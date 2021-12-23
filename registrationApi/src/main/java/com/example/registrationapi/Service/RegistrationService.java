package com.example.registrationapi.Service;

import com.example.registrationapi.Exception.BusinessException;
import com.example.registrationapi.Model.Entity.Registration;
import com.example.registrationapi.Model.Request.RegistrationRequest;
import com.example.registrationapi.Model.dto.RegistrationDTO;
import com.example.registrationapi.Repository.RegistrationRepository;
import com.example.registrationapi.client.library.LibraryApiService;
import com.example.registrationapi.client.library.model.dto.BookDto;
import com.example.registrationapi.client.user.UserApiService;
import com.example.registrationapi.client.user.model.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.example.registrationapi.Model.Mapper.RegistrationMapper.REGISTRATION_MAPPER;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    private final RegistrationRepository registrationRepository;
    private final UserApiService userApiService;
    private final LibraryApiService libraryApiService;

    public RegistrationDTO register(RegistrationRequest registrationRequest) throws JsonProcessingException {
        validateUser(registrationRequest);
        validateBook(registrationRequest);

        Registration registration = REGISTRATION_MAPPER.toRegistration(registrationRequest);
        Registration savedRegistration = registrationRepository.save(registration);

        libraryApiService.updateAvailability(registrationRequest.getBookId(),false);
        userApiService.implementCount(registrationRequest.getUserId());


        return REGISTRATION_MAPPER.toRegistrationDto(savedRegistration);
    }

    private void validateBook(RegistrationRequest registrationRequest) {
        BookDto bookDTO =libraryApiService.getBookDto(registrationRequest.getBookId());
        if(!bookDTO.isAvailable()){ //false ve true iki tane case var.
            throw new BusinessException("Book already registered!");
        }
    }
    private void validateUser(RegistrationRequest registrationRequest) {
        UserDto userDTO = userApiService.getUserDto(registrationRequest.getUserId());

        if(userDTO.getRegisteredBookCount() >= 3){ //0 2 3 4 10
            throw new BusinessException("User registration limit is reached!!");
        }
    }
}

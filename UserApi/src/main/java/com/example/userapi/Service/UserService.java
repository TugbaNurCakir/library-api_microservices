package com.example.userapi.Service;

import com.example.userapi.Model.Entity.User;
import com.example.userapi.Model.Entity.dto.UserDto;
import com.example.userapi.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import static com.example.userapi.Model.Entity.Mapper.UserMapper.USER_MAPPER;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto getUserDto(int id){
        User user = getUser(id);
        return USER_MAPPER.toUserDto(user);
    }

    private User getUser(int id) {
        return userRepository.findById(id).orElseThrow(()->new NotFoundException("User not found."));
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void incrementRegistrationsCount(int id){
        userRepository.incrementRegisteredBookCount(id);
    }
}

package com.example.registrationapi.Model.Mapper;

import com.example.registrationapi.Model.Entity.Registration;
import com.example.registrationapi.Model.Request.RegistrationRequest;
import com.example.registrationapi.Model.dto.RegistrationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.ZonedDateTime;
import java.util.Date;

@Mapper(componentModel = "spring")
public interface RegistrationMapper {
    RegistrationMapper REGISTRATION_MAPPER = Mappers.getMapper(RegistrationMapper.class);

    @Mapping(source = "registrationDay", target = "expiryDate", qualifiedByName ="expiryDateConversion")
    Registration toRegistration(RegistrationRequest registrationRequest);
    RegistrationDTO toRegistrationDto(Registration registration);

    @Named("expiryDateConversion")
    static Date expiryDateConversion(int registrationDay){
        return Date.from(ZonedDateTime.now().plusDays(registrationDay).toInstant());
    }
}

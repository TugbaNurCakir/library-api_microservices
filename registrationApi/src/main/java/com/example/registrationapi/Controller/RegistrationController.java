package com.example.registrationapi.Controller;

import com.example.registrationapi.Model.Request.RegistrationRequest;
import com.example.registrationapi.Model.dto.RegistrationDTO;
import com.example.registrationapi.Service.RegistrationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("registrations")
@RequiredArgsConstructor

public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public  RegistrationDTO registrationDTO(@Valid @RequestBody RegistrationRequest registrationRequest) throws JsonProcessingException {
        return registrationService.register(registrationRequest);
    }
}

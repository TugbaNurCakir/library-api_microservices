package com.example.registrationapi.Model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {
    private Integer id;
    private Integer userId;
    private Integer bookId;
    private Date expiryDate;
}

package com.example.registrationapi.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RegistrationRequest {
    @NotNull
    private Integer userId;
    @NotNull
    private Integer bookId;
    @NotNull
    @Min(1)
    private Integer registrationDay;
}

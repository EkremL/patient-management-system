package com.pm.patientservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientUpdateRequestDto {
    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "Surname is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @JsonProperty("sur_name")
    private String surName;

    @NotBlank(message = "Gender is required")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    @JsonProperty("gender")
    private String gender;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "Date of birth is required")
    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @NotBlank(message = "Registered date is required")
    @JsonProperty("registered_date")
    private String registeredDate;
}

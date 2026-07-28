package com.pm.patientservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponseDto {
    private String id;
    private String name;
    @JsonProperty("sur_name")
    private String surName;
    private String gender;
    private String email;
    private String address;
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
}

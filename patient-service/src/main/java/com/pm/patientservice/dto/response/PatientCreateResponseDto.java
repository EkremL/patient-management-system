package com.pm.patientservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientCreateResponseDto {
    private UUID id;
    private String name;
    @JsonProperty("sur_name")
    private String surName;
    private String message;
}

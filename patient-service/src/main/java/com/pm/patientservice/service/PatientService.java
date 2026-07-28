package com.pm.patientservice.service;

import com.pm.patientservice.dto.request.PatientCreateRequestDto;
import com.pm.patientservice.dto.response.PatientCreateResponseDto;
import com.pm.patientservice.dto.response.PatientResponseDto;

import java.util.List;

public interface PatientService {
    List<PatientResponseDto> getPatients();

    PatientCreateResponseDto createPatient(PatientCreateRequestDto patientCreateRequestDto);
}

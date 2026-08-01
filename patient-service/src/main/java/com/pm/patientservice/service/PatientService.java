package com.pm.patientservice.service;

import com.pm.patientservice.dto.request.PatientCreateRequestDto;
import com.pm.patientservice.dto.request.PatientUpdateRequestDto;
import com.pm.patientservice.dto.response.PatientCreateResponseDto;
import com.pm.patientservice.dto.response.PatientResponseDto;
import com.pm.patientservice.dto.response.PatientUpdateResponseDto;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<PatientResponseDto> getPatients();

    PatientCreateResponseDto createPatient(PatientCreateRequestDto patientCreateRequestDto);

    PatientUpdateResponseDto updatePatient(UUID id, PatientUpdateRequestDto patientUpdateRequestDto);

    void deletePatient(UUID id);
}

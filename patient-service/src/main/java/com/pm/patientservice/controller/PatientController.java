package com.pm.patientservice.controller;

import com.pm.patientservice.dto.request.PatientCreateRequestDto;
import com.pm.patientservice.dto.request.PatientUpdateRequestDto;
import com.pm.patientservice.dto.response.PatientCreateResponseDto;
import com.pm.patientservice.dto.response.PatientResponseDto;
import com.pm.patientservice.dto.response.PatientUpdateResponseDto;
import com.pm.patientservice.dto.validators.CreatePatientValidatorGroup;
import com.pm.patientservice.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<PatientResponseDto>> getAllPatients() {
        var response = patientService.getPatients();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<PatientCreateResponseDto> createPatient(@Validated({Default.class, CreatePatientValidatorGroup.class}) @RequestBody PatientCreateRequestDto patientCreateRequestDto) {
        return ResponseEntity.ok().body(patientService.createPatient(patientCreateRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientUpdateResponseDto> updatePatient(@PathVariable UUID id, @Valid @RequestBody PatientUpdateRequestDto patientUpdateRequestDto) {
        return ResponseEntity.ok().body(patientService.updatePatient(id,patientUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}

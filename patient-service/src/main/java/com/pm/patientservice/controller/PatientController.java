package com.pm.patientservice.controller;

import com.pm.patientservice.dto.request.PatientCreateRequestDto;
import com.pm.patientservice.dto.response.PatientCreateResponseDto;
import com.pm.patientservice.dto.response.PatientResponseDto;
import com.pm.patientservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PatientCreateResponseDto> createPatient(@Valid @RequestBody PatientCreateRequestDto patientCreateRequestDto){
        return  ResponseEntity.ok().body(patientService.createPatient(patientCreateRequestDto));
    }

}

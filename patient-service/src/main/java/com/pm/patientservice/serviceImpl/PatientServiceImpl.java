package com.pm.patientservice.serviceImpl;

import com.pm.patientservice.dto.request.PatientCreateRequestDto;
import com.pm.patientservice.dto.request.PatientUpdateRequestDto;
import com.pm.patientservice.dto.response.PatientCreateResponseDto;
import com.pm.patientservice.dto.response.PatientResponseDto;
import com.pm.patientservice.dto.response.PatientUpdateResponseDto;
import com.pm.patientservice.entities.Patient;
import com.pm.patientservice.exception.ConflictException;
import com.pm.patientservice.exception.NotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.repository.PatientRepository;
import com.pm.patientservice.service.PatientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public List<PatientResponseDto> getPatients() {
        return patientMapper.toDtoList(patientRepository.findAll());
    }

    @Override
    @Transactional
    public PatientCreateResponseDto createPatient(PatientCreateRequestDto patientCreateRequestDto){
        if(patientRepository.existsByEmail(patientCreateRequestDto.getEmail()))
            throw new ConflictException("A patient with this email already exists! " + patientCreateRequestDto.getEmail());

        var patient = patientMapper.toEntity(patientCreateRequestDto);
        var saved = patientRepository.save(patient);

        return patientMapper.toCreateResponseDto(saved);
    }

    @Override
    @Transactional
    public PatientUpdateResponseDto updatePatient(UUID id,PatientUpdateRequestDto patientUpdateRequestDto){
        var patient = patientRepository.findById(id).orElseThrow(()-> new NotFoundException("Patient not found!"));

        if(patientRepository.existsByEmailAndIdNot(patientUpdateRequestDto.getEmail(), id))
            throw new ConflictException("A patient with this email already exists! " + patientUpdateRequestDto.getEmail());

        patientMapper.updateEntity(patientUpdateRequestDto,patient);

        var updated = patientRepository.save(patient);

        return patientMapper.toUpdateResponseDto(updated);

    }

    @Override
    @Transactional
    public void deletePatient(UUID id) {
        patientRepository.deleteById(id);
    }
}

package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.request.PatientCreateRequestDto;
import com.pm.patientservice.dto.request.PatientUpdateRequestDto;
import com.pm.patientservice.dto.response.PatientCreateResponseDto;
import com.pm.patientservice.dto.response.PatientResponseDto;
import com.pm.patientservice.dto.response.PatientUpdateResponseDto;
import com.pm.patientservice.entities.Patient;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PatientMapper {

    @Mapping(
            target = "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd"
    )
    PatientResponseDto toDto(Patient patient);

    List<PatientResponseDto> toDtoList(List<Patient> patients);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "registeredDate", source = "registeredDate", dateFormat = "yyyy-MM-dd")
    Patient toEntity(PatientCreateRequestDto patientCreateRequestDto);

    @Mapping(target = "message", constant = "Patient created successfully!")
    PatientCreateResponseDto toCreateResponseDto(Patient patient);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateOfBirth", source = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "registeredDate", source = "registeredDate", dateFormat = "yyyy-MM-dd")
    void updateEntity(PatientUpdateRequestDto requestDto, @MappingTarget Patient patient);

    @Mapping(target = "message", constant = "Patient updated successfully!")
    PatientUpdateResponseDto toUpdateResponseDto(Patient patient);
}


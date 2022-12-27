package com.ozlemaglar.petClinic.service;

import com.ozlemaglar.petClinic.dto.OwnerDto;
import com.ozlemaglar.petClinic.entity.Owner;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IOwnerService {

    //ModelMapper => Entity/Dto
    public OwnerDto entityToDto(Owner employeeEntity);
    public Owner dtoToEntity(OwnerDto employeeDto);

    public ResponseEntity<OwnerDto> createOwner(OwnerDto ownerDto);

    public List<OwnerDto> getAllOwner();

    public OwnerDto getOwnerById(long id);

    public OwnerDto updateOwner(long id, OwnerDto ownerDto);

    public Map<String, Boolean> deleteOwner(Long id);
}

package com.ozlemaglar.petClinic.sevice;

import com.ozlemaglar.petClinic.model.dto.OwnerDto;
import com.ozlemaglar.petClinic.model.entity.Owner;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

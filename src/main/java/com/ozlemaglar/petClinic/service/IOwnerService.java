package com.ozlemaglar.petClinic.service;

import com.ozlemaglar.petClinic.dto.OwnerDto;
import com.ozlemaglar.petClinic.entity.Owner;
import com.ozlemaglar.petClinic.result.Result;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IOwnerService {

    //ModelMapper => Entity/Dto
    public OwnerDto entityToDto(Owner employeeEntity);
    public Owner dtoToEntity(OwnerDto employeeDto);

    public ResponseEntity<OwnerDto> createOwner(OwnerDto ownerDto);

    public List<OwnerDto> getAllOwner();

    public OwnerDto findOwner(String findBy);

    public OwnerDto updateOwner(long id, OwnerDto ownerDto);

    public Result deleteOwner(long id);
}

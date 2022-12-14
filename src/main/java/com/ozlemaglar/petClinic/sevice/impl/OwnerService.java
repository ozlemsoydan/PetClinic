package com.ozlemaglar.petClinic.sevice.impl;

import com.ozlemaglar.petClinic.model.dto.OwnerDto;
import com.ozlemaglar.petClinic.model.entity.Owner;
import com.ozlemaglar.petClinic.repo.IOwnerRepo;
import com.ozlemaglar.petClinic.sevice.IOwnerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.*;

@Service
public class OwnerService implements IOwnerService {

    @Autowired
    private IOwnerRepo repo;
    @Autowired
    private ModelMapper modelMapper;


    //Model Mapper
    //DTO
    @Override
    public OwnerDto entityToDto(Owner owner) {
        OwnerDto ownerDto = modelMapper.map(owner, OwnerDto.class);
        return ownerDto;
    }

    //Entity
    @Override
    public Owner dtoToEntity(OwnerDto ownerDto) {
        Owner owner = modelMapper.map(ownerDto, Owner.class);
        return owner;
    }

    @Override
    public ResponseEntity<OwnerDto> createOwner(OwnerDto ownerDto) {
        Owner owner = dtoToEntity(ownerDto);
        owner.setCreatedDate(new Date());
        // owner.setCreateBy();
        repo.save(owner);
        return ResponseEntity.ok(ownerDto) ;
    }

    @Override
    public List<OwnerDto> getAllOwner() {

        //entity (FindAll)
        Iterable<Owner> ownerList = repo.findAll();

        //dtolist
        List<OwnerDto> ownerDtoList = new ArrayList<>();
        for (Owner temp : ownerList) {
            OwnerDto ownerDto = entityToDto(temp);
            ownerDtoList.add(ownerDto);
        }
        return ownerDtoList;

    }

    @Override
    public OwnerDto getOwnerById(long id) {
        Optional<Owner> owner = repo.findById(id);

        OwnerDto ownerDto = entityToDto(owner.get());
        return ownerDto;
    }


    @Override
    public OwnerDto updateOwner(long id, OwnerDto ownerDto) {

        Optional<Owner> optionalOwner = repo.findById(id);

        if (optionalOwner.isPresent()) {
            Owner owner = dtoToEntity(ownerDto);
            owner.setCreatedDate(owner.getCreatedDate());
            owner.setUpdatedDate(new Date());

            repo.save(owner);

        } else {
            throw new NotFoundException("id not found");
        }

        return ownerDto;
    }

    @Override
    public Map<String, Boolean> deleteOwner(Long id) {
        //find Entity
        Optional<Owner> owner=repo.findById(id);

        //Object delete
        repo.delete(owner.get());
        Map<String, Boolean> response=new HashMap<>();
        response.put("silindi",Boolean.TRUE);
        return response;
    }
}

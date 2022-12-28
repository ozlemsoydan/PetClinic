package com.ozlemaglar.petClinic.service;

import com.ozlemaglar.petClinic.dto.OwnerDto;
import com.ozlemaglar.petClinic.entity.Owner;
import com.ozlemaglar.petClinic.entity.Pet;
import com.ozlemaglar.petClinic.entity.Type;
import com.ozlemaglar.petClinic.repository.OwnerRepository;
import com.ozlemaglar.petClinic.result.Result;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class OwnerService implements IOwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

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
//        owner.setCreatedDate(new Date());
        // owner.setCreateBy();
        ownerRepository.save(owner);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Override
    public List<OwnerDto> getAllOwner() {

        //entity (FindAll)
        Iterable<Owner> ownerList = ownerRepository.findAll();

        //dtolist
        List<OwnerDto> ownerDtoList = new ArrayList<>();
        for (Owner temp : ownerList) {
            OwnerDto ownerDto = entityToDto(temp);
            ownerDtoList.add(ownerDto);
        }
        return ownerDtoList;
    }

    @Override
    public OwnerDto findOwner(String findBy) {
        OwnerDto ownerDto = new OwnerDto();

        //findById
        if (findBy == ownerDto.getId().toString()) {
            Optional<Owner> owner1 = (ownerRepository.findById(ownerDto.getId()));
            Owner owner = dtoToEntity(ownerDto);
            return ownerDto;
        }
        //findBySurname
        else if (findBy == ownerDto.getSurname()) {
            Page<Owner> owner1 = ownerRepository.findBySurname(ownerDto.getSurname());
            Owner owner = dtoToEntity(ownerDto);
            return ownerDto;
        }
        //findByPetTypes
        else if (findBy == ownerDto.getPets().toString()) {
            List<Type> pType = ownerRepository.findPetTypes();
            return (OwnerDto) pType;
        } else {
            throw new EntityNotFoundException("Hatalı sorgu");
        }

    }


    @Override
    public OwnerDto updateOwner(long id, OwnerDto ownerDto) {

        Optional<Owner> optionalOwner = ownerRepository.findById(id);

        if (optionalOwner.isPresent()) {
            Owner owner = dtoToEntity(ownerDto);
//            owner.setCreatedDate(owner.getCreatedDate());
//            owner.setUpdatedDate(new Date());

            ownerRepository.save(owner);

        } else {
//            throw new NotFoundException("id not found");
        }

        return ownerDto;
    }

    @Override
    public Result deleteOwner(long id) {

        Result data;

        Optional<Owner> owner = ownerRepository.findById(id);


        if (!owner.isPresent()) {
            data = new Result(null, "Not found", HttpStatus.NOT_FOUND.value());

        } else {

            try {
                ownerRepository.delete(owner.get());
                data = new Result(null, "deleted owner", HttpStatus.OK.value());
            } catch (Exception e) {
                data = new Result(null, e.getMessage(), HttpStatus.FAILED_DEPENDENCY.value());
            }
        }
        return data;
    }
}

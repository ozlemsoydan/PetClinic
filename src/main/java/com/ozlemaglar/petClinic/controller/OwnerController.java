package com.ozlemaglar.petClinic.controller;


import com.ozlemaglar.petClinic.dto.OwnerDto;
import com.ozlemaglar.petClinic.repository.OwnerRepository;
import com.ozlemaglar.petClinic.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/owner")
@CrossOrigin("http://localhost:3000")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private IOwnerService ownerService;



    @PostMapping("/")
    public List<OwnerDto> getALlList(OwnerDto ownerDto) {
        return ownerService.getAllOwner();
    }


    @PostMapping("/add")
    public ResponseEntity<OwnerDto> createOwner(@RequestBody OwnerDto ownerDto) {
        return ownerService.createOwner(ownerDto);
    }

//    @GetMapping("/find/{id}")
//    public OwnerDto findOwner(@PathVariable long id, OwnerDto ownerDto) {
//
//        //findBySurname
//
//        //findById
//
//        //findByPetType
//
//        return null;
//    }

//    public OwnerDto updateOwner() {
//        return null;
//    }
//
//    public OwnerDto deleteOwner(long id) {
//        return null;
//    }


}

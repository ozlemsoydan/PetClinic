package com.ozlemaglar.petClinic.model.dto;

import com.ozlemaglar.petClinic.model.entity.Pet;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OwnerDto {

    private String name;
    private String surname;
    private int phoneNumber;
    private String address;
    private List<Pet> pets = new ArrayList<>();
    private String city;
}

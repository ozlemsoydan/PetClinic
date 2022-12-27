package com.ozlemaglar.petClinic.dto;

import com.ozlemaglar.petClinic.entity.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OwnerDto {

    private Long id;
    private String name;
    private String surname;
    private int phoneNumber;
    private String address;
    private List<Pet> pets = new ArrayList<>();
    private String city;
}

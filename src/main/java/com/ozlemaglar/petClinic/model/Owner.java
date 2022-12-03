package com.ozlemaglar.petClinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "owner")
public class Owner extends BaseEntity {

    @Column(name = "name")
    @NotNull
    private String name;


    @Column(name = "surname")
    @NotNull
    private String surname;

    @Column(name = "phoneNumber")
    @NotNull
    private int phoneNumber;

    @Column(name = "address")
    private String address;


    @NotNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private List<Pet> pets = new ArrayList<>();

    @Column(name = "city")
    private String city;


}

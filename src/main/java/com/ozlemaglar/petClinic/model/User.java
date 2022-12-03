package com.ozlemaglar.petClinic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "user")


public class User extends BaseEntity{

    @Column(name = "userName")
    @NotNull
    private String userName;

    @Column(name = "password")
    @NotNull
    private char password;

    @Column(name = "email")
    @NotNull
    private  String email;




}

package com.ozlemaglar.petClinic.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Getter
@Setter
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdDate", updatable = false)
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

}

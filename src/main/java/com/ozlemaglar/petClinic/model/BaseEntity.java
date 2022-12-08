package com.ozlemaglar.petClinic.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "createdDate", updatable = false)
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;

}

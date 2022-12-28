package com.ozlemaglar.petClinic.repository;


import com.ozlemaglar.petClinic.entity.Owner;
import com.ozlemaglar.petClinic.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {


    @Query("SELECT o FROM Owner o")
    @Transactional(readOnly = true)
    Page<Owner> findAll(Pageable pageable);

    @Query("SELECT o FROM Owner o left join fetch o.pets WHERE o.id =:id")
    @Transactional(readOnly = true)
    Owner findById(@Param("id") Integer id);

    @Query("SELECT DISTINCT o FROM Owner o left join o.pets WHERE o.surname LIKE :surname% ")
    @Transactional(readOnly = true)
    Page<Owner> findBySurname(@Param("surname") String Surname);

    @Query("SELECT ptype FROM Type ptype ORDER BY ptype.name")
    @Transactional(readOnly = true)
    List<Type> findPetTypes();
}

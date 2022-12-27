package com.ozlemaglar.petClinic.repository;

import com.ozlemaglar.petClinic.dto.OwnerDto;
import com.ozlemaglar.petClinic.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {


//    @Query("SELECT o FROM Owner o")
//    @Transactional(readOnly = true)
//    Page<Owner> findAll(Pageable pageable);
//
//    @Query("SELECT o FROM Owner o left join fetch owner.pets WHERE owner.id =:id")
//    @Transactional(readOnly = true)
//    Owner findById(@Param("id") Integer id);
//
//    @Query("SELECT DISTINCT o FROM Owner o left join  owner.pets WHERE owner.surname LIKE :surname% ")
//    @Transactional(readOnly = true)
//    Page<Owner> findBySurname(@Param("surname") String Surname, Pageable pageable);
//
//    @Query("SELECT ptype FROM PetType ptype ORDER BY ptype.name")
//    @Transactional(readOnly = true)
//    List<PetType> findPetTypes();
}

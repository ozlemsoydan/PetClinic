package com.ozlemaglar.petClinic.repo;

import com.ozlemaglar.petClinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOwnerRepo extends JpaRepository<Owner,Long> {


}

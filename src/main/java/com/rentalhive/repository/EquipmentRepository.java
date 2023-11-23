package com.rentalhive.repository;

import com.rentalhive.domain.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipement, Long> {
    Equipement findByName(String lastname);

}

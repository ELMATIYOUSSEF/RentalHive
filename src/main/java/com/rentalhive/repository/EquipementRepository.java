package com.rentalhive.repository;

import com.rentalhive.domain.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
    //public Equipement findById(Long id);

}

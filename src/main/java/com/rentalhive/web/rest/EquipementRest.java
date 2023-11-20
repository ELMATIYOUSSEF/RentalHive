package com.rentalhive.web.rest;

import com.rentalhive.domain.Equipement;
import com.rentalhive.service.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EquipementRest {
    private final EquipementService equipementService;

    @Autowired
    public EquipementRest(EquipementService equipementService) {
        this.equipementService = equipementService;
    }

    @GetMapping
    public ResponseEntity<List<Equipement>> getAllEquipements() {
        List<Equipement> equipements = equipementService.getAllEquipements();
        return new ResponseEntity<>(equipements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipement> getEquipementById(@PathVariable Long id) {
        Equipement equipement = equipementService.getEquipementById(id);
        if (equipement != null) {
            return new ResponseEntity<>(equipement, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Equipement> createEquipement(@RequestBody Equipement equipement) {
        Equipement createdEquipement = equipementService.createEquipement(equipement);
        return new ResponseEntity<>(createdEquipement, HttpStatus.CREATED);
    }









}

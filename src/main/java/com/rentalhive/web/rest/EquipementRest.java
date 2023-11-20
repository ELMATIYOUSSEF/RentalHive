package com.rentalhive.web.rest;

import com.rentalhive.domains.Equipment;
import com.rentalhive.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EquipementRest {
    private final EquipmentService equipmentService;

    @Autowired
    public EquipementRest(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipements() {
        List<Equipment> equipment = equipmentService.getAllEquipements();
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipementById(@PathVariable Long id) {
        Equipment equipment = equipmentService.getEquipementById(id);
        if (equipment != null) {
            return new ResponseEntity<>(equipment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<Equipment> createEquipement(@RequestBody Equipment equipment) {
        Equipment createdEquipment = equipmentService.createEquipement(equipment);
        return new ResponseEntity<>(createdEquipment, HttpStatus.CREATED);
    }

    @DeleteMapping("/equipment/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id){
        equipmentService.deleteEquipement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }









}

package com.rentalhive.controllers;

import com.rentalhive.domains.Equipment;
import com.rentalhive.services.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class equipmentController {
    @Autowired
    private EquipmentService equipmentService;

    /*@PostMapping("/addEquipment")
    public ResponseEntity<Map<String, Object>> addEquipment(@RequestBody @Valid Equipment equipment, BindingResult bindingResult){
        Map<String, Object> response = new HashMap<>();
        if(bindingResult.hasErrors()){
            response.put("status","Error");
            response.put("message","Validation Error");
            Map<String, String> errors = new HashMap<>();
            for (ObjectError error: bindingResult.getAllErrors()) {
                errors.put(error.getObjectName(), error.getDefaultMessage());
            }
            response.put("errors",422);
            return ResponseEntity.badRequest().body(response);
        }
        Equipment addedEquipment = equipmentService.create(equipment);
        response.put("status","success");
        response.put("message","Equipment added successfully");
        response.put("Equipment",addedEquipment);
        return ResponseEntity.ok(response);
    }*/

    @PutMapping("/updateEquipment")
    public ResponseEntity<Map<String, Object>> updateEquipment(@RequestBody @Valid Equipment equipment, BindingResult bindingResult) {
        Map<String, Object> response = new HashMap<>();
        if (bindingResult.hasErrors()) {
            response.put("status", "Error");
            response.put("message", "Validation Error");
            Map<String, String> errors = new HashMap<>();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.put(error.getObjectName(), error.getDefaultMessage());
            }
            response.put("errors", errors);
            return ResponseEntity.badRequest().body(response);
        }
        Equipment updatedEquipment = equipmentService.update(equipment);

        if (updatedEquipment == null) {
            response.put("status", "Error");
            response.put("message", "Equipment not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        response.put("status", "Success");
        response.put("message", "Equipment updated successfully");
        response.put("equipment", updatedEquipment);

        return ResponseEntity.ok(response);
    }
}

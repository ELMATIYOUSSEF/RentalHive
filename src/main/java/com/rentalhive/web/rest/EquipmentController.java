package com.rentalhive.web.rest;

import com.rentalhive.domain.Equipment;
import com.rentalhive.service.EquipementService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/equipments")
public class EquipmentController {

    private final EquipementService equipementService;
    private Logger log = LoggerFactory.getLogger(EquipmentController.class);
    @PostMapping("/save")
    public ResponseEntity<?> saveEquipement(@RequestBody Equipment equipment)  {
        try {
            Equipment equipment1 = equipementService.Save(equipment);
            log.info("Equipment Saved Successfully");
            return ResponseEntity.ok().body(equipment1);
        } catch (Exception e) {
            log.error("Registration failed");
          return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchByName(@RequestParam String name) {
        try {
            Equipment result = equipementService.searchByName(name);
            if (result != null) {
                log.info("result of Search : " + result);
                return ResponseEntity.ok(result);
            } else {
                log.info("No Equipment with this name");
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            log.error("Search failed");
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Equipment>> getAllEquipements() {
        List<Equipment> equipment = equipementService.getAllEquipements();
        return new ResponseEntity<>(equipment, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipementById(@PathVariable Long id) {
        Equipment equipment = equipementService.getEquipementById(id);
        if (equipment != null) {
            return new ResponseEntity<>(equipment, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/updateEquipment")
    public ResponseEntity<Map<String, Object>> updateEquipment(@RequestBody @Valid Equipment equipment, BindingResult bindingResult) throws Exception {
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
        Equipment updatedEquipment = equipementService.update(equipment);

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

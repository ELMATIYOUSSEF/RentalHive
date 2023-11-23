package com.rentalhive.web.rest;

import com.rentalhive.DTO.EquipmentDto;
import com.rentalhive.DTO.EquipmentItemsDto;
import com.rentalhive.domain.Equipment;
import com.rentalhive.domain.EquipmentItem;
import com.rentalhive.domain.enums.StatusEquipmentItems;
import com.rentalhive.service.EquipementService;
import com.rentalhive.service.EquipmentItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/equipmentsType")
public class EquipmentItemsController {
    private final EquipmentItemsService equipmentItemsService;
    private final EquipementService equipementService ;

    @PostMapping("/save")
    public ResponseEntity<?> saveEquipementType(@RequestBody EquipmentItemsDto equipmentItemsDto)  {
        try {
           Equipment equipment =  equipementService.searchByName(equipmentItemsDto.getEquipementname());
            EquipmentItem equipmentItem = EquipmentItem.builder()
                    .equipment(equipment)
                    .Matricul(equipmentItemsDto.getMatricul())
                    .statusEquipementType(StatusEquipmentItems.inStock)
                    .build();
            EquipmentItem result = equipmentItemsService.save(equipmentItem);
            equipementService.upDate(equipment);
            EquipmentDto equipementReturn = ResponseDate(result);
            return ResponseEntity.ok().body(equipementReturn);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchByMatricul(@RequestParam String matricul) {
        try {
            EquipmentItem result = equipmentItemsService.findByMatricul(matricul);
            EquipmentDto equipementReturn = ResponseDate(result);
            if (equipementReturn != null) {
                return ResponseEntity.ok(equipementReturn);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    public EquipmentDto ResponseDate(EquipmentItem result){
        return EquipmentDto.builder()
                .name(result.getEquipment().getName())
                .quantite(result.getEquipment().getQuantite())
                .cout_Location(result.getEquipment().getCout_Location())
                .Matricul(result.getMatricul())
                .statusEquipementType(result.getStatusEquipementType())
                .build();
    }
}

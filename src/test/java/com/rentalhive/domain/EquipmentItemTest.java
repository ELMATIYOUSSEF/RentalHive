package com.rentalhive.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentItemTest {
    private EquipmentItem equipmentItem;
    private Equipment equipment;

    @BeforeEach
    void setUp() {
        equipment = Equipment.builder()
                .id(1L)
                .name("Test Equipment")
                .quantite(10)
                .cout_Location(50.0)
                .equipmentItems(new ArrayList<>())
                .build();

        equipmentItem = EquipmentItem.builder()
                .id(1L)
                .equipment(equipment)
                .Matricul("Test Matricul")
                .build();
    }

    @Test
    void testEquipementTypeCreation() {
        assertNotNull(equipmentItem);
        assertEquals(1L, equipmentItem.getId());
        assertEquals(equipment, equipmentItem.getEquipment());
        assertEquals("Test Matricul", equipmentItem.getMatricul());
    }

    @Test
    void testEquipementTypeIdSetter() {
        equipmentItem.setId(2L);
        assertEquals(2L, equipmentItem.getId());
    }

    @Test
    void testEquipementTypeEquipementSetter() {
        Equipment newEquipment = Equipment.builder().id(2L).name("New Equipment").build();
        equipmentItem.setEquipment(newEquipment);
        assertEquals(newEquipment, equipmentItem.getEquipment());
    }

    @Test
    void testEquipementTypeMatriculSetter() {
        equipmentItem.setMatricul("Updated Matricul");
        assertEquals("Updated Matricul", equipmentItem.getMatricul());
    }

//    @Test
//    void testSearchEquipmentInStock() {
//        // Assume you have a service or class that manages the equipment stock
//        EquipementServiceImpl equipementService = new EquipementServiceImpl();
//
//        // Assume you have a list of equipment in the stock
//        Equipment equipment1 = Equipment.builder().id(1L).name("Equipment1").quantite(5).cout_Location(50.0).build();
//        Equipment equipment2 = Equipment.builder().id(2L).name("Equipment2").quantite(10).cout_Location(75.0).build();
//        Equipment equipment3 = Equipment.builder().id(3L).name("Equipment3").quantite(0).cout_Location(100.0).build();
//
//        equipementService.addToStock(equipment1);
//        equipementService.addToStock(equipment2);
//        equipementService.addToStock(equipment3);
//
//        // Test searching for an existing equipment
//       Equipment result1 = equipementService.searchEquipment("Equipment1");
//        assertNotNull(result1);
//        assertEquals("Equipment1", result1.getName());
//        assertEquals(5, result1.getAvailability());
//        assertEquals(50.0, result1.getRentalCost());
//
//        // Test searching for equipment with zero availability
//        Equipment result3 = equipementService.searchEquipment("Equipment3");
//        assertNotNull(result3);
//        assertEquals("Equipment3", result3.getName());
//        assertEquals(0, result3.getAvailability());
//        assertEquals(100.0, result3.getRentalCost());
//
//        // Test searching for non-existing equipment
//        assertThrows(Exception.class, () -> {
//            Equipment result4 = equipementService.searchEquipment("Equipment4");
//        });
//    }
}
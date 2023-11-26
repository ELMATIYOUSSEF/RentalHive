package com.rentalhive.web.rest;

import com.rentalhive.DTO.DevisDTO;
import com.rentalhive.service.impl.DevisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/devis")
public class DevisController {
    @Autowired
    private DevisServiceImpl devisService;

    @PostMapping("/add")
    public ResponseEntity<Map<String,Object>> addDevis (@Valid @RequestBody DevisDTO devisDTO){
        return null;
    }
}

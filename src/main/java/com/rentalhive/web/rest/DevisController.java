package com.rentalhive.web.rest;

import com.itextpdf.text.DocumentException;
import com.rentalhive.DTO.DevisDTO;
import com.rentalhive.DTO.DevisInfoDTO;
import com.rentalhive.domain.Devis;
import com.rentalhive.domain.EquipmentItemsReservation;
import com.rentalhive.files.FileGenerator;
import com.rentalhive.service.impl.DevisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/devis")
public class DevisController {
    @Autowired
    private DevisServiceImpl devisService;

    @PostMapping("/add")
    //public ResponseEntity<Map<String,Object>> addDevis (@Valid @RequestBody DevisDTO devisDTO, BindingResult bindingResult) throws DocumentException, IOException {
    public ResponseEntity<FileSystemResource> addDevis (@Valid @RequestBody DevisDTO devisDTO, BindingResult bindingResult) throws DocumentException, IOException {
        Map<String, Object> response = new HashMap<>();
        if (bindingResult.hasErrors()){
            response.put("status","Error");
            response.put("message","ValidationError");
            Map<String , String> errors = new HashMap<>();
            for (ObjectError error : bindingResult.getAllErrors()){
                errors.put(error.getObjectName(),error.getDefaultMessage());
            }
            response.put("errors",errors);
            //return ResponseEntity.badRequest().body(response);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Devis devis = new Devis();
        devis.setStatus(devisDTO.DTOtoDevis().getStatus());
        devis.setTerms(devisDTO.DTOtoDevis().getTerms());
        devis.setEquipmentItemsReservations(devisDTO.DTOtoDevis().getEquipmentItemsReservations());


        List<DevisInfoDTO> test = new ArrayList<>();
        List<EquipmentItemsReservation> equipmentItemsReservations = devis.getEquipmentItemsReservations();
        for (EquipmentItemsReservation reservation : equipmentItemsReservations){
            Long idR = reservation.getId();
            DevisInfoDTO devisInfoDTO = devisService.getEquipmentInfo(idR);
            test.add(devisInfoDTO);
        }
        Devis devis1 = devisService.addDevis(devis);
        response.put("status","Success");
        response.put("message","DevisAddedSuccessfully");
        response.put("Terms", devis1.devisToDTO().getTerms());
        response.put("Status", devis1.devisToDTO().getStatus());

        //response.put("Equipment",test);
        for (int i = 0; i < test.size(); i++) {
            response.put("Name", test.get(i).getName());
            response.put("Matricul", test.get(i).getMatricul());
            response.put("Cout_Location", test.get(i).getCout_Location());
            response.put("Email", test.get(i).getEmail());
            response.put("Date Reservation", test.get(i).getDateReservation());
            response.put("Date retour", test.get(i).getDateRetoure());
        }


        String path = "com/rentalhive/files/";
        String fname = "devis.pdf";
        String pfname = path + fname;
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        ByteArrayOutputStream devisFile = FileGenerator.fileGenerator(response, "Devis :");
        try (FileOutputStream fos = new FileOutputStream(pfname)) {
            fos.write(devisFile.toByteArray());
        }
        FileSystemResource fileResource = new FileSystemResource(new File(pfname));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fname);
        headers.setContentLength(fileResource.contentLength());

        return new ResponseEntity<>(fileResource, headers, HttpStatus.OK);

        //return ResponseEntity.ok(response);
    }
}

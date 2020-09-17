package com.padepokan79.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padepokan79.exceptions.ResourceNotFoundException;
import com.padepokan79.models.Divisions;
import com.padepokan79.models.dtos.DivisionsDto;
import com.padepokan79.repositories.DivisionsRepository;

@RestController
@RequestMapping("/divisions")
public class DivisionsController {
	
	@Autowired
	DivisionsRepository divisionsRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
    @GetMapping("/{id}")
    public HashMap<String, Object> getDivisionsEntity(@PathVariable(value = "id") Long paramId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        Divisions divisionsEntity = divisionsRepository.findById(paramId).orElseThrow(() -> new ResourceNotFoundException("Divisions", "id",paramId));
        
        DivisionsDto divisionsDto = modelMapper.map(divisionsEntity, DivisionsDto.class);
        
        result.put("Message", "Berhasil menampilkan Divisions");
        result.put("data", divisionsDto);
        
        return result;
    }
    
    @GetMapping
    public HashMap<String, Object> getAllDivisions(){
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        List<Divisions> listAllDivisions = divisionsRepository.findAll();
        
        List<DivisionsDto> listAllDivisionsDto = new ArrayList<DivisionsDto>();       
        
        for (Divisions divisionsEntity : listAllDivisions ) {
            
            DivisionsDto divisionsDto = modelMapper.map(divisionsEntity, DivisionsDto.class);
            
            listAllDivisionsDto.add(divisionsDto);
        }
        
        result.put("Message", "Berhasil menampilkan seluruh data Divisions");
        result.put("Data", listAllDivisionsDto);
        
        return result;
    }
}
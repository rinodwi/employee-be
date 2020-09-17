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
import com.padepokan79.models.Positions;
import com.padepokan79.models.dtos.PositionsDto;
import com.padepokan79.repositories.PositionsRepository;

@RestController
@RequestMapping("/positions")
public class PositionsController {
	
	@Autowired
	PositionsRepository positionsRepository;
	
	ModelMapper modelMapper = new ModelMapper();
    @GetMapping("/{id}")
    public HashMap<String, Object> getPositionsEntity(@PathVariable(value = "id") Long paramId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        Positions positionsEntity = positionsRepository.findById(paramId).orElseThrow(() -> new ResourceNotFoundException("Positions", "IdPositions",paramId));
        
        PositionsDto positionsDto = modelMapper.map(positionsEntity, PositionsDto.class);
        
        result.put("Message", "Berhasil menampilkan Positions");
        result.put("data", positionsDto);
        
        return result;
    }
    
    @GetMapping
    public HashMap<String, Object> getAllPositions(){
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        List<Positions> listAllPositions = positionsRepository.findAll();
        
        List<PositionsDto> listAllPositionsDto = new ArrayList<PositionsDto>();       
        
        for (Positions positionsEntity : listAllPositions ) {
            
            PositionsDto positionsDto = modelMapper.map(positionsEntity, PositionsDto.class);
            
            listAllPositionsDto.add(positionsDto);
        }
        
        result.put("Message", "Berhasil menampilkan seluruh data Positions");
        result.put("Data", listAllPositionsDto);
        
        return result;
    }
}

package com.padepokan79.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padepokan79.models.dtos.PositionsDto;
import com.padepokan79.repositories.PositionsRepository;
import com.padepokan79.services.PositionsService;

@RestController
@RequestMapping("/positions")
public class PositionsController {
	
	@Autowired
	PositionsRepository positionsRepository;
	
	@Autowired
	PositionsService positionsService;
	
	ModelMapper modelMapper = new ModelMapper();
	
    @GetMapping("/{id}")
    public PositionsDto getPositionsEntity(@PathVariable(value = "id") Long paramId){
        PositionsDto result = positionsService.getDetailPositions(paramId);
        return result;
    }
    
    @GetMapping
    public List<PositionsDto> getAllPositions(){
    	List<PositionsDto> list = positionsService.getAllPositions();
	return list;
    }
}
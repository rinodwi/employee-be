package com.padepokan79.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padepokan79.models.dtos.DivisionsDto;
import com.padepokan79.repositories.DivisionsRepository;
import com.padepokan79.services.DivisionsService;

@RestController
@RequestMapping("/divisions")
public class DivisionsController {
	
	@Autowired
	DivisionsRepository divisionsRepository;
	
	@Autowired
	DivisionsService divisionsService;
	
	ModelMapper modelMapper = new ModelMapper();
	
    @GetMapping("/{id}")
    public DivisionsDto getDivisionsEntity(@PathVariable(value = "id") Long paramId){
        DivisionsDto result = divisionsService.getDetailDivisions(paramId);
        return result;
    }
    
    @GetMapping
    public List<DivisionsDto> getAllDivisions(){
    	List<DivisionsDto> list = divisionsService.getAllDivisions();
	return list;
    }
}
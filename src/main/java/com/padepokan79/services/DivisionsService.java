package com.padepokan79.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padepokan79.exceptions.ResourceNotFoundException;
import com.padepokan79.models.Divisions;
import com.padepokan79.models.dtos.DivisionsDto;
import com.padepokan79.repositories.DivisionsRepository;

@Service
public class DivisionsService {
	
	@Autowired
	DivisionsRepository divisionsRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	 //ReadOne
	 public DivisionsDto getDetailDivisions(Long paramId){
		 Divisions divisionsEntity = divisionsRepository.findById(paramId).orElseThrow(() -> new ResourceNotFoundException("Divisions", "IdDivisions",paramId));
		 DivisionsDto divisionsDto = modelMapper.map(divisionsEntity, DivisionsDto.class);
	     return divisionsDto;
	 }
	 
	 //readAll
	public List<DivisionsDto> getAllDivisions() {
		List<Divisions> listAllDivisions = divisionsRepository.findAll();		    
		List<DivisionsDto> listAllDivisionsDto = new ArrayList<DivisionsDto>();       
		    
		for (Divisions divisionsEntity : listAllDivisions ) {
		DivisionsDto divisionsDto = modelMapper.map(divisionsEntity, DivisionsDto.class);
		listAllDivisionsDto.add(divisionsDto);
		}
		return listAllDivisionsDto;
	}
	
	
}

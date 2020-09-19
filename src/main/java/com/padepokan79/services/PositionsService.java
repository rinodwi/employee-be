package com.padepokan79.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.padepokan79.exceptions.ResourceNotFoundException;
import com.padepokan79.models.Positions;
import com.padepokan79.models.dtos.PositionsDto;
import com.padepokan79.repositories.PositionsRepository;

@Service
public class PositionsService {
	
	@Autowired
	PositionsRepository positionsRepository;
	
	ModelMapper modelMapper = new ModelMapper();
	
	 //ReadOne
	 public PositionsDto getDetailPositions(Long paramId){
		 Positions positionsEntity = positionsRepository.findById(paramId).orElseThrow(() -> new ResourceNotFoundException("Positions", "IdPositions",paramId));
		 PositionsDto positionsDto = modelMapper.map(positionsEntity, PositionsDto.class);
	     return positionsDto;
	 }
	 
	 //readAll
	public List<PositionsDto> getAllPositions() {
		List<Positions> listAllPositions = positionsRepository.findAll();		    
		List<PositionsDto> listAllPositionsDto = new ArrayList<PositionsDto>();       
		    
		for (Positions positionsEntity : listAllPositions ) {
		PositionsDto positionsDto = modelMapper.map(positionsEntity, PositionsDto.class);
		listAllPositionsDto.add(positionsDto);
		}
		return listAllPositionsDto;
	}
	
	
}

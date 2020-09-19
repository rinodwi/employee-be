package com.padepokan79.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.padepokan79.exceptions.ResourceNotFoundException;
import com.padepokan79.models.Employees;
import com.padepokan79.models.Positions;
import com.padepokan79.models.dtos.EmployeesDto;
import com.padepokan79.repositories.EmployeesRepository;
import com.padepokan79.repositories.PositionsRepository;

@Service
public class EmployeesService {
	 @Autowired
	 	EmployeesRepository repository;
	 @Autowired
	 	PositionsRepository positionsRepository;
	 
	 	ModelMapper modelMapper = new ModelMapper();
	 //create
	 	public EmployeesDto saveEmployee(EmployeesDto body){
	 		Employees employeesEntity = new Employees();
	 		body.setNik(generateNik(repository.getEmployeeCurrentSequence()));
			body.setType("NEW");
			body.setCreateDate(new Date());
			body.setLastPosition("NEW");
			employeesEntity =  modelMapper.map(body, Employees.class);
			repository.save(employeesEntity);
			body.setId(repository.getEmployeeNextSequence());
			
		return body;
	 }
	 
	 	
	 //edit
	 public EmployeesDto editEmployee(Long paramId, EmployeesDto body){
	    Employees employeesEntity = repository.findById(paramId).orElseThrow(() -> new ResourceNotFoundException("Employees", "IdEmployees",paramId));
	    Positions positionsEntity = positionsRepository.findById(body.getPositionsId()).get();
	    
	    long previousPositionLevel = employeesEntity.getPositions().getLevel();
	    long nextPositionLevel = positionsEntity.getLevel();

//	    System.out.println("Entity====>"+entityPositionId);
//	    System.out.println("DTO====>"+dtoPositionId);
	    
	    if (nextPositionLevel == previousPositionLevel) {
		    body.setType(employeesEntity.getType());
		}else if (nextPositionLevel < previousPositionLevel) {
			body.setType("DEMOTE");
		}else if (nextPositionLevel > previousPositionLevel) {
			body.setType("PROMOTE");
		}
	    body.setId(paramId);
	    body.setNik(employeesEntity.getNik());
	    body.setCreateDate(employeesEntity.getCreateDate());
	    body.setLastPosition(employeesEntity.getPositions().getName());

//	    System.out.println("Entity2====>"+entityPositionId);
//	    System.out.println("===========");

	     employeesEntity = modelMapper.map(body, Employees.class);
	     repository.save(employeesEntity);
	     return body ;
	 }
	 
	 //ReadOne
	 public List<EmployeesDto> getDetailEmployee(Long paramId){
		 Employees employeesEntity = repository.findById(paramId).orElseThrow(() -> new ResourceNotFoundException("Employees", "IdEmployees",paramId));
	     EmployeesDto employeesDto = modelMapper.map(employeesEntity, EmployeesDto.class);
	     List<EmployeesDto> list = new ArrayList<>();
	     list.add(employeesDto);
	     return list;
	 }
	 //readAll
	 public List<EmployeesDto> getAllEmployee(Integer pageNo, Integer pageSize, String sortBy){
		 Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		 Page<Employees> pagedResult = repository.findAll(paging);
		 List<EmployeesDto> listAllEmployeesDto = new ArrayList<EmployeesDto>();
		  for (Employees employeesEntity : pagedResult ) {
            
            EmployeesDto employeesDto = modelMapper.map(employeesEntity, EmployeesDto.class);
            
            listAllEmployeesDto.add(employeesDto);
        }
		  if(pagedResult.hasContent()) {
			 return listAllEmployeesDto;
		 } else {
			 return new ArrayList<EmployeesDto>();
		 }
	}
	 //delete
	public String deleteEmployee(Long paramId) {
		repository.deleteById(paramId);
		return "Data Employee with ID "+ paramId +" Deleted.";
	}
	 
	public String generateNik(long id) {
		long ids = id + 1; 
		String nik = "";
		if (ids<10) {
			nik="MK0000"+ids;
		}else if (ids<100) {
			nik="MK000"+ids;
		}else if (ids<1000) {
			nik="MK00"+ids;
		}
	return nik;
	}
	
}

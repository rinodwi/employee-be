package com.padepokan79.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.padepokan79.exceptions.ResourceNotFoundException;
import com.padepokan79.models.Employees;
import com.padepokan79.repositories.EmployeesRepository;
import com.padepokan79.models.dtos.EmployeesDto;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
	
	@Autowired
	EmployeesRepository employeesRepository;
	

    ModelMapper modelMapper = new ModelMapper();
	
	   //Create
    @PostMapping
    public HashMap<String, Object> createEmployees(@Validated @RequestBody EmployeesDto body){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Employees employeesEntity = new Employees();    
        
        modelMapper.map(body, employeesEntity);
        
        employeesRepository.save(employeesEntity);
        
        result.put("Message","Data Employees berhasil dibuat");
        result.put("Data", body);
        
        return result;
    }
    
    //Update
    @PutMapping("/{id}")
    public HashMap<String, Object> updateEmployees(@PathVariable(value = "id") Long paramId, @RequestBody EmployeesDto body){
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        Employees employeesEntity = employeesRepository.findById(paramId).orElseThrow(() -> new ResourceNotFoundException("Employees", "IdEmployees",paramId));
        
        employeesEntity = modelMapper.map(body, Employees.class);
        
        employeesRepository.save(employeesEntity);
        
        result.put("Message","Data Employees berhasil diupdate");
        result.put("Data", body);
        
        return result;
        
    }
    
    //ReadOne
    @GetMapping("/{id}")
    public HashMap<String, Object> getEmployeesEntity(@PathVariable(value = "id") Long paramId){
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        Employees employeesEntity = employeesRepository.findById(paramId).orElseThrow(() -> new ResourceNotFoundException("Employees", "IdEmployees",paramId));
        
        EmployeesDto employeesDto = modelMapper.map(employeesEntity, EmployeesDto.class);
        
        result.put("Message", "Berhasil menampilkan Employees");
        result.put("data", employeesDto);
        
        return result;
    }
    
    @GetMapping
    public HashMap<String, Object> getAllEmployees(){
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        List<Employees> listAllEmployees = employeesRepository.findAll();
        
        List<EmployeesDto> listAllEmployeesDto = new ArrayList<EmployeesDto>();       
        
        for (Employees employeesEntity : listAllEmployees ) {
            
            EmployeesDto employeesDto = modelMapper.map(employeesEntity, EmployeesDto.class);
            
            listAllEmployeesDto.add(employeesDto);
        }
        
        result.put("Message", "Berhasil menampilkan seluruh data Employees");
        result.put("Data", listAllEmployeesDto);
        
        return result;
    }
    
    //Delete
    @DeleteMapping("/{id}")
    public HashMap<String, Object>  deleteEmployees(@PathVariable(value = "Id") Long paramId ){
        HashMap<String, Object> result = new HashMap<String, Object>();
        
        employeesRepository.deleteById(paramId);
        
        result.put("Message", "Data Employees dengan ID " + paramId + " berhasil dihapus");
        
        return result;
    }
}


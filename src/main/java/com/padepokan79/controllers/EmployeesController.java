package com.padepokan79.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.padepokan79.repositories.EmployeesRepository;
import com.padepokan79.services.EmployeesService;
import com.padepokan79.models.dtos.EmployeesDto;

@RestController
@RequestMapping
public class EmployeesController {
	
	@Autowired
	EmployeesRepository employeesRepository;
	
	@Autowired
	EmployeesService employeesService;

    ModelMapper modelMapper = new ModelMapper();
	
	 //Create
    @PostMapping("/employees")
    public EmployeesDto saveEmployee(@RequestBody EmployeesDto body){
    	EmployeesDto employeeDto = employeesService.saveEmployee(body);
    	return employeeDto;
    }
    
    //Update
    @PutMapping("/employees/{id}")
    public EmployeesDto editEmployee(@PathVariable(value = "id") Long paramId, @RequestBody EmployeesDto body ){
    	EmployeesDto employeesDto = employeesService.editEmployee(paramId, body);
    	return employeesDto;
    }
    
    //ReadOne
    @GetMapping("/employees/{id}")
    public List<EmployeesDto> getDetailEmployee(@PathVariable(value = "id") Long paramId){
        List<EmployeesDto> list = employeesService.getDetailEmployee(paramId);
        return list; 
    }
    
    //ReadAll
    @GetMapping("/employees")
    public List<EmployeesDto> getAllEmployee(
                        @RequestParam(defaultValue = "0",required = false) Integer pageNo, 
                        @RequestParam(defaultValue = "10",required = false) Integer pageSize,
                        @RequestParam(defaultValue = "id",required = false) String sortBy) 
    {
        List<EmployeesDto> list = employeesService.getAllEmployee(pageNo, pageSize, sortBy);
 
        return list; 
    }
    
    //Delete
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long paramId ){
    	 employeesService.deleteEmployee(paramId);
         return new ResponseEntity<>("",HttpStatus.OK); 
    }
    
    //Sequence
    @GetMapping("/employee-sequence")
    public String getEmployeeCurrentSequence() {
    return	employeesRepository.getEmployeeCurrentSequence();
    }

}


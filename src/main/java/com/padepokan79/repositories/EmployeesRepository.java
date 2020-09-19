package com.padepokan79.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.padepokan79.models.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Long>{

	 //getCurrentSequence
    @Query(value = "SELECT last_value from seq_employees",nativeQuery = true )
    public String getEmployeeCurrentSequence();   
}

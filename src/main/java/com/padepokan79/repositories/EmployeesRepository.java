package com.padepokan79.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padepokan79.models.Employees;

public interface EmployeesRepository extends JpaRepository<Employees, Long>{

}

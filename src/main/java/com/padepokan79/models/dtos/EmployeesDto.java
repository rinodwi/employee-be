package com.padepokan79.models.dtos;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto {
	
	private Timestamp createDate;
	private DivisionsDto divisions;
	private long id;
	private String lastPosition;
	private String name;
	private long nik;
	private PositionsDto positions;
	private String type;

}

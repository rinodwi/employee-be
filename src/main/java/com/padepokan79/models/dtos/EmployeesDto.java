package com.padepokan79.models.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDto {

	private long id;
	private String nik;
	private String name;
	private long divisionsId;
	private long positionsId;
	private String lastPosition;
	private String type;
	private Date createDate;

}

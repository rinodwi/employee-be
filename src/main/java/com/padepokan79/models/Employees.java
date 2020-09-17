package com.padepokan79.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employees {
	
	@CreatedDate
	@Column(name = "create_date")
	private Timestamp createDate;
	
	@ManyToOne
	@JoinColumn(name = "division_id")
	private Divisions divisions;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_generator")
	@SequenceGenerator(name="employees_generator", sequenceName = "seq_employees", schema = "public", allocationSize = 1)
	private long id;
	
	@Column(name = "last_position")
	private String lastPosition;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "nik")
	private long nik;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Positions positions;
	
	@Column(name = "type")
	private String type;


}

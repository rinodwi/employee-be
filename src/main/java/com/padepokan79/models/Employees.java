package com.padepokan79.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_generator")
	@SequenceGenerator(name="employees_generator", sequenceName = "seq_employees", schema = "public", allocationSize = 1)
	private long id;
	
	@Column(name = "nik")
	private String nik;
	
	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "divisions_id")
	private Divisions divisions;
	
	@ManyToOne
	@JoinColumn(name = "positions_id")
	private Positions positions;
	
	@Column(name = "last_position")
	private String lastPosition;

	@Column(name = "type")
	private String type;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
	

}

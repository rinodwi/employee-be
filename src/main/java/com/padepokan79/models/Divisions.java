package com.padepokan79.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "division")
public class Divisions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "divisions_generator")
	@SequenceGenerator(name="divisions_generator", sequenceName = "seq_divisions", schema = "public", allocationSize = 1)
	@Column(name = "division_id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "divisions")
	Set<Employees> employees;

}

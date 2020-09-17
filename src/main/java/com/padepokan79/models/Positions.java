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
@Table(name = "position")
public class Positions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "positions_generator")
	@SequenceGenerator(name="positions_generator", sequenceName = "seq_positions", schema = "public", allocationSize = 1)
	@Column(name = "position_id")
	private long id;
	
	@Column(name = "level")
	private int level;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "positions")
	Set<Employees> employees;
	
	
}

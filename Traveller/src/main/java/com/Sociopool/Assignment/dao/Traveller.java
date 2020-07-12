package com.Sociopool.Assignment.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Traveller {

	/*
	 * 1.Username
	 * 2.Distance
	 * 3.TimeStamp
	 * 
	 * */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private long id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="distance")
	private String distance;
	
	@Column(name="unix")
	private int unix;
	
	
}

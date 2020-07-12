package com.Sociopool.Assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Traveller_Model {

	private String userName;
	private String date;
	private String time;
	private String distance;
	private int unix;
	private String startTime;
	private String endTime;
	private int endunix;
	
}

package com.Sociopool.Assignment.service;

import com.Sociopool.Assignment.model.Traveller_Model;

public interface TravellerService {

	public void saveEntity(Traveller_Model entity);

	public int getDistance(Traveller_Model entity);

}

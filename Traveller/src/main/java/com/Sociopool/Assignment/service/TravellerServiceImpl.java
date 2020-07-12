package com.Sociopool.Assignment.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sociopool.Assignment.dao.Traveller;
import com.Sociopool.Assignment.dao.TravellerRepo;
import com.Sociopool.Assignment.model.Traveller_Model;

@Service
public class TravellerServiceImpl implements TravellerService {

	@Autowired
	private TravellerRepo tr;

	@Autowired
	private ModelMapper modelMapper;

	public void saveEntity(Traveller_Model entity) {
		Traveller ts = modelMapper.map(entity, Traveller.class);
		Traveller unts = tr.findByUnix(entity.getUnix());
		if (unts != null) {
			unts.setDistance(entity.getDistance());
			tr.save(unts);

		} else {

			tr.save(ts);
		}
	}

	public int getDistance(Traveller_Model entity) {

		List<Traveller> travelList = tr.getTotalDistance(entity.getUserName(), entity.getUnix(), entity.getEndunix());

		return travelList.stream().filter(traveller -> traveller.getDistance() != null)
				.mapToInt(traveller -> Integer.parseInt(traveller.getDistance())).sum();

	}
}

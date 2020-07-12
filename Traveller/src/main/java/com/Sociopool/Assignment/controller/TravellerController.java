package com.Sociopool.Assignment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Sociopool.Assignment.model.Traveller_Model;
import com.Sociopool.Assignment.service.TravellerServiceImpl;

@RestController
public class TravellerController {

	@Autowired
	private TravellerServiceImpl tsl;

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { "application/json" })
	public ResponseEntity<?> saveTraveller(@RequestBody Traveller_Model entity) {

		if (isnullNdBlank(entity.getUserName()) || isnullNdBlank(entity.getDistance())) {
			return ResponseEntity.ok("Entries can't be blank.");
		}

		if (!validateJavaDate(entity.getDate())) {
			return ResponseEntity.ok("Invalid date format.Enter in dd/MM/yyyy");
		}
		if (!validateTime(entity.getTime())) {
			return ResponseEntity.ok("Invalid time.Please enter in 24 hours.");
		}

		entity.setUnix(unixConvert(entity.getDate() + " " + entity.getTime()));

		tsl.saveEntity(entity);

		return ResponseEntity.ok("distance saved");

	}

	@RequestMapping(value = "/get", method = RequestMethod.GET, consumes = { "application/json" })
	public ResponseEntity<?> getTraveller(@RequestBody Traveller_Model entity) {

		if (isnullNdBlank(entity.getUserName()) || isnullNdBlank(entity.getStartTime())
				|| isnullNdBlank(entity.getEndTime())) {
			return ResponseEntity.ok("Entries can't be blank.");
		}

		int startepoc = unixConvert(entity.getStartTime());
		int endepoc = unixConvert(entity.getEndTime());

		if (startepoc > endepoc) {
			return ResponseEntity.ok("end date can't be greater than start date.");
		}

		entity.setUnix(startepoc);
		entity.setEndunix(endepoc);

		return ResponseEntity.ok("Total distance covered-" + tsl.getDistance(entity));

	}

	public boolean isnullNdBlank(String string) {

		if (string == null || string.trim().equalsIgnoreCase("")) {
			return true;
		}

		return false;
	}

	public boolean validateTime(String inputTimeString) {

		try {
			LocalTime.parse(inputTimeString);
			return true;
		} catch (DateTimeParseException | NullPointerException e) {
			return false;
		}

	}

	public boolean validateJavaDate(String strDate) {
		if (strDate.trim().equals("")) {
			return true;
		} else {
			SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
			sdfrmt.setLenient(false);
			try {
				sdfrmt.parse(strDate);

			} catch (ParseException e) {
				return false;
			}
			return true;
		}
	}

	public int unixConvert(String timestamp) {
		if (timestamp == null)
			return 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm");
			Date dt = sdf.parse(timestamp);
			long epoch = dt.getTime();
			return (int) (epoch / 1000);
		} catch (ParseException e) {
			return 0;
		}
	}

}

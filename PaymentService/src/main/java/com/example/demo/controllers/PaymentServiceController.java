package com.example.demo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TripDataModel;
import com.example.demo.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class PaymentServiceController {


	@Autowired
	private PaymentService service;
	
	@GetMapping("/checkIfTripCompleted/{tripId}")
	public boolean checkIfTripCompleted(@PathVariable("tripId")long tripId)
	{
		//boolean logic comes here to 
		List<TripDataModel> listOfTrips = service.getAllTrips(tripId);
		TripDataModel currentTrip = null;
		for(int i=0;i<listOfTrips.size();i++)
		{
			if(listOfTrips.get(i).getTripId()==tripId)
			currentTrip = listOfTrips.get(i);
		}
		return currentTrip.getTripCompleted();
		
	}
	
	@GetMapping("/getFare/{tripId}/{kms}")
	public double fareCalculation(@PathVariable("kms")int kms,@PathVariable("tripId")long tripId) throws ParseException {
		//log.info(tripEntity.toString());
		//FARE CALCULATION COMES HERE
		
		String carType="sedan";
		
		double fare = 1;
		
		if(carType.equalsIgnoreCase("sedan"))
		{
			fare = fare*kms;
		}
		//Iterable<Long> id = tripId;
		List<TripDataModel> listOfTrips = service.getAllTrips(tripId);
		TripDataModel currentTrip = null;
		for(int i=0;i<listOfTrips.size();i++)
		{
			if(listOfTrips.get(i).getTripId()==tripId)
			currentTrip = listOfTrips.get(i);
		}
		
		
		String startDateTimeStr = currentTrip.getDateAndTimeOfTrip();
	    Date startDateTime=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").parse(startDateTimeStr);  
	    Date currentDateTime = new Date();
	    long diffMs = currentDateTime.getTime() - startDateTime.getTime();
	    long diffSec = diffMs / 1000;
	    long min = diffSec / 60;
	    long sec = diffSec % 60;
	    System.out.println("The difference is "+min+" minutes and "+sec+" seconds.");
	    System.out.println(startDateTime);
	    long hrs = min/60;
	    
	    fare = fare + hrs*5;
		
		
		return fare;
		
	}
	
	
	
	

}

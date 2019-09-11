package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TripDataModel;
import com.example.demo.repos.PaymentRepo;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepo repo;
	
	public TripDataModel saveFareAndTripCompleted(TripDataModel entity)
	{
		return repo.save(entity);
	
		
	}
	
	public List<TripDataModel> getTrip(Iterable<Long> tripId)
	{
		//return repo.findById(tripId);
		return repo.findAllById(tripId);
		
	}
	
	public List<TripDataModel> getAllTrips(long tripId)
	{
		//return repo.findById(tripId);
		return repo.findAll();
		
	}
	
	

	
	

}

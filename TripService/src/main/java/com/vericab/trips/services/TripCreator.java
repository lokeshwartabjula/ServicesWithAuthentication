 package com.vericab.trips.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.vericab.trips.models.HistoryTripDataModel;
import com.vericab.trips.models.TripDataModel;
import com.vericab.trips.repositories.HistoryTripData;
import com.vericab.trips.repositories.OngoingTripData;



@Service
public class TripCreator implements TripCreatorServiceMethods{

	@Autowired
	private OngoingTripData service;
	
	@Autowired HistoryTripData serviceHistory;

	@Override
	public void createTrip(TripDataModel entity) {
		
		service.save(entity);
		
	}



	@Override
	public void tripHasEnded(TripDataModel tripEntity) {
		
		tripEntity.setTripCompleted(true);
		service.save(tripEntity);
	}



	@Override
	public Iterable<HistoryTripDataModel> checkHistory(long userId,Pageable pageable) {
		
		Slice<HistoryTripDataModel> trips,tripHistory;
		
		trips = serviceHistory.findByPassengerId(userId, pageable);
		 
		if(!trips.isEmpty()) {
			 tripHistory = trips;
		 }
		else {
			tripHistory = serviceHistory.findByDriverId(userId, pageable);
		}
		
		return tripHistory;
	}



	@Override
	public void createHistory(HistoryTripDataModel historyData) {
		
		serviceHistory.save(historyData);
		
	}



	@Override
	public Iterable<HistoryTripDataModel> checkAllHistory() {
		
		return serviceHistory.findAll();
		
	}

	
}

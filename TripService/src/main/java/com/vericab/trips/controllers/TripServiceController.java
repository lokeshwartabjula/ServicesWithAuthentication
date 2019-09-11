package com.vericab.trips.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.vericab.trips.models.HistoryTripDataModel;
import com.vericab.trips.models.TripDataModel;
import com.vericab.trips.services.TripServiceInitiator;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
public class TripServiceController {
	


	@Autowired
	private TripServiceInitiator serviceCall;
	
	@Autowired
	private HistoryTripDataModel historyData;
	
	@PostMapping("/createTrip")
	public boolean TripCreation(@RequestBody TripDataModel tripEntity) {
		
		serviceCall.tripCreationInitiator(tripEntity);
		return true;
	}
	
	@PostMapping("/tripEnd")
	public boolean TripEnded(@RequestBody TripDataModel tripEntity) {
		serviceCall.EndTrip(tripEntity);
		
		historyData.setDriverId(tripEntity.getDriverId());
		historyData.setDriverName(tripEntity.getDriverName());
		historyData.setPassengerId(tripEntity.getPassengerId());
		historyData.setPassengerName(tripEntity.getPassengerName());
		historyData.setDateAndTimeOfTrip(tripEntity.getDateAndTimeOfTrip());
		historyData.setTripCompleted(true);
		historyData.setTripId(tripEntity.getTripId());
		historyData.setSourceLocation(tripEntity.getSourceLocation());
		historyData.setFare(tripEntity.getFare());
		
		serviceCall.createHistory(historyData);
		return true;
	}
	
	@GetMapping("/getHistory/{userId}/{page}/{size}")
	public List<HistoryTripDataModel> getHistory(@PathVariable("userId")long userId,
			@PathVariable("page")int page,
			@PathVariable("size")int size){ 
		
		//HAS TO BE CHECKED AGAIN
		
		
		
		List<HistoryTripDataModel> history= new ArrayList<>();
		
		
		
		Iterable<HistoryTripDataModel> historyDataList= serviceCall.CheckHistory(userId,CassandraPageRequest.first(size));
		historyDataList.forEach(action->history.add(action));
		log.info(history.toString());
		return history;
		
	}
	
	@GetMapping("/allHistory")
	public List<HistoryTripDataModel> getAllHistory(){
		Iterable<HistoryTripDataModel> historyDataList = serviceCall.findAll();
		List<HistoryTripDataModel> history= new ArrayList<>();
		historyDataList.forEach(action->history.add(action));
		
		return history;
	}
	

}

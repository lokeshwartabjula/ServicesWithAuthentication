/*This is an interface for TripCreator service.
 *It has the methods that will be used by TripService to manipulate database.
 
 	METHODS AND THEIR FUNCTIONALITIES:-
 	
 *getDriverByCarType - This will fetch the driver data from the database after the customer requests for a ride which is based
 *                     on car type, drivers are mapped inside DB itself.
 
 *createTrip - This will create a trip and insert it into the ongoing_trip document MONGO database.
 
 *deleteOngoingTripForPassenger - Deletes the data from ongoing_trip after the trip ends and archives it in history_trips.
 
 *createHistoryTripData - Creates the history data and archives it for the customer and driver to access.
 
 */



package com.vericab.trips.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.vericab.trips.models.HistoryTripDataModel;
import com.vericab.trips.models.TripDataModel;



@Component
public interface TripCreatorServiceMethods {
	
	public void createTrip(TripDataModel entity);
	public void tripHasEnded(TripDataModel historyTripEntity);
	public Iterable<HistoryTripDataModel> checkHistory(long userId,Pageable pageable);
	public void createHistory(HistoryTripDataModel historyData);
	public Iterable<HistoryTripDataModel> checkAllHistory();
}

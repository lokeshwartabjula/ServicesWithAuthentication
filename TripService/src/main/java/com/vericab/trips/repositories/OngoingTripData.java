package com.vericab.trips.repositories;




import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.vericab.trips.models.TripDataModel;

@Repository
public interface OngoingTripData extends CassandraRepository<TripDataModel, Long> {

	

	
}


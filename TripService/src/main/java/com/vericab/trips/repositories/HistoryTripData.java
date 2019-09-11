package com.vericab.trips.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.vericab.trips.models.HistoryTripDataModel;


public interface HistoryTripData extends CassandraRepository<HistoryTripDataModel, Long>{

	@Query(allowFiltering = true)
	public	Slice<HistoryTripDataModel> findByPassengerId(long userId,Pageable pageable);
	@Query(allowFiltering = true)
	public Slice<HistoryTripDataModel> findByDriverId(long userId,Pageable pageable);
	
}

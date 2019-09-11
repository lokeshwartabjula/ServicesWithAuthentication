package com.example.demo.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "onGoing")
@Component
public class TripDataModel {
	
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private Long driverId;
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private Long passengerId;
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private Long tripId;
	private String  passengerName;
	private String driverName;
	private String sourceLocation;
	private String dateAndTimeOfTrip;
	private Boolean tripCompleted;
	private Double fare;
	

} 

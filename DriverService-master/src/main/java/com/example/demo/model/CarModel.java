package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component 
@Entity 
@Table(name="vericab_car")
public class CarModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
	private String manufacturer;  //Eg. Toyota
	private String variant;  //Eg. Corolla variant of Toyota
	private String registrationNumber;  //Eg. TN 27 CT 0595
	private Integer noOfSeaters;	//4 , 6 seaters
	private String type; //Hatchback or Sedan class
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "driverId")
	private DriverModel driver ;
	

	private Double ratePerKm;
	
}


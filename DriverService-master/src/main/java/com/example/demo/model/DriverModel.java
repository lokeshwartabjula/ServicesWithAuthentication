package com.example.demo.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component 
@Entity 
@Table(name="vericab_driver")
public class DriverModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;
    private String name;  //First name+Last name
    private String gender;  //To be entered as 'Male, 'Female', 'Transgender' only
    private Double rating;   //On a scale of 5
    private Long totalNoOfRatings;
    private String email; 
    private String phoneNumber;
    
    @DateTimeFormat(pattern="MM/dd/yyyy")
    private Date dob;
    private String password;
    private String driverPhotoLocation;
    private String licenseNumber; //Eg. MH-4089503248
    
}

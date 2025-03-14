package com.tribleCarLeaseManagementSystem.exception;
//Custom exception for handling cases where a car is not found in the system
public class CarNotFoundException  extends RuntimeException{

	  public CarNotFoundException(String message){
	        super(message);
	  }
}

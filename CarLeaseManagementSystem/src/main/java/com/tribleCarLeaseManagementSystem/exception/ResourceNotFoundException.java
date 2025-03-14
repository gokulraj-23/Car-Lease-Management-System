package com.tribleCarLeaseManagementSystem.exception;
//Custom exception class for handling resource not found scenarios
public class ResourceNotFoundException  extends RuntimeException {
    public ResourceNotFoundException(String message){
        super(message);
    }

}

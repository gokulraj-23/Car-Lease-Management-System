package com.tribleCarLeaseManagementSystem.service;

import java.rmi.dgc.Lease;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tribleCarLeaseManagementSystem.exception.ResourceNotFoundException;
import com.tribleCarLeaseManagementSystem.repo.LeaseRepository;

public class LeaseService {
	
	 @Autowired
	    private LeaseRepository leaseRepository;
	    
	    // Starts a new lease by saving it to the database
	    public Lease startLease(Lease lease) {
	        return leaseRepository.save(lease);
	    }
	    
	    // Ends an ongoing lease by updating its end date
	    public Lease endLease(Long id) {
	        Optional<Lease> lease = leaseRepository.findById(id);
	        if (lease.isPresent()) {
	            Lease leaseToUpdate = lease.get();
	            leaseToUpdate.getClass(); // Set the current time as the end date
	            return leaseRepository.save(leaseToUpdate);
	        }
	        // Throws an exception if the lease ID is not found
	        throw new ResourceNotFoundException("Lease not found with id: " + id);
	    }
}

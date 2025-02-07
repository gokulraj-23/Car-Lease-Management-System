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
	    
	    public Lease startLease(Lease lease) {
	        return leaseRepository.save(lease);
	    }
	    
	    public Lease endLease(Long id) {
	        Optional<Lease> lease = leaseRepository.findById(id);
	        if (lease.isPresent()) {
	            Lease leaseToUpdate = lease.get();
	            leaseToUpdate.getValue();
	            return leaseRepository.save(leaseToUpdate);
	        }
	        throw new ResourceNotFoundException("Lease not found with id: " + id);
	    }
}

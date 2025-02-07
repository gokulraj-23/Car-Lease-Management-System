package com.tribleCarLeaseManagementSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.tribleCarLeaseManagementSystem.dto.Lease;
import com.tribleCarLeaseManagementSystem.exception.ResourceNotFoundException;
import com.tribleCarLeaseManagementSystem.repo.LeaseRepository;
import com.tribleCarLeaseManagementSystem.service.LeaseService;

public class LeaseServiceTest {
	  @Mock
	    private LeaseRepository leaseRepository;

	    @InjectMocks
	    private LeaseService leaseService;

	    private Lease lease;

	    @BeforeEach
	    void setUp() {
	        lease = new Lease();
	        lease.setId(1L);
	        lease.setStartDate(LocalDateTime.now()); // Initialize lease with start date
	    }

	    @Test
	    void startLease_ShouldSaveLease() {
	        when(leaseRepository.save(lease)).thenReturn(lease);
	        Lease savedLease = leaseService.startLease(lease);
	        assertNotNull(savedLease); // Ensure the lease is saved
	        assertEquals(lease.getStartDate(), savedLease.getStartDate()); // Validate start date
	    }

	    @Test
	    void endLease_ShouldUpdateEndDate_WhenLeaseExists() {
	        when(leaseRepository.findById(1L)).thenReturn(Optional.of(lease));
	        when(leaseRepository.save(any(Lease.class))).thenReturn(lease);
	        Lease endedLease = leaseService.endLease(1L);
	        assertNotNull(endedLease.getEndDate()); // Ensure the end date is updated
	    }

	    @Test
	    void endLease_ShouldThrowException_WhenLeaseNotFound() {
	        when(leaseRepository.findById(1L)).thenReturn(Optional.empty());
	        assertThrows(ResourceNotFoundException.class, () -> leaseService.endLease(1L)); // Expect exception when lease is missing
	    }
}

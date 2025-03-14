package com.tribleCarLeaseManagementSystem.dto;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lease")
public class Lease {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Unique identifier for the lease transaction
	    private Long carId; // ID of the car being leased
	    private Long userId; // ID of the user leasing the car
	    private LocalDate startDate; // Start date of the lease period
	    private LocalDate endDate; // End date of the lease period
	    private boolean isActive; // Indicates if the lease is currently active or not
		public void setId(long l) {
			// TODO Auto-generated method stub
			
		}
}

package com.tribleCarLeaseManagementSystem.dto;
import java.rmi.dgc.Lease;
import java.util.List;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Car entity representing the cars available for lease
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id; // Unique identifier for each car
	    
	    private String model;
	    private String make;
	    private int year;
	    private String status; // Car status: Ideal, On Lease, On Service
	    
	    @ManyToOne
	    @JoinColumn(name = "owner_id")
	    private User owner; // Owner of the car
	    
	    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	    private List<Lease> leaseHistory; // Lease history of the car

		public void setId(long l) {
			// TODO Auto-generated method stub
			
		}
}

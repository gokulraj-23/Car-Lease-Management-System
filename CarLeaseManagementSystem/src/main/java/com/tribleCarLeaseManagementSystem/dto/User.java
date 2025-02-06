package com.tribleCarLeaseManagementSystem.dto;

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
@Table(name = "user")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Unique identifier for the user
    private String name; // Full name of the user
    private String email; // Contact email of the user
    private String role; // Role of the user: either OWNER (Car owner) or CUSTOMER (End-user renting the car)
}

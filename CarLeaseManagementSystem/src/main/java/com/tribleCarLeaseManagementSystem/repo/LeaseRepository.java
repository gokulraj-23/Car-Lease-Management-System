package com.tribleCarLeaseManagementSystem.repo;
import java.rmi.dgc.Lease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaseRepository extends JpaRepository<Lease, Long>{

	Object saveAll(com.tribleCarLeaseManagementSystem.dto.Lease lease);

}

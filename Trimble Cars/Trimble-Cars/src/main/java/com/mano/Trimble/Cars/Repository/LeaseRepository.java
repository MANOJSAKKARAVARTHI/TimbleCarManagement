package com.mano.Trimble.Cars.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mano.Trimble.Cars.Entity.Lease;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {
    List<Lease> findByCustomerId(Long customerId);
    long countByCustomerIdAndEndDateIsNull(Long customerId);
}
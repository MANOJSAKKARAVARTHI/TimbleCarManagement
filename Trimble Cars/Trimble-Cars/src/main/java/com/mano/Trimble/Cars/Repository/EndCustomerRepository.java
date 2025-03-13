package com.mano.Trimble.Cars.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mano.Trimble.Cars.Entity.EndCustomer;

@Repository
public interface EndCustomerRepository extends JpaRepository<EndCustomer, Long> {}

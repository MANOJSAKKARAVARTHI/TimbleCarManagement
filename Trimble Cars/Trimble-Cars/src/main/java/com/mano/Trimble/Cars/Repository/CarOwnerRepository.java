package com.mano.Trimble.Cars.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mano.Trimble.Cars.Entity.CarOwner;

@Repository
public interface CarOwnerRepository extends JpaRepository<CarOwner, Long> {
}

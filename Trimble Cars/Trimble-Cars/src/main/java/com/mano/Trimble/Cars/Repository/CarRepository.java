package com.mano.Trimble.Cars.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mano.Trimble.Cars.Entity.Car;
import com.mano.Trimble.Cars.Entity.CareStatus;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByOwnerId(Long ownerId);
    List<Car> findByStatus(CareStatus status);
}

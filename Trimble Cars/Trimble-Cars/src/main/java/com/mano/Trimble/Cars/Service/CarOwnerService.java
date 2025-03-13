package com.mano.Trimble.Cars.Service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mano.Trimble.Cars.Entity.Car;
import com.mano.Trimble.Cars.Entity.CarOwner;
import com.mano.Trimble.Cars.Entity.CareStatus;
import com.mano.Trimble.Cars.Repository.CarOwnerRepository;
import com.mano.Trimble.Cars.Repository.CarRepository;

import jakarta.transaction.Transactional;

@Service
public class CarOwnerService {

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    @Autowired
    private CarRepository carRepository;

    public CarOwner registerCarOwner(CarOwner carOwner) {
        return carOwnerRepository.save(carOwner);
    }

    @Transactional
    public Car enrollCar(Long ownerId, Car car) {
        Optional<CarOwner> owner = carOwnerRepository.findById(ownerId);
        if (owner.isPresent()) {
            car.setOwner(owner.get());
            return carRepository.save(car);
        } else {
            throw new RuntimeException("Car Owner not found with ID: " + ownerId);
        }
    }

    public String getCarStatus(Long carId) {
        Optional<Car> car = carRepository.findById(carId);
        return car.map(c -> c.getStatus().toString()).orElse("Car Not Found");
    }

}

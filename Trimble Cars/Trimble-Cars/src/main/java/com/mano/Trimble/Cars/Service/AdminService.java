package com.mano.Trimble.Cars.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mano.Trimble.Cars.Entity.Car;
import com.mano.Trimble.Cars.Entity.Lease;
import com.mano.Trimble.Cars.Repository.CarRepository;
import com.mano.Trimble.Cars.Repository.LeaseRepository;

@Service
public class AdminService {
    @Autowired
    private CarOwnerService carOwnerService;
    @Autowired
    private EndCustomerService endCustomerService;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private LeaseRepository leaseRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Lease> getAllLeases() {
        return leaseRepository.findAll();
    }
}

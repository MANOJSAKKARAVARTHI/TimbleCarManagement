package com.mano.Trimble.Cars.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mano.Trimble.Cars.Entity.Car;
import com.mano.Trimble.Cars.Entity.CarOwner;
import com.mano.Trimble.Cars.Entity.CareStatus;
import com.mano.Trimble.Cars.Service.CarOwnerService;

@RestController
@RequestMapping("/car-owner")
public class CarOwnerController {

    @Autowired
    private CarOwnerService carOwnerService;

    @PostMapping("/register")
    public ResponseEntity<CarOwner> registerCarOwner(@RequestBody CarOwner carOwner) {
        return ResponseEntity.ok(carOwnerService.registerCarOwner(carOwner));
    }

    @PostMapping("/enroll-car/{ownerId}")
    public ResponseEntity<Car> enrollCar(@PathVariable("ownerId") Long ownerId, @RequestBody Car car) {
        return ResponseEntity.ok(carOwnerService.enrollCar(ownerId, car));
    }
    @GetMapping("/car-status/{carId}")
    public ResponseEntity<String> getCarStatus(@PathVariable("carId") Long carId) {  
        String status = carOwnerService.getCarStatus(carId);  
        return ResponseEntity.ok(status);
    }

}

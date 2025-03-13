package com.mano.Trimble.Cars.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mano.Trimble.Cars.Entity.Car;
import com.mano.Trimble.Cars.Entity.Lease;
import com.mano.Trimble.Cars.Service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all-cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(adminService.getAllCars());
    }

    @GetMapping("/all-leases")
    public ResponseEntity<List<Lease>> getAllLeases() {
        return ResponseEntity.ok(adminService.getAllLeases());
    }
}

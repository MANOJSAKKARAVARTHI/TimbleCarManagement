package com.mano.Trimble.Cars.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mano.Trimble.Cars.Entity.Car;
import com.mano.Trimble.Cars.Entity.EndCustomer;
import com.mano.Trimble.Cars.Entity.Lease;
import com.mano.Trimble.Cars.Entity.LeaseRequest;
import com.mano.Trimble.Cars.Service.EndCustomerService;

@RestController
@RequestMapping("/end-customer")
public class EndcustomerController {  // ✅ Fixed class name formatting

    @Autowired
    private EndCustomerService endCustomerService;

    @PostMapping("/register")
    public ResponseEntity<EndCustomer> registerEndCustomer(@RequestBody EndCustomer customer) {
        return ResponseEntity.ok(endCustomerService.registerEndCustomer(customer));
    }

    @GetMapping("/available-cars")
    public ResponseEntity<List<Car>> getAvailableCars() {
        List<Car> cars = endCustomerService.getAvailableCars();  // ✅ Using correct service
        return ResponseEntity.ok(cars);
    }

    @PostMapping("/start-lease/{customerId}/{carId}")
    public ResponseEntity<Lease> startLease(@RequestBody LeaseRequest request) {
        Lease lease = endCustomerService.startLease(request.getCustomerId(), request.getCarId());
        return ResponseEntity.ok(lease);
    }
}

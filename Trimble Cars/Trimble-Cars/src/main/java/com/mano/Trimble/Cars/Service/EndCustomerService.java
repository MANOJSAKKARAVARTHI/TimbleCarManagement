package com.mano.Trimble.Cars.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mano.Trimble.Cars.Entity.Car;
import com.mano.Trimble.Cars.Entity.CareStatus;
import com.mano.Trimble.Cars.Entity.EndCustomer;
import com.mano.Trimble.Cars.Entity.Lease;
import com.mano.Trimble.Cars.Repository.CarRepository;
import com.mano.Trimble.Cars.Repository.EndCustomerRepository;
import com.mano.Trimble.Cars.Repository.LeaseRepository; // ✅ Fixed typo

@Service
public class EndCustomerService {

    @Autowired
    private EndCustomerRepository endCustomerRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private LeaseRepository leaseRepository; // ✅ Fixed typo

    public EndCustomer registerEndCustomer(EndCustomer customer) {
        return endCustomerRepository.save(customer);
    }

    public List<Car> getAvailableCars() {
        return carRepository.findByStatus(CareStatus.IDLE); // ✅ Use correct enum
    }

    public Lease startLease(Long customerId, Long carId) {
        EndCustomer customer = endCustomerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        long activeLeases = leaseRepository.countByCustomerIdAndEndDateIsNull(customerId); // ✅ Correct instance usage
        if (activeLeases >= 2) {
            throw new RuntimeException("Customer can only lease up to 2 cars at a time");
        }

        Lease lease = new Lease();
        lease.setCar(car);
        lease.setCustomer(customer);
        lease.setStartDate(java.time.LocalDate.now().toString());
        car.setStatus(CareStatus.ON_LEASE);

        carRepository.save(car);
        return leaseRepository.save(lease); // ✅ Correct instance usage
    }

    public Lease endLease(Long leaseId) {
        Lease lease = leaseRepository.findById(leaseId) // ✅ Correct instance usage
                .orElseThrow(() -> new RuntimeException("Lease not found"));
        lease.setEndDate(java.time.LocalDate.now().toString());
        lease.getCar().setStatus(CareStatus.IDLE);

        carRepository.save(lease.getCar());
        return leaseRepository.save(lease); // ✅ Correct instance usage
    }

    public List<Lease> getCustomerLeaseHistory(Long customerId) {
        return leaseRepository.findByCustomerId(customerId); // ✅ Correct instance usage
    }
    
}

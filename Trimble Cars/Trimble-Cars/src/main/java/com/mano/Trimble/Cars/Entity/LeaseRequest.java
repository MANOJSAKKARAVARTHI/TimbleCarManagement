package com.mano.Trimble.Cars.Entity;


public class LeaseRequest {
    private Long customerId;
    private Long carId;

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    
    public Long getCarId() { return carId; }
    public void setCarId(Long carId) { this.carId = carId; }
}

package com.mano.Trimble.Cars.Entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String brand;
    private String numberPlate;

    @Enumerated(EnumType.STRING)
    private CareStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    @JsonIgnore 
    private CarOwner owner;


    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore 
    private List<Lease> leaseHistory;

    public Car() {}

    public Car(String model, String brand, String numberPlate, CareStatus status, CarOwner owner) {
        this.model = model;
        this.brand = brand;
        this.numberPlate = numberPlate;
        this.status = status;
        this.owner = owner;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getNumberPlate() { return numberPlate; }
    public void setNumberPlate(String numberPlate) { this.numberPlate = numberPlate; }

    public CareStatus getStatus() { return status; }
    public void setStatus(CareStatus status) { this.status = status; }

    public CarOwner getOwner() { return owner; }
    public void setOwner(CarOwner owner) { this.owner = owner; }

    public List<Lease> getLeaseHistory() { return leaseHistory; }
    public void setLeaseHistory(List<Lease> leaseHistory) { this.leaseHistory = leaseHistory; }
}

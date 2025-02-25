package dev.layseiras.larussoautogroup.core.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tb_test_drive")
public class TestDrive extends Base {
    @ManyToOne
    @JoinColumn(name = "car_tested")
    private Car carTested;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller sellerTester;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientTester;

    public TestDrive() {
        super();
    }

    public TestDrive(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, Car car, Seller seller, Client client) {
        super(id, createdAt, updatedAt, deletedAt, startDate, endDate, startTime, endTime);
        this.carTested = car;
        this.sellerTester = seller;
        this.clientTester = client;
    }

    public Car getCarTested() {
        return carTested;
    }

    public void setCarTested(Car carTested) {
        this.carTested = carTested;
    }

    public Seller getSellerTester() {
        return sellerTester;
    }

    public void setSellerTester(Seller sellerTester) {
        this.sellerTester = sellerTester;
    }

    public Client getClientTester() {
        return clientTester;
    }

    public void setClientTester(Client clientTester) {
        this.clientTester = clientTester;
    }
}

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

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    public TestDrive() {
        super();
    }

    public TestDrive(Car carTested, Seller sellerTester, Client clientTester, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        this.carTested = carTested;
        this.sellerTester = sellerTester;
        this.clientTester = clientTester;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TestDrive(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Car carTested, Seller sellerTester, Client clientTester, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        super(id, createdAt, updatedAt, deletedAt);
        this.carTested = carTested;
        this.sellerTester = sellerTester;
        this.clientTester = clientTester;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}

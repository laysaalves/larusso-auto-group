package dev.layseiras.larussoautogroup.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_seller")
public class Seller extends Base {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "tests_quantity")
    private int testDriveQuantity;

    @Column(name = "satisfied_clients")
    private int satisfiedClient;

    public Seller() {
        super();
    }

    public Seller(String name, String email, int testDriveQuantity, int satisfiedClient) {
        this.name = name;
        this.email = email;
        this.testDriveQuantity = testDriveQuantity;
        this.satisfiedClient = satisfiedClient;
    }

    public Seller(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String name, String email, int testDriveQuantity, int satisfiedClient) {
        super(id, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.email = email;
        this.testDriveQuantity = testDriveQuantity;
        this.satisfiedClient = satisfiedClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTestDriveQuantity() {
        return testDriveQuantity;
    }

    public void setTestDriveQuantity(int testDriveQuantity) {
        this.testDriveQuantity = testDriveQuantity;
    }

    public int getSatisfiedClient() {
        return satisfiedClient;
    }

    public void setSatisfiedClient(int satisfiedClient) {
        this.satisfiedClient = satisfiedClient;
    }
}

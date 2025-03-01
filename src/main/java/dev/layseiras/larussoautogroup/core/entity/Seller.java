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

    public Seller() {
        super();
    }

    public Seller(String name, String email, int testDriveQuantity) {
        this.name = name;
        this.email = email;
        this.testDriveQuantity = testDriveQuantity;
    }

    public Seller(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String name, String email, int testDriveQuantity) {
        super(id, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.email = email;
        this.testDriveQuantity = testDriveQuantity;
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
}

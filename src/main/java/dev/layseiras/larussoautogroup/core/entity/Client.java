package dev.layseiras.larussoautogroup.core.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_client")
public class Client extends Base {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "test_drive")
    private TestDrive testDrive;

    public Client() {
        super();
    }

    public Client(String name, String email, TestDrive testDrive) {
        this.name = name;
        this.email = email;
        this.testDrive = testDrive;
    }

    public Client(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String name, String email, TestDrive testDrive) {
        super(id, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.email = email;
        this.testDrive = testDrive;
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

    public TestDrive getTestDrive() {
        return testDrive;
    }

    public void setTestDrive(TestDrive testDrive) {
        this.testDrive = testDrive;
    }
}

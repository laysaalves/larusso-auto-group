package dev.layseiras.larussoautogroup.core.entity;

import dev.layseiras.larussoautogroup.core.enuns.CarBrand;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_car")
public class Car extends Base {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "brand")
    private CarBrand brand;

    @Column(name = "model")
    private String model;

    @Column(name = "price", nullable = false)
    private Double price;

    public Car() {
        super();
    }

    public Car(String name, CarBrand brand, String model, Double price) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Car(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, String name, CarBrand brand, String model, Double price) {
        super(id, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

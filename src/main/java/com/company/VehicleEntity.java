package com.company;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "vehicle")
public abstract class VehicleEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "fuel_type")
    private String fuel_type;
    @Column(name = "model")
    private String model;
    @Column(name = "type")
    private String type;
    @Column(name = "price")
    private BigDecimal price;

    public VehicleEntity(String type) {
        this.type = type;
    }

    public VehicleEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

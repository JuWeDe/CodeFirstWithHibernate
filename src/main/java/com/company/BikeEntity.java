package com.company;

import javax.persistence.*;

@Entity
@Table(name = "bikes")
public class BikeEntity extends VehicleEntity {
    private final static String type = "bike";

    @Id
    @ManyToMany
    private long id;

    public BikeEntity() {
        super(type);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String toString() {
        return "Id = " + id + "\ntype = " + type + "\nprice = " + getPrice() + "\nmodel = " + getModel() + "\nfuel = " + getFuel_type() + "\n";
    }
}

package com.company;

import javax.persistence.*;

@Entity
@Table(name = "trucks")
public class TruckEntity extends VehicleEntity {

    @Id
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private long id;


    private static final String type = "truck";
    private double load_capacity;

    public TruckEntity() {
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

    public double getLoad_capacity() {
        return load_capacity;
    }

    public void setLoad_capacity(double load_capacity) {
        this.load_capacity = load_capacity;
    }

    public String toString() {
        return "Id = " + id + "\ntype = " + type + "\nprice = " + getPrice() + "\nmodel = " + getModel() + "\nfuel = " + getFuel_type() +
                "\nload capacity = " + load_capacity + "\n";
    }
}

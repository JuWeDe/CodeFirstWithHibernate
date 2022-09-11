package com.company;

import javax.persistence.*;

@Entity
@Table(name = "planes")
public class PlaneEntity extends VehicleEntity {

    @Id
    @ManyToMany
    private long id;

    private static final String type = "plane";

    private String airline;
    private int passenger_capacity;


    public PlaneEntity() {
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

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getPassenger_capacity() {
        return passenger_capacity;
    }

    public void setPassenger_capacity(int passenger_capacity) {
        this.passenger_capacity = passenger_capacity;
    }

    public String toString() {
        return "Id = " + id + "\ntype = " + type + "\nprice = " + getPrice() + "\nmodel = " + getModel() + "\nfuel = " + getFuel_type() +
                "\nairline = " + airline + "\npassenger capacity = " + passenger_capacity + "\n";
    }
}

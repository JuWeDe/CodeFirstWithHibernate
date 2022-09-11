package com.company;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class CarEntity extends VehicleEntity {

    @Id
    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private long id;
    private final static String type = "car";
    private int seats;

    @Override
    public long getId() {
        return id;
    }


    @Override
    public void setId(long id) {
        this.id = id;
    }


    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public CarEntity() {
        super(type);
    }

    public String toString() {
        return "Id = " + id + "\ntype = " + type + "\nprice = " + getPrice() + "\nmodel = " + getModel() + "\nfuel = " + getFuel_type() +
                "\nseats = " + seats + "\n";
    }
}

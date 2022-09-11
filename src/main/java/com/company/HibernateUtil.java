package com.company;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.List;

public class HibernateUtil {

    public static void deleteBike(long id) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(BikeEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        BikeEntity bike = session.get(BikeEntity.class, id);
        if (readBike(id) != null) {
            session.delete(bike);
            System.out.println("Bike was successfully deleted!");
        } else {
            System.out.println("!!!error!!!");
        }
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }


    public static void deleteTruck(long id) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(TruckEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        TruckEntity truck = session.get(TruckEntity.class, id);
        if (readBike(id) != null) {
            session.delete(truck);
            System.out.println("Truck was successfully deleted!");
        } else {
            System.out.println("!!!error!!!");
        }
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }

    public static void deleteCar(long id) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(CarEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        CarEntity car = session.get(CarEntity.class, id);
        if (readBike(id) != null) {
            session.delete(car);
            System.out.println("Car was successfully deleted!");
        } else {
            System.out.println("!!!error!!!");
        }
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }


    public static void deletePlane(long id) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(PlaneEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        PlaneEntity plane = session.get(PlaneEntity.class, id);
        if (readBike(id) != null) {
            session.delete(plane);
            System.out.println("Plane was successfully deleted!");
        } else {
            System.out.println("!!!error!!!");
        }
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }

    public static void updateBike(long id, String fType, BigDecimal price, String model) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(BikeEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        BikeEntity bike = session.get(BikeEntity.class, id);
        if (!fType.isEmpty()) {
            bike.setFuel_type(fType);
        }
        if (price.longValue() > 0) {
            bike.setPrice(price);
        }
        if (!model.isEmpty()) {
            bike.setModel(model);
        }

        Transaction transaction = session.beginTransaction();
        transaction.commit();
        System.out.println("Updated Successfully");
        session.close();

    }

    public static void updateTruck(long id, String fType, BigDecimal price, String model, int loadCapacity) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(TruckEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        TruckEntity truck = session.get(TruckEntity.class, id);
        if (!fType.isEmpty()) {
            truck.setFuel_type(fType);
        }
        if (price.longValue() >= 0) {
            truck.setPrice(price);
        }
        if (!model.isEmpty()) {
            truck.setModel(model);
        }
        if (loadCapacity >= 0) {
            truck.setLoad_capacity(loadCapacity);
        }

        Transaction transaction = session.beginTransaction();
        transaction.commit();
        System.out.println("Updated Successfully");
        session.close();

    }

    public static void updateCar(long id, String fType, BigDecimal price, String model, int seats) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(CarEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        CarEntity car = session.get(CarEntity.class, id);
        if (!fType.isEmpty()) {
            car.setFuel_type(fType);
        }
        if (price.longValue() >= 0) {
            car.setPrice(price);
        }
        if (!model.isEmpty()) {
            car.setModel(model);
        }
        if (seats >= 0) {
            car.setSeats(seats);
        }

        Transaction transaction = session.beginTransaction();
        transaction.commit();
        System.out.println("Updated Successfully");
        session.close();

    }

    public static void updatePlane(long id, String fType, BigDecimal price, String model, String airline, int pasCapacity) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(PlaneEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        PlaneEntity plane = session.get(PlaneEntity.class, id);
        if (!fType.isEmpty()) {
            plane.setFuel_type(fType);
        }
        if (price.longValue() >= 0) {
            plane.setPrice(price);
        }
        if (!model.isEmpty()) {
            plane.setModel(model);
        }
        if (!airline.isEmpty()) {
            plane.setAirline(airline);
        }
        if (pasCapacity > 0) {
            plane.setPassenger_capacity(pasCapacity);
        }

        Transaction transaction = session.beginTransaction();
        transaction.commit();
        System.out.println("Updated Successfully");
        session.close();

    }

    public static void viewAllBikesData() {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(BikeEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<BikeEntity> cq = cb.createQuery(BikeEntity.class);
        Root<BikeEntity> rootEntry = cq.from(BikeEntity.class);
        CriteriaQuery<BikeEntity> all = cq.select(rootEntry);

        TypedQuery<BikeEntity> allQuery = session.createQuery(all);
        List<BikeEntity> res = allQuery.getResultList();
        for (int i = 0; i < res.size(); i++) {
            System.out.println(allQuery.getResultList().get(i).toString());
        }
        session.close();

    }

    public static void viewAllPlanesData() {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(PlaneEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<PlaneEntity> cq = cb.createQuery(PlaneEntity.class);
        Root<PlaneEntity> rootEntry = cq.from(PlaneEntity.class);
        CriteriaQuery<PlaneEntity> all = cq.select(rootEntry);
        TypedQuery<PlaneEntity> allQuery = session.createQuery(all);
        List<PlaneEntity> res = allQuery.getResultList();
        for (int i = 0; i < res.size(); i++) {
            System.out.println(allQuery.getResultList().get(i).toString());
        }
        session.close();

    }

    public static void viewAllTrucksData() {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(TruckEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<TruckEntity> cq = cb.createQuery(TruckEntity.class);
        Root<TruckEntity> rootEntry = cq.from(TruckEntity.class);
        CriteriaQuery<TruckEntity> all = cq.select(rootEntry);
        TypedQuery<TruckEntity> allQuery = session.createQuery(all);
        List<TruckEntity> res = allQuery.getResultList();
        for (int i = 0; i < res.size(); i++) {
            System.out.println(allQuery.getResultList().get(i).toString());
        }
        session.close();

    }

    public static void viewAllCarsData() {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(CarEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<CarEntity> cq = cb.createQuery(CarEntity.class);
        Root<CarEntity> rootEntry = cq.from(CarEntity.class);
        CriteriaQuery<CarEntity> all = cq.select(rootEntry);
        TypedQuery<CarEntity> allQuery = session.createQuery(all);
        List<CarEntity> res = allQuery.getResultList();
        for (int i = 0; i < res.size(); i++) {
            System.out.println(allQuery.getResultList().get(i).toString());
        }
        session.close();

    }

    public static BikeEntity readBike(long id) {
        BikeEntity bike;
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(BikeEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        bike = session.get(BikeEntity.class, id);
        session.close();
        return bike;


    }

    public static PlaneEntity readPlane(long id) {

        PlaneEntity plane;
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(PlaneEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();


        plane = session.get(PlaneEntity.class, id);
        session.close();
        return plane;


    }

    public static TruckEntity readTruck(long id) {

        TruckEntity truck;
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(TruckEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        truck = session.get(TruckEntity.class, id);
        session.close();
        return truck;
    }

    public static CarEntity readCar(long id) throws NullPointerException {

        CarEntity car;
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(CarEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        car = session.get(CarEntity.class, id);
        session.close();
        return car;
    }

    public static void createBike(BikeEntity bike) {

        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(BikeEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bike);
        transaction.commit();
        session.close();

    }

    public static void createPlane(PlaneEntity plane) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(PlaneEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(plane);
        transaction.commit();
        session.close();
    }

    public static void createTruck(TruckEntity truck) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(TruckEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(truck);
        transaction.commit();
        session.close();
    }

    public static void createCar(CarEntity car) {
        Configuration config = new Configuration().configure("cfg.xml").addAnnotatedClass(CarEntity.class);
        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();
    }
}



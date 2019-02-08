package ats;

import java.awt.geom.Point2D;
import java.time.LocalDate;

public class Auxiliar {

    Company comp = new Company("taxiC", "123");
    Company comp2 = new Company("Uber", "123");

    Point2D.Double x = new Point2D.Double(5, 8);
    Point2D.Double y = new Point2D.Double(0, 8);
    LocalDate l = LocalDate.now();

    Driver d = new Driver("d1@gmail.com", "pedro", "123456", "rua do montinho", l, 0.5, "taxiC");
    Driver d2 = new Driver("d2@gmail.com", "luis", "123456", "rua do montinho", l, 0.5, "taxiC");

    Driver d3 = new Driver("d3@gmail.com", "luis", "123456", "rua do montinho", l, 0.5, null);

    Client c = new Client("c1@gmail.com", "carlos", "123456", "rua santa maria", l);
    Client c2 = new Client("c2@gmail.com", "antonio", "123456", "rua santa maria", l);

    Car car = new Car("1", 0.8, x, "d1@gmail.com");
    Car car2 = new Car("2", 0.8, y, "d2@gmail.com");

    public Auxiliar() {

    }

    public Driver getDriver() {
        return this.d;
    }

    public Client getClient() {
        return this.c;
    }

    public Driver getDriver2() {
        return this.d2;
    }

    public Driver getDriver3() {
        return this.d3;
    }

    public Client getClient2() {
        return this.c2;
    }

    public Car getCar() {
        return this.car;
    }

    public Car getCar2() {
        return this.car2;
    }

    public Company getCompany() {
        return this.comp;
    }

    public Company getCompany2() {
        return this.comp2;
    }

    public Trip getTrip(){
        UMeR umer = new UMeR();
        Point2D.Double x = new Point2D.Double(5, 8);
        Point2D.Double dest = new Point2D.Double(50, 80);
        //Criar
        d.setVehicle("1");
        Vehicle v = new Car("1", 0.5, x, d.getEmail());

        // Registar
        boolean user = umer.registerUser(d, null);
        boolean reg = umer.registerVehicleP(v);
        boolean add = umer.registerUser(c, null);
        Trip t = umer.newTrip(c, d, v, dest);
        return t;
    }

    public UMeR getUmer(){
        Point2D.Double x = new Point2D.Double(5, 8);
        Point2D.Double dest = new Point2D.Double(50, 80);
        //Criar
        UMeR umer = new UMeR();
        d.setVehicle("1");
        Vehicle v = new Car("1", 0.5, x, d.getEmail());

        // Registar
        boolean comp = umer.registerCompany("taxiC","123");
        boolean user = umer.registerUser(d, d.getCompany());
        boolean reg = umer.registerVehicleP(v);
        boolean add = umer.registerUser(c, null);
        Trip t = umer.newTrip(c, d, v, dest);

        umer.addTrip(t.getClient(),t.getDriver(),t.getLicencePlate(),t);
        return umer;



    }
}

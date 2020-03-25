import java.util.ArrayList;

abstract class Vehicle<T extends Person> {
    private int maxSeats;
    private ArrayList<T> passengers;

    public Vehicle(int seats) {
        passengers = new ArrayList<T>();
        maxSeats = seats;
    }

    public int getMaxSeats() {
        return maxSeats;
    }
    public int getOccupiedSeats() {
        return passengers.size();
    }

    public void pickUp(T passenger) throws Exception{
        if (passengers.size() >= maxSeats)
            throw new Exception("all seats are occupied");
        else {
            passengers.add(passenger);
        }
    }
    public void dropOff(T passenger) throws Exception{
        if (!passengers.contains(passenger))
            throw new Exception("this passenger is not here");
        else {
            passengers.remove(passenger);
        }
    }
}

class Bus extends Vehicle {
    public Bus(int seats) {
        super(seats);
    }
}

class Car<T extends Person> extends Vehicle<T> {
    public Car(int seats) { super(seats); }
}

class Taxi extends Car {
    public Taxi(int seats) {
        super(seats);
    }
}

class PoliceCar extends Car<Policeman> {
    public PoliceCar(int seats) {
        super(seats);
    }
}

class FireTruck extends Car<Fireman> {
    public FireTruck(int seats) {
        super(seats);
    }
}
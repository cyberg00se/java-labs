import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BusTest {
    static Bus bus;

    @BeforeEach
    void createBus() {
        bus = new Bus(30);
    }

    @Test
    void pickUp() throws Exception {
        //arrange
        Person person = new Person();
        Policeman policeman = new Policeman();
        Fireman fireman = new Fireman();
        int expectedOccupiedSeats = 3;

        //act
        bus.pickUp(person);
        bus.pickUp(policeman);
        bus.pickUp(fireman);
        int actualOccupiedSeats = bus.getOccupiedSeats();

        //assert
        assertEquals(expectedOccupiedSeats, actualOccupiedSeats);
    }

    @Test
    void dropOff() throws Exception {
        //arrange
        Person person = new Person();
        Policeman policeman = new Policeman();
        Fireman fireman = new Fireman();
        bus.pickUp(person);
        bus.pickUp(policeman);
        bus.pickUp(fireman);
        int expectedOccupiedSeats = 0;

        //act
        bus.dropOff(person);
        bus.dropOff(policeman);
        bus.dropOff(fireman);
        int actualOccupiedSeats = bus.getOccupiedSeats();

        //assert
        assertEquals(expectedOccupiedSeats, actualOccupiedSeats);
    }
}

class TaxiTest {
    static Taxi taxi;

    @BeforeEach
    void createTaxi() {
        taxi = new Taxi(5);
    }

    @Test
    void pickUp() throws Exception {
        //arrange
        Person person = new Person();
        Policeman policeman = new Policeman();
        Fireman fireman = new Fireman();
        int expectedOccupiedSeats = 3;

        //act
        taxi.pickUp(person);
        taxi.pickUp(policeman);
        taxi.pickUp(fireman);
        int actualOccupiedSeats = taxi.getOccupiedSeats();

        //assert
        assertEquals(expectedOccupiedSeats, actualOccupiedSeats);
    }

    @Test
    void dropOff() throws Exception {
        //arrange
        Person person = new Person();
        Policeman policeman = new Policeman();
        Fireman fireman = new Fireman();
        taxi.pickUp(person);
        taxi.pickUp(policeman);
        taxi.pickUp(fireman);
        int expectedOccupiedSeats = 0;

        //act
        taxi.dropOff(person);
        taxi.dropOff(policeman);
        taxi.dropOff(fireman);
        int actualOccupiedSeats = taxi.getOccupiedSeats();

        //assert
        assertEquals(expectedOccupiedSeats, actualOccupiedSeats);
    }
}

class PoliceCarTest {
    static PoliceCar policeCar;

    @BeforeEach
    void createPoliceCar() {
        policeCar = new PoliceCar(5);
    }

    @Test
    void pickUp() throws Exception {
        //arrange
        Policeman policeman1 = new Policeman();
        Policeman policeman2 = new Policeman();
        int expectedOccupiedSeats = 2;

        //act
        policeCar.pickUp(policeman1);
        policeCar.pickUp(policeman2);
        int actualOccupiedSeats = policeCar.getOccupiedSeats();

        //assert
        assertEquals(expectedOccupiedSeats, actualOccupiedSeats);
    }

    @Test
    void dropOff() throws Exception{
        //arrange
        Policeman policeman1 = new Policeman();
        Policeman policeman2 = new Policeman();
        policeCar.pickUp(policeman1);
        policeCar.pickUp(policeman2);
        int expectedOccupiedSeats = 0;

        //act
        policeCar.dropOff(policeman1);
        policeCar.dropOff(policeman2);
        int actualOccupiedSeats = policeCar.getOccupiedSeats();

        //assert
        assertEquals(expectedOccupiedSeats, actualOccupiedSeats);
    }
}

class FireTruckTest {
    static FireTruck fireTruck;

    @BeforeEach
    void createFireTruck() {
        fireTruck = new FireTruck(5);
    }

    @Test
    void pickUp() throws Exception {
        //arrange
        Fireman fireman1 = new Fireman();
        Fireman fireman2 = new Fireman();
        int expectedOccupiedSeats = 2;

        //act
        fireTruck.pickUp(fireman1);
        fireTruck.pickUp(fireman2);
        int actualOccupiedSeats = fireTruck.getOccupiedSeats();

        //assert
        assertEquals(expectedOccupiedSeats, actualOccupiedSeats);
    }

    @Test
    void dropOff() throws Exception{
        //arrange
        Fireman fireman1 = new Fireman();
        Fireman fireman2 = new Fireman();
        fireTruck.pickUp(fireman1);
        fireTruck.pickUp(fireman2);
        int expectedOccupiedSeats = 0;

        //act
        fireTruck.dropOff(fireman1);
        fireTruck.dropOff(fireman2);
        int actualOccupiedSeats = fireTruck.getOccupiedSeats();

        //assert
        assertEquals(expectedOccupiedSeats, actualOccupiedSeats);
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoadTest {

    @Test
    void getCountOfHumans() throws Exception {
        //arrange
        Road road = new Road();

        Bus bus = new Bus(30);
        for(int i = 0; i<15; i++) {
            bus.pickUp(new Person());
        }
        for(int i = 0; i<3; i++) {
            bus.pickUp(new Policeman());
        }
        FireTruck fireTruck = new FireTruck(5);
        for(int i = 0; i<4; i++) {
            fireTruck.pickUp(new Fireman());
        }

        road.addCarToRoad(bus);
        road.addCarToRoad(fireTruck);

        int expectedCountOfHumans = 22;

        //act
        int actualCountOfHumans = road.getCountOfHumans();

        //assert
        assertEquals(expectedCountOfHumans, actualCountOfHumans);
    }
}
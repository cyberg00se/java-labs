import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleExceptionTest {

    @Test()
    public void pickUpExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            //arrange
            Vehicle testVehicle = new Car(5);

            //act
            for (int i = 0; i < 10; i++) {
                testVehicle.pickUp(new Person());
            }
        });

        //assert
        assertEquals("all seats are occupied", exception.getMessage());
    }

    @Test()
    public void dropOffExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            //arrange
            Vehicle testVehicle = new Car(5);
            for (int i = 0; i < 3; i++) {
                testVehicle.pickUp(new Person());
            }
            Person testPerson = new Person();

            //act
            testVehicle.dropOff(testPerson);
        });

        //assert
        assertEquals("this passenger is not here", exception.getMessage());
    }
}

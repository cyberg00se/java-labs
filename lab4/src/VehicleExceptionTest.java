import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class VehicleExceptionTest {

    @Test()
    public void pickUpExceptionTest() {
        try {
            //arrange
            Vehicle testVehicle = new Car(5);

            //act
            for (int i = 0; i < 10; i++) {
                testVehicle.pickUp(new Person());
            }
            fail();
        }
        catch (Exception e) {
            //assert
            assertEquals("all seats are occupied", e.getMessage());
        }
    }

    @Test()
    public void dropOffExceptionTest() {
        try {
            //arrange
            Vehicle testVehicle = new Car(5);
            for (int i = 0; i < 3; i++) {
                testVehicle.pickUp(new Person());
            }
            Person testPerson = new Person();

            //act
            testVehicle.dropOff(testPerson);
            fail();
        }
        catch (Exception e) {
            //assert
            assertEquals("this passenger is not here", e.getMessage());
        }
    }
}

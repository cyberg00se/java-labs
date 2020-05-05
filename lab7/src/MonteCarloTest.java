import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class MonteCarloTest {
    MonteCarlo PI_Calculator;

    @BeforeEach
    void createPI_Calculator() {
        PI_Calculator = new MonteCarlo(8, 1000000);
    }

    @Test
    void calculatePI_Value() throws ExecutionException, InterruptedException {
        //arrange
        double expectedPI = 3.14159;
        double deltaPI = 0.3;

        //act
        double actualPI = PI_Calculator.calculatePI();

        //assert
        assertEquals(expectedPI, actualPI, deltaPI);
    }

    @Test
    void calculatePI_Time() throws ExecutionException, InterruptedException {
        //arrange
        double expectedExecutionTime = 500;
        double deltaExecutionTime = 500;

        //act
        double tempPI = PI_Calculator.calculatePI();
        double actualExecutionTime = PI_Calculator.getLastExecutionTime();

        //assert
        assertEquals(expectedExecutionTime, actualExecutionTime, deltaExecutionTime);
    }
}
package lab1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StringsArrayTest {

    static ArrayList<String> input = new ArrayList<String>();

    @BeforeAll
    static void createObject() {
        input.add("first string");
        input.add("second string");
        input.add("very long string");
        input.add("shortest");
    }

    @Test
    void getAvgLength() {
        //arrange
        double expected = 12.25;

        //act
        double actual = StringsArray.getAvgLength(input);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void getOutputArray() {
        //arrange
        ArrayList<String> expected = new ArrayList<>();
        expected.add("first string");
        expected.add("shortest");

        //act
        ArrayList<String> actual = StringsArray.getOutputArray(input);

        //assert
        assertEquals(expected, actual);
    }
}
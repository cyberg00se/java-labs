package lab2;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Person.class).
                withIgnoredFields("name", "age").
                suppress(Warning.NULL_FIELDS, Warning.NONFINAL_FIELDS).
                verify();
    }

    @Test
    public void testJson() {
        //arrange
        Person testPerson = new Person("testname", 18);
        Person resultPerson;
        boolean expected = true;

        //act
        String tmpJson = Person.ToJson(testPerson);
        resultPerson = Person.FromJson(tmpJson);
        boolean actual = testPerson.equals(resultPerson);

        //assert
        assertEquals(expected, actual);
    }
}
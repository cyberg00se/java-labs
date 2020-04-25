import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.io.*;

class DecryptingFilterReaderTest {

    @Test
    void read() throws IOException {
        //arrange
        char[] charArray = {'i', 'l', 'o', 'w', 'h', 'u'};
        FileWriter out = new FileWriter("path");
        out.write(charArray);
        out.close();

        DecryptingFilterReader in = new DecryptingFilterReader(new FileReader("path"), '#');
        char[] expected = {'F', 'I', 'L', 'T', 'E', 'R'};

        //act
        char[] actual = new char[6];
        in.read(actual);
        in.close();

        //assert
        assertArrayEquals(expected, actual);
    }
}
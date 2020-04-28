import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class EncryptingFilterWriterTest {

    @Test
    void write() throws IOException {
        //arrange
        char[] charArray = {'F', 'I', 'L', 'T', 'E', 'R'};

        EncryptingFilterWriter out = new EncryptingFilterWriter(new FileWriter("path"), '#');
        char[] expected = {'i', 'l', 'o', 'w', 'h', 'u'};

        //act
        out.write(charArray);
        out.close();

        //assert
        FileReader in = new FileReader("path");
        char[] actual = new char[6];
        in.read(actual);

        assertArrayEquals(expected, actual);
    }
}
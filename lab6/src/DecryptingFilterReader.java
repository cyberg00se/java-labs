import java.io.*;

class DecryptingFilterReader extends FilterReader {
    private char key;

    public DecryptingFilterReader(Reader in, char key) {
        super(in);
        this.key = key;
    }

    public char getKey() {
        return key;
    }
    public void setKey(char key) {
        this.key = key;
    }

    @Override
    public int read(char[] output) throws IOException {
        int temp = super.read(output);
        for(int i = 0; i < output.length; i++) {
            output[i] = decrypt(output[i]);
        }
        return temp;
    }

    private char decrypt(char input) {
        return (char) ((input - key + 128) % 128);
    }
}

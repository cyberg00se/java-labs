import java.io.*;

class EncryptingFilterWriter extends FilterWriter {
    private char key;

    public EncryptingFilterWriter(Writer out, char key) {
        super(out);
        this.key = key;
    }

    public char getKey() {
        return key;
    }
    public void setKey(char key) {
        this.key = key;
    }

    @Override
    public void write(char[] input) throws IOException {
        for(int i = 0; i < input.length; i++) {
            input[i] = encrypt(input[i]);
        }
        super.write(input);
    }

    private char encrypt(char input) {
        return (char) ((input + key) % 128);
    }
}

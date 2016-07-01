package de.exxcellent.java9.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

public class InputStreamExample {

    /**
     * Stream utilities.
     */
    public static void main(String[] args) throws IOException {
        // 128 random bytes
        byte[] buf = new byte[128];
        new Random().nextBytes(buf);

        // All bytes from an InputStream at once
        byte[] result = new ByteArrayInputStream(buf).readAllBytes();

        // Directly redirect an InputStream to an OutputStream
        new ByteArrayInputStream(buf).transferTo(System.out);
    }

}
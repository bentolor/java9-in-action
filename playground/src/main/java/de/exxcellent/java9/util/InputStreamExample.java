package de.exxcellent.java9.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

public class InputStreamExample {

    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[128];
        new Random().nextBytes(buf);
        byte[] result = new ByteArrayInputStream(buf).readAllBytes(); // All bytes from an InputStream, yeah :D

        new ByteArrayInputStream(buf).transferTo(System.out); // Directly transferring from InputStream to OutputStream
    }

}
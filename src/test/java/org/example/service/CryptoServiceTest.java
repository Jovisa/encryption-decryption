package org.example.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CryptoServiceTest {

    @Test
    public void serviceDecodesTheMessageAndReturnsResult() {
        CryptoService service = new CryptoService();
        String result = service.run("-alg", "shift",
                "-mode", "dec",
                "-key", "10",
                "-data", "dbokcebo");


        Assertions.assertEquals("treasure", result);
    }

    @Test
    public void serviceEncodesMessageAndWritesItToFile() throws IOException {
        CryptoService service = new CryptoService();
        String OUTPUT_FILE_NAME = "output.txt";
        String result = service.run("-alg", "unicode",
                "-mode", "enc",
                "-key", "5",
                "-data", "Welcome to hyperskill!",
                "-out", OUTPUT_FILE_NAME);

        Assertions.assertNull(result);

        Path path = Paths.get(OUTPUT_FILE_NAME);
        String encodedMessage = Files.readString(path, StandardCharsets.UTF_8);

        Assertions.assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", encodedMessage);

    }

    @Test
    public void unicodeCryptographerDecodesMessage() {
        CryptoService service = new CryptoService();
        String result = service.run("-alg", "unicode",
                "-mode", "dec",
                "-key", "5",
                "-data", "\\jqhtrj%yt%m~ujwxpnqq&");


        Assertions.assertEquals("Welcome to hyperskill!", result);
    }


    @Test
    public void shiftCriptographerEncodesMessage() {
        CryptoService service = new CryptoService();
        String result = service.run("-alg", "shift",
                "-mode", "enc",
                "-key", "10",
                "-data", "treasure");


        Assertions.assertEquals("dbokcebo", result);
    }

}

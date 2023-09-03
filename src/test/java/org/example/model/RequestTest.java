package org.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class RequestTest {

    @Test
    public void requestCreatedProperlyFromCliArgs() {
        Request request = new Request("-alg", "shift",
                "-mode", "dec",
                "-key", "10",
                "-data", "dbokcebo");

        Assertions.assertEquals("shift", request.getAlgorithm());
        Assertions.assertEquals("dec", request.getOperation());
        Assertions.assertEquals(10, request.getKey());
        Assertions.assertEquals("dbokcebo", request.getData());
    }

    @Test
    public void requestReadsDataFromInputFile() throws IOException {
        final String INPUT_FILE_NAME = "input.txt";
        final String DATA = "\\jqhtrj%yt%m~ujwxpnqq&";

        FileWriter writer = new FileWriter(INPUT_FILE_NAME);
        writer.write(DATA);
        writer.close();

        Request request = new Request("-alg", "unicode",
                "-mode", "dec",
                "-key", "5",
                "-in", INPUT_FILE_NAME);

        Assertions.assertEquals(DATA, request.getData());
    }
}

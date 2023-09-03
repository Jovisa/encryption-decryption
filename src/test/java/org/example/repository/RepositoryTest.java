package org.example.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RepositoryTest {

    @Test
    public void readDataFromFileTest() throws IOException {
        final String INPUT_FILE_NAME = "input.txt";
        final String DATA = "\\jqhtrj%yt%m~ujwxpnqq&";

        FileWriter writer = new FileWriter(INPUT_FILE_NAME);
        writer.write(DATA);
        writer.close();

        String dataReadFromFile = Repository.readDataFromFile(INPUT_FILE_NAME);

        Assertions.assertEquals(DATA, dataReadFromFile);
    }

    @Test
    public void fileDoesntExistsTest() {
        final String WRONG_INPUT_FILE_NAME = "bla.txt";
        String dataReadFromFile = Repository.readDataFromFile(WRONG_INPUT_FILE_NAME);

        Assertions.assertEquals("", dataReadFromFile);
    }

    @Test
    public void writeDataToFileText() throws IOException {
        final String OUTPUT_FILE_NAME = "output.txt";
        final String DATA = "example data";

        Repository.writeDataToFile(OUTPUT_FILE_NAME, DATA);

        Path path = Paths.get(OUTPUT_FILE_NAME);
        String dataWrittenToFile = Files.readString(path, StandardCharsets.UTF_8);

        Assertions.assertEquals(DATA, dataWrittenToFile);
    }
}

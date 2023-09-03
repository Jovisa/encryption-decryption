package org.example.repository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Repository {

    public static String readDataFromFile(String fileName) {
        try {
            Path path = Paths.get(fileName);
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Error while reading file");
        }
        return "";
    }

    public static void writeDataToFile(String fileName, String data) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Error while writing the data to a file");
        }
    }
}

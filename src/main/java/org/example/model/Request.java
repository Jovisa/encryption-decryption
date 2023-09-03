package org.example.model;

import org.example.repository.Repository;

import java.util.HashMap;
import java.util.Map;

import static org.example.util.Constants.*;
import static org.example.util.Constants.DEFAULT_KEY;

public class Request {
    private final String algorithm;
    private final String operation;
    private final String data;
    private final int key;
    private final String outputFileName;

    public Request(String ... args) {
        Map<String, String> cliArgsMap = transformToMap(args);

        this.algorithm = cliArgsMap.getOrDefault(ALGORITHM, SHIFT);
        this.operation = cliArgsMap.getOrDefault(MODE, ENCRYPTION);
        this.data = readData(cliArgsMap);
        this.key = Integer.parseInt(cliArgsMap.getOrDefault(KEY, DEFAULT_KEY));
        this.outputFileName = cliArgsMap.get(OUTPUT_FILE);
    }

    private Map<String, String> transformToMap(String[] args) {
        Map<String, String> request = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                request.put(args[i], args[i + 1]);
            }
        }
        return request;
    }

    private String readData(Map<String, String> commands) {
        String inputFile = commands.get(INPUT_FILE);
        return inputFile == null
                ? commands.getOrDefault(DATA, DEFAULT_DATA)
                : Repository.readDataFromFile(inputFile);
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public String getOperation() {
        return operation;
    }

    public String getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    public String getOutputFileName() {
        return outputFileName;
    }
}

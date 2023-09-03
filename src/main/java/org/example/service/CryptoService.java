package org.example.service;

import org.example.crypto.Cryptographer;
import org.example.crypto.CryptographerFactory;
import org.example.model.Request;
import org.example.repository.Repository;

public class CryptoService {
    public String run(String ... args) {
        Request request = new Request(args);

        Cryptographer cryptographer = CryptographerFactory.createCryptographer(request.getAlgorithm());
        String processedData = cryptographer.processData(
                request.getData(),
                request.getKey(),
                request.getOperation()
        );

        if (request.getOutputFileName() == null) {
            return processedData;
        }

        Repository.writeDataToFile(request.getOutputFileName(), processedData);
        return null;
    }

}

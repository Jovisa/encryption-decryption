package org.example.crypto;

import static org.example.util.Constants.UNICODE;

public class CryptographerFactory {
    public static Cryptographer createCryptographer(String algorithm) {
       return UNICODE.equals(algorithm)
               ? new UnicodeCryptographer()
               : new ShiftCryptographer();
    }
}

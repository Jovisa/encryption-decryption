package org.example.crypto;

import static org.example.util.Constants.ENCRYPTION;

public class UnicodeCryptographer extends Cryptographer{
    @Override
    protected char processCharacter(char character, int key, String mode) {
        return ENCRYPTION.equals(mode)
                ? (char) (character + key)
                : (char) (character - key);
    }
}

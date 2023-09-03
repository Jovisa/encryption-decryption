package org.example.crypto;

import static org.example.util.Constants.ENCRYPTION;
import static org.example.util.Constants.NUMBER_OF_LETTERS;

public class ShiftCryptographer extends Cryptographer{

    @Override
    protected char processCharacter(char character, int key, String mode) {
        if (!Character.isLetter(character)) {
            return character;
        }

        int firstLetter = getFirstLetter(character);
        int letterOffset = getLetterOffset(character, firstLetter);

        return ENCRYPTION.equals(mode)
                ? encode(firstLetter, letterOffset, key)
                : decode(firstLetter, letterOffset, key);
    }

    private char encode(int firstLetter, int letterOffset, int key) {
        return (char) (firstLetter + ( letterOffset + key) % NUMBER_OF_LETTERS);
    }

    private char decode(int firstLetter, int letterOffset, int key) {
        return (char) (firstLetter + (NUMBER_OF_LETTERS + letterOffset - key) % NUMBER_OF_LETTERS);
    }

    private int getFirstLetter(char character) {
        return Character.isLowerCase(character) ? 'a' : 'A';
    }

    private int getLetterOffset(char character, int firstLetter) {
        return (int) character - firstLetter;
    }

}



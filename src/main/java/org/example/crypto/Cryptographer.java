package org.example.crypto;


public abstract class Cryptographer {
    public String processData(String text, int key, String mode) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            char processedChar = processCharacter(character, key, mode);
            builder.append(processedChar);
        }

        return builder.toString();
    }

    protected abstract char processCharacter(char character, int key, String mode);

}

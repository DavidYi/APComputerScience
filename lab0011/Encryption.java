package lab0011;

/**
 * Created by David on 11/16/2015.
 */
public class Encryption {//use separate file to run like EncryptionRunner.java

    public String encrypt(int key, String text) {
        int newLetter, originalLetter;
        String encrypted = "";

        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            originalLetter = text.charAt(i);

            newLetter = ((originalLetter + key) - 65) % 26 + 65;

            key += originalLetter;
            encrypted = encrypted + Character.toString((char) newLetter);
        }

        return encrypted;
    }

    public String decrypt(int key, String text) {
        int newLetter, originalLetter;
        String decrypted = "";

        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            originalLetter = text.charAt(i);

            newLetter = ((originalLetter - key) % 26 + 65) % 26 + 65;
            decrypted = decrypted + Character.toString((char) newLetter);

            key += newLetter;
        }

        return decrypted;
    }

}

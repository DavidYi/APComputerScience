package lab0100;

/**
 * Created by David on 12/2/2015.
 */
public class EncryptionV2 {//Same as Encryption except the use of mods (remainder operation)

    public String encrypt(int key, String text) {
        int newLetter, originalLetter;
        String encrypted = "";

        for (int i = 0; i < text.length(); i++) {
            originalLetter = text.charAt(i);

            newLetter = ((originalLetter + key) - 32) % 95 + 32;

            key += originalLetter;
            encrypted = encrypted + Character.toString((char) newLetter);
        }

        return encrypted;
    }

    public String decrypt(int key, String text) {
        int newLetter, originalLetter;
        String decrypted = "";

        newLetter = text.charAt(0) - key;
        decrypted = decrypted + Character.toString((char) newLetter);
        key += newLetter;

        for (int i = 0; i < text.length(); i++) {
            originalLetter = text.charAt(i);

            newLetter = (((originalLetter - key) % 95) + 95) % 95 + 32;
            if (i >  0){
                decrypted = decrypted + Character.toString((char) newLetter);
            }
            key += newLetter;
        }

        return decrypted;
    }

}

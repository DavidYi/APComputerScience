package lab0011;

/**
 * Created by David on 11/16/2015.
 */
public class EncryptionRunner {//used this to test Encryption

    public static void main(String[] args) {
        Encryption enigma = new Encryption();
        System.out.println(enigma.encrypt (1, "HELL0BOY"));
        System.out.println(enigma.decrypt (1, "IZXVWKLW") + "\n");

        System.out.println(enigma.encrypt (14, "ARGUMENT"));
        System.out.println(enigma.decrypt (14, "OSLSRIIO") + "\n");

        System.out.println(enigma.encrypt(7, "AARDVARK"));
        System.out.println(enigma.decrypt(7, "HUYOWJNK") + "\n");

        System.out.println(enigma.encrypt(9, "PROGRAMS"));
        System.out.println(enigma.decrypt(9, "YCDWANMR") + "\n");

        System.out.println(enigma.encrypt(11, "ZOOPHYTE"));
        System.out.println(enigma.decrypt(11, "KLMOITZQ") + "\n");

        System.out.println(enigma.encrypt(11, "EATS EGG"));
        System.out.println(enigma.decrypt(11, "PCINTKDW") + "\n");

    }

}

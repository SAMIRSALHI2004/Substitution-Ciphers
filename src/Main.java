//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //ceaser cipher
        System.out.println("the encription message  with caesar cipher is "+ CaesarCipher.encryption("hello world"));
        System.out.println("the decription message  with caesar cipher is "+ CaesarCipher.decryption("khoorczruog"));
       //shift cipher
        System.out.println("the encription message  with shift cipher is "+  ShiftCipher.encryption("hello world",4));
        System.out.println("the decription message  with shift cipher is "+  ShiftCipher.decryption("lippsd.svph",4));
        //Affine Cipher
        int a = 4;
        int b = 6;

        if (AffineCipher.gcd(a, 28) != 1) {
            System.out.println("The value of 'a' must be coprime with 28!");

        }
        String message = "hello world.";

        String encrypted = AffineCipher.encryption(message, a, b);
        String decrypted = AffineCipher.decryption(encrypted, a, b);

        System.out.println("Original Message:  " + message);
        System.out.println("Encrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + decrypted);

    }
}
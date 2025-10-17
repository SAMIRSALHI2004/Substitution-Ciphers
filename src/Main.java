import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
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
        int a = 5;
        int b = 6;

        if (AffineCipher.gcd(a, 28) != 1) {
            System.out.println("The value of 'a' must be coprime with 28!");

        }
        String message = "hello world.";

        String encrypted = AffineCipher.encryption(message, a, b);
        String decrypted = AffineCipher.decryption(encrypted, a, b);

        System.out.println("Original Message:  " + message);
        System.out.println("the encription message  with affine cipher is : " + encrypted);
        System.out.println("the decription message  with affine cipher is : " + decrypted);
        //frquency analysis
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get("src/shift.txt")));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
        Object[] result = FrequencyAnalysis.sortByFrequency(text);

        char[] symbols = (char[]) result[0];
        int[] freq = (int[]) result[1];

        System.out.println("Symbol | Frequency");
        for (int i = 0; i < symbols.length; i++) {
            if (freq[i] > 0) {
                if (symbols[i] == ' ')
                    System.out.println("[space]" + " | " + freq[i]);
                else
                    System.out.println(symbols[i] + "      | " + freq[i]);
            }
        }
        int key = (symbols[0]-'e')%28;
        if (key < 0){
            key+=28;
        }
        System.out.println("the key used  for get the encripted message in shift.txt is "+ key);
        System.out.println("the decription of content in file shift.txt is : "+ShiftCipher.decryption(text ,key));
//        Vigenère Cipher
        System.out.println("the encription message  with vigenere cipher is "+  VigenèreCipher.encryption("hello world","samir"));
        System.out.println("the decription message  with vigenere cipher is "+  VigenèreCipher.decryption("zextdrw.zav","samir"));

    }
}
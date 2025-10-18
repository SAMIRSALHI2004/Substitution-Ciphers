import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        //frquency analysis on shift cipher
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
        //frequency analysis on  affine cipher
        String text2 = "";
        try {
            text2 = new String(Files.readAllBytes(Paths.get("src/affine.txt")));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
        Object[] result2 = FrequencyAnalysis.sortByFrequency(text2);

        char[] symbols2 = (char[]) result2[0];
        int[] freq2 = (int[]) result2[1];

        System.out.println("Symbol | Frequency");
        for (int i = 0; i < symbols2.length; i++) {
            if (freq2[i] > 0) {
                if (symbols2[i] == ' ')
                    System.out.println("[space]" + " | " + freq2[i]);
                else
                    System.out.println(symbols2[i] + "      | " + freq2[i]);
            }
        }


        try {
            int[] keyaffine = AffineCipher.affinekey(symbols2[0], symbols2[2], 'e', 't');
            System.out.println("The key in affine cipher is a=" + keyaffine[0] + ", b=" + keyaffine[1]);

            System.out.println("the decripted of cipher text affter defind the key of encription is " + AffineCipher.decryption(text2,keyaffine[0],keyaffine[1]));

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

//        Vigenère Cipher
        System.out.println("the encription message  with vigenere cipher is "+  VigenèreCipher.encryption("hello world","cyber"));

        System.out.println("the decription message  with vigenere cipher is "+  VigenèreCipher.decryption("jampdbspvaf","cyber"));
        String unknounKey  = VigenèreCipher.generateUnknounKey("hello world","jampdbspvaf");

        System.out.println("generate unknoun key from cipher text and plain text "+ VigenèreCipher.findPattern(unknounKey));




    }
}
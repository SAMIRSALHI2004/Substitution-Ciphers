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


    }
}
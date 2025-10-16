public class CaesarCipher {
    static String alpha ="abcdefghijklmnopqrstuvwxyz. ";
    public static String encryption(String message){
        String cypherText ="";
        for (int i = 0; i < message.length(); i++) {
            int charPositon = alpha.indexOf(message.charAt(i));
            int newPosition = (charPositon+3)%alpha.length();
            char newChar = alpha.charAt(newPosition);
            cypherText+=newChar;

        }
        return cypherText;
    };
    public static String decryption(String message){
        String plainText ="";
        for (int i = 0; i < message.length(); i++) {
            int charPositon = alpha.indexOf(message.charAt(i));
            int newPosition = (charPositon-3)%alpha.length();
            if(newPosition < 0){
                newPosition+=alpha.length();
            }
            char newChar = alpha.charAt(newPosition);
            plainText+=newChar;
        }
        return plainText;
    };
    public static void main(String[] args) {

    }
}

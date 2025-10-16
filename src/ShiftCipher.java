public class ShiftCipher {
    static String alpha ="abcdefghijklmnopqrstuvwxyz. ";
    public static String encryption(String message,int key){
        String cypherText ="";
        for (int i = 0; i < message.length(); i++) {
            int charPositon = alpha.indexOf(message.charAt(i));
            int newPosition = (charPositon+key)%alpha.length();
            char newChar = alpha.charAt(newPosition);
            cypherText+=newChar;

        }
        return cypherText;
    };
    public static String decryption(String message,int key){
        String plainText ="";
        for (int i = 0; i < message.length(); i++) {
            int charPositon = alpha.indexOf(message.charAt(i));
            int newPosition = (charPositon-key)%alpha.length();
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

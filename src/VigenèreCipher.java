public class VigenèreCipher {
    public static String generateKey(String plain, String key) {
        int x = plain.length();
        int d = 0;
        int j = key.length();

        while (key.length() < x) {
            key += key.charAt(d);
            d++;
            if (d == j) {
                d = 0;
            }
        }

        return key;
    }
    static String alpha ="abcdefghijklmnopqrstuvwxyz. ";
    public static String encryption(String message,String key){
        String cypherText ="";
        String generatedKey = generateKey(message,key);
        for (int i = 0; i < message.length(); i++) {
            int charPositon = alpha.indexOf(message.charAt(i));
            int newPosition = (charPositon+ alpha.indexOf(generatedKey.charAt(i)))%alpha.length();
            char newChar = alpha.charAt(newPosition);
            cypherText+=newChar;

        }
        return cypherText;
    };
    public static String decryption(String message,String key){
        String plainText ="";
        String generatedKey = generateKey(message,key);

        for (int i = 0; i < message.length(); i++) {
            int charPositon = alpha.indexOf(message.charAt(i));
            int newPosition = (charPositon-alpha.indexOf(generatedKey.charAt(i)))%alpha.length();
            if(newPosition < 0){
                newPosition+=alpha.length();
            }
            char newChar = alpha.charAt(newPosition);
            plainText+=newChar;
        }
        return plainText;
    };
}

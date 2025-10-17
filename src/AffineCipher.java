public class AffineCipher {
    static String alpha ="abcdefghijklmnopqrstuvwxyz. ";
    public static int gcd(int a, int b) {
        while (b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }

    public static int modInverse(int a) {
        int b = alpha.length();
        int u0 = 1, u1 = 0;
        int v0 = 0, v1 = 1;

        int a0 = a, b0 = b;

        if (gcd(a, b) != 1) {
            System.out.println("No modular inverse exists for " + a + " mod " + b + "because gcd ≠ 1");

            return 0;
        }

        while (b != 0) {
            int q = a / b;
            int r = a % b;
            a = b;
            b = r;

            int tempU = u0 - q * u1;
            u0 = u1;
            u1 = tempU;
        }

        if (u0 < 0) {
            u0 += b0;
        }

        return u0;
    }
    public static String encryption(String message,int a,int b){
        if (gcd(a,alpha.length()) != 1){
            String k = "No modular inverse exists for " + a + " mod " + alpha.length() + "because gcd ≠ 1 so cant encrypt the message";
            return k;
        }
        String cypherText ="";
        for (int i = 0; i < message.length(); i++) {
            int charPositon = alpha.indexOf(message.charAt(i));
            int newPosition = (a*charPositon+b)%alpha.length();
            char newChar = alpha.charAt(newPosition);
            cypherText+=newChar;

        }
        return cypherText;
    };
    public static String decryption(String message,int a,int b){
        if (gcd(a,alpha.length()) != 1){
            String k = "No modular inverse exists for " + a + " mod " + alpha.length() + "because gcd ≠ 1 we cant decript the message because  cant encrypt the message";
            return k;
        }
        String plainText ="";
        for (int i = 0; i < message.length(); i++) {
            int charPositon = alpha.indexOf(message.charAt(i));
            int newPosition = modInverse(a)*(charPositon-b)%alpha.length();
            if(newPosition < 0){
                newPosition+=alpha.length();
            }
            char newChar = alpha.charAt(newPosition);
            plainText+=newChar;
        }
        return plainText;
    };

    public static void  affinekey (int a,int b,String messsage) {


    }

    public static void main(String[] args) {

    }
}

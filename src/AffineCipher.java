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

            int t = u0 - q * u1;
            u0 = u1;
            u1 = t;
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
            String k = "No modular inverse exists for " + a + " mod " + alpha.length() + " because gcd ≠ 1 we cant decript the message because  cant encrypt the message";
            return k;
        }
        String plainText ="";
        for (int i = 0; i < message.length(); i++) {
            int charPositon = alpha.indexOf(message.charAt(i));
            int newPosition = (modInverse(a) * ((charPositon - b + alpha.length()) % alpha.length())) % alpha.length();
            if(newPosition < 0) newPosition += alpha.length();
            char newChar = alpha.charAt(newPosition);
            plainText+=newChar;
        }
        return plainText;
    };

    public static int []  affinekey (char C1,char C2,char P1,char P2) throws Exception {
        int c1 = alpha.indexOf(C1);
        int c2 = alpha.indexOf(C2);
        int p1 = alpha.indexOf(P1);
        int p2 = alpha.indexOf(P2);
        int pDiff = (p2 - p1 + alpha.length()) % alpha.length();
        int cDiff = (c2 - c1 + alpha.length()) % alpha.length();

        int a = (cDiff * modInverse(pDiff)) % alpha.length();

        int b = (c1 - a * p1) % alpha.length();
        if (b < 0) b += alpha.length();
        if (gcd(a,alpha.length()) != 1) {
            throw new Exception("a is invalid because gcd(" + a + "," + alpha.length() + ") != 1, cannot find inverse");
        }

        return new int[]{a,b};
    }

    public static void main(String[] args) {

    }
}

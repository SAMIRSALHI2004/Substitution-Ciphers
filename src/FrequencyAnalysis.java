public class FrequencyAnalysis {


    static String alpha = "abcdefghijklmnopqrstuvwxyz. ";

    static Object[] sortByFrequency(String text) {
        int[] freq = new int[alpha.length()];

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = alpha.indexOf(c);
            if (index != -1) {
                freq[index]++;
            }
        }

        char[] symbols = alpha.toCharArray();

        for (int i = 0; i < symbols.length; i++) {
            for (int j = i + 1; j < symbols.length; j++) {
                if (freq[j] > freq[i]) {
                    int tempFreq = freq[i];
                    freq[i] = freq[j];
                    freq[j] = tempFreq;

                    char tempSymbol = symbols[i];
                    symbols[i] = symbols[j];
                    symbols[j] = tempSymbol;
                }
            }
        }

        return new Object[]{symbols, freq};
    }

    public static void main(String[] args) {

    }
}

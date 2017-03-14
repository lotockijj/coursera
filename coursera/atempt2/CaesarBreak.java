package coursera.coursera.atempt2;

/**
 * Created by Роман Лотоцький on 19.12.2016.
 */
public class CaesarBreak {

    String submessage1 = "", submessage2 = "";

    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    private String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                if(i % 2 == 0) {
                    encrypted.setCharAt(i, shiftedAlphabet1.charAt(idx));
                }
                if(i % 2 != 0){
                    encrypted.setCharAt(i, shiftedAlphabet2.charAt(idx));
                }
            }
        }
        return encrypted.toString();
    }

    private void split(String message){
        for (int i = 0; i < message.length(); i +=2 ) {
            submessage1 = submessage1 + message.charAt(i);
        }
        for (int i = 1; i < message.length(); i +=2 ) {
            submessage2 = submessage2 + message.charAt(i);
        }
        System.out.println(submessage1 + "\n" + submessage2);
    }

    private int[] countLetters(String message) {
        String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[52];
        for(int i = 0; i < message.length(); i++){
            char ch = message.charAt(i);
            int dex = alph.indexOf(ch);
            if(dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }

    public int decryptKey(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        final int IND_E = 4;
        int key = maxDex - IND_E;
        if (key<0) return key + 26;
        else return key;
    }

    private int maxIndex(int[] freqs) {
        int maxIndex = 0;
        for(int i = 0; i < freqs.length; i++){
            if(maxIndex < freqs[i]){
                maxIndex = freqs[i];
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        CaesarBreak c = new CaesarBreak();
        String encrypted = c.encryptTwoKeys("eeeeeeeeeeeeeeeeeees", 2, 15);
        System.out.println(encrypted);

        c.split(encrypted);

        int key1 = c.decryptKey(c.submessage1);
        int key2 = c.decryptKey(c.submessage2);

        String s = c.encryptTwoKeys(encrypted, key1, key2);
        System.out.println(s);
    }
}

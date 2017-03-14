package coursera;

/**
 * Created by Роман Лотоцький on 13.12.2016.
 */
public class Encrypt {

    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "abcdefghijklmnopqrstuvwxyz"; /*ABCDEFGHIJKLMNOPQRSTUVWXYZ*/
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        System.out.println(shiftedAlphabet);
        for (int i = 0; i < encrypted.length(); i++) {
            char currentChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currentChar);
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    public String testCeaser(String message){
        int key = 15;
        //String message = "A SOUP IS GOOD!!!Z: a soup is good!!!z || Hip Hip Hura-y-y-y...";
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        //String decrypted = encrypt(encrypted, 52 - key );
        //String decrypted = encrypt(encrypted, 26 - key);
        //System.out.println(decrypted);
        return encrypted;
    }

    public String decrypted(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return encrypt(encrypted, 26 - dkey);
    }

    private int maxIndex(int[] freqs) {
        int maxIndex = 0;
        for(int i = 0; i < freqs.length; i++){
            if(maxIndex < freqs[i]){
                maxIndex = freqs[i];
            }
        }
        System.out.println(maxIndex);
        return maxIndex;
    }

    private int[] countLetters(String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i = 0; i < message.length(); i++){
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alph.indexOf(ch);
            if(dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
        System.out.println(message);
        Encrypt encrypt = new Encrypt();
        //encrypt.testCeaser(message);
        System.out.println("Result: " + encrypt.testCeaser(message));
        //System.out.println(encrypt.decrypted(encrypt.testCeaser(message)));
    }
}

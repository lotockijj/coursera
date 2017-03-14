package coursera;

/**
 * Created by Роман Лотоцький on 19.12.2016.
 */
public class DecryptedWithTwoKeys {

    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "abcdefghijklmnopqrstuvwxyz"; /*ABCDEFGHIJKLMNOPQRSTUVWXYZ*/
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
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

    public String decrypted(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        System.out.println(dkey);
        return encrypt(encrypted, 26 - dkey);
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
        String message = "eeeeeeeeeeeeeeeees";
        System.out.println(message);
       DecryptedWithTwoKeys d = new DecryptedWithTwoKeys();
        System.out.println(d.encrypt(message, 18));
        System.out.println(d.decrypted(d.encrypt(message, 18)));
    }
}

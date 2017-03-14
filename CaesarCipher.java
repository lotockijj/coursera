package coursera;

/**
 * Created by Роман Лотоцький on 13.12.2016.
 */
public class CaesarCipher {

    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        for (int i = 0; i < encrypted.length(); i++) {
            char currentChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currentChar);
            if(idx != -1){
                if(i%2 == 0) {
                    char newChar = shiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                } else {
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }

    public void testCeaser(){
        int key = 8;
        int key2 = 21;
        //String message = "A SOUP IS GOOD!!!Z: a soup is good!!!z || Hip Hip Hura-y-y-y...";
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String encrypted = encryptTwoKeys(message, key, key2);
        System.out.println(encrypted);
        String decrypted = encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx", 52 - 2, 52 - 20 );
        //String decrypted = encrypt(encrypted, 26 - key);
        System.out.println(decrypted);
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher = new CaesarCipher();
        caesarCipher.testCeaser();
    }
}

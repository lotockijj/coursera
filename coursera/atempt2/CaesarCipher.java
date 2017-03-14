package coursera.coursera.atempt2;

/**
 * Created by Роман Лотоцький on 19.12.2016.
 */
public class CaesarCipher {

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

    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1){
                if(i % 2 != 0) {
                    encrypted.setCharAt(i, shiftedAlphabet1.charAt(idx));
                }
                if(i % 2 == 0){
                    encrypted.setCharAt(i, shiftedAlphabet2.charAt(idx));
                }
            }
        }
        return encrypted.toString();
    }

    private void testCaesar(String message, int key){
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 52 - key);
        System.out.println(decrypted);
    }

    private void testCaesarTwoKeys(String message, int key1, int key2){
        String encrypted = encryptTwoKeys(message, key1, key2);
        System.out.println(encrypted);
        String decrypted = encryptTwoKeys(encrypted, 52 - key1, 52 - key2);
        System.out.println(decrypted);
    }


    public static void main(String[] args) {
        CaesarCipher c = new CaesarCipher();
       // c.testCaesar("An awesome program. Happy NEW YEARS!!!", 6);
        //c.testCaesar("At noon be in the conference room" +
        //        " with your hat on for a surprise party. YELL LOUD!", 15);
        System.out.println(c.encryptTwoKeys("Hfs cpwewloj" +
                " loks cd Hoto kyg Cyy.", 52-14, 52-24));
       // c.testCaesarTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.", 52-14, 52-24);
    }
}

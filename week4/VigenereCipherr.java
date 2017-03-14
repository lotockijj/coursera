package coursera.week4;

import java.util.Arrays;

/**
 * Created by Роман Лотоцький on 03.01.2017.
 */
public class VigenereCipherr {

    CeasarCipher[] ciphers;

    public VigenereCipherr(int[] key){
        ciphers = new CeasarCipher[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new CeasarCipher(key[i]);
        }
    }

    public String encrypt(String input){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char c : input.toCharArray()){
            int cipherIndex = i%ciphers.length;
            CeasarCipher thisCeasarCiphter = new CeasarCipher(cipherIndex);
            sb.append(thisCeasarCiphter.encryptLetter(Character.toString(c)));
            i++;
        }
        return sb.toString();
    }

    public String dencrypt(String input){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(char c : input.toCharArray()){
            int cipherIndex = i%ciphers.length;
            CeasarCipher thisCeasarCiphter = new CeasarCipher(cipherIndex);
            sb.append(thisCeasarCiphter.encryptLetter(Character.toString(c)));
            i++;
        }
        return sb.toString();
    }

    public String toString() {
        return Arrays.toString(ciphers);
    }


}

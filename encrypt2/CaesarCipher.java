package coursera.encrypt2;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

/**
 * Created by Роман Лотоцький on 03.01.2017.
 */
public class CaesarCipher {

    public String encrypt(String input, int key){
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)
                + alphabet.substring(0, key);
        for (int i = 0; i < encrypted.length(); i++) {
            char currentChar = encrypted.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currentChar));
            if(idx != -1){
                char newChar = shiftedAlphabet.charAt(idx);
                if(isLowerCase(currentChar)){
                    encrypted.setCharAt(i, Character.toLowerCase(newChar));
                } else{
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        return encrypted.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder sb = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        char newChar = '\u0000';
        System.out.println(newChar);
        for(int i = 0; i < sb.length(); i++){
            char currentChar = sb.charAt(i);
            int idx = alphabet.indexOf(Character.toUpperCase(currentChar));
            if(idx != -1) {
                if (i == 0 || i % 2 == 0) {
                    newChar = shiftAlphabet1.charAt(idx);
                }
                if(i % 2 == 1) {
                    newChar = shiftAlphabet2.charAt(idx);
                }
                if(isLowerCase(currentChar)){
                    sb.setCharAt(i, Character.toLowerCase(newChar));
                } else{
                    sb.setCharAt(i, newChar);
                }
            }
        }
        return sb.toString();
    }

    public int[] countLetters(String message){
        String alpabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); i++) {
            char ch = Character.toLowerCase(message.charAt(i));
            int dex = alpabet.indexOf(ch);
            if(dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
    }

    public int maxIndex(int[] counts){
        int max = 0;
        for (int i = 0; i < counts.length; i++) {
            if(counts[max] < counts[i]){
                max = i;
            }
        }
        return max;
    }

    public String decrypt(String encrypted){
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return encrypt(encrypted, 26 - dkey);
    }

    public String  halfOfString(String message, int start){
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < message.length(); i += 2) {
            sb.append(message.charAt(i));
        }
        return sb.toString();
    }

    public int getKey(String s){
        int[] counts = countLetters(s);
        int maxDex = maxIndex(counts);
        int dkey = maxDex - 4;
        if(maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }

    public String decryptTwoKeys(String encrypted){
        String firstCharacters = halfOfString(encrypted, 0);
        String secondCharactes = halfOfString(encrypted, 1);
        int dkey1 = getKey(firstCharacters);
        int dkey2 = getKey(secondCharactes);
        System.out.println("Key 1 is: " + dkey1 + ". Key 2 is: " + dkey2);
        String firstDecrypted = encrypt(firstCharacters, 26 - dkey1);
        String secondDecrypted = encrypt(secondCharactes, 26 - dkey2);
        String compaund = compaundTwos(firstDecrypted, secondDecrypted);
        return compaund;
    }

    private String compaundTwos(String firstDecrypted, String secondDecrypted) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < firstDecrypted.length(); i++) {
            sb.append(firstDecrypted.charAt(i));
            if(i < secondDecrypted.length()){
                sb.append(secondDecrypted.charAt(i));
            }
        }
        return sb.toString();
    }

//    public String[] split(String message){
//        String[] result = new String[2];
//        StringBuilder sb1 = new StringBuilder("");
//        StringBuilder sb2 = new StringBuilder("");
//        for (int i = 0; i < message.length(); i++) {
//            if(i == 0 || i % 2 == 0){
//                sb1.append(message.charAt(i));
//            }
//            if(i % 2 == 1){
//                sb2.append(message.charAt(i));
//            }
//        }
//        result[0] = sb1.toString();
//        result[1] = sb2.toString();
//        return result;
//    }
}

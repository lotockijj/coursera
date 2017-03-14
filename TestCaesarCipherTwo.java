package coursera;

/**
 * Created by Роман Лотоцький on 19.12.2016.
 */
public class TestCaesarCipherTwo {
    public int [] countLetters(String message) {
        int [] counters = new int [26];
        for (int i = 0; i < 26; i++) {
            counters[i] = 0;
        }
        System.out.println(counters);
        String alph = "abcdefghijklmnopqrstuvwxyz";
        message = message.toLowerCase();
        for (int i = 0; i < message.length(); i++) {
            int position = alph.indexOf(message.charAt(i));
            if (position != -1) counters[position] += 1;
        }

        return counters;
    }

    public int maxIndex(int [] counters) {
        int maxcounter = 0;
        int maxposition = 0;
        for (int i = 0; i < counters.length; i++) {
            if (maxcounter < counters[i]) {
                maxposition = i;
                maxcounter = counters[i];
            }
        }
        return maxposition;
    }

    public String halfOfString(String message, int start) {
        String result = new String();
        for (int i = start; i < message.length(); i = i+2) {
            result = result + message.charAt(i);
        }
        return result;
    }

    public int getKey(String s) {
        int [] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex-4;
        if (dkey < 0) dkey = 26 - (4 - maxDex);
        return dkey;
    }

    public void simpleTests() {
        String message = "eeeeeeeeeeeeeeeeeeeeeeees";
        CaesarCipher2 cc = new CaesarCipher2(17,3);
        String encrypted = cc.encrypt(message);
        System.out.println("Encrypted message: "+encrypted);

        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted message: "+decrypted);

        breakCaesarCipher(encrypted);
    }

    public void breakCaesarCipher(String input) {
        String part_1 = halfOfString(input, 0);
        String part_2 = halfOfString(input, 1);
        int dkey2 = getKey(part_2);
        int dkey1 = getKey(part_1);
        dkey1 = 20;
        dkey2 = 2;
        System.out.println("The two keys are " + dkey1 + " and " + dkey2);
        CaesarCipher2 cc = new CaesarCipher2(26-dkey1,26-dkey2);
        System.out.println("Decrypted message: "+cc.decrypt(input));
    }

    public static void main(String[] args) {
        TestCaesarCipherTwo t = new TestCaesarCipherTwo();
        t.breakCaesarCipher("Top ncmy qkff vi vguv vbg ycpx");
    }
}
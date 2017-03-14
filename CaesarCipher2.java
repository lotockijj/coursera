package coursera;

/**
 * Created by Роман Лотоцький on 19.12.2016.
 */
public class CaesarCipher2 {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;

    public CaesarCipher2(int key1, int key2) {
        mainKey1 = key1;
        mainKey2 = key2;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1, 26) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2, 26) + alphabet.substring(0, key2);
    }

    public String encrypt(String input) {
        int n = input.length();
        String newinput1 = new String();
        String newinput2 = new String();
        String newinput = new String();

        for (int i = 0; i < n; i= i + 2) {
            int position = alphabet.indexOf(input.substring(i, i + 1));
            if (position == -1) {
                position = alphabet.toLowerCase().indexOf(input.substring(i, i + 1));
                if (position > -1) newinput1 = newinput1 + shiftedAlphabet1.substring(position, position+1).toLowerCase();
                else newinput1 = newinput1 + input.substring(i, i + 1);
            }
            else if (position > -1) newinput1 = newinput1 + shiftedAlphabet2.substring(position, position+1);
        }

        for (int i = 1; i < n; i= i + 2) {
            int position = alphabet.indexOf(input.substring(i, i + 1));
            if (position == -1) {
                position = alphabet.toLowerCase().indexOf(input.substring(i, i + 1));
                if (position > -1) newinput2 = newinput2 + shiftedAlphabet1.substring(position, position+1).toLowerCase();
                else newinput2 = newinput2 + input.substring(i, i + 1);
            }
            else if (position > -1) newinput2 = newinput2 + shiftedAlphabet2.substring(position, position+1);
        }

        int n1 = newinput1.length();
        int n2 = newinput2.length();

        if (n1 > n2) {
            for (int i = 0; i < n2; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
            newinput = newinput + newinput1.substring(n1-1, n1);
        }

        if (n1 == n2) {
            for (int i = 0; i < n2; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
        }

        if (n1 < n2) {
            for (int i = 0; i < n1; i++) {
                newinput = newinput + newinput1.substring(i, i+1);
                newinput = newinput + newinput2.substring(i, i+1);
            }
            newinput = newinput + newinput2.substring(n2-1, n2);
        }

        return(newinput);

    }


    public String decrypt(String input) {
        CaesarCipher2 cc = new CaesarCipher2(26-mainKey1, 26-mainKey2);
        return(cc.encrypt(input));
    }
}
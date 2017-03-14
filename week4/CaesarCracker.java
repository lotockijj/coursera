package coursera.week4;

/**
 * Created by Роман Лотоцький on 02.01.2017.
 */
public class CaesarCracker {

    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private char mostCChar;

    public CaesarCracker() {
        mostCChar = 'e';
    }

    public CaesarCracker(char c) {
        mostCChar = c;
    }

    public int getKey(String msg){
        //count letters in msg
        int[] counts = countLetters(msg);
        //find intex of highest count
        int indOfMax = maxIndex(counts);
        //find&return shift
        final int IND_E = 4;
        int key = indOfMax - IND_E;
        if (key < 0) return key + 26;
        else return key;
    }

    public int maxIndex(int[] vals) {
        int indOfMax = 0;
        int maxSoFar = vals[0];
        for (int i = 1; i < vals.length; i++) {
            if (vals[i] > maxSoFar) {
                maxSoFar = vals[i];
                indOfMax = i;
            }
        }
        return indOfMax;
    }

    public int[] countLetters(String msg) {
        int[] counts = new int[26];
        for (char c : msg.toCharArray()) {
            char cuc = Character.toUpperCase(c);
            if (Character.isAlphabetic(cuc)) counts[ALPHABET.indexOf(cuc)]++;
        }
        return counts;
    }
}

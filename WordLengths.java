package coursera;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Роман Лотоцький on 17.12.2016.
 */
public class WordLengths {

    public int[] countWordLengths(String path, int[] counts) throws IOException {
        Path fPath = Paths.get(path);
        Scanner scanner = new Scanner(fPath, "UTF8");
        Scanner scanner2;
        while (scanner.hasNextLine()){
            scanner2 = new Scanner(scanner.next());
            while(scanner2.hasNext()) {
                String s = scanner2.next();
                int wordLength = 0;
                for (int i = 0; i < s.length(); i++) {
                    if(Character.isAlphabetic(s.charAt(i)) || s.charAt(i) == 45){
                        wordLength += 1;
                    }
                }
                counts[wordLength] += 1;
            }
        }
        System.out.println(indexOfMax(counts));
        return counts;
    }

    private int  indexOfMax(int[] counts){
        int maxValues = 0;
        for (int i = 0; i < counts.length; i++) {
            if(maxValues < counts[i]){
                maxValues = i;
            }
        }
        return maxValues - 1;
    }

    public static void main(String[] args) throws IOException {
        WordLengths wordLengths = new WordLengths();
        int[] counts = new int[30];
        counts = wordLengths.countWordLengths("caesar.txt", counts);
        for (int i = 1; i < counts.length; i++) {
            System.out.println(i + ". " + counts[i]);
        }
    }
}

package coursera.week2;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Роман Лотоцький on 20.12.2016.
 */
public class WordFrequencies {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFregs;

    public WordFrequencies() {
        myWords = new ArrayList<>();
        myFregs = new ArrayList<>();
    }

    public void findUnique() throws IOException {
        FileResource resourse = new FileResource();
        for (String s : resourse.words("new2.txt")) {
            s = s.toLowerCase();
            int myIndex = myWords.indexOf(s);
            if (myIndex == -1) {
                myWords.add(s);
                myFregs.add(1);
            } else {
                int value = myFregs.get(myIndex);
                myFregs.set(myIndex, value + 1);
            }
        }
    }

    public void tester() throws IOException {
        findUnique();
        System.out.println("#unique words : " + myWords);
        System.out.println("Number of unique words: " + myWords.size() + ". ");
        for (int i = 0; i < myWords.size(); i++) {
            System.out.println(myFregs.get(i) + "\t" + myWords.get(i));
        }
        int indexOfMax = findIndexOfMax();
        System.out.println("Index of max: " + (indexOfMax + 1) );
        System.out.println("The word that occurs the most often is: "
                + myWords.get(indexOfMax) + " " +  myFregs.get(indexOfMax));
    }

    public int findIndexOfMax(){
        int maxIndex = 0;
        int n = 0;
        for (int i = 0; i < myFregs.size() ; i++) {
            if( maxIndex < myFregs.get(i)){
                maxIndex = myFregs.get(i);
                n = i;
            }
        }

        return n;
    }

    public static void main(String[] args) throws IOException {
        WordFrequencies wF = new WordFrequencies();
        wF.tester();
    }
}


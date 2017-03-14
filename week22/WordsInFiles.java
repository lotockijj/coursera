package coursera.week22;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Роман Лотоцький on 22.12.2016.
 */
public class WordsInFiles {

    HashMap<String, ArrayList<String>> map;

    public WordsInFiles(){
        map = initializeMapTxtFiles();
    }

    private HashMap<String,ArrayList<String>> initializeMapTxtFiles() {
        return new HashMap<>();
    }

    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f.toString());
        String name = f.getName();

        for (String word: fr.words()) {
            if(!map.containsKey(word)){
                map.put(word, new ArrayList<>());
                map.get(word).add(name);
            }
            else {
                if(map.containsKey(word)){
                    if(!map.get(word).contains(name)){
                        map.get(word).add(name);
                    }
                }
            }
        }
    }

    private void buildWordFileMap(){
        map.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f: dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }

    private int maxNumber(){
        int current = 0;
        int largest = 0;

        for(String word: map.keySet()){
            current = map.get(word).size();
            if(largest < current){
                largest = current;
            }
        }
        return largest;
    }

    private ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> words = new ArrayList<>();
        for (String word: map.keySet()) {
            if(map.get(word).size() == number){
                words.add(word);
            }
        }
        return words;
    }

    private void printFilesIn(String word) {
        System.out.println("The files contain "+word+" are(is): \t");
        ArrayList<String> list = new ArrayList<String>();
        for (String current: map.keySet()) {
            if (current.equals(word)) list = map.get(current);
        }
        for (int k = 0; k < list.size(); k++) {
            System.out.println(list.get(k)+"\t");
        }
    }

    public void test(){
        buildWordFileMap();
        int max = maxNumber();
        ArrayList<String> list = wordsInNumFiles(max);
        System.out.println("The greatest number of files a word appears in is "
        + max + ", and the are " + list.size() + " such words: ");
        for(int k = 4; k < 5; k++){
            System.out.println("size() " + list.size() );
        }
        //System.out.println("\t");
        for (int i = 0; i < list.size(); i++) {
           // printFileIn(list.get(i));
        }
    }


    public static void main(String[] args) {
        WordsInFiles w = new WordsInFiles();
        w.test();
        w.printFilesIn("tree");
    }
}

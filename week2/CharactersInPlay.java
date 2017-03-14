package coursera.week2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Роман Лотоцький on 20.12.2016.
 */
public class CharactersInPlay {

    ArrayList<String> foundNames;
    ArrayList<Integer> countCharacter;
    ArrayList<String> s;

    protected CharactersInPlay(){
        foundNames = new ArrayList<String>();
        countCharacter = new ArrayList<Integer>();
    }

    public void update(String person){
        int myIndex = foundNames.indexOf(person);
        if(myIndex == -1){
            foundNames.add(person);
            countCharacter.add(1);
        } else {
            int value = countCharacter.get(myIndex);
            countCharacter.set(myIndex, value + 1);
        }
    }

    public void findAllCharacters() throws IOException {
        //FileResource file = new FileResource();
        processLine("new2.txt");//file.words("romeo.txt");
        for (String line : s) {
            int periodInLine = line.indexOf(".");
            if(periodInLine != -1){
                String possibleName = line.substring(0, periodInLine);
                update(possibleName);
            }
        }
    }

    private void processLine(String file) {
        Path fPath = Paths.get(file);
        try( Scanner scanner = new Scanner(fPath, "UTF8")) {
            s = new ArrayList<>();
            while (scanner.hasNextLine()) {
                //System.out.println(scanner.nextLine());
                s.add(scanner.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void tester() throws IOException {
        findAllCharacters();
        int index = findMax();
        for (int i = 0; i < foundNames.size(); i++) {
            System.out.println(foundNames.get(i) + " " + countCharacter.get(i));
        }
        System.out.println("Character with most speaking parts: " + foundNames.get(index) +
                " " + countCharacter.get(index) + "\n");
        charactersWithNumParts(10, 15);
    }

    public void charactersWithNumParts(int num1, int num2){
        for (int i = 0; i < foundNames.size(); i++) {
            if(num1 < countCharacter.get(i) && countCharacter.get(i) < num2) {
                System.out.println(foundNames.get(i));
            }
        }
    }

    public int findMax(){
        int max = countCharacter.get(0);
        int maxIndex = 0;
        for(int k=0; k < countCharacter.size(); k++){
            if (countCharacter.get(k) > max){
                max = countCharacter.get(k);
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) throws IOException {
        CharactersInPlay c = new CharactersInPlay();
        c.tester();
    }
}

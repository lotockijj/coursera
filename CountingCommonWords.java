package coursera;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Роман Лотоцький on 17.12.2016.
 */
public class CountingCommonWords {

    void countShakespeare()throws IOException{
        String[] plays = {"caesar.txt"};
        String[] common = getCommon();
        int[] counts = new int[common.length];
        for(int k = 0; k < plays.length; k++){
            Path fPath = Paths.get(plays[k]);
            countWords(fPath, common, counts);
            System.out.println("done with " + plays[k]);
        }
        for(int k = 0; k < common.length; k++){
            System.out.println(common[k] + "\t" + counts[k]);
        }
    }


    private void countWords(Path fPath, String[] common, int[] counts)
        throws IOException{
        String[] sss = words(fPath);
        for(String word : sss){
            word = word.toLowerCase();
            int index = indexOf(common, word);
            if(index != -1){
                counts[index] += 1;
            }
        }
    }

    private int indexOf(String[] list, String word) {
        for (int i = 0; i < list.length; i++) {
             if(list[i].equals(word)){
                 return i;
             }
        }
        return -1;
    }

    private String[] getCommon() throws IOException{
        Path fPath = Paths.get("common.txt");
        String[] common = new String[31];
        int index = 0;
        String[] sss = words(fPath);
        for(String s : sss){
            common[index] = s;
            index += 1;
        }
        return common;
    }

    private String[] words(Path fPath) throws IOException{
        Scanner scanner = new Scanner(fPath, "UTF8");
        Scanner scanner2;
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()){
            scanner2 = new Scanner(scanner.next());
            while(scanner2.hasNext()) {
                list.add(scanner2.nextLine());
            }
        }
        String[] s = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            s[i] = list.get(i);
        }

        return s;
    }

    private void createFile() {
        File file = new File("caesar.txt");
        File file2 = new File("common.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
            if(file2.createNewFile()){
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        CountingCommonWords count = new CountingCommonWords();
        //count.createFile();
        count.countShakespeare();
    }

}

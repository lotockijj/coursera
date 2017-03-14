package coursera.week2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Роман Лотоцький on 20.12.2016.
 */
public class FileResource {

    String[] s;

    public FileResource(String source) {
    }

    public FileResource() {

    }

    private void createFile(String myFile) {

    }

    public String[] words(String file){
        createFile(file);
        Path fPath = Paths.get(file);
        System.out.println(fPath);
        try( Scanner scanner = new Scanner(fPath, "UTF8")) {
            List<String> list = new ArrayList<>();
            while (scanner.hasNext()) {
                try ( Scanner scanner2 = new Scanner(scanner.next())){
                    while (scanner2.hasNext()) {
                        list.add(scanner2.next());
                    }
                }
            }
            s = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                s[i] = list.get(i);
            }
        } catch (IOException e){
            System.out.println(e + "\n" + fPath);
        }
        return s;
    }


    public String[] words() {
        return null;
    }

    public String[] lines() {
        return null;
    }
}

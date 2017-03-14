package coursera.week2;

import java.util.ArrayList;

/**
 * Created by Роман Лотоцький on 20.12.2016.
 */
public class StoregeResource {

    private ArrayList<String> words;

    public StoregeResource(){
        words = new ArrayList<>();
    }


    public String[] data() {
        String[] list = new String[words.size()];
        for (int i = 0; i < list.length; i++) {
            list[i] = words.get(i);
        }
        return list;
    }

    public void clear() {
        words.removeAll(words);
    }

    public void add(String s) {
        words.add(s);
    }

    public int size() {
        return words.size();
    }
}

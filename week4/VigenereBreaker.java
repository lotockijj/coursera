package coursera.week4;

import coursera.week44.VigenereCipher;
import edu.duke.FileResource;

import java.util.HashSet;

/**
 * Created by Роман Лотоцький on 03.01.2017.
 */
public class VigenereBreaker {

    CaesarCracker crackers;
    HashSet<String> set;

    public VigenereBreaker(){
        set = new HashSet<>();
        FileResource fr = new FileResource("common.txt");
        for (String w: fr.lines()) {
            set.add(w);
        }
    }

    public String sliceString(String message, int whichSlice, int totalSlices){
        StringBuilder sb = new StringBuilder();
        for(int i = whichSlice; i < message.length(); i += totalSlices){
            sb.append(message.substring(i, i + 1));
        }
        return sb.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon){
        crackers=new CaesarCracker();
        int[] s= new int[klength];

        for(int i=0;i<klength;i++){
            s[i]=crackers.getKey(sliceString(encrypted,i,klength));
        }
        return s;
    }

    public int  countWords(String message){
        int count = 0;
        String[] array = message.split("\\W+");
        for (int i = 0; i < array.length; i++) {
            if(set.contains(array[i].toLowerCase())){
                count++;
            }
        }
        return count;
    }

    public String breakForLanguage(String encrypted){
        int largestCount = 0;
        String encr = null;
        for (int i = 2; i < 100; i++) {
            int[] keyLen = tryKeyLength(encrypted, i, 'e');
            VigenereCipherr vc = new VigenereCipherr(keyLen);
            int countWords = countWords(vc.dencrypt(encrypted));
            if(countWords > largestCount){
                largestCount = countWords;
                encr = vc.dencrypt(encrypted);
            }
        }
        return encr;
    }

}

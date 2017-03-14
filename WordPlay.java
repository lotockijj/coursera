package coursera;

/**
 * Created by Роман Лотоцький on 13.12.2016.
 */
public class WordPlay {

    public boolean isVowel(char ch){
        if(     ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ){
            return true;
        } else {
            return false;
        }
    }

    public String replaceVowels(String phrase, char ch){
        for (int i = 0; i < phrase.length(); i++) {
            if(isVowel(phrase.charAt(i))){
                phrase =   phrase.replace(phrase.charAt(i), ch);
            }
        }
        return phrase;
    }

    public String emphasize(String phrase, char ch){
        StringBuilder stringBuilder = new StringBuilder(phrase);
        String emphasizePhrase = "";
        for (int i = 0; i < phrase.length(); i++) {
            if(     phrase.charAt(i) == Character.toUpperCase(ch) ||
                    phrase.charAt(i) == Character.toLowerCase(ch)){
                if(i%2 == 0){
                    emphasizePhrase = emphasizePhrase + "*";
                } else {
                    emphasizePhrase = emphasizePhrase + "+";
                }
            } else {
                emphasizePhrase = emphasizePhrase + phrase.charAt(i);
            }
        }
        return emphasizePhrase;
    }
    public static void main(String[] args) {
        WordPlay wordPlay = new WordPlay();
        //System.out.println(wordPlay.isVowel('b'));
        //System.out.println(wordPlay.replaceVowels("Testing last time this method", '*'));
        System.out.println(wordPlay.emphasize("dna ctgaaactga", 'a'));
    }
}

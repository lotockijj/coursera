package coursera.coursera.atempt2;

/**
 * Created by Роман Лотоцький on 19.12.2016.
 */
public class CaesarBreaker {
    final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Count occurancies of letters in string.
     * @param   msg String for which number of letters is to be calculated
     * @return  int array containing frequencie of letters
     */
    public int[] countLetters (String msg) {
        int[] counts = new int[26];
        for (char c : msg.toCharArray()) {
            char cuc = Character.toUpperCase(c);
            if (Character.isAlphabetic(cuc)) counts[ALPHABET.indexOf(cuc)]++;
        }

        return counts;
    }

    /**
     * Find index of max value in array.
     * @param   vals    array of ints to be checked.
     * @return  index of max value in ints array
     */
    public int maxIndex(int[] vals) {

        int indOfMax = 0;
        int maxSoFar = vals[0];

        for (int i=1;i<vals.length;i++){

            if (vals[i]>maxSoFar) {
                maxSoFar = vals[i];
                indOfMax = i;
            }
        }

        return indOfMax;
    }
    /**
     * Decrypt Caesar Cipher with a given key.
     * @param   msg String to be decrypted
     * @param   key key for decrypting.
     * @return  decrypted msg
     */
    public String decrypt(String msg, int key) {

        StringBuilder sb = new StringBuilder(msg);

        for (int i=0; i< sb.length(); i++) {
            char decrypted = decrypt(sb.charAt(i), key);
            sb.setCharAt(i, decrypted);
        }

        return sb.toString();
    }

    /**
     * Helper function for decrypting single character with key.
     * Decrypts letters only, returning non letters as is.
     * @param   ch  character to be decrypted
     * @param   key to be used in decrypting
     * @return  uppercase or lowercase decrypted character
     */
    private char decrypt(char ch, int key) {
        char chUC = Character.toUpperCase(ch);
        int cind = ALPHABET.indexOf(chUC);
        // do not decrypt non letters
        if (cind == -1) return ch;

        // index of decrypted character
        int dind = (cind - key) % 26;

        // java can return negative from modulo:
        if (dind <0) dind+=26;

        // decrypted uppercase character
        char dch = ALPHABET.charAt(dind);

        // check original case and return decrypted char
        if (Character.isUpperCase(ch)) return dch;
        else return Character.toLowerCase(dch);
    }


    /**
     * Method for finding encryption key, based on most common occurences of letter
     * in encrypted msg, assuming that it represents 'e';
     * @param   msg encrypted string for which key is to be found
     * @return  encryption key for msg
     */
    public int getKey(String msg) {
        //count letters in msg
        int[] counts = countLetters(msg);
        //find intex of highest count
        int indOfMax = maxIndex(counts);
        //find&return shift
        final int IND_E = 4;
        int key = indOfMax - IND_E;
        if (key<0) return key+26;
        else return key;

    }

    /**
     * Method for decrypting meg, encrypted with one key.
     * @param   encrypted string to be decrypted
     * @return  decrypted msg with key guessed
     */
    public String decryptOneKey(String encrypted) {

        return decrypt(encrypted, getKey(encrypted));

    }

    /**
     * This method should return a new String that is every
     * other character from message starting with the start position.
     * @param message   string to be split in half
     * @param   start   starting point to begin splitting
     * @return  string containing every other letter from input
     */
    public String halfOfString(String message, int start) {

        StringBuilder sb = new StringBuilder();

        for (int i=start;i<message.length();i+=2) sb.append(message.charAt(i));

        return sb.toString();

    }

    /**
     * Helper function for merging string split with halfOfString
     * @param   s0  substring starting from index 0
     * @param   s1  substring starting from index 1
     * @return  original string split with halfOfString
     */
    public String mix(String s0, String s1) {

        StringBuilder sb = new StringBuilder(s0+s1);

        //put s0 to place
        for (int i=0;i<s0.length();i++) {
            sb.setCharAt(2*i, s0.charAt(i));
        }
        //put s1 to place
        for (int i=0;i<s1.length();i++) {
            sb.setCharAt(2*i+1, s1.charAt(i));
        }
        return sb.toString();

    }

    /**
     * This method attempts to determine the two keys used to encrypt the message,
     * prints the two keys, and then returns the decrypted String with those two keys.
     * @param   encrypted   string encrypted with encryptTwoKeys
     * @return  decrypted string
     */
    public String decryptTwoKeys(String encrypted) {
        String s0 = halfOfString(encrypted, 0);
        String s1 = halfOfString(encrypted, 1);

        System.out.printf("key1: %d\tkey2: %d\n", getKey(s0), getKey(s1));

        String dec0 = decryptOneKey(s0);
        String dec1 = decryptOneKey(s1);

        return mix(dec0, dec1);
    }

    /**
     * Decrypt text encrypted with two keys.
     * @param   encrypted   text to be decrypted
     * @param   key0    first encryption key
     * @param   key1    second encryption key
     * @return  string decrypted using provided keys
     */
    public String decrypt(String encrypted, int key0, int key1) {

        String s0 = halfOfString(encrypted, 0);
        String s1 = halfOfString(encrypted, 1);

        String dec0 = decrypt(s0, key0);
        String dec1 = decrypt(s1, key1);

        return mix(dec0, dec1);

    }

    public String decryptFileTwoKeys() {
        return decryptTwoKeys("Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin\n" +
                "\n" +
                "Sei sw klv deec lrpcqrvbw sw fyi jytgvwj yej sivr jiyzxwyc tscprffvrxzsew edsek hzjwiiiex kisltj nmklzr xyi hvtrvkqvrk, azxy iijirvtl kisltj zr sklvv hvtrvkqvrkw ek Uybi, nmkl sklvv mewkmkykij, eeh azxy zruyjxic. Rw av dsmi mexf klv zrwsiqrxzse rkv, xyi jfglw sw jgziegv zw wymwxzrx wvfq xyi hzwtsmiic sw ein zrwsiqrxzse ks xyi gfqgykekmfrrpcc mexvrjmmi xrwb fj tistijwzrx rru rrrppdzrx zrwsiqrxzse.\n" +
                "\n" +
                "Ni lrzv fykwkeehzrx gvfkiedw me xifqvximt tsdtlxzrx; mexvveik jcjxvqj, rvxnsiozrx, eeh wvglvzxp; fzscsxmtec tsdtlxzrx; qvqfvp jcjxvqj rru dejwzzv ueke qrrrkvqvrk; eeh pveirzrx rru dsuicmek. Klv iijirvtl mexvvvwkw sw fyi wetycxp fzvvceg nmkl xyiji eiirw eeh azxy iijirvtlvv eiirw me fxyii umjgztcmeij jytl ej smfpfkp, iekzrviimek, eeeskitlescsxc, rru vrmmiseqvrkec jgziegvw.\n" +
                "\n" +
                "GJ Uigx Tysks Av rpjs hf nsio me r eydfvv sw fxyii zqgsixrrk rvvej zrtplhzrx tsdtlxvv kieglzgj rru mmjyrpzdrxzse, wvrjsi eikafvbw, eydiimtec rrrppwzw, jswxneii iekzrviimek, tsdtciomkc xyifvp, eeh vfffxzgj.\n" +
                "\n" +
                "Klv uigeixdiex mj rvxyrfcc yemhyv zr xyi wpqsmfwzw xyek vbzwkw fvxnivr xyi iuytekmfr kislt eeh xyi vvwveigy wetycxp. Xyi wprvvxc fvxnivr xyid yej sivr e ovc xf klv jytgvwj zr gfrkmeyrpcc vvjfvdmek xyi glvimtycyd rru zrkixvrxzrx iijirvtl eeh iuytekmfr. Klv uigeixdiex mj lwzrx r uyrp egtisrgy ks gfqsmei vvwveigy rru vhlgrxzse. Fimekzrx iijirvtl mexf klv tyivzglplq mj klv sijx arc xf kvrme jxlhvrkw esslx xyi qfwk rhmeegvh xvgyrfpfkp rru ks hzwjidmeeki xyi prxvwk uimicsgqvrkw sw tsdtlxzrx kitlescsxc me jstmvxp.\n" +
                "\n" +
                "TW Hvtk Glfxf Ni iegfyiexi yehvvxvrhleki wkyuiexj ks kvx mezfpmiu nmkl sekfmek qrnfv vvwveigy gvfnvgkw xyvfyxl xyi G-WLVW gvfkied, yehvvxvrhleki xyijij, Vvwveigy Vbgiimvrti jfv Yehvvxvrhlekij (VVY) jygtfvk, mehvtvruiex wkyumvw, vxt. Wfqv fj slv iogvtkmfrrp jzvjx qrnfvj xvrhleki azxy umjxzrtxzse, aymtl mezfpmij r jmxrzjzgrrk iijirvtl gfqgseiex, rru zr qrrp tejij klv iijirvtl lrw vvwlpkiu zr tlfcmtekmfrj zr pveumek gfrwiiiegvw.\n" +
                "\n" +
                "Xyi idmeiegv fj slv vvwveigy rru kirgymek jrglpkc mj klv smxkvwk jxiiekkl sw klv uigeixdiex. Deec jrglpkc qvqsiiw lrzv sivr vvgfkemqiu sskl ek lrzzvvjmkc eeh rrxzseec cimicw jfv xyizv iogvpciegv zr vvwveigy, iuytekmfr, rru jiizzgv. Lzkypp mmjmspv, qlpkmumjgztcmeeic tisaitxj rvv sizrx tsehlgkiu, wgsewfvvh fp meimfyj wyehzrx rkvrtmvw.\n" +
                "\n" +
                "Xyi hvtrvkqvrk gvfzzhvw ee vbkvvqvpp jxzqlprxzrx, tisuytxzzv, eeh jimvrupp vrmmiseqvrk zr xyi jfvd fj gcejwisfq, fjwmti, rru ces jtrgv; gfqgykmek mejiejxiytxlvv; xvetlzrx jygtfvk; eeh kieuyrxv wicpfajlztj rru rwjmjxrrkwymgw. Zx ieespvw jrglpkc eeh wkyuiexj ks etgfqgpzwy klvmi wycp tfxvrkmrp. Klv uigeixdiex mj tsewkvlgkiu ks iegfyiexi merfzrxzzv tscprffvrxzsew edsek xyi wtmvrtij, iekzrviimek, vrmmiseqvrkec jxlhzij, eeh qvhzgzrv.");
    }

    public static void main(String[] args) {
        CaesarBreaker c = new CaesarBreaker();
        System.out.println(c.decryptFileTwoKeys());
    }

}
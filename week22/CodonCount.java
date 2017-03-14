package coursera.week22;

import edu.duke.FileResource;

import java.util.HashMap;
import java.util.jar.Pack200;

/**
 * Created by Роман Лотоцький on 22.12.2016.
 */
public class CodonCount {

    HashMap<String, Integer> codonsDNA;

    public CodonCount(){
        codonsDNA = new HashMap<>();
    }

    private void buildCodonMap(int start, String dna){
        codonsDNA.clear();
        String current;
        for (int i = 0; i < (dna.length() - start)/3; i++) {
            current = dna.substring(start+i*3, start+i*3+3);
            if (!codonsDNA.containsKey(current)) codonsDNA.put(current, 1);
            else codonsDNA.put(current, codonsDNA.get(current)+1);
        }
    }

    private String getMostCommonCodon(){
        int maxValue = 0;
        String s = "";
        for (String n: codonsDNA.keySet()) {
            if(maxValue < codonsDNA.get(n)){
                maxValue = codonsDNA.get(n);
                s = n;
            }
        }
        return s;
    }

    private void printCodonCounts(int start, int end){
        for (String n: codonsDNA.keySet()) {
            if(start <= codonsDNA.get(n) && codonsDNA.get(n) <= end){
                System.out.println(n + "\t" + codonsDNA.get(n));
            }
        }
    }

    private void tester(){
        //FileResource fr = new FileResource();
        //String dna = fr.asString().trim();
        //dna = dna.toUpperCase();
        String dna = "CAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAAC" +
                "ATACAACCTTTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACAT" +
                "ACAACCTTTAAAAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATAC" +
                "AAACTTTAAAAGGAAGAAATCTAACATACAACCTTTAAAAGGAAGAAATCGCAC" +
                "CAGCCCAGAATCAACTGCATAACATACAAACTTTAAAAGGAAGAAATCCAACCT" +
                "TTAAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTT" +
                "AAAAGGAAGAAATCGCAGCAGCCCAGAACCAACTGCATAACATACAACCTTTAA" +
                "AAGGAAGAAATCGCACCAGCCCAGAATCAACTGCATAACATACAAACTTTAAAA" +
                "GGAAGAAATC";
        //String dna = "CGTTCAAGTTCAA";

        int start = 7;
        int end = 7;

        buildCodonMap(0, dna);
        System.out.println("Reading frame starting with 0 results in "+codonsDNA.size()+" unique codons"+"\t");
        String largest = getMostCommonCodon();
        System.out.println("Most common codon is "+largest+" with count "+codonsDNA.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(1, dna);
        System.out.println("Reading frame starting with 1 results in "+codonsDNA.size()+" unique codons"+"\t");
        largest = getMostCommonCodon();
        System.out.println("Most common codon is "+largest+" with count "+codonsDNA.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

        buildCodonMap(2, dna);
        System.out.println("Reading frame starting with 2 results in "+codonsDNA.size()+" unique codons"+"\t");
        largest = getMostCommonCodon();
        System.out.println("Most common codon is "+largest+" with count "+codonsDNA.get(largest)+"\t");
        System.out.println("Counts of codons between "+start+" and "+end+" inclusive are:"+"\t");
        printCodonCounts(start, end);

    }

    public static void main(String[] args) {
        CodonCount c = new CodonCount();
        c.tester();

    }
}

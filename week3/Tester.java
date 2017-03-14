package coursera.week3;

import java.util.ArrayList;

/**
 * Created by Роман Лотоцький on 27.12.2016.
 */
public class Tester {

    private void testUniqueIP(){
        LogAnalyzer logAnalyzer = new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        int uniqueIPs = logAnalyzer.countUniqueIPs();
        System.out.println("Number of unique IPs is: " + uniqueIPs);
    }

    private void printAllHigherThanNum(int num){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        la.printAllHigherThanNum(num);
    }

    private void printStringSomeDay(String someday){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        ArrayList<String> s = la.uniqueIPVisitsOneDay(someday);
        System.out.println(s.size());
    }

    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.testUniqueIP();
        //tester.printAllHigherThanNum(302);
        System.out.println("\n");
        tester.printStringSomeDay("Mar 17");
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("short-test_log");
        System.out.println(la.countUniqueIPsInRange(200,299));
    }
}

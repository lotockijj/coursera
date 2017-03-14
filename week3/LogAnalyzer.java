package coursera.week3;

import edu.duke.FileResource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Роман Лотоцький on 26.12.2016.
 */
public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<>();
    }

    public void readFile(String fileName){
        FileResource fr = new FileResource(fileName.toString());
        for (String line: fr.lines()) {
            records.add(WebLogParser.parseEntry(line));
        }
    }

    private void printAll(){
        for (LogEntry log: records) {
            System.out.println(log);
        }
    }

    public int countUniqueIPs(){
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for(LogEntry le: records){
            if(!uniqueIPs.contains(le.getIpAddress())){
                uniqueIPs.add(le.getIpAddress());
            }
        }
        return uniqueIPs.size();
    }

    public void printAllHigherThanNum(int num){
        for (LogEntry le: records) {
            if(le.getStatusCode() > num){
                System.out.println(le);
            }
        }
    }

    // return unique Ips that visited that day.
    public ArrayList<String> uniqueIPVisitsOneDay(String someday) {
        ArrayList<String> uniqueip = new ArrayList<>();
        for (LogEntry le:records) {
            String whole = le.getAccessTime().toString();
            String date = whole.substring(8, 10);
            String month = whole.substring(4, 7);
            if (someday.substring(0,3).equals(month) && someday.substring(4,6).equals(date)) {
                String ip = le.getIpAddress();
                if (!uniqueip.contains(ip)) uniqueip.add(ip);
            }
        }
        return uniqueip;
    }

    public int countUniqueIPsInRange(int low, int high){
        int numberOfUniqueIPs = 0;
        ArrayList<String> uniqueIPs = new ArrayList<>();
        for (LogEntry le: records) {
            if(low <= le.getStatusCode() && le.getStatusCode() <= high){
                String ip = le.getIpAddress();
                if(!uniqueIPs.contains(ip)){
                    uniqueIPs.add(ip);
                }
            }
        }
        return uniqueIPs.size();
    }

    public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> counts = new HashMap<>();
        for (LogEntry le: records) {
            String ip = le.getIpAddress();
            if(!counts.containsKey(ip)){
                counts.put(ip, 1);
            }
            else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        return counts;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> ipToTimes){
        int max = 0;
        for (String ip: ipToTimes.keySet()) {
            if(ipToTimes.get(ip) > max){
                max = ipToTimes.get(ip);
            }
        }
        return max;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts){
        int mostVisit = 0;
        ArrayList<String> iPWithMaxVisits = new ArrayList<>();
        for (String ip: counts.keySet()) {
            if(counts.get(ip) > mostVisit){
                mostVisit = counts.get(ip);
            }
        }
        for (String ip: counts.keySet()) {
            if(counts.get(ip) == mostVisit){
                iPWithMaxVisits.add(ip);
            }
        }
        return iPWithMaxVisits;
    }

    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> iPsDays = new HashMap<>();
        for (LogEntry le: records) {
            String whole = le.getAccessTime().toString();
            String date = whole.substring(8, 10);
            String month = whole.substring(4, 7);
            String monthDate = date + " " + month;

            if(!iPsDays.containsKey(monthDate)) {
                ArrayList<String> array = new ArrayList<>();
                array.add(le.getIpAddress());
                iPsDays.put(monthDate, array);
            } else {
                iPsDays.get(monthDate).add(le.getIpAddress());
            }
        }
        return iPsDays;
    }

    public String dayWithMostIPVisits(){
        String dayWithMostIP = "";
        HashMap<String, ArrayList<String>> map = iPsForDays();
        int maxVisitDay = 0;
        for (String day: map.keySet()) {
            if(map.get(day).size() > maxVisitDay){
                maxVisitDay = map.get(day).size();
                dayWithMostIP = day;
            }
        }
        return dayWithMostIP;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(String day){
        ArrayList<String> mostVisitsOnDay = new ArrayList<>();
        HashMap<String, ArrayList<String>> iPsDays = iPsForDays();
        ArrayList<String> s = iPsDays.get(day);
        HashMap<String, Integer> iPCount = new HashMap<>();

        for (String ip : s) {
            if(!iPCount.containsKey(ip)){
                iPCount.put(ip, 1);
            } else{
                iPCount.put(ip, iPCount.get(ip) + 1);
            }
        }
        int maxIp = 0;
        for(String ip : iPCount.keySet()){
            if(maxIp < iPCount.get(ip)){
                maxIp = iPCount.get(ip);
            }
        }
        for(String ip : iPCount.keySet()){
            if(iPCount.get(ip) == maxIp){
                mostVisitsOnDay.add(ip);
            }
        }

        return mostVisitsOnDay;
    }

    public static void main(String[] args) {
        System.gc ();
        System.runFinalization ();
    }
}

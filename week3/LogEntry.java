package coursera.week3;

import java.util.Date;

/**
 * Created by Роман Лотоцький on 26.12.2016.
 */
public class LogEntry {
    private String ipAddress;
    private Date accessTime;
    private String request;
    private int statusCode;
    private int butesReturned;

    public LogEntry(String ipAddress, Date accessTime, String request,
                    int statusCode, int butesReturned) {
        this.ipAddress = ipAddress;
        this.accessTime = accessTime;
        this.request = request;
        this.statusCode = statusCode;
        this.butesReturned = butesReturned;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getButesReturned() {
        return butesReturned;
    }

    public void setButesReturned(int butesReturned) {
        this.butesReturned = butesReturned;
    }

    @Override
    public String toString() {
        return  ipAddress + " " + accessTime + " " +  request + " " + statusCode + " " + butesReturned;
    }
}

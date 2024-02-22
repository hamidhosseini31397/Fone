package se.iths;

import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

public class Run {
    private double distance;
    private int time;
    LocalDate date;
    UUID id;
    String stringID;

    
    public Run(double distance,int time, String dateString, String stringID) {
        this.distance = distance;
        this.time = time;
        date = LocalDate.parse(dateString);
        this.stringID = stringID;
    }

    public double computeSpeed() {

        double speed = distance / time;
        double speedKmPerHour = speed * 3600;
        
        return speedKmPerHour;
    }

    public Duration computeKmTime() {
        return Duration.ofSeconds((long) (time / distance));
    }

    public double getDistance() {
        return distance;
    }
    public int getTime() {
        return time;
    }

    public String getInfo() {
        return "Distance : " + distance + " Time : " + time + " Date : " + date;
    }

    
    
    
    
    
}



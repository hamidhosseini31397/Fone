package se.iths;
import java.util.*;

public class User {
int height;
int weight;
double BMI;

DatabaseAPI DB;

    public User(int height, int weight, DatabaseAPI api) {
        this.height = height;
        this.weight = weight;  
        this.DB = api;
    }

    public double calculateBMI() {

        return BMI = weight/(double)((height*height)/2.0);
    }

    boolean addRun(Run run) {

        return DB.createRecord(run.stringID, run.getDistance(), run.getTime(), run.date);
        }

    public double computeAvgSpeed() {
        double sumSpeed = 0;
        List<String> ids = DB.getRecordIDs();

        for (String id : ids) {
            sumSpeed += DB.readRecord(id).computeSpeed();
        }
    
        return sumSpeed/ids.size();
    }

    public double computeTotalDistance() {

        double totalDistance = 0;

        List<String> ids = DB.getRecordIDs();

        for (String id : ids) {
            totalDistance += DB.readRecord(id).getDistance();
        }
        return totalDistance;
    }

    public double computeAvgDistance(){

        return computeTotalDistance()/DB.getRecordIDs().size();
    }

    public boolean removeRun(String stringID) {

        return  DB.deleteRecord(stringID);
    }

   
}

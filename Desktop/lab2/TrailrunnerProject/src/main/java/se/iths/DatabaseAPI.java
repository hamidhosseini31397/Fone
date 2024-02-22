package se.iths;

import java.time.LocalDate;
import java.util.List;

public class DatabaseAPI {
    public boolean createRecord(String id, double distance_km, int time_seconds, LocalDate date) {
        throw new UnsupportedOperationException();
    }

    public Run readRecord(String id) {
        throw new UnsupportedOperationException();
    }

    public boolean deleteRecord(String id) {
        throw new UnsupportedOperationException();
    }

    public List<String> getRecordIDs() {
        throw new UnsupportedOperationException();
    }
}
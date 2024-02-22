package se.iths;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.*;


public class DatabaseTest {

    DatabaseAPI DB;

    @BeforeEach
    public void setUp() {

        DB = new DatabaseAPI();
    }

    @Test
    public void createRecordCastsExeption() {

        assertThrows(UnsupportedOperationException.class, () -> {
            DB.createRecord("a1", 10, 3600, LocalDate.parse("2024-01-08"));
        });

    }

    @Test 
    public void readRecordThrowsException() {

          assertThrows(UnsupportedOperationException.class, () -> {
            DB.readRecord("a1");
        });
    }

    @Test
    public void deleteRecordThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> {
            DB.deleteRecord("a1");
        });
    }

    @Test
    public void getRecordsIDThrowsException() {

        assertThrows(UnsupportedOperationException.class, () -> {
            DB.getRecordIDs();
        });
    }
    
    
}

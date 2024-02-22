package se.iths;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.time.LocalDate;


public class RunTest {

    Run run1;
    Run run2;
    Run run3;

    @BeforeEach
    public void setUp() {
        run1 = new Run(15.5, 1800, "2024-01-01", "c3");
        run2 = new Run(10.5, 3300, "2024-01-02","b4");
        run3 = new Run(10.0, 3600, "2024-01-02","a2");

    }


    @Test
    public void eachRunHasDistanceTimeAndDate() {
        assertEquals(15.5, run1.getDistance());
        assertEquals(1800, run1.getTime());
        assertEquals(LocalDate.of(2024,1,1),run1.date);
    }

    @Test
    public void testRunID() {
        assertNotEquals(run1.stringID, run2.stringID);
        assertFalse(run1.stringID.equals(run2.stringID));
    }

    @Test
    public void testComputeSpeed() {

        double actual = run1.computeSpeed();

        assertEquals(15.5/0.5, actual, 0.1);
    }

    @Test
    public void timePerKilometer() {
        Duration kilometerTime = run3.computeKmTime();
        Duration kilometerTime2 = run2.computeKmTime();

        assertEquals(Duration.ofMinutes(6), kilometerTime);
        assertEquals(Duration.ofSeconds(314), kilometerTime2);
    }

    @Test
    public void showInfoAboutARun(){
        String expected = "Distance : 15.5 Time : 1800 Date : 2024-01-01";
        assertEquals(expected, run1.getInfo());
    }
    
    
    

}

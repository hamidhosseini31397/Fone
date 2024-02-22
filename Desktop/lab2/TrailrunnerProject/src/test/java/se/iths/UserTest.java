package se.iths;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.*;

import org.mockito.*;
import static org.mockito.Mockito.*;

public class UserTest {
    User user;
    
    @Mock
    DatabaseAPI api;

    @BeforeEach
    public void initMocks() {
        api = mock(DatabaseAPI.class);
    }

    Run run1;
    Run run2;
    Run run3;
    @BeforeEach
    public void setUp() {
        run1 = new Run(15.5, 1800, "2024-01-01","c3");
        run2 = new Run(10.5, 1800, "2024-01-08", "b4");
        run3 = new Run(10, 3600, "2024-01-08", "a2");

        user = new User(165, 60, api);
    }

    @BeforeEach
    public void stubOutput() {
        String[] idArray = {"a2","b4","c3"};
        List<String> IDs = Arrays.asList(idArray);

        when(api.getRecordIDs()).thenReturn(IDs);

        when(api.readRecord("a2")).thenReturn(run3);
        when(api.readRecord("b4")).thenReturn(run2);
        when(api.readRecord("c3")).thenReturn(run1);
    }

    @Test
    public void userHeightAndWeight(){
        assertEquals(165, user.height);
        assertEquals(60, user.weight);
    }

    @Test
    public void calculateUserBMI() {
        assertEquals(60/((165.0*165.0)/2.0), user.calculateBMI(), 0.1);
    }

    @Test
    public void addRunToUser() {       
        
        when(api.createRecord("a2", 10, 3600, LocalDate.parse("2024-01-08"))).thenReturn(true);

        assertTrue(user.addRun(run3));
        assertFalse(user.addRun(run2));

    }

    @Test
    public void testAvgSpeedOfAllRuns() {

        double avgSpeed = user.computeAvgSpeed();

        assertEquals(20.6, avgSpeed, 0.1);
    }


    @Test
    public void totalDistance(){

        double totalDistance = user.computeTotalDistance();
        
        assertEquals(36, totalDistance);
    }

    @Test
    public void testAvgDistanceOfAllRuns() {

        double totalAvgDistanceOfAllRuns = user.computeAvgDistance();

        assertEquals(36.0/3.0, totalAvgDistanceOfAllRuns, 0.1);
    }


    @Test
    public void removeRunFromUser() {

        when(api.deleteRecord("a2")).thenReturn(true);
        assertTrue(user.removeRun("a2"));
        assertFalse(user.removeRun("b4"));

    }
    
    
}

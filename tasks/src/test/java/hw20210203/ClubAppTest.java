package hw20210203;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClubAppTest {
    ClubApp clubApp = new ClubApp();
    List<FootballClub> footballClubs = new ArrayList<>();

    //Create FootballClubs:

    FootballClub fc1 = new FootballClub("A", "Abc", 5 );
    FootballClub fc2 = new FootballClub("B", "Abc", 5 );
    FootballClub fc3 = new FootballClub("C", "Bac", 5 );
    FootballClub fc4 = new FootballClub("D", "Abc", 1 );
    FootballClub fc5 = new FootballClub("E", "Bac", 1 );
    FootballClub fc6 = new FootballClub("J", "Der", 3 );
    FootballClub fc7 = new FootballClub("I", "Die", 7 );
    FootballClub fc8 = new FootballClub("K", "Das", 8 );


    @Test
    public void testSortedClub_one_one(){
        List<FootballClub> actual =  clubApp.sortedClub(Arrays.asList(fc1));
        List<FootballClub> expected = Arrays.asList(fc1);
        assertEquals(expected, actual);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
    @Test
    public void testSortedClub_two_some(){
        List<FootballClub> actual =  clubApp.sortedClub(Arrays.asList(fc1, fc2));
        List<FootballClub> expected = Arrays.asList(fc1,fc2);
        assertEquals(expected, actual);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
    @Test
    public void testSortedClub_two_differentCountry(){
        List<FootballClub> actual =  clubApp.sortedClub(Arrays.asList(fc3, fc1));
        List<FootballClub> expected = Arrays.asList(fc1,fc3);
        assertEquals(expected, actual);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
    @Test
    public void testSortedClub_two_differentPoint(){
        List<FootballClub> actual =  clubApp.sortedClub(Arrays.asList(fc1,fc4));
        List<FootballClub> expected = Arrays.asList(fc4, fc1);
        assertEquals(expected, actual);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
    @Test
    public void testSortedClub_two_differentAll(){
        List<FootballClub> actual =  clubApp.sortedClub(Arrays.asList(fc5, fc1));
        List<FootballClub> expected = Arrays.asList(fc1,fc5);
        assertEquals(expected, actual);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
    @Test
    public void testSortedClub_many_many(){
        List<FootballClub> actual =  clubApp.sortedClub(Arrays.asList(fc8, fc7, fc6, fc5, fc4, fc3, fc2, fc1));
        List<FootballClub> expected = Arrays.asList(fc4, fc2, fc1, fc5, fc3, fc8, fc6, fc7);
        assertEquals(expected, actual);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

}

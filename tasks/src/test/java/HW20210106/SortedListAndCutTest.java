package HW20210106;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortedListAndCutTest {

    private SortedListAndCut sortedList = new SortedListAndCut();

    @Test
    public void maxCoveredPoint_cut2_2(){
        List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        int cut = 2;
        int actual = sortedList.maxCoveredPoint(numbers, cut);
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    public void maxCoveredPoint_cut1_1(){
        List<Integer> numbers = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        int cut = 1;
        int actual = sortedList.maxCoveredPoint(numbers, cut);
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    public void maxCoveredPoint_cut8_1(){
        List<Integer> numbers = Arrays.asList(10,15,20,31,40,55,58,64);
        int cut = 9;
        int actual = sortedList.maxCoveredPoint(numbers, cut);
        int expected = 3;
        assertEquals(expected, actual);
    }
}

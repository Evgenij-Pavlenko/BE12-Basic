package hw202124_cut_and_set;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CutSolveTest {
    CutSolve cutSolve = new CutSolve();
    Cut c1 = new Cut(1,7);
    Cut c2 = new Cut(2,7);
    Cut c3 = new Cut(4,8);
    Cut c4 = new Cut(8,13);
    Cut c5 = new Cut(9,12);
    Cut c6 = new Cut(11,15);

    @Test
    public void testGetNumberSegments(){
        List<Cut> cuts = Arrays.asList(c1,c2,c3,c4,c5,c6);
        List<Integer> listInt = Arrays.asList(3,6,10,12,14);
        Map<Integer, Integer> actual = cutSolve.getNumberSegments(cuts, listInt);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(3,2);
        expected.put(6,3);
        expected.put(10,2);
        expected.put(12,3);
        expected.put(14,1);
        assertEquals(expected, actual);

    }

}

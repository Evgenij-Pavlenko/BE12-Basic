package pac20201126;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * {1, 5, 8, 20} & 15 -> false; {1, 5, 8, 20} & 40 -> true; {1, 5, 5, 8, 20} & 25 -> true; {1, 5, 8, 20} & 25 -> false;
 */

class MultiplicationNTest {
    MultiplicationN mult = new MultiplicationN();

    @Test
    public void testDecomposedN_15_false(){
        List<Integer> actual = Arrays.asList(1, 5, 8, 20);
        assertFalse(mult.decomposedN(actual, 15));
    }
    @Test
    public void testDecomposedN_40_true(){
        List<Integer> actual = Arrays.asList(1, 5, 8, 20);
        assertTrue(mult.decomposedN(actual, 40));
    }
    @Test
    public void testDecomposedN_25_true(){
        List<Integer> actual = Arrays.asList(1, 5, 5, 8, 20);
        assertTrue(mult.decomposedN(actual, 25));
    }
    @Test
    public void testDecomposedN_25_false(){
        List<Integer> actual = Arrays.asList(1, 5, 8, 20);
        assertFalse(mult.decomposedN(actual, 25));
    }

}
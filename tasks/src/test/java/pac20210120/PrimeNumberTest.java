package pac20210120;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {

    PrimeNumber pn = new PrimeNumber();


    @Test
    public void testGetPrime_2_1() {
        List<Integer> actual = pn.getPrimes(2);
        List<Integer> expected = Arrays.asList(2);
        assertEquals(expected,actual);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testGetPrime_3_2() {
        List<Integer> actual = pn.getPrimes(3);
        List<Integer> expected = Arrays.asList(2,3);
        assertEquals(expected,actual);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testGetPrime_4_2() {
        List<Integer> actual = pn.getPrimes(4);
        List<Integer> expected = Arrays.asList(2,3);
        assertEquals(expected,actual);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testGetPrime_5_3() {
        List<Integer> actual = pn.getPrimes(5);
        List<Integer> expected = Arrays.asList(2,3,5);
        assertEquals(expected,actual);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testGetPrime_7_4() {
        List<Integer> actual = pn.getPrimes(7);
        List<Integer> expected = Arrays.asList(2,3,5,7);
        assertEquals(expected,actual);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testGetPrime_11_5() {
        List<Integer> actual = pn.getPrimes(11);
        List<Integer> expected = Arrays.asList(2,3,5,7,11);
        assertEquals(expected,actual);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

    @Test
    public void testGetPrime_200_46() {
        List<Integer> actual = pn.getPrimes(200);
        List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67,
                71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
                181, 191, 193, 197, 199);
        System.out.println(expected.size());
        assertEquals(expected,actual);
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }

}

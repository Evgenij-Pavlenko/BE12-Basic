package hw20210215_range_of_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeOfNumbersTest {
    RangeOfNumbers range = new RangeOfNumbers();

    @Test // 9
    public void testGetCountNumbers_9_zero() {
        int a = 9;
        int b = 9;
        int actual = range.getCountNumbers(a, b);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test // 10
    public void testGetCountNumbers_10_one() {
        int a = 10;
        int b = 10;
        int actual = range.getCountNumbers(a, b);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test // 8,9
    public void testGetCountNumbers_8_9_zero() {
        int a = 8;
        int b = 9;
        int actual = range.getCountNumbers(a, b);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test // 9, 10
    public void testGetCountNumbers_9_10_one() {
        int a = 9;
        int b = 10;
        int actual = range.getCountNumbers(a, b);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test // 111
    public void testGetCountNumbers_111_one() {
        int a = 111;
        int b = 111;
        int actual = range.getCountNumbers(a, b);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test // 1-100 =>20
    public void testGetCountNumbers_1_100_one() {
        int a = 1;
        int b = 100;
        int actual = range.getCountNumbers(a, b);
        int expected = 20;
        assertEquals(expected, actual);
    }

}

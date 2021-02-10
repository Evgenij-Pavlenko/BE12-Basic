package hw20210203;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
*Для тестов - до 10*
2. Есть массив из неповторяющихся чисел от 1 до 100 (всего 99 чисел вразброс).
В массиве присутствуют все числа, кроме одного. Найти оное (это).
 */
class Array100Test {
    Array100 arr = new Array100();

    @Test
    public void testFindOne_ten_5() {
        int[] arr10 = {1, 10, 3, 4, 6, 7, 8, 9, 2};
        int actual = arr.findOne(arr10);
        int expected = 5;
        assertEquals(expected, actual);

    }

    @Test
    public void testFindOne_ten_1() {
        int[] arr10 = {10, 3, 4, 6, 7, 8, 5, 9, 2};
        int actual = arr.findOne(arr10);
        int expected = 1;
        assertEquals(expected, actual);

    }

    @Test
    public void testFindOne_ten_10() {
        int[] arr10 = {1, 5, 3, 4, 6, 7, 8, 9, 2};
        int actual = arr.findOne(arr10);
        int expected = 10;
        assertEquals(expected, actual);

    }

}

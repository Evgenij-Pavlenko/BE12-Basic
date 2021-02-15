package hw20210215_range_of_numbers;


/*
Есть диапазон чисел от a до b включительно. Найти количество чисел, содержащих цифру 1.
 */
public class RangeOfNumbers {

    public int getCountNumbers(int a, int b) {
        int retCount = 0;
        for (int i = a; i <= b; i++) {
            if (isOne(i)) {
                retCount++;
            }
        }
        return retCount;
    }

    private boolean isOne(int num) {
        while (num > 0) {
            if (num % 10 == 1) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}

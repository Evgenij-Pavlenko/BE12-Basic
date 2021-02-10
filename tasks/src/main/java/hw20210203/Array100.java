package hw20210203;

import java.util.Arrays;

/*
2. Есть массив из неповторяющихся чисел от 1 до 100 (всего 99 чисел вразброс).
В массиве присутствуют все числа, кроме одного. Найти оное (это).
 */
public class Array100 {
    public int findOne(int[] hundred) {
        int ret = 0;
        Arrays.sort(hundred);
        for (int i = 0; i < hundred.length; i++) {
            if ((ret + 1) != hundred[i]) {
                System.out.println(ret);
                return ret + 1;
            } else if (i == hundred.length - 1) {
                return ret + 2;
            }
            ret++;
        }
        return ret;
    }
}

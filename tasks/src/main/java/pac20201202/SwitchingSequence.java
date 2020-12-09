package pac20201202;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Будем называть последовательность чисел "переключающий" если все элементы на четных местах равны между собой,
 * а также и на нечетных. Дюбая длина
 * {5,-3,5,-3,5} -> true
 */

public class SwitchingSequence {

    public boolean checkSequence(List<Integer> arr) {
        int even = arr.get(0);
        int odd = 0;
        try {
            if (arr.get(1) != null) {
                odd = arr.get(1);
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
        }

        for (int i = 0; i < arr.size(); i++) {
            if (i % 2 == 0) {
                if (even != arr.get(i)) {
                    return false;
                }
            }
            if (i % 2 != 0) {
                if (odd != arr.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}

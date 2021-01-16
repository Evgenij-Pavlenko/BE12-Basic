package pac20201202;

import java.util.List;

/**
 * Есть массив чисел. Вернуть длину самой длинной "переключающей" последовательности в этом массиве.
 * {1,2,3,4,5} -> 2 (1,2)
 * {1,2,3,4,5,4} -> 3 (4,5,4)
 * {5} -> 1
 * {} -> 0
 */
public class SwitchingSequenceCount {


    // работает, но много if ((
    public int checkSequenceCount(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        int even = arr[0];
        int odd = 0;
        int tempLengthCount = 1;
        int lengthCount = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (even == arr[i]) {
                    tempLengthCount++;

                } else tempLengthCount = 2;
                even = arr[i];
            }
            if (lengthCount < tempLengthCount) {
                lengthCount = tempLengthCount;
            }
            if (i % 2 != 0) {
                if (odd == arr[i]) {
                    tempLengthCount++;

                } else tempLengthCount = 2;
                odd = arr[i];
            }
            if (lengthCount < tempLengthCount) {
                lengthCount = tempLengthCount;
            }
        }

        return lengthCount;
    }
}

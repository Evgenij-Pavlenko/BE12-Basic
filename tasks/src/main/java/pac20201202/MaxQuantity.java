package pac20201202;

/**
 * Есть массив int[]. Вывести число, которое встречается чаще всех
 * {1,2,3,4,5,3,5} -> 3 (если несколько - то первое из них)
 * <p>
 * Будем называть последовательность чисел "переключающий" если все элементы на четных местах равны между собой,
 * а также и на нечетных. Дюбая длина
 * {5,-3,5,-3,5} -> true
 */

import java.util.*;

public class MaxQuantity {
    public int maxQuantity(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arr) {
            map.computeIfPresent(i, (key, value) ->++value);
            map.putIfAbsent(i, 1);
        }
//        int result = map.entrySet().stream().sorted(Comparator.comparing(m -> -m.getValue())).findFirst().get().getKey();
        int result = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
        System.out.println(map);
        System.out.println(result);
        return result;
    }
}

package pac20201126;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Есть лист целых ( Integer) чисел. Известно что каждое число, кроме одного, имеет пару. Найти число без пары.
 * {3, 5, 3}->5; {3,5,3,3,3}->5; {3,5,3,5,3}->3
 */
public class FindPair {


    public int findPair(List<Integer> listInt) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : listInt) {
            map.computeIfPresent(i, (k, v) -> v + 1);
            map.putIfAbsent(i, 1);
        }

        // O(n+k)
        int ret = map.entrySet().stream().filter(m -> m.getValue() % 2 != 0).map(Map.Entry::getKey).findFirst().get();
        return ret;
    }
}

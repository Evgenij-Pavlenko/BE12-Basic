package hw202124_cut_and_set;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
1. Есть лист объектов "Отрезок":
class Cut{
   int left;
   int right;
}
и есть лист int чисел.
Вернуть Map<Integer, Integer> ключами которого являются числа из листа (int),  а значения - это кол-во отрезков покрывающих это число
Map<Integer, Integer> solve (List<Cut> cuts, List<Integer> numbers)
 */
public class CutSolve {

    public Map<Integer, Integer> getNumberSegments(List<Cut> cuts, List<Integer> numbers) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int num : numbers) {
            for (Cut cut : cuts) {
                if (cut.left <= num && cut.right >= num) {
                    res.computeIfPresent(num, (k, v) -> ++v);
                    res.putIfAbsent(num, 1);
                }
            }
        }
        return res;
    }
}

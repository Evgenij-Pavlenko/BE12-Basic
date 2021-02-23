package hw202124_cut_and_set;

import java.util.*;

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

    public Map<Integer, Integer> getNumberSegments1(List<Cut> cuts, List<Integer> numbers) {
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

    //как-то через Deque, но что-то не получилось( Забыл, как делали. На уроке посмотрю
    public Map<Integer, Integer> getNumberSegments(List<Cut> cuts, List<Integer> numbers) {
        Map<Integer, Integer> res = new HashMap<>();
        Deque<Cut> cutDeque = new LinkedList<>();
        int index  = 0;
        int indexCount = 0;
for(Cut cut: cuts){
    int num = numbers.get(index);
    if (cut.left <= num && cut.right >= num){
        indexCount++;
        cutDeque.add(cut);
    } else{
        res.put(num, cutDeque.size());
        index++;
    }

}
        return res;
    }
}

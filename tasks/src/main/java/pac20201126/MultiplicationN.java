package pac20201126;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2. Есть ряд (List) положительных int чисел, расположенных по возрастанию. Есть число N.
 * Определить, можно ли N разложить на произведение двух различных элементов из ряда-листа.
 * {1, 5, 8, 20} & 15 -> false; {1, 5, 8, 20} & 40 -> true; {1, 5, 5, 8, 20} & 25 -> true; {1, 5, 8, 20} & 25 -> false;
 */
public class MultiplicationN {

    public boolean decomposedN(List<Integer> list, int n) {
        Deque<Integer> deq = new LinkedList<>(list);
        System.out.println(deq);

        // O(n) or O((n)/2)
        // algorithm 1
//        while (deq.size() != 0) {
//            if (deq.contains(n/ deq.pollFirst())) {
//                return true;
//            }
//        }

        // algorithm 2
        while (deq.size() > 1 ) {
            if (deq.getFirst()*deq.getLast() == n) {
                return true;
            }
            if (deq.getFirst() * deq.getLast() > n) {
                deq.pollLast();
            } else {
                deq.pollFirst();
            }
        }
        return false;
    }
}

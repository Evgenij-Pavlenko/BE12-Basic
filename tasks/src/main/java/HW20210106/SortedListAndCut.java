package HW20210106;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Есть List<Integer> отсортированных чисел. Есть еще одно число, символизирующее длину некоего отрезка.
Найти максимальное количество точек на этой прямой, которые можно покрыть этим отрезком.
*int maxCoveredPoint(List<Imteger> numbers, int cut)
**List<Integer>{10,15,20,31,40,55,58,64}, cut=9 -> maxCoveredPoint = 3    (55,58,64)
 */
public class SortedListAndCut {

    public int maxCoveredPoint(List<Integer> numbers, int cut){
        List<Integer> listInt = new ArrayList<>(numbers);
        int maxCount = 0;
        int count;
        for (int i = 0; i < numbers.size(); i++) {
            count = 0;
            for (int j = i; j < numbers.size(); j++) {
                if (listInt.get(j)<=listInt.get(i)+cut){
                    count++;
                }
            }
            if (count>maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }
}

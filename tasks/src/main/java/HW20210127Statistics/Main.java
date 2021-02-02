package HW20210127Statistics;

import java.util.*;

public class Main {

    public  List<Statistic> last10Minute(List<Statistic> statistics){
        List<Statistic> ret = new ArrayList<>(statistics);
        Deque<Statistic> deqSt = new LinkedList<>();
        HashMap<String, Deque<Statistic>> hashMap = new LinkedHashMap<>();
        int countLast10Minute = 0;
        for (Statistic st: ret){
            hashMap.computeIfPresent(st.url, () ->{
                deqSt.addLast(st);

                while (st.time - deqSt.getFirst().time > 10) {
                    deqSt.removeFirst();
                }

                if (countLast10Minute < deqSt.size())
                    countLast10Minute = deqSt.size();
            });
        }

        return ret;
    }

//    public void dequeu() {
//        List<Double> angles = pointsToDegree(points);
//        angles.addAll(increasingList(angles,alpha));
//        Deque<Double> intervalQueue = new ArrayDeque<>();
//        int max = 0;
//        for (double angle :angles) {
//            intervalQueue.addLast(angle);
//
//            while (angle - intervalQueue.getFirst() > alpha) {
//                intervalQueue.removeFirst();
//            }
//
//            if (max < intervalQueue.size())
//                max = intervalQueue.size();
//        }
//    }
}

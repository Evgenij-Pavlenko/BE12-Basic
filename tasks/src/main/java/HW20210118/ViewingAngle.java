package HW20210118;

import javafx.collections.transformation.SortedList;

import java.util.*;

/*
ДЗ 20210113
Есть лес, на который смотрим сверху (т.е. разбросаны точки). Мы находимся в центре.
Какое максимальное кол-во деревьев можно увидеть в этой точки?
int maxTrees(List<Point> points, int alpha)
class Point{
double x;
double y;
}
есть функция Math.arctn() от
tangens(x,y) => y/x
получим угол
 */
public class ViewingAngle {

    public int maxTrees(List<Point> points, int alpha) {
        List<Double> angles = pointsToDegree(points);
        angles.addAll(increasingList(angles,alpha));
        System.out.println(angles);
        Deque<Double> intervalQueue = new ArrayDeque<>();
        int max = 0;
        for (double angle : angles) {
            intervalQueue.addLast(angle);

            while (angle - intervalQueue.getFirst() > alpha) {
                intervalQueue.removeFirst();
            }

            if (max < intervalQueue.size())
                max = intervalQueue.size();
        }
        return max;
    }

    private List<Double> pointsToDegree(List<Point> points) {
        List<Double> angles = new ArrayList<>();
        for (Point point : points) {
            double x = point.x;
            double y = point.y;
            double tempAngle;
            if (y < 0) {
                tempAngle = Math.abs(Math.toDegrees(Math.atan2(y, x))) + 180.0; // нижний полукруг
            } else {
                tempAngle = Math.abs(Math.toDegrees(Math.atan2(y, x)));
            }
            angles.add(tempAngle);
        }
        //если точки вразброс в списке
        Collections.sort(angles);
//      System.out.println(angles);
        return angles;
    }

    private List<Double> increasingList(List<Double> angles, int alpha) {
        List<Double> list = new ArrayList<>();
        for (double angle : angles) {
            if (angle < alpha) {
                list.add(angle+360);
            } else break;
        }
        return list;
    }
}

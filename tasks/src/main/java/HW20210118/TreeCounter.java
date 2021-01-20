package HW20210118;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeCounter {
    /**
     * Count the max amount of trees visible from the point (0,0) with the angle of
     * visibility angle
     *
     * @param trees list of the points (has x and y coordinates)
     * @param alpha the angle of visibility
     * @return
     */
    public int threeCount(List<Point> trees, double alpha) {
        List<Double> angles = getSortedAngles(trees, alpha);
        return numberCount(angles,alpha);
    }
    private List<Double> getSortedAngles(List<Point> trees, double alpha) {
        return trees.stream().flatMap(point -> {
            double angle = point.getAndleRads();
            return angle<alpha? Stream.of(angle + 2*Math.PI):Stream.of(angle);
        })
                .sorted()
                .collect(Collectors.toList());
    }

    public int numberCount(List<Double> numbers, double alpha) {
        if (numbers.isEmpty() || alpha == 0)
            return 0;

        Deque<Double> intervalQueue = new ArrayDeque<>();
        int max = 0;
        for (double angle : numbers) {
            intervalQueue.addLast(angle);

            while (angle - intervalQueue.getFirst() > alpha) {
                intervalQueue.removeFirst();
            }

            if (max < intervalQueue.size())
                max = intervalQueue.size();
        }
        return max;
    }
}

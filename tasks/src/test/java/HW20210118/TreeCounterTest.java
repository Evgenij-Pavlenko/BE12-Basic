package HW20210118;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeCounterTest {
    private TreeCounter viewingAngle = new TreeCounter();
    // в каждом секторе по точке
    private List<Point> points = Arrays.asList(new Point(1, 1), new Point(-1, 1),
            new Point(-1, -1), new Point(1, -1));

    @Test
    public void testMaxTrees_alpha1_1() {
        int actual = viewingAngle.threeCount(points, Math.toRadians(1));
        int expected = 1;
        assertEquals(expected, actual);
    }

    // не совсем понятно условие
    //если включая крайние точки - то результат int expected = 5 про alpha==360
    @Test
    public void testMaxTrees_alpha359_4() {
        int actual = viewingAngle.threeCount(points, Math.toRadians(359));
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxTrees_alpha89_1() {
        int actual = viewingAngle.threeCount(points, Math.toRadians(89));
        int expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void testMaxTrees_alpha179_2() {
        int actual = viewingAngle.threeCount(points, Math.toRadians(179));
        int expected = 2;
        assertEquals(expected, actual);
    }


}

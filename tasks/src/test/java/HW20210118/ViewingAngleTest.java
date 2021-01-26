package HW20210118;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewingAngleTest {
    private ViewingAngle viewingAngle = new ViewingAngle();
    // в каждом секторе по точке
    private List<Point> points = Arrays.asList(new Point(1, 1), new Point(-1, 1),
            new Point(-1, -1), new Point(1, -1));

    @Test
    public void testMaxTrees_alpha1_1() {
        int actual = viewingAngle.maxTrees(points, 1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    // не совсем понятно условие
    //если включая крайние точки - то результат int expected = 5 про alpha==360
    @Test
    public void testMaxTrees_alpha359_4() {
        int actual = viewingAngle.maxTrees(points, 359);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void testMaxTrees_alpha89_1() {
        int actual = viewingAngle.maxTrees(points, 89);
        int expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void testMaxTrees_alpha179_2() {
        int actual = viewingAngle.maxTrees(points, 179);
        int expected = 2;
        assertEquals(expected, actual);
    }

}

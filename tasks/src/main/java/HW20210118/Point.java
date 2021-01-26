package HW20210118;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return angle of the point from [0; 2pi]
     */
    public double getAndleRads() {
        double res = Math.atan2(y, x);
        return res < 0 ? res + 2 * Math.PI : res;

    }
}

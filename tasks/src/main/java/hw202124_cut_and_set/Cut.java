package hw202124_cut_and_set;

public class Cut {
    int left;
    int right;

    public Cut(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Cut{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}

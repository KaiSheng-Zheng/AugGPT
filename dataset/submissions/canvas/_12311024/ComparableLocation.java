import java.util.Comparator;

public class ComparableLocation implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.location.getX() > o2.location.getX()) {
            return 1;
        } else if (o1.location.getX() < o2.location.getX()) {
            return -1;
        } else {
            if (o1.location.getY() > o2.location.getY()) {
                return 1;
            } else if (o1.location.getY() < o2.location.getY()) {
                return -1;
            } else {
                int i = (int) o1.pattern;
                int j = (int) o2.pattern;
                if (i > j) {
                    return 1;
                } else if (i < j) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
import java.util.Comparator;

public class ShapeComparators {
    public static Comparator<Shape> location = (s1, s2) -> {
        if (s1.getLocation().getX() != s2.getLocation().getX()) {
            return Integer.compare(s1.getLocation().getX(), s2.getLocation().getX());
        }
        if (s1.getLocation().getY() != s2.getLocation().getY()) {
            return Integer.compare(s1.getLocation().getY(), s2.getLocation().getY());
        }
        return Character.compare(s1.getPattern(), s2.getPattern());
    };
        public static  Comparator<Shape> area = (s1, s2) -> {
            if (s1.area() !=s2.area()) {
                return Integer.compare(s1.area(), s2.area());
            }
                return Character.compare(s1.getPattern(), s2.getPattern());
        };
}


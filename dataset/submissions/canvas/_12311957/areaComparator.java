import java.util.Comparator;

public class areaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.area() - o2.area() == 0) {
            return Character.valueOf(o1.getPattern()).compareTo(Character.valueOf(o2.getPattern()));
        }
        else {
            return o1.area() - o2.area();
        }
    }
}
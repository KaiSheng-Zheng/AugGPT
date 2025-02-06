import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.area() != o2.area())
            return o1.area() - o2.area();
        else return o1.pattern - o2.pattern;
    }
}

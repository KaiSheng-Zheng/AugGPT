import java.util.Comparator;

public class locationComparator implements Comparator<Shape>{
    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.getLocation().getX() == o2.getLocation().getX()
                && o1.getLocation().getY() == o2.getLocation().getY()){
            return Character.valueOf(o1.getPattern()).compareTo(Character.valueOf(o2.getPattern()));
        }
        else if(o1.getLocation().getX() == o2.getLocation().getX()){
            return o1.getLocation().getY() - o2.getLocation().getY();
        }
        else{
            return o1.getLocation().getX() - o2.getLocation().getX();
        }
    }
}
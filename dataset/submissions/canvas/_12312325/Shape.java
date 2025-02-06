import java.util.Comparator;

public abstract class Shape implements Comparator<Shape> {

    protected char[][] grids;
    protected char pattern;
    protected Location location;
    private String mode;
    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public int compare(Shape one, Shape other) {

        if (mode.equals("area")) {
            int areaComparison = Integer.compare(one.area(), other.area());
            if (areaComparison != 0) {
                return areaComparison;
            } else {
                return String.valueOf(one.pattern).compareTo(String.valueOf(other.pattern));
            }
        }else {
            int xCompare = one.location.getX() - other.location.getX();
            if (xCompare !=0) {
                return xCompare;
            }else if (one.location.getY() - other.location.getY() !=0){
                return one.location.getY() - other.location.getY();
            }else {
                return String.valueOf(one.pattern).compareTo(String.valueOf(other.pattern));
            }
        }
    }
}

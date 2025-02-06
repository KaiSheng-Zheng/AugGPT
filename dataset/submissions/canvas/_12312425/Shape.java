import java.util.Comparator;

public abstract class Shape implements Comparable<Shape>{
    protected char[][] grids;
    protected char pattern;//shape of pixels
    protected Location location;
    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
    };
    public char[][] getGrids(){return grids;};
    public abstract void fillGrids();//fill grid with pattern
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();//return the count of patterns
    public static double distance(int a, int b){
        return (Math.sqrt(Math.pow(a,2)+Math.pow(b,2)));
    }

}
class ShapeLocationComparator implements Comparator<Shape>{
    public int compare(Shape o1, Shape o2) {
        if (o1.location.getX() < o2.location.getX()){
            return -1;
        } else if (o1.location.getX() > o2.location.getX()) {
            return 1;
        } else {
            if (o1.location.getY() < o2.location.getY()){
                return -1;
            } else if (o1.location.getY() > o2.location.getY()) {
                return 1;
            } else {
                if (o1.pattern < o2.pattern){
                    return -1;
                } else if (o1.pattern > o2.pattern) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

}

public abstract class Shape implements Comparable<Shape>{
    protected char[][] grids;
    protected char pattern;
    protected Location location;


    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();


    public int compareTo(Shape other) {
        int compareArea = Double.compare(this.area(), other.area());
        if (compareArea == 0) {
            int comparePattern = Character.compare(this.pattern, other.pattern);
            if (comparePattern == 0) {
                int compareX = Double.compare(this.location.getX(), other.location.getX());
                if (compareX == 0) {
                    return Double.compare(this.location.getY(), other.location.getY());
                }
                return compareX;
            }
            return comparePattern;
        }
        return compareArea;
    }

}
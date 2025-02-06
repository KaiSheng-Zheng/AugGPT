public abstract class Shape implements Comparable<Shape>{
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected String name;
    public Shape(char pattern, Location location) {
        this.pattern = pattern;
        this.location = location;
    }
    public int compareTo(Shape shape) {
        if (this.area() < shape.area()){
            return -1;
        } else if (this.area() > shape.area()) {
            return 1;
        } else {
            if (this.pattern < shape.pattern){
                return -1;
            } else if (this.pattern > shape.pattern) {
                return 1;
            } else {
                return 0;
            }
        }
    }


    public char[][] getGrids() {
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}

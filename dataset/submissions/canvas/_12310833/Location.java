public class Location {
    //The location means the left-up corner of grids. For example,
    // if the location of the shape is (5, 6) and the shape is in a canvas,
    // so that the pixel grids[0][0] in the location of canvas is (5, 6)
    //The class Location doesn't have any specific role in the current assignment,
    // because there is no requirement of any class about canvas in this assignment,
    private int x;
    private int y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}
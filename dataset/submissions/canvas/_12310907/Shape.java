import java.util.Comparator;

public abstract class Shape {
    //The dimensions of the grids can be used as the width and height of the graphics.
    protected char[][] grids;
    //If there is an element, it is represented by a pattern , and if there is no element, it is represented by a space.
    protected char pattern;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    protected Location location;

    public Shape(Location location, char pattern) {
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

    public int areaCount(char[][] grids, char pattern) {
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    //natural by location
    /*
    @Override
    public int compareTo(Shape o) {
        if (this.getLocation().getX() < o.getLocation().getX()) {
            return -1;
        } else if (this.getLocation().getX() > o.getLocation().getX()) {
            return 1;
        }
        if (this.getLocation().getX() == o.getLocation().getX()) {
            if (this.getLocation().getY() < o.getLocation().getY()) {
                return -1;
            } else if (this.getLocation().getY() > o.getLocation().getY()) {
                return 1;
            }
            if (this.getLocation().getY() == o.getLocation().getY() && this.getLocation().getX() == o.getLocation().getX()) {
                if (this.pattern < o.pattern) {
                    return -1;
                } else if (this.pattern > o.pattern) {
                    return 1;
                }
            }

        }
        return 0;
    }


     */
}

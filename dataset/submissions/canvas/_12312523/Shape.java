public abstract class Shape implements Comparable<Shape>{
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected String className;
    protected int area;
    private int selection;

    public Shape(Location location, char pattern) {
        this.pattern = pattern;
        this.location = location;
    }
    public char[][] getGrids() {
        return grids;
    }
    public void setSelection(int areaOrLocation) {
        this.selection = areaOrLocation;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public abstract boolean ifIn(int i, int j);
    public String toString() {
        int x = this.location.getX();
        int y = this.location.getY();
        return String.format("%s: (%d,%d) area=%d pattern=%s", this.className, x, y, this.area, this.pattern);
    }

    public int compareTo(Shape o) {
        if (selection == 1) {
            if (this.area < o.area) {
                return -1;
            } else if (this.area > o.area) {
                return 1;
            } else {
                if (this.pattern < o.pattern) {
                    return -1;
                } else if (this.pattern > o.pattern) {
                    return 1;
                }
            }
        } else if (selection == 2) {
            Location location1 = this.location;
            int x1 = location1.getX();
            int y1 = location1.getY();
            Location location2 = o.location;
            int x2 = location2.getX();
            int y2 = location2.getY();
            if (x1 < x2) {
                return -1;
            } else if (x1 > x2) {
                return 1;
            } else {
                if (y1 < y2) {
                    return -1;
                } else if (y1 > y2) {
                    return 1;
                } else {
                    if (this.pattern < o.pattern) {
                        return -1;
                    } else if (this.pattern > o.pattern) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}

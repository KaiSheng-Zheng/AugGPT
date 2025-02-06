public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    protected void initializeGrids(int height, int width) {
        grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' ';
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

    public String toString() {
        return String.format("%s: (%d,%d) area=%d pattern=%c",
                this.getClass().getSimpleName(),
                location.getX(),
                location.getY(),
                area(),
                pattern);
    }

    public int getArea() {
        return area();
    }

    public Location getLocation() {
        return location;
    }

    public char getPattern() {
        return pattern;
    }
}


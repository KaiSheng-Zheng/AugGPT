public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    public char[][] getGrids() {
        return this.grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    protected void initiate() {
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j] = ' ';
            }
        }
    }
}

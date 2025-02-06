public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape (Location location, char pattern){
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
    public abstract char[][] ConflictShapeCanvasCheck(char[][] canvas);
    public abstract char[][] RePaint(char[][] canvas);
    public void fillGridsWithSpace(){
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j] = ' ';
            }
        }
    }
}

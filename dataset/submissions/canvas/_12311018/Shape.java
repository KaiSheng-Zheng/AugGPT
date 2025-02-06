public  abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public String property;

    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern=pattern;
    }

    public char[][] getGrids() {
        return grids;
    }


    public void fillGridsWithBlank(){
        for (int indexInHeight = 0; indexInHeight < grids.length; indexInHeight++) {
            for (int indexInWidth = 0; indexInWidth < grids[indexInHeight].length; indexInWidth++)
                grids[indexInHeight][indexInWidth] = ' ';
        }
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}

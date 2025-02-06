public abstract class Shape {
    protected char[][] grids;
    protected char pattern;

    public char getPattern() {
        return pattern;
    }

    public Location getLocation() {
        return location;
    }

    protected Location location;

    public Shape(){
    }
    public Shape(Location location, char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids(){
        fillGrids();
        return this.grids;
    }
    public abstract void fillGrids();

    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    public int getArea(){
        return this.area();
    }


}

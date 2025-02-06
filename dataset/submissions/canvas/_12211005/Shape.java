public abstract class Shape{
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public abstract String toString();

    public char[][] getGrids() {
        return grids;
    }
    public char getPattern() {
        return pattern;
    }

    public void setPattern(char pattern) {
        this.pattern = pattern;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

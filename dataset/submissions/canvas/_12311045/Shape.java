public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public char getPattern() {return pattern;}
    public Location getLocation() {return location;}
    public void setGrids(char[][] grids) {this.grids = grids;}
    public void setPattern(char pattern) {this.pattern = pattern;}
    public void setLocation(Location location) {this.location = location;}
    public int getX(){return location.getX();}
    public int getY(){return location.getY();}


    public Shape(Location location, char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids(){return grids;}
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}


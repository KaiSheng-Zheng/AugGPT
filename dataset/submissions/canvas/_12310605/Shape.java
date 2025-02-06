public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public abstract int getreduction();
    public Shape(Location location, char pattern){
        this.location=location;
        this.pattern=pattern;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();
    public char getPattern() {
        return pattern;
    }
    public Location getLocation() {
        return location;
    }

    public String toString(){
        if(this instanceof Circle){
            return String.format("Circle: %s area=%d pattern=%c",getLocation().toString(),area(),getPattern());
        }
        else{
            return String.format("RightTriangle: %s area=%d pattern=%c",getLocation().toString(),area(),getPattern());
        }
    }
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
}

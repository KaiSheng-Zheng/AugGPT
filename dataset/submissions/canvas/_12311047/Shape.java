public abstract class Shape{
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern) {
        this.pattern=pattern;
        this.location=location;
    }
    public char getPattern(){
        return this.pattern;
    }
    public char[][] getGrids(){
        return this.grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public Location getLocation(){
        return this.location;
    }
    public int getX(){
        return this.location.getX();
    }
    public int getY(){
        return this.location.getY();
    }

}





public abstract class Shape {
    protected char[][] grids;    
    protected char pattern;      
    protected Location location; 
    protected int area;

    
    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }
    public Location getLocation() {
        return this.location;
    }

    
    public char[][] getGrids() {
        return grids;
    }

    
    public abstract char[][] fillGrids();

    
    public abstract void enlarge();

    
    public abstract void shrink();

    
    public abstract int area();

    
    @Override
    public String toString() {
        return String.format("%s: (%d,%d) area=%d pattern=%c",
                this.getClass().getSimpleName(),
                location.getX(), location.getY(),
                area(), pattern);
    }
}


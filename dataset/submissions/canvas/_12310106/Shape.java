
public abstract class Shape {
    protected char[][] grids;
    
    
    

    protected char pattern;
    

    protected Location location;
    

    protected int countPattern = 0;

    public Shape(Location location, char pattern) {
        
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
    

    public String toString(String type) {
        
        return String.format("%s: (%d,%d) area=%d pattern=%c",
                type, location.getX(), location.getY(), countPattern, pattern);
    }

    public int[] getLocationArr() {
        int[] locationArr = new int[2];
        locationArr[0] = this.location.getX();
        locationArr[1] = this.location.getY();
        return locationArr;
    }
}

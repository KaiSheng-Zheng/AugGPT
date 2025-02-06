

public abstract class Shape {
    protected int area;
    protected char[][] grids;
    // missing shrink() and enlarge()

    public boolean isOverLapconflict() {
        return overLapconflict;
    }

    public void setOverLapconflict(boolean overLapconflict) {
        this.overLapconflict = overLapconflict;
    }

    protected boolean overLapconflict;
    public boolean isOverLap() {
        return overLap;
    }
    public void setOverLap(boolean overLap) {
        this.overLap = overLap;
    }
    protected boolean overLap;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern){
        this.location=location;
        this.pattern=pattern;
        overLapconflict=true;
        overLap=false;
        area=0;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids(Location location,char[][] c);

    public abstract void fillOverlap(Location l,char[][] c);
    public abstract boolean judgeFull(Location location,char[][]c);


    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
    public String toString(){
        return String.format("%s: %s area=%d pattern=%c",this.getClass().getName(),this.location,this.area,this.pattern);
    }
}

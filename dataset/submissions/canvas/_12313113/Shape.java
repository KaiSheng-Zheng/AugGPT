public abstract class Shape implements Comparable{

    protected Location location;
    protected char pattern;
    protected char[][] grids;


    protected int area;

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

    public String toString(){
        return String.format("%s: %s area=%d pattern=%c",this.getClass().getName(),this.location,this.area,this.pattern);
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public int compareTo(Object o) {
        Shape b = (Shape) o;
        if (this.area()>b.area()){
            return 1;
        }else if(this.area()<b.area()){
            return -1;
        }else {
            if (this.pattern>((Shape) b).pattern){
                return 1;
            }else if (this.pattern<((Shape) b).pattern){
                return -1;
            }
        }
        return 0;
    }
}

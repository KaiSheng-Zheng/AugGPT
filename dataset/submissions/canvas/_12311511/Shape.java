public abstract class Shape implements Comparable<Shape> {

    protected Location location;
    protected char pattern;
    protected char[][] grids;
    private int x;
    private int y;

    protected int area;

    public Shape(Location location, char pattern) {
        this.location = location;
        x=location.getX();
        y=location.getY();
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
    public int compareTo(Shape s) {
        if (this.area<s.area){
            return -1;
        }
        if (this.area>s.area){
            return 1;
        }
        else {
            if (this.pattern<s.pattern){
                return -1;
            }
            else {
                return -1;
            }
        }
    }

    public char getPattern() {
        return pattern;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int compare(Shape s){
        if (x<s.x){
            return -1;
        }
        if (x>s.x){

            return 1;
        }
        else {
            if (y<s.y){
                return -1;
            }
            if (y>s.y){
                return 1;
            }
            else{
                if (pattern<s.pattern){
                    return -1;
                }
                else
                    return 1;
            }
        }
    }
}

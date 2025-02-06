public abstract class Shape implements Comparable<Shape>{
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids() {
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    @Override
    public int compareTo(Shape o) {
        if(this.area()<o.area()){
            return -1;
        }else if(this.area()==o.area()){
            if(this.pattern<o.pattern){
                return -1;
            }
            else{
                return 1;
            }
        }
        else {
            return 1;
        }
    }
}

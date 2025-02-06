abstract class Shape implements Comparable<Shape> {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    public Shape(Location location, char pattern){
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public int compareTo(Shape shape){
        if(this.location.getX()<shape.location.getX()){
            return -1;
        }
        else if(this.location.getX()>shape.location.getX()) {
            return 1;
        }
        else{
            if(this.location.getY()<shape.location.getY()){
                return -1;
            }
            else if(this.location.getY()>shape.location.getY()){
                return  1;
            }
            else{
                if(this.pattern<shape.pattern){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        }
    }
}
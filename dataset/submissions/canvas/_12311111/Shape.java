public abstract class Shape implements Comparable<Shape> {
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
    public String toString(){
        String string=this.getClass().getSimpleName()+": ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
        return string;
    }

    public int compareTo(Shape shape2) {
        if (this.area()>shape2.area()){
            return 1;
        }else if (this.area()==shape2.area()&&this.pattern>shape2.pattern){
            return 1;
        }else {
            return -1;
        }
    }


    public int compare(Shape shape2){
        if (this.location.getX()>shape2.location.getX()){
            return 1;
        }else if (this.location.getX()==shape2.location.getX()&&this.location.getY()>shape2.location.getY()){
            return 1;
        }else if (this.location.getX()==shape2.location.getX()&&this.location.getY()==shape2.location.getY()&&this.pattern>shape2.pattern){
            return 1;
        }else {
            return -1;
        }
    }
}

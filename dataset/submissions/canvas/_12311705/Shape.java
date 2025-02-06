public abstract class Shape  implements Comparable <Shape>{
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    String shape;
    public Shape(String shape,Location location,char pattern){
        this.shape=shape;
        this.location=location;
        this.pattern=pattern;

    }
    public Shape(Location location, char pattern){
        grids=new char[100][100];
        this.location=location;
        this.pattern=pattern;
    }
    public char[][] getGrids(){
        return this.grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    @Override
    public int compareTo(Shape o) {
        if (this.location.getX() < o.location.getX()) return -1;
        else if (this.location.getX() > o.location.getX()) return 1;
        else {
            if (this.location.getY() < o.location.getY()) return -1;
            else if (this.location.getY() > o.location.getY()) return 1;
            else return this.pattern - o.pattern;
        }
    }

}

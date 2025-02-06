public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected int count;
    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
    }
    public char[][] getGrids(){
        return grids;
    }
    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public int getX(){
        return this.location.getX();
    }
    public int getY(){
        return this.location.getY();
    }
    public void setCount(int count){this.count = count;}
    public int getPattern(){
        return (int)pattern;
    }
}

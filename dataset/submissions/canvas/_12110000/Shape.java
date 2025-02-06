public abstract class Shape implements Comparable<Shape>{
    protected char[][] grids;
    protected char pattern;
    protected Location location;
    protected int sortOption = 0; // 1: by area;  2: by location


    public Shape(Location location, char pattern){
        this.location = location;
        this.pattern = pattern;
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
        if(sortOption == 1){
            if(this.area() == o.area()){
                return this.pattern - o.pattern;
            }
            else{
                return (int)(this.area() - o.area());
            }

        }
        else if(sortOption == 2){
            if(this.location.getX() == o.location.getX()){
                if(this.location.getY() == o.location.getY()){
                    return this.pattern - o.pattern;
                }
                else{
                    return this.location.getY() - o.location.getY();
                }
            }
            else{
                return this.location.getX() - o.location.getX();
            }
        }
        return 0;
    }
}

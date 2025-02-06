public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
        this.pattern = pattern;
        this.location = location;
    }

    public char[][] getGrids() {
        return grids;
    }

    public void setGrids(char[][] grids) {
        this.grids = grids;
    }

    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();
    public int compareByArea(Shape s){
        if(area() > s.area()){
            return 1;
        }else if(area() == s.area()){
            if(pattern >s.pattern) {
                return 1;
            }else {return -1;}
        }else {return -1;}
    }
    public int compareByLocation(Shape s){
        if(location.getX() > s.getLocation().getX()){
            return 1;
        }else if(location.getX() == s.getLocation().getX()){
            if(location.getY() > s.getLocation().getY()) {
                return 1;
            }else if(location.getY() == s.getLocation().getY()){
                if(pattern >s.pattern) {
                    return 1;
                }else {return -1;}
            }else {return -1;}
        }else {return -1;}
    }

    public Location getLocation() {
        return location;
    }
}
public abstract class Shape implements Comparable<Shape>{
    protected char[][] grids;
    protected char pattern;
    protected Location location;


    public Shape(Location location, char pattern){
        location=this.location;
        pattern=this.pattern;
        this.fillGrids();
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();
    public abstract void enlarge();
    public abstract void shrink();
    public abstract int area();

    public char getPattern() {
        return pattern;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public int compareTo(Shape o) {
        if (o.getLocation().getX()>this.getLocation().getX()){
            return -1;
        }else if (o.getLocation().getX()<this.getLocation().getX()){
            return 1;
        }else {
            if (o.getLocation().getY()>this.getLocation().getY()){
                return -1;
            }else if (o.getLocation().getY()<this.getLocation().getY()){
                return 1;
            }else {
                if (this.getPattern()<o.getPattern()){
                    return -1;
                }else if (this.getPattern()>o.getPattern()){
                    return 1;
                }else {
                    return 0;
                }
            }
        }
    }
}
public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern, int radius){
        this.location=location;
        this.pattern=pattern;
        this.radius=radius;
        fillGrids();
    }
    public void fillGrids(){
        grids=new char[radius*2][radius*2];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                double d=Math.sqrt((radius-i-1)*(radius-i-1)+(radius-j-1)*(radius-j-1));
                if (d<radius)
                    grids[i][j]=pattern;
                else
                    grids[i][j]=' ';
            }
        }
        for (int i = radius; i < 2*radius; i++) {
            for (int j = 0; j < radius; j++) {
                double d=Math.sqrt((radius-i)*(radius-i)+(radius-j-1)*(radius-j-1));
                if (d<radius)
                    grids[i][j]=pattern;
                else
                    grids[i][j]=' ';
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = radius; j < 2*radius; j++) {
                double d=Math.sqrt((radius-i-1)*(radius-i-1)+(radius-j)*(radius-j));
                if (d<radius)
                    grids[i][j]=pattern;
                else
                    grids[i][j]=' ';
            }
        }
        for (int i = radius; i < 2*radius; i++) {
            for (int j = radius; j < 2*radius; j++) {
                double d=Math.sqrt((radius-i)*(radius-i)+(radius-j)*(radius-j));
                if (d<radius)
                    grids[i][j]=pattern;
                else
                    grids[i][j]=' ';
            }
        }
    }
    public void enlarge(){
        radius+=1;
        grids=new char[2*radius][2*radius];
        fillGrids();
    }
    public void shrink(){
        radius-=1;
        grids=new char[2*radius][2*radius];
        fillGrids();
    }
    public int area(){
        int counter=0;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if (grids[i][j]==pattern)
                    counter++;
            }
        }
        return counter;
    }
    public String toString(){
        return "Circle: "+this.location.toString()+" area="+this.area()+" pattern="+pattern;
    }

    @Override
    public int compare(Shape o1, Shape o2) {
        Location loc1 = o1.getLocation();
        Location loc2 = o2.getLocation();
        int compareX = Integer.compare(loc1.getX(), loc2.getX());
        int compareY=Integer.compare(loc1.getY(),loc2.getY());
        int comparePattern=Character.compare(o1.pattern,o2.pattern);
        if (compareX != 0) {
            return compareX;
        } else if (compareY!=0){
            return compareY;
        }
        else
            return comparePattern;
    }
}

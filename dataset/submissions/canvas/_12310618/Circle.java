
public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public char getPattern() {
        return super.pattern;
    }

    @Override
    public void fillGrids() {
        super.grids=new char[2*radius][2*radius];
        for (int i = 0; i <radius; i++) {
            for (int j = 0; j <radius; j++) {
                if(Math.pow(radius-i-1,2)+Math.pow(radius-j-1,2)<Math.pow(radius,2)){
                    grids[i][j]=pattern;
                }
                else {grids[i][j]=' ';}
            }
        }
        for (int i =0; i <radius; i++) {
            for (int j =radius; j <2*radius; j++) {
                grids[i][j]=grids[i][2*radius-1-j];
            }
        }
        for (int i = radius; i <2*radius; i++) {
            for (int j = 0; j <2*radius; j++) {
                grids[i][j]=grids[2*radius-1-i][j];
            }
        }
    }

    @Override
    public void enlarge() {
        radius=radius+1;
        super.grids=new char[2*radius][2*radius];
        fillGrids();
    }

    @Override
    public void shrink() {
        radius=radius-1;
        super.grids=new char[2*radius][2*radius];
        fillGrids();
    }


    @Override
    public int area() {
        return count();
    }

    @Override
    public String toString() {
        return "Circle: ("+ location.getX()+','+location.getY()+") area="+area()+" pattern="+pattern;

    }
}

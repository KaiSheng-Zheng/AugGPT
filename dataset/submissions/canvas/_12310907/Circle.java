
public class Circle extends Shape {
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private int radius = 0;



    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        // instantiate the attribute grids
        grids = new char[2*radius][2*radius];
        // initialize grids with with space
        for (int i = 0; i <2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                grids[i][j] = ' ';
            }
        }
        //center (radius,radius)
        //upLeft
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (Tools.findTheLength(i,j,radius-1,radius-1)<radius){
                    grids[i][j] = pattern;
                }
            }
        }
        //upRight
        for (int i = radius; i < 2*radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (Tools.findTheLength(i,j,radius,radius - 1)<radius){
                    grids[j][i] = pattern;
                }
            }
        }

        //downRight
        for (int i = radius; i < 2*radius; i++) {
            for (int j = radius; j < 2*radius; j++) {
                if (Tools.findTheLength(i,j,radius,radius)<radius){
                    grids[i][j] = pattern;
                }
            }
        }
        //downLeft
        for (int i = radius; i < 2*radius; i++) {
            for (int j = 0; j <radius; j++) {
                if (Tools.findTheLength(i,j,radius,radius-1)<radius){
                    grids[i][j] = pattern;
                }
            }
        }
    }




    @Override
    public void enlarge() {
        radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        fillGrids();
    }

    @Override
    public int area() {
        return areaCount(grids,pattern);
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }

}

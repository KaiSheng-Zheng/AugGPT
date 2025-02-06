

public class Circle extends Shape {
    private int radius;
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

    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        this.fillGrids();
    }
    public void fillGrids(){
        grids =new char[2*radius][2*radius];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                grids[i][j]=' ';
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if((radius-i-1)*(radius-i-1)+(radius-j-1)*(radius-j-1)<radius*radius){
                    grids[i][j]=pattern;
                }
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = radius; j < 2*radius; j++) {
                if((radius-i-1)*(radius-i-1)+(radius-j)*(radius-j)<radius*radius){
                    grids[i][j]=pattern;
                }
            }
        }
        for (int i = radius; i < 2*radius; i++) {
            for (int j = 0; j < radius; j++) {
                if((radius-i)*(radius-i)+(radius-j-1)*(radius-j-1)<radius*radius){
                    grids[i][j]=pattern;
                }
            }
        }
        for (int i = radius; i < 2*radius; i++) {
            for (int j = radius; j < 2*radius; j++) {
                if((radius-i)*(radius-i)+(radius-j)*(radius-j)<radius*radius){
                    grids[i][j]=pattern;
                }
            }
        }
    }

    @Override
    public int area() {
        int a=0;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if (grids[i][j]==pattern){
                    a++;
                }
            }
        }
        return a;
    }

    public String toString(){
        String string = "Circle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
        return string;
    }
}
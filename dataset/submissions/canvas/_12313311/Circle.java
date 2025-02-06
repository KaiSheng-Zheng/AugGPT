import java.util.Comparator;

public class Circle extends Shape {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public Circle(Location location, char pattern, int radius) {
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }

    public int distance(int x,int y) {
        return (x-radius)*(x-radius)+(y-radius)*(y-radius);
    }
    public void fillGrids() {
        grids=new char[2*radius][2*radius];
        for(int i=0;i<2*radius;i++) {
            for(int j=0;j<2*radius;j++) {
                grids[i][j]=' ';
            }
        }
        for(int i=0;i<radius*2;i++) {
            for(int j=0;j<radius*2;j++) {
                if(i<radius) {
                    if(j<radius) {
                        if(distance(i+1,j+1)<radius*radius) {
                            grids[i][j]=pattern;
                        }
                    }
                    else {
                        if(distance(i+1,j)<radius*radius) {
                            grids[i][j]=pattern;
                        }
                    }
                }
                else {
                    if(j<radius) {
                        if(distance(i,j+1)<radius*radius) {
                            grids[i][j]=pattern;
                        }
                    }
                    else {
                        if(distance(i,j)<radius*radius) {
                            grids[i][j]=pattern;
                        }
                    }
                }
            }
        }
    }

    public void enlarge() {
        this.radius+=1;
        fillGrids();
    }

    public void shrink() {
        this.radius-=1;
        fillGrids();
    }

    public int area() {
        int area=0;
        for(int i=0;i<2*radius;i++) {
            for(int j=0;j<2*radius;j++) {
                if(grids[i][j]==pattern)
                    area++;
            }
        }
        return area;
    }

    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }
}

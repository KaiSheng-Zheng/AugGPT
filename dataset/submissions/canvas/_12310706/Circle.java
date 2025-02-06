
import java.util.SplittableRandom;

import static java.lang.Math.*;
public class Circle
extends Shape
{
    private int radius;
    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }
    public void setRadius(int radius) {
        this.radius = radius;
        fillGrids();
    }
    public int getRadius() {
        return radius;
    }
    @Override public void fillGrids() {
        int r=radius;
        m=n=2*r;
        grids = new char[m][n];
        for (int i = 0; i <r; i++) {
            for (int j = 0; j <r; j++) {
                if(pow(r-(i+1),2)+pow(r-(j+1),2)<pow(r,2)-0.0001)
                    grids[i][j] =grids[2*r-1-i][j]=grids[i][2*r-1-j]=grids[2*r-1-i][2*r-1-j]= pattern;
                else
                    grids[i][j] =grids[2*r-1-i][j]=grids[i][2*r-1-j]=grids[2*r-1-i][2*r-1-j]=EMPTY;
            }
        }
    }
    @Override public void enlarge() {
        radius++;
        fillGrids();
    }
    @Override public void shrink() {
        radius--;
        fillGrids();
    }
    @Override public String toString(){
        return String.format("Circle: %s area=%d pattern=%c",location,area(),pattern);
    }
}


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Circle extends Shape{
    int radius;
    char[][]copy=new char[1000][1000];
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    int area=0;
    @Override
    public void fillGrids() {
        int area2=0;
        grids=new char[2*radius][2*radius];
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if (ifIn(i,j,radius)||ifIn(i+1,j,radius)||ifIn(i,j+1,radius)||ifIn(i+1,j+1,radius)){
                    copy [i][j]=pattern;
                    area2++;
                }
                else {
                    copy [i][j]= ' ';
                }
            }
        }
        for (int i = 0; i < 2*radius; i++) {
            System.arraycopy(copy[i], 0, grids[i], 0, 2*radius);
        }
        area=area2;
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
        return area;
    }

    public String toString(){
        return getClass().getName()+": "+location.toString()+" area="+ area + " pattern="+pattern;
    }

    public boolean ifIn(int x, int y, int radius){
        if ((x-radius)*(x-radius)+(y-radius)*(y-radius)<radius*radius){
            return true;
        }
        else {
            return false;
        }
    }

}

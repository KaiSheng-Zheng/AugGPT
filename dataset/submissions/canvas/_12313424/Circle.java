import java.lang.Math;
public class Circle extends Shape{

    private int radius;




    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
//        this.pattern=pattern;
//        this.location=location;
        this.radius=radius;

        this.fillGrids();
    }



    @Override
    public void fillGrids() {
        super.grids=new char[radius*2][radius*2];
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                int r = radius - 1;
                if (i <= r & j <= r) {
                    if ((r - i) * (r - i) + (r - j) * (r - j) < radius * radius) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j]=' ';
                    }
                }
                if (i <= r & j > r) {
                    if ((r - i) * (r - i) + (r - j + 1) * (r - j + 1) < radius * radius) {
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j]=' ';
                    }
                }
                    if (i > r & j <= r) {
                        if ((r - i + 1) * (r - i + 1) + (r - j) * (r - j) < radius * radius) {
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j]=' ';
                        }
                    }

                    if (i > r & j > r) {
                        if ((r - i + 1) * (r - i + 1) + (r - j + 1) * (r - j + 1) < radius * radius) {
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j]=' ';
                        }
                    }

            }
        }
    }

    @Override
    public void enlarge() {
          this.radius+=1;
        grids=new char[radius*2][radius*2];
          fillGrids();
    }

    @Override
    public void shrink() {
        this.radius-=1;
        grids=new char[radius*2][radius*2];
        fillGrids();
    }

    @Override
    public int area() {

        int a=0;
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (grids[i][j]==pattern){
                    a+=1;
                }

            }
        }
        return a;
    }


    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%s",location.getX(),location.getY(),area(),pattern);
    }


}

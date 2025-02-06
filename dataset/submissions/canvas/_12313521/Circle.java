public class Circle extends Shape {
    private int radius;
    private int sum=0;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        grids =new char[2*radius][2*radius];
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                grids[i][j]=' ';
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if(((i+1-radius)*(i+1-radius)+(j+1-radius)*(j+1-radius))<radius*radius){
                    grids[i][j]=pattern;
                    grids[i][2*radius-1-j]=pattern;
                    grids[2*radius-1-i][j]=pattern;
                    grids[2*radius-1-i][2*radius-1-j]=pattern;
                    sum++;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        sum=0;
        radius=radius+1;
        grids =new char[2*radius][2*radius];
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                grids[i][j]=' ';
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if(((i+1-radius)*(i+1-radius)+(j+1-radius)*(j+1-radius))<radius*radius){
                    grids[i][j]=pattern;
                    grids[i][2*radius-1-j]=pattern;
                    grids[2*radius-1-i][j]=pattern;
                    grids[2*radius-1-i][2*radius-1-j]=pattern;
                    sum++;
                }
            }
        }
    }

    @Override
    public void shrink() {
        //incorrect
        sum=0;
        radius=radius-1;
        grids =new char[2*radius][2*radius];
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                grids[i][j]=' ';
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if(((i+1-radius)*(i+1-radius)+(j+1-radius)*(j+1-radius))<radius*radius){
                    grids[i][j]=pattern;
                    grids[i][2*radius-1-j]=pattern;
                    grids[2*radius-1-i][j]=pattern;
                    grids[2*radius-1-i][2*radius-1-j]=pattern;
                    sum++;
                }
            }
        }
    }

    @Override
    public int area() {
        return sum*4;
    }

    public String toString(){
        return "Circle: "+"("+location.getX()+","+location.getY()+") "+"area="+sum*4+" pattern="+pattern;
    }
}

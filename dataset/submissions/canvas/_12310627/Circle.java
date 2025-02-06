public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        sum=0;
        this.grids = new char[2*radius][2*radius];
        for (int i = 0; i < grids.length/2; i++) {
            for (int j = 0; j < grids[i].length/2; j++) {
                if((i+1-radius)*(i+1-radius)+(j+1-radius)*(j+1-radius)<radius*radius){
                    grids[i][j]=pattern;
                    grids[i][grids[i].length-1-j]=pattern;
                    grids[grids.length-1-i][j]=pattern;
                    grids[grids.length-1-i][grids[i].length-1-j]=pattern;
                    sum+=4;
                }
                else {
                    grids[i][j]=' ';
                    grids[i][grids[i].length-1-j]=' ';
                    grids[grids.length-1-i][j]=' ';
                    grids[grids.length-1-i][grids[i].length-1-j]=' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.radius+=1;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        this.radius-=1;
        this.fillGrids();
    }

    @Override
    public int area() {
        return sum;
    }

}

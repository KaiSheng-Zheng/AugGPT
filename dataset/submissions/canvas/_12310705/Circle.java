public class Circle extends Shape {
    private int radius;

    public Circle(Location location,char pattern,  int radius) {
        super(pattern, location);
        this.radius = radius;
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[2*radius][2*radius];
        int r2 = radius*radius;
        for(int i = 0;i<=radius-1;i++){
            for(int j = 0 ;j<=radius-1;j++){
                if((i+1-radius)*(i+1-radius)+(j+1-radius)*(j+1-radius)<r2){
                    grids[i][j]=pattern;
                    grids[i][2*radius-1-j]=pattern;
                    grids[2*radius-1-i][j]=pattern;
                    grids[2*radius-1-i][2*radius-1-j]=pattern;
                }
                else{grids[i][j]=' ';
                    grids[i][2*radius-1-j]=' ';
                    grids[2*radius-1-i][j]=' ';
                    grids[2*radius-1-i][2*radius-1-j]=' ';

                }
            }

        }
    }

    @Override
    public void enlarge() {
        this.radius++;
        this.fillGrids();

    }

    @Override
    public void shrink() {
        this.radius--;
        this.fillGrids();

    }

    @Override
    public int area() {
        int count = 0;
        int r2 = radius*radius;
        for(int i = 0;i<=radius-1;i++){
            for(int j = 0 ;j<=radius-1;j++){
                if((i+1-radius)*(i+1-radius)+(j+1-radius)*(j+1-radius)<r2){
                    count++;
                }
            }

        }
        return 4*count;
    }

    @Override
    public String toString() {
        return "Circle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
    }
}
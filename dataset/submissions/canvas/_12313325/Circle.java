public class Circle extends Shape{
    private int radius;

    public Circle(Location location,char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        grids=new char[2*radius][2*radius];
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                grids[i][j]=' ';
            }
        }
        for (int i = 1; i <= radius ; i++) {
            for (int j = 1; j <= radius; j++) {
                double distance = Math.sqrt((radius-i)*(radius-i)+(radius-j)*(radius-j));
                if (distance<radius) {
                    grids[i-1][j-1]=pattern;
                    grids[i-1][2*radius-j]=pattern;
                    grids[2*radius-i][j-1]=pattern;
                    grids[2*radius-i][2*radius-j]=pattern;
                }
            }
        }
    }
    @Override
    public void enlarge() {
        radius+=1;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius-=1;
        fillGrids();
    }

    @Override
    public int area() {
        int count=0;
        for (int i = 1; i <= radius ; i++) {
            for (int j = 1; j <= radius; j++) {
                double distance = Math.sqrt((radius-i)*(radius-i)+(radius-j)*(radius-j));
                if (distance<radius) {
                    count+=4;
                }
            }
        }
        return count;
    }

    public String toString(){
        return ("Circle: (%d,%d) area=%d pattern=%c".formatted(this.getLocation().getX(),this.getLocation().getY(),this.area(),this.getPattern()));
    }
}

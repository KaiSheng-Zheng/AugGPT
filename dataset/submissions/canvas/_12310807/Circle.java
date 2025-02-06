public class Circle extends Shape{
    private int radius;//1 to 15
    private int area;
    public Circle(Location location,char pattern,int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    public boolean pointInsideCircle(int i,int j){
        return distance(i + 1, j + 1) < radius;
    }

    private double distance(int i, int j) {
        return Math.sqrt((radius-i)*(radius-i)+(radius-j)*(radius-j));
    }

    @Override
    public void fillGrids() {
        area=0;
        grids = new char[2*radius][2*radius];
        for(int i=0;i<radius;i++){
            for (int j = 0; j < radius; j++) {
                if(pointInsideCircle(i,j)){
                    grids[i][j]=pattern;
                    grids[2*radius-1-i][2*radius-1-j]=pattern;
                    grids[2*radius-1-i][j]=pattern;
                    grids[i][2*radius-1-j]=pattern;
                    area+=4;
                }
                else {
                    grids[i][j]=' ';
                    grids[2*radius-1-i][2*radius-1-j]=' ';
                    grids[2*radius-1-i][j]=' ';
                    grids[i][2*radius-1-j]=' ';
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
        return area;
    }

    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),this.area(),pattern);
    }
    public char pattern(){ return pattern;}
}

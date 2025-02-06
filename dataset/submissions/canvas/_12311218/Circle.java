public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();

    }

    @Override
    public void fillGrids() {
        area=0;
        super.grids=new char[radius*2][radius*2];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j <radius; j++) {
                if (checkInside(i,j,radius)){
                    grids[i][j]=pattern;
                    grids[i][radius*2-1-j]=pattern;
                    grids[radius*2-1-i][j]=pattern;
                    grids[radius*2-1-i][radius*2-1-j]=pattern;
                    area+=4;
                }
                else {
                    grids[i][j]=' ';
                    grids[i][radius*2-1-j]=' ';
                    grids[radius*2-1-i][j]=' ';
                    grids[radius*2-1-i][radius*2-1-j]=' ';
                }
            }
        }
    }

    public static boolean checkInside(int x,int y,int radius){
        double squareDistance=(x+1-radius)*(x+1-radius)+(y+1-radius)*(y+1-radius);
        return (squareDistance - ((radius) * (radius ))) <0;

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
        return area;
    }
    public String toString(){
        return String.format("Circle: "+location+" area="+area+" pattern="+pattern);

    }
}

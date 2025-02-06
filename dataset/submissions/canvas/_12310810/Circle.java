

public class Circle extends Shape {


    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius=radius;
        fillGrids();
    }
    private int radius;
    int count=0;
    private char[][]grids=new char[radius*2][radius*2];


    @Override
    public char[][] getGrids() {
        return fillGrids();
    }

    @Override
    public char[][] fillGrids() {
        count=0;
        int bian=radius*2;
        char[][] grids=new char[bian][bian];
        for (int i = 0; i < bian; i++) {
            for (int i1 = 0; i1 < bian; i1++) {
                double distance1=Math.pow(i-radius,2)+Math.pow(i1-radius,2);
                double distance2=Math.pow(i+1-radius,2)+Math.pow(i1+1-radius,2);
                double distance3=Math.pow(i+1-radius,2)+Math.pow(i1-radius,2);
                double distance4=Math.pow(i-radius,2)+Math.pow(i1+1-radius,2);
                double distance=Math.min(distance4,Math.min(distance3,Math.min(distance1,distance2)));
                if(distance<radius*radius){
                    grids[i][i1]=pattern;
                    count++;
                }else{
                    grids[i][i1]=' ';
                }
            }
        }
        return grids;
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
        return count;
    }
    public String toString(){
        return "Circle: "+location+" area="+area()+" pattern="+pattern;
    }
}

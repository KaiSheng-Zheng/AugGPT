public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius=radius;
        this.grids=new char[2*radius][2*radius];
        fillGrids();
    };

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    public void fillGrids() {
        double d=0;
        for(int i=0;i<radius;i++){
            for (int j=0;j<radius;j++){
            d=(radius-i-1)*(radius-i-1)+(radius-j-1)*(radius-j-1);
            if (d<radius*radius){
                grids[i][j]=pattern;
                grids[i][2*radius-j-1]=pattern;
                grids[2*radius-i-1][j]=pattern;
                grids[2*radius-i-1][2*radius-j-1]=pattern;
            }
            else {
                grids[i][j]=' ';
                grids[i][2*radius-j-1]=' ';
                grids[2*radius-i-1][j]=' ';
                grids[2*radius-i-1][2*radius-j-1]=' ';
            }
            }
        }
    }
    public void enlarge(){
        this.radius=radius+1;
        this.grids=new char[2*radius][2*radius];
        fillGrids();
    }
    public void shrink(){
        this.radius=radius-1;
        this.grids=new char[2*radius][2*radius];
        fillGrids();
    }

    @Override
    public int area() {
        int t=0;
        for(int i=0;i<2*radius;i++){
            for (int j=0;j<2*radius;j++){
                if(grids[i][j]==pattern){
                    t=t+1;
                }
                }
            }
        return t;
    }
    public String toString(){
        return "Circle: "+location.toString()+" area="+area()+" pattern="+pattern;
    }
}

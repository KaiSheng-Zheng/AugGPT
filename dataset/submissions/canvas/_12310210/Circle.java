public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius=radius;
        this.grids = new char[2*radius][2*radius];
        fillGrids();
    }

    public void fillGrids(){
        grids=new char[2*radius][2*radius];
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                grids[i][j]=' ';
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                int k=(radius-1-i)*(radius-1-i)+(radius-1-j)*(radius-1-j);
                if(k<radius*radius){
                    grids[i][j]=pattern;
                    grids[i][2*radius-1-j]=pattern;
                    grids[2*radius-1-i][j]=pattern;
                    grids[2*radius-1-i][2*radius-1-j]=pattern;
                }
            }
        }
    }
    public void enlarge(){
        this.radius++;
        fillGrids();
    }
    public void shrink(){
        this.radius--;
        fillGrids();
    }
    public int area(){
        int t=0;
        for (int i = 0; i <2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if(grids[i][j]==pattern){t++;}
            }
        }
        return t;
    }
    public String toString(){
        return "Circle: "+"("+location.getX()+","+location.getY()+")"+" area="+area()+" pattern="+pattern;
    }
}

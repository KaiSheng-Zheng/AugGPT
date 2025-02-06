public class Circle extends Shape {
    private int radius;
    char[][]grids;
    public int getRadius() {return radius;}
    @Override
    public char[][] getGrids() {return grids;}
    public void setGrids(char[][] grids) {this.grids = grids;}
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        this.grids=new char[2*radius][2*radius];
        fillGrids();
    }
    public void setRadius(int radius) {this.radius = radius;}
    public void fillGrids(){
        this.grids=new char[2*radius][2*radius];
        for(int i=0;i<radius;i++){
            for(int j=0;j<radius;j++){
                int a=(radius-i-1)*(radius-i-1)+(radius-j-1)*(radius-j-1);
                if(a<radius*radius){
                    grids[i][j]=pattern;
                }
                else grids[i][j]=' ';
            }
        }
        for(int i=radius;i<2*radius;i++){
            for(int j=0;j<radius;j++){
                int a=(radius-i)*(radius-i)+(radius-j-1)*(radius-j-1);
                if(a<radius*radius){grids[i][j]=pattern;}
                else grids[i][j]=' ';
            }
        }
        for(int i=0;i<radius;i++){
            for(int j=radius;j<2*radius;j++){
                int a=(radius-i-1)*(radius-i-1)+(radius-j)*(radius-j);
                if(a<radius*radius){
                    grids[i][j]=pattern;
                }
                else grids[i][j]=' ';
            }
        }
        for(int i=radius;i<2*radius;i++){
            for(int j=radius;j<2*radius;j++){
                int a=(radius-i)*(radius-i)+(radius-j)*(radius-j);
                if(a<radius*radius){
                    grids[i][j]=pattern;
                }
                else grids[i][j]=' ';
            }
        }
    }

    public void enlarge(){
        setRadius(radius+1);
        fillGrids();
    }

    public void shrink(){
        setRadius(radius-1);
        fillGrids();
    }
    public int area(){
        int s=0;
        for(int i=0;i<2*radius;i++){
            for(int j=0;j<2*radius;j++){
                if(grids[i][j]==pattern){s++;}
            }
        }
        return s;
    }

    public String toString(){
        return "Circle: "+location.toString()+" area="+area()+" pattern="+pattern;
    }
}

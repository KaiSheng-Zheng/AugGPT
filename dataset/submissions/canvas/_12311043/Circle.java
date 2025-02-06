public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        grids=new char[2*radius][2*radius];
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids(){
        char[][] Grids=new char[2*radius][2*radius];
        for(int i=0;i<2*radius;i++){
            for(int j=0;j<2*radius;j++){
                Grids[i][j]=' ';
            }
        }
        for(int i=0;i<radius;i++){
            for(int j=0;j<radius;j++){
                if(Math.abs(i+1-radius)*Math.abs(i+1-radius)+Math.abs(j+1-radius)*Math.abs(j+1-radius)<radius*radius){
                    Grids[i][j]=pattern;
                    Grids[i][2*radius-1-j]=pattern;
                    Grids[2*radius-1-i][j]=pattern;
                    Grids[2*radius-1-i][2*radius-1-j]=pattern;
                }
            }
        }
        for(int i=0;i<2*radius;i++){
            for(int j=0;j<2*radius;j++){
                grids[i][j]=Grids[i][j];
            }
        }
    }
    @Override
    public void enlarge(){
        radius++;
        grids=new char[2*radius][2*radius];
        fillGrids();
    }
    @Override
    public void shrink(){
        radius--;
        grids=new char[2*radius][2*radius];
        fillGrids();
    }
    @Override
    public int area(){
        int count=0;
        for(int i=0;i<2*radius;i++){
            for(int j=0;j<2*radius;j++){
                if(grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){
        int x= location.getX();
        int y= location.getY();
        int area=area();
        return String.format("Circle: (%d,%d) area=%d pattern=%c",x,y,area,pattern);
    }
}
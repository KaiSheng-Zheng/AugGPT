public class Circle extends Shape{
    private int radius;
    private int count=0;
    public Circle(Location location,char pattern,int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        // clear the counter before counting!
        grids=new char[2*radius][2*radius];
        for(int i=0;i<2*radius;i++) {
            for (int j = 0; j < 2 * radius; j++){
                if((Math.pow(radius-i,2)+Math.pow(radius-j,2)<Math.pow(radius,2))|(Math.pow(radius-i-1,2)+Math.pow(radius-j,2)<Math.pow(radius,2))|(Math.pow(radius-i,2)+Math.pow(radius-j-1,2)<Math.pow(radius,2))|(Math.pow(radius-i-1,2)+Math.pow(radius-j-1,2)<Math.pow(radius,2))){
                    grids[i][j]=pattern;
                    count++;
                }
                else{
                    grids[i][j]=' ';
                }
            }
        }
    }
    public void enlarge(){
        count=0;
        radius++;
        fillGrids();
    }
    public void shrink(){
        count=0;
        radius--;
        fillGrids();
    }
    public int area(){
        return count;
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),count,pattern);
    }
}

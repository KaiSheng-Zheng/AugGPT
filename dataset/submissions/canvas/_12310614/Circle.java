import static java.lang.Math.*;
public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids(location,pattern,radius);
    }
    public double distance(int x,int y,int a,int b){
        double d1 =pow(x+1-a,2)+pow(y+1-b,2);
        double d2 =pow(x+1-a,2)+pow(y-b,2);
        double d3 =pow(x-a,2)+pow(y+1-b,2);
        double d4 =pow(x-a,2)+pow(y-b,2);
        return min(min(d1,d2),min(d3,d4));
    }

    // missing method: fillGrids(), with empty parameter list
    public void fillGrids(Location location,char pattern,int radius){
        grids= new char[2*radius+location.getX()][2*radius+location.getY()];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (distance(i,j,location.getX()+radius,location.getY()+radius)<pow(radius,2)){
                    grids[i][j]=pattern;
                }
                else grids[i][j]=' ';
            }
        }
    }
    //public void fillGrids(Location location,char pattern,int radius){
//    grids= new char[2*radius][2*radius];
//    String a =" ";
//    for (int i = 0; i < grids.length; i++) {
//        for (int j = 0; j < grids[0].length; j++) {
//            if (distance(i,j,radius,radius)<pow(radius,2)){
//                grids[i][j]=pattern;
//            }
//            else grids[i][j]=a.charAt(0);
//        }
//    }
//}
    public void enlarge(){
        radius++;
        fillGrids(location,pattern,radius);
    }
    public void shrink(){
        if (radius>1){
            radius--;
            fillGrids(location,pattern,radius);
        }
    }
    public int area(){
        int num = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j]==pattern){
                    num++;
                }
            }
        }
        return num;
    }
    public String toString(){
        return String.format("Circle: %s area=%d pattern=%s",location.toString(),area(),pattern);
    }

    public static void main(String[] args) {
        Location location = new Location(0, 0);
        Circle circle = new Circle(location, 'C', 1);

    }
}

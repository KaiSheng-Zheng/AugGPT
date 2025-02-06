public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        grids=new char[2*radius][2*radius];
        this.radius=radius;
        this.fillGrids();
    }
    public void fillGrids(){
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                 if (i<=radius-1&&j<=radius-1){
                     if ((Math.pow(radius-i-1,2)+Math.pow(radius-j-1,2)<Math.pow(radius,2))){
                         grids[i][j]=pattern;
                     }
                 }
                 if (i<=radius-1&&j>=radius){
                     if ((Math.pow(radius-i-1,2)+Math.pow(radius-j,2)<Math.pow(radius,2))){
                         grids[i][j]=pattern;
                     }
                 }
                 if (i>=radius&&j<=radius-1){
                     if ((Math.pow(radius-i,2)+Math.pow(radius-j-1,2)<Math.pow(radius,2))){
                         grids[i][j]=pattern;
                     }
                 }
                 if (i>=radius&&j>=radius){
                     if ((Math.pow(radius-i,2)+Math.pow(radius-j,2)<Math.pow(radius,2))){
                         grids[i][j]=pattern;
                     }
                 }
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j]!=pattern){
                    grids[i][j]=' ';
                }
            }
        }
    }
    public void enlarge(){
        radius+=1;
        grids=new char[2*radius][2*radius];
        this.fillGrids();
    }
    public void shrink(){
        radius-=1;
        grids=new char[2*radius][2*radius];
        this.fillGrids();
    }
    public int area(){
        int count=0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }
}

public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        fillGrids();
    }
    public void fillGrids(){
        grids = new char[radius*2][radius*2];
        for (int i =0;i<radius*2;i++){
            for (int j =0;j<radius*2;j++){
                if (i<radius&&j<radius){
                    if ((radius-i-1)*(radius-i-1)+(radius-j-1)*(radius-j-1)<radius*radius){
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
                if (i<radius&&j>=radius){
                    if ((radius-i-1)*(radius-i-1)+(radius-j)*(radius-j)<radius*radius){
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
                if (i>=radius&&j<radius){
                    if ((radius-i)*(radius-i)+(radius-j-1)*(radius-j-1)<radius*radius){
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
                if (i>=radius&&j>=radius){
                    if ((radius-i)*(radius-i)+(radius-j)*(radius-j)<radius*radius){
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }
    public void enlarge(){
        radius = radius+1;
        fillGrids();
    }
    public void shrink(){
        radius = radius-1;
        fillGrids();
    }
    public int area(){
        int a =0;
        for (int i =0;i<radius*2;i++){
            for (int j=0;j<radius*2;j++){
                if (grids[i][j]==pattern){
                    a++;
                }
            }
        }
        return a;
    }
    public String toString(){

        return String.format("Circle: "+location+" "+"area="+area()+" pattern="+pattern);
    }

}

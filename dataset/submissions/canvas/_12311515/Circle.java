public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        char [][] grids1 = new char [radius*2][radius*2];
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if((((radius-i)*(radius-i)+(radius-j)*(radius-j))<radius*radius)||(((radius-1-i)*(radius-1-i)+(radius-j)*(radius-j))<radius*radius)||(((radius-i)*(radius-i)+(radius-1-j)*(radius-1-j))<radius*radius)||(((radius-1-j)*(radius-1-j)+(radius-1-i)*(radius-1-i))<radius*radius)){
                    grids1[i][j]=pattern;
                }
                else {
                    grids1[i][j]=' ';
                }
            }
        }
        super.grids=grids1;
    }

    @Override
    public void enlarge() {
        radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int cout=0;
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if(super.grids[i][j]==pattern){
                    cout++;
                }
            }
        }
        return cout;
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }
}

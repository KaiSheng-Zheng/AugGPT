public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }


    public void fillGrids(){
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                double distance = (radius-i-1)*(radius-i-1) + (radius-j-1)*(radius-j-1);
                if(distance < radius*radius){
                    grids[i][j]=pattern;
                    grids[radius*2-1-i][j]=pattern;
                    grids[i][radius*2-1-j]=pattern;
                    grids[radius*2-1-i][radius*2-1-j]=pattern;
                }else{
                    grids[i][j]=' ';
                    grids[radius*2-1-i][j]=' ';
                    grids[i][radius*2-1-j]=' ';
                    grids[radius*2-1-i][radius*2-1-j]=' ';
                }
            }

        }

    }
    public int area() {
        int area=0;
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if( grids[i][j]==pattern){
                    area+=1;
                }

            }

        }
        return area;

    }


    public void enlarge() {
        radius++;
        fillGrids();

    }


    public void shrink() {
        radius--;
        fillGrids();

    }
    public String toString(){
        return (String.format("Circle: (%d,%d) area=%d pattern=%s",location.getX(),location.getY(),area(),pattern));
    }


}

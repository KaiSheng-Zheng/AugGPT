public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        this.grids = new char[2*radius][2*radius];
        fillGrids();
    }

    public void fillGrids(){
        for(int i= radius; i< 2*radius; i++){
            for(int j= radius; j< 2*radius; j++){
                if((i-radius)*(i-radius) + (j-radius)*(j-radius) < radius*radius){
                    grids[i][j] = pattern;
                    grids[2*radius-1-i][j]=pattern;
                    grids[i][2*radius-1-j] = pattern;
                    grids[2*radius-1-i][2*radius-1-j] = pattern;
                }
                else{
                    grids[i][j] = ' ';
                    grids[2*radius-1-i][j] = ' ';
                    grids[i][2*radius-1-j] = ' ';
                    grids[2*radius-1-i][2*radius-1-j] = ' ';
                }
            }
        }
    }

    public void enlarge(){
        this.radius = radius + 1;
        this.grids = new char[2*radius][2*radius];
        fillGrids();
    }

    public void shrink(){
        this.radius = radius - 1;
        this.grids = new char[2*radius][2*radius];
        fillGrids();
    }


    public int area(){
        int cnt=0;
        for(int i= radius; i< 2*radius; i++){
            for(int j= radius; j< 2*radius; j++){
                if((i-radius)*(i-radius) + (j-radius)*(j-radius) < radius*radius){
                    cnt+=1;
                }
            }
        }
        return 4*cnt;
    }

    public String toString(){
        return String.format("%s: (%d,%d) area=%d pattern=%c","Circle",location.getX(),location.getY(),area(),pattern);
    }
}

public class Circle extends Shape {
    private int radius;
    public int reduction=0;
    @Override
    public int getreduction() {
        return reduction;
    }

    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    @Override
    public int area() {
        fillGrids();
        int sum=0;
        for(int i=0;i<2*getRadius();i++){
            for(int j=0;j<2*getRadius();j++){
                if (grids[i][j] == getPattern()){
                    sum++;
                }
            }
        }
        return sum;
    }
    @Override
    public void enlarge() {
        setRadius(getRadius()+1);
        fillGrids();
    }
    @Override
    public void shrink() {
        setRadius(getRadius()-1);
        fillGrids();
    }
    public boolean inside(int x,int y,int posx,int posy,int radius){
        if(Math.pow(x-posx-radius,2)+Math.pow(y-posy-radius,2)<Math.pow(radius,2)){
            return true;
        }
        else if(Math.pow(x-posx-radius+1,2)+Math.pow(y-posy-radius,2)<Math.pow(radius,2)){
            return true;
        }
        else if(Math.pow(x-posx-radius,2)+Math.pow(y-posy-radius+1,2)<Math.pow(radius,2)){
            return true;
        }
        else return Math.pow(x-posx-radius+1, 2) + Math.pow(y-posy-radius + 1, 2) < Math.pow(radius, 2);
    }
    @Override
    public void fillGrids() {
        grids=new char[2*getRadius()][2*getRadius()];
        for(int i=0;i<2*getRadius();i++){
            for(int j=0;j<2*getRadius();j++){
                if(inside(i,j,0,0,getRadius())){
                    grids[i][j]=pattern;
                }
                else{
                    grids[i][j]=' ';
                }
            }
        }
    }
    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
}

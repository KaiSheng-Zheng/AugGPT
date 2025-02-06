public class Circle extends Shape {
    private int radius;
    private int count;
    public boolean ifIn(int x,int y){
        int xr = x - radius;
        int yr = y - radius;
        if (xr*xr + (yr+1)*(yr+1) < radius*radius)
            return true;
        if ((xr+1)*(xr+1) + yr*yr < radius*radius)
            return true;
        if (xr*xr + yr*yr < radius*radius)
            return true;
        return (xr + 1) * (xr + 1) + (yr + 1) * (yr + 1) < radius * radius;
    }
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        fillGrids();
    }
    public void fillGrids(){
        count = 0;
        this.grids = new char[2*radius][2*radius];
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if (ifIn(i,j)) {
                    grids[i][j] = pattern;
                    count++;
                }
                else grids[i][j] = ' ';
            }
        }
    }
    public void enlarge(){
        radius ++;
        fillGrids();
    }
    public void shrink(){
        radius --;
        fillGrids();
    }
    public int area(){
        return count;
    }
    public String toString() {
        return "Circle: (" + location.getX() + ',' + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }
}

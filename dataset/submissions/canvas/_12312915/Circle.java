public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        this.fillGrids();
    }
    public void fillGrids(){
        // should clear count before filling
        grids = new char[2*radius][2*radius];
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if(this.ifToFill(i,j)){
                    grids[i][j] = pattern;
                    count++;
                }else{
                    grids[i][j] = ' ';
                }
            }
        }
    }
    public void enlarge(){
        count = 0;
        radius++;
        this.fillGrids();;
    }
    public void shrink(){
        count = 0;
        radius--;
        this.fillGrids();;
    }
    public String toString() {
        return "Circle: (" + super.getX() + "," + super.getY() + ") area=" + count + " pattern=" + pattern;
    }
    public int area(){
        return count;
    }
    public boolean ifToFill(int i,int j){
        if((i-radius)*(i-radius)+(j-radius)*(j-radius)<radius*radius||(i+1-radius)*(i+1-radius)+(j-radius)*(j-radius)<radius*radius||(i-radius)*(i-radius)+(j+1-radius)*(j+1-radius)<radius*radius||(i+1-radius)*(i+1-radius)+(j+1-radius)*(j+1-radius)<radius*radius){
            return true;
        }else return false;
    }
}

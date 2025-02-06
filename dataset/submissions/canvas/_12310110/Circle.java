public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        fillGrids();
    }

    public void fillGrids(char[][] canvas, int x, int y) {
        grids = new char[2*radius][2*radius];
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                grids[i][j]=' ';
            }
        }
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if((i-radius)*(i-radius)+(j-radius)*(j-radius)<=radius*radius){
                    grids[i][j] = pattern;
                }
                else if (check(i,j)){
                    grids[i][j] = pattern;
                }
                if (i>radius-1&j>radius-1&(i-radius)*(i-radius)+(j-radius)*(j-radius)==radius*radius){
                    grids[i][j] = ' ';
                }
            }
        }
    }
    @Override
    public void fillGrids() {
        grids = new char[2*radius][2*radius];
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                grids[i][j]=' ';
            }
        }
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if((i-radius)*(i-radius)+(j-radius)*(j-radius)<=radius*radius){
                    grids[i][j] = pattern;
                }
                else if (check(i,j)){
                    grids[i][j] = pattern;
                }
                if (i>radius-1&j>radius-1&(i-radius)*(i-radius)+(j-radius)*(j-radius)==radius*radius){
                    grids[i][j] = ' ';
                }
            }
        }
    }
    public boolean check(int a, int b){
        if(a<2*radius-1&&b<2*radius-1){
            if ((a-radius)*(a-radius)+(b-radius)*(b-radius)<radius*radius||(a+1-radius)*(a+1-radius)+(b-radius)*(b-radius)<radius*radius||(a-radius)*(a-radius)+(b+1-radius)*(b+1-radius)<radius*radius||(a+1-radius)*(a+1-radius)+(b+1-radius)*(b+1-radius)<radius*radius){
                return true;
            }
        }
        if (a>=2*radius-1&&b<2*radius-1){
            if ((a-radius)*(a-radius)+(b-radius)*(b-radius)<radius*radius||(a-radius)*(a-radius)+(b+1-radius)*(b+1-radius)<radius*radius){
                return true;
            }
        }
        if (a>=2*radius-1&&b>=2*radius-1){
            if ((a-radius)*(a-radius)+(b-radius)*(b-radius)<radius*radius){
                return true;
            }
        }
        if (a<2*radius-1&&b>=2*radius-1) {
            if ((a - radius) * (a - radius) + (b - radius) * (b - radius) < radius * radius || (a + 1 - radius) * (a + 1 - radius) + (b - radius) * (b - radius) < radius * radius) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void enlarge() {
        this.radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if (grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){
        return "Circle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
    }
}

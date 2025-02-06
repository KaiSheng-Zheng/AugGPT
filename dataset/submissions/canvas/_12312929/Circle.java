public class Circle extends Shape{
    public int radius;
    public Circle(Location location,char pattern,int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    };
    int sum = 0;
    int n = 0;
    int m = 0;
    public void fillGrids() {
        // should clear sum before filling!
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (i < radius){
                    n = 1;
                }else {
                    n = 0;
                }
                if (j < radius){
                    m = 1;
                }else {
                    m = 0;
                }
                if ((i+n - radius) * (i+n - radius) + (j+m - radius) * (j+m - radius) < radius * radius) {
                    grids[i][j] = pattern;
                    sum++;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }
    public void enlarge() {
        sum = 0;
        radius++;
        fillGrids();
    }
    public void shrink() {
        sum = 0;
        if (radius > 1) {
            radius--;
            fillGrids();
        }
    }
    public int area() {
        return sum;
    }
}

public class Circle extends Shape {

    private int radius;
    private char[][] grids;
    int sum;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        grids = new char[2*radius][2*radius];

    }
    public char[][] getGrids(){
        fillGrids();
        return grids;
    }
    public void fillGrids() {
        sum = 0;
        
            int r = radius;
            for (int x = 0; x < grids.length; x++) {
                for (int y = 0; y < grids[x].length; y++) {
                    grids[x][y] = ' ';
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < r; j++) {
                    int A = (r - i) * (r - i) + j * j;
                    int B = (r - i) * (r - i) + (j + 1) * (j + 1);
                    int C = (r - i - 1) * (r - i- 1) + j * j;
                    int D = (r - i - 1) * (r - i - 1) + (j + 1) * (j + 1);
                    int a = 0, b = 0, c = 0, d = 0;

                    if (A <= r * r) {
                        a = 1;
                    }
                    if (B <= r * r) {
                        b = 1;
                    }
                    if (C < r * r) {
                        c = 1;
                    }
                    if (D <= r * r) {
                        d = 1;
                    }
                    if (a == 1 || b == 1 || c == 1 || d == 1) {
                        grids[i][j + r] = pattern;
                        grids[i][r - j - 1] = pattern;
                        grids[2 * r - i - 1][j + r] = pattern;
                        grids[2 * r - i - 1][r - j - 1] = pattern;
                        sum += 4;
                    }
                }
            }
        
    }

    public void enlarge() {
        radius+=1;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }

    @Override
    public void shrink() {
        radius-=1;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }

    public int area(){
        fillGrids();
//        if(radius==5){
//            return 88;
//        }
        return sum;
    }

    @Override
    public String toString() {
        int x = location.getX(), y = location.getY();
        int m = area();
        return("Circle: (" + x +"," + y +") area=" + m  + " pattern=" + pattern);
    }

}

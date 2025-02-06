public class Circle extends Shape {
    private int radius;
    private int s=0;
    public Circle(Location location,char pattern,int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        // clear the counter before counting!
        int zj = 2 * radius;
        grids = new char[zj][zj];
        for (int x = 0; x < zj; x++) {
            for (int y = 0; y < zj; y++) {
                boolean filled = false;
                for (int a = x; a < Math.min(x + 2, zj); a++) {
                    for (int b = y; b < Math.min(y + 2, zj); b++) {
                        int dx = a - radius;
                        int dy = b - radius;
                        if (dx * dx + dy * dy < radius * radius) {
                            grids[x][y] = pattern;
                            filled = true;
                            s++;
                            break;
                        }
                    }
                    if (filled) {
                        break;
                    }
                }
                if (!filled) {
                    grids[x][y] = ' ';
                }
            }
        }
    }
    @Override
    public void enlarge() {
        s=0;
        radius++;
        fillGrids();
    }
    @Override
    public void shrink() {
        if(radius>1){
            s=0;
            radius--;
            fillGrids();
        }
    }
    @Override
    public int area() {
        return s;
    }
    public String toString(){
        return super.toString();
    }
}

public class Circle extends Shape {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }
    public void setGrids(char[][] grids) {
        char [][] areas =new char[2*radius][2*radius];
        super.grids = areas;
    }
    public void fillGrids() {
        char [][] areas =new char[2*radius][2*radius];
        super.grids = areas;
        int centerX = radius;
        int centerY = radius;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                int dx = i - centerX;
                int dy = j - centerY;
                if (dx * dx + dy * dy < radius * radius||Math.pow(dx+1,2) + dy * dy < radius * radius || dx * dx + Math.pow(dy+1,2) < radius * radius || Math.pow(dx+1,2) + Math.pow(dy+1,2) < radius * radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }
    public void enlarge() {
        radius += 1;
        fillGrids();
    }
    public void shrink() {
        radius -= 1;
        fillGrids();
    }
    public int area() {
        int k = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if(grids[i][j] == pattern){
                    k += 1;
                }
            }
        }
        return k;
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(), pattern);
    };
}

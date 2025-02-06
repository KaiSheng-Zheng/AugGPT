public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        fillGrids();
    }

    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < radius; i ++){
            for (int j = 0; j < radius; j ++){
                if ((radius - i - 1) * (radius - i - 1) +
                        (radius - j - 1) * (radius - j - 1) < radius * radius ){
                    grids[i][j] = pattern;
                    grids[i][radius * 2 - 1 - j] = pattern;
                    grids[radius * 2 - 1 - i][j] = pattern;
                    grids[radius * 2 - 1 - i][radius * 2 - 1 - j] = pattern;
                } else {
                    grids[i][j] = ' ';
                    grids[i][radius * 2 - 1 - j] = ' ';
                    grids[radius * 2 - 1 - i][j] = ' ';
                    grids[radius * 2 - 1 - i][radius * 2 - 1 - j] = ' ';
                }
            }
        }
    }

    public void enlarge() {
        radius ++;
        fillGrids();
    }

    public void shrink() {
        radius --;
        fillGrids();
    }

    public int area() {
        int area = 0;
        for (int i = 0; i < radius; i ++) {
            for (int j = 0; j < radius; j++) {
                if (grids[i][j] == pattern){
                    area += 4;
                }
            }
        }
        return area;
    }
    public String toString(){
        int x = location.getX();
        int y = location.getY();
        return String.format("Circle: (%d,%d) area=%d pattern=%s",x,y,area(),pattern);
    }

}

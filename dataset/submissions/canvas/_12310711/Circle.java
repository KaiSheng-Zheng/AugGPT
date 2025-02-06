public class Circle extends Shape {

    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }



    @Override
    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if ((i - radius) * (i - radius) + (j - radius) * (j - radius) < radius * radius) {
                    grids[i][j] = pattern;
                    grids[radius*2-1-i][j] = pattern;
                    grids[i][radius*2-j-1] = pattern;
                    grids[radius*2-1-i][radius*2-j-1] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }
   
}

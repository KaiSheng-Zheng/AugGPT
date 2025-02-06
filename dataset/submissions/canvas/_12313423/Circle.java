public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        super.grids = new char[2*radius][2*radius];
        fillGrids();
    }


    @Override
    public void fillGrids() {
        int centerX = radius;
        int centerY = radius;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                grids[i][j] = ' ';
            }

        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                double distance = Math.pow(i + 1 - centerX, 2) + Math.pow(j + 1 - centerY, 2);
                if (distance < Math.pow(radius, 2)){
                    grids[i][j] = pattern;
                    grids[i][2*radius - 1 -j] = pattern;
                    grids[2*radius - 1 - i][j] = pattern;
                    grids[2*radius - i - 1][2*radius - 1 -j] = pattern;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius++;
        super.grids = new char[2*radius][2*radius];
        this.fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        super.grids = new char[2*radius][2*radius];
        this.fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if(grids[i][j] == pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c", X, Y, area(), pattern);
    }
}

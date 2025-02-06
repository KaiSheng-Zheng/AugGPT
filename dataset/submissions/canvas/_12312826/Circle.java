public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }
    public void fillGrids() {
        this.grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j <radius*2; j++) {
                grids[i][j] = ' ';
            }
        }
        for (int x = 0; x <= radius; x++) {
            for (int y = 0; y <= radius; y++) {
                double distance = Math.sqrt((x - radius) * (x - radius) + (y - radius) * (y - radius));
                if (distance < radius) {
                    grids[x - 1][y - 1] =pattern;
                }
            }
        }
        for (int x = radius*2; x >= radius; x--) {
            for (int y =radius*2 ; y >= radius; y--) {
                double distance = Math.sqrt((x - radius) * (x - radius) + (y - radius) * (y - radius));
                if (distance < radius) {
                    grids[x][y] = pattern;
                }
            }
        }
        for (int x = radius*2; x >= radius; x--) {
            for (int y = 0; y <= radius; y++) {
                double distance = Math.sqrt((x - radius) * (x - radius) + (y - radius) * (y - radius));
                if (distance < radius) {
                    grids[x][y-1] = pattern;
                }
            }
        }for (int x = 0; x <= radius; x++) {
            for (int y = radius*2; y >= radius; y--) {
                double distance = Math.sqrt((x - radius) * (x - radius) + (y - radius) * (y - radius));
                if (distance < radius) {
                    grids[x-1][y] = pattern;
                }
            }
        }
    }
    public char[][] getGrids(){
        return this.grids;
    }
    public void enlarge() {
        radius++;
        fillGrids();
    }

    public void shrink() {
        radius--;
        fillGrids();
    }
    public int area(){
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids.length; j++) {
                if(grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString() {
        return String.format("Circle: %s area=%d pattern=%c", location, area(), pattern);
    }
}

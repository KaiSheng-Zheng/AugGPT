public class Circle extends Shape {
    private int radius;


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        //which means you need create a two-dimensional array of char type for the attribute grids.
        fillGrids();
    }


    public void fillGrids() {
        char[][] G = new char[radius * 2][radius * 2];
        int x0 = radius;
        int y0 = radius;
        int x = 0;
        int y = 0;
        int r = 0;
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G.length; j++) {
                x = i + 1;
                y = j + 1;
                r = (x - x0) * (x - x0) + (y - y0) * (y - y0);
                if (radius*radius <= r) {
                    G[i][j] = ' ';
                } else {
                    G[i][j] = pattern;
                }
            }
        }
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                grids[i][j] = G[i][j];
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                grids[2 * radius - i - 1][j] = G[i][j];
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                grids[i][2 * radius - j - 1] = G[i][j];
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                grids[2 * radius - i - 1][2 * radius - j - 1] = G[i][j];
            }
        }
    }

    public void enlarge() {
        radius++;
        fillGrids();
    }


    public void shrink() {
        radius--;
        fillGrids();
    }

    public int area() {
        int count = 0;
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (grids[i][j] != ' ') {
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
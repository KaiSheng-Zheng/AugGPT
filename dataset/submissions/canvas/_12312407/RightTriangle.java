public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;
    private int count;


    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }


    public void fillGrids() {

        switch (d) {
            case LEFT_UP:
                fillLeftUpTriangle();
                break;
            case LEFT_DOWN:
                fillLeftDownTriangle();
                break;
            case RIGHT_UP:
                fillRightUpTriangle();
                break;
            case RIGHT_DOWN:
                fillRightDownTriangle();
                break;

        }
    }

    // LeftUp
    public void fillLeftUpTriangle() {
        count =0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (Math.abs((double) i / (j - (double) width)) < (double) height / width){
                    grids[i][j] = pattern;
                    count=count+1;
                    }
                    else {
                        grids[i][j] = ' ';
                    }
            }
        }
    }

    // LeftDown
    public void fillLeftDownTriangle() {
        count =0;
        for (int i =0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (Math.abs((double)(i + 1 - height) / (double)(j - width)) < (double)height / (double)width){
                    grids[i][j] = pattern;
                    count=count+1;
                }
                else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

 //RightUp
    public void fillRightUpTriangle() {
        count =0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (Math.abs((double)i / (j + 1)) < ((double)height / (double)width)){
                    grids[i][j] = pattern;
                    count=count+1;
                }
                else {
                    grids[i][j] = ' ';
                }
            }
        }

    }

 //RightDown
    private void fillRightDownTriangle() {
        count =0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (Math.abs((double)(i + 1 - height) / (j + 1)) < ((double)height / (double)width)){
                    grids[i][j] = pattern;
                    count=count+1;
                }
                else {
                    grids[i][j] = ' ';
                }
            }
        }
    }



    protected void enlarge() {
        width++;
        height++;
        this.grids = new char[height][width];
        fillGrids();
    }


    protected void shrink() {
        width--;
        height--;
        this.grids = new char[height][width];
        fillGrids();
    }


    public int area() {
        return count;
    }

    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(), pattern);
    }


    //print
    public static void main(String[] args) {
        Location p1 = new Location(0, 1);
        Shape s1 = new RightTriangle(p1, 'X', 4, 5, Direction.RIGHT_DOWN);
        char[][] grids = s1.getGrids();
        for (char[] line : grids) {
            System.out.println(line);
        }
        System.out.printf("Grids height = %d, width = %d\n", grids.length,
                grids[0].length);
        System.out.println(s1);
        s1.enlarge();
        grids = s1.getGrids();
        for (char[] line : grids) {
            System.out.println(line);
        }
        System.out.printf("Grids height = %d, width = %d\n", grids.length,
                grids[0].length);
        System.out.println(s1);
    }
}
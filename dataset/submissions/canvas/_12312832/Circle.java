

public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;

        fillGrids();
    }

//    @Override
//    public char[][] getGrids() {
//        return super.getGrids();
//    }

    @Override
    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(), pattern);
        // [Classname]: ([x],[y]) area=[area] pattern=[pattern]
    }

    @Override
    public void fillGrids() {
        grids = new char[2 * radius][2 * radius];
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j ++) {
                boolean result1 = (radius - i) * (radius - i) + (radius - j) * (radius - j) < radius * radius;
                boolean result2 = (radius - i) * (radius - i) + (radius - j-  1) * (radius - j - 1) < radius * radius;
                boolean result3 = (radius - i - 1) * (radius - i - 1) + (radius - j) * (radius - j) < radius * radius;
                boolean result4 = (radius - i - 1) * (radius - i - 1) + (radius - j - 1) * (radius - j - 1) < radius * radius;
                if (result1||result2||result3||result4) {
                    grids[i][j] = pattern;
                }else{
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.radius = radius + 1;
        fillGrids();

    }


    @Override
    public void shrink() {
        this.radius = radius - 1;
        fillGrids();

    }

    @Override
    public int area() {
        int sum = 0;
        for (int i = 0; i < grids.length; i ++) {
            for (int j = 0; j < grids[i].length; j ++) {
                if (grids[i][j] == pattern) {
                    sum ++;
                }
            }
        }
        return sum;
    }
}


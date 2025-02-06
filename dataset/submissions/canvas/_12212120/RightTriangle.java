public class RightTriangle extends Shape {
    private int width;
    private int height;
    private int   d;

    public RightTriangle(Location location, char pattern, int width, int height, int d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }

    public void fillGrids() {
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
               if(d==0) {
                   if (j == 0) {
                       grids[i][j] = pattern;
                   } else {
                       double slope1 = (double) (-height) / width;
                       double slope2 = (double) (i - height) / j;
                       if (slope2 <slope1) {
                           grids[i][j] = pattern;
                       } else grids[i][j] = ' ';
                   }
               }
               if(d==1) {
                   if (j == 0) {
                       grids[i][j] = pattern;
                   } else {
                       double slope1 = (double) height / width;
                       double slope2 = (double) (i + 1) / (j);
                       if (slope2 > slope1) {
                           grids[i][j] = pattern;
                       }
                       else grids[i][j]=' ';
                   }
               }
               if(d==2) {
                   if (j == grids[i].length - 1) {
                       grids[i][j] = pattern;
                   } else {
                       double slope1 = (double) height / width;
                       double slope2 = (double) (i - height) / (j - width + 1);
                       if (slope2 > slope1) {
                           grids[i][j] = pattern;
                       }
                       else grids[i][j]=' ';
                   }
               }
               if (d==3) {
                   if (j == width - 1) {
                       grids[i][j] = pattern;
                   } else {
                       double slope1 = (double) (-height) / width;
                       double slope2 = (double) -(i + 1) / (width - j - 1);
                       if (slope2 < slope1) {
                           grids[i][j] = pattern;
                       }
                       else grids[i][j]=' ';
                   }
               }

            }
        }
    }

    public void enlarge() {
        width++;
        height++;
        grids = new char[height][width];
        fillGrids();
    }

    public void shrink() {
        if (width > 1 && height > 1) {
            width--;
            height--;
            grids = new char[height][width];
            fillGrids();
        }
    }

    public int area() {
        int count = 0;
        for (char[] grid : grids) {
            for (char c : grid) {
                if (c == pattern) count++;
            }
        }
        return count;
    }
}
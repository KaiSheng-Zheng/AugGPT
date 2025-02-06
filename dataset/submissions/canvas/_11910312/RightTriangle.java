
public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction direction;

    public RightTriangle(Location location, char pattern, int width, int height, Direction direction) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.direction = direction;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        double ans = 0;
        int temp = 0;
        double ans1 = 0;
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                switch (direction) {
                    case LEFT_DOWN:
                        ans = (double)(height)/(double)(width) * j;
                        temp = (int) ans;
//                        if (j <= (i * width / height)) grids[i][j] = pattern;
                        if (temp  <=  i){
                            grids[i][j] = pattern;
                        }
                        else grids[i][j] = ' ';
                        break;
                    case LEFT_UP:
                        ans = (double)(height)/(double)(width) * j;
                        temp = (int) ans;
//                        ans = (double)(height)/(double)(width) * j;
//                        temp = (int) ans ;
//                        ans1 = (double)(height)/(double)(width) * (j+1);
//                        if (ans1 % 1 != 0 ){
//                            temp = (int) ans1;
//                        }else {
//                            temp = (int) ans1 - 1;
//                        }
                        if (height - i - 1 >= temp) grids[i][j] = pattern;
                        else grids[i][j] = ' ';
                        break;
                    case RIGHT_DOWN:
                        ans = (double)(height)/(double)(width) * j;
                        temp = (int) ans ;
                        ans1 = (double)(height)/(double)(width) * (j+1);
                        if (ans1 % 1 != 0 ){
                            temp = (int) ans1;
                        }else {
                            temp = (int) ans1 - 1;
                        }
                        if (height - i - 1 <= temp) grids[i][j] = pattern;
                        else grids[i][j] = ' ';
                        break;
                    case RIGHT_UP:
//                        ans = (double)(height)/(double)(width) * j;
//                        temp = (int) ans;
                        ans = (double)(height)/(double)(width) * j;
                        temp = (int) ans ;
                        ans1 = (double)(height)/(double)(width) * (j+1);
                        if (ans1 % 1 != 0 ){
                            temp = (int) ans1;
                        }else {
                            temp = (int) ans1 - 1;
                        }
                        if (i <= temp) grids[i][j] = pattern;
                        else grids[i][j] = ' ';
                        break;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        if (width < 20 && height < 20) {
            width++;
            height++;
            fillGrids();
        }
    }

    @Override
    public void shrink() {
        if (width > 1 && height > 1) {
            width--;
            height--;
            fillGrids();
        }
    }

    @Override
    public int area() {
        int count = 0;
        for (char[] row : grids) {
            for (char cell : row) {
                if (cell == pattern) {
                    count++;
                }
            }
        }
        return count;
    }


}

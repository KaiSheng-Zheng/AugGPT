public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }
    public void fillGrids() {
        grids = new char[height][width];
        switch (d){
            case LEFT_DOWN :
                for (int i = 0; i < height; i ++) {
                    for (int j = 0; j < width; j++) {
                        if (width * (i + 1) > height * j){  //equivalent to i+1 > (height/width)*j
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;

            case LEFT_UP:
                for (int i = 0; i < height; i ++) {
                    for (int j = 0; j < width; j++) {
                        if (width * i < height * (width - j)){
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;

            case RIGHT_DOWN:
                for (int i = 0; i < height; i ++) {
                    for (int j = 0; j < width; j++) {
                        if (width * (i + 1) > height * (width - j - 1)){
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;

            case RIGHT_UP:
                for (int i = 0; i < height; i ++) {
                    for (int j = 0; j < width; j++) {
                        if (width * i < height * (j + 1)){
                            grids[i][j] = pattern;
                        }else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;

        }
    }

    public void enlarge() {
        height ++;
        width ++;
        fillGrids();
    }

    public void shrink() {
        height --;
        width --;
        fillGrids();
    }

    public int area() {
        int area = 0;
        for (int i = 0; i < height; i ++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern){
                    area += 1;
                }
            }
        }
        return area;
    }
    public String toString(){
        int x = location.getX();
        int y = location.getY();
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%s",x,y,area(),pattern);
    }
}

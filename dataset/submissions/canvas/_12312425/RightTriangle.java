public class RightTriangle extends Shape implements Comparable<Shape>{
    private int height;//[1-20]
    private int width;//[1-20]
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.height = height;
        this.width = width;
        this.d = d;
        this.fillGrids();
    }
    @Override
    public void fillGrids() {
        this.grids = new char[height][width];
        if (d == Direction.RIGHT_UP){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i * width  >= height * (j + 1)){
                        grids[i][j] = '\u0020';
                    }
                    else {
                        grids[i][j] = pattern;
                    }
                }
            }
        }else if (d == Direction.LEFT_UP){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i * width >= height * (width - j)){
                        grids[i][j] = '\u0020';
                    }
                    else {
                        grids[i][j] = pattern;
                    }
                }
            }
        }else if (d == Direction.RIGHT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((i + 1) * width <= height * (width - j - 1)){
                        grids[i][j] = '\u0020';
                    }
                    else {
                        grids[i][j] = pattern;
                    }
                }
            }
        }else {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if ((i + 1) * width <= height * j){
                        grids[i][j] = '\u0020';
                    }
                    else {
                        grids[i][j] = pattern;
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.width += 1;
        this.height += 1;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        this.width -= 1;
        this.height -= 1;
        this.fillGrids();
    }

    @Override
    public int area() {
        int a = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] == pattern){
                    a += 1;
                }
            }
        }
        return a;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(),location.getY(), area(), pattern);
    }

    @Override
    public int compareTo(Shape o) {
        if (this.area() < o.area()){
            return -1;
        }else if (this.area() > o.area()) {
            return 1;
        }else {
            if (this.pattern < o.pattern){
                return -1;
            } else if (this.pattern > o.pattern) {
                return 1;
            }
            else {
               return 0;
            }
        }
    }
}
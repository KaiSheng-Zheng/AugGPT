public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.d = d;
        this.height = height;
        this.width = width;
    }

    ;

    public void fillGrids() {
        this.grids = new char[height][width];
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                int x, y;
                if (d == Direction.LEFT_DOWN) {
                    x = i;
                    y = j;
                } else if (d == Direction.LEFT_UP) {
                    x = i;
                    y = this.height - 1 - j;
                } else if (d == Direction.RIGHT_UP) {
                    x = this.width - 1 - i;
                    y = this.height - 1 - j;
                } else {
                    x = this.width - 1 - i;
                    y = j;
                }
                if ((height - j - 1) * width < height * (width - i)) {
                    grids[y][x] = this.pattern;
                }
                else
                    grids[y][x]=' ';
            }
        }
    }
    public int getWidth(){
       return this.width ;
    }
    public int getHeight(){
        return this.height;
    }

    ;

    public void enlarge() {
        this.width++;
        this.height++;
    }

    ;

    public void shrink() {
        this.width--;
        this.height--;
    }

    ;

    public int area() {
        int area = 0;
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                if ((height - j - 1) * width < height * (width - i)) {
                    area++;
                }
            }
        }
        return area;
    };
    public String toString(){
        return "RightTriangle: ("+this.location.getX()+","+this.location.getY()+") area="+this.area()+" pattern="+pattern;
    }
}

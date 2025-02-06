public class RightTriangle extends Shape {
    
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
        super.className = "RightTriangle";
    }


    @Override
    public void fillGrids() {
        super.grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                super.grids[i][j] = RTTest(i, j, new Location(0, 0)) ? pattern : ' ';
            }
        }
    }

    public boolean RTTest(int i, int j, Location location) {
        int x0 = location.getX();
        int y0 = location.getY();
        switch (d) {
        case LEFT_UP:
        if ( (i - x0) * width <  width * height -  (j - y0) * height && (i >= x0) && (j >=y0)){
            return true;
        }else{return false;}
        case LEFT_DOWN:
        i++;
        if ((j - y0) * height <  (i - x0) * width && (i <= x0 + height) && (j >=y0)){
            return true;
        }else{return false;}
        case RIGHT_UP:
        j++;
        if( (j - y0) * height >  (i - x0) * width && (i >= x0) && (j <= y0 + width)){
            return true;
        }else{return false;}
        case RIGHT_DOWN:
        i++;j++;
       if (( (i - x0) * width >  width * height -  (j - y0) * height && (i <= x0 + height) && (j <= y0 + width))){
           return true;
       }else{return false;}
        default:
        return false;
        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        fillGrids();
    }

    @Override
    public void shrink() {
        height--;
        width--;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (super.grids[i][j] == pattern) count++;
            }
        }
        return count;
    }

    @Override
    public int getArea() {
        return area();
    }

}

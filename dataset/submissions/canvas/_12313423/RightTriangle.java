public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;//The direction of the right angle of a right triangle.

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        super.grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void fillGrids() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' ';
            }
        }

        if (d == Direction.LEFT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j < (int)Math.ceil((i+1) * ((double)width / height))){
                        grids[i][j] = pattern;
                    }
                }

            }


        } else if (d == Direction.LEFT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j < (int)Math.ceil((height-i) * ((double)width / height))){
                        grids[i][j] = pattern;
                    }
                }
            }
            
        } else if (d == Direction.RIGHT_DOWN) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j >= width - (int)Math.ceil((i + 1) * ((double)width / height))){
                        grids[i][j] = pattern;
                    }
                }

            }
            
        } else if (d == Direction.RIGHT_UP) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j >= width - (int)Math.ceil((height - i) * ((double)width / height))) {
                        grids[i][j] = pattern;
                    }
                }
            }
        }


    }

    @Override
    public void enlarge() {
        width++;
        height++;
        super.grids = new char[height][width];
        fillGrids();

    }

    @Override
    public void shrink() {
        width--;
        height--;
        super.grids = new char[height][width];
        fillGrids();

    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grids[i][j] == pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", X, Y, area(), pattern);
    }

}

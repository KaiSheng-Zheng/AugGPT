public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        if (width >= 1 && width <= 20){
            this.width = width;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height >= 1 && height <= 20){
            this.height = height;
        }
    }

    public Direction getD() {
        return d;
    }

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
    }

    @Override
    public void fillGrids() {
        // using ' ' not null to fill the empty slot
        grids = new char[height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                switch (d){
                    case LEFT_UP:
                        if (j == 0){
                            grids[i][j] = pattern;
                        }
                        else {
                            if (((double)(height - i) / j) > ((double) height / width)){
                                grids[i][j] = pattern;
                            }
                        }
                        break;
                    case LEFT_DOWN:
                        if (j == 0){
                            grids[i][j] = pattern;
                        }
                        else {
                            if (((double) (i + 1) / j) >  ((double) height / width)){
                                grids[i][j] = pattern;
                            }
                        }
                        break;
                    case RIGHT_UP:
                        if ((width - 1 - j) == 0){
                            grids[i][j] = pattern;
                        }
                        else {
                            if (((double)(height - i) / (width - 1 - j)) >  ((double) height / width)){
                                grids[i][j] = pattern;
                            }
                        }
                        break;
                    case RIGHT_DOWN:
                        if ((width - 1 - j) == 0){
                            grids[i][j] = pattern;
                        }
                        else {
                            if (((double) (i + 1) / (width - 1 - j)) >  ((double) height / width)){
                                grids[i][j] = pattern;
                            }
                        }
                        break;
                }
            }
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
        fillGrids();
        int counter = 0;
        for (char[] test1 : grids){
            for (char test : test1){
                if (test == pattern){
                    counter++;
                }
            }
        }
        return counter;
    }

    public String toString(){
        return "RightTriangle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }
}

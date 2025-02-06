public class RightTriangle extends Shape{
    private int width;
    private int height;
    private Direction direction;
    public RightTriangle(Location location, char pattern, int width, int height, Direction direction){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.direction = direction;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        for(int i = 0; i < height; i ++){
            for(int j = 0; j < width; j ++){
                grids[i][j] = ' ';
            }
        }
        switch(direction){
            case RIGHT_UP -> {
                for(int i = 0; i < height; i ++){
                    for(int j = 0; j <= (width * (i+1) - 1)/height; j ++){
                        grids[height - 1 - i][width - 1 - j] = pattern;
                    }
                }
            }
            case LEFT_UP -> {
                for(int i = 0; i < height; i ++){
                    for(int j = 0; j <= (width * (i+1) - 1)/height; j ++){
                        grids[height - 1 - i][j] = pattern;
                    }
                }
            }
            case RIGHT_DOWN -> {
                for(int i = 0; i < height; i ++){
                    for(int j = 0; j <= (width * (i+1) - 1)/height; j ++){
                        grids[i][width - 1 - j] = pattern;
                    }
                }
            }
            case LEFT_DOWN -> {
                for(int i = 0; i < height; i ++){
                    for(int j = 0; j <= (width * (i+1) - 1)/height; j ++){
                        grids[i][j] = pattern;
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        width ++;
        height ++;
        fillGrids();
    }

    @Override
    public void shrink() {
        if(width > 0) width --;
        if(height > 0) height --;
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for(int i = 0; i < height; i ++){
            for(int j = 0; j < width; j ++){
                if(grids[i][j] == pattern) area ++;
            }
        }
        return area;
    }

    @Override
    public char[][] getGrids() {
        return super.getGrids();
    }
}

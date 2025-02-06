public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    private double slope;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.slope = ((double)height / (double) width);
        this.fillGrids();
    }
    public void initialGrid(){
        this.grid = new char[height + 1][width + 1];
    }
    @Override
    public int area(){
        int count = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grids[i][j] == this.pattern)count++;
            }
        }
        return count;
    }
    @Override
    public void fillGrids(){
        this.grid = new char[height+1][width + 1];
        this.grids = new char[height][width];
        if(this.d == Direction.RIGHT_UP){
            for(int i = 1; i <= width; i++){
                for(int j = 1; j <= (int)(i * slope - 0.01) + 1; j++){
                    grid[j][i] = this.pattern;
                }
            }
        }
        else if(this.d == Direction.LEFT_DOWN){
            for(int i = 1; i <= width; i++){
                for(int j = (int)((i-1) * slope) + 1; j <= height; j++){
                    grid[j][i] = this.pattern;
                }
            }
        }
        else if(this.d == Direction.LEFT_UP){
            for(int i = 1; i <= width; i++){
                for(int j = 1; j <= (int)((width-i+1)*slope - 0.01)+1; j++){
                        grid[j][i] = this.pattern;
                }
            }
        }
        else if(this.d == Direction.RIGHT_DOWN){
            for(int i = 1; i <= width; i++){
                for(int j = (int)((width - i)*slope) + 1; j <= height; j++){
                    grid[j][i] = this.pattern;
                }
            }
        }
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i+1][j+1] == this.pattern)grids[i][j] = grid[i+1][j+1];
                else grids[i][j] = ' ';
            }
        }
    }
    @Override
    public void shrink(){
        initialGrid();
        this.width--;
        this.height--;
        this.slope = ((double)height / (double) width);
        fillGrids();
    }
    @Override
    public void enlarge(){
        initialGrid();;
        this.width++;
        this.height++;
        this.slope = ((double)height / (double) width);
        fillGrids();
    }
    @Override
    public String toString(){
        return "RightTriangle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }
}

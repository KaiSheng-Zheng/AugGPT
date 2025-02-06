public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(pattern, location);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        this.grids=new char[height][width];
        double h = height;
        double w = width;
        double slope = h/w;
        if (d==Direction.LEFT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 1; j < width; j++) {
                    if ((i+1+h-h)/j>slope){
                        grids[i][j]=pattern;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                grids[i][0]=pattern;
            }
        }
        if (d==Direction.LEFT_UP){
            for (int i = 0; i < height; i++) {
                for (int j = 1; j < width; j++) {
                    if ((h-i)/j>slope){
                        grids[i][j]=pattern;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                grids[i][0]=pattern;
            }
        }
        if (d==Direction.RIGHT_UP){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width-1; j++) {
                    if ((h-i)/(w-1-j)>slope){
                        grids[i][j] = pattern;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                grids[i][width-1]= pattern;
            }
        }
        if (d==Direction.RIGHT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j <width-1 ; j++) {
                    if ((i+1+h-h)/(w-1-j)>slope){
                        grids[i][j] = pattern;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                grids[i][width-1]= pattern;
            }
        }
    }

    @Override
    public char[][] getGrids() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j]!=pattern){
                    grids[i][j]=' ';
                }
            }
        }
        return super.getGrids();
    }
    @Override
    public void enlarge(){
        this.height++;
        this.width++;
        fillGrids();
    }
    @Override
    public void shrink(){
        this.height--;
        this.width--;
        fillGrids();
    }
    @Override
    public int area(){
        int counter = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j]==pattern){
                    counter++;
                }
            }
        }
        return counter;
    }
    @Override
    public String toString(){
        return String.format("%s%s%s%d%s","RightTriangle: ",location.toString()," area=",area()," pattern="+pattern);
    }
}

public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public void fillGrids(){
        double slope = (double)  (height)/(width);
        for (int i = 0 ; i < grids.length ; i++){
            for (int j = 0; j < grids[i].length ; j++){
                 if (d == Direction.LEFT_DOWN){
                    if (j == 0 || (i+1.0)/j > slope){
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                } else if (d == Direction.RIGHT_UP){
                    if ( i/(j+1.0) < slope){
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                } else if (d == Direction.LEFT_UP){
                    if ((double) i/(width-j) < slope){
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                } else if (d == Direction.RIGHT_DOWN){
                    if (width-j-1 == 0 || (i+1)/(width-j-1.0) > slope){
                        grids[i][j] = pattern;
                    }else {
                        grids[i][j] = ' ';
                    }
                }
            }
        }
    }
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
         this.height =height;
         this.width = width;
         this.d = d;
         grids = new char[height][width];
         fillGrids();
    }

    public char getPattern(){
        return this.pattern;
    }
    public void enlarge(){
        this.height++;
        this.width++;
        grids = new char[height][width];
        fillGrids();
    }
    public void shrink(){
        this.height--;
        this.width--;
        grids = new char[height][width];
        fillGrids();
    }
    public int area(){
        int count = 0;
        for (int i = 0 ; i < grids.length ; i++){
            for (int j = 0 ; j < grids[i].length ; j++){
                if(grids[i][j] == this.pattern){
                    count++;
                }
            }
        }
        return count;
    }
    public String toString(){
        return  "RightTriangle: (" + location.getX() + "," + location.getY() + ") area=" +area()+" pattern=" +pattern;
    }
}
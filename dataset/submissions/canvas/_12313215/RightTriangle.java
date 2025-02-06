public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location,char pattern,int width,int height,Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        grids = new char[height][width];
        for(int i = 0 ; i<height ;i++){
            for(int j = 0; j<width ;j++){
                grids[i][j]=" ".charAt(0);
            }
        }
        fillGrids();
    }

    @Override
    public void fillGrids() {
        double slope = 1.0*height/width;
        if(d == Direction.LEFT_DOWN){
            Location origin = new Location(0,0);
            for(int i = 1 ; i<height+1 ;i++){
                for(int j =0;j<width;j++){
                    double currentSlope = Math.abs(1.0*(i-origin.getY())/(j-origin.getX()));
                    if(currentSlope > slope){grids[i-1][j] = pattern;}
                    else {grids[i-1][j] = " ".charAt(0);}
                }
            }
        }
        if(d == Direction.LEFT_UP){
            Location origin = new Location(0,height);
            for(int i = 0 ; i<height ;i++){
                for(int j =0;j<width;j++){
                    double currentSlope = Math.abs(1.0*(i-origin.getY())/(j-origin.getX()));
                    if(currentSlope > slope){grids[i][j] = pattern;}
                    else {grids[i][j] = " ".charAt(0);}
                }
            }
        }
        if(d == Direction.RIGHT_UP){
            Location origin = new Location(width,height);
            for(int i = 0 ; i<height ;i++){
                for(int j =1;j<width+1;j++){
                    double currentSlope = Math.abs(1.0*(i-origin.getY())/(j-origin.getX()));
                    if(currentSlope > slope){grids[i][j-1] = pattern;}
                    else {grids[i][j-1] = " ".charAt(0);}
                }
            }
        }
        if(d == Direction.RIGHT_DOWN){
            Location origin = new Location(width,0);
            for(int i = 1 ; i<height+1 ;i++){
                for(int j =1;j<width+1;j++){
                    double currentSlope = Math.abs(1.0*(i-origin.getY())/(j-origin.getX()));
                    if(currentSlope > slope){grids[i-1][j-1] = pattern;}
                    else {grids[i-1][j-1] = " ".charAt(0);}
                }
            }
        }
    }

    @Override
    public void shrink() {
        width--;
        height--;
        grids = new char[height][width];
        for(int i = 0 ; i<height ;i++){
            for(int j = 0; j<width ;j++){
                grids[i][j]=" ".charAt(0);
            }
        }
        fillGrids();
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        grids = new char[height][width];
        for(int i = 0 ; i<height ;i++){
            for(int j = 0; j<width ;j++){
                grids[i][j]=" ".charAt(0);
            }
        }
        fillGrids();
    }
    @Override
    public int area() {
        int Area = 0;
        for(int i = 0;i < height;i++){
            for(int j = 0 ; j < width ; j++){
                if (grids[i][j] == pattern){Area++;}
            }
        }
        return Area;
    }
    public String toString(){
        return("RightTriangle: " + location.toString() + " area=" + String.valueOf(area()) +  " pattern=" + pattern);
    }
}

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }
    @Override
    public void fillGrids() {
        this.grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' ';
            }
        }
        double slope=(double)height/width;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (d==Direction.LEFT_DOWN) {
                    if (j==0){
                        grids[i][j] = pattern;
                    }
                    else {
                        double a=(double)(i+1)/j;
                        if (a>slope){
                            grids[i][j] = pattern;
                        }
                    }
                }
                else if (d==Direction.LEFT_UP) {
                    if (j==0){
                        grids[i][j] = pattern;
                    }
                    else{
                        double a=(double)(height-i)/j;
                        if (a>slope){
                            grids[i][j] = pattern;
                        }
                    }
                }
                else if (d==Direction.RIGHT_DOWN) {
                    if ((width-j-1)==0){
                        grids[i][j] = pattern;
                    }else{
                        double a=(double) (i+1)/(width-j-1);
                        if (a>slope){
                            grids[i][j] = pattern;
                        }
                    }
                }
                else if (d==Direction.RIGHT_UP) {
                    if ((width-j-1)==0){
                        grids[i][j] = pattern;
                    }else{
                        double a=(double)(height-i)/(width-j-1);
                        if (a>slope){
                            grids[i][j] = pattern;
                        }
                    }
                }
            }
        }
    }
    @Override
    public void enlarge(){
        this.height = this.height + 1;
        this.width=this.width + 1;
        fillGrids();
    }
    @Override
    public void shrink(){
        this.height = this.height - 1;
        this.width=this.width - 1;
        fillGrids();
    }
    @Override
    public int area(){
        int count =0;
        int len1 = grids.length;
        int len2=grids[0].length;
        for(int i=0;i<len1;i++) {
            for (int j = 0; j < len2; j++) {
                if (grids[i][j] != ' '){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString(){
        return "RightTriangle: (" + location.getX() + "," + location.getY() +
                ") area=" + area() + " pattern=" + pattern;
    }
}

public class RightTriangle extends Shape {
    private int width;
    private int height;
    double slope;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        this.grids=new char[height][width];
        fillGrids();

    }


    @Override
    public void fillGrids() {
        this.grids=new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j] = ' ';//initialize grids
            }
        }
        slope = (double)height/width;
        if (d.equals(Direction.LEFT_DOWN)) {
            for (int i = 1; i <= height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == 0 && i < height) {
                        this.grids[i][j] = pattern;
                    }
                    if ((double) i / j > slope ) {
                        this.grids[i-1][j] = pattern;
                    }
                }
            }
        }
        
        if(d.equals(Direction.LEFT_UP)){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (j == 0 ) {
                        this.grids[i][j] = pattern;
                    } else if (i == 0) {
                        this.grids[i][j] = pattern;
                    }
                    if ((double)(height - i) / j >slope && j!=0){
                        this.grids[i][j]=pattern;
                    }
                }
            }
        }

        if (d.equals(Direction.RIGHT_DOWN)){
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j <= width; j++) {
                    if ( j== width){
                        this.grids[i-1][j-1]=pattern;
                    }
                    if ((double) i/(width - j)>slope && j!=width ){
                        this.grids[i-1][j-1]=pattern;
                    }
                }
            }
        }

        if (d.equals(Direction.RIGHT_UP)){
            for (int i = 0; i < height; i++) {
                for (int j = 1; j <= width; j++) {
                    if (j == width-1 ) {
                        this.grids[i][j] = pattern;
                    }
                    if ((float) (height - i)/(width - j)>slope){
                        this.grids[i][j-1]=pattern;
                    }
                }
            }
        }
        
    }
    public String toString(){
        return "RightTriangle"+": "+"("+this.location.getX()+","+this.location.getY()+")"+" area="+this.area()+" pattern="+this.pattern;
    }
    public void enlarge(){
        height+=1;
        width+=1;
        fillGrids();
    }
    public void shrink(){
        height-=1;
        width-=1;
        fillGrids();
    }
    @Override
    public int area() {
            int num=0;
            for (int i = 0; i < this.height ; i++) {
                for (int j = 0; j < this.width; j++) {
                    if (this.grids[i][j] == this.pattern){
                        num++;
                    }
                }
            }
            return num;
    }


}

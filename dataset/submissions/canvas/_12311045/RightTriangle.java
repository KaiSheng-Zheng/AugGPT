public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    char[][]grids;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Direction getD() {
        return d;
    }

    @Override
    public char[][] getGrids() {
        return grids;
    }

    public void setGrids(char[][] grids) {
        this.grids = grids;
    }

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        grids=new char[height][width];
        fillGrids();
    }
    public void setWidth(int width) {this.width = width;}

    public void setHeight(int height) {this.height = height;}

    public void fillGrids(){
        grids=new char[height][width];
        double k= (double) (height) /(width);
        if(d.equals(Direction.LEFT_UP)){
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    double a=height-j*k;
                    if(a>i){
                        grids[i][j]=pattern;
                    }
                    else grids[i][j]=' ';
                }
            }
        }
        if(d.equals(Direction.RIGHT_DOWN)){
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    double a=height-(j+1)*k;
                    if(i+1>a){
                        grids[i][j]=pattern;
                    }
                    else grids[i][j]=' ';
                }
            }
        }
        if(d.equals(Direction.RIGHT_UP)){
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    double a=(j+1)*k;
                    if(i<a){
                        grids[i][j]=pattern;
                    }
                    else grids[i][j]=' ';
                }
            }
        }
        if(d.equals(Direction.LEFT_DOWN)){
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    double a=j*k;
                    if(i+1>a){
                        grids[i][j]=pattern;
                    }
                    else grids[i][j]=' ';
                }
            }
        }
    }
    public void enlarge(){
        setHeight(height+1);
        setWidth(width+1);
        fillGrids();
    }
    public void shrink(){
        setHeight(height-1);
        setWidth(width-1);
        fillGrids();
    }
    public int area(){
        int s=0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(grids[i][j]==pattern){s++;}
            }
        }
        return s;
    }

    public String toString(){
        return "RightTriangle: "+location.toString()+" area="+area()+" pattern="+pattern;
    }
}

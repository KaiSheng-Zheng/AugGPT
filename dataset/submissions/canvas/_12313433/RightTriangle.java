



public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.d=d;
        this.width=width;
        this.height=height;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        width--;
        height--;
        fillGrids();
    }
    @Override
    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }
    @Override
    public int area() {
        int a=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grids[i][j]==pattern){
                    a++;
                }
            }
        }
        return a;
    }
    @Override
    public void fillGrids() {
        grids = new char[height][width];
        double height=this.height;
        double width=this.width;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j]=' ';
            }

        }
        if(d==Direction.LEFT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(((height-i-1)/(width-j))<(height/width)){
                        grids[i][j]=pattern;
                    }
                }
            }
        }
        if(d==Direction.LEFT_UP){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(i/(width-j)<(height/width)){
                        grids[i][j]=pattern;
                    }
                }
            }
        }
        if(d==Direction.RIGHT_UP){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(((i)/(double)(j+1))<(height/width)){
                        grids[i][j]=pattern;
                    }
                }
            }
        }
        if(d==Direction.RIGHT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(((height-i-1)/(j+1))<(height/width)){
                        grids[i][j]=pattern;
                    }
                }
            }
        }
    }
    public String toString(){
        String string = "RightTriangle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
        return string;
    }
}

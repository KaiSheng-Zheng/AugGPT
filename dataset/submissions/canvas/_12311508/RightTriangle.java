public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.d=d;
        this.height=height;
        this.width=width;
        fillGrids();
    }

    public void fillGrids(){
        grids=new char[height][width];
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                if (d==Direction.LEFT_UP){
                    if ((width-j)*((double)height/width)>i){
                        grids[i][j]=pattern;
                    } else {
                        grids[i][j]=' ';
                    }
                } else if (d==Direction.LEFT_DOWN){
                    if (j<(i+1)*((double)width/height)){
                        grids[i][j]=pattern;
                    } else {
                        grids[i][j]=' ';
                    }
                } else if (d==Direction.RIGHT_UP){
                    if (i<(j+1)*((double)height/width)){
                        grids[i][j]=pattern;
                    } else {
                        grids[i][j]=' ';
                    }
                } else if (d==Direction.RIGHT_DOWN){
                    if (i+1>(width-j-1)*((double)height/width)){
                        grids[i][j]=pattern;
                    } else {
                        grids[i][j]=' ';
                    }
                }
            }
        }
    }

    public void enlarge(){
        this.width++;
        this.height++;
        fillGrids();
    }

    public void shrink(){
        this.width--;
        this.height--;
        fillGrids();
    }

    public int area(){
        int area=0;
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                if (grids[i][j]==pattern){
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public String toString(){
        return "RightTriangle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
    }
}

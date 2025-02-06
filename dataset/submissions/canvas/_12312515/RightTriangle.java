import java.lang.Math;
public class RightTriangle extends Shape{
    private int width;
    private int height;
    private int areas;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.location=location;
        this.pattern=pattern;
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids=new char[height][width];
        
        areas=0;
        
        if(d==Direction.RIGHT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    
                    if((height-i-1)*(width)<(j+1)*(height)) {grids[i][j]=pattern;areas++;}
                    else grids[i][j]=' ';
                }
            }
        }
        if(d==Direction.RIGHT_UP){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((i)*(width)<(j+1)*(height)) {grids[i][j]=pattern;areas++;}
                    else grids[i][j]=' ';
                }
            }
        }
        if(d==Direction.LEFT_UP){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((i)*(width)<(width-j)*(height)) {grids[i][j]=pattern;areas++;}
                    else grids[i][j]=' ';
                }
            }
        }
        if(d==Direction.LEFT_DOWN){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((height-i-1)*(width)<(width-j)*(height)) {grids[i][j]=pattern;areas++;}
                    else grids[i][j]=' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        fillGrids();
    }

    @Override
    public void shrink() {
        height--;
        width--;
        fillGrids();
    }
    public int area(){
        return areas;
    }
    @Override
    public String toString(){
        return "RightTriangle: "+location.toString()+" area="+area()+" pattern="+pattern;
    }
}

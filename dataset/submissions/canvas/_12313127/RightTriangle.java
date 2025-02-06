public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;

       // this.fillGrids();
    }
    public void fillGrids(){
        grids=new char[height][width];
        for(int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                grids[i][j]=' ';
            }
        }
        if(d==Direction.LEFT_UP){
            for(int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    if(width*i+height*j<height*width){
                        grids[i][j]=pattern;
                    }
                }
            }
        }
        if(d==Direction.LEFT_DOWN){
            for(int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    if(width*i+height*j<height*width){
                        grids[height-1-i][j]=pattern;
                    }
                }
            }
        }
        if(d==Direction.RIGHT_UP){
            for(int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    if(width*i+height*j<height*width){
                        grids[i][width-1-j]=pattern;
                    }
                }
            }
        }
        if(d==Direction.RIGHT_DOWN){
            for(int i=0;i<height;i++){
                for (int j=0;j<width;j++){
                    if(width*i+height*j<height*width){
                        grids[height-1-i][width-1-j]=pattern;
                    }
                }
            }
        }
    }
    public void enlarge(){
        this.height++;
        this.width++;
        fillGrids();
    }
    public void shrink(){
        this.height--;
        this.width--;
        fillGrids();
    }
    public int area() {
        fillGrids();
        int a=0;
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                if(this.grids[i][j]==pattern){
                    a++;
                }
            }
        }
        return a;

    }
    public String toString(){
        return "RightTriangle: "+this.location.toString()+" area="+this.area()+" pattern="+this.pattern;
    }
}

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.height=height;
        this.width=width;
        this.d=d;
        this.grids=new char[height][width];
        fillGrids();
    };

    public Direction getD() {
        return d;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }
    @Override
    public void fillGrids() {
        double slope= (double) height /width;
        if (d==Direction.LEFT_DOWN){
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    if ((double) (i + 1) /j>slope){
                        grids[i][j]=pattern;
                    }
                    else {grids[i][j]=' ';}
                    }
                }
            }
        if (d==Direction.RIGHT_UP){
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    if ((double) i /(j+1)<slope){
                        grids[i][j]=pattern;
                    }
                    else {grids[i][j]=' ';}
                }
            }
        }
        if (d==Direction.RIGHT_DOWN){
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    if ((double) (i + 1) /(width-j-1)>slope){
                        grids[i][j]=pattern;
                    }
                    else {grids[i][j]=' ';}
                }
            }
        }
        if (d==Direction.LEFT_UP){
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    if ((double) i /(width-j)<slope){
                        grids[i][j]=pattern;
                    }
                    else {grids[i][j]=' ';}
                }
            }
        }
    }
    public void enlarge(){
        this.width=width+1;
        this.height=height+1;
        this.grids=new char[height][width];
        fillGrids();
    }
    public void shrink(){
        this.width=width-1;
        this.height=height-1;
        this.grids=new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        int t=0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(grids[i][j]==pattern){
                    t=t+1;
                }
            }
        }
        return t;
    }
    public String toString(){
        return "RightTriangle: "+location.toString()+" area="+area()+" pattern="+pattern;
    }
}

public class RightTriangle extends Shape{
    private int width;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        this.grids=new char[height][width];
        this.fillGrids();
    }
    public void fillGrids() {
        if(d==Direction.LEFT_UP){
            for(float i=0;i<height;i++){
                for(float j=0;j<width;j++){
                    if(j/(height-i)< (float) width /height){
                        grids[(int) i][(int) j]=pattern;
                    }else{
                        grids[(int) i][(int) j] = ' ';
                    }
                }
            }
        }
        if(d==Direction.LEFT_DOWN){
            for(float i=0;i<height;i++){
                for(float j=0;j<width;j++){
                    if(j/(i+1)< (float) width /height){
                        grids[(int) i][(int) j]=pattern;
                    }else{
                        grids[(int) i][(int) j] = ' ';
                    }
                }
            }
        }
        if(d==Direction.RIGHT_UP){
            for(float i=0;i<height;i++){
                for(float j=0;j<width;j++){
                    if((width-j-1)/(height-i)< (float) width /height){
                        grids[(int) i][(int) j]=pattern;
                    }else{
                        grids[(int) i][(int) j] = ' ';
                    }
                }
            }
        }
        if(d==Direction.RIGHT_DOWN){
            for(float i=0;i<height;i++){
                for(float j=0;j<width;j++){
                    if((width-j-1)/(i+1)< (float) width /height){
                        grids[(int) i][(int) j]=pattern;
                    }else{
                        grids[(int) i][(int) j] = ' ';
                    }
                }
            }
        }
    }
    public void enlarge(){
        height+=1;
        width+=1;
        this.grids=new char[height][width];
        this.fillGrids();
    }
    public void shrink(){
        height-=1;
        width-=1;
        this.grids=new char[height][width];
        this.fillGrids();
    }
    public int area(){
        int area=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grids[i][j]==pattern){
                    area+=1;
                }
            }
        }
        return area;
    }
    public char[][] getGrids(){
        return grids;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }
}
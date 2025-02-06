public class RightTriangle extends Shape{
    private int width;
    private int height;
    private int count=0;
    private final Direction d;
    public RightTriangle(Location location,char pattern,int width,int height,Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;//meiju right or not
        fillGrids();
    }
    public void fillGrids() {
        grids=new char[height][width];
        if(d== Direction.LEFT_DOWN){
            for(int i=0;i<height;i++) {
                for (int j = 0; j <width; j++){
                    if(j==0 || ((double)i+1)/(double)j>(double)height/(double)width){
                        grids[i][j]=pattern;
                        count++;
                    }
                    else{
                        grids[i][j]=' ';
                    }
                }
            }
        }
        if(d== Direction.LEFT_UP){
            for(int i=0;i<height;i++) {
                for (int j = 0; j <width; j++){
                    if(i==0 || ((double)width-(double) j)/(double) i>(double) width/(double) height){
                        grids[i][j]=pattern;
                        count++;
                    }
                    else{
                        grids[i][j]=' ';
                    }
                }
            }
        }
        if(d== Direction.RIGHT_UP){
            for(int i=0;i<height;i++) {
                for (int j = 0; j <width; j++){
                    if(j==width-1 || ((double)height-(double) i)/((double) width-(double) j-1)>(double) height/(double) width){
                        grids[i][j]=pattern;
                        count++;
                    }
                    else{
                        grids[i][j]=' ';
                    }
                }
            }
        }
        if(d== Direction.RIGHT_DOWN){
            for(int i=0;i<height;i++) {
                for (int j = 0; j <width; j++){
                    if(i==height-1 || ((double)j+1)/((double) height-(double) i-1) >(double) width/(double) height){
                        grids[i][j]=pattern;
                        count++;
                    }
                    else{
                        grids[i][j]=' ';
                    }
                }
            }
        }

    }
    public void enlarge(){
        count=0;
        width++;
        height++;
        fillGrids();
    }
    public void shrink(){
        count=0;
        width--;
        height--;
        fillGrids();
    }
    public int area(){
        return count;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),count,pattern);
    }

}

public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width =width;
        this.height = height;
        this.d = d;
        fillGrids();
    }
    public void fillGrids(){
        grids = new char[height][width];
        for (int i =0;i<width;i++){
            for (int j =0;j<height;j++){
                if (d==Direction.RIGHT_UP){
                    if ((height-j)*width>height*(width-i-1)){
                        grids[j][i] = pattern;
                    }else {
                        grids[j][i] = ' ';
                    }
                }
                if (d==Direction.LEFT_UP){
                    if (width*(height-j)>i*height){
                        grids[j][i] = pattern;
                    }else {
                        grids[j][i] = ' ';
                    }
                }
                if (d==Direction.RIGHT_DOWN){
                    if (width*(height-1-j)<(i+1)*height){
                        grids[j][i] = pattern;
                    }else {
                        grids[j][i] = ' ';
                    }
                }
                if (d==Direction.LEFT_DOWN){
                    if ((height-1-j)*width<height*(width-i)){
                        grids[j][i] = pattern;
                    }else {
                        grids[j][i] = ' ';
                    }
                }
            }
        }
    }
    public void enlarge(){
        height = height+1;
        width = width+1;
        fillGrids();
    }
    public void shrink(){
        height =height-1;
        width=width-1;
        fillGrids();
    }
    public int area(){
        int a =0;
        for (int i =0;i<width;i++){
            for (int j=0;j<height;j++){
                if (grids[j][i]==pattern){
                    a++;
                }
            }
        }
        return a;
    }
    public String toString(){

        return String.format("RightTriangle: "+location+" "+"area="+area()+" pattern="+pattern);
    }
}

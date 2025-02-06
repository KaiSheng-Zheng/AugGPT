public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        this.grids = new char[height][width];
        fillGrids();
    }

    public void fillGrids(){
        float wid=width,hei=height;
        float ji=wid/hei;
        grids=new char[height][width];
        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j]=' ';
            }
        }
        switch (d) {
            case LEFT_DOWN:for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    float J=j;
                    float I=i+1;
                    if((J)/(I)<ji){grids[i][j]=pattern;}
                }
            }
                break;
            case LEFT_UP:for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    float J=j;
                    float I=height-i;
                    if((J)/(I)<ji){grids[i][j]=pattern;}
                }
            }
                break;
            case RIGHT_UP:for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    float J=width-j-1;
                    float I=height-i;
                    if((J)/(I)<ji){grids[i][j]=pattern;}
                }
            }
                break;
            case RIGHT_DOWN:for(int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    float J=width-j-1;
                    float I=i+1;
                    if((J)/(I)<ji){grids[i][j]=pattern;}
                }
            }
                break;
        }
    }
    public void enlarge(){
        width++;
        height++;
        fillGrids();
    }
    public void shrink(){
        width--;
        height--;
        fillGrids();
    }
    public int area(){int t=0;
        for (int i = 0; i <height; i++) {
            for (int j = 0; j < width; j++) {
                if(grids[i][j]==pattern){t++;}
            }
        }
        return t;}
    public String toString(){
        return "RightTriangle: "+"("+location.getX()+","+location.getY()+")"+" area="+area()+" pattern="+pattern;
    }
}

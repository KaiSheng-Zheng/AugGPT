public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location,char pattern,int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        grids=new char[height][width];
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.grids[i][j] = ' ';
            }

        }
        double h=height;
        double w=width;
        double k;
        switch (d) {
            case LEFT_UP:
                k=h/w;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if(i/(w-j)<k){
                            this.grids[i][j]=pattern;
                        }
                    }
                }
                break;
            case LEFT_DOWN:
                k=w/h;
                for (int i = 1; i < height+1; i++) {
                    for (int j = 0; j < width; j++) {
                        if((double) j /i <k){
                            this.grids[i-1][j]=pattern;
                        }
                    }
                }
                break;
            case RIGHT_UP:
                k=w/h;
                for (int i = 0; i < height; i++){
                    for (int j = 1;j < width+1; j++){
                        if((w-j)/(h-i)<k){
                            this.grids[i][j-1]=pattern;
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                k=h/w;
                for (int i = 1; i < height+1; i++){
                    for (int j = 1;j < width+1; j++){
                        if((h-i)/j<k){
                            this.grids[i-1][j-1]=pattern;
                        }
                    }
                }
                break;
            default:
                break;
        }
    }
    @Override
    public void enlarge(){
        this.width++;
        this.height++;
        this.grids=new char[height][width];
        fillGrids();
    }
    @Override
    public void shrink(){
        this.width--;
        this.height--;
        this.grids=new char[height][width];
        fillGrids();
    }
    @Override
    public int area(){
        int count = 0;
        for (int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }
}

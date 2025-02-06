
public class RightTriangle extends Shape {
    int count=0;
    private int width;
    private int height;
    private Direction d ;
    char[][]grids;


    public RightTriangle(Location location, char pattern,int width,int height,Direction d) {
        super(location, pattern);
        this.pattern=pattern;
        this.width=width;
        this.height=height;
        grids=new char[height][width];
        this.d=d;
        fillGrids();
    }

    @Override
    public char[][] getGrids() {
        return fillGrids();
    }

    @Override
    public char[][] fillGrids() {
        grids=new char[height][width];
        count=0;
        if(d==Direction.LEFT_DOWN){
            double slope=height*1.0/width;
            for (int i = 0; i < height; i++) {
                grids[i][0]=pattern;
                count++;
                for (int i1 = 1; i1 < width; i1++) {
                    double slopex=(i+1)*1.0/i1;
                    if(slopex>slope){
                        grids[i][i1]=pattern;
                        count++;
                    }else{
                        grids[i][i1]=' ';
                    }
                }
            }
        }
        if(d==Direction.LEFT_UP){
            double slope=(double) (height)/(double) (width);
            for (int i = 0; i < height; i++) {
                grids[i][0]=pattern;
                count++;
                for (int i1 = 1; i1 < width; i1++) {
                    double slopex=(i)*1.0/i1;
                    if(slopex<slope){
                        grids[i][width-i1]=pattern;
                        count++;
                    }else{
                        grids[i][width-i1]=' ';
                    }
                }
            }
        }
        if(d==Direction.RIGHT_DOWN){
            double slope=height*1.0/width;
            for (int i = 0; i < height; i++) {
                grids[i][width-1]=pattern;
                count++;
                for (int i1 = 0; i1 < width-1; i1++) {
                    double slopex=(i+1)*1.0/(width-i1-1);
                    if(slopex>slope){
                        grids[i][i1]=pattern;
                        count++;
                    }else{
                        grids[i][i1]=' ';
                    }
                }
            }
        }
        if(d==Direction.RIGHT_UP){
            double slope=(double) (height)/(double) (width);
            for (int i = 0; i < height; i++) {
                grids[i][width-1]=pattern;
                count++;
                for (int i1 = 0; i1 < width-1; i1++) {
                    double slopex=i*1.0/(i1+1);
                    if(slopex<slope){
                        grids[i][i1]=pattern;
                        count++;
                    }else{
                        grids[i][i1]=' ';
                    }
                }
            }
        }
        return grids;
    }

    @Override
    public void enlarge() {
        width+=1;
        height+=1;
        fillGrids();
    }

    @Override
    public void shrink() {
        width-=1;
        height-=1;
        fillGrids();
    }

    @Override
    public int area() {
        return count;
    }
    public String toString(){
        return "RightTriangle: "+location+" area="+area()+" pattern="+pattern;
    }
}

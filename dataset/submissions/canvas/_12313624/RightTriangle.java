public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location,char pattern,int width,int height,Direction d){
        super(location,pattern);
        this.d=d;
        this.height=height;
        this.width=width;
        super.grids=new char[height][width];
        fillGrids();
    }
    @Override
    public void fillGrids(){
        super.grids=new char[height][width];
        double slope=(double) width/height;
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = 0; i1 < grids[0].length; i1++) {
                int a=i+1;
                if ((double) i1/a<slope)grids[i][i1]=pattern;
                else grids[i][i1]=' ';
            }
        }
        if (d==Direction.LEFT_DOWN){
        } else if (d==Direction.LEFT_UP) {
            char inter;
            for (int i = 0; i < grids.length/2; i++) {
                for (int i1 = 0; i1 < grids[0].length; i1++) {
                    inter=grids[i][i1];
                    grids[i][i1]=grids[height-i-1][i1];
                    grids[height-i-1][i1]=inter;
                }
            }
        } else if (d==Direction.RIGHT_DOWN) {
            for (int i = 0; i < grids.length; i++) {
                char inter;
                for (int i1 = 0; i1 < grids[0].length/2; i1++) {
                    inter=grids[i][i1];
                    grids[i][i1]=grids[i][width-i1-1];
                    grids[i][width-i1-1]=inter;
                }
            }
        }else {
            for (int i = 0; i < grids.length/2; i++) {
                for (int i1 = 0; i1 < grids[0].length; i1++) {
                    char inter;
                    inter=grids[i][i1];
                    grids[i][i1]=grids[height-i-1][i1];
                    grids[height-i-1][i1]=inter;
                }
            }
            for (int i = 0; i < grids.length; i++) {
                char inter;
                for (int i1 = 0; i1 < grids[0].length/2; i1++) {
                    inter=grids[i][i1];
                    grids[i][i1]=grids[i][width-i1-1];
                    grids[i][width-i1-1]=inter;
                }
            }
        }
    }
    @Override
    public void enlarge(){
        height++;
        width++;
        fillGrids();
    }
    @Override
    public void shrink(){
        height--;
        width--;
        fillGrids();
    }
    @Override
    public int area(){
        int number=0;
        for (int i = 0; i < grids.length; i++) {
            for (int i1 = 0; i1 < grids[0].length; i1++) {
                if (grids[i][i1]==pattern)number++;
            }
        }
        return number;
    }
    @Override
    public String toString(){
        return String.format("RightTriangle: "+
                location.toString()+" area="+area()+" pattern="+pattern);
    }
}

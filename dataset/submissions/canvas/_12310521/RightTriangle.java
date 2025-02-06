public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location,char pattern,int width,int height,Direction direction){
        super(location,pattern);
        d = direction;
        this.width = width;
        this.height = height;
        grids = new char[height][width];
        fillGrids();
    }
    public void fillGrids(){
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if(inTriangle(d,i,j)){
                    grids[i][j]=pattern;
                }else {
                    grids[i][j]=' ';
                }
            }
        }
    }
    public boolean inTriangle(Direction d,int row,int column){
        double x = column;
        double y = row;
        double ym =height;
        double xm =width;
        double k = ym/xm;
        switch(d){
            case LEFT_DOWN ->{
                if(y+1>k*x){
                    return true;
                }
                return false;
            }
            case LEFT_UP -> {
                if (y<k*((double) width-x)){
                    return true;
                }
                return false;
            }
            case RIGHT_DOWN -> {
                if (y+1>k*((double)width-x-1)){
                    return true;
                }
                return false;
            }
            case RIGHT_UP -> {
                if (y<k*(x+1)){
                    return true;
                }
                return false;
            }
        }
        return true;
    }
    public void enlarge(){
        height++;
        width++;
        grids=new char[height][width];
        fillGrids();
    }

    public void shrink(){
        if (height>0&width>0){
            height--;
            width--;
            grids = new char[height][width];
            fillGrids();
        }
    }

    @Override
    public int area() {
        int area =0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (!(grids[i][j]==' ')){area++;}
            }
        }
        return area;
    }
    public String toString(){
        return String.format("RightTriangle: %s area=%d pattern=%s",location,area(),pattern);
    }
}

public class RightTriangle extends  Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width =width;
        this.height = height;
        this.d = d;
        fillGrids();
    }


    @Override
    public void fillGrids() {
        char[][] grid = new char[height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if(ifFill(i,j)){
                    grid[i][j] = super.pattern;
                }else{grid[i][j] = ' ';}
            }
        }


        super.grids = grid;
    }

    @Override
    public void enlarge() {
        this.width+=1;
        this.height+=1;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        this.width-=1;
        this.height-=1;
        this.fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                if(super.getGrids()[i][j] == super.pattern){
                    area++;
                }
            }
        }
        return area;
    }

    private boolean ifFill(int i,int j){
        double w = width;
        double h = height;

        if(d.equals(Direction.LEFT_DOWN)){
            if((i+1)*(w/h)>j){
                return true;
            }else {return false;}
        }else if(d.equals(Direction.RIGHT_UP)){
            if((i)*(w/h)<(j+1)){
                return true;
            }else {return false;}
        }else if(d.equals(Direction.RIGHT_DOWN)){
            if((height-i-1)*(w/h)<(j+1)){
                return true;
            }else {return false;}
        }else {
            if((height-i)*(w/h)>(j)){
                return true;
            }else {return false;}
    }
    }

    public String toString(){
        String string= String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(),location.getY(),area(),pattern);
        return string;
    }
}
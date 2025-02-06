public class RightTriangle extends Shape{
    private double width;
    private double height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, double width, double height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.fillGrids();
    }
    public void fillGrids(){
        grids = new char[(int)height][(int)width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(this.ifToFill(i,j)){
                    grids[i][j] = pattern;
                    count++;
                }else{
                    grids[i][j] = ' ';
                }
            }
        }
    }
    public void enlarge(){
        count = 0;
        width++;
        height++;
        this.fillGrids();;
    }
    public void shrink(){
        count = 0;
        width--;
        height--;
        this.fillGrids();;
    }
    public String toString() {
        return "RightTriangle: (" + super.getX() + "," + super.getY() + ") area=" + count + " pattern=" + pattern;
    }
    public int area(){
        return count;
    }
    public boolean ifToFill(int i,int j){
        double p = (double) i;
        double q = (double) j;
        if(d == Direction.LEFT_UP){
            if(j == 0||(height-p)/q>height/width||(height-1-p)/(q+1)>height/width||(height-p)/(q+1)>height/width||(height-1-p)/q>height/width){
                return true;
            }else return false;
        }
        if(d == Direction.LEFT_DOWN){
            if(j == 0||p/q>height/width||(p+1)/q>height/width||p/(q+1)>height/width||(p+1)/(q+1)>height/width){
                return true;
            }else return false;
        }
        if(d == Direction.RIGHT_UP){
            //System.out.println((double) (i)*(double) width/(double) height);
            if(j == width-1||(height-p)/(width-q)>height/width||(height-1-p)/(width-q)>height/width||(height-p)/(width-1-q)>height/width||(height-1-p)/(width-1-q)>height/width){
                return true;
            }else return false;
        }
        if(d == Direction.RIGHT_DOWN){
            if(j == width-1||p/(width-q)>height/width||(p+1)/(width-q)>height/width||p/(width-1-q)>height/width||(p+1)/(width-1-q)>height/width){
                return true;
            }else return false;
        }
        return false;
    }
}

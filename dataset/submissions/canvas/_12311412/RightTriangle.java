public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void fillGrids() {
        if(d == Direction.LEFT_DOWN) {
            for(int i=0; i<width; i++){
                for(int j=0; j<height; j++){
                    if(width*(j+1)>height*i){
                        grids[j][i] = pattern;
                    }
                    else{
                        grids[j][i] = ' ';
                    }
                }
            }
        }
        if(d == Direction.LEFT_UP) {
            for(int i=0; i<width; i++){
                for(int j=0; j<height; j++){
                    if(height*(width-i)>width*j){
                        grids[j][i] = pattern;
                    }
                    else{
                        grids[j][i] = ' ';
                    }
                }
            }
        }
        if(d == Direction.RIGHT_DOWN) {
            for(int i=0; i<width; i++){
                for(int j=0; j<height; j++){
                    if(height*(width-i-1)<width*(j+1)){
                        grids[j][i] = pattern;
                    }
                    else{
                        grids[j][i] = ' ';
                    }
                }
            }
        }
        if(d == Direction.RIGHT_UP) {
            for(int i=0; i<width; i++){
                for(int j=0; j<height; j++){
                    if(width*j<height*(i+1)){
                        grids[j][i] = pattern;
                    }
                    else{
                        grids[j][i] = ' ';
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        width--;
        height--;
        grids = new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        int count=0;
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                if(grids[j][i] == pattern){
                    count++;
                }
            }
        }
        return count;
    }
    @Override
    public String toString(){
        return ("RightTriangle: (" + location.getX() + "," + location.getY()+") area=" + area() +" pattern=" + pattern);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;


    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
    }
    public void fillGrids(){
        grids = new char[height][width];
        double tan = (0.0+height)/width;
        if (d == Direction.LEFT_DOWN){
            for (int i = 0; i < width;i++){
                if (i == 0){
                    for (int j = 0 ; j < height; j++){
                        grids[j][0] = pattern;
                    }
                }
                for (int j = 0 ; j < height; j++){
                    if ((j+1)/(i+0.0) > tan){
                        grids[j][i] = pattern;
                    }
                    if ((j+1)/(i+0.0) <= tan){
                        grids[j][i] = ' ';
                    }
                }
            }
        }

        if (d == Direction.RIGHT_DOWN){
            for (int i = 0; i < width;i++){
                if (i == width-1){
                    for (int j = 0 ; j < height; j++){
                        grids[j][width-1] = pattern;
                    }
                }
                for (int j = 0 ; j < height; j++){
                    if ((j+1.0)/(width-i-1) > tan){
                        grids[j][i] = pattern;
                    }
                    if ((j+1.0)/(width-i-1) <= tan){
                        grids[j][i] = ' ';
                    }
                }
            }
        }

        if (d == Direction.LEFT_UP){
            for (int i = 0; i < width;i++){
                if (i == 0){
                    for (int j = 0 ; j < height; j++){
                        grids[j][0] = pattern;
                    }
                }
                for (int j = 0 ; j < height; j++){
                    if ((j+1.0)/i > tan){
                        grids[height-1-j][i] = pattern;
                    }
                    if ((j+1.0)/i <= tan){
                        grids[height-1-j][i] = ' ';
                    }
                }
            }
        }
        if (d == Direction.RIGHT_UP){
            for (int i = 0; i < width;i++){
                if (i == width-1){
                    for (int j = 0 ; j < height; j++){
                        grids[j][width-1] = pattern;
                    }
                }
                for (int j = 0 ; j < height; j++){
                    if ((j+1.0)/(width-i-1) > tan){
                        grids[height-1-j][i] = pattern;
                    }
                    if ((j+1.0)/(width-i-1) <= tan){
                        grids[height-1-j][i] = ' ';
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        width += 1;
        height += 1;
    }

    @Override
    public void shrink() {
        width -= 1;
        height -= 1;
    }

    @Override
    public int area() {
        fillGrids();
        int count = 0;
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                if (grids[j][i] == pattern){
                    count += 1;
                }
                else {count =count;}
            }
        }
        return count;
    }

    public String toString(){
        return String.format("RightTriangle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern);
    }


}

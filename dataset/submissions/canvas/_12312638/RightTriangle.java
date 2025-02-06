public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    public  void fillGrids() {
        grids = new char[height][width];
        double slope = (double) height / width;


            for (int i=0; i< height; i++) {
                for(int j=0; j< width; j++) {
                    int distanceY = height - (i+1);
                    int distanceX = width - (j);
                    double distance = (double) distanceY / distanceX;

                    if(d == Direction.LEFT_DOWN) {
                        if(distance < slope) {
                            grids[i][j] = pattern;
                        }else{
                            grids[i][j] = ' ';
                        }
                    }

                    if(d == Direction.RIGHT_DOWN) {
                        if(distance < slope) {
                            grids[i][width-1-j] = pattern;
                        }else{
                            grids[i][width-1-j] = ' ';
                        }
                    }

                    if(d == Direction.LEFT_UP) {
                        if(distance < slope) {
                            grids[height-1-i][j] = pattern; // left_up
                        }else{
                            grids[height-1-i][j] = ' '; // left_up
                        }
                    }

                    if(d == Direction.RIGHT_UP) {
                        if(distance < slope) {
                            grids[height-i-1][width-j-1] = pattern; // right_up
                        }else{
                            grids[height-i-1][width-j-1] = ' '; // right_up
                        }
                    }

                }
            }


    }

    public  void enlarge() {
        height++;
        width++;
        fillGrids();
    }

    public  void shrink() {
        height--;
        width--;
        fillGrids();
    }

    public  int area() {
        int count = 0;
        for(int i=0; i< height; i++) {
            for(int j=0; j< width; j++) {
                if(grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        String className = "RightTriangle";
        String output = className + ": " + "("+ location.getX() + "," + location.getY() + ") area="+ area() + " pattern=" + pattern;

        return output;
    }
}

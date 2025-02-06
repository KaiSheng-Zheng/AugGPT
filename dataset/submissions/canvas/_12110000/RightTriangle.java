public class RightTriangle extends Shape{
    private int width; //range from 1 to 20
    private int height; //range from 1 to 20
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        //grids = new char[height][width];
        this.fillGrids();
    }

    public String toString(){
        return "RightTriangle: (" + location.getX() + "," + location.getY()
                + ") area=" + area() + " pattern=" + pattern;
    }

    public void fillGrids(){
        grids = new char[height][width];
        double slopeOfTriangle = (double) height / (double) width;
        switch (d){
            case LEFT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        grids[i][j] = (slope(height - i, j) > slopeOfTriangle)? pattern : ' ';
                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        grids[i][j] = (slope(i+1, j) > slopeOfTriangle)? pattern : ' ';
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        grids[i][j] = (slope(height - i, width - j - 1) > slopeOfTriangle)? pattern : ' ';
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        grids[i][j] = (slope(i+1, width - j - 1) > slopeOfTriangle)? pattern : ' ';
                    }
                }
                break;
        }
    }

    public double slope(int i, int j){
        return (double) i / (double) j;
    }

    public void enlarge(){
        width++;
        height++;
        this.fillGrids();
    }

    public void shrink(){
        if(width > 1){
            width--;
        }
        if(height > 1){
            height--;
        }
        this.fillGrids();
    }

    public int area(){
        int num = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if(grids[i][j] == pattern){
                    num++;
                }
            }
        }

        return num;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Direction getD() {
        return d;
    }
}

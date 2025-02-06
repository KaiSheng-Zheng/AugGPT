public class Circle extends Shape {
    private int radius;

    private int pattern_count;

    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        grids = new char[radius * 2][radius * 2];//initialize the grids in the constructor
        fillGrids();
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void fillGrids() {
        //clear the counter before counting
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if(inTest(i,j,radius)){
                    //We use the principle of mirrors
                    grids[i][j] = pattern;
                    grids[radius * 2 - 1 - i][j] = pattern;
                    grids[i][radius * 2 - 1 - j] = pattern;
                    grids[radius * 2 - 1 - i][radius * 2 - 1 - j] = pattern;
                    pattern_count += 4;
                }
            }
        }
        //Blank a space into every null grid
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if(grids[i][j] == '\u0000'){
                    grids[i][j] = ' ';
                }
            }
        }
    }

    //Whether the point should be in the circle
    private boolean inTest(int x1, int x2, int r){
        double distance = Math.sqrt((r - x1 - 1) * (r -x1 - 1) + (r - x2 - 1) * (r - x2 - 1));
        return distance < r;
    }
    @Override
    public void enlarge() {
        pattern_count = 0;
        radius ++;
        grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public void shrink() {
        pattern_count = 0;
        radius--;
        grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public int area() {
        return pattern_count;
    }

    public String toString(){
        return "Circle: (" + location.getX() + "," + location.getY() + ") area="
                + area() + " pattern=" + pattern;
    }
}

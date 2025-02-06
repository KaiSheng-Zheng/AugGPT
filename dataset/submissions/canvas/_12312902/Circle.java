import java.util.List;

public class Circle extends Shape implements ShapeCanvas{
    private int radius;
    public int count = 0;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.fillGrids();
    }


    @Override
    public void fillGrids() {
        // should clear count before filling
        grids = new char[2 * this.radius][2 * this.radius];
        for (int i = 0; i < radius ; i++) {
            for (int j = 0; j < radius ; j++) {
                if(((i + 1 - radius)*(i + 1 -radius) + (j + 1 - radius)*(j + 1 - radius)) < (radius * radius)){
                    this.grids[i][j] = pattern;
                    count ++;
                }else{
                    this.grids[i][j] = ' ';
                }


            }

        }
        for (int k = 0; k < radius; k++) {
            for (int p = radius; p < (2 * radius); p++) {
                if(((k + 1 - radius) * (k + 1 - radius) + (p - radius) *(p-radius)) < (radius * radius)){
                    this.grids[k][p] = pattern;
                    count ++;
                }else{
                    this.grids[k][p] = ' ';
                }

            }

        }

        for (int x = radius; x < (2 * radius); x++) {
            for (int y = 0; y < radius; y++) {
                if(((x - radius) * (x - radius) + (y + 1 - radius)* (y + 1 - radius)) < (radius * radius)){
                    this.grids[x][y] = pattern;
                    count ++;
                }else{
                    this.grids[x][y] = ' ';
                }

            }

        }

        for (int t = radius; t < (2 * radius); t++) {
            for (int z = radius; z < (2 * radius); z++) {
                if(((t - radius) * (t - radius) + (z - radius) * (z - radius)) < (radius * radius)){
                    this.grids[t][z] = pattern;
                    count ++;
                }else{
                    this.grids[t][z] = ' ';
                }

            }

        }
    }

    @Override
    public void enlarge() {
        this.radius++;
        this.grids = new char[2*this.radius][2*this.radius];
        count = 0;
        this.fillGrids();


    }

    public char getPattern(){
        return pattern;
    }

    @Override
    public void shrink() {
        this.radius--;
        this.grids = new char[2*this.radius][2*this.radius];
        count = 0;
        this.fillGrids();


    }

    @Override
    public int area() {

        return count;
    }

    public String toString() {
        return "Circle: " + location.toString() + " area="
                + area() + " pattern=" + pattern;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        return false;
    }

    @Override
    public int getShapeCount() {
        return 0;
    }

    @Override
    public char[][] getCanvas() {
        return new char[0][];
    }

    @Override
    public int getSpaceGridCount() {
        return 0;
    }

    @Override
    public List<Shape> getShapesByArea() {
        return null;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        return null;
    }
}

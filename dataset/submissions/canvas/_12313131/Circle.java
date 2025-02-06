import java.util.ArrayList;
import java.util.List;

public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {

        super(location, pattern);
        this.radius = radius;
       this.locations = new ArrayList<Location>();
    }

    @Override
    public void fillGrids() {

        grids = new char[radius * 2][radius * 2];
        for (int x = 0; x < 2*radius; x++) {
            for (int y = 0; y < 2*radius; y++) {

        grids[x][y]=' ';
        }}
        for (int i = 0; i < 2*radius; i++) {
            for (int j = radius; j < 2 * radius; j++) {
                double distance = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius, 2));
                if (distance < radius) {
                    grids[i][j] = pattern;
                    grids[i][2 * radius - 1 - j] = pattern;
                    grids[2 * radius - i - 1][2 * radius - j - 1] = pattern;
                    grids[2 * radius - i - 1][j] = pattern;

                }

            }
        }
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (grids[i][j] == pattern) {
                this.locations.add(new Location(i+getX(), j+getY()));}
            }
        }
    }
    @Override
    public void enlarge(){
        this.radius++;
        fillGrids();
    }
    @Override
    public void shrink(){
        this.radius--;
        fillGrids();
    }
    @Override
    public int area() {
        fillGrids();
        int count = 0;
        for (int x = 0; x < 2*radius; x++) {
            for (int y = 0; y < 2*radius; y++) {
                if (grids[x][y] == pattern) {count++;}
            }
        }
        return count;
    }

    public int getRadius() {
        return radius;
    }

}

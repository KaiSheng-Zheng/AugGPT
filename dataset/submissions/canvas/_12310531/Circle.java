import java.awt.*;

public class Circle extends Shape {
    private int radius;
    public Circle() {}

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius; // Ensure the radius is within the specified range [1-15]
        fillGrids();
    }

    @Override
    public void fillGrids() {
        int diameter = 2 * radius;
        grids = new char[diameter][diameter];
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                grids[i][j] = ' '; // Initialize with space
            }
        }
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                if (!(
                        (i - radius) * (i - radius) + (j - radius) * (j - radius) >= (radius * radius)&&
                (i+1 - radius) * (i+1 - radius) + (j - radius) * (j - radius) >= (radius * radius)&&
                (i - radius) * (i - radius) + (j+1 - radius) * (j+1 - radius) >= (radius * radius)&&
                (i+1 - radius) * (i+1 - radius) + (j+1 - radius) * (j+1 - radius) >= (radius * radius)
                )) {
                    grids[i][j] = pattern;
                }
            }
        }
    }

    @Override
    public int area() {
        fillGrids();
        int count = 0;
        int diameter = 2 * radius;
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }


    @Override
    public void enlarge() {
        if (radius < 15) {
            radius++;
            fillGrids();
        }
    }

    @Override
    public void shrink() {
        if (radius > 1) {
            radius--;
            fillGrids();
        }
    }
}




import com.sun.source.tree.NewArrayTree;

import javax.swing.plaf.metal.MetalIconFactory;

public class Circle extends Shape {
    private int radius;


    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        grids = new char[radius * 2][radius * 2];

        this.fillGrids();
    }

    @Override
    public void fillGrids() {

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids.length; j++) {
                grids[i][j] = ' ';

            }

        }
        for (int i = 0; i <= radius; i++) {
            for (int j = 0; j <= radius; j++) {
                if (Math.sqrt((i - radius) * (i - radius) + (j - radius) * (j - radius)) < radius) {
                    grids[i - 1][j - 1] = pattern;
                }

            }

        }
        for (int i = radius; i < grids.length ; i++) {
            for (int j = radius; j < grids.length; j++) {
                if (Math.sqrt((i - radius) * (i - radius) + (j - radius) * (j - radius)) < radius) {
                    grids[i ][j ] = pattern;
                }

            }

        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (grids[i][j] == pattern) {
                    grids[i][2 * radius - 1 - j] = pattern;
                    grids[2 * radius - 1 - j][i] = pattern;
                }
            }
        }
    }

    @Override
    public void enlarge() {

        radius = radius + 1;
        grids = new char[radius * 2][radius * 2];
        fillGrids();

    }

    @Override
    public void shrink() {

        radius = radius - 1;
        grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public int area() {
        int counter = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids.length; j++) {

                if (grids[i][j] == pattern) {
                    counter++;
                }

            }

        }
        return counter;
    }

    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(), pattern);
    }

    public void update() {
    }
}


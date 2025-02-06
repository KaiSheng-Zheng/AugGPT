import java.util.ArrayList;
import java.util.Collections;

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Direction getD() {
        return d;
    }

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[height][width];
        double slope = -(double) height / width;
        int intercept = height;
        for (int i = 1; i < width; i++) {
            double value = i * slope + intercept;
            if (Math.ceil(value) < height) {
                for (int j = 0; j < height - Math.ceil(value); j++) {
                    grids[j][i] = ' ';
                }
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] != ' ') {
                    grids[i][j] = pattern;
                }
            }
        }
        overturnFromDirection(grids);
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }

    @Override
    public void shrink() {
        width--;
        height--;
        fillGrids();
    }

    @Override
    public int area() {
        int counter = 0;
        for (char[] grid : grids) {
            for (char c : grid) {
                if (c == pattern) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private void fillEmptyGrids(char[][] grids, char pattern) {
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] != pattern) {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    public void overturnHorizontally(char[][] grids) {
        for (int i = 0; i < grids.length; i++) {
            ArrayList<Character> list = new ArrayList<Character>();
            for (int j = 0; j < grids[i].length; j++) {
                list.add(grids[i][j]);
            }
            Collections.reverse(list);
            for (int j = 0; j < grids[i].length; j++) {
                grids[i][j] = list.get(j);
            }
        }
    }

    public void overturnVertically(char[][] grids) {
        for (int i = 0; i < grids[0].length; i++) {
            ArrayList<Character> list = new ArrayList<Character>();
            for (int j = 0; j < grids.length; j++) {
                list.add(grids[j][i]);
            }
            Collections.reverse(list);
            for (int j = 0; j < grids.length; j++) {
                grids[j][i] = list.get(j);
            }
        }
    }

    public void overturnFromDirection(char[][] grids) {
        if (d.equals(Direction.RIGHT_DOWN)) {
            overturnHorizontally(grids);
        } else if (d.equals(Direction.LEFT_UP)) {
            overturnVertically(grids);
        } else if (d.equals(Direction.RIGHT_UP)) {
            overturnVertically(grids);
            overturnHorizontally(grids);
        }
    }
}
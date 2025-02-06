import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j] = ' ';
            }
        }
    }
    public int getRows() {
        return this.canvas.length;
    }
    public int getCols() {
        return this.canvas[0].length;
    }

    public boolean addShape(int x, int y, char pattern, int radius) {
        boolean ifAdd = false;
        Location location = new Location(x, y);
        Shape target = new Circle(location, pattern, radius);
        if (!this.ifOut(x, y, radius)) {
            if (!this.ifConflict(x, y, target)) {
                ifAdd = true;
                this.shapes.add(target);
                char[][] grids = target.getGrids();
                int height = grids.length;
                int width = grids[0].length;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (grids[i][j] != ' ') {
                            canvas[x + i][y + j] = pattern;
                        }
                    }
                }
            }
        }
        return ifAdd;
    }

    public boolean addShape(int x, int y, char pattern, int width, int height, int direction) {
        boolean ifAdd = false;
        Location location = new Location(x, y);
        Direction d = Direction.matchIntToDir(direction);
        Shape target = new RightTriangle(location, pattern, width, height, d);
        if (!this.ifOut(x, y, width, height)) {
            if (!this.ifConflict(x, y, width, height, target)) {
                ifAdd = true;
                this.shapes.add(target);
                char[][] grids = target.getGrids();
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (grids[i][j] != ' ') {
                            canvas[x + i][y + j] = pattern;
                        }
                    }
                }
            }
        }
        return ifAdd;
    }

    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getCols(); j++) {
                if (canvas[i][j] != ' ') {
                    count++;
                }
            }
        }
        int width = this.getCols();
        int height = this.getRows();
        return width * height - count;
    }
    public int getShapeCount() {
        return this.shapes.size();
    }
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < this.shapes.size(); i++) {
            shapes.get(i).setSelection(1);
        }
        Collections.sort(shapes);
        return shapes;
    }
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < this.shapes.size(); i++) {
            shapes.get(i).setSelection(2);
        }
        Collections.sort(shapes);
        return shapes;
    }
    public char[][] getCanvas() {
        return this.canvas;
    };

    public boolean ifOut(int x, int y, int radius) {
        boolean ifOut = false;
        if (x + radius * 2 > this.getRows() || y + radius * 2 > this.getCols()) {
            ifOut = true;
        }
        return ifOut;
    }

    public boolean ifOut(int x, int y, int width, int height) {
        boolean ifOut = false;
        if (x + height > this.getRows() || y + width > this.getCols()) {
            ifOut = true;
        }
        return ifOut;
    }

    public boolean ifConflict(int x, int y, Shape target) {
        boolean ifConflict = false;
        char[][] grids = target.getGrids();
        outer:
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] != ' ' && this.canvas[x + i][y + j] != ' ') {
                    ifConflict = true;
                    break outer;
                }
            }
        }
        return ifConflict;
    }

    public boolean ifConflict(int x, int y, int width, int height, Shape target) {
        boolean ifConflict = false;
        char[][] grids = target.getGrids();
        outer:
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j] != ' ' && this.canvas[x + i][y + j] != ' ') {
                    ifConflict = true;
                    break outer;
                }
            }
        }
        return ifConflict;
    }
}

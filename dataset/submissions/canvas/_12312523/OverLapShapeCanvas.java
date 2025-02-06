import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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
        int enclosedArea = 0;
        char[][] grids = target.getGrids();
        int height = grids.length;
        int width = grids[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (x + i < this.getRows() && y + j < this.getCols()) {
                    if (grids[i][j] != ' ') {
                        enclosedArea++;
                        canvas[x + i][y + j] = pattern;
                    }
                }
            }
        }
        if (enclosedArea > 0) {
            this.shapes.add(target);
            ifAdd = true;
        }
        return ifAdd;
    }

    public boolean addShape(int x, int y, char pattern, int width, int height, int direction) {
        boolean ifAdd = false;
        Location location = new Location(x, y);
        Direction d = Direction.matchIntToDir(direction);
        Shape target = new RightTriangle(location, pattern, width, height, d);
        int enclosedArea = 0;
        char[][] grids = target.getGrids();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (x + i < this.getRows() && y + j < this.getCols()) {
                    if (grids[i][j] != ' ') {
                        enclosedArea++;
                        canvas[x + i][y + j] = pattern;
                    }
                }
            }
        }
        if (enclosedArea > 0) {
            this.shapes.add(target);
            ifAdd = true;
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
}

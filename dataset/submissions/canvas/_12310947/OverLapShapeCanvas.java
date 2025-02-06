import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int ShapeCount;
    private int r;
    private int c;

    public OverLapShapeCanvas(int rows, int cols) {
        this.r = rows;
        this.c = cols;
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        this.shapes = new ArrayList<>();
    }

    public int getSpaceGridCount() {
        int SpaceGridCount = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (canvas[i][j] == ' ') {
                    SpaceGridCount++;
                }
            }
        }

        return SpaceGridCount;

    }

    public int getShapeCount() {
        return ShapeCount;
    }

    public List<Shape> getShapesByArea() {
        Comparator hyn = Comparator.comparing(Shape::area).thenComparing(Shape::getPattern);
        this.shapes.sort(hyn);
        return shapes;
    }

    public List<Shape> getShapesByLocation() {
        Comparator hyn = Comparator.comparing(Shape::getX).thenComparing(Shape::getY).thenComparing(Shape::getPattern);
        this.shapes.sort(hyn);
        return this.shapes;
    }

    public char[][] getCanvas() {
        return this.canvas;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            int a = 0;
            Location l = new Location(x, y);
            Circle yzy = new Circle(l, pattern, params[0]);
            for (int i = 0; i < 2 * params[0]; i++) {
                for (int j = 0; j < 2 * params[0]; j++) {
                    if (yzy.getGrids()[i][j] != ' ' && x + i < r && y + j < c) {
                        a = 1;
                    }
                }
            }
            if (a != 0) {
                this.ShapeCount++;
                this.shapes.add(yzy);
                for (int i = 0; i < 2 * params[0]; i++) {
                    for (int j = 0; j < 2 * params[0]; j++) {
                        if (yzy.getGrids()[i][j] != ' ' && x + i < r && y + j < c) {
                            this.canvas[x + i][y + j] = pattern;
                        }
                    }
                }
                return true;
            }


        }
        if (params.length == 3) {
                Location l = new Location(x, y);
                Direction d = Direction.LEFT_UP;
                if (params[2] == 0) {
                    d = Direction.LEFT_UP;
                }
                if (params[2] == 1) {
                    d = Direction.LEFT_DOWN;
                }
                if (params[2] == 2) {
                    d = Direction.RIGHT_UP;
                }
                if (params[2] == 3) {
                    d = Direction.RIGHT_DOWN;
                }
                RightTriangle yzy = new RightTriangle(l, pattern, params[0], params[1], d);
                int a = 0;
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if (yzy.getGrids()[i][j] != ' ' && x + i < r && y + j < c) {
                            a = 1;
                        }
                    }
                }
                if (a != 0) {
                    this.ShapeCount++;
                    this.shapes.add(yzy);
                    for (int i = 0; i < params[1]; i++) {
                        for (int j = 0; j < params[0]; j++) {
                            if (yzy.getGrids()[i][j] != ' ' && x + i < r && y + j < c) {
                                this.canvas[x + i][y + j] = pattern;
                            }
                        }
                    }
                    return true;

                }
            }

        return false;
    }
}

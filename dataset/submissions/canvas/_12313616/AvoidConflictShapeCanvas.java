import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < this.canvas.length; i++) {
            for (int j = 0; j < this.canvas[i].length; j++) {
                this.canvas[i][j] = 32;
            }
        }
        this.shapes = new ArrayList<Shape>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        if (params.length == 1) {
            Circle circle = new Circle(location, pattern, params[0]);

            if (y + circle.grids.length >= 0 && y + circle.grids.length <= canvas[0].length &&
                    x + circle.grids.length >= 0 && x + circle.grids.length <= canvas.length) {
                for (int i = 0; i < circle.grids.length; i++) {
                    for (int j = 0; j < circle.grids[i].length; j++) {
                        if (circle.grids[i][j] == pattern) {
                            if (canvas[i + x][j + y] != 32) {
                                return false;
                            }
                        }
                    }
                }

                for (int i = 0; i < circle.grids.length; i++) {
                    for (int j = 0; j < circle.grids[i].length; j++) {
                        if (circle.grids[i][j] == pattern) {
                            canvas[i + x][j + y] = circle.grids[i][j];
                        }
                    }
                }
                shapes.add(circle);
                return true;

            } else {
                return false;
            }

        } else {
            Direction direction = null;
            switch (params[2]) {
                case 0:
                    direction = Direction.LEFT_UP;
                    break;
                case 1:
                    direction = Direction.LEFT_DOWN;
                    break;
                case 2:
                    direction = Direction.RIGHT_UP;
                    break;
                case 3:
                    direction = Direction.RIGHT_DOWN;
                    break;
            }

            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], direction);

            if (y + rightTriangle.grids[0].length >= 0 && y + rightTriangle.grids[0].length <= canvas[0].length &&
                    x + rightTriangle.grids.length >= 0 && x + rightTriangle.grids.length <= canvas.length) {
                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                        if (rightTriangle.grids[i][j] == pattern) {
                            if (canvas[i + x][j + y] != 32) {
                                return false;
                            }
                        }
                    }
                }

                for (int i = 0; i < rightTriangle.grids.length; i++) {
                    for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                        if (rightTriangle.grids[i][j] == pattern) {
                            canvas[i + x][j + y] = rightTriangle.grids[i][j];
                        }
                    }
                }
                shapes.add(rightTriangle);
                return true;

            } else {
                return false;
            }

        }
    }

    @Override
    public int getSpaceGridCount() {
        int spaceValue = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == 32) {
                    spaceValue++;
                }
            }
        }
        return spaceValue;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, new AreaCompare());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new LocationCompare());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

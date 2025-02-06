import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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

            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids[i].length; j++) {
                    if (y + j >= 0 && y + j < canvas[0].length && x + i >= 0 && x + i < canvas.length && circle.grids[i][j] == pattern) {

                        for (int a = 0; a < circle.grids.length; a++) {
                            for (int b = 0; b < circle.grids[a].length; b++) {
                                if (circle.grids[a][b] != 32) {
                                    if (y + b >= 0 && y + b < canvas[0].length && x + a >= 0 && x + a < canvas.length) {
                                        canvas[a + x][b + y] = circle.grids[a][b];
                                    }
                                }
                            }
                        }

                        shapes.add(circle);
                        return true;
                    }
                }
            }

            return false;

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

            for (int i = 0; i < rightTriangle.grids.length; i++) {
                for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                    if (y + j >= 0 && y + j < canvas[0].length && x + i >= 0 && x + i < canvas.length && rightTriangle.grids[i][j] == pattern) {

                        for (int a = 0; a < rightTriangle.grids.length; a++) {
                            for (int b = 0; b < rightTriangle.grids[a].length; b++) {
                                if (rightTriangle.grids[a][b] != 32) {
                                    if (y + b >= 0 && y + b < canvas[0].length && x + a >= 0 && x + a < canvas.length) {
                                        canvas[a + x][b + y] = rightTriangle.grids[a][b];
                                    }
                                }
                            }
                        }

                        shapes.add(rightTriangle);
                        return true;
                    }
                }
            }
            return false;
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

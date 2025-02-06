import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x,y);
        if (params.length == 1) {
            Shape circle = new Circle(location, pattern, params[0]);
            circle.fillGrids();
            boolean f=false;
            for (int a = 0; a < circle.grids.length; a++) {
                for (int b = 0; b < circle.grids.length; b++) {
                    if (circle.grids[a][b] != ' ') {
                        if ((x+a)<canvas.length && (y+b)<canvas[0].length) {
                            canvas[x + a][y + b] = circle.grids[a][b];
                            f=true;
                        }
                    }
                }
            }if (f == false){
            return  false;
            }
            shapes.add(circle);
            return true;
        } else {
            Shape rightTriangle = new RightTriangle(location, pattern, params[0], params[1], Direction.values()[params[2]]);
            rightTriangle.fillGrids();
            boolean f = false;
            for (int a = 0; a < rightTriangle.grids.length; a++) {
                for (int b = 0; b < rightTriangle.grids[0].length; b++) {
                    if (rightTriangle.grids[a][b] != ' ') {
                        if ((x + a) < canvas.length && (y + b) < canvas[0].length) {
                            canvas[x + a][y + b] = rightTriangle.grids[a][b];
                            f = true;
                        }
                    }
                }
            }
            if (f == false) {
                return false;
            }
            shapes.add(rightTriangle);
            return true;
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char cell : row) {
                if (cell == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes1 = new ArrayList<>(shapes);
        for (int j = 0; j < sortedShapes1.size() - 1; j++) {
            for (int i = 0; i < sortedShapes1.size() - 1; i++) {
                Shape exchange1 = shapes.get(i);
                if (shapes.get(i).area() > shapes.get(i + 1).area()) {
                    shapes.set(i, shapes.get(i + 1));
                    shapes.set(i + 1, exchange1);
                } else if (shapes.get(i).area() == shapes.get(i + 1).area()) {
                    if (shapes.get(i).pattern > shapes.get(i + 1).pattern) {
                        shapes.set(i, shapes.get(i + 1));
                        shapes.set(i + 1, exchange1);
                    }
                }
            }
        }
        return shapes;
    }


    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes2 = new ArrayList<>(shapes);
        for (int j = 0; j < sortedShapes2.size() - 1; j++) {
            for (int i = 0; i < sortedShapes2.size() - 1; i++) {
                Shape exchange2 = shapes.get(i);
                if (shapes.get(i).location.getX() > shapes.get(i + 1).location.getX()) {
                    shapes.set(i, shapes.get(i + 1));
                    shapes.set(i + 1, exchange2);
                } else if (shapes.get(i).location.getX() == shapes.get(i + 1).location.getX()) {
                    if (shapes.get(i).location.getY() > shapes.get(i + 1).location.getY()) {
                        shapes.set(i, shapes.get(i + 1));
                        shapes.set(i + 1, exchange2);
                    } else if (shapes.get(i).location.getY() == shapes.get(i + 1).location.getY()) {
                        if (shapes.get(i).pattern > shapes.get(i + 1).pattern) {
                            shapes.set(i, shapes.get(i + 1));
                            shapes.set(i + 1, exchange2);
                        }
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
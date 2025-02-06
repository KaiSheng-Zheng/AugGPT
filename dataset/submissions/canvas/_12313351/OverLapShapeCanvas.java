import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int width, int height) {
        shapes = new ArrayList<>();
        canvas = new char[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            if (circle.getGrids() == null) {//If the shape is invalid, return false
                return false;
            }
            boolean flag = false;
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if (circle.getGrids()[i][j] != ' ') {
                        if (x + i < canvas.length & y + j < canvas[0].length) {
                            flag = true;
                            canvas[x + i][y + j]= circle.getGrids()[i][j];
                        }
                    }
                }
            }
            if (flag) {
                shapes.add(circle);
                return true;
            } else {
                return false;
            }
        } else if (params.length == 3) {
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
            if (rightTriangle.getGrids() == null) {
                return false;
            }
            boolean flag = false;
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                    if (rightTriangle.getGrids()[i][j] != ' ') {
                        if (x + i < canvas.length && y + j < canvas[0].length) {
                            flag = true;
                            canvas[x + i][y + j] = rightTriangle.getGrids()[i][j];
                        }
                    }
                }
            }
            if (flag) {
                shapes.add(rightTriangle);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
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
        if (shapes.size() == 0) {
            return new ArrayList<>();
        } else {
            if (shapes.size() == 1) {
                return shapes;
            } else {
                shapes.sort((o1, o2) -> {
                    if (o1.area() < o2.area()) {
                        return -1;
                    } else if (o1.area() > o2.area()) {
                        return 1;
                    } else {
                        if (o1.getPattern() > o2.getPattern()) {
                            return 1;
                        } else if (o1.getPattern() < o2.getPattern()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
                return shapes;
            }
        }
    }

    @Override
    public List<Shape> getShapesByLocation() {
        if (shapes.size() == 0) {
            return new ArrayList<>();
        } else {
            if (shapes.size() == 1) {
                return shapes;
            } else {
                shapes.sort((o1, o2) -> {
                    if (o1.location.getX() < o2.location.getX()) {
                        return -1;
                    } else if (o1.location.getX() > o2.location.getX()) {
                        return 1;
                    } else {
                        if (o1.location.getY() < o2.location.getY()) {
                            return -1;
                        } else if (o1.location.getY() > o2.location.getY()) {
                            return 1;
                        } else {
                            if (o1.getPattern() < o2.getPattern()) {
                                return -1;
                            } else if (o1.getPattern() > o2.getPattern()) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    }
                });
                return shapes;
            }
        }
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

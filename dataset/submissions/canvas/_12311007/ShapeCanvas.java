
import java.util.*;

public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int... params);

    public int getSpaceGridCount();

    public int getShapeCount();

    public List<Shape> getShapesByArea();

    public List<Shape> getShapesByLocation();

    public char[][] getCanvas();
}

class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    int spaceGridCount = 0;
    int shapeCount = 0;
    Direction d;
    ArrayList<Shape> shapesByArea = new ArrayList<>();
    ArrayList<Shape> shapesByLocation = new ArrayList<>();

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Shape circle = new Circle(new Location(x, y), pattern, params[0]);
            circle.fillGrids();
            circle.area();
            circle.getGrids();
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if (i + x >= canvas.length || j + y >= canvas[0].length) {
                        return false;
                    }
                    if (circle.getGrids()[i][j] != ' ' && canvas[i + x][j + y] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if (circle.getGrids()[i][j] != ' ') {
                        canvas[i + x][j + y] = circle.getGrids()[i][j];
                    }
                }
            }
            spaceGridCount += circle.area();
            shapeCount++;
            shapesByArea.add(circle);
            shapesByLocation.add(circle);
            return true;
        } else {
            if (params[2] == 0) {
                d = Direction.LEFT_UP;
            } else if (params[2] == 1) {
                d = Direction.LEFT_DOWN;
            } else if (params[2] == 2) {
                d = Direction.RIGHT_UP;
            } else if (params[2] == 3) {
                d = Direction.RIGHT_DOWN;
            }
            Shape rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
            rightTriangle.fillGrids();
            rightTriangle.area();
            rightTriangle.getGrids();
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                    if (i + x >= canvas.length || j + y >= canvas[0].length) {
                        return false;
                    }
                    if (rightTriangle.getGrids()[i][j] != ' ' && canvas[i + x][j + y] != ' ') {
                        return false;
                    }
                }
            }
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                    if (rightTriangle.getGrids()[i][j] != ' ') {
                        canvas[i + x][j + y] = rightTriangle.getGrids()[i][j];
                    }
                }
            }
            spaceGridCount += rightTriangle.area();
            shapeCount++;
            shapesByArea.add(rightTriangle);
            shapesByLocation.add(rightTriangle);
            return true;
        }
    }

    @Override
    public int getSpaceGridCount() {
        return spaceGridCount;
    }

    @Override
    public int getShapeCount() {
        return shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int j = 0; j < shapesByArea.size(); j++) {
            for (int i = 0; i < shapesByArea.size()-1; i++) {
                Shape s1 = shapesByArea.get(i);
                Shape s2 = shapesByArea.get(i + 1);
                if (s1.area() > s2.area()) {
                    shapesByArea.set(i, s2);
                    shapesByArea.set(i + 1, s1);
                } else if (s1 == s2) {
                    if (s1.pattern > s2.pattern) {
                        shapesByArea.set(i, s2);
                        shapesByArea.set(i + 1, s1);
                    }
                }

            }
        }
        return shapesByArea;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int j = 0; j < shapesByLocation.size(); j++) {
            for (int i = 0; i < shapesByLocation.size() - 1; i++) {
                Shape s1 = shapesByLocation.get(i);
                Shape s2 = shapesByLocation.get(i + 1);
                if (s1.location.getX() > s2.location.getX()) {
                    shapesByLocation.set(i, s2);
                    shapesByLocation.set(i + 1, s1);
                } else if (s1.location.getX() == s2.location.getX()) {
                    if (s1.location.getY() > s2.location.getY()) {
                        shapesByLocation.set(i, s2);
                        shapesByLocation.set(i + 1, s1);
                    } else if (s1.location.getY() == s2.location.getY()) {
                        if (s1.pattern > s2.pattern) {
                            shapesByLocation.set(i, s2);
                            shapesByLocation.set(i + 1, s1);
                        }
                    }
                }
            }
        }
        return shapesByLocation;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    int spaceGridCount = 0;
    int shapeCount = 0;
    Direction d;
    ArrayList<Shape> shapesByArea = new ArrayList<>();
    ArrayList<Shape> shapesByLocation = new ArrayList<>();

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Shape circle = new Circle(new Location(x, y), pattern, params[0]);
            circle.fillGrids();
            circle.area();
            circle.getGrids();
            int n = 0;
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if (i + x >= canvas.length || j + y >= canvas[0].length) {
                        continue;
                    }
                    if (circle.getGrids()[i][j] != ' ') {
                        canvas[i + x][j + y] = circle.getGrids()[i][j];
                        n++;
                    }
                }
            }
            if (n != 0) {
                shapeCount++;
                shapesByArea.add(circle);
                shapesByLocation.add(circle);
                return true;
            } else {
                return false;
            }
        } else {
            if (params[2] == 0) {
                d = Direction.LEFT_UP;
            } else if (params[2] == 1) {
                d = Direction.LEFT_DOWN;
            } else if (params[2] == 2) {
                d = Direction.RIGHT_UP;
            } else if (params[2] == 3) {
                d = Direction.RIGHT_DOWN;
            }
            Shape rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
            rightTriangle.fillGrids();
            rightTriangle.area();
            rightTriangle.getGrids();
            int n = 0;
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                    if (i + x >= canvas.length || j + y >= canvas[0].length) {
                        continue;
                    }
                    if (rightTriangle.getGrids()[i][j] != ' ') {
                        canvas[i + x][j + y] = pattern;
                        n++;
                    }
                }
            }
            if (n != 0) {
                shapeCount++;
                shapesByArea.add(rightTriangle);
                shapesByLocation.add(rightTriangle);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        //incomplete implementation
        return spaceGridCount;
    }

    @Override
    public int getShapeCount() {
        return shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int j = 0; j < shapesByArea.size(); j++) {
            for (int i = 0; i < shapesByArea.size() - 1; i++) {
                Shape s1 = shapesByArea.get(i);
                Shape s2 = shapesByArea.get(i + 1);
                if (s1.area() > s2.area()) {
                    shapesByArea.set(i, s2);
                    shapesByArea.set(i + 1, s1);
                } else if (s1.area() == s2.area()) {
                    if (s1.pattern > s2.pattern) {
                        shapesByArea.set(i, s2);
                        shapesByArea.set(i + 1, s1);
                    }
                }
            }
        }
        return shapesByArea;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int j = 0; j < shapesByLocation.size(); j++) {
            for (int i = 0; i < shapesByLocation.size() - 1; i++) {
                Shape s1 = shapesByLocation.get(i);
                Shape s2 = shapesByLocation.get(i + 1);
                if (s1.location.getX() > s2.location.getX()) {
                    shapesByLocation.set(i, s2);
                    shapesByLocation.set(i + 1, s1);
                } else if (s1.location.getX() == s2.location.getX()) {
                    if (s1.location.getY() > s2.location.getY()) {
                        shapesByLocation.set(i, s2);
                        shapesByLocation.set(i + 1, s1);
                    } else if (s1.location.getY() == s2.location.getY()) {
                        if (s1.pattern > s2.pattern) {
                            shapesByLocation.set(i, s2);
                            shapesByLocation.set(i + 1, s1);
                        }
                    }
                }
            }
        }
        return shapesByLocation;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}

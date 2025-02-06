import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int count = 0;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean isAdd = false;
        if (x >= 0 && y >= 0 && x < canvas.length && y < canvas[0].length)
        {
            isAdd=true;
            if (params.length == 1) {
                Circle circle = new Circle(new Location(x, y), pattern, params[0]);
                int count = 0;
                int RowT = circle.location.getX();
                int ColT = circle.location.getY();
                for (int i = 0; i < circle.getGrids().length; i++) {
                    for (int j = 0; j < circle.getGrids()[0].length; j++) {
                        try {
                            if (circle.getGrids()[i][j] == pattern) {
                                canvas[i + RowT][j + ColT] = circle.getGrids()[i][j];
                                count++;
                            }
                        } catch (ArrayIndexOutOfBoundsException ignore) {
                        }
                    }
                }
                if (count == 0) {
                    isAdd = false;
                } else {
                    shapes.add(circle);
                }
            } else {
                RightTriangle triangle=null;
                switch (params[2]) {
                    case 0: {
                        triangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.LEFT_UP);
                    }
                    break;
                    case 1: {
                        triangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.LEFT_DOWN);
                    }
                    break;
                    case 2: {
                        triangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.RIGHT_UP);
                    }
                    break;
                    case 3: {
                        triangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.RIGHT_DOWN);
                    }
                    break;
                }
                assert triangle!=null;
                isAdd = fillCavans(triangle);
            }
            if (isAdd) {
                count++;
            }
        }
        return isAdd;
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
        return count;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - i - 1; j++) {
                if (shapes.get(j + 1).area() < shapes.get(j).area()) {
                    Shape temp = shapes.get(j + 1);
                    shapes.set(j + 1, shapes.get(j));
                    shapes.set(j, temp);
                } else if (shapes.get(j + 1).area() == shapes.get(j).area() && shapes.get(j + 1).pattern < shapes.get(j).pattern) {
                    Shape temp = shapes.get(j + 1);
                    shapes.set(j + 1, shapes.get(j));
                    shapes.set(j, temp);
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size() - i - 1; j++) {
                if (shapes.get(j + 1).location.getX() < shapes.get(j).location.getX()) {
                    Shape temp = shapes.get(j + 1);
                    shapes.set(j + 1, shapes.get(j));
                    shapes.set(j, temp);
                } else if (shapes.get(j + 1).location.getX() == shapes.get(j).location.getX() && shapes.get(j + 1).location.getY() < shapes.get(j).location.getY()) {
                    Shape temp = shapes.get(j + 1);
                    shapes.set(j + 1, shapes.get(j));
                    shapes.set(j, temp);
                } else if (shapes.get(j + 1).location.getX() == shapes.get(j).location.getX() && shapes.get(j + 1).location.getY() == shapes.get(j).location.getY() && shapes.get(j + 1).pattern < shapes.get(j).pattern) {
                    Shape temp = shapes.get(j + 1);
                    shapes.set(j + 1, shapes.get(j));
                    shapes.set(j, temp);
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
    public boolean fillCavans(RightTriangle triangle) {
        boolean isAdd = true;
        int count = 0;
        int rowT = triangle.location.getX();
        int colT = triangle.location.getY();
        for (int i = 0; i < triangle.getGrids().length; i++) {
            for (int j = 0; j < triangle.getGrids()[0].length; j++) {
                try {
                    if (triangle.getGrids()[i][j] == triangle.pattern) {
                        canvas[i + rowT][j + colT] = triangle.getGrids()[i][j];
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException ignore) {
                }
            }
        }
        if (count == 0) {
            isAdd = false;
        } else {
            shapes.add(triangle);
        }
        return isAdd;
    }
}

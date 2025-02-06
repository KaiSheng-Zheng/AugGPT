import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    private int count = 0;

    public AvoidConflictShapeCanvas(int rows, int cols) {
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
        if (x < canvas.length && y < canvas[0].length && x >= 0 && y >= 0) {
            if (params.length == 1) {
                Circle circle = new Circle(new Location(x, y), pattern, params[0]);
                isAdd = fillCanvas(circle);
            } else {
                RightTriangle rightTriangle=null;
                if (params[2] == 0) {
                    rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.LEFT_UP);
                } else if (params[2] == 1) {
                    rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.LEFT_DOWN);
                } else if (params[2] == 2) {
                    rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.RIGHT_UP);
                } else if (params[2] == 3) {
                    rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.RIGHT_DOWN);
                }
                assert rightTriangle != null;
                isAdd = fillcanvas(rightTriangle);
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

    public boolean fillCanvas(Circle circle) {
        boolean isAdd = true;
        int rowT = circle.location.getX();
        int colT = circle.location.getY();
        int count = 0;
        fillloop:
        for (int i = 0; i < circle.getGrids().length; i++) {
            for (int j = 0; j < circle.getGrids()[0].length; j++) {
                try {
                    if (canvas[i + rowT][j + colT] == ' ' && circle.getGrids()[i][j] == circle.pattern) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException a) {
                    isAdd = false;
                    break fillloop;
                }
            }
        }
        if (count==circle.area())
        {
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[0].length; j++) {
                    if (circle.getGrids()[i][j]==circle.pattern)
                    {
                        canvas[i + rowT][j + colT] = circle.pattern;
                    }
                }
            }
        }
        else
        {
            isAdd=false;
        }
        if (isAdd) {
            shapes.add(circle);
        }
        return isAdd;
    }

    public boolean fillcanvas(RightTriangle triangle) {
        boolean isAdd = true;
        int rowT = triangle.location.getX();
        int colT = triangle.location.getY();
        int count=0;
        fillloop:
        for (int i = 0; i < triangle.getGrids().length; i++) {
            for (int j = 0; j < triangle.getGrids()[0].length; j++) {
                try {
                    if (canvas[i + rowT][j + colT] == ' ' && triangle.getGrids()[i][j] == triangle.pattern) {
                        count++;
                    }
                } catch (ArrayIndexOutOfBoundsException a) {
                    isAdd = false;
                    break fillloop;
                }
            }
        }
        if (count==triangle.area())
        {
            for (int i = 0; i < triangle.getGrids().length; i++) {
                for (int j = 0; j < triangle.getGrids()[0].length; j++) {
                    if (triangle.getGrids()[i][j]==triangle.pattern)
                    {
                        canvas[i + rowT][j + colT] = triangle.pattern;
                    }
                }
            }
        }
        else
        {
            isAdd=false;
        }
        if (isAdd) {
            shapes.add(triangle);
        }
        return isAdd;
    }
}
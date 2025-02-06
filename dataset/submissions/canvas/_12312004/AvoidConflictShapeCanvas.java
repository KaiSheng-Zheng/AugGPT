import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int shapenumber;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes=new ArrayList<>();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void setCanvas(char[][] canvas) {
        this.canvas = canvas;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Location location = new Location(x, y);
            Shape circle = new Circle(location, pattern, params[0]);
                circle.fillGrids();
                for (int i = 0; i < circle.getGrids().length; i++) {
                    for (int j = 0; j < circle.getGrids()[i].length; j++) {
                        if (x+i>=canvas.length|y+j>=canvas[0].length) return false;
                        if (canvas[x + i][y + j] != ' ' && circle.getGrids()[i][j] == pattern) return false;
                    }
                }
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[i].length; j++) {
                    if (x + i < canvas.length && y + j < canvas[0].length) {
                        if (canvas[x + i][y + j] == ' ' && circle.getGrids()[i][j] == pattern) {
                            canvas[x + i][y + j] = circle.getGrids()[i][j];
                        }
                    }
                }
            }
            shapes.add(circle);
        }
        if (params.length > 1) {
            Location location = new Location(x, y);
            Direction[] d = new Direction[1];
            switch (params[2]) {
                case 0:
                    d[0] = Direction.LEFT_UP;
                    break;
                case 1:
                    d[0] = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d[0] = Direction.RIGHT_UP;
                    break;
                case 3:
                    d[0] = Direction.RIGHT_DOWN;
                    break;
            }
            Shape rightTriangle = new RightTriangle(location, pattern, params[0], params[1], d[0]);
            rightTriangle.fillGrids();
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[i].length; j++) {
                    if (x + i >= canvas.length | y + j >= canvas[0].length) return false;
                    if (canvas[x + i][y + j] != ' ' && rightTriangle.getGrids()[i][j] == pattern) return false;
                }
            }
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[i].length; j++) {
                    if (x + i < canvas.length && y + j < canvas[0].length)
                        if (canvas[x + i][y + j] == ' ' && rightTriangle.getGrids()[i][j] == pattern)
                            canvas[x + i][y + j] = pattern;
                }
            }
            shapes.add(rightTriangle);
        }
        shapenumber++;
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int a=0;
        for (int i=0;i<canvas.length;i++){
            for (int j=0;j<canvas[0].length;j++){
                if (canvas[i][j]!=' '){
                    a++;
                }
            }
        }
        return canvas.length*canvas[0].length-a;
    }
    @Override
    public int getShapeCount() {
        return shapenumber;
    }

    @Override
    public List<Shape> getShapesByArea() {
        Comparator orderByArea = new OrderByArea();
        shapes.sort(orderByArea);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator orderByLocation = new OrderByLocation();
        shapes.sort(orderByLocation);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

    class OrderByArea implements Comparator<Shape> {
        @Override
        public int compare(Shape o1, Shape o2) {
            if (o1.area() > o2.area()) return 1;
            if (o1.area() < o2.area()) return -1;
            if (o1.area() == o2.area()) {
                if (o1.getPattern() > o2.getPattern()) return 1;
                else return -1;
            }
            return 0;
        }
    }
class OrderByLocation implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        if (o1.getLocation().getX() > o2.getLocation().getX()) return 1;
        if (o1.getLocation().getX() < o2.getLocation().getX()) return -1;
        if (o1.getLocation().getX() == o2.getLocation().getX()) {
            if (o1.getLocation().getY() > o2.getLocation().getY()) return 1;
            if (o1.getLocation().getY() < o2.getLocation().getY()) return -1;
            if (o1.getLocation().getY() == o2.getLocation().getY()) {
                if (o1.getPattern() > o2.getPattern()) return 1;
                else return -1;
            }
        }
        return 0;
    }
}
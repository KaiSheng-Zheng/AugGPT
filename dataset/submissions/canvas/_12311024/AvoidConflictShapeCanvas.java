import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
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
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            if (AvoidConflict(circle)) {
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
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
            if (AvoidConflict(rightTriangle)) {
                shapes.add(rightTriangle);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean AvoidConflict(Shape shape) {
        int x0 = shape.location.getX();
        int y0 = shape.location.getY();
        boolean condition = true;
        char[][] ch = shape.getGrids();
            for (int i = 0; i < shape.getGrids().length; i++) {
                for (int j = 0; j < shape.getGrids()[0].length; j++) {
                    if (ch[i][j] != ' ') {
                        if (!ispointinside(x0+i,y0+j)||canvas[x0 + i][y0 + j] != ' ') {
                            condition = false;
                            break;
                        }
                    }
                }
            }
        if (condition) {
            for (int i = 0; i < shape.getGrids().length; i++) {
                for (int j = 0; j < shape.getGrids()[0].length; j++) {
                    if(ch[i][j] != ' '){
                    canvas[x0 + i][y0 + j] = ch[i][j];}
                }
            }
        }
        return condition;
    }

    public boolean ispointinside(int x, int y) {
        if (x >= 0 && x <= canvas.length-1 && y >= 0 && y <= canvas[0].length-1) {
            return true;
        }
        return false;
    }


    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i <canvas.length; i++) {
            for(int j =0;j<canvas[0].length;j++){
                if(canvas[i][j]==' '){
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
        ComparableShape COMparator = new ComparableShape();
        shapes.sort(COMparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        ComparableLocation location = new ComparableLocation();
        shapes.sort(location);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


}
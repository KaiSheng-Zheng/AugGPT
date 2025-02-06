import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int sc = 0;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = '\u0020';
            }
        }
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean isvaild = true;
        Location location = new Location(x,y);
        if(params.length == 1){
            Shape s = new Circle(location, pattern,params[0]);
            s.fillGrids();
            for (int i = x; i < x + 2 * params[0]; i++) {
                for (int j = y; j < y + 2 * params[0]; j++) {
                    if(s.getGrids()[i - x][j - y] != '\u0020'){
                        if (0 <= i && i < canvas.length && 0 <= j && j < canvas[0].length) {
                            if (canvas[i][j] == '\u0020'){
                                isvaild = isvaild && true;
                            }
                            else {
                                isvaild = isvaild && false;
                            }
                        }
                        else {
                            isvaild = isvaild && false;
                        }
                    }
                }
            }
            if (isvaild == true){
                for (int i = 0; i < 2 * params[0]; i++) {
                    for (int j = 0; j < 2 * params[0]; j++) {
                        if(s.getGrids()[i][j] != '\u0020'){
                            canvas[i + x][j + y] = s.getGrids()[i][j];
                        }
                    }
                }
                shapes.add(s);
                sc += 1;
            }
        }
        else if(params.length == 3){
            Direction d = null;
            switch (params[2]){
                case 0:
                    d = Direction.LEFT_UP;
                    break;
                case 1:
                    d = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d = Direction.RIGHT_UP;
                    break;
                case 3:
                    d = Direction.RIGHT_DOWN;
            }
            Shape s = new RightTriangle(location, pattern,params[0], params[1], d);
            s.fillGrids();
            for (int i = x; i < x + params[1]; i++) {
                for (int j = y; j < y + params[0]; j++) {
                    if(s.getGrids()[i - x][j - y] != '\u0020'){
                        if (0 <= i && i < canvas.length && 0 <= j && j < canvas[0].length) {
                            if (canvas[i][j] == '\u0020'){
                                isvaild = isvaild && true;
                            }
                            else {
                                isvaild = isvaild && false;
                            }
                        }
                        else {
                            isvaild = isvaild && false;
                        }
                    }
                }
            }
            if (isvaild == true){
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if(s.getGrids()[i][j] != '\u0020'){
                            canvas[i + x][j + y] = s.getGrids()[i][j];
                        }
                    }
                }
                shapes.add(s);
                sc += 1;
            }
        }
        return isvaild;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == '\u0020'){
                    count += 1;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return sc;
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> c = new ShapeLocationComparator();
        Collections.sort(shapes, c);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
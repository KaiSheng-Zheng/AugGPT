import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<Shape>();
        canvas = new char[rows][cols];
        this.rows = rows;
        this.cols = cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        //return false;
        Shape s = null;
        Location l = new Location(x, y);
        if (params.length == 1) {
            s = new Circle(l, pattern, params[0]);
        } else if (params.length == 3) {
            Direction d = Direction.LEFT_UP;
            switch (params[2]) {
                case 0 -> d = Direction.LEFT_UP;
                case 1 -> d = Direction.LEFT_DOWN;
                case 2 -> d = Direction.RIGHT_UP;
                case 3 -> d = Direction.RIGHT_DOWN;
            }
            s = new RightTriangle(l, pattern, params[0], params[1], d);
        }
        if(isInCanvas(s) && isNotConflict(s)){
            int startX = s.location.getX();
            int startY = s.location.getY();
            for (int i = 0; i < s.grids.length; i++) {
                for (int j = 0; j < s.grids[0].length; j++) {
                    if(startX+i < rows && startY+j < cols && s.grids[i][j] != ' '){
                        canvas[startX + i][startY + j] = s.grids[i][j];
                    }
                }
            }
            shapes.add(s);
            return true;
        }
        return false;
    }

    public boolean isInCanvas(Shape s) {
        if (s instanceof Circle) {
            if ((s.location.getX() + ((Circle) s).getRadius() > rows) || (s.location.getY() + ((Circle) s).getRadius() > cols)) {
                return false;
            }
        } else if (s instanceof RightTriangle) {
            if ((s.location.getX() + ((RightTriangle) s).getHeight() > rows) || (s.location.getY() + ((RightTriangle) s).getWidth() > cols)) {
                return false;
            }
        }

        return true;
    }

    public boolean isNotConflict(Shape s) {
        int startX = s.location.getX();
        int startY = s.location.getY();
        for (int i = 0; i < s.grids.length; i++) {
            for (int j = 0; j < s.grids[0].length; j++) {
                if (startX+i < rows && startY+j < cols && s.grids[i][j] != ' ' && canvas[startX + i][startY + j] != ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j] == ' ') {
                    num++;
                }
            }
        }
        return num;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> shapesNew = new ArrayList<Shape>();
        for (int i = 0; i < shapes.size(); i++) {
            shapesNew.add(shapes.get(i));
            shapesNew.get(i).sortOption = 1;
        }
        Collections.sort(shapesNew);

        return shapesNew;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> shapesNew = new ArrayList<Shape>();
        for (int i = 0; i < shapes.size(); i++) {
            shapesNew.add(shapes.get(i));
            shapesNew.get(i).sortOption = 2;
        }
        Collections.sort(shapesNew);

        return shapesNew;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;

    public OverLapShapeCanvas(int rows, int cols){
        shapes = new ArrayList<Shape>();
        this.rows = rows;
        this.cols = cols;
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
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
        if(isInCanvas(s)){
            int startX = s.location.getX();
            int startY = s.location.getY();
            for (int i = 0; i < s.grids.length; i++) {
                for (int j = 0; j < s.grids[0].length; j++) {
                    if(startX+i < rows && startY+j < cols  && s.grids[i][j] != ' '){
                        canvas[startX + i][startY + j] = s.pattern;
                    }

                }
            }
            shapes.add(s);
            return true;
        }
        return false;
    }

    public boolean isInCanvas(Shape s){
        int startX = s.location.getX();
        int startY = s.location.getY();
        for (int i = 0; i < s.grids.length; i++) {
            for (int j = 0; j < s.grids[0].length; j++) {
                if(s.grids[i][j] != ' ' && startX+i < rows && startY+j < cols){
                    return true;
                }
            }
        }

        return false;
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

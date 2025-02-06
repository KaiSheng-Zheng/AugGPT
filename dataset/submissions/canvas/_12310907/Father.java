import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Father implements ShapeCanvas {
    protected List<Shape> shapes;
    protected char[][] canvas;

    public Father(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes = new ArrayList<Shape>();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int c = 0;
        for (int i = 0; i < canvas[0].length; i++) {
            for (int j = 0; j < canvas.length; j++) {
                if (canvas[i][j] == ' ') {
                    c++;
                }
            }
        }
        return c;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Comparator<Shape> AreaComparator = new ShapeAreaComparator();
        Collections.sort(shapes, AreaComparator);
        return shapes;
    }


    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> LocationComparator = new ShapeLocationComparator();
        Collections.sort(shapes,LocationComparator);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


}


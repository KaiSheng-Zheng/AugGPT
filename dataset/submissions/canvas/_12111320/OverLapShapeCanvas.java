import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        // prepare a new empty base
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public int getSpaceGridCount() {
        int result = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    result++;
                }
            }
        }
        return result;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);

        Comparator<Shape> areaPatternComparator = new Comparator<>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int compareArea = Integer.compare(s1.area(), s2.area());
                if (compareArea != 0) {
                    return compareArea;
                }

                return Character.compare(s1.getPattern(), s2.getPattern());
            }
        };

        Collections.sort(sortedShapes, areaPatternComparator);

        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);

        Comparator<Shape> locationComparator = (s1, s2) -> {
            int compareX = Integer.compare(s1.getLocation().getX(), s2.getLocation().getX());
            if (compareX != 0) {
                return compareX;
            }

            int compareY = Integer.compare(s1.getLocation().getY(), s2.getLocation().getY());
            if (compareY != 0) {
                return compareY;
            }

            return Character.compare(s1.getPattern(), s2.getPattern());
        };

        sortedShapes.sort(locationComparator);

        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        char[][] canvasCopy = new char[canvas.length][canvas[0].length];

        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvasCopy[i][j] = canvas[i][j];
            }
        }

        return canvasCopy;
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

        if (x < 0 || y < 0 || x >= canvas.length || y >= canvas[0].length) {
            return false;
        }

        Shape newShapeIntermideum = null;
        if (params.length == 1) {
            int radius = params[0];
            newShapeIntermideum = new Circle(new Location(x, y), pattern, radius);
        } else if (params.length == 3) {
            int width = params[0];
            int height = params[1];
            Direction direction = Direction.values()[params[2]];
            newShapeIntermideum = new RightTriangle(new Location(x, y), pattern, width, height, direction);
        }

        char[][] shapeGrids = new char[0][];
        if (newShapeIntermideum != null) {
            shapeGrids = newShapeIntermideum.getGrids();
        }

        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
//                if (x + i >= canvas.length || y + j >= canvas[0].length && canvas[i][j] != ' ') {
                if (x + i >= canvas.length && y + j >= canvas[0].length && shapeGrids[i][j] != ' ' && x+i >= 0 && y+j >= 0) {
                    return false;
                }
            }
        }

        shapes.add(newShapeIntermideum);
        for (int i = 0; i < shapeGrids.length; i++) {
            for (int j = 0; j < shapeGrids[i].length; j++) {
                if (x + i < canvas.length && y + j < canvas[0].length && shapeGrids[i][j] != ' ' && x+i >= 0 && y+j >= 0) {
                    canvas[x + i][y + j] = shapeGrids[i][j];
                }
            }
        }

        return true;
    }


}

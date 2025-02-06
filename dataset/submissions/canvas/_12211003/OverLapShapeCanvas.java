import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        Location location = new Location(x, y);
        if (params.length == 1) {
            shape = new Circle(location, pattern, params[0]);
        } else if (params.length == 3) {
            shape = new RightTriangle(location, pattern, params[0], params[1], Direction.values()[params[2]]);
        } else {
            throw new IllegalArgumentException("Invalid number of parameters");
        }
        boolean s=false;
        for (int i = 0; i < shape.getGrids().length; i++) {
            for (int j = 0; j < shape.getGrids()[0].length; j++) {
                if (shape.getGrids()[i][j] != ' ') {
                    int cx=x+i;
                    int cy=y+j;
                  if(cx < 0 || cx >= canvas.length || cy < 0 || cy >= canvas[0].length){

                  }else {
                      s=true;
                  }
                }
            }
        }
        if (!s){
            return s;
        }

        for (int i = 0; i < shape.getGrids().length; i++) {
            for (int j = 0; j < shape.getGrids()[0].length; j++) {
                int cx=x+i;
                int cy=y+j;
                if (shape.getGrids()[i][j] != ' ' ) {
                    if(cx < 0 || cx >= canvas.length || cy < 0 || cy >= canvas[0].length){

                    }
                    else {
                        canvas[x + i][y + j] = pattern;
                    }
                }
            }
        }

        shapes.add(shape);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char c : row) {
                if (c == ' ') count++;
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
        shapes.sort(Comparator.comparingInt(Shape::area).thenComparing(Shape::toString));
        return new ArrayList<>(shapes);
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(Comparator.comparingInt((Shape s) -> s.location.getX())
                .thenComparingInt(s -> s.location.getY())
                .thenComparing(Shape::toString));
        return new ArrayList<>(shapes);
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

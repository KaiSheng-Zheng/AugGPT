import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int columns;

    public OverLapShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.columns = cols;
        shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        boolean isInbound = false;

        //Circle
        if (params.length == 1) {
            Shape circle = new Circle(location, pattern, params[0]);
            char[][] circleGrids = circle.getGrids();


            first:
            for (int i = 0; i < circleGrids.length; i++) {
                second:
                for (int j = 0; j < circleGrids[i].length; j++) {
                    if (circleGrids[i][j] == pattern) {
                        //checkPatternMustBeInBound
                        if (i+x >= 0 && j+y >= 0) {
                            if (i+x < rows && j+y < columns) {
                                isInbound = true;
                                break first;
                            }
                        }


                    }
                }
            }
            if (isInbound) {
                for (int i = 0; i < circleGrids.length; i++) {
                    for (int j = 0; j < circleGrids[i].length; j++) {
                        if (circleGrids[i][j] == pattern) {
                            if(i+x < rows && j+y < columns){
                                canvas[i+x][j+y] = pattern;

                            }
                        }
                    }
                }
                shapes.add(circle);
            }
        }

        //Triangle
        if (params.length == 3) {
            Direction d = null;

            d = switch (params[2]) {
                case 0 -> Direction.LEFT_UP;
                case 1 -> Direction.LEFT_DOWN;
                case 2 -> Direction.RIGHT_UP;
                case 3 -> Direction.RIGHT_DOWN;
                default -> d;
            };

            Shape rightTriangle = new RightTriangle(location, pattern, params[0], params[1], d);
            char[][] triangleGrids = rightTriangle.getGrids();

            first:
            for (int i = 0; i < triangleGrids.length; i++) {
                second:
                for (int j = 0; j < triangleGrids[i].length; j++) {
                    if (triangleGrids[i][j] == pattern) {
                        //checkPatternMustBeInBound
                        if (i+x >= 0 && j+y >= 0) {
                            if (i+x < rows && j+y < columns) {
                                isInbound = true;
                                break first;
                            }
                        }

                    }
                }
            }
            if (isInbound) {
                for (int i = 0; i < triangleGrids.length; i++) {
                    for (int j = 0; j < triangleGrids[i].length; j++) {
                        if (triangleGrids[i][j] == pattern) {
                            if(i+x < rows && j+y < columns){
                                canvas[i+x][j+y] = pattern;

                            }
                        }
                    }
                }
                shapes.add(rightTriangle);
            }

        }

        return isInbound;
    }


    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++) {
                if(canvas[i][j] == ' '){
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
        Collections.sort(shapes);
        Collections.sort(shapes, new AreaComparator());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes);
        Collections.sort(shapes, new LocationY());
        Collections.sort(shapes, new LocationX());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

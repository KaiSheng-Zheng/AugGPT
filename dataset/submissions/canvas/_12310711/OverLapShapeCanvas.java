import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;


    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }



    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (x < 0 || y < 0 || x >= canvas.length || y >= canvas[0].length) {
            return false;
        }

        if (params.length == 1) {
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            int LRow = circle.location.getX();
            int LCol = circle.location.getY();
            int chechin = 0;
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[i].length; j++) {
                    if (LRow + i < canvas.length && LCol + j < canvas[0].length) {
                        if (circle.getGrids()[i][j] == pattern) {
                            canvas[LRow + i][LCol + j] = circle.getGrids()[i][j];
                            chechin++;
                        }
                    }
                }
            }
            if (chechin <= 0) {
                return false;
            }
        } else if (params.length == 3) {
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], A.int2dir(params[2]));
            int LRow = rightTriangle.location.getX();
            int LCol = rightTriangle.location.getY();
            int chechin = 0;
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[i].length; j++) {
                    if (LRow + i < canvas.length && LCol + j < canvas[0].length) {
                        if (rightTriangle.getGrids()[i][j] == pattern) {
                            canvas[LRow + i][LCol + j] = rightTriangle.getGrids()[i][j];
                            chechin++;
                        }
                    }
                }
            }
            if (chechin <= 0) {
                return false;
            }
        }

        if(params.length ==1) {
            shapes.add(new Circle(new Location(x, y), pattern, params[0]));
        } else if(params.length ==3) {
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], A.int2dir(params[2]));
            if (params[2] == 0) {
                rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.LEFT_UP);
            } else if (params[2] == 1) {
                rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.LEFT_DOWN);
            } else if (params[2] == 2) {
                rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.RIGHT_UP);
            } else if (params[2] == 3) {
                rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.RIGHT_DOWN);
            }
            shapes.add(rightTriangle);
        }
        return true;

    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (char[] row : canvas) {
            for (char c : row) {
                if (c == ' ') {
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
        List<Shape> ascendingShapes = new ArrayList<>(shapes);
        ascendingShapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area() != s2.area()) {
                    return Double.compare(s1.area(), s2.area());
                } else {
                    return Character.compare(s1.getPattern(), s2.getPattern());
                }
            }
        });
        return ascendingShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.getLocation().getX() != s2.getLocation().getX()) {
                    return Integer.compare(s1.getLocation().getX(), s2.getLocation().getX());
                } else if (s1.getLocation().getY() != s2.getLocation().getY()) {
                    return Integer.compare(s1.getLocation().getY(), s2.getLocation().getY());
                } else {
                    return Character.compare(s1.getPattern(), s2.getPattern());
                }
            }
        });
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


   }
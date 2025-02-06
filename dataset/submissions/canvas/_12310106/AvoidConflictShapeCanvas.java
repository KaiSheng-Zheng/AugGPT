import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    
    private List<Shape> shapes;
    
    private char[][] canvas;
    
    
    private int shapeCount = 0;
    private int spaceGridCount;

    
    public AvoidConflictShapeCanvas(int rows, int cols) {
        
        
        
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        spaceGridCount = rows * cols;
    }

    /**
     * @param x       location x(left)
     * @param y       location y(up)
     * @param pattern the pattern of shape
     * @param params  radius(circle); width, height, index of Direction(rightTriangle)
     * @return if it has no conflict when adding a shape, the method returns true, otherwise it returns false
     */
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        
        ShapeType shapeTypeAdded;
        Location location = new Location(x, y);
        int radius = -1;
        int width = -1;
        int height = -1;
        int idxOfDirection;
        Direction directionAdded = null;
        if (params.length == 1) {
            shapeTypeAdded = ShapeType.CIRCLE;
            radius = params[0];
        } else {
            shapeTypeAdded = ShapeType.RIGHTTRIANGLE;
            width = params[0];
            height = params[1];
            idxOfDirection = params[2];
            if (idxOfDirection == 0) {
                directionAdded = Direction.LEFT_UP;
            } else if (idxOfDirection == 1) {
                directionAdded = Direction.LEFT_DOWN;
            } else if (idxOfDirection == 2) {
                directionAdded = Direction.RIGHT_UP;
            } else if (idxOfDirection == 3) {
                directionAdded = Direction.RIGHT_DOWN;
            }
        }

        
        boolean isValid = true;

        
        if (x < 0 || y < 0) {
            isValid = false;
        } else {
            if (shapeTypeAdded == ShapeType.CIRCLE) {
                if (x + 2 * radius > canvas.length || y + 2 * radius > canvas[0].length) {
                    isValid = false;
                }
            } else {
                if (y + width > canvas[0].length || x + height > canvas.length) {
                    isValid = false;
                }
            }
        }
        if (!isValid) {
            return false;
        }

        
        char[][] canvasTemp = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < canvasTemp.length; i++) {
            System.arraycopy(canvas[i], 0, canvasTemp[i], 0, canvasTemp[0].length);
        }


        if (shapeTypeAdded == ShapeType.CIRCLE) {
            Shape circleAdded = new Circle(new Location(x, y), pattern, radius);
            circleAdded.fillGrids();
            char[][] grids = circleAdded.getGrids();
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[0].length; j++) {
                    int iCanvas = i + x;
                    int jCanvas = j + y;
                    if (grids[i][j] != ' ') {
                        if (iCanvas >= 0 && iCanvas < canvas.length && jCanvas >= 0 && jCanvas < canvas[0].length) {
                            if (canvasTemp[iCanvas][jCanvas] != ' ') {
                                isValid = false;
                                break;
                            } else {

                                canvasTemp[iCanvas][jCanvas] = pattern;
                            }
                        }
                    }
                }
                if (!isValid) {
                    break;
                }
            }
        } else {
            
            Shape triangleAdded = new RightTriangle(new Location(x, y), pattern, width, height, directionAdded);
            triangleAdded.fillGrids();
            char[][] grids = triangleAdded.getGrids();
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[0].length; j++) {
                    int iCanvas = i + x;
                    int jCanvas = j + y;
                    if (grids[i][j] != ' ') {
                        if (iCanvas >= 0 && iCanvas < canvas.length && jCanvas >= 0 && jCanvas < canvas[0].length) {
                            if (canvasTemp[iCanvas][jCanvas] != ' ') {
                                isValid = false;
                                break;
                            } else {
                                canvasTemp[iCanvas][jCanvas] = pattern;
                            }
                        }
                    }
                }
                if (!isValid) {
                    break;
                }
            }
        }

        
        if (isValid) {
            canvas = canvasTemp;

            this.shapeCount++;
            Shape shapeAdded;
            if (shapeTypeAdded == ShapeType.CIRCLE) {
                shapeAdded = new Circle(location, pattern, radius);
            } else {
                shapeAdded = new RightTriangle(location, pattern, width, height, directionAdded);
            }
            shapes.add(shapeAdded);
            spaceGridCount -= shapeAdded.area();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getSpaceGridCount() {
        return this.spaceGridCount;
    }

    @Override
    public int getShapeCount() {
        return this.shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> shapesByArea = new ArrayList<>(shapes);
        shapesByArea.sort((c1, c2) -> {
            if (c1.area() != c2.area()) {
                return c1.area() - c2.area();
            }
            return (int) c1.pattern - (int) c2.pattern;
        });
        return shapesByArea;
    }


    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> shapesByArea = new ArrayList<>(shapes);
        shapesByArea.sort((c1, c2) -> {
            if (c1.getLocationArr()[0] != c2.getLocationArr()[0]) {
                return c1.getLocationArr()[0] - c2.getLocationArr()[0];
            }
            if (c1.getLocationArr()[1] != c2.getLocationArr()[1]) {
                return c1.getLocationArr()[1] - c2.getLocationArr()[1];
            }
            return (int) c1.pattern - (int) c2.pattern;
        });
        return shapesByArea;
    }

    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }

    public static void main(String[] args) {
        ShapeCanvas shapeCanvas = new AvoidConflictShapeCanvas(20, 20);
        System.out.println(shapeCanvas.addShape(0, 2, 'A', 5, 3, 1));
        System.out.println(shapeCanvas.addShape(6, 8, 'B', 5, 7, 2));
        System.out.println(shapeCanvas.addShape(8, 12, 'C', 5));
        System.out.println(shapeCanvas.addShape(6, 6, 'D', 5, 7, 1));
        System.out.println(shapeCanvas.addShape(0, 8, 'E', 3));

        shapeCanvas.getShapesByArea().forEach(System.out::println);
        shapeCanvas.getShapesByLocation().forEach(System.out::println);

        for (char[] line : shapeCanvas.getCanvas()) {
            System.out.println(line);
        }
    }
}

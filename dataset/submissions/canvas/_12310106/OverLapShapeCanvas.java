import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int shapeCount = 0;
    private int spaceGridCount = 0;

    public OverLapShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
        spaceGridCount = rows * cols;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        
        ShapeType shapeTypeAdded;
        Location locationAdded = new Location(x, y);
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

        
        char[][] canvasTemp = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < canvasTemp.length; i++) {
            System.arraycopy(canvas[i], 0, canvasTemp[i], 0, canvasTemp[0].length);
        }

        boolean isValid = false;

        if (shapeTypeAdded == ShapeType.CIRCLE) {
            Shape circleAdded = new Circle(locationAdded, pattern, radius);
            circleAdded.fillGrids();
            char[][] grids = circleAdded.getGrids();
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[0].length; j++) {
                    int iCanvas = i + x;
                    int jCanvas = j + y;
                    if (grids[i][j] != ' ') {
                        boolean isInCanvas = iCanvas >= 0 && iCanvas < canvas.length && jCanvas >= 0 && jCanvas < canvas[0].length;
                        if (isInCanvas) {
                            if (canvasTemp[iCanvas][jCanvas] == ' ') {
                                spaceGridCount--;
                            }
                            canvasTemp[iCanvas][jCanvas] = pattern;
                            isValid = true;
                        }
                    }
                }
            }
        } else {
            
            Shape rightTriangleAdded = new RightTriangle(locationAdded, pattern, width, height, directionAdded);
            rightTriangleAdded.fillGrids();
            char[][] grids = rightTriangleAdded.getGrids();
            for (int i = 0; i < grids.length; i++) {
                for (int j = 0; j < grids[0].length; j++) {
                    int iCanvas = i + x;
                    int jCanvas = j + y;
                    if (grids[i][j] != ' ') {
                        boolean isInCanvas = iCanvas >= 0 && iCanvas < canvas.length && jCanvas >= 0 && jCanvas < canvas[0].length;
                        if (isInCanvas) {
                            if (canvasTemp[iCanvas][jCanvas] == ' ') {
                                spaceGridCount--;
                            }
                            canvasTemp[iCanvas][jCanvas] = pattern;
                            isValid = true;
                        }
                    }
                }
            }
        }

        
        if (isValid) {
            canvas = canvasTemp;
            this.shapeCount++;
            Shape shapeAdded;
            if (shapeTypeAdded == ShapeType.CIRCLE) {
                shapeAdded = new Circle(locationAdded, pattern, radius);
            } else {
                shapeAdded = new RightTriangle(locationAdded, pattern, width, height, directionAdded);
            }
            shapes.add(shapeAdded);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getSpaceGridCount() {
        return spaceGridCount;
    }

    @Override
    public int getShapeCount() {
        return shapeCount;
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
        ShapeCanvas canvas1 = new OverLapShapeCanvas(15, 15);
        canvas1.addShape(0, 0, 'A', 6);
        canvas1.addShape(1, 1, 'B', 5);
        canvas1.addShape(2, 2, 'C', 4);
        canvas1.addShape(3, 3, 'D', 3);
        canvas1.addShape(10, 5, 'E', 4, 6, 2);
        canvas1.addShape(14, 14, 'F', 4, 6, 3);
        canvas1.addShape(10, 5, '0', 3, 2, 1);
        canvas1.addShape(10, 5, '1', 1, 1, 2);
        for (char[] line : canvas1.getCanvas()) {
            System.out.println(line);
        }
        System.out.println(canvas1.getShapeCount());
        System.out.println(canvas1.getSpaceGridCount());
        canvas1.getShapesByArea().forEach(System.out::println);
        canvas1.getShapesByLocation().forEach(System.out::println);
    }
}

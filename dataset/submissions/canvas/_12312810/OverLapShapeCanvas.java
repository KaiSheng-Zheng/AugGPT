import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private static final char EMPTY_GRID = ' ';
    public OverLapShapeCanvas(int rows, int cols){
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (char[] line : canvas) {
            Arrays.fill(line, ' ');
        }
        shapes = new ArrayList<>();
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

        if (x < 0 || x > canvas.length-1 || y < 0 || y > canvas[0].length-1) {
            return false;
        }int num=0;
        if (params.length==1) {
            int gridsize = params[0] ;
            for (int i = 0; i < gridsize; i++) {
                for (int j = 0; j < gridsize; j++) {
                    if (i + x >= 0 && i + x < canvas.length && j + y >= 0 && j + y < canvas[0].length) {
                        int distence2 = (i + 1 - params[0]) * (i + 1 - params[0]) + (j + 1 - params[0]) * (j + 1 - params[0]);
                        if (i < params[0] && j < params[0]) {
                            if (distence2 < params[0] * params[0]) {
                                num++;
                            }
                        }
                        if (i + x >= 0 && i + x < canvas.length && (2 * params[0] - 1) - j + y >= 0 && (2 * params[0] - 1) - j + y < canvas[0].length) {
                            num++;
                        }
                        if ((2 * params[0] - 1) - i + x >= 0 && (2 * params[0] - 1) - i + x < canvas.length && j + y >= 0 && j + y < canvas[0].length) {
                            num++;
                        }
                        if ((2 * params[0] - 1) - (i + x) >= 0 && (2 * params[0] - 1) - (i + x) < canvas.length && (2 * params[0] - 1) - j + y >= 0 && (2 * params[0] - 1) - j + y < canvas[0].length) {
                            num++;
                        }
                    }
                }
            }
        }
        if (params.length == 3) {
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    double b = ((double) params[0] / params[1]) * (i + 1);
                    if (params[2] == 1) {
                        if (x + i >= 0 && x + i < canvas.length && y + j >= 0 && y + j < canvas[0].length && j < b) {
                            num++;
                        }
                    }
                    if (params[2] == 0) {
                        if (x + i >= 0 && x + i < canvas.length && y + j >= 0 && y + j < canvas[0].length && j < params[0] - ((double) params[0] / params[1]) * i) {
                            num++;
                        }
                    }
                    if (params[2] == 2) {
                        if (x + i >= 0 && x + i < canvas.length && y + j >= 0 && y + j < canvas[0].length && j + 1 > ((double) params[0] / params[1]) * i) {
                            num++;
                        }
                    }
                    if (params[2] == 3) {
                        if (x + i >= 0 && x + i < canvas.length && y + j >= 0 && y + j < canvas[0].length && j + 1 > params[0] - b) {
                            num++;
                        }
                    }
                }
            }
        }
        if (num==0){return false;}
        Shape shape;
        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else {
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        }
        shapes.add(shape);
        if (params.length==1) {
            boolean shapeadd=false;
            int gridsize = params[0];
            for (int i = 0; i < gridsize; i++) {
                for (int j = 0; j < gridsize; j++) {
                    if (i + x >= 0 && i + x < canvas.length && j + y >= 0 && j + y < canvas[0].length) {
                        int distence2 = (i + 1 - params[0]) * (i + 1 - params[0]) + (j + 1 - params[0]) * (j + 1 - params[0]);
                            if (distence2 < params[0] * params[0]) {
                                canvas[i + x][j + y] = pattern;
                                shapeadd= true;
                                if (i + x >= 0 && i + x < canvas.length && (2 * params[0] - 1) - j + y >= 0 && (2 * params[0] - 1) - j + y < canvas[0].length) {
                                    canvas[i + x][(2 * params[0] - 1) - j + y] = canvas[i + x][j + y];
                                    shapeadd= true;
                                }
                                if ((2 * params[0] - 1) - i + x >= 0 && (2 * params[0] - 1) - i + x < canvas.length && j + y >= 0 && j + y < canvas[0].length) {
                                    canvas[(2 * params[0] - 1) - i + x][j + y] = canvas[i + x][j + y];
                                    shapeadd= true;
                                }
                                if ((2*params[0]-1)-i+x<canvas.length&&(2*params[0]-1-j+y)<canvas[0].length) {
                                    canvas[(2*params[0]-1)-i+x][(2*params[0]-1-j+y)]=canvas[i+x][j+y];
                                    shapeadd=true;
                                }
                            }

                    }
                }
            }

            return shapeadd;
        }
        if (params.length == 3) {
            boolean shapeadd=false;
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    double b = ((double) params[0] / params[1]) * (i + 1);
                    if (params[2] == 1) {
                        if (x + i >= 0 && x + i < canvas.length && y + j >= 0 && y + j < canvas[0].length && j < b) {
                            canvas[x + i][y + j] = pattern;
                            shapeadd=true;
                        }
                    }
                    if (params[2] == 0) {
                        if (x + i >= 0 && x + i < canvas.length && y + j >= 0 && y + j < canvas[0].length && j < params[0] - ((double) params[0] / params[1]) * i) {
                            canvas[x + i][y + j] = pattern;
                            shapeadd=true;
                        }
                    }
                    if (params[2] == 2) {
                        if (x + i >= 0 && x + i < canvas.length && y + j >= 0 && y + j < canvas[0].length && j + 1 > ((double) params[0] / params[1]) * i) {
                            canvas[x + i][y + j] = pattern;
                            shapeadd=true;
                        }
                    }
                    if (params[2] == 3) {
                        if (x + i >= 0 && x + i < canvas.length && y + j >= 0 && y + j < canvas[0].length && j + 1 > params[0] - b) {
                            canvas[x + i][y + j] = pattern;
                            shapeadd=true;
                        }
                    }
                }
            }
            return shapeadd;
        }
        return true;
    }


    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == EMPTY_GRID) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getShapeCount() {
        return shapes.size();
    }

    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        int n = sortedShapes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedShapes.get(j).area > sortedShapes.get(j + 1).area ||
                        (sortedShapes.get(j).area == sortedShapes.get(j + 1).area) &&
                                sortedShapes.get(j).pattern > sortedShapes.get(j + 1).pattern) {
                    Shape temp = sortedShapes.get(j);
                    sortedShapes.set(j, sortedShapes.get(j + 1));
                    sortedShapes.set(j + 1, temp);
                }
            }
        }
        return sortedShapes;
    }

    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        int n = sortedShapes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedShapes.get(j).location.getX() > sortedShapes.get(j + 1).location.getX() ||
                        (sortedShapes.get(j).location.getX() == sortedShapes.get(j + 1).location.getX()&&
                                sortedShapes.get(j).location.getY()> sortedShapes.get(j + 1).location.getY())||(sortedShapes.get(j).location.getX() == sortedShapes.get(j + 1).location.getX() &&
                        sortedShapes.get(j).location.getY() == sortedShapes.get(j + 1).location.getY()&&sortedShapes.get(j).pattern>sortedShapes.get(j+1).pattern)) {
                    Shape temp = sortedShapes.get(j);
                    sortedShapes.set(j, sortedShapes.get(j + 1));
                    sortedShapes.set(j + 1, temp);
                }
            }
        }
        return sortedShapes;
    }

    public char[][] getCanvas() {
        return canvas;
    }
}
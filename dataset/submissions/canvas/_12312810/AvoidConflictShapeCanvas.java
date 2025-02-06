import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private static final char EMPTY_GRID = ' ';
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (char[] line : canvas) {
            Arrays.fill(line, ' ');
        }
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

        if (x < 0 || x >= canvas.length || y < 0 || y >= canvas[0].length) {
            return false;
        }
        if (params.length==1){
            if (x+2*params[0]>canvas.length||y+2*params[0]>canvas[0].length){
                return false;
            }
        }
        if (params.length==3){
            if (x+params[1]>canvas.length||y+params[0]>canvas[0].length){
                return false;
            }
        }
        if (params.length == 1) {
            int gridsize = params[0] ;
            for (int i = 0; i < gridsize; i++) {
                for (int j = 0; j < gridsize; j++) {
                    int distance2 = (i - params[0] + 1) * (i - params[0] + 1) + (j - params[0] + 1) * (j - params[0] + 1);
                    if (distance2 < params[0] * params[0]) {
                        if (canvas[i + x][j + y] != ' ') {
                            return false;
                        }
                    }
                    if (canvas[i + x][2 * params[0] - 1 - j + y] != ' ' && canvas[2 * params[0] - 1 - i + x][j + y] != ' '&&canvas[2 * params[0] - 1 - i + x][2 * params[0] - 1 - j + y]!=' ') {
                        return false;
                    }
                }
            }
        }
        if (params.length==3) {
            for (int i1 = 0; i1 < params[1]; i1++) {
                for (int j1 = 0; j1 < params[0]; j1++) {
                    double b = ((double) params[0] / params[1]) * (i1 + 1);
                    if (params[2] == 1) {
                        if (j1 < b) {
                            if (canvas[i1 + x][j1 + y] != ' ') {
                                return false;
                            }
                        }
                    }
                    if (params[2] == 0) {
                        if (j1 < params[0] - ((double) params[0] / params[1]) * i1) {
                            if (canvas[i1 + x][j1 + y] != ' ') {
                                return false;
                            }
                        }
                    }
                    if (params[2] == 2) {
                        if (j1 + 1 > ((double) params[0] / params[1]) * i1) {
                            if (canvas[i1 + x][j1 + y] != ' ') {
                                return false;
                            }
                        }
                    }
                    if (params[2] == 3) {
                        if (j1 + 1 > params[0] - b) {
                            if (canvas[i1 + x][j1 + y] != ' ') {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        Shape shape;
        if (params.length == 1) {
            shape = new Circle(new Location(x, y), pattern, params[0]);
        } else {
            shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
        }
        shapes.add(shape);
        if (params.length == 1) {
            int gridsize = params[0] ;
            for (int i = 0; i < gridsize; i++) {
                for (int j = 0; j < gridsize; j++) {
                    int distance2 = (i - params[0] + 1) * (i - params[0] + 1) + (j - params[0] + 1) * (j - params[0] + 1);
                        if (distance2 < params[0] * params[0]) {
                            if (canvas[i + x][j + y] != ' ') {
                                return false;
                            } else {
                                canvas[i + x][j + y] = pattern;
                            }
                        }
                    if (canvas[i + x][2 * params[0] - 1 - j + y] == ' ' && canvas[2 * params[0] - 1 - i + x][j + y] == ' '&&canvas[2 * params[0] - 1 - i + x][2 * params[0] - 1 - j + y]==' ') {
                        canvas[i + x][2 * params[0] - 1 - j + y] = canvas[i + x][j + y];
                        canvas[2 * params[0] - 1 - i + x][j + y] = canvas[i + x][j + y];
                        canvas[2 * params[0] - 1 - i + x][2 * params[0] - 1 - j + y]=canvas[i + x][j + y];
                    } else {
                        return false;
                    }
                }
            }return true;
        }
        if (params.length==3) {
            for (int i1 = 0; i1 < params[1]; i1++) {
                for (int j1 = 0; j1 < params[0]; j1++) {
                    double b = ((double) params[0] / params[1]) * (i1 + 1);
                    if (params[2] == 1) {
                        if (j1 < b) {
                              if (canvas[i1 + x][j1 + y] != ' '){
                                return false;
                            }
                        }
                    }
                    if (params[2] == 0) {
                        if (j1 < params[0] - ((double) params[0] / params[1]) * i1) {
                            if (canvas[i1 + x][j1 + y] != ' '){
                                return false;
                            }
                        }
                    }
                    if (params[2] == 2) {
                        if (j1 + 1 > ((double) params[0] / params[1]) * i1) {
                            if (canvas[i1 + x][j1 + y] != ' '){
                                return false;
                            }
                        }
                    }
                    if (params[2] == 3) {
                        if (j1 + 1 > params[0] - b) {
                            if (canvas[i1 + x][j1 + y] != ' '){
                                return false;
                            }
                        }
                    }
                }
            }
            for (int i1 = 0; i1 < params[1]; i1++) {
                for (int j1 = 0; j1 < params[0]; j1++) {
                    double b = ((double) params[0] / params[1]) * (i1 + 1);
                    if (params[2] == 1) {
                        if (j1 < b) {
                            if (canvas[i1 + x][j1 + y] == ' ') {
                              canvas[i1 + x][j1 + y] = pattern;
                            }
                          else   if (canvas[i1 + x][j1 + y] != ' '){
                                return false;
                            }
                        }
                    }
                    if (params[2] == 0) {
                        if (j1 < params[0] - ((double) params[0] / params[1]) * i1) {
                            if (canvas[i1 + x][j1 + y] == ' ') {
                                canvas[i1 + x][j1 + y] = pattern;
                            }
                           else if (canvas[i1 + x][j1 + y] != ' '){
                                return false;
                            }
                        }
                    }
                    if (params[2] == 2) {
                        if (j1 + 1 > ((double) params[0] / params[1]) * i1) {
                            if (canvas[i1 + x][j1 + y] == ' ') {
                                canvas[i1 + x][j1 + y] = pattern;
                            }
                            else if (canvas[i1 + x][j1 + y] != ' '){
                                return false;
                            }
                        }
                    }
                    if (params[2] == 3) {
                        if (j1 + 1 > params[0] - b) {
                            if (canvas[i1 + x][j1 + y] == ' ') {
                                canvas[i1 + x][j1 + y] = pattern;
                            }
                            else if (canvas[i1 + x][j1 + y] != ' '){
                                return false;
                            }
                        }
                    }
                }
            }
                return true;
            }
        return false;
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
                        (sortedShapes.get(j).location.getX() == sortedShapes.get(j + 1).location.getX()) &&
                                sortedShapes.get(j).pattern > sortedShapes.get(j + 1).pattern) {
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
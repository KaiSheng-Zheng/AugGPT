import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        Shape shape;
        if (params.length == 1) {
            shape = new Circle(location, pattern, params[0]);
        } else {
            Direction direction = Direction.LEFT_UP;
            switch (params[2]) {
                case 0:
                    direction = Direction.LEFT_UP;
                    break;
                case 1:
                    direction = Direction.LEFT_DOWN;
                    break;
                case 2:
                    direction = Direction.RIGHT_UP;
                    break;
                case 3:
                    direction = Direction.RIGHT_DOWN;
                    break;
            }
            shape = new RightTriangle(location, pattern, params[0], params[1], direction);
        }
        char[][] grid = shape.getGrids();
        char[][] newGrids;
        if (x+grid.length > canvas.length && y+grid[0].length > canvas[0].length) {
            newGrids = new char[x+grid.length][y+grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    newGrids[i+x][j+y] = grid[i][j];
                }
            }
            boolean a = true;
            for (int i = canvas.length; i < newGrids.length; i++) {
                for (int j = 0; j < newGrids[0].length; j++) {
                    if (newGrids[i][j] != ' '){
                        a = false;
                        break;
                    }
                }
            }
            for (int i = 0; i < newGrids.length; i++) {
                for (int j = canvas[0].length; j < newGrids[0].length; j++) {
                    if (newGrids[i][j] != ' ') {
                        a = false;
                        break;
                    }
                }
            }
            for (int i = x; i < canvas.length; i++) {
                for (int j = y; j < canvas[0].length; j++) {
                    if (grid[i-x][j-y] != ' ' && canvas[i][j] != ' ') {
                        a = false;
                        break;
                    }
                }
            }
            if (a) {
                for (int i = 0; i < canvas.length-x; i++) {
                    for (int j = 0; j < canvas[0].length-y; j++) {
                        if (grid[i][j] != ' ') {
                            canvas[i + x][j + y] = grid[i][j];
                        }
                    }
                }
                shapes.add(shape);
                return true;
            }else {
                return false;
            }
        } else if (x+grid.length > canvas.length && y+grid[0].length <= canvas[0].length) {
            newGrids = new char[x+grid.length][canvas[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    newGrids[i+x][j+y] = grid[i][j];
                }
            }
            boolean a = true;
            for (int i = canvas.length; i < newGrids.length; i++) {
                for (int j = 0; j < newGrids[0].length; j++) {
                    if (newGrids[i][j] != ' '){
                        a = false;
                        break;
                    }
                }
            }
            for (int i = x; i < canvas.length; i++) {
                for (int j = y; j < y+params[0]; j++) {
                    if (grid[i-x][j-y] != ' ' && canvas[i][j] != ' ') {
                        a = false;
                        break;
                    }
                }
            }
            if (a) {
                for (int i = 0; i < canvas.length-x; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if (grid[i][j] != ' '){
                            canvas[i+x][j+y] = grid[i][j];
                        }
                    }
                }
                shapes.add(shape);
                return true;
            }else {
                return false;
            }
        } else if (x+grid.length <= canvas.length && y+grid[0].length > canvas[0].length) {
            newGrids = new char[canvas.length][y+grid[0].length];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    newGrids[i+x][j+y] = grid[i][j];
                }
            }
            boolean a = true;
            for (int i = 0; i < newGrids.length; i++) {
                for (int j = canvas[0].length; j < newGrids[0].length; j++) {
                    if (newGrids[i][j] != ' ') {
                        a = false;
                        break;
                    }
                }
            }
            for (int i = x; i < x+params[1]; i++) { // error if the shape is circle
                for (int j = y; j < canvas[0].length; j++) {
                    if (grid[i-x][j-y] != ' ' && canvas[i][j] != ' ') {
                        a = false;
                        break;
                    }
                }
            }
            if (a) {
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < canvas[0].length-y; j++) {
                        if (grid[i][j] != ' ') {
                            canvas[i + x][j + y] = grid[i][j];
                        }
                    }
                }
                shapes.add(shape);
                return true;
            }else {
                return false;
            }
        }else {
            boolean a = true;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != ' ' && canvas[i+x][j+y] != ' ') {
                        a = false;
                        break;
                    }
                }
            }
            if (a) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] != ' ') {
                            canvas[i+x][j+y] = grid[i][j];
                        }
                    }
                }
                shapes.add(shape);
                return true;
            }else{
                return false;
            }
        }
    }


    @Override
    public int getSpaceGridCount() {
        int t = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] != ' ') {
                    t++;
                }
            }
        }
        return t;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = shapes.size()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(shapes.get(j).area() > shapes.get(j+1).area()) {
                    Shape shape = shapes.get(j);
                    shapes.set(j, shapes.get(j+1));
                    shapes.set(j+1, shape);
                }else if (shapes.get(j).area() == shapes.get(j+1).area()) {
                    Shape shape = shapes.get(j);
                    char c1 = shapes.get(j).pattern;
                    char c2 = shapes.get(j+1).pattern;
                    int t = c1 - c2;
                    if (t > 0) {
                        shapes.set(j, shapes.get(j+1));
                        shapes.set(j+1, shape);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = shapes.size()-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                Shape shape = shapes.get(j);
                if(shapes.get(j).location.getX() > shapes.get(j+1).location.getX()) {
                    shapes.set(j, shapes.get(j+1));
                    shapes.set(j+1, shape);
                }else if (shapes.get(j).location.getX() == shapes.get(j+1).location.getX()) {
                    if (shapes.get(j).location.getY() > shapes.get(j+1).location.getY()) {
                        shapes.set(j, shapes.get(j+1));
                        shapes.set(j+1, shape);
                    } else if (shapes.get(j).location.getY() == shapes.get(j+1).location.getY()) {
                        char c1 = shapes.get(j).pattern;
                        char c2 = shapes.get(j+1).pattern;
                        int t = c1 - c2;
                        if (t > 0) {
                            shapes.set(j, shapes.get(j+1));
                            shapes.set(j+1, shape);
                        }
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
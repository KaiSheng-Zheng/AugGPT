import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private int shapeCount;
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    private final int r;
    private final int c;
    private int space = 0;

    public OverLapShapeCanvas(int rows, int cols) {
        r = rows;
        c = cols;
        canvas = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            int count= 0;
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            for (int i = 0; i < params[0] * 2; i++) {
                for (int j = 0; j < params[0] * 2; j++) {
                    if ((x + i <= r - 1 && x + i >= 0) && (y + j <= c - 1 && y + j >= 0)) {
                        if ( !(circle.grids[i][j] == ' ')){
                            count++;
                        }
                    }
                }
            }
            if (count!=0) {
                for (int i = x; i < Math.min(r, x + circle.grids.length); i++) {
                    for (int j = y; j < Math.min(c, y + circle.grids[0].length); j++) {
                        if (circle.grids[i - x][j - y] != ' ') {
                            canvas[i][j] = circle.grids[i - x][j - y];
                        }
                    }
                }
                this.shapes.add(circle);
                shapeCount += 1;
                return true;
            }
        } else if (params.length == 3) {
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
            int count = 0;
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if ((x + i <= r - 1 && x + i >= 0) && (y + j <= c - 1 && y + j >= 0)) {
                        if ( !(rightTriangle.grids[i][j] == ' ')){
                            count++;
                        }
                    }
                }
            }
            if (count != 0) {
                for (int i = x; i < Math.min(r, x + rightTriangle.grids.length); i++) {
                    for (int j = y; j < Math.min(c, y + rightTriangle.grids[0].length); j++) {
                        if (rightTriangle.grids[i - x][j - y] != ' ') {
                            canvas[i][j] = rightTriangle.grids[i - x][j - y];
                        }
                    }
                }
                this.shapes.add(rightTriangle);
                shapeCount += 1;
                return true;
            }
        }
        return false;
    }

    public boolean isCircleInBound(int x, int y, int... params) {
        boolean b = false;
        for (int i = 0; i < params[0] * 2; i++) {
            for (int j = 0; j < params[0] * 2; j++) {
                double distance;
                if (i < params[0] && j < params[0]) {
                    distance = Math.sqrt(Math.pow(i + 1 - params[0], 2) + Math.pow(j + 1 - params[0], 2));
                } else if (i >= params[0] && j < params[0]) {
                    distance = Math.sqrt(Math.pow(i - params[0], 2) + Math.pow(j + 1 - params[0], 2));
                } else if (i < params[0]) {
                    distance = Math.sqrt(Math.pow(i + 1 - params[0], 2) + Math.pow(j - params[0], 2));
                } else {
                    distance = Math.sqrt(Math.pow(i - params[0], 2) + Math.pow(j - params[0], 2));
                }
                if ((x + i <= r && x + i >= 0) && (y + j <= c && y + j >= 0) && distance < params[0]) {
                    b = true;
                    break;
                }
            }
        }

        return b;
    }

    @Override
    public int getSpaceGridCount() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (canvas[i][j] == ' ') {
                    space++;
                }
            }
        }
        return space;
    }

    public int getShapeCount() {
        return shapeCount;
    }

    public char[][] getCanvas() {
        return canvas;
    }

    public List<Shape> getShapesByArea() {
        Shape temp;
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).area() > shapes.get(j + 1).area()) {
                    temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).area() == shapes.get(j + 1).area()) {
                    if (shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                        temp = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, temp);
                    }
                }
            }
        }
        return shapes;
    }

    public List<Shape> getShapesByLocation() {
        Shape temp;
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).location.getX() > shapes.get(j + 1).location.getX()) {
                    temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).location.getX() == shapes.get(j + 1).location.getX()) {
                    if (shapes.get(j).location.getY() > shapes.get(j + 1).location.getY()) {
                        temp = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, temp);
                    }
                }
            }
        }
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if ((shapes.get(j).location.getX() == shapes.get(j + 1).location.getX()) && (shapes.get(j).location.getY() == shapes.get(j + 1).location.getY())) {
                    if (shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                        temp = shapes.get(j);
                        shapes.set(j, shapes.get(j + 1));
                        shapes.set(j + 1, temp);
                    }
                }
            }
        }
        return shapes;
    }
}


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Shape {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    public Shape(Location location, char pattern) {
        this.location = location;
        this.pattern = pattern;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();
}

class Circle extends Shape {

    private int radius;

    private int count = 0;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        count = 0;
        this.grids = new char[radius * 2][radius * 2];

        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                int a, b;
                if (i < radius && j < radius) {
                    a = (Math.abs(i - radius) - 1);
                    b = (Math.abs(j - radius) - 1);
                } else if (i < radius && j >= radius) {
                    a = (Math.abs(i - radius) - 1);
                    b = (Math.abs(j - radius));
                } else if (i >= radius && j < radius) {
                    a = (Math.abs(i - radius));
                    b = (Math.abs(j - radius) - 1);
                } else {
                    a = (Math.abs(i - radius));
                    b = (Math.abs(j - radius));
                }
                if (a * a + b * b < radius * radius) {
                    grids[i][j] = pattern;
                    count++;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.radius--;
        fillGrids();
    }

    @Override
    public int area() {
        return count;
    }

    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c",
                location.getX(), location.getY(), this.area(), this.pattern);
    }
}

class RightTriangle extends Shape {

    private int width;
    private int height;
    private final Direction d;

    private int count;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        count = 0;
        this.grids = new char[height][width];
        double slope = (double) height / width;

        switch (d) {
            case LEFT_DOWN:
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[0].length; j++) {
                        if (i + 1 > j * slope) {
                            grids[i][j] = pattern;
                            count++;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case LEFT_UP:
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[0].length; j++) {
                        if (height - i > j * slope) {
                            grids[i][j] = pattern;
                            count++;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[0].length; j++) {
                        if (i + 1 > (width - j - 1) * slope) {
                            grids[i][j] = pattern;
                            count++;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < grids[0].length; j++) {
                        if (height - i > (width - j - 1) * slope) {
                            grids[i][j] = pattern;
                            count++;
                        } else {
                            grids[i][j] = ' ';
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void enlarge() {
        this.height++;
        this.width++;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.height--;
        this.width--;
        fillGrids();
    }

    @Override
    public int area() {
        return count;
    }

    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",
                location.getX(), location.getY(), this.area(), this.pattern);
    }
}

class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        switch (params.length) {
            case 1:
                if (x >= 0 && y >= 0 && x + 2 * params[0] - 1 < canvas.length && y + 2 * params[0] - 1 < canvas[0].length) {
                    int radius = params[0];

                    boolean flag = true;

                    l:
                    for (int i = 0; i < 2 * radius; i++) {
                        for (int j = 0; j < 2 * radius; j++) {
                            int a, b;
                            if (i < radius && j < radius) {
                                a = (Math.abs(i - radius) - 1);
                                b = (Math.abs(j - radius) - 1);
                            } else if (i < radius && j >= radius) {
                                a = (Math.abs(i - radius) - 1);
                                b = (Math.abs(j - radius));
                            } else if (i >= radius && j < radius) {
                                a = (Math.abs(i - radius));
                                b = (Math.abs(j - radius) - 1);
                            } else {
                                a = (Math.abs(i - radius));
                                b = (Math.abs(j - radius));
                            }
                            if (a * a + b * b < radius * radius && canvas[i + x][j + y] != ' ') {
                                flag = false;
                                break l;
                            }
                        }
                    }

                    if (flag == true) {
                        for (int i = 0; i < 2 * radius; i++) {
                            for (int j = 0; j < 2 * radius; j++) {
                                int a, b;
                                if (i < radius && j < radius) {
                                    a = (Math.abs(i - radius) - 1);
                                    b = (Math.abs(j - radius) - 1);
                                } else if (i < radius && j >= radius) {
                                    a = (Math.abs(i - radius) - 1);
                                    b = (Math.abs(j - radius));
                                } else if (i >= radius && j < radius) {
                                    a = (Math.abs(i - radius));
                                    b = (Math.abs(j - radius) - 1);
                                } else {
                                    a = (Math.abs(i - radius));
                                    b = (Math.abs(j - radius));
                                }
                                if (a * a + b * b < radius * radius) {
                                    canvas[i + x][j + y] = pattern;
                                }
                            }
                        }
                        shapes.add(new Circle(new Location(x, y), pattern, params[0]));
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            case 3:
                if (x >= 0 && y >= 0 && x + params[1] - 1 < canvas.length && y + params[0] - 1 < canvas[0].length) {
                    int width = params[0];
                    int height = params[1];

                    Direction d = Direction.values()[params[2]];

                    boolean flag = true;

                    double slope = (double) height / width;

                    ll:
                    switch (d) {
                        case LEFT_DOWN:
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < width; j++) {
                                    if (i + 1 > j * slope && canvas[i + x][j + y] != ' ') {
                                        flag = false;
                                        break ll;
                                    }
                                }
                            }
                            break;
                        case LEFT_UP:
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < width; j++) {
                                    if (height - i > j * slope && canvas[i + x][j + y] != ' ') {
                                        flag = false;
                                        break ll;
                                    }
                                }
                            }
                            break;
                        case RIGHT_DOWN:
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < width; j++) {
                                    if (i + 1 > (width - j - 1) * slope && canvas[i + x][j + y] != ' ') {
                                        flag = false;
                                        break ll;
                                    }
                                }
                            }
                            break;
                        case RIGHT_UP:
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < width; j++) {
                                    if (height - i > (width - j - 1) * slope && canvas[i + x][j + y] != ' ') {
                                        flag = false;
                                        break ll;
                                    }
                                }
                            }
                            break;
                    }

                    if (flag == true) {
                        switch (d) {
                            case LEFT_DOWN:
                                for (int i = 0; i < height; i++) {
                                    for (int j = 0; j < width; j++) {
                                        if (i + 1 > j * slope) {
                                            canvas[i + x][j + y] = pattern;
                                        }
                                    }
                                }
                                shapes.add(new RightTriangle(new Location(x, y), pattern, width, height, d));
                                return true;
                            case LEFT_UP:
                                for (int i = 0; i < height; i++) {
                                    for (int j = 0; j < width; j++) {
                                        if (height - i > j * slope) {
                                            canvas[i + x][j + y] = pattern;
                                        }
                                    }
                                }
                                shapes.add(new RightTriangle(new Location(x, y), pattern, width, height, d));
                                return true;
                            case RIGHT_DOWN:
                                for (int i = 0; i < height; i++) {
                                    for (int j = 0; j < width; j++) {
                                        if (i + 1 > (width - j - 1) * slope) {
                                            canvas[i + x][j + y] = pattern;
                                        }
                                    }
                                }
                                shapes.add(new RightTriangle(new Location(x, y), pattern, width, height, d));
                                return true;
                            case RIGHT_UP:
                                for (int i = 0; i < height; i++) {
                                    for (int j = 0; j < width; j++) {
                                        if (height - i > (width - j - 1) * slope) {
                                            canvas[i + x][j + y] = pattern;
                                        }
                                    }
                                }
                                shapes.add(new RightTriangle(new Location(x, y), pattern, width, height, d));
                                return true;
                        }
                    } else {
                        return false;
                    }
                }
                break;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
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
        Comparator<Shape> comparator = new ShapeAreaComparator();
        shapes.sort(comparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> comparator = new ShapeCoordinateComparator();
        shapes.sort(comparator);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<Shape>();
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
        switch (params.length) {
            case 1:
                int radius = params[0];

                boolean flag = false;

                l:
                for (int i = 0; i < 2 * radius; i++) {
                    for (int j = 0; j < 2 * radius; j++) {
                        int a, b;
                        if (i < radius && j < radius) {
                            a = (Math.abs(i - radius) - 1);
                            b = (Math.abs(j - radius) - 1);
                        } else if (i < radius && j >= radius) {
                            a = (Math.abs(i - radius) - 1);
                            b = (Math.abs(j - radius));
                        } else if (i >= radius && j < radius) {
                            a = (Math.abs(i - radius));
                            b = (Math.abs(j - radius) - 1);
                        } else {
                            a = (Math.abs(i - radius));
                            b = (Math.abs(j - radius));
                        }
                        if (a * a + b * b < radius * radius &&
                                (i + x >= 0 && i + x < canvas.length) && (j + y >= 0 && j + y < canvas[0].length)) {
                            flag = true;
                            break l;
                        }
                    }
                }

                if (flag == true) {
                    for (int i = 0; i < 2 * radius; i++) {
                        for (int j = 0; j < 2 * radius; j++) {
                            int a, b;
                            if (i < radius && j < radius) {
                                a = (Math.abs(i - radius) - 1);
                                b = (Math.abs(j - radius) - 1);
                            } else if (i < radius && j >= radius) {
                                a = (Math.abs(i - radius) - 1);
                                b = (Math.abs(j - radius));
                            } else if (i >= radius && j < radius) {
                                a = (Math.abs(i - radius));
                                b = (Math.abs(j - radius) - 1);
                            } else {
                                a = (Math.abs(i - radius));
                                b = (Math.abs(j - radius));
                            }
                            if (a * a + b * b < radius * radius &&
                                    (i + x >= 0 && i + x < canvas.length) && (j + y >= 0 && j + y < canvas[0].length)) {
                                canvas[i + x][j + y] = pattern;
                            }
                        }
                    }
                    shapes.add(new Circle(new Location(x, y), pattern, params[0]));
                    return true;
                } else {
                    return false;
                }
            case 3:
                int width = params[0];
                int height = params[1];

                Direction d = Direction.values()[params[2]];

                boolean flag2 = false;

                double slope = (double) height / width;

                ll:
                switch (d) {
                    case LEFT_DOWN:
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                if (i + 1 > j * slope &&
                                        (i + x >= 0 && i + x < canvas.length) && (j + y >= 0 && j + y < canvas[0].length)) {
                                    flag2 = true;
                                    break ll;
                                }
                            }
                        }
                        break;
                    case LEFT_UP:
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                if (height - i > j * slope &&
                                        (i + x >= 0 && i + x < canvas.length) && (j + y >= 0 && j + y < canvas[0].length)) {
                                    flag2 = true;
                                    break ll;
                                }
                            }
                        }
                        break;
                    case RIGHT_DOWN:
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                if (i + 1 > (width - j - 1) * slope &&
                                        (i + x >= 0 && i + x < canvas.length) && (j + y >= 0 && j + y < canvas[0].length)) {
                                    flag2 = true;
                                    break ll;
                                }
                            }
                        }
                        break;
                    case RIGHT_UP:
                        for (int i = 0; i < height; i++) {
                            for (int j = 0; j < width; j++) {
                                if (height - i > (width - j - 1) * slope &&
                                        (i + x >= 0 && i + x < canvas.length) && (j + y >= 0 && j + y < canvas[0].length)) {
                                    flag2 = true;
                                    break ll;
                                }
                            }
                        }
                        break;
                }

                if (flag2 == true) {
                    switch (d) {
                        case LEFT_DOWN:
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < width; j++) {
                                    if (i + 1 > j * slope &&
                                            (i + x >= 0 && i + x < canvas.length) && (j + y >= 0 && j + y < canvas[0].length)) {
                                        canvas[i + x][j + y] = pattern;
                                    }
                                }
                            }
                            shapes.add(new RightTriangle(new Location(x, y), pattern, width, height, d));
                            return true;
                        case LEFT_UP:
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < width; j++) {
                                    if (height - i > j * slope &&
                                            (i + x >= 0 && i + x < canvas.length) && (j + y >= 0 && j + y < canvas[0].length)) {
                                        canvas[i + x][j + y] = pattern;
                                    }
                                }
                            }
                            shapes.add(new RightTriangle(new Location(x, y), pattern, width, height, d));
                            return true;
                        case RIGHT_DOWN:
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < width; j++) {
                                    if (i + 1 > (width - j - 1) * slope &&
                                            (i + x >= 0 && i + x < canvas.length) && (j + y >= 0 && j + y < canvas[0].length)) {
                                        canvas[i + x][j + y] = pattern;
                                    }
                                }
                            }
                            shapes.add(new RightTriangle(new Location(x, y), pattern, width, height, d));
                            return true;
                        case RIGHT_UP:
                            for (int i = 0; i < height; i++) {
                                for (int j = 0; j < width; j++) {
                                    if (height - i > (width - j - 1) * slope &&
                                            (i + x >= 0 && i + x < canvas.length) && (j + y >= 0 && j + y < canvas[0].length)) {
                                        canvas[i + x][j + y] = pattern;
                                    }
                                }
                            }
                            shapes.add(new RightTriangle(new Location(x, y), pattern, width, height, d));
                            return true;
                    }
                } else {
                    return false;
                }

                break;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
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
        Comparator<Shape> comparator = new ShapeAreaComparator();
        shapes.sort(comparator);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> comparator = new ShapeCoordinateComparator();
        shapes.sort(comparator);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

class ShapeAreaComparator implements Comparator<Shape> {
    public int compare(Shape o1, Shape o2) {
        if (o1.area() < o2.area()) {
            return -1;
        } else if (o1.area() > o2.area()) {
            return 1;
        } else {
            if (o1.pattern < o2.pattern) {
                return -1;
            } else if (o1.pattern > o2.pattern) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

class ShapeCoordinateComparator implements Comparator<Shape> {
    public int compare(Shape o1, Shape o2) {
        if (o1.location.getX() < o2.location.getX()) {
            return -1;
        } else if (o1.location.getX() > o2.location.getX()) {
            return 1;
        } else {
            if (o1.location.getY() < o2.location.getY()) {
                return -1;
            } else if (o1.location.getY() > o2.location.getY()) {
                return 1;
            } else {
                if (o1.pattern < o2.pattern) {
                    return -1;
                } else if (o1.pattern > o2.pattern) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}



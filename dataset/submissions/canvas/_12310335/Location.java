import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;


public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return String.format("(%d,%d)", x, y);
    }
}


enum Direction {
    LEFT_UP, LEFT_DOWN, RIGHT_UP, RIGHT_DOWN;

    public static Direction getDirection(int index) {
        switch (index) {
            case 0:
                return LEFT_UP;
            case 1:
                return LEFT_DOWN;
            case 2:
                return RIGHT_UP;
            case 3:
                return RIGHT_DOWN;
            default:
                return null;
        }
    }
    }


abstract class Shape implements Comparable<Shape> {
    protected char[][] grids;
    protected char pattern;
    protected Location location;

    protected int area;

    public Shape(Location location, char pattern) {
        this.pattern = pattern;
        this.location = location;
    }

    public char[][] getGrids() {
        return grids;
    }

    public abstract void fillGrids();

    public abstract void enlarge();

    public abstract void shrink();

    public abstract int area();

    public String toString(){
        return String.format("%s: %s area=%d pattern=%c",this.getClass().getName(),this.location,this.area,this.pattern);
    }

    public int compareTo(Shape shape) {
        if (this.area() > shape.area()) {
            return 1;
        } else if (this.area() < shape.area()) {
            return -1;
        } else {
            if (this.pattern > shape.pattern) {
                return 1;
            } else if (this.pattern < shape.pattern) {
                return -1;
            } else return 0;
        }
    }

}

class CompareByLocation implements Comparator<Shape> {
    public int compare(Shape shape1,Shape shape2) {
        if (shape1.location.getX() > shape2.location.getX()) {
            return 1;
        } else if (shape1.location.getX() < shape2.location.getX()) {
            return -1;
        } else {
            if (shape1.location.getY() > shape2.location.getY()) {
                return 1;
            } else if (shape1.location.getY() < shape2.location.getY()) {
                return -1;
            } else {
                if (shape1.pattern > shape2.pattern) {
                    return 1;
                } else if (shape1.pattern < shape2.pattern) {
                    return -1;
                }else return 0;
            }
        }
    }
}
class Circle extends Shape  {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.fillGrids();
    }


    @Override
    public void fillGrids() {
        super.grids = new char[radius * 2][radius * 2];
        for (char[] grid : grids) {
            Arrays.fill(grid, this.pattern);
        }
        area = (int) Math.pow(radius * 2, 2);
        for (int i = 1; i < radius; i++) {
            for (int j = 1; j < radius; j++) {
                double length = Math.pow(radius - i, 2) + Math.pow(radius - j, 2);
                int row = i - 1;
                int col = j - 1;
                if (length >= radius * radius) {
                    grids[row][col] = ' ';
                    grids[grids.length - row - 1][col] = ' ';
                    grids[row][grids.length - col - 1] = ' ';
                    grids[grids.length - row - 1][grids.length - col - 1] = ' ';
                    area -= 4;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.radius += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.radius -= 1;
        fillGrids();
    }

    @Override
    public int area() {
        return super.area;
    }

    public static void main(String[] args) {
        Location p1 = new Location(1, 0);
        Shape s1 = new Circle(p1, '*', 5);
        char[][] grids = s1.getGrids();
        for (char[] grid : grids) {
            System.out.println(grid);
        }
        System.out.printf("Grids: height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
        s1.shrink();
        grids = s1.getGrids();
        for (char[] grid : grids) {
            System.out.println(grid);
        }
        System.out.printf("Grids: height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
    }

}
class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;


    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.fillGrids();
    }

    @Override
    public void fillGrids() {
        super.grids = new char[height][width];
        double k = 1.0 * this.height / this.width;
        this.area = 0;
        for (char[] grid : grids) {
            Arrays.fill(grid, ' ');
        }
        for (int i = 1; i <= grids.length; i++) {
            if (this.d == Direction.LEFT_UP || this.d == Direction.LEFT_DOWN) {
                grids[i - 1][0] = this.pattern;
                area++;
            } else {
                grids[i - 1][width - 1] = this.pattern;
                this.area++;
            }
            for (int col = 1; col < grids[0].length; col++) {
                if (i * 1.0 / col > k) {
                    int row = i - 1;
                    if (this.d == Direction.LEFT_DOWN) {
                        grids[row][col] = this.pattern;
                        this.area++;
                    } else if (this.d == Direction.LEFT_UP) {
                        grids[height - 1 - row][col] = this.pattern;
                        this.area++;
                    } else if (this.d == Direction.RIGHT_DOWN) {
                        grids[row][width - 1 - col] = this.pattern;
                        this.area++;
                    } else {
                        grids[height - 1 - row][width - 1 - col] = this.pattern;
                        this.area++;
                    }
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.width += 1;
        this.height += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.width -= 1;
        this.height -= 1;
        fillGrids();
    }


    @Override
    public int area() {
        return super.area;
    }

    public static void main(String[] args) {
        Location p1 = new Location(0, 1);
        Shape s1 = new RightTriangle(p1, 'X', 7, 3, Direction.RIGHT_UP);
        char[][] grids = s1.getGrids();
        for (char[] line : grids) {
            System.out.println(line);
        }
        System.out.printf("Grids height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
        s1.enlarge();
        grids = s1.getGrids();
        for (char[] line : grids) {
            System.out.println(line);
        }
        System.out.printf("Grids height = %d, width = %d\n", grids.length, grids[0].length);
        System.out.println(s1);
    }
}


interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int radius);

    public boolean addShape(int x, int y, char pattern, int width,int height,int index);

    public int getSpaceGridCount();

    public int getShapeCount();

    public List<Shape> getShapesByArea();

    public List<Shape> getShapesByLocation();

    public char[][] getCanvas();


}


class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }


    public boolean addShape(int x, int y, char pattern, int radius) {
        Shape circle = new Circle(new Location(x, y), pattern, radius);
        circle.fillGrids();
        if ((x + 2 * radius > canvas.length) || (y + 2 * radius > canvas[0].length)) {
            return false;
        }
        for (int i = 0; i < circle.grids.length; i++) {
            for (int j = 0; j < circle.grids[0].length; j++) {
                if ((canvas[x + i][y + j] != ' ') && (circle.grids[i][j] == pattern)) {
                    return false;
                }

            }
        }
        for (int i = 0; i < circle.grids.length; i++) {
            for (int j = 0; j < circle.grids[0].length; j++) {
                if ((canvas[x + i][y + j] == ' ') && (circle.grids[i][j] == pattern)) {
                    canvas[x + i][y + j] = pattern;
                }
            }
        }
        shapes.add(circle);
        return true;
    }

    public boolean addShape(int x, int y, char pattern, int width, int height, int index) {
        Shape rightTriangle = new RightTriangle(new Location(x, y), pattern, width, height, Direction.getDirection(index));
        rightTriangle.fillGrids();
        if ((x + height > canvas.length) || (y + width > canvas[0].length)) {
            return false;
        }
        for (int i = 0; i < rightTriangle.grids.length; i++) {
            for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                if ((canvas[x + i][y + j] != ' ') && (rightTriangle.grids[i][j] == pattern)) {
                    return false;
                }

            }
        }
        for (int i = 0; i < rightTriangle.grids.length; i++) {
            for (int j = 0; j < rightTriangle.grids[i].length; j++) {
                if ((canvas[x + i][y + j] == ' ') && (rightTriangle.grids[i][j] == pattern)) {
                    canvas[x + i][y + j] = pattern;
                }

            }
        }
        shapes.add(rightTriangle);
        return true;

    }

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

    public int getShapeCount() {
        return shapes.size();
    }


    public List<Shape> getShapesByArea() {
        Collections.sort(shapes);
        return shapes;
    }

    public List<Shape> getShapesByLocation() {
        Comparator c = new CompareByLocation();
        shapes.sort(c);
        return shapes;
    }

    public char[][] getCanvas() {
        return canvas;
    }



}


class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int radius) {
        Shape circle = new Circle(new Location(x, y), pattern, radius);
        circle.fillGrids();
        boolean A = false;
        for (int i = 0; i < circle.grids.length; i++) {
            for (int j = 0; j < circle.grids[0].length; j++) {
                if ((x + i < canvas.length) && (y + j < canvas[0].length) && (circle.grids[i][j] == pattern)) {
                    A= true;
                    canvas[x + i][y + j] = pattern;
                }
            }
        }
        if (A){
            shapes.add(circle);
        }
        return A;
    }

    public boolean addShape(int x, int y, char pattern, int width, int height, int index) {
        Shape rightTriangle = new RightTriangle(new Location(x, y), pattern, width, height, Direction.getDirection(index));
        rightTriangle.fillGrids();
        boolean A = false;
        for (int i = 0; i < rightTriangle.grids.length; i++) {
            for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                if ((x + i < canvas.length) && (y + j < canvas[0].length) && (rightTriangle.grids[i][j] == pattern)) {
                    canvas[x + i][y + j] = pattern;
                    A= true;
                }
            }
        }
        if (A){
            shapes.add(rightTriangle);
        }
        return A;
    }

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

    public int getShapeCount() {
        return shapes.size();
    }

    public List<Shape> getShapesByArea() {
        Collections.sort(shapes);
        return shapes;
    }

    public List<Shape> getShapesByLocation() {
        Comparator c = new CompareByLocation();
        shapes.sort(c);
        return shapes;
    }

    public char[][] getCanvas() {
        return canvas;
    }

}
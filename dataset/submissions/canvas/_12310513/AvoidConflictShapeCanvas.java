import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
         shapes = new ArrayList<Shape>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    public boolean addShape(int x, int y, char pattern, int radius) {
        Shape circle = new Circle(new Location(x,y),pattern,radius);
        for (int i = x; i < x+2*radius; i++) {
            for (int j = y; j < y + 2*radius; j++) {
                if (i < 0 || i  > canvas.length - 1 || j < 0 || j > canvas[0].length - 1) {
                    return false;
                }
            }
        }for (int i = x; i < x+radius; i++) {
            for (int j = y; j < y + radius; j++) {
                if ((x + radius - i - 1) * (x + radius - i - 1) + (y + radius - j - 1) * (y + radius - j - 1) < radius * radius) {
                    if (canvas[i][j] != ' ' || canvas[2 * x + 2 * radius - 1 - i][2 * y + 2 * radius - 1 - j] != ' ' || canvas[i][2 * y + 2 * radius - 1 - j] != ' ' || canvas[2 * x + 2 * radius - 1 - i][j] != ' ') {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                    if (( radius - i - 1) * (radius - i - 1) + (radius - j - 1) * ( radius - j - 1) < radius * radius) {
                        canvas[i+x][j+y] = circle.getPattern();
                        canvas[x+2 * radius - 1 - i][y + 2 * radius - 1 - j] = circle.getPattern();
                        canvas[i+x][y + 2 * radius - 1 - j] = circle.getPattern();
                        canvas[x + 2 * radius - 1 - i][j+y] = circle.getPattern();
                    }
                }
            }
        shapes.add(circle);
        return true;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int width, int height, int d) {
        Shape rightTriangle = new RightTriangle(new Location(x, y), pattern, width, height, Direction.direction(d));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i+x < 0 || i+x > canvas.length - 1 || j+y < 0 || j+y > canvas[0].length - 1)
                    return false;
                else if ((d == 2 && height * (j + 1) > width * i) || (d == 1 && height * j < width * (i + 1)) || (d == 3 && width * (i + 1) + height * (j + 1) > height * width) || (d == 0 && width * i + height * j < height * width)) {
                    if (canvas[i+x][j+y] != ' ') {
                        return false;
                    }
                }
            }
        }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (d == 2) {
                        if (height * (j + 1) > width * i)
                            canvas[i+x][j+y] = rightTriangle.getPattern();
                    } else if (d == 1) {
                        if (height * j < width * (i + 1)) {
                            canvas[x+i][y+j] = rightTriangle.getPattern();
                        }
                    } else if (d == 3) {
                        if (width * (i + 1) + height * (j + 1) > height * width) {
                            canvas[i+x][y+j] = rightTriangle.getPattern();
                        }
                    } else {
                        if (width * i + height * j < height * width) {
                            canvas[x+i][y+j] = rightTriangle.getPattern();
                        }
                    }
                }
            }
            shapes.add(rightTriangle);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i <canvas.length ; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] ==' ') {
                    count+=1;
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
        shapes.sort(ShapeComparators.area);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(ShapeComparators.location);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

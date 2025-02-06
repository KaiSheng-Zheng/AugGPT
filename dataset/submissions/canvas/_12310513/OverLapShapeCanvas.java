import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        shapes = new ArrayList<Shape>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int radius) {
        boolean a = false;
        Shape circle = new Circle(new Location(x,y),pattern,radius);
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (( radius - i - 1) * (radius - i - 1) + (radius - j - 1) * ( radius - j - 1) < radius * radius) {
                    if (check(i+x,j+y)) {
                        canvas[i+x][j+y] = circle.getPattern();
                        a = true;
                    }
                    if (check(x+2 * radius - 1 - i,y + 2 * radius - 1 - j)) {
                        canvas[x + 2 * radius - 1 - i][y + 2 * radius - 1 - j] = circle.getPattern();
                        a = true;
                    }
                    if (check(i+x,y + 2 * radius - 1 - j)) {
                        canvas[i+x][y + 2 * radius - 1 - j] = circle.getPattern();
                        a = true;
                    }
                    if (check(x + 2 * radius - 1 - i,j+y)) {
                        canvas[x + 2 * radius - 1 - i][j+y] = circle.getPattern();
                        a = true;
                    }
                }
            }
        }
        if (a) {
            shapes.add(circle);
            return true;
        }
        else
            return false;
    }
    public boolean check(int a, int b){
        return a >= 0 && a <= canvas.length - 1 && b >= 0 && b <= canvas[0].length - 1;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int width, int height, int d) {
        boolean a = false;
        Shape rightTriangle = new RightTriangle(new Location(x, y), pattern, width, height, Direction.direction(d));
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (d == 2) {
                    if (height * (j + 1) > width * i)
                        if (i+x >= 0 && i+x <= canvas.length - 1 && j+y >= 0 && j+y <= canvas[0].length - 1) {
                            canvas[i + x][j + y] = rightTriangle.getPattern();
                            a = true;
                        }
                } else if (d == 1) {
                    if (height * j < width * (i + 1)) {
                        if (i + x >= 0 && i + x <= canvas.length - 1 && j + y >= 0 && j + y <= canvas[0].length - 1) {
                            canvas[x + i][y + j] = rightTriangle.getPattern();
                            a = true;
                        }
                    }
                } else if (d == 3) {
                    if (width * (i + 1) + height * (j + 1) > height * width) {
                        if (i + x >= 0 && i + x <= canvas.length - 1 && j + y >= 0 && j + y <= canvas[0].length - 1) {
                            canvas[i + x][y + j] = rightTriangle.getPattern();
                            a = true;
                        }
                    }
                } else {
                    if (width * i + height * j < height * width) {
                        if (i + x >= 0 && i + x <= canvas.length - 1 && j + y >= 0 && j + y <= canvas[0].length - 1) {
                            canvas[x + i][y + j] = rightTriangle.getPattern();
                            a = true;
                        }
                    }
                }
            }
        }
        if (a) {
            shapes.add(rightTriangle);
            return true;
        }
        else
            return false;
    }
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i <canvas.length ; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
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

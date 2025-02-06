import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    private int num = 0;
    private int susnum = 0;
    private int rows = 0, cols = 0;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        this.cols = cols;
        this.rows = rows;
    }

    public boolean addShape(int x, int y, char pattern, int r) {
        num++;
        if(x+2*r>rows||x<0||y+2*r>cols||y<0)
            return false;
        Location location = new Location(x, y);
        Shape s = new Circle(location, pattern, r);
        char[][] shape = s.getGrids();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                    if(x+i<rows&&x+i>=0&&y+j<cols&&y+j>=0)
                    if (canvas[x + i][y + j] != ' '&&shape[i][j]!=' ') {
                        return false;
                    }

            }
        }
        susnum++;
        shapes.add(s);
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if(x+i<rows&&x+i>=0&&y+j<cols&&y+j>=0)
                    if (shape[i][j] != ' ') {
                    canvas[x + i][y + j] = shape[i][j];
                }
            }
        }
        return true;
    }

    public boolean addShape(int x, int y, char pattern, int width, int height, int direction) {
        num++;
        if(x+height>rows||x<0||y+width>cols||y<0) {
            System.out.println(1);return false;

        }Direction d = Direction.LEFT_UP;
        switch (direction) {
            case 0:
                d = Direction.LEFT_UP;break;
            case 1:
                d = Direction.LEFT_DOWN;break;
            case 2:
                d = Direction.RIGHT_UP;break;
            case 3:
                d = Direction.RIGHT_DOWN;break;
        }
        Location location = new Location(x, y);
        Shape s = new RightTriangle(location, pattern, width, height, d);
        char[][] shape = s.getGrids();
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if(x+i<rows&&x+i>=0&&y+j<cols&&y+j>=0)
                    if (canvas[x + i][y + j] != ' '&&shape[i][j]!=' ') {
                        return false;
                    }
            }
        }
        susnum++;
        shapes.add(s);
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if(x+i<rows&&x+i>=0&&y+j<cols&&y+j>=0)
                    if (shape[i][j] != ' ') {
                    canvas[x + i][y + j] = shape[i][j];
                }
            }
        }
        return true;
    }

    public int getSpaceGridCount() {
        return num;
    }

    public int getShapeCount() {
        return susnum;
    }

    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, (a, b) -> {
            if(a.area()!= b.area())
                return a.area() - b.area();
            else return (int)a.pattern-(int)b.pattern;
        });
        return shapes;
    }

    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, (a, b) -> {
            if (a.getLocation().getX() != b.getLocation().getX()) {
                return a.getLocation().getX() - b.getLocation().getX();
            } else if (a.getLocation().getY() != b.getLocation().getY()) {
                return a.getLocation().getY() - b.getLocation().getY();
            } else return (int)a.pattern-(int)b.pattern;
        });

        return shapes;
    }
    public  char[][] getCanvas(){
        return canvas;
    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;
    private int rows;
    private int cols;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        char[][] canvasTemp = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvasTemp[i][j] = canvas[i][j];
            }
        }
        if (params.length == 1) {
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            if (x + params[0] * 2 - 1 > rows - 1 || y + params[0] * 2 - 1 > cols - 1) {
                return false;
            } else {
                for (int i = x; i < x + circle.getRadius() * 2; i++) {
                    for (int j = y; j < y + circle.getRadius() * 2; j++) {
                        if (i < x + circle.getRadius() && j < y + circle.getRadius()) {
                            if (Math.sqrt(1.0 * (x + circle.getRadius() - i - 1) * (x + circle.getRadius() - i - 1) + 1.0 * (y + circle.getRadius() - j - 1) * (y + circle.getRadius() - j - 1)) < 1.0 * circle.getRadius()) {
                                if (canvasTemp[i][j]==' ' && canvasTemp[x*2 + circle.getRadius() * 2 - 1 - i][y*2 + circle.getRadius() * 2 - 1 - j]==' ' && canvasTemp[x*2 + circle.getRadius() * 2 - 1 - i][j]==' ' && canvasTemp[i][y*2 + circle.getRadius() * 2 - 1 - j]==' ') {
                                    canvasTemp[i][j] = pattern;
                                    canvasTemp[x*2 + circle.getRadius() * 2 - 1 - i][y*2 + circle.getRadius() * 2 - 1 - j] = pattern;
                                    canvasTemp[x*2 + circle.getRadius() * 2 - 1 - i][j] = pattern;
                                    canvasTemp[i][y*2 + circle.getRadius() * 2 - 1 - j] = pattern;
                                }
                                else {
                                    return false;
                                }
                            }
                        }
                    }
                }
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        canvas[i][j] = canvasTemp[i][j];
                    }
                }
                shapes.add(circle);
                return true;
            }
        }
        if ((params.length == 3)) {
            Direction d = getDirection(params[2]);
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
            if (x + params[1] - 1 > rows -1 || y + params[0] - 1 > cols - 1){
                return false;
            } else {
                switch (d) {
                    case LEFT_DOWN:
                        for (int i = x; i < x+rightTriangle.getHeight(); i++) {
                            for (int j = y; j < y+rightTriangle.getWidth(); j++) {
                                if (j-y < Math.ceil(1.0 * (i - x + 1) * rightTriangle.getWidth() / rightTriangle.getHeight())) {
                                    if (canvasTemp[i][j] == ' ') {
                                        canvasTemp[i][j] = pattern;
                                    } else {
                                        return false;
                                    }
                                }
                            }
                        }
                        break;
                    case LEFT_UP:
                        for (int i = x+rightTriangle.getHeight() - 1; i >= x; i--) {
                            for (int j = y; j < y+rightTriangle.getWidth(); j++) {
                                if (j-y < Math.ceil(1.0 * (rightTriangle.getHeight() + x - i) * rightTriangle.getWidth() / rightTriangle.getHeight())) {
                                    if (canvasTemp[i][j] == ' ') {
                                        canvasTemp[i][j] = pattern;
                                    } else {
                                        return false;
                                    }
                                }
                            }
                        }
                        break;
                    case RIGHT_UP:
                        for (int i = x+rightTriangle.getHeight() - 1; i >= x; i--) {
                            for (int j = y+rightTriangle.getWidth() - 1; j >= y; j--) {
                                if (rightTriangle.getWidth()+y - 1 - j < Math.ceil(1.0 * (rightTriangle.getHeight()+x - i) * rightTriangle.getWidth() / rightTriangle.getHeight())) {
                                    if (canvasTemp[i][j] == ' ') {
                                        canvasTemp[i][j] = pattern;
                                    } else {
                                        return false;
                                    }
                                }
                            }
                        }
                        break;
                    case RIGHT_DOWN:
                        for (int i = x; i < x+rightTriangle.getHeight(); i++) {
                            for (int j = y+rightTriangle.getWidth() - 1; j >= y; j--) {
                                if (rightTriangle.getWidth()+y - 1 - j < Math.ceil(1.0 * (i - x + 1) * rightTriangle.getWidth() / rightTriangle.getHeight())) {
                                    if (canvasTemp[i][j] == ' ') {
                                        canvasTemp[i][j] = pattern;
                                    } else {
                                        return false;
                                    }
                                }
                            }
                        }
                        break;
                }
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        canvas[i][j] = canvasTemp[i][j];
                    }
                }
                shapes.add(rightTriangle);
                return true;
            }
        }
        return false;
    }
    public Direction getDirection(int n){
        Direction direction = null;
        switch (n){
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
        return direction;
    }
    @Override
    public int getSpaceGridCount() {
        int space = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                space++;
            }
        }
        return space;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                int a1 = o1.location.getX();
                int a2 = o2.location.getX();
                int b1 = o1.location.getY();
                int b2 = o2.location.getY();
                if (a1 < a2){
                    return -1;
                } else if (a1 > a2) {
                    return 1;
                } else {
                    if (b1 < b2){
                        return -1;
                    } else if (b1 > b2) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}

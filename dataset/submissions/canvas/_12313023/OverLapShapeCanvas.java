import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;
    private int rows;
    private int cols;

    public OverLapShapeCanvas(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int... params) {
        int space = 0;
        char[][] canvasTemp = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvasTemp[i][j] = canvas[i][j];
            }
        }
        if (params.length == 1) {
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            space = circle.area();
            for (int i = x; i < x + circle.getRadius() * 2; i++) {
                for (int j = y; j < y + circle.getRadius() * 2; j++) {
                    if (i < x + circle.getRadius() && j < y + circle.getRadius()) {
                        if (Math.sqrt(1.0 * (x + circle.getRadius() - i - 1) * (x + circle.getRadius() - i - 1) + 1.0 * (y + circle.getRadius() - j - 1) * (y + circle.getRadius() - j - 1)) < 1.0 * circle.getRadius()) {
                            if (i < rows && j < cols) {
                                canvasTemp[i][j] = pattern;
                                space--;
                            }
                            if (x * 2 + circle.getRadius() * 2 - 1 - i < rows && y * 2 + circle.getRadius() * 2 - 1 - j < cols) {
                                canvasTemp[x * 2 + circle.getRadius() * 2 - 1 - i][y * 2 + circle.getRadius() * 2 - 1 - j] = pattern;
                                space--;
                            }
                            if (x * 2 + circle.getRadius() * 2 - 1 - i < rows && j < cols) {
                                canvasTemp[x * 2 + circle.getRadius() * 2 - 1 - i][j] = pattern;
                                space--;
                            }
                            if (i < rows && y * 2 + circle.getRadius() * 2 - 1 - j < cols) {
                                canvasTemp[i][y * 2 + circle.getRadius() * 2 - 1 - j] = pattern;
                                space--;
                            }
                        }
                    }
                }
            }
            if (space != circle.area()) {
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
            space = rightTriangle.area();
            switch (d) {
                case LEFT_DOWN:
                    for (int i = x; i < x + rightTriangle.getHeight(); i++) {
                        for (int j = y; j < y + rightTriangle.getWidth(); j++) {
                            if (j - y < Math.ceil(1.0 * (i - x + 1) * rightTriangle.getWidth() / rightTriangle.getHeight())) {
                                if (i < rows && j < cols) {
                                    canvasTemp[i][j] = pattern;
                                    space--;
                                }
                            }
                        }
                    }
                    break;
                case LEFT_UP:
                    for (int i = x + rightTriangle.getHeight() - 1; i >= x; i--) {
                        for (int j = y; j < y + rightTriangle.getWidth(); j++) {
                            if (j - y < Math.ceil(1.0 * (rightTriangle.getHeight() + x - i) * rightTriangle.getWidth() / rightTriangle.getHeight())) {
                                if (i < rows && j < cols) {
                                    canvasTemp[i][j] = pattern;
                                    space--;
                                }
                            }
                        }
                    }
                    break;
                case RIGHT_UP:
                    for (int i = x + rightTriangle.getHeight() - 1; i >= x; i--) {
                        for (int j = y + rightTriangle.getWidth() - 1; j >= y; j--) {
                            if (rightTriangle.getWidth() + y - 1 - j < Math.ceil(1.0 * (rightTriangle.getHeight() + x - i) * rightTriangle.getWidth() / rightTriangle.getHeight())) {
                                if (i < rows && j < cols) {
                                    canvasTemp[i][j] = pattern;
                                    space--;
                                }
                            }
                        }
                    }
                    break;
                case RIGHT_DOWN:
                    for (int i = x; i < x + rightTriangle.getHeight(); i++) {
                        for (int j = y + rightTriangle.getWidth() - 1; j >= y; j--) {
                            if (rightTriangle.getWidth() + y - 1 - j < Math.ceil(1.0 * (i - x + 1) * rightTriangle.getWidth() / rightTriangle.getHeight())) {
                                if (i < rows && j < cols) {
                                    canvasTemp[i][j] = pattern;
                                    space--;
                                }
                            }
                        }
                    }
                    break;
            }
            if (space != rightTriangle.area()) {
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

    public Direction getDirection(int n) {
        Direction direction = null;
        switch (n) {
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
        // incomplete implementation.
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
                char c1 = o1.pattern;
                char c2 = o2.pattern;
                if (a1 < a2) {
                    return -1;
                } else if (a1 > a2) {
                    return 1;
                } else {
                    if (b1 < b2) {
                        return -1;
                    } else if (b1 > b2) {
                        return 1;
                    } else {
                        if (c1 < c2) {
                            return -1;
                        } else if (c1 > c2) {
                            return 1;
                        } else {
                            return 0;
                        }
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

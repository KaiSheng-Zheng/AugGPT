import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows,int cols) {
        canvas = new char[rows][cols];
        for (char[] canvas : canvas) {
            Arrays.fill(canvas, ' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int p : params) {
            arrayList.add(p);
        }
        if (arrayList.size() == 1) {
            int radius = arrayList.get(0);
            Shape Circle = new Circle(new Location(x, y), pattern, radius);
            if (x + 2 * radius - 1 > canvas.length - 1) {
                return false;
            }
            if (y + 2 * radius - 1 > canvas[0].length - 1) {
                return false;
            }
            if (x < 0) {
                return false;
            }
            if (y < 0) {
                return false;
            }
            for (int i = x + 1; i <= x + radius; i++) {
                for (int j = y + 1; j <= y + radius; j++) {
                    double length = Math.pow(x + radius - i, 2) + Math.pow(y + radius - j, 2);
                    int row = i - 1;
                    int col = j - 1;
                    if (length < radius * radius) {
                        if (row >= 0 && row <= canvas.length && col >= 0 && col <= canvas[0].length) {
                            if (canvas[row][col] != ' ') {
                                return false;
                            }
                        }
                        if (2 * radius - row + x + x - 1 >= 0 && 2 * radius - row + x + x - 1 <= canvas.length && col >= 0 && col <= canvas[0].length) {
                            if (canvas[2 * radius - row + x + x - 1][col] != ' ') {
                                return false;
                            }
                        }
                        if (row >= 0 && row <= canvas.length && 2 * radius - col + y + y - 1 >= 0 && 2 * radius - col + y + y - 1 <= canvas[0].length) {
                            if (canvas[row][2 * radius - col + y + y - 1] != ' ') {
                                return false;
                            }
                        }
                        if (2 * radius - row + x + x - 1 >= 0 && 2 * radius - row + x + x - 1 <= canvas.length && 2 * radius - col + y + y - 1 >= 0 && 2 * radius - col + y + y - 1 <= canvas[0].length) {
                            if (canvas[2 * radius - row + x + x - 1][2 * radius - col + y + y - 1] != ' ') {
                                return false;
                            }
                        }
                    }
                }
            }
            for (int i = x + 1; i <= x + radius; i++) {
                for (int j = y + 1; j <= y +radius; j++) {
                    double length = Math.pow(x + radius - i, 2) + Math.pow(y + radius - j, 2);
                    int row = i - 1;
                    int col = j - 1;
                    if (length <= radius * radius) {
                        if (row >= 0 && row <= canvas.length && col >= 0 && col <= canvas[0].length && 2 * radius - row + x + x - 1 >= 0 && 2 * radius - row + x + x - 1 <= canvas.length && 2 * radius - col + y + y - 1 >= 0 && 2 * radius - col + y + y - 1 <= canvas[0].length) {
                            canvas[row][col] = pattern;
                            canvas[2 * radius - row + x + x - 1][col] = pattern;
                            canvas[row][2 * radius - col + y + y - 1] = pattern;
                            canvas[2 * radius - row + x + x - 1][2 * radius - col + y + y - 1] = pattern;
                        }
                    } else {
                        break;
                    }
                }
            }
            this.shapes.add(Circle);
        }

        if (arrayList.size() == 3) {
            int width = arrayList.get(0);
            int height = arrayList.get(1);
            int indexOfDirection = arrayList.get(2);
            Direction d = null;
            if (indexOfDirection == 0) {
                d = Direction.LEFT_UP;
            }
            if (indexOfDirection == 1) {
                d = Direction.LEFT_DOWN;
            }
            if (indexOfDirection == 2) {
                d = Direction.RIGHT_UP;
            }
            if (indexOfDirection == 3) {
                d = Direction.RIGHT_DOWN;
            }
            Shape RightTriangle = new RightTriangle(new Location(x, y), pattern, width, height, d);
            if (x + height - 1 > canvas.length - 1) {
                return false;
            }
            if (y + width - 1 > canvas[0].length - 1) {
                return false;
            }
            if (x < 0) {
                return false;
            }
            if (y < 0) {
                return false;
            }

            double k = 1.0 * height / width;
            for (int i = x + 1; i <= x + height; i++) {
                if (indexOfDirection == 0 || indexOfDirection == 1) {
                    if (i - 1 >= 0 && i - 1 <= canvas.length && y >= 0 && y <= canvas[0].length) {
                        if (canvas[i - 1][y] != ' ') {
                            return false;
                        }
                    }
                } else {
                    if (i - 1 >= 0 && i - 1 <= canvas.length && y + width - 1 >= 0 && y + width - 1 <= canvas[0].length) {
                        if (canvas[i - 1][y + width - 1] != ' ') {
                            return false;
                        }
                    }
                }
                for (int col = y + 1; col < y + width; col++) {
                    if ((i - x) * 1.0 / (col - y) > k) {
                        int row = i - 1;
                        if (indexOfDirection == 1) {
                            if (row >= 0 && row <= canvas.length && col >= 0 && col <= canvas[0].length) {
                                if (canvas[row][col] != ' ') {
                                    return false;
                                }
                            }
                        } else if (indexOfDirection == 0) {
                            if (height - 1 - row + x + x >= 0 && height - 1 - row + x + x <= canvas.length && col >= 0 && col <= canvas[0].length) {
                                if (canvas[height - 1 - row + x + x][col] != ' ') {
                                    return false;
                                }
                            }
                        } else if (indexOfDirection == 3) {
                            if (row >= 0 && row <= canvas.length && width - 1 - col + y + y >= 0 && width - 1 - col + y + y <= canvas[0].length) {
                                if (canvas[row][width - 1 - col + y + y] != ' ') {
                                    return false;
                                }
                            }
                        } else {
                            if (height - 1 - row + x + x >= 0 && height - 1 - row + x + x <= canvas.length && width - 1 - col + y + y >= 0 && width - 1 - col + y + y <= canvas[0].length) {
                                if (canvas[height - 1 - row + x + x][width - 1 - col + y + y] != ' ') {
                                    return false;
                                }
                            }
                        }
                    } else {
                        break;
                    }
                }
            }

            for (int i = x + 1; i <= x + height; i++) {
                if (indexOfDirection == 0 || indexOfDirection == 1) {
                    if (i - 1 >= 0 && i - 1 <= canvas.length && y >= 0 && y <= canvas[0].length)
                    canvas[i - 1][y] = pattern;
                } else {
                    if (i - 1 >= 0 && i - 1 <= canvas.length && y + width - 1 >= 0 && y + width - 1 <= canvas[0].length) {
                        canvas[i - 1][y + width - 1] = pattern;
                    }
                }
                for (int col = y + 1; col < y + width; col++) {
                    if ((i - x) * 1.0 / (col - y) > k) {
                        int row = i - 1;
                        if (indexOfDirection == 1) {
                            if (row >= 0 && row <= canvas.length && col >= 0 && col <= canvas[0].length) {
                                canvas[row][col] = pattern;
                            }
                        } else if (indexOfDirection == 0) {
                            if (height - 1 - row + x + x >= 0 && height - 1 - row + x + x <= canvas.length && col >= 0 && col <= canvas[0].length) {
                            canvas[height - 1 - row + x + x][col] = pattern;
                            }
                        } else if (indexOfDirection == 3) {
                            if (row >= 0 && row <= canvas.length && width - 1 - col + y + y >= 0 && width - 1 - col + y + y <= canvas[0].length) {
                                canvas[row][width - 1 - col + y + y] = pattern;
                            }
                        } else {
                            if (height - 1 - row + x + x >= 0 && height - 1 - row + x + x <= canvas.length && width - 1 - col + y + y <= canvas[0].length) {
                                canvas[height - 1 - row + x + x][width - 1 - col + y + y] = pattern;
                            }
                            }
                    } else {
                        break;
                    }
                }
            }
            shapes.add(RightTriangle);
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int SpaceGridCount = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    SpaceGridCount++;
                }
            }
        }
        return SpaceGridCount;
    }

    @Override
    public int getShapeCount() {
        int ShapeCount = 0;
        ShapeCount = shapes.size();
        return ShapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(i).area > shapes.get(j).area) {
                    Shape shape = shapes.get(i);
                    shapes.set(i, shapes.get(j));
                    shapes.set(j, shape);
                }
                if (shapes.get(i).area == shapes.get(j).area) {
                    if (shapes.get(i).pattern > shapes.get(j).pattern) {
                        Shape shape = shapes.get(i);
                        shapes.set(i, shapes.get(j));
                        shapes.set(j, shape);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(i).location.getX() > shapes.get(j).location.getX()) {
                    Shape shape = shapes.get(i);
                    shapes.set(i, shapes.get(j));
                    shapes.set(j, shape);
                }
                if (shapes.get(i).location.getX() == shapes.get(j).location.getX()) {
                    if (shapes.get(i).location.getY() > shapes.get(j).location.getY()) {
                        Shape shape = shapes.get(i);
                        shapes.set(i, shapes.get(j));
                        shapes.set(j, shape);
                    }
                    if (shapes.get(i).location.getY() == shapes.get(j).location.getY()) {
                        if (shapes.get(i).pattern > shapes.get(j).pattern) {
                            Shape shape = shapes.get(i);
                            shapes.set(i, shapes.get(j));
                            shapes.set(j, shape);
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    public int numberOfFilledGrids = 0;
    int countShapes = 0;
    private List<Shape> shapes = new ArrayList<>();//Careful!!!, I changed this ,donno 
    private char[][] canvas;/*Using a char[][] array to represent the canvas.
    The initial value of each grid in canvas is a space' ' , which mean an empty grid.*/

    public AvoidConflictShapeCanvas(int rows, int cols) {


        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }

        }/*important! I didn't know this,
        actually canvas is the one that needs to be initiated*/
    }

    public boolean isWithinBoundsForCircle(int x, int y, int radius) {
        // Calculate the coordinates of the circle's bounding box
        int minX = x;
        int minY = y;
        int maxX = x + 2 * radius - 1;
        int maxY = y + 2 * radius - 1;

        // Check if the bounding box falls entirely within the canvas bounds
        return minX >= 0 && minY >= 0 && maxX < canvas.length && maxY < canvas[0].length;
    }

    public boolean theBlockIsEmptyForCircle(int x, int y, int radius) {
        for (int i = 1; i <= radius; i++) {
            for (int j = 1; j <= radius; j++) {
                if ((radius - i) * (radius - i) + (radius - j) * (radius - j) < radius * radius) {
                    if (!(canvas[i - 1 + x][j - 1 + y] == ' ') || !(canvas[2 * radius - i + x][j - 1 + y] == ' ') ||
                            !(canvas[i - 1 + x][2 * radius - j + y] == ' ') || !(canvas[2 * radius - i + x][2 * radius - j + y] == ' ')) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public boolean isWithinBoundsForRightTriangle(int x, int y, int... params) {
        // Calculate the coordinates of the circle's bounding box
        int minX = x;
        int minY = y;
        int maxX = x + params[1] - 1;
        int maxY = y + params[0] - 1;
        // Check if the bounding box falls entirely within the canvas bounds
        return minX >= 0 && minY >= 0 && maxX < canvas.length && maxY < canvas[0].length;
    }

    public boolean theBlockIsEmptyForRightTriangle(int x, int y, int... params) {
        int width = params[0];
        int height = params[1];
        Direction d = null;

        if (params[2] % 4 == 0) d = Direction.LEFT_UP;
        if (params[2] % 4 == 1) d = Direction.LEFT_DOWN;
        if (params[2] % 4 == 2) d = Direction.RIGHT_UP;
        if (params[2] % 4 == 3) d = Direction.RIGHT_DOWN;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch (d) {
                    case LEFT_UP, LEFT_DOWN:
                        if (j == 0) {
                            if (!(canvas[i + x][y] == ' '))
                                return false;

                        }
                        break;
                    case RIGHT_UP, RIGHT_DOWN:
                        if (j == width - 1) {
                            if (!(canvas[i + x][width - 1 + y] == ' '))
                                return false;
                        }
                        break;
                }
            }
        }
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j < width; j++) {
                if ((double) i / j > (double) height / width) {
                    switch (d) {
                        case LEFT_DOWN:
                            if (!(canvas[i - 1 + x][j + y] == ' '))
                                return false;

                            break;
                        case LEFT_UP:
                            if (!(canvas[height - i + x][j + y] == ' '))
                                return false;
                            break;
                        case RIGHT_UP:
                            if (!(canvas[height - i + x][width - j - 1 + y] == ' '))
                                return false;
                            break;
                        case RIGHT_DOWN:
                            if (!(canvas[i - 1 + x][width - j - 1 + y] == ' '))
                                return false;
                            break;
                    }

                }
            }
        }
        return true;
    }

    @Override

    public boolean addShape(int x, int y, char pattern, int... params) {
        numberOfFilledGrids = 0;
        Location location1 = new Location(x, y);
        if (params.length == 1) {
            int radius = params[0];
            Circle circle = new Circle(location1, pattern, radius);

            if (!isWithinBoundsForCircle(x, y, radius)) return false;
            if (!theBlockIsEmptyForCircle(x, y, radius)) return false;
            else {

                for (int i = 1; i <= radius; i++) {
                    for (int j = 1; j <= radius; j++) {
                        if ((radius - i) * (radius - i) + (radius - j) * (radius - j) < radius * radius) {

                            if (0 <= i - 1 + x && i - 1 + x < canvas.length &&
                                    j - 1 + y >= 0 && j - 1 + y < canvas[0].length) {
                                if (!(canvas[i - 1 + x][j - 1 + y] == ' ') || !(canvas[2 * radius - i + x][j - 1 + y] == ' ') ||
                                        !(canvas[i - 1 + x][2 * radius - j + y] == ' ') || !(canvas[2 * radius - i + x][2 * radius - j + y] == ' ')) {
                                    return false;
                                } else {
                                    canvas[i - 1 + x][j - 1 + y] = pattern;
                                    canvas[2 * radius - i + x][j - 1 + y] = pattern;
                                    canvas[i - 1 + x][2 * radius - j + y] = pattern;
                                    canvas[2 * radius - i + x][2 * radius - j + y] = pattern;
                                    numberOfFilledGrids += 4;
                                }
                            }
                        }
                    }
                }

                circle.fillGrids();
                shapes.add(circle);
            }

        }
        if (params.length == 3) {
            int width = params[0];
            int height = params[1];
            Direction d = null;

            if (params[2] % 4 == 0) d = Direction.LEFT_UP;
            if (params[2] % 4 == 1) d = Direction.LEFT_DOWN;
            if (params[2] % 4 == 2) d = Direction.RIGHT_UP;
            if (params[2] % 4 == 3) d = Direction.RIGHT_DOWN;
            RightTriangle rightTriangle = new RightTriangle(location1, pattern, width, height, d);

            if (!isWithinBoundsForRightTriangle(x, y, params)) return false;
            if (!theBlockIsEmptyForRightTriangle(x, y, params)) return false;
            else {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        switch (d) {
                            case LEFT_UP, LEFT_DOWN:
                                if (j == 0) {
                                    if (!(canvas[i + x][y] == ' '))
                                        return false;

                                    canvas[i + x][0 + y] = pattern;
                                    numberOfFilledGrids += 1;
                                }
                                break;
                            case RIGHT_UP, RIGHT_DOWN:
                                if (j == width - 1) {
                                    if (!(canvas[i + x][width - 1 + y] == ' '))
                                        return false;
                                    canvas[i + x][width - 1 + y] = pattern;
                                    numberOfFilledGrids += 1;
                                }
                                break;
                        }
                    }

                }
                for (int i = 1; i <= height; i++) {
                    for (int j = 1; j < width; j++) {
                        if ((double) i / j > (double) height / width) {
                            switch (d) {
                                case LEFT_DOWN:
                                    if (!(canvas[i - 1 + x][j + y] == ' '))
                                        return false;
                                    else {
                                        canvas[i - 1 + x][j + y] = pattern;
                                        numberOfFilledGrids += 1;
                                    }

                                    break;
                                case LEFT_UP:
                                    if (!(canvas[height - i + x][j + y] == ' '))
                                        return false;
                                    else {
                                        canvas[height - i + x][j + y] = pattern;
                                        numberOfFilledGrids += 1;

                                    }

                                    break;
                                case RIGHT_UP:
                                    if (!(canvas[height - i + x][width - j - 1 + y] == ' '))
                                        return false;
                                    else {
                                        canvas[height - i + x][width - j - 1 + y] = pattern;
                                        numberOfFilledGrids += 1;
                                    }

                                    break;
                                case RIGHT_DOWN:
                                    if (!(canvas[i - 1 + x][width - j - 1 + y] == ' '))
                                        return false;
                                    else {
                                        canvas[i - 1 + x][width - j - 1 + y] = pattern;
                                        numberOfFilledGrids += 1;
                                    }
                                    break;
                            }

                        }
                    }
                }
                rightTriangle.fillGrids();
                shapes.add(rightTriangle);
            }
        }
        countShapes += 1;
        return true;
    }


    @Override
    public int getSpaceGridCount() {
        int spaceGridCount = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    spaceGridCount += 1;
                }
            }
        }
        return spaceGridCount;
    }

    @Override
    public int getShapeCount() {
        return countShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int xValueLocation = Double.compare(s1.location.getX(), s2.location.getX());
                if (xValueLocation != 0) {
                    return xValueLocation;
                } else {
                    int yValueLocation = Double.compare(s1.location.getY(), s2.location.getY());
                    if (yValueLocation != 0) {
                        return yValueLocation;
                    }
                    return Double.compare(s1.pattern, s2.pattern);
                }
            }
        });

        return shapes;
    }

    @Override
    public List<Shape> getShapesByArea() {
        // Sort the shapes using a custom comparator
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                // Compare by area first
                int areaComparison = Double.compare(s1.area(), s2.area());
                if (areaComparison != 0) {
                    return areaComparison;
                }
                // If areas are the same, compare by character value of pattern
                return Character.compare(s1.pattern, s2.pattern);
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {

        return canvas;
    }
}



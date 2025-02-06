import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    public int numberOfFilledGrids = 0;
    int countShapes = 0;
    private List<Shape> shapes = new ArrayList<>();//Careful!!!, I changed this ,donno


    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }

        }/*important! I didn't know this,
        actually canvas is the one that needs to be initiated*/
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        numberOfFilledGrids = 0;
        Location location1 = new Location(x, y);
        int hasBlock = 0;
        if (params.length == 1) {
            int radius = params[0];
            Circle circle = new Circle(location1, pattern, radius);
            for (int i = 1; i <= radius; i++) {
                for (int j = 1; j <= radius; j++) {
                    if ((radius - i) * (radius - i) + (radius - j) * (radius - j) < radius * radius) {
                        if (0 <= i - 1 + x && i - 1 + x < canvas.length &&
                                j - 1 + y >= 0 && j - 1 + y < canvas[0].length) {
                            canvas[i - 1 + x][j - 1 + y] = pattern;
                            hasBlock += 1;
                            numberOfFilledGrids += 1;

                        }
                        if (0 <= 2 * radius - i + x && 2 * radius - i + x < canvas.length &&
                                j - 1 + y >= 0 && j - 1 + y < canvas[0].length) {
                            canvas[2 * radius - i + x][j - 1 + y] = pattern;
                            hasBlock += 1;
                            numberOfFilledGrids += 1;

                        }
                        if (0 <= 2 * radius - i + x && 2 * radius - i + x < canvas.length &&
                                2 * radius - j + y >= 0 && 2 * radius - j + y < canvas[0].length) {
                            canvas[2 * radius - i + x][2 * radius - j + y] = pattern;
                            hasBlock += 1;
                            numberOfFilledGrids += 1;

                        }
                        if (0 <= i - 1 + x && i - 1 + x < canvas.length &&
                                2 * radius - j + y >= 0 && 2 * radius - j + y < canvas[0].length) {
                            canvas[i - 1 + x][2 * radius - j + y] = pattern;
                            hasBlock += 1;
                            numberOfFilledGrids += 1;

                        }
                    }
                }
            }
            if (!(hasBlock == 0)) {
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

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    switch (d) {
                        case LEFT_UP, LEFT_DOWN:
                            if (j == 0 && i + x >= 0 && i + x < canvas.length && y >= 0 && y < canvas[0].length) {
                                canvas[i + x][y] = pattern;
                                numberOfFilledGrids += 1;
                                hasBlock += 1;

                            }
                            break;
                        case RIGHT_UP, RIGHT_DOWN:
                            if (j == width - 1 && i + x >= 0 && i + x < canvas.length
                                    && width - 1 + y >= 0 && width - 1 + y < canvas[0].length) {
                                canvas[i + x][width - 1 + y] = pattern;
                                numberOfFilledGrids += 1;
                                hasBlock += 1;
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
                                if (i - 1 + x >= 0 && i - 1 + x < canvas.length
                                        && j + y >= 0 && j + y < canvas[0].length) {
                                    canvas[i - 1 + x][j + y] = pattern;
                                    numberOfFilledGrids += 1;
                                    hasBlock += 1;
                                }

                                break;
                            case LEFT_UP:
                                if (height - i + x >= 0 && height - i + x < canvas.length
                                        && j + y >= 0 && j + y < canvas[0].length) {
                                    canvas[height - i + x][j + y] = pattern;
                                    numberOfFilledGrids += 1;
                                    hasBlock += 1;
                                }
                                break;
                            case RIGHT_UP:
                                if (height - i + x >= 0 && height - i + x < canvas.length
                                        && width - j - 1 + y >= 0 && width - j - 1 + y < canvas[0].length) {
                                    canvas[height - i + x][width - j - 1 + y] = pattern;
                                    numberOfFilledGrids += 1;
                                    hasBlock += 1;
                                }

                                break;
                            case RIGHT_DOWN:
                                if (i - 1 + x >= 0 && i - 1 + x < canvas.length
                                        && width - j - 1 + y >= 0 && width - j - 1 + y < canvas[0].length) {
                                    canvas[i - 1 + x][width - j - 1 + y] = pattern;
                                    numberOfFilledGrids += 1;
                                    hasBlock += 1;
                                }
                                break;
                        }
                    }
                }
            }
            if (!(hasBlock == 0)) {
                rightTriangle.fillGrids();
                shapes.add(rightTriangle);
            }
        }
        if (hasBlock == 0) {
            return false;
        } else {
            countShapes += 1;
            return true;
        }
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

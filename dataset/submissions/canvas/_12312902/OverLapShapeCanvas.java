
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';

            }

        }


    }

    public boolean addShape(int x, int y, char pattern, int... params) {
        char[][] canva = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canva[i][j] = ' ';
            }
        }

        boolean b = false;

        if (params.length == 1) {
            Location location = new Location(x, y);
            int radius = params[0];
            char[][]grids = new char[radius * 2][radius * 2];
            for (char[] grid : grids) {
                Arrays.fill(grid, pattern);
            }
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

                    } else {
                        break;
                    }



                }
            }

            for (int i = 0; i < 2*radius; i++) {
                for (int j = 0; j < 2*radius; j++) {
                    if (grids[i][j] != ' ' && x + i < canvas.length && y +j < canvas[0].length) {
                        canvas[i+x][j+y] = grids[i][j];
                        b = true;
                    }

                }

            }
            if (b) {
                shapes.add(new Circle(location, pattern, radius));
            }


            return b;

        } else {

            int width = params[0];
            int height = params[1];
            int d = params[2];


            Direction D = null;
            if (d == 0) {
                D = Direction.LEFT_UP;
            } else if (d == 1) {
                D = Direction.LEFT_DOWN;
            } else if (d == 2) {
                D = Direction.RIGHT_UP;
            } else if (d == 3) {
                D = Direction.RIGHT_DOWN;

            }
            Location location = new Location(x, y);
            char[][]grids = new char[height][width];
            double k = 1.0 * height / width;
            for (char[] grid : grids) {
                Arrays.fill(grid, ' ');
            }
            for (int i = 1; i <= grids.length; i++) {
                if (d == 1|| d ==0) {
                    grids[i - 1][0] = pattern;

                } else {
                    grids[i - 1][width - 1] = pattern;
                }
                for (int col = 1; col < grids[0].length; col++) {
                    if (i * 1.0 / col > k) {
                        int row = i - 1;
                        if (d == 1) {
                            grids[row][col] = pattern;

                        } else if (d == 0) {
                            grids[height - 1 - row][col] = pattern;

                        } else if (d == 3) {
                            grids[row][width - 1 - col] = pattern;

                        } else {
                            grids[height - 1 - row][width - 1 - col] = pattern;

                    } }else {
                        break;
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                for (int  j= 0;  j< width; j++) {
                    if(x + i < canvas.length && y + j < canvas[0].length && grids[i][j] != ' '){
                        b =true;
                        canvas[i + x][j + y] = grids[i][j];
                    }

                }

            }
            if (b){
                shapes.add(new RightTriangle(location, pattern ,width ,height , D));
            }
            return b;
        }
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
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int areaComparison = Double.compare(s1.area(), s2.area());
                if (areaComparison != 0) {
                    return areaComparison;
                }
                return Character.compare(s1.getPattern(), s2.getPattern());
            }
        });
        return sortedShapes;
    }


    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.location.getX() != s2.location.getX()) {
                    return Integer.compare(s1.location.getX(), s2.location.getX());
                } else if (s1.location.getY() != s2.location.getY()) {
                    return Integer.compare(s1.location.getY(), s2.location.getY());
                } else {
                    return Character.compare(s1.getPattern(), s2.getPattern());
                }
            }
        });
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}


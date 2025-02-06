
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
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
        if (params.length == 1) {
            Location location = new Location(x, y);
            int radius = params[0];
            if (x < 0 || x > canvas[0].length - 1 || y < 0 || y > canvas.length - 1) {
                return false;
            } else {
                if (x + 2 * radius > canvas[0].length - 1 || y + 2 * radius > canvas.length - 1) {
                    return false;
                } else {
                    for (int i = x; i < x + 2 * radius; i++) {
                        for (int j = y; j < y + 2 * radius; j++) {
                            canva[i][j] = pattern;

                        }

                    }
                    for (int i = x + 1; i < x + radius; i++) {
                        for (int j = y + 1; j < y + radius; j++) {
                            double length = Math.pow(x + radius - i, 2) + Math.pow(y + radius - j, 2);
                            int row = i - 1;
                            int col = j - 1;
                            if (length >= radius * radius) {
                                canva[row][col] = ' ';
                                canva[x + 2 * radius - row - 1][col] = ' ';
                                canva[row][y + 2 * radius - col - 1] = ' ';
                                canva[x + 2 * radius - row - 1][y + 2 * radius - col - 1] = ' ';
                            } else {
                                break;
                            }
                        }
                    }
                }
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if(canvas[i][j] != ' ' && canva[i][j] != ' ')
                            return false;

                    }

                }

                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if(canva[i][j] != ' '){
                        canvas[i][j] = canva[i][j];
                        }

                    }

                }
                shapes.add(new Circle(location, pattern, radius));
                return true;

                }
            }


         else {
            int width = params[0];
            int height = params[1];
            int d = params[2];
            Direction D = null;
            if(d == 0){
                D =Direction.LEFT_UP;
            }else if(d == 1){
                D = Direction.LEFT_DOWN;
            } else if (d == 2) {
                D = Direction.RIGHT_UP;
            } else if (d == 3) {
                D = Direction.RIGHT_DOWN;
                
            }
            Location location = new Location(x ,y);
            if (x < 0 || x + height > canvas.length || y < 0 || y + width > canvas[0].length) {
                return false;
            } else {
                double k = 1.0 * height /width;
                for (int i = x + 1; i <= x + height; i++) {
                    if (d == 0 || d == 1) {
                        if(canvas[i - 1][y] != ' '){
                            return false;
                        }
                        canva[i - 1][y] = pattern;
                    } else {
                        if( canvas[i - 1][y + width - 1] != ' '){
                            return false;
                        }
                       canva[i - 1][y + width - 1] = pattern;

                    }
                    for (int col = y + 1; col < y + width; col++) {
                        if ((i * 1.0 - x )/ (col - y) > k) {
                            int row = i - 1;
                            if (d == 1) {
                                if(canvas[row][col] != ' '){
                                    return false;
                                }else {
                                    canva[row][col] = pattern;
                                }

                            } else if (d == 0) {
                                if(canvas[2 * x + height - 1 - row][col] != ' '){
                                    return false;
                                }else {
                                    canva[2 * x + height - 1 - row][col] = pattern;
                                }
                            } else if (d == 3) {
                                if(canvas[row][2 * y + width - 1 - col]  != ' '){
                                    return false;
                                }else {
                                    canva[row][2 * y + width - 1 - col] = pattern;
                                }
                            } else {
                                if(canvas[2 * x + height - 1 - row][2 * y + width - 1 - col] != ' '){
                                    return  false;
                                }else {
                                    canva[2 * x + height - 1 - row][2 * y + width - 1 - col] = pattern;
                                }
                            }
                        } else {
                            break;
                        }
                    }
                }
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (canva[i][j] != ' '){
                            canvas[i][j] = canva[i][j];
                        }

                    }

                }

                shapes.add(new RightTriangle(location, pattern, width, height, D));
                return true;
            }
            }

    }




    @Override
    public int getSpaceGridCount() {
        return 1;
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


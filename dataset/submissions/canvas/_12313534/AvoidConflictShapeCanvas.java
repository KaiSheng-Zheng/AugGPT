import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int i1 = 0; i1 < canvas[i].length; i1++) {
                canvas[i][i1] = ' ';
            }
        }

    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location l = new Location(x, y);
        Direction d = null;

        if (params.length == 1) {

            Circle c = new Circle(l, pattern, params[0]);
            char[][] a = c.getGrids();
            char[][] b = new char[params[0] * 2][params[0] * 2];
            int count = 0;
            if (y + params[0] * 2 >= canvas.length || x + params[0] * 2 >= canvas[0].length) {
                return false;
            } else {
                for (int i = 0; i < a.length; i++) {
                    for (int i1 = 0; i1 < a[i].length; i1++) {
                        if (a[i][i1] == pattern && canvas[i + x][i1 + y] !=' ' ) {
                            count++;
                            return false;

                        }
                    }
                }
                if (count == 0) {
                    for (int i = 0; i < a.length; i++) {
                        for (int i1 = 0; i1 < a[i].length; i1++) {
                            canvas[i + x][i1 + y] = a[i][i1];


                        }
                    }
                    shapes.add(c);
                    return true;

                }
            }

        } else if (params.length == 3) {
            if (y + params[0] > canvas.length || x + params[1] > canvas[0].length) {
                return false;
            } else {
                if (params[2] == 0) {

                    d = Direction.LEFT_UP;
                } else if (params[2] == 1) {
                    d = Direction.LEFT_DOWN;
                } else if (params[2] == 2) {
                    d = Direction.RIGHT_UP;
                } else if (params[2] == 3) {
                    d = Direction.RIGHT_DOWN;
                }
                RightTriangle r = new RightTriangle(l, pattern, params[0], params[1], d);

                char a[][] = r.getGrids();
                int count = 0;
                for (int i = 0; i < a.length; i++) {
                    for (int i1 = 0; i1 < a[i].length; i1++) {
                        if (a[i][i1] == pattern && canvas[i + x][i1 + y] != ' ') {
                            count++;
                            return false;

                        }
                    }
                }
                if (count == 0) {
                    for (int i = 0; i < a.length; i++) {
                        for (int i1 = 0; i1 < a[i].length; i1++) {
                            if (canvas[i + x][i1 + y]==' ') {
                                canvas[i + x][i1 + y] = a[i][i1];
                            }else if (canvas[i + x][i1 + y]!=' '&&a[i][i1]!=' '){
                                return false;
                            }


                        }
                    }
                    shapes.add(r);
                    return true;

                }
            }


        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int i1 = 0; i1 < canvas[i].length; i1++) {
                if (canvas[i][i1] == ' ') {
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
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Integer.compare(s1.pattern, s2.pattern);
            }
        });
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Integer.compare(s1.area(), s2.area());
            }
        });

        return shapes;
    }


    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Integer.compare(s1.pattern, s2.pattern);
            }
        });
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Integer.compare(s1.location.getY(), s2.location.getY());
            }
        });
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Integer.compare(s1.location.getX(), s2.location.getX());
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {

        return canvas;
    }





}

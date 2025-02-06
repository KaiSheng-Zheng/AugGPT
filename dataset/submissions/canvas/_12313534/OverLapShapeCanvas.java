import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {

    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
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
            int count = 0;
            Circle c = new Circle(l, pattern, params[0]);
            char[][] a = c.getGrids();
//            for (int i = x; i < Math.min(canvas.length, a.length); i++) {
//                for (int i1 = y; i1 < Math.min(canvas[i].length, a.length); i1++) {
//                    if (canvas[i][i1] == ' ') {
//                        canvas[i][i1] = a[i - x][i1 - y];
//                        if (a[i - x][i1 - y] != ' ') {
//                            count++;
//                        }
//
//                    }
//
//                }
//
//
//            }
            for (int i = 0; i < a.length; i++) {
                for (int i1 = 0; i1 < a[0].length; i1++) {
                    if (x+i<canvas.length&&y+i1<canvas.length) {
                        if (a[i][i1]!=' '){
                            canvas[i + x][i1 + y] =a[i][i1];

                                count++;

                        }



                    }
                }
            }
            if (count == 0) {
                return false;
            } else {
                shapes.add(c);
                return true;
            }


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
                for (int i1 = 0; i1 < a[0].length; i1++) {
                    if (x+i<canvas.length&&y+i1<canvas[0].length) {
                        if (a[i][i1]!=' '){
                            canvas[i + x][i1 + y] =a[i][i1];

                            count++;

                        }



                    }
                }
            }
            if (count == 0) {
                return false;
            } else {
                shapes.add(r);
                return true;


            }

        }

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

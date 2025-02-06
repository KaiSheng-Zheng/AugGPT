import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        initialCanvas();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            boolean flag = false;
            int radius = params[0];
            Location location = new Location(x, y);
            char[][] grids = new char[radius * 2][radius * 2];
            for (int i = 0 + location.getX(); i < grids.length + location.getX(); i++) {
                for (int j = 0 + location.getY(); j < radius * 2 + location.getY(); j++) {
                    if ((location.getX() + radius - i) * (location.getX() + radius - i) + (location.getY() + radius - j) * (location.getY() + radius - j) < radius * radius || (location.getX() + radius - i - 1) * (location.getX() + radius - i - 1) + (location.getY() + radius - j) * (location.getY() + radius - j) < radius * radius || (location.getX() + radius - i) * (location.getX() + radius - i) + (location.getY() + radius - j - 1) * (location.getY() + radius - j - 1) < radius * radius || (location.getX() + radius - i - 1) * (location.getX() + radius - i - 1) + (location.getY() + radius - j - 1) * (location.getY() + radius - j - 1) < radius * radius) {
                        if (i >= 0 && i < canvas.length&&j >= 0 && j < canvas[i].length) {
                                flag = true;

                        }
                    }
                }
            }
            if (!flag) {
                return flag;
            }
            for (int i = 0 + location.getX(); i < grids.length + location.getX(); i++) {
                for (int j = 0 + location.getY(); j < radius * 2 + location.getY(); j++) {
                    if ((location.getX() + radius - i) * (location.getX() + radius - i) + (location.getY() + radius - j) * (location.getY() + radius - j) < radius * radius || (location.getX() + radius - i - 1) * (location.getX() + radius - i - 1) + (location.getY() + radius - j) * (location.getY() + radius - j) < radius * radius || (location.getX() + radius - i) * (location.getX() + radius - i) + (location.getY() + radius - j - 1) * (location.getY() + radius - j - 1) < radius * radius || (location.getX() + radius - i - 1) * (location.getX() + radius - i - 1) + (location.getY() + radius - j - 1) * (location.getY() + radius - j - 1) < radius * radius) {
                        if (i >= 0 && i < canvas.length&&j >= 0 && j < canvas[i].length) {
                                canvas[i][j]=pattern;
                        }
                    }
                }
            }
            shapes.add(new Circle(location, pattern, params[0]));
            return true;
        } else {
            Location location = new Location(x, y);
            int width = params[0];
            int height = params[1];
            char[][] grids = new char[height][width];
            switch (params[2]) {
                case 1:
                    boolean flag=false;
                    Direction d = Direction.LEFT_DOWN;
                    for (int i = x; i < grids.length + x; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (height - i + x - 1) / (width - j + y) < (double) height / width) {
                                if (i >= 0 && i < canvas.length&&j >= 0 && j < canvas[i].length) {
                                        flag = true;
                                }
                            }
                        }
                    }
                    if (!flag) {
                        return flag;
                    }
                    for (int i = x; i < grids.length + x; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (height - i + x - 1) / (width - j + y) < (double) height / width) {
                                if (i >= 0 && i < canvas.length&&j >= 0 && j < canvas[i].length) {
                                        canvas[i][j]=pattern;
                                }
                            }
                        }
                    }
                    shapes.add(new RightTriangle(location, pattern, params[0], params[1], d));
                    break;
                case 0:
                    boolean flag2 =false;
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < width + y; j++) {
                            if ((double) (i - x) / (width - j + y) < (double) height / width) {
                                if (i >= 0 && i < canvas.length&&j >= 0 && j < canvas[i].length) {
                                        flag2 = true;
                                }
                            }
                        }
                    }
                    if (!flag2) {
                        return flag2;
                    }
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < width + y; j++) {
                            if ((double) (i - x) / (width - j + y) < (double) height / width) {
                                if (i >= 0 && i < canvas.length&&j >= 0 && j < canvas[i].length) {
                                        canvas[i][j] = pattern;
                                }
                            }
                        }
                    }
                    shapes.add(new RightTriangle(location, pattern, params[0], params[1], Direction.LEFT_UP));
                    break;
                case 2:
                    boolean flag4=false;
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (i - x) / (j - y + 1) < (double) height / width) {
                                if (i >= 0 && i < canvas.length&&j >= 0 && j < canvas[i].length) {
                                        flag4 = true;
                                }
                            }
                        }
                    }
                    if (!flag4) {
                        return flag4;
                    }
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (i - x) / (j - y + 1) < (double) height / width) {
                                if (i >= 0 && i < canvas.length) {
                                    if (j >= 0 && j < canvas[i].length) {
                                        canvas[i][j] = pattern;
                                    }
                                }
                            }
                        }
                    }
                    shapes.add(new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_UP));
                    break;
                case 3:
                    boolean flag5=false;
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (height - i + x - 1) / (j - y + 1) < (double) height / width) {
                                if (i >= 0 && i < canvas.length) {
                                    if (j >= 0 && j < canvas[i].length) {
                                        flag5 = true;
                                    }
                                }
                            }
                        }
                    }
                    if (!flag5) {
                        return flag5;
                    }
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (height - i + x - 1) / (j - y + 1) < (double) height / width) {
                                if (i >= 0 && i < canvas.length) {
                                    if (j >= 0 && j < canvas[i].length) {
                                        canvas[i][j] = pattern;
                                    }
                                }
                            }
                        }
                    }
                    shapes.add(new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_DOWN));
                    break;
            }
            return true;
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
        return getShapes().size();
//        ArrayList<Character> list = new ArrayList<>();
//        for (int i = 0; i < shapes.size(); i++) {
//            if (i == 0) {
//                list.add(shapes.get(0).pattern);
//            }
//            if (!list.contains(shapes.get(i).pattern)) {
//                list.add(shapes.get(i).pattern);
//            }
//        }
//        return list.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 1; i < shapes.size(); i++) {
            for (int j = 1; j < shapes.size(); j++) {
                if (shapes.get(j).area() < shapes.get(j - 1).area()) {
                    Collections.swap(shapes, j, j - 1);
                } else if (shapes.get(j).area() == shapes.get(j - 1).area()) {
                    if (shapes.get(j).pattern < shapes.get(j - 1).pattern) {
                        Collections.swap(shapes, j, j - 1);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 1; i < shapes.size(); i++) {
            for (int j = 1; j < shapes.size(); j++) {
                if (shapes.get(j).location.getX() < shapes.get(j - 1).location.getX()) {
                    Collections.swap(shapes, j, j - 1);
                } else if (shapes.get(j).location.getX() == shapes.get(j - 1).location.getX()) {
                    if (shapes.get(j).location.getY() < shapes.get(j - 1).location.getY()) {
                        Collections.swap(shapes, j, j - 1);
                    } else if (shapes.get(j).location.getY() == shapes.get(j - 1).location.getY()) {
                        if (shapes.get(j).pattern < shapes.get(j - 1).pattern) {
                            Collections.swap(shapes, j, j - 1);
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

    public void initialCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            Arrays.fill(canvas[i], ' ');
        }
    }
    public List<Shape> getShapes(){
        return shapes;
    }
}

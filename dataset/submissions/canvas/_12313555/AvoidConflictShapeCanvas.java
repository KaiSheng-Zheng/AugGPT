import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        initialCanvas();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            int radius = params[0];
            Location location = new Location(x, y);
            char[][] grids = new char[radius * 2][radius * 2];
            if (x + grids.length > canvas.length || y + grids[0].length > canvas[0].length) {
                return false;
            }
            for (int i = 0 + location.getX(); i < grids.length + location.getX(); i++) {
                for (int j = 0 + location.getY(); j < radius * 2 + location.getY(); j++) {
                    if ((location.getX() + radius - i) * (location.getX() + radius - i) + (location.getY() + radius - j) * (location.getY() + radius - j) < radius * radius || (location.getX() + radius - i - 1) * (location.getX() + radius - i - 1) + (location.getY() + radius - j) * (location.getY() + radius - j) < radius * radius || (location.getX() + radius - i) * (location.getX() + radius - i) + (location.getY() + radius - j - 1) * (location.getY() + radius - j - 1) < radius * radius || (location.getX() + radius - i - 1) * (location.getX() + radius - i - 1) + (location.getY() + radius - j - 1) * (location.getY() + radius - j - 1) < radius * radius) {
                        if (canvas[i][j] != ' ') {
                            return false;
                        }
                    }
                }
            }
            for (int i = 0 + location.getX(); i < grids.length + location.getX(); i++) {
                for (int j = 0 + location.getY(); j < radius * 2 + location.getY(); j++) {
                    if ((location.getX() + radius - i) * (location.getX() + radius - i) + (location.getY() + radius - j) * (location.getY() + radius - j) < radius * radius || (location.getX() + radius - i - 1) * (location.getX() + radius - i - 1) + (location.getY() + radius - j) * (location.getY() + radius - j) < radius * radius || (location.getX() + radius - i) * (location.getX() + radius - i) + (location.getY() + radius - j - 1) * (location.getY() + radius - j - 1) < radius * radius || (location.getX() + radius - i - 1) * (location.getX() + radius - i - 1) + (location.getY() + radius - j - 1) * (location.getY() + radius - j - 1) < radius * radius) {
                        canvas[i][j]=pattern;
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
            if (x + grids.length > canvas.length || y + grids[0].length > canvas[0].length) {
                return false;
            }
            switch (params[2]) {
                case 1:
                    Direction d = Direction.LEFT_DOWN;
                    for (int i = x; i < grids.length + x; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (height - i + x - 1) / (width - j + y) < (double) height / width) {
                                if (canvas[i][j] != ' ') {
                                    return false;
                                }
                            }
                        }
                    }
                    for (int i = x; i < grids.length + x; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (height - i + x - 1) / (width - j + y) < (double) height / width) {
                                canvas[i][j] = pattern;
                            }
                        }
                    }
                    shapes.add(new RightTriangle(location, pattern, params[0], params[1], d));
                    break;
                case 0:
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < width + y; j++) {
                            if ((double) (i - x) / (width - j + y) < (double) height / width) {
                                if (canvas[i][j] != ' ') {
                                    return false;
                                }
                            }
                        }
                    }
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < width + y; j++) {
                            if ((double) (i - x) / (width - j + y) < (double) height / width) {
                                canvas[i][j] = pattern;
                            }
                        }
                    }
                    shapes.add(new RightTriangle(location, pattern, params[0], params[1], Direction.LEFT_UP));
                    break;
                case 2:
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (i - x) / (j - y + 1) < (double) height / width) {
                                if (canvas[i][j] != ' ') {
                                    return false;
                                }
                            }
                        }
                    }
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (i - x) / (j - y + 1) < (double) height / width) {
                                canvas[i][j] = pattern;
                            }
                        }
                    }
                    shapes.add(new RightTriangle(location, pattern, params[0], params[1], Direction.RIGHT_UP));
                    break;
                case 3:
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (height - i + x - 1) / (j - y + 1) < (double) height / width) {
                                if (canvas[i][j] != ' ') {
                                    return false;
                                }
                            }
                        }
                    }
                    for (int i = x; i < x + grids.length; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((double) (height - i + x - 1) / (j - y + 1) < (double) height / width) {
                                canvas[i][j] =pattern;
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
        return getShapes().size();
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

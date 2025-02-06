import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AvoidConflictShapeCanvas implements ShapeCanvas {

    private char[][] canvas;

    private Location location;
    private Circle circle;
    private RightTriangle triangle;
    private Direction direction;
    private static int count = 0;
    private List<Shape> shapeList = new ArrayList<>();

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        int m = canvas.length;
        int n = canvas[0].length;
        if (x >= m || y >= n) {
            return false;
        }
        this.location = new Location(x, y);
        ArrayList<Integer> pa = new ArrayList<>();
        for (int i : params) {
            pa.add(i);
        }
        //Circle, judge by location
        if (pa.size() == 1) {
            int radius = pa.get(0);
            if (m - x < 2 * radius || n - y < 2 * radius) {
                return false;
            }
            this.circle = new Circle(location, pattern, radius);
            //Circle, overlap
            if (!circle.canCircleFillGrids(x, y, canvas)) {
                return false;
            } else {
                this.circle.fillGridsA6(x, y, canvas);
                shapeList.add(this.circle);
                return true;
            }

            //Triangular, judge by location
        } else if (pa.size() == 3) {
            int width = pa.get(0);
            int height = pa.get(1);
            if (m - x < height || n - y < width) {
                return false;
            }
            if (pa.get(2) == 0) {
                this.direction = Direction.LEFT_UP;
            }
            if (pa.get(2) == 1) {
                this.direction = Direction.LEFT_DOWN;

            }
            if (pa.get(2) == 2) {
                this.direction = Direction.RIGHT_UP;
            }
            if (pa.get(2) == 3) {
                this.direction = Direction.RIGHT_DOWN;
            }
            this.triangle = new RightTriangle(location, pattern, pa.get(0), pa.get(1), direction);
            //Triangle, overlap
            if (!triangle.CanTriangleFillGrids(x, y, canvas)) {
                return false;
            } else {
                this.triangle.fillGridsA6(x, y, canvas);
                shapeList.add(triangle);
            }
        }

        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int m = canvas.length;
        int n = canvas[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canvas[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return shapeList.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> lastlist = new ArrayList<>();
        ArrayList<Integer> areas = new ArrayList<>();
        for (Shape shape : shapeList) {
            areas.add(shape.area());
        }
        Collections.sort(areas);
        List<Integer> listWithoutDuplicates = areas.stream().distinct().collect(Collectors.toList());
        int n = listWithoutDuplicates.size();
        for (int i = 0; i < n; i++) {
            int count = 0;
            List<Shape> templist = new ArrayList<>();
            for (Shape shape : shapeList) {
                if (shape.area() == listWithoutDuplicates.get(i)) {
                    count++;
                    templist.add(shape);
                }
            }
            if (count == 1) {
                lastlist.add(templist.get(0));
            }
            if (count > 1) {
                List<Character> chars = new ArrayList<>();
                for (Shape s : templist) {
                    chars.add(s.getPattern());
                }
                Collections.sort(chars);
                for (int j = 0; j < templist.size(); j++) {
                    for (Shape s : templist) {
                        if (s.getPattern() == chars.get(j)) {
                            lastlist.add(s);
                        }
                    }
                }

            }
        }


        return lastlist;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> lastlist = new ArrayList<>();
        ArrayList<Integer> xs = new ArrayList<>();
        for (Shape shape : shapeList) {
            xs.add(shape.getLocation().getX());
        }
        Collections.sort(xs);
        List<Integer> listWithoutDuplicates = xs.stream().distinct().collect(Collectors.toList());
        int n = listWithoutDuplicates.size();
        for (int i = 0; i < n; i++) {
            int count = 0;
            List<Shape> templist = new ArrayList<>();
            for (Shape shape : shapeList) {
                if (shape.getLocation().getX() == listWithoutDuplicates.get(i)) {
                    count++;
                    templist.add(shape);
                }
            }
            if (count == 1) {
                lastlist.add(templist.get(0));
            }
            if (count > 1) {
                List<Integer> ys = new ArrayList<>();
                for (Shape s : templist) {
                    ys.add(s.getLocation().getY());
                }
                Collections.sort(ys);
                List<Integer> listWithout = ys.stream().distinct().collect(Collectors.toList());
                int n2 = listWithout.size();
                int count2 = 0;
                for (int j = 0; j < n2; j++) {
                    List<Shape> templist2 = new ArrayList<>();
                    for (Shape s : templist) {
                        if (s.getLocation().getY() == listWithout.get(j)) {
                            count2++;
                            templist2.add(s);
                        }
                    }
                    if (count2 == 1) {
                        lastlist.add(templist2.get(0));
                    }
                    if (count2 > 1) {
                        List<Character> chars = new ArrayList<>();
                        for (Shape s : templist2) {
                            chars.add(s.getPattern());
                        }
                        Collections.sort(chars);
                        for (int k = 0; k < templist2.size(); k++) {
                            for (Shape s : templist2) {
                                if (s.getPattern() == chars.get(k)) {
                                    lastlist.add(s);
                                }
                            }
                        }

                    }
                }

            }
        }
        return lastlist;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


    public static void main(String[] args) {
        ShapeCanvas shapeCanvas = new AvoidConflictShapeCanvas(20, 20);
        System.out.println(shapeCanvas.addShape(0, 2, 'A', 5, 3, 1));
        System.out.println(shapeCanvas.addShape(6, 8, 'B', 5, 7, 2));
        System.out.println(shapeCanvas.addShape(8, 12, 'C', 5));
        System.out.println(shapeCanvas.addShape(6, 6, 'D', 5, 7, 1));
        System.out.println(shapeCanvas.addShape(0, 8, 'E', 3));
        shapeCanvas.getShapesByArea().forEach(System.out::println);
        shapeCanvas.getShapesByLocation().forEach(System.out::println);
        for (char[] line : shapeCanvas.getCanvas()) {
            System.out.println(line);
        }
    }
}


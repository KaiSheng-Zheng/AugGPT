import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;

    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols){
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (char[] canva : canvas) {
            Arrays.fill(canva, ' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean test = false;
        if (params.length == 1) {
            Location location = new Location(x, y);
            Circle circle = new Circle(location, pattern, params[0]);
            boolean judge = false;
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[i].length; j++) {
                    if ((circle.getGrids()[i][j]!=' ')&&(i+y<canvas.length)&&(j+x<canvas[i].length)){
                        if((x+j>=0)&&(x+j<canvas.length)&&(y+i>=0)&&((y+i)< canvas[0].length)) {
                            judge = true;
                            break;
                        }
                    }
                }
            }
                if (judge) {
                    test = true;
                    shapes.add(circle);
                    for (int i = 0; i < 2 * params[0]; i++) {
                        for (int j = 0; j < 2 * params[0]; j++) {
                            if ((circle.getGrids()[i][j] != ' ')&&((i+x)<canvas.length)&&((j+y)<canvas[0].length)) {
                                canvas[i + x][j + y] = pattern;
                            }
                        }
                    }
                }
        }
        if (params.length == 3) {
            Location location = new Location(x, y);
            boolean judge = false;
            Direction d = Direction.LEFT_UP;
            RightTriangle rightTriangle = null;

            d = switch (params[2]) {
                case 0 -> Direction.LEFT_UP;
                case 1 -> Direction.LEFT_DOWN;
                case 2 -> Direction.RIGHT_UP;
                case 3 -> Direction.RIGHT_DOWN;
                default -> d;
            };
            rightTriangle = new RightTriangle(location, pattern, params[0], params[1], d);
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[i].length; j++) {
                    if( (rightTriangle.getGrids()[i][j]!=' ')&&((j+x)<canvas.length)&&((y+i)<canvas[0].length)){
                        if((x+j>=0)&&(x+j<canvas[0].length)&&(y+i>=0)&&((y+i)< canvas.length)) {
                            judge = true;
                            break;
                        }
                    }
                }
            }
            if (judge) {
                    test = true;
                    shapes.add(rightTriangle);
                    for (int i = 0; i < params[0]; i++) {
                        for (int j = 0; j < params[1]; j++) {
                            if ((rightTriangle.getGrids()[j][i] != ' ')&&((j+x)<canvas.length)&&((y+i)<canvas[0].length)) {
                                canvas[j + x][y + i] = rightTriangle.getGrids()[j][i];
                            }
                        }
                    }
                }
        }
        return test;
    }

    @Override
    public int getSpaceGridCount() {
        int k = 0;
        for (char[] canva : canvas) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canva[j] == ' ') {
                    k++;
                }
            }
        }
        return k;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(Comparator.comparingInt(Shape::area).thenComparingInt(s -> s.pattern));
        return new ArrayList<>(shapes);
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort((s1, s2) -> {
            int xCompare = Integer.compare(s1.location.getX(), s2.location.getX());
            if (xCompare != 0) {
                return xCompare;
            }
            int yCompare = Integer.compare(s1.location.getY(), s2.location.getY());
            if (yCompare != 0) {
                return yCompare;
            }
            return Character.compare(s1.pattern, s2.pattern);
        });
        return new ArrayList<>(shapes);
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private final List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    private final int row;
    private final int col;


    public OverLapShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        this.col = cols;
        this.row = rows;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                canvas[i][j] = bgChar;
            }
        }
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean quit = true;
        if (params.length == 1) {
            int r = params[0];
            Circle c = new Circle(new Location(x, y), pattern, r);
            for (int i = 0; i < 2 * r; i++) {
                for (int j = 0; j < 2 * r; j++) {
                    if (0 <= x + i && x + i < row && 0 <= y + j && y + j < col
                            && c.getGrids()[i][j] != ' ')
                    {canvas[x + i][y + j] = c.getGrids()[i][j];
                        quit = false;
                    }
                }
            }
            if(quit) return false;
            shapes.add(c);
            return true;
        }
        int width, height, dir;
        width = params[0];
        height = params[1];
        dir = params[2];
        Direction d = switch (dir) {
            case 0 -> Direction.LEFT_UP;
            case 1 -> Direction.LEFT_DOWN;
            case 2 -> Direction.RIGHT_UP;
            default -> Direction.RIGHT_DOWN;
        };
        RightTriangle rt = new RightTriangle(new Location(x, y), pattern, width, height, d);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (0 <= x + i && x + i < row && 0 <= y + j && y + j < col
                        && rt.getGrids()[i][j] != ' ')
                {canvas[x + i][y + j] = rt.getGrids()[i][j];
                    quit = false;
                }
            }
        }
        if(quit) return false;
        shapes.add(rt);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int cnt = 0;
        for (char[] canva : canvas) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canva[j] == ' ') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort((o1, o2) -> {
            if (o1.area() > o2.area()) {
                return 1;
            } else if (o1.area() < o2.area()) {
                return -1;
            }
            return o1.pattern - o2.pattern;
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort((o1, o2) -> {
            if (o1.location.getX() > o2.location.getX()) {
                return 1;
            } else if (o1.location.getX() < o2.location.getX()) {
                return -1;
            } else {
                if (o1.location.getY() > o2.location.getY()) {
                    return 1;
                } else if (o1.location.getY() < o2.location.getY()) {
                    return -1;
                } else {
                    return o1.pattern - o2.pattern;
                }
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
    public void showCanvas() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(canvas[i][j]);
            }
            System.out.println();
        }
    }
}

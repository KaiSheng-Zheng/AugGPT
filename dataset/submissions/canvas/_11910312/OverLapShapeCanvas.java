
public class OverLapShapeCanvas extends ShapeCanvas {
    private final char[][] canvas;

    // missing method: getSpaceGridCount()
    public OverLapShapeCanvas(int width, int height) {
        super(width, height);
        this.canvas = new char[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape shape;
        Location location = new Location(x, y);
        if (params.length == 1) {
            shape = new Circle(location, pattern, params[0]);
        } else if (params.length == 2) {
            shape = new Rectangle(location, pattern, params[0], params[1]);
        } else if (params.length == 3) {
            Direction direction = Direction.values()[params[2]];
            shape = new RightTriangle(location, pattern, params[0], params[1], direction);
        } else {
            return false;
        }

        char[][] grids = shape.getGrids();
        boolean p = true;
        boolean sign = true;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                int canvasX = x + i;
                int canvasY = y + j;
                if (grids[i][j] != ' ' && canvasX < width && width >= 0 && canvasY < height && canvasY >= 0){
                    p = false;
                    sign = true;
                }
                if (p && (canvasX >= width || canvasY >= height || canvasX < 0 || canvasY < 0)) {
                    sign = false;
                }
            }
        }
        if (!sign){
            return sign;
        }

        shapes.add(shape);
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                int canvasX = x + i;
                int canvasY = y + j;
                if (grids[i][j] != ' ' && canvasX < width && width >= 0 && canvasY < height && canvasY >= 0) {
                    canvas[canvasX][canvasY] = grids[i][j];
                }
            }
        }

        return true;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

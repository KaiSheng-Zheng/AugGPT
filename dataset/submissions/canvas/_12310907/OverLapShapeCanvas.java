public class OverLapShapeCanvas extends Father {
    public OverLapShapeCanvas(int rows, int cols) {
        super(rows, cols);
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean rs = true;
        Location location = new Location(x, y);
        if (params.length == 1) {
            Circle circle = new Circle(location, pattern, params[0]);
            if (overLabConflict(circle)) {
                rs = false;
            } else {
                shapes.add(circle);
                rs = true;
            }
        }
        if (params.length == 3) {
            Direction direction = Direction.LEFT_UP;
            switch (params[2]) {
                case 0:
                    direction = Direction.LEFT_UP;
                    break;
                case 1:
                    direction = Direction.LEFT_DOWN;
                    break;
                case 2:
                    direction = Direction.RIGHT_UP;
                    break;
                case 3:
                    direction = Direction.RIGHT_DOWN;
                    break;
                default:
                    System.out.println("Invalid direction");
            }

            RightTriangle rightTriangle = new RightTriangle(location, pattern, params[0], params[1], direction);
            if (overLabConflict(rightTriangle)) {
                rs = false;
            } else {
                shapes.add(rightTriangle);
                rs = true;
            }
        }
        return rs;
    }

    // 2. bound conflict
    public boolean boundConflict(Shape shape) {
        boolean rs = true;
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;

            int x = circle.getLocation().getX();
            int y = circle.getLocation().getY();
            circle.fillGrids();
            char[][] circleGrids = circle.getGrids();
            for (int i = x; i < min(canvas.length, x + 2 * circle.getRadius()); i++) {
                for (int j = y; j < min(canvas[0].length, y + 2 * circle.getRadius()); j++) {
                    if (circleGrids[i - x][j - y] == circle.pattern) {
                        rs = false;
                        break;
                    }
                }
            }
        }
        if (shape instanceof RightTriangle) {
            RightTriangle rightTriangle = (RightTriangle) shape;
            int x = rightTriangle.getLocation().getX();
            int y = rightTriangle.getLocation().getY();
            rightTriangle.fillGrids();
            char[][] rightTriangleGrids = rightTriangle.getGrids();
            for (int i = x; i < min(canvas.length, x + rightTriangle.getHeight()); i++) {
                for (int j = y; j < min(canvas[0].length, y + rightTriangle.getWidth()); j++) {
                    if (rightTriangleGrids[i - x][j - y] == rightTriangle.pattern) {
                        rs = false;
                        break;
                    }
                }
            }
        }
        return rs;
    }

    // 1. add shape into canvas
    // 3. overlap conflict
    public boolean overLabConflict(Shape shape) {
        boolean rs = false;
        if (boundConflict(shape)) {
            rs = true;
        } else {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                circle.fillGrids();
                char[][] circleGrids = circle.getGrids();
                int x = circle.getLocation().getX();//0
                int y = circle.getLocation().getY();//0
                /*for (int i = x; i < x + 2 * circle.getRadius(); i++) { //2  <4
                    for (int j = y; j < y + 2 * circle.getRadius(); j++) {//1  <3
                        if (canvas[i][j] != ' ' && circleGrids[i - x][j - y] == circle.pattern) {
                            rs = true;
                            break;
                        }
                    }
                }*/
                if (!rs) {
                    for (int i = x; i < min(canvas.length, x + 2 * circle.getRadius()); i++) {
                        for (int j = y; j < min(canvas[0].length, y + 2 * circle.getRadius()); j++) {
                            if (circleGrids[i - x][j - y] != ' ') {


                                canvas[i][j] = circleGrids[i - x][j - y];
                            }
                        }
                    }
                }

            }

            if (shape instanceof RightTriangle) {
                RightTriangle rightTriangle = (RightTriangle) shape;
                rightTriangle.fillGrids();
                char[][] rightTriangleGrids = rightTriangle.getGrids();
                int x = rightTriangle.getLocation().getX();
                int y = rightTriangle.getLocation().getY();
                /*for (int i = x; i < x + rightTriangle.getHeight(); i++) {
                    for (int j = y; j < y + rightTriangle.getWidth(); j++) {
                        if (canvas[i][j] != ' ' && rightTriangleGrids[i - x][j - y] == rightTriangle.pattern) {
                            rs = true;
                            break;
                        }
                    }


                }*/
                if (!rs) {
                    for (int i = x; i < min(canvas.length, x + rightTriangle.getHeight()); i++) {
                        for (int j = y; j < min(canvas[0].length, y + rightTriangle.getWidth()); j++) {
                            if (rightTriangleGrids[i - x][j - y] != ' ') {
                                canvas[i][j] = rightTriangleGrids[i - x][j - y];
                            }
                        }
                    }
                }
            }
        }
        return rs;
    }

    //return the less one
    public static int min(int a, int b) {
        return (a <= b) ? a : b;
    }
}

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction direction;

    public RightTriangle(Location location, char pattern, int width, int height, Direction direction) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.direction = direction;
    }

    @Override
    public int getArea() {
        return (width * height) / 2;
    }

    @Override
    public char[][] draw() {
        char[][] shapeCanvas = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                shapeCanvas[i][j] = ' ';
            }
        }

        switch (direction) {
            case LEFT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j <= i * width / height; j++) {
                        shapeCanvas[i][j] = pattern;
                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j <= (height - i - 1) * width / height; j++) {
                        shapeCanvas[i][j] = pattern;
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = width - 1; j >= width - 1 - i * width / height; j--) {
                        shapeCanvas[i][j] = pattern;
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = width - 1; j >= width - 1 - (height - i - 1) * width / height; j--) {
                        shapeCanvas[i][j] = pattern;
                    }
                }
                break;
        }

        return shapeCanvas;
    }
}


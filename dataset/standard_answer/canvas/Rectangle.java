
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(Location location, char pattern, int width, int height) {
        super(location, pattern);
        this.width = width;
        this.height = height;
    }

    @Override
    public char[][] getGrids() {
        char[][] grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = pattern;
            }
        }
        return grid;
    }

    @Override
    public void fillGrids() {

    }

    @Override
    public int area() {
        return width * height;
    }

    @Override
    public void shrink() {
        if (width > 1) {
            width--;
        }
        if (height > 1) {
            height--;
        }
    }

    @Override
    public void enlarge() {
        width++;
        height++;
    }
}

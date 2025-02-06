public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }

    @Override
    protected void fillGrids() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch (d) {
                    case LEFT_DOWN:
                        if ((i + 1) * width > j * height)
                            grids[i][j] = getPattern();
                        else grids[i][j] = ' ';
                        break;
                    case RIGHT_DOWN:
                        if ((i + 1) * width > j * height)
                            grids[i][width - 1 - j] = getPattern();
                        else grids[i][width - 1 - j] = ' ';
                        break;
                    case RIGHT_UP:
                        if ((i + 1) * width > j * height)
                            grids[height - 1 - i][width - 1 - j] = getPattern();
                        else grids[height - 1 - i][width - 1 - j] = ' ';
                        break;
                    case LEFT_UP:
                        if ((i + 1) * width > j * height)
                            grids[height - 1 - i][j] = getPattern();
                        else grids[height - 1 - i][j] = ' ';
                        break;

                }
            }
        }
    }

    @Override
    public void enlarge() {
            width++;
            height++;
        char[][] newtri = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {


                switch (d) {
                    case LEFT_DOWN:
                        if ((i + 1) * width > j * height)
                            newtri[i][j] = getPattern();
                        else newtri[i][j] = ' ';
                        break;
                    case RIGHT_DOWN:
                        if ((i + 1) * width > j * height)
                            newtri[i][width - 1 - j] = getPattern();
                        else newtri[i][width - 1 - j] = ' ';
                        break;
                    case RIGHT_UP:
                        if ((i + 1) * width > j * height)
                            newtri[height - 1 - i][width - 1 - j] = getPattern();
                        else newtri[height - 1 - i][width - 1 - j] = ' ';
                        break;
                    case LEFT_UP:
                        if ((i + 1) * width > j * height)
                            newtri[height - 1 - i][j] = getPattern();
                        else newtri[height - 1 - i][j] = ' ';
                        break;

                }
            }
        }grids=newtri;
        }

    @Override
    public void shrink() {
        if (width > 1 && height > 1) {
            width--;
            height--;
            char[][] newtri = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {


                    switch (d) {
                        case LEFT_DOWN:
                            if ((i + 1) * width > j * height)
                                newtri[i][j] = getPattern();
                            else newtri[i][j] = ' ';
                            break;
                        case RIGHT_DOWN:
                            if ((i + 1) * width > j * height)
                                newtri[i][width - 1 - j] = getPattern();
                            else newtri[i][width - 1 - j] = ' ';
                            break;
                        case RIGHT_UP:
                            if ((i + 1) * width > j * height)
                                newtri[height - 1 - i][width - 1 - j] = getPattern();
                            else newtri[height - 1 - i][width - 1 - j] = ' ';
                            break;
                        case LEFT_UP:
                            if ((i + 1) * width > j * height)
                                newtri[height - 1 - i][j] = getPattern();
                            else newtri[height - 1 - i][j] = ' ';
                            break;

                    }
                }
            }grids=newtri;
    }}

    @Override
    public int area() {
        int area = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + 1) * width > j * height) {
                    area += 1;
                }
            }
        }
        return area;
    }@Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }
}
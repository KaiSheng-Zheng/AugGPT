public class RightTriangle extends Shape{

    private int width;

    private int height;

    private char pattern;

    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.pattern = pattern;
        this.d = d;
        this.grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void fillGrids() {
        for (int i = 0; i < this.grids.length; i++) {
            for (int j = 0; j < this.grids[0].length; j++) {
                double x = (double)width;
                double y = (double)height;
                boolean ifFill = (y / x) * (width - j) - (double) (height - i - 1) > 0.0;
                if (ifFill) {
                    this.grids[i][j] = this.pattern;
                } else {
                    this.grids[i][j] = ' ';
                }
            }
        }
        if (d == Direction.LEFT_DOWN) {
            //Do Nothing
        } else if (d ==Direction.LEFT_UP) {
            //Upside down
            for (int i = 0; i < this.grids.length / 2; i++) {
                for (int j = 0; j < this.grids[0].length; j++) {
                    char temp = this.grids[i][j];
                    this.grids[i][j] = this.grids[this.grids.length - i - 1][j];
                    this.grids[this.grids.length - i - 1][j] = temp;
                }
            }
        } else if (d == Direction.RIGHT_DOWN) {
            //Mirror
            for (int i = 0; i < this.grids.length; i++) {
                for (int j = 0; j < this.grids[0].length / 2; j++) {
                    char temp = this.grids[i][j];
                    this.grids[i][j] = this.grids[i][this.grids[0].length - j - 1];
                    this.grids[i][this.grids[0].length - j - 1] = temp;
                }
            }
        } else if (d == Direction.RIGHT_UP) {
            //Upside down & Mirror
            for (int i = 0; i < this.grids.length / 2; i++) {
                for (int j = 0; j < this.grids[0].length; j++) {
                    char temp = this.grids[i][j];
                    this.grids[i][j] = this.grids[this.grids.length - i - 1][j];
                    this.grids[this.grids.length - i - 1][j] = temp;
                }
            }
            for (int i = 0; i < this.grids.length; i++) {
                for (int j = 0; j < this.grids[0].length /2 ; j++) {
                    char temp = this.grids[i][j];
                    this.grids[i][j] = this.grids[i][this.grids[0].length - j - 1];
                    this.grids[i][this.grids[0].length - j - 1] = temp;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.width = width + 1;
        this.height = height + 1;
        this.grids = new char[height][width];
        fillGrids();
    }

    @Override
    public void shrink() {
        this.width = width - 1;
        this.height = height - 1;
        this.grids = new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for (int i = 0; i < this.grids.length; i++) {
            for (int j = 0; j < this.grids[0].length; j++) {
                if (this.getGrids()[i][j] != ' ') {
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public String toString() {
        int x = location.getX();
        int y = location.getY();
        int area = this.area();
        char pattern = this.pattern;
        return String.format("%s: (%s,%s) area=%d pattern=%s", "RightTriangle", x, y, area, pattern);
    }


    @Override
    public int compareTo(Shape o) {
        if (this.location.getX() > o.location.getX()) {
            return 1;
        } else if (this.location.getX() < o.location.getX()) {
            return -1;
        } else {
            if (this.location.getY() > o.location.getY()) {
                return 1;
            } else if (this.location.getY() < o.location.getY()) {
                return -1;
            } else {
                if (this.pattern > o.pattern) {
                    return 1;
                } else if (this.pattern < o.pattern) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}

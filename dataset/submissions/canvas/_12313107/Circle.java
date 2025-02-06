public class Circle extends Shape {

    private int radius;

    private char pattern;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.pattern = pattern;
        this.radius = radius;
        this.grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public void fillGrids() {
        for (int i = 0; i < this.grids.length; i++) {
            for (int j = 0; j < this.grids[0].length; j++) {
                grids[i][j] = ' ';
            }
        }
        for (int i = 0; i < this.radius; i++) {
            for (int j = 0; j < this.radius; j++) {
                boolean ifFillIn = radius * radius - (i + 1 - radius) * (i + 1 - radius) - (j + 1 - radius) * (j + 1 - radius) > 0;
                if (ifFillIn) {
                    this.grids[i][j] = this.pattern;
                } else {
                    this.grids[i][j] = ' ';
                }
            }
        }
        for (int i = this.radius; i < this.radius * 2; i++) {
            for (int j = 0; j < this.radius; j++) {
                boolean ifFillIn = radius * radius - (i - radius) * (i - radius) - (j + 1 - radius) * (j + 1 - radius) > 0;
                if (ifFillIn) {
                    this.grids[i][j] = this.pattern;
                } else {
                    this.grids[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i < this.radius * 2; i++) {
            for (int j = this.radius; j < this.radius * 2; j++) {
                this.grids[i][j] = this.grids[i][2 * radius - j - 1];
            }
        }

    }

    @Override
    public void enlarge() {
        this.pattern = pattern;
        this.radius = radius + 1;
        this.grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    @Override
    public void shrink() {
        this.pattern = pattern;
        this.radius = radius - 1;
        this.grids = new char[radius * 2][radius * 2];
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
        return String.format("%s: (%s,%s) area=%d pattern=%s", "Circle", x, y, area, pattern);
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

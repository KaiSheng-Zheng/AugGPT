public class Circle extends Shape {
    public int getRadius() {
        return radius;
    }

    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.location = location;
        this.pattern = pattern;
        this.radius = radius;
        fillGrids();
    }

    public boolean JudgeCircle(int x, int y) {
        if ((Math.pow((x - radius- location.getX()), 2) + Math.pow((y - radius- location.getY()), 2)) < radius * radius)
            return true;
        if ((Math.pow((x + 1 - radius- location.getX()), 2) + Math.pow((y - radius- location.getY()), 2)) < radius * radius)
            return true;
        if ((Math.pow((x - radius- location.getX()), 2) + Math.pow((y + 1 - radius- location.getY()), 2)) < radius * radius)
            return true;
        if ((Math.pow((x + 1 - radius- location.getX()), 2) + Math.pow((y + 1 - radius- location.getY()), 2)) < radius * radius)
            return true;
        return false;
    }

    public boolean JudgeCircle1(int x, int y) {
        if ((Math.pow((x - radius), 2) + Math.pow((y - radius), 2)) < radius * radius)
            return true;
        if ((Math.pow((x + 1 - radius), 2) + Math.pow((y - radius), 2)) < radius * radius)
            return true;
        if ((Math.pow((x - radius), 2) + Math.pow((y + 1 - radius), 2)) < radius * radius)
            return true;
        if ((Math.pow((x + 1 - radius), 2) + Math.pow((y + 1 - radius), 2)) < radius * radius)
            return true;
        return false;
    }

    @Override
    public void fillGrids() {
        this.grids = new char[2 * radius][2 * radius];
        for (int i = 0; i <= 2 * radius - 1; i++) {
            for (int j = 0; j <= 2 * radius - 1; j++) {
                if (JudgeCircle1(i, j))
                    grids[i][j] = pattern;
                else grids[i][j] = ' ';
            }
        }
    }

    @Override
    public void enlarge() {
        this.radius++;
        this.grids = new char[2 * radius][2 * radius];
        for (int i = 0; i <= 2 * radius - 1; i++) {
            for (int j = 0; j <= 2 * radius - 1; j++) {
                if (JudgeCircle1(i, j))
                    grids[i][j] = pattern;
                else grids[i][j] = ' ';
            }
        }
    }

    @Override
    public void shrink() {
        this.radius--;
        this.grids = new char[2 * radius][2 * radius];
        for (int i = 0; i <= 2 * radius - 1; i++) {
            for (int j = 0; j <= 2 * radius - 1; j++) {
                if (JudgeCircle1(i, j))
                    grids[i][j] = pattern;
                else grids[i][j] = ' ';
            }
        }
    }

    @Override
    public int area() {
        int num = 0;
        for (int i = 0; i <= 2 * radius - 1; i++) {
            for (int j = 0; j <= 2 * radius - 1; j++) {
                if (grids[i][j] == pattern)
                    num++;
            }
        }
        return num;
    }

    public String toString() {
        String a = "Circle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + this.pattern;
        return a;
    }
}

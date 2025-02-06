public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        super.location = location;
        super.pattern = pattern;
        this.radius = radius;
        fillGrids();
    }

    public void fillGrids() {
        super.grids = new char[radius * 2][radius * 2];
        for (int i = 1; i <= radius; i++) {
            for (int j = 1; j <= radius; j++) {
                if ((radius - i) * (radius - i) + (radius - j) * (radius - j) < (radius * radius)) {
                    super.grids[i - 1][j - 1] = super.pattern;
                    super.grids[i - 1][radius * 2 - j] = super.pattern;
                    super.grids[radius * 2 - i][radius * 2 - j] = super.pattern;
                    super.grids[radius * 2 - i][j - 1] = super.pattern;
                } else {
                    super.grids[i - 1][j - 1] = ' ';
                    super.grids[i - 1][radius * 2 - j] = ' ';
                    super.grids[radius * 2 - i][radius * 2 - j] = ' ';
                    super.grids[radius * 2 - i][j - 1] = ' ';
                }
            }
        }
    }

    public void enlarge() {
        this.radius++;
        fillGrids();
    }

    public void shrink() {

        this.radius--;
        fillGrids();

    }

    public int area() {
        int qArea = 0;
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (i * i + j * j < radius * radius) {
                    qArea++;
                }
            }
        }
        return qArea * 4;
    }
    public char getPattern(){
        return super.pattern;
    }
    public String toString(){
        return "Circle: "+location.toString()+" area="+area()+" pattern="+super.pattern;
    }


}

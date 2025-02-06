public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {

        super(location, pattern);
        this.location = location;
        this.pattern = pattern;
        this.radius = radius;

        fillGrids();

    }

    @Override
    public void fillGrids() {

        this.grids = new char[this.radius * 2][this.radius * 2];

        for (int i = 0; i < this.radius; i++) {
            for (int j = 0; j < this.radius; j++) {
                double distance = Math.sqrt((this.radius - i - 1) * (this.radius - i - 1) + (this.radius - j - 1) * (this.radius - j - 1));
                if (distance < this.radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i < this.radius; i++) {
            for (int j = this.radius; j < this.radius * 2; j++) {
                grids[i][j] = grids[i][this.radius * 2 - 1 - j];
            }
        }

        for (int i = this.radius; i < this.radius * 2; i++) {
            for (int j = 0; j < this.radius * 2; j++) {
                grids[i][j] = grids[this.radius * 2 - 1 - i][j];
            }
        }

    }

    @Override
    public void enlarge() {

        this.radius++;
        fillGrids();

    }

    @Override
    public void shrink() {

        this.radius--;
        fillGrids();

    }

    @Override
    public int area() {

        int count = 0;

        for (int i = 0; i < this.radius * 2; i++) {
            for (int j = 0; j < this.radius * 2; j++) {
                if(grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }

    public String toString() {
        return String.format("Circle: (%d,%d) area=%d pattern=%c",
                location.getX(), location.getY(), area(), pattern);
    }

}


public class Circle extends Shape{
    private int radius;
    int area;

    public Circle(Location location, char pattern, int radius) {
        super();
        super.location = location;
        super.pattern = pattern;
        this.radius = radius;
        this.fillGrids();
    }


    @Override
    public void fillGrids() {
        area=0;
        super.grids = new char[2 * radius][2 * radius];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (i <= radius - 1 && j <= radius - 1) {
                    double distance = Math.sqrt(Math.pow(radius - 1 - i, 2) + Math.pow(radius - 1 - j, 2));
                    fill(distance,i,j);
                } else if (i <= radius - 1 && j > radius - 1) {
                    double distance = Math.sqrt(Math.pow(radius - 1 - i, 2) + Math.pow(radius - j, 2));
                    fill(distance,i,j);
                } else if (i > radius - 1 && j <= radius - 1) {
                    double distance = Math.sqrt(Math.pow(radius - i, 2) + Math.pow(radius - 1 - j, 2));
                    fill(distance,i,j);
                } else if (i > radius - 1 && j > radius - 1) {
                    double distance = Math.sqrt(Math.pow(radius - i, 2) + Math.pow(radius - j, 2));
                    fill(distance,i,j);
                }
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
        return area;
    }

    @Override
    public String toString() {
        return "Circle: (" + this.location.getX() + "," + this.location.getY() + ") area=" + area + " pattern=" + pattern;
    }
    private void fill(double distance,int i, int j){
        if (distance < radius) {
            grids[i][j] = pattern;
            area++;
        } else {
            grids[i][j] = ' ';
        }
    }
}

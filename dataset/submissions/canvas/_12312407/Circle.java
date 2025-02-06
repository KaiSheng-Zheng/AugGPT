public class Circle extends Shape {
    private int radius;
    private int count;
    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;

        this.grids = new char[2 * radius][2 * radius];
        fillGrids();
    }


    protected void fillGrids() {
       count=0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (Math.pow(i - radius, 2)+Math.pow(j - radius, 2) < Math.pow(radius,2)||
                    Math.pow(i - radius, 2)+Math.pow(j+1 - radius, 2) < Math.pow(radius,2)||
                    Math.pow(i+1 - radius, 2)+Math.pow(j - radius, 2) < Math.pow(radius,2)||
                    Math.pow(i+1 - radius, 2)+Math.pow(j+1 - radius, 2) < Math.pow(radius,2)) {
                    grids[i][j] = pattern;
                    count=count+1;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
    }


    protected void enlarge() {
            radius++;

            this.grids = new char[2 * radius][2 * radius];
            fillGrids();

    }


    protected void shrink() {
            radius--;

            this.grids = new char[2 * radius ][2 * radius ];
            fillGrids();
        }


    public int area() {
        return count;
    }


    public String toString() {
        return String.format("Circle: %s area=%d pattern=%c", location.toString(), area(), pattern);
    }
}
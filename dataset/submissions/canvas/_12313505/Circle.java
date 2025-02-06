public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
        super.className = "Circle";
    }

    @Override
    public void fillGrids() {
        int gridLength = 2 * radius;
        super.grids = new char[gridLength][gridLength];
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridLength; j++) {
                super.grids[i][j] = CircleTest(i, j, new Location(0, 0)) ? pattern : ' ';
            }
        }
    }

    public boolean CircleTest(int x,int y,Location location){
        Location center = new Location(location.getX() + radius, location.getY() + radius);
        if(x< center.getX()&&y< center.getY()) {
            int x0 = x - center.getX()+1;
            int y0 =  y - center.getY()+1;
            double distance = Math.sqrt(x0*x0+y0*y0);
            return distance<radius;
        } else if (x< center.getX()&&y< center.getY()*2) {
            int x0 = x - center.getX()+1;
            int y0 =  y - center.getY();
            double distance = Math.sqrt(x0*x0+y0*y0);
            return distance<radius;
        } else if (y< center.getY()&&x< center.getX()*2) {
            int y0 =  y - center.getY()+1;
            int x0 = x - center.getX();
            double distance = Math.sqrt(x0*x0+y0*y0);
            return distance<radius;
        } else {
            int y0 =  y - center.getY();
            int x0 = x - center.getX();
            double distance = Math.sqrt(x0*x0+y0*y0);
            return distance<radius;
        }
    }

    @Override
    public void enlarge() {
        radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (super.grids[i][j] == pattern) count++;
            }
        }
        return count;
    }

    @Override
    public int getArea() {
        return area();
    }
}

public class Circle extends Shape {
    private int radius;
    private int count=0;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }


    @Override
    public void fillGrids() {
        //clear the counter before counting
        grids = new char[2*radius][2*radius];
        for (int i = 0; i < 2*radius; i++) {//y axis
            for (int j = 0; j < 2*radius; j++) {//x axis
                double d = Math.sqrt(Math.pow((i-0.5)-(radius-1), 2) + Math.pow((j-0.5)-(radius-1), 2));
                if (d-radius < 0.5*1.4){//inside the circle                    count++;
                    grids[i][j] = pattern;
                    count++;
                }
                else{
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        count=0;
        radius+=1;
        fillGrids();
    }

    @Override
    public void shrink() {
        count=0;
        radius-=1;
        fillGrids();
    }

    @Override
    public int area() {
        return count;
    }

    public String toString(){
        return String.format("Circle: %s area=%d pattern=%s", getLocation(), area(), getPattern());
    }
}
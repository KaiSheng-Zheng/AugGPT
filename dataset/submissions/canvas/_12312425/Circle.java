public class Circle extends Shape implements Comparable<Shape>{
    private int radius;//[1-15]
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        this.fillGrids();
    }
    @Override
    public void fillGrids() {
        this.grids = new char[2 * radius][2 * radius];
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if(distance(radius - i,radius - j) >= radius && distance(radius - i - 1,radius - j) >= radius
                && distance(radius - i, radius - j - 1) >= radius && distance(radius - i - 1,radius - j - 1) >= radius){
                    grids[i][j] = '\u0020';
                } else {
                    grids[i][j] = pattern;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.radius += 1;
        this.fillGrids();
    }

    @Override
    public void shrink() {
        this.radius -= 1;
        this.fillGrids();
    }

    @Override
    public int area() {
        int a = 0;
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (grids[i][j] == pattern){
                    a += 1;
                }
            }
        }
        return a;
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(),location.getY(), area(), pattern);
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public int compareTo(Shape o) {
        if (this.area() < o.area()){
            return -1;
        }else if (this.area() > o.area()) {
            return 1;
        }else {
            if (this.pattern < o.pattern){
                return -1;
            }else if (this.pattern > o.pattern) {
                return 1;
            }else {
                return 0;
            }
        }
    }
}
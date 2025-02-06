public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        this.fillGrids();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void fillGrids() {
      char[][] chars=new char[2*radius][2*radius];
       for (int i=0;i<2*radius;i++){
           for (int j=0;j<2*radius;j++){
               chars[i][j]=' ';
           }
       }
        int q = 0;
        for (int i = 0; i < radius; i++) {
            double r = Math.sqrt(2 * (i + 1) * radius - (i + 1) * (i + 1));
            if (r % 1 == 0) {
                q = (int) r;
            }
            if (r % 1 != 0) {
                q = (int) r + 1;
            }
            for (int k = 0; k < q; k++) {
                chars[i][radius - 1 - k] = pattern;
                chars[i][radius + k] = pattern;
                chars[2*radius-i-1][radius - 1 - k] = pattern;
                chars[2*radius-i-1][radius + k] = pattern;
            }
        }
        super.setGrids(chars);
    }

    @Override
    public void enlarge() {
        this.radius = radius + 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.radius = radius - 1;
        fillGrids();
    }

    @Override
    public int area() {
        int a = 0;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if (this.grids[i][j] == pattern)
                    a++;
            }
        }
        return a;
    }
    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c", getLocation().getX(), getLocation().getY(), area(), pattern);
    }
}

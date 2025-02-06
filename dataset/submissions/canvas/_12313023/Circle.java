public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(pattern, location);
        this.radius = radius;
        name = "Circle";
        grids = new char[radius*2][radius*2];
        fillGrids();
    }
    @Override
    public void fillGrids(){
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if (i < radius && j < radius) {
                    if (Math.sqrt(1.0*(radius-i-1)*(radius-i-1) + 1.0*(radius-j-1)*(radius-j-1)) < 1.0*radius){
                        grids[i][j] = pattern;
                        grids[radius*2-1-i][radius*2-1-j] = pattern;
                        grids[radius*2-1-i][j] = pattern;
                        grids[i][radius*2-1-j] = pattern;
                    } else {
                        grids[i][j] = ' ';
                        grids[radius*2-1-i][radius*2-1-j] = ' ';
                        grids[radius*2-1-i][j] = ' ';
                        grids[i][radius*2-1-j] = ' ';
                    }
                }
            }
        }
    }
    @Override
    public void enlarge(){
        radius += 1;
        grids = new char[radius*2][radius*2];
        fillGrids();
    }
    @Override
    public void shrink(){
        if (radius != 0) {
            radius -= 1;
            grids = new char[radius*2][radius*2];
            fillGrids();
        }
    }
    @Override
    public int area(){
        int count = 0;
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if (grids[i][j] == pattern){
                    count++;
                }
            }
        }
        return count;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return name + ": "+ location.toString() +" area=" + area() + " pattern=" + pattern;
    }

}

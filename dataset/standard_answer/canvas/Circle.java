public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius = radius;
        this.grids = new char[2*radius][2*radius];
        fillGrids();
    }
    @Override
    public void fillGrids(){
        int centerX =  radius;
        int centerY =  radius;
        for (int i = radius; i <2*radius; i++) {
            for (int j = radius; j <2*radius; j++) {
                double distance = Math.sqrt((i - centerX) * (i - centerX) + (j - centerY) * (j - centerY));
                if (distance < radius) {
                    grids[i][j] = pattern;
                    grids[i][2 * radius - j-1] = pattern;
                    grids[2 * radius - i-1][j] = pattern;
                    grids[2 * radius - i-1][2 * radius - j-1] = pattern;
                } else {
                    grids[i][j] = ' ';
                    grids[i][2 * radius - j-1] = ' ';
                    grids[2 * radius - i-1][j] = ' ';
                    grids[2 * radius - i-1][2 * radius - j-1] = ' ';
                }
            }
        }
    }
    @Override
    public void enlarge() {
        radius ++;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }
    @Override
    public void shrink() {
        if(radius>1){
        radius --;
        grids = new char[2*radius][2*radius];
        fillGrids();
        }
    }
    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if (grids[i][j] == pattern) {
                    count++;
                }
            }
        }
        return count;
    }
}
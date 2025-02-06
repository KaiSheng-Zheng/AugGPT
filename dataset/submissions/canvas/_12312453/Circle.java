public class Circle extends Shape{
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        if (radius >= 1 && radius <=15){
            this.radius = radius;
        }
    }

    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
    }

    @Override
    public void fillGrids() {
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < grids.length; i++){
            for (int j = 0; j < grids[i].length; j++) {
                if (i < radius) {
                    if (j < radius) {
                        if (Math.pow(radius - j - 1, 2) + Math.pow(radius - i - 1, 2) < Math.pow(radius, 2)) {
                            grids[i][j] = pattern;
                        }
                    } else {
                        if (Math.pow(radius - j, 2) + Math.pow(radius - i - 1, 2) < Math.pow(radius, 2)) {
                            grids[i][j] = pattern;
                        }
                    }
                } else {
                    if (j < radius) {
                        if (Math.pow(radius - j - 1, 2) + Math.pow(radius - i, 2) < Math.pow(radius, 2)) {
                            grids[i][j] = pattern;
                        }
                    } else {
                        if (Math.pow(radius - j, 2) + Math.pow(radius - i, 2) < Math.pow(radius, 2)) {
                            grids[i][j] = pattern;
                        }
                    }
                }
            }
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
        fillGrids();
        int counter = 0;
        for (char[] test1 : grids){
            for (char test : test1){
                if (test == pattern){
                    counter++;
                }
            }
        }
        return counter;
    }

    public String toString(){
        return "Circle: (" + location.getX() + "," + location.getY() + ") area=" + area() + " pattern=" + pattern;
    }

}

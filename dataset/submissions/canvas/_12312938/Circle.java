
public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        setRadius(radius);
        grids = new char[2*radius][2*radius];
        fillGrids();
    }


    public void fillGrids() {
        int centerX = radius;
        int centerY = radius;

        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if ((i - centerX) * (i - centerX) + (j - centerY) * (j - centerY) < radius * radius|
                        (i+1 - centerX) * (i+1 - centerX) + (j - centerY) * (j - centerY) < radius * radius|
                        (i - centerX) * (i - centerX) + (j+1 - centerY) * (j+1 - centerY) < radius * radius|
                        (i+1 - centerX) * (i+1 - centerX) + (j+1 - centerY) * (j+1 - centerY) < radius * radius) {
                    grids[i][j] = pattern; // Inside the circle
                } else {
                    grids[i][j] = ' '; // Outside the circle
                }
            }
        }
    }

    public void enlarge(){
        this.radius++;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }

    public void shrink(){
        this.radius--;
        grids = new char[2*radius][2*radius];
        fillGrids();
    }

    public void setRadius(int r){
        if (1<=r & r<=100){
            radius = r;
        }
    }
    public int getRadius(){
        return radius;
    }

    @Override
    public int area(){
        int centerX = radius;
        int centerY = radius;
        int area = 0;
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if ((i - centerX) * (i - centerX) + (j - centerY) * (j - centerY) < radius * radius|
                        (i+1 - centerX) * (i+1 - centerX) + (j - centerY) * (j - centerY) < radius * radius|
                        (i - centerX) * (i - centerX) + (j+1 - centerY) * (j+1 - centerY) < radius * radius|
                        (i+1 - centerX) * (i+1 - centerX) + (j+1 - centerY) * (j+1 - centerY) < radius * radius) {
                    area++;
                }
            }
        }
        return area;
    }

    public String toString(){
        return String.format("%s: (%d,%d) %s=%d %s=%c",
                "Circle",location.getX(),location.getY(),
                "area",this.area(),"pattern",pattern);
    }
    
}
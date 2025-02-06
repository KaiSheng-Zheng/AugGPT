import java.util.Comparator;

public class Circle extends Shape {
    private int radius;
    private int width;
    private int height;
    public Circle(Location location, char pattern, int radius){
      super(location,pattern);
      this.radius = radius;
      this.height=2*radius;
      this.width=2*radius;
      fillGrids();
    }

    @Override
    public void fillGrids(){
        grids = new char[width][height];
        for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i <= radius && j <= radius) {
                        if (Math.pow(i+1 - radius, 2) + Math.pow(j+1 - radius, 2) < Math.pow(radius, 2)) {
                            grids[j][i] = pattern;
                        }
                    }
                    if (i >= radius && j <= radius) {
                        if (Math.pow(i - radius, 2) + Math.pow(j+1 - radius, 2) < Math.pow(radius, 2)) {
                            grids[j][i] = pattern;
                        }
                    }
                    if (i >= radius && j >= radius) {
                        if (Math.pow(i - radius, 2) + Math.pow(j - radius, 2) < Math.pow(radius, 2)) {
                            grids[j][i] = pattern;
                        }
                    }
                    if (i <= radius && j >= radius) {
                        if (Math.pow(i + 1 -radius , 2) + Math.pow(j  - radius, 2) < Math.pow(radius, 2)) {
                            grids[j][i] = pattern;
                        }
                    }
                    if(grids[j][i] != pattern){
                        grids[j][i] = ' ';
                    }
                }
        }
    }

    @Override
    public void enlarge() {
        radius++;
        height = 2*radius;
        width = 2*radius;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius--;
        height = 2*radius;
        width = 2*radius;
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grids[j][i] == pattern) {
                        count++;
                    }
                }
            }
        return count;
    }

    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),this.area(),pattern);
    }


}

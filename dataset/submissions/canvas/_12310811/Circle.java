import java.util.Arrays;

public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location != null ? location : new Location(0, 0), pattern != '\0' ? pattern : '*');
        this.radius = radius > 0 ? radius : 5;
        fillGrids();
    }


    @Override
    public void fillGrids() {
        super.grids = new char[radius * 2][radius * 2];
        for (char[] grid : grids) {
            Arrays.fill(grid, this.pattern);
        }
        int area = (int) Math.pow(radius * 2, 2);
        for (int i = 1; i < radius; i++) {
            for (int j = 1; j < radius; j++) {
                double length = Math.pow(radius - i, 2) + Math.pow(radius - j, 2);
                int row = i - 1;
                int col = j - 1;
                if (length >= radius * radius) {
                    grids[row][col] = ' ';
                    grids[grids.length - row - 1][col] = ' ';
                    grids[row][grids.length - col - 1] = ' ';
                    grids[grids.length - row - 1][grids.length - col - 1] = ' ';
                    area -= 4;
                } else {
                    break;
                }
            }
        }
    }



    @Override
    public void enlarge() {
        radius += 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius -= 1;
        fillGrids();
    }

    @Override
    public int area() {
        int number = 0;
        for (int i = 0; i < 2 * radius; i++) {
            for (int j = 0; j < 2 * radius; j++) {
                if (grids[i][j] == pattern) {
                    number += 1;
                }
            }
        }
        return number;
    }

    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }

    @Override
    public char getPattern() {
        return pattern;
    }
    
}
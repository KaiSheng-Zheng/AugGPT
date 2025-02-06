import java.util.Arrays;

public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        int diameter = 2 * radius;
        this.grids = new char[diameter][diameter];
        fillGrids();
    }

    @Override
    protected void fillGrids() {
        int centerX = radius;
        int centerY = radius;
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (Math.sqrt(Math.pow(i+1 - centerX, 2) + Math.pow(j+1- centerY, 2)) < radius) {
                    grids[i][j] = getPattern();
                    grids[radius*2-1-i][radius*2-1-j]=getPattern();
                    grids[radius*2-1-i][j]=getPattern();
                    grids[i][radius*2-1-j]=getPattern();
                } else {
                    grids[i][j] = ' ';
                    grids[radius*2-1-i][radius*2-1-j]=' ';
                    grids[i][radius*2-1-j]=' ';
                    grids[radius*2-1-i][j]=' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius++;
        int diameter = 2 * radius;
        char[][] newGrids = new char[diameter][diameter];
        int centerX = radius;
        int centerY = radius;
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (Math.sqrt(Math.pow(i+1 - centerX, 2) + Math.pow(j+1- centerY, 2)) < radius) {
                    newGrids[i][j] = getPattern();
                    newGrids[radius*2-1-i][radius*2-1-j]=getPattern();
                    newGrids[radius*2-1-i][j]=getPattern();
                    newGrids[i][radius*2-1-j]=getPattern();
                } else {
                    newGrids[i][j] = ' ';
                    newGrids[radius*2-1-i][radius*2-1-j]=' ';
                    newGrids[i][radius*2-1-j]=' ';
                    newGrids[radius*2-1-i][j]=' ';
                }
            }
        }
        grids = newGrids;
    }

    @Override
    public void shrink() {
        if (radius > 0) {
            radius--;
            int diameter = 2 * radius;
            char[][] newGrids = new char[diameter][diameter];
            int centerX = radius;
            int centerY = radius;
            for (int i = 0; i < radius; i++) {
                for (int j = 0; j < radius; j++) {
                    if (Math.sqrt(Math.pow(i+1 - centerX, 2) + Math.pow(j+1- centerY, 2)) < radius) {
                        newGrids[i][j] = getPattern();
                        newGrids[radius*2-1-i][radius*2-1-j]=getPattern();
                        newGrids[radius*2-1-i][j]=getPattern();
                        newGrids[i][radius*2-1-j]=getPattern();
                    } else {
                        newGrids[i][j] = ' ';
                        newGrids[radius*2-1-i][radius*2-1-j]=' ';
                        newGrids[i][radius*2-1-j]=' ';
                        newGrids[radius*2-1-i][j]=' ';
                    }
                }
            }
            grids = newGrids;
        }
    }

    @Override
    public int area() {
        int centerX = radius;
        int centerY = radius;
        int area=0;
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (Math.sqrt(Math.pow(i+1 - centerX, 2) + Math.pow(j+1- centerY, 2)) < radius) {
                    grids[i][j] = getPattern();
                   area+=4;
                }
            }
        }
        return area;
    }
@Override
public int getHeight() {
    return 2*radius;
}

@Override
public int getWidth() {
    return 2*radius;
}
    @Override
    public String toString() {
        return "Circle: (" + getLocation().getX() + "," + getLocation().getY() + ") area=" + area() + " pattern=" + getPattern();
    }

}
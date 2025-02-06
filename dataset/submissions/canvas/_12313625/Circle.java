public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        getGrids();
        grids = new char[radius * 2][radius * 2];
        this.pattern = pattern;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (((i + 1 - radius) * (i + 1 - radius) + (j + 1 - radius) * (j + 1 - radius)) < radius * radius) {
                    grids[i][j] = pattern;
                } else grids[i][j] = ' ';
            }
        }
        for (int i = radius; i < radius * 2 & i >= radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (((i - radius) * (i - radius) + (j + 1 - radius) * (j + 1 - radius)) < radius * radius) {
                    grids[i][j] = pattern;
                } else grids[i][j] = ' ';
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = radius; j < radius * 2 & j >= radius; j++) {
                if(((i+1-radius)*(i+1-radius)+(j-radius)*(j-radius)) < radius*radius){
                    grids[i][j] = pattern;
                }else grids[i][j] = ' ';
            }
        }
        for (int i = radius; i < radius*2 & i >= radius; i++) {
            for (int j = radius; j < radius*2 & j >= radius; j++) {
                if(((i-radius)*(i-radius)+(j-radius)*(j-radius)) < radius*radius){
                    grids[i][j] = pattern;
                }else grids[i][j] = ' ';
            }
        }
    }
    @Override
    public void enlarge() {
        radius = radius+1;
        grids = new char[radius*2][radius*2];
        fillGrids();
    }

    @Override
    public void shrink() {
        radius = radius-1;
        grids = new char[radius*2][radius*2];
        fillGrids();
    }

    @Override
    public int area() {
        int S = 0;
        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                if (grids[i][j] == pattern) {
                    S++;
                }
            }
        }
        return S;
    }
    @Override
    public String toString() {
        int x,y;
        x = location.getX();
        y = location.getY();
        int s = area();
        return String.format("Circle: ("+x+","+y+") area="+area()+" pattern="+pattern);
    }

    @Override
    public char[][] getGrids() {
        return super.getGrids();
    }
}
public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        int diameter = 2 * radius;
        grids = new char[diameter][diameter];
        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                double distance1 = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius, 2));
                double distance2 = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius+1, 2));
                double distance3 = Math.sqrt(Math.pow(i - radius+1, 2) + Math.pow(j - radius, 2));
                double distance4 = Math.sqrt(Math.pow(i - radius+1, 2) + Math.pow(j - radius+1, 2));
                if (distance1 < radius||distance2<radius||distance3<radius||distance4<radius) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
        setGrids(grids);
    }


    @Override
    public void enlarge() {
        radius++;
        fillGrids();
    }

    @Override
    public void shrink() {
        if (radius > 1) {
            radius--;
            fillGrids();
        }
    }

    @Override
    public int area() {
        int count=0;
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if (grids[i][j]==pattern){
                    count++;
                }
            }
        }
        return count;
    }
}
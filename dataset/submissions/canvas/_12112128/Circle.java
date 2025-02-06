public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    public double Distance(int i, int j, int a,int b, int radius) {
        return Math.sqrt(Math.pow(i + a - radius, 2) + Math.pow(j + b - radius, 2));
    }
    @Override
    public void fillGrids() {
        int diameter = 2 * radius;
        grids = new char[diameter][diameter];

        for (int i = 0; i < diameter; i++) {
            for (int j = 0; j < diameter; j++) {
                if(i<radius&&j<radius){
                    double distance = Distance(i,j,1,1,radius);
                    if(distance<radius){
                        grids[i][j] = pattern;
                    }else{
                        grids[i][j] = ' ';
                    }
                }else if (i<radius&&j>=radius) {
                    double distance = Distance(i,j,1,0,radius);
                    if(distance<radius){
                        grids[i][j] = pattern;
                    }else{
                        grids[i][j] = ' ';
                    }
                }else if (i>=radius&&j<radius) {
                    double distance = Distance(i,j,0,1,radius);
                    if(distance<radius){
                        grids[i][j] = pattern;
                    }else{
                        grids[i][j] = ' ';
                    }
                }else if (i>=radius&&j>=radius) {
                    double distance = Distance(i,j,0,0,radius);
                    if(distance<radius){
                        grids[i][j] = pattern;
                    }else{
                        grids[i][j] = ' ';
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
        if (radius > 1) {
            radius--;
            fillGrids();
        }
    }

    @Override
    public int area() {
        int n=0;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if(grids[i][j] == pattern){
                    n++;
                }
            }
        }
        return n;
    }
}

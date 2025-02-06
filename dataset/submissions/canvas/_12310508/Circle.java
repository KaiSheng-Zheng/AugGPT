public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern,int radius) {
        super(location,pattern);
        this.radius = radius;
        this.grids = new char[radius * 2][radius * 2];
        fillGrids();
    }

    public  char[][] getGrids(){
        return grids;
    }


    public void fillGrids (){
        grids[radius - 1][radius - 1] = pattern;
        for (int i = radius; i >= 0; i--) {
            for (int j = radius; j >= 0; j--) {
                if ((i - radius) * (i - radius) + (j - radius) * (j - radius) < radius * radius) {
                    grids[i-1][j-1] = pattern;
                }
            }
        }
        for (int i = 0; i <= radius - 1; i++) {
            for (int j = 0; j <= radius - 1; j++) {
                if (grids[i][j] == pattern) {
                    grids[radius * 2 - 1 - i][radius * 2 - 1 - j] = pattern;
                    grids[i][radius * 2 - 1 - j] = pattern;
                    grids[radius * 2 - 1 - i][j] = pattern;
                }
            }
        }
        for (int i = 0; i <= radius*2-1; i++) {
            for (int j = 0; j <= radius*2-1; j++) {
                if(grids[i][j] != pattern){
                    grids[i][j] = ' ';
                }
            }
        }
    }

    public void enlarge() {
        radius++;
        this.grids = new char[radius * 2][radius * 2];
        this.fillGrids();
    }

    public void shrink() {
        radius--;
        this.grids = new char[radius * 2][radius * 2];
        this.fillGrids();
    }

    @Override
    public int area() {
        int k=0;
        char[][] a = getGrids();
        for (char[] chars : a) {
            for (char aChar : chars) {
                if (aChar == pattern) {
                    k++;
                }
            }
        }
        return k;
    }

    @Override
    public String toString() {
        return "Circle: "+ location.toString() + " "+"area="+area()+" "+ "pattern="+pattern;
    }
}

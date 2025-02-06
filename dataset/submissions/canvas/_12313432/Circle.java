public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids = new char[2*radius][2*radius];
        for(int i = 0; i < 2*radius; i ++){
            for(int j = 0; j < 2*radius; j ++){
                grids[i][j] = ' ';
            }
        }
        for(int i = 1; i < 2*radius; i ++){
            for(int j = 1; j < 2*radius; j ++){
                if(radius*radius + i*i + j*j < 2*radius*(i + j)){
                    grids[i-1][j-1] = pattern;
                    grids[i-1][j] = pattern;
                    grids[i][j-1] = pattern;
                    grids[i][j] = pattern;
                }
            }
        }
    }

    @Override
    public void enlarge() {
        radius ++;
        fillGrids();
    }

    @Override
    public void shrink() {
        if(radius > 0) radius --;
        fillGrids();
    }

    @Override
    public int area() {
        int area = 0;
        for(char[] r : grids){
            for(char c : r){
                if(c == pattern) area ++;
            }
        }
        return area;
    }

    @Override
    public char[][] getGrids() {
        return super.getGrids();
    }
}

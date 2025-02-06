public class Circle extends Shape{
    private int radius;
    public Circle(Location location1, char pattern, int radius){
        super(location1, pattern);
        this.radius = radius;
        fillGrids();
    }
    public String toString(){
        return "Circle: "+"("+location.getX()+","+location.getY()+") "+"area=" +area() +" pattern="+pattern;
    }
    public char[][] setGrids(){
        this.grids= new char[radius*2][radius*2];
        return grids;
    }
    @Override
    public void fillGrids() {
        setGrids();
        char space = ' ';
        for (int i = 0; i <= radius-1; i++) {
            for (int j = 0; j <= radius-1; j++) {
                if (Math.pow(i- radius+1,2)+Math.pow(j- radius+1,2)<radius*radius){
                    grids[i][j] = pattern;
                    grids[i][2*radius-1-j] = pattern;
                    grids[2*radius-1-i][j] = pattern;
                    grids[2*radius-1-i][2*radius-1-j] = pattern;
                }
                if (Math.pow(i- radius+1,2)+Math.pow(j- radius+1,2)>=radius*radius){
                    grids[i][j] = space;
                    grids[i][2*radius-1-j] = space;
                    grids[2*radius-1-i][j] = space;
                    grids[2*radius-1-i][2*radius-1-j] = space;
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
        int n = 0;
        for (int i = 0; i < 2*radius; i++) {
            for (int j = 0; j < 2*radius; j++) {
                if (grids[i][j] == pattern){
                    n++;
                }
            }
        }
        return n;
    }
}

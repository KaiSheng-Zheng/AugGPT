public class Circle extends Shape {
    private int radius;
    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
    }
    public char[][] getGrids() {
        grids = new char[radius * 2][radius * 2];
        fillGrids();
        return grids;
    }
    @Override
    public void fillGrids() {
        for (int i=1;i<grids.length;i++){
            for(int j=1;j<grids[i].length;j++){
                if( (i-radius)*(i-radius)+(j-radius)*(j-radius)<radius*radius){
                    if(grids[i][j]!=pattern)grids[i][j]= pattern;
                    if(grids[i-1][j]!=pattern)grids[i-1][j]= pattern;
                    if(grids[i][j-1]!=pattern)grids[i][j-1]= pattern;
                    if(grids[i-1][j-1]!=pattern)grids[i-1][j-1]= pattern;
                }
            }
        }
        for (int i=0;i<grids.length;i++){
            for(int j=0;j<grids[i].length;j++){
                if(grids[i][j]!=pattern){
                    grids[i][j]= ' ';
                }
            }
        }
    }
    public int area() {
        getGrids();
        int countGrids = 0;
        for (char[] grid : grids) {
            for (char c : grid) {
                if (c == pattern) {
                    countGrids++;
                }
            }
        }
        return countGrids;
    }

    public void enlarge() {
        ++radius;
    }

    public void shrink() {
        --radius;
    }

}

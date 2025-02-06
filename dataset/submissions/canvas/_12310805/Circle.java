public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(pattern,location);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        // fill the empty slot with ' ', not null
        this.grids = new char[radius*2][radius*2];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (((radius-i-1)*(radius-i-1)+(radius-j-1)*(radius-j-1))<radius*radius){
                    grids[i][j]=pattern;
                }
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (((radius-i-1)*(radius-i-1)+(j*j))<radius*radius){
                    grids[i][j+radius]=pattern;
                }
            }
        }
        for (int i = 0; i <radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (((i*i)+(radius-j-1)*(radius-j-1))<radius*radius){
                    grids[i+radius][j]=pattern;
                }
            }
        }
        for (int i = 0; i <radius; i++) {
            for (int j = 0; j < radius; j++) {
                if (((i*i)+(j*j))<radius*radius){
                    grids[i+radius][j+radius]=pattern;
                }
            }
        }
    }

    @Override
    public char[][] getGrids() {
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if (grids[i][j]!=pattern){
                    grids[i][j]=' ';
                }
            }
        }
        return super.getGrids();
    }

    @Override
    public void enlarge(){
        this.radius++;
        fillGrids();
    }
    @Override
    public void shrink(){
        this.radius--;
        fillGrids();
    }
    @Override
    public int area(){
        int counter = 0;
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if (grids[i][j]==pattern){
                    counter++;
                }
            }
        }
        return counter;
    }
    @Override
    public String toString(){
        return String.format("%s%s%s%d%s","Circle: ",location.toString()," area=",area()," pattern="+pattern);
    }
}

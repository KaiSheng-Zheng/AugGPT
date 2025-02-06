public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.location = location;
        this.pattern = pattern;
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        char[][] grids = new char[radius*2][radius*2];
        /*double d = (radius*(Math.sqrt(2)-1));
        double xie = Math.floor(d/Math.sqrt(2));
        double h = 2*xie;
        if(d<Math.sqrt(2)){

        }else {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < h-i; j++) {
                    grids[i][j] = ' ';
                    grids[i][radius * 2 - j-1] = ' ';
                    grids[radius * 2 - i-1][j] = ' ';
                    grids[radius * 2 - i-1][radius * 2 - j-1] = ' ';
                }
            }
        }
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if(grids[i][j] != ' '){
                    grids[i][j] = pattern;
                }
            }
        }
        */
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                if(Math.pow((i+1-radius),2)+Math.pow((j+1-radius),2)>=Math.pow(radius,2)){
                    grids[i][j] = ' ';
                }else {
                    grids[i][j] = pattern;
                }
            }
        }
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < radius; j++) {
                grids[radius*2-1-i][j]=grids[i][j];
                grids[i][radius*2-1-j]=grids[i][j];
                grids[radius*2-1-i][radius*2-1-j]=grids[i][j];
            }
        }
        this.grids= grids;
    }

    @Override
    public void enlarge() {
        radius ++;
        fillGrids();
    }

    @Override
    public void shrink() {
        radius --;
        fillGrids();
    }

    @Override
    public int area() {
        int sum = 0;
        for (int i = 0; i < radius*2; i++) {
            for (int j = 0; j < radius*2; j++) {
                if(grids[i][j] == pattern){
                    sum++;
                }
            }
        }
        return sum;
    }

    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c", location.getX(),location.getY(),area(),pattern);
    }
}

public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d ;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }
    public void setGrids(char[][] grids) {
        char[][] areas = new char[height][width];
        super.grids = areas;
    }
    public void fillGrids() {
            grids = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    double AreaRight = width*height*0.5;
                    switch (d) {
                        case LEFT_DOWN: {
                            double Area1 = 0.5*Math.abs(height*(j));
                            double Area2 = 0.5*Math.abs(width*(height-i-1));
                            double Area3 = 0.5*Math.abs(j*height+width*(-i-1));
                            double Area1Modi = 0.5*Math.abs(height*(j+0.01));
                            double Area3Modi = 0.5*Math.abs((j+0.01)*height+width*(-i-1));
                            if (AreaRight == Area1 + Area2 + Area3 && AreaRight >= Area1Modi + Area2 + Area3Modi){
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                        break;
                        case RIGHT_UP:{
                            double Area1 = 0.5*Math.abs(height*(width-(j+1)));
                            double Area2 = 0.5*Math.abs(width*(i));
                            double Area3 = 0.5*Math.abs((j+1)*height+width*(-i));
                            if (AreaRight >= Area1 + Area2 + Area3 && height*(j+1) != i*width){
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                        break;
                        case LEFT_UP: {
                            double Area1 = 0.5*Math.abs(height*(j));
                            double Area2 = 0.5*Math.abs(width*(i));
                            double Area3 = 0.5*Math.abs((j)*height+width*(i-height));
                            if (AreaRight >= Area1 + Area2 + Area3 && height*j != (height-i)*width){
                                grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                            break;
                        case RIGHT_DOWN: {
                            double Area1 = 0.5*Math.abs(height*(width-(j+1)));
                            double Area2 = 0.5*Math.abs(width*(height-(i+1)));
                            double Area3 = 0.5*Math.abs((j+1)*height+width*(i+1-height));
                            double Area1Modi = 0.5*Math.abs(height*(width-(j+0.99)));
                            double Area3Modi = 0.5*Math.abs((j+0.99)*height+width*(i+1-height));
                            if (AreaRight == Area1 + Area2 + Area3 && AreaRight >= Area1Modi + Area2 + Area3Modi){
                                        grids[i][j] = pattern;
                            } else {
                                grids[i][j] = ' ';
                            }
                        }
                        break;
                    }
                }
            }
        }

    public void enlarge() {
        width +=1;
        height+=1;
        fillGrids();
    }

    public void shrink() {
        width -= 1;
        height -= 1;
        fillGrids();
    }
    public int area() {
        int k = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if(grids[i][j] == pattern){
                    k += 1;
                }
            }
        }
        return k;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", location.getX(), location.getY(), area(), pattern);
    };
}
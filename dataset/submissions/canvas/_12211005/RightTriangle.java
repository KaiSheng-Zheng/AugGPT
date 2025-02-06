public class RightTriangle extends Shape{
    private int width;
    private int height;
    private Direction d;
    private int areacount;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }

    public void fillGrids(){
        grids = new char[height][width];
        double slope = (double) height / (double) width;
        for (int i = 1; i <= width; i++) {
            for (int j = 1;j<= height;j++) {
                    grids[j-1][i-1] = ' ';
            }
        }
        switch (d) {
            case RIGHT_UP:
                for (int i = 1; i <= width; i++) {
                    for (int j = 1;j<= height;j++) {
                        double testslope = Math.abs((double) (j-1-height) / (double) (i-width));
                        if(testslope>slope){
                            grids[j-1][i-1] = pattern;
                            areacount++;
                        }
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 1; i <= width; i++) {
                    for (int j = 1;j<= height;j++) {
                        double testslope = Math.abs((double) (j-height) / (double) (i));
                        if(testslope<slope){
                            grids[j-1][i-1] = pattern;
                            areacount++;
                        }
                    }
                }
                break;
            case LEFT_UP:
                for (int i = 1; i <= width; i++) {
                    for (int j = 1;j<= height;j++) {
                        double testslope = Math.abs((double) (j-1-height) / (double) (i-1));
                        if(testslope>slope){
                            grids[j-1][i-1] = pattern;
                            areacount++;
                        }
                    }
                }
                break;
            case LEFT_DOWN:
                for (int i = 1; i <= width; i++) {
                    for (int j = 1;j<= height;j++) {
                        double testslope = Math.abs((double) (j-height) / (double) (i-1-width));
                        if(testslope<slope){
                        grids[j-1][i-1] = pattern;
                            areacount++;
                        }
                    }
                }
                break;
        }
    }
    public void enlarge(){
        width++;
        height++;
        areacount=0;
        fillGrids();
    }
    public void shrink(){
        width--;
        height--;
        areacount=0;
        fillGrids();
    }
    public int area(){
        return areacount;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",super.getLocation().getX(),super.getLocation().getY(),this.area(),super.getPattern());
    }
}

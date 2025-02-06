public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.pattern = pattern;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        switch (d){
            case LEFT_UP -> buildLeftUp();
            case LEFT_DOWN -> buildLeftDown();
            case RIGHT_UP -> buildRightUp();
            case RIGHT_DOWN -> buildRightDown();
        }
    }
    public void buildLeftUp(){
        grids = new char[height][width];
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                double iR = (double) i / height;
                double jR = (double) j / width;
                if(iR + jR < 0.999999){
                    grids[i][j] = pattern;
                }else {
                    grids[i][j] = ' ';
                }
            }
        }
    }
    public void buildLeftDown(){
        grids = new char[height][width];
        for(int i = 1 ; i <= height ; i++){
            for(int j = 0 ; j < width ; j++){
                double iR = (double) i / height;
                double jR = (double) j / width;
                if(1 - iR + jR < 0.999999){
                    grids[i-1][j] = pattern;
                }else {
                    grids[i-1][j] = ' ';
                }
            }
        }
    }
    public void buildRightUp(){
        grids = new char[height][width];
        for(int i = 0 ; i < height ; i++){
            for(int j = 1 ; j <= width ; j++){
                double iR = (double) i / height;
                double jR = (double) j / width;
                if(iR + 1 - jR < 0.999999){
                    grids[i][j-1] = pattern;
                }else {
                    grids[i][j-1] = ' ';
                }
            }
        }
    }
    public void buildRightDown(){
        grids = new char[height][width];
        for(int i = 1 ; i <= height ; i++){
            for(int j = 1 ; j <= width ; j++){
                double iR = (double) i / height;
                double jR = (double) j / width;
                if(iR + jR > 1.000001){
                    grids[i-1][j-1] = pattern;
                }else {
                    grids[i-1][j-1] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }

    @Override
    public void shrink() {
        width--;
        height--;
        fillGrids();
    }

    @Override
    public int area() {
        int cnt = 0;
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                if(grids[i][j] == pattern){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    @Override
    public String toString() {
        return String.format("RightTriangle: %s area=%d pattern=%c", location, area(), pattern);
    }
//    public static void main(String[] args) {
//        Location p1 = new Location(0, 1);
//        Shape s1 = new RightTriangle(p1, 'X', 7, 3, Direction.RIGHT_UP);
//        char[][] grids = s1.getGrids();
//        for (char[] line : grids) {
//            System.out.println(line);
//        }
//        System.out.printf("Grids height = %d, width = %d\n", grids.length, grids[0].length);
//        System.out.println(s1);
//        s1.enlarge();
//        grids = s1.getGrids();
//        for (char[] line : grids) {
//            System.out.println(line);
//        }
//        System.out.printf("Grids height = %d, width = %d\n", grids.length, grids[0].length);
//        System.out.println(s1);
//    }
}

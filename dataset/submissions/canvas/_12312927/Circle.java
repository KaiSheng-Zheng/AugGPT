public class Circle extends Shape {
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        this.pattern = pattern;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[2 * radius][2 * radius];
        for (int i = 0 ; i < 2 * radius ; i++){
            for (int j = 0 ; j < 2 * radius ; j++){
                if(((i - radius) * (i - radius)) + ((j - radius) * (j - radius)) < (radius * radius) || ((i - radius + 1) * (i - radius + 1)) + ((j - radius) * (j - radius)) < (radius * radius) || ((i - radius) * (i - radius)) + ((j + 1 - radius) * (j + 1 - radius)) < (radius * radius) || ((i + 1 - radius) * (i + 1 - radius)) + ((j + 1 - radius) * (j + 1 - radius)) < (radius * radius)){
                    grids[i][j] = pattern;
                }else {
                    grids[i][j] = ' ';
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
        int cnt = 0;
        for (int i = 0 ; i < 2 * radius ; i++){
            for (int j = 0 ; j < 2 * radius ; j++){
                if(grids[i][j] == pattern){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    @Override
    public String toString() {
        return String.format("Circle: %s area=%d pattern=%c", location, area(), pattern);
    }
//    public static void main(String[] args) {
//        Location p1 = new Location(1, 0);
//        Shape s1 = new Circle(p1, '*', 5);
//        char[][] grids = s1.getGrids();
//        for (char[] grid : grids) {
//            System.out.println(grid);
//        }
//        System.out.printf("Grids: height = %d, width = %d\n", grids.length, grids[0].length);
//        System.out.println(s1);
//        s1.shrink();
//        grids = s1.getGrids();
//        for (char[] grid : grids) {
//            System.out.println(grid);
//        }
//        System.out.printf("Grids: height = %d, width = %d\n", grids.length, grids[0].length);
//        System.out.println(s1);
//    }
}

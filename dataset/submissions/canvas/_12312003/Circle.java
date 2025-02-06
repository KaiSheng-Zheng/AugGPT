public class Circle extends Shape{
    private int radius;
    int circleCount;

    public Circle(Location location, char pattern, int radius) {
        super(pattern, location);
        this.radius=radius;
        fillGrids();
    }

    @Override
    public void enlarge() {
        this.radius++;
        fillGrids();
    }

    @Override
    public char[][] fillGrids() {
        circleCount=0;
        char [][]grid = new char[radius*2][radius*2];
        for (int i = 1; i <= radius; i++) {
            for (int j = 1; j <= radius; j++) {
                double distance=Math.pow(i-radius,2) + Math.pow(j-radius,2);
                if(distance<radius*radius){
                    grid[i-1][j-1]=pattern;
                    grid[2*radius-i][j-1]=pattern;
                    grid[i-1][2*radius-j]=pattern;
                    grid[2*radius-i][2*radius-j]=pattern;
                    circleCount++;
                }else{
                    grid[i-1][j-1]=' ';
                    grid[2*radius-i][j-1]=' ';
                    grid[i-1][2*radius-j]=' ';
                    grid[2*radius-i][2*radius-j]=' ';
                }
            }
            setGrids(grid);
        }
        return grid;
    }
    @Override
    public void shrink() {
        this.radius--;
        fillGrids();
    }

    @Override
    public int area() {
        return 4*circleCount;
    }

    public String toString() {
        return String.format("Circle: %s area=%d pattern=%c",location.toString(),area(),pattern);
    }
}


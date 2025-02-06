public class Circle extends Shape{
    private int radius;
    private int area;
    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
        grids = new char[radius * 2][radius * 2];
        for (int i = 0; i < radius * 2; i++){
            for (int j = 0; j < radius * 2; j++){
                grids[i][j] = ' ';
            }
        }
        fillGrids();
    }

    public boolean judgeDistance(int i,int j){
        double center_X = 0.5 * (2 * radius);
        double center_Y = 0.5 * (2 * radius);
        if (Math.pow((i - center_X),2) + Math.pow(j - center_Y,2) < Math.pow(radius,2)){
            return true;
        } else if (Math.pow((i + 1 - center_X),2) + Math.pow(j - center_Y,2) < Math.pow(radius,2)) {
            return true;
        } else if (Math.pow((i - center_X),2) + Math.pow(j + 1 - center_Y,2) < Math.pow(radius,2)) {
            return true;
        }else if (Math.pow((i + 1 - center_X),2) + Math.pow(j + 1 - center_Y,2) < Math.pow(radius,2)) {
            return true;
        }else if (Math.pow((i + 1 - center_X),2) + Math.pow(j + 0.5 - center_Y,2) == Math.pow(radius,2)) {
            return true;
        } else if (Math.pow((i - center_X),2) + Math.pow(j + 0.5 - center_Y,2) == Math.pow(radius,2)) {
            return true;
        } else if (Math.pow((i + 0.5 - center_X),2) + Math.pow(j + 1 - center_Y,2) == Math.pow(radius,2)) {
            return true;
        } else if (Math.pow((i + 0.5 - center_X),2) + Math.pow(j - center_Y,2) == Math.pow(radius,2)) {
            return true;
        }else return false;
    }

    public void fillGrids(){
        for (int i = 0;i < grids.length;i++){
            for (int j = 0;j < grids[i].length;j++){
                if (judgeDistance(i, j)){
                    grids[i][j] = pattern;
                }else grids[i][j] = ' ';
            }
        }
    }

    public String toString(){
        return String.format("Circle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),this.area(),pattern);
    }

    @Override
    public void setGrids(char[][] grids) {
        grids = new char[radius * 2][radius * 2];
        this.grids = grids;
    }

    @Override
    public void enlarge() {
        radius += 1;
        char[][] gridsNew = new char[radius * 2][radius * 2];
        setGrids(gridsNew);
        fillGrids();
    }

    @Override
    public void shrink() {
        radius -= 1;
        char[][] gridsNew = new char[radius * 2][radius * 2];
        setGrids(gridsNew);
        fillGrids();
    }

    @Override
    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public int area() {
        int area = 0;
        for (int i = 0;i < grids.length;i++){
            for (int j = 0;j < grids[i].length;j++){
                if (grids[i][j] == pattern){
                    area++;
                }
            }
        }
        this.area = area;
        return this.area;
    }
}
public class Circle extends Shape{

    private int area = 0;

    private int radius;

    public Circle(Location location, char pattern, int radius){
        super(pattern, location);
        this.radius = radius;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[radius*2][radius*2];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids.length; j++) {
                int x;
                int y;
                if(i<radius && j<radius){
                    x = i+1;
                    y = j+1;
                }else if(i<radius && j>=radius){
                    x=i+1;
                    y=j;
                }else if(i>=radius && j<radius ){
                    x = i;
                    y = j+1;
                }else{
                    x = i;
                    y = j ;
                }
                double distanceToCenter = Math.sqrt(Math.pow(radius - x, 2) + Math.pow(radius - y, 2));
                if(distanceToCenter < radius){
                    grids[i][j] = pattern;
                    area++;
                }else{
                    grids[i][j] = ' ';
                }

            }
        }
    }

    @Override
    public void enlarge() {
        this.radius = radius+1;
        this.area = 0;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.radius = radius-1;
        this.area = 0;
        fillGrids();
    }

    @Override
    public int area() {
        return area;
    }

    @Override
    public String toString() {
        return "Circle: "+location.toString()+" area="+area+" pattern="+pattern;
    }
}
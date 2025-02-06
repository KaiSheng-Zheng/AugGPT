import java.util.Objects;

public class Circle extends Shape{
    private int radius;
    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        this.radius=radius;
        fillGrids();
    }
    @Override
    public void fillGrids(){
        char[][] grids=new char[2*radius][2*radius];
        for (int i = 0; i < radius; i++) {
            for (int j = 0; j < Math.ceil(Math.sqrt(radius*radius-i*i)); j++) {
                grids[radius-i-1][radius-j-1]=pattern;
                grids[radius-i-1][radius+j]=pattern;
                grids[radius+i][radius-j-1]=pattern;
                grids[radius+i][radius+j]=pattern;
            }
        }
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (!Objects.equals(grids[i][j],pattern)){
                    grids[i][j]=' ';
                }
            }
        }
        super.grids=grids;
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
        int area=0;
        for (int i = 0; i < getGrids().length; i++) {
            for (int j = 0; j < getGrids()[i].length; j++) {
                if (Objects.equals(getGrids()[i][j],pattern)){
                    area++;
                }
            }
        }
        return area;
    }

    @Override
    public String toString() {
        return "Circle: " +
                location + " " +
                "area=" + area() + " " +
                "pattern=" + pattern;
    }
}
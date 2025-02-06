import java.awt.*;
import java.util.Objects;

public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        char[][] grids=new char[height][width];
        switch (d){
            case LEFT_UP -> {
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < Math.ceil((double) ((height - i) * width) /height); j++) {
                        grids[i][j]=pattern;
                    }
                }
            }
            case RIGHT_UP -> {
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < Math.ceil((double) ((height - i) * width) /height); j++) {
                        grids[i][width-j-1]=pattern;
                    }
                }
            }
            case LEFT_DOWN -> {
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < Math.ceil((double) ((height - i) * width) /height); j++) {
                        grids[height-i-1][j]=pattern;
                    }
                }
            }
            case RIGHT_DOWN -> {
                for (int i = 0; i < grids.length; i++) {
                    for (int j = 0; j < Math.ceil((double) ((height - i) * width) /height); j++) {
                        grids[height-i-1][width-j-1]=pattern;
                    }
                }
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
        return "RightTriangle: " +
                location + " " +
                "area=" + area() + " " +
                "pattern=" + pattern;
    }
}

import javax.swing.*;

public class RightTriangle extends Shape{
    private int width;
    private int height;
    private int area;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        grids = new char[height][width];
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                grids[i][j] = ' ';
            }
        }
        fillGrids();
    }

    public void fillGrids(){
        double slope = height * 1.000 / width;
        if (d == Direction.RIGHT_DOWN){
            for (double i = 0.0; i < height; i++){
                for (double j = 0.0; j < width; j++){
                    int times = 0;
                    if (width - j != 0){
                        if (i / (width - j) > slope){
                            times++;
                        }
                        if ((i + 1) / (width - j) > slope){
                            times++;
                        }
                    }else times++;
                    if (width - j - 1 != 0){
                        if (i / (width - j - 1) > slope){
                            times++;
                        }
                        if ((i + 1) / (width - j - 1) > slope){
                            times++;
                        }
                    }else times++;
                    if (times < 1)grids[(int)i][(int)j] = ' ';
                    else grids[(int)i][(int)j] = pattern;
                }
            }
        }
        else if (d == Direction.LEFT_DOWN){
            for (double i = 0.0; i < height; i++){
                for (double j = 0.0; j < width; j++){
                    int times = 0;
                    if (j != 0){
                        if (i / j > slope){
                            times++;
                        }
                        if ((i + 1) / j > slope){
                            times++;
                        }
                    }else times++;
                    if (j + 1 != 0){
                        if (i / (j + 1) > slope){
                            times++;
                        }
                        if ((i + 1) / (j + 1) > slope){
                            times++;
                        }
                    }else times++;
                    if (times < 1)grids[(int)i][(int)j] = ' ';
                    else grids[(int)i][(int)j] = pattern;
                }
            }
        }
        else if (d == Direction.LEFT_UP){
            for (double i = 0.0; i < height; i++){
                for (double j = 0.0; j < width; j++){
                    int times = 0;
                    if (width - j != 0){
                        if (i / (width - j) < slope){
                            times++;
                        }
                        if ((i + 1) / (width - j) < slope){
                            times++;
                        }
                    }
                    if (width - i - 1 != 0){
                        if (i / (width - j - 1) < slope){
                            times++;
                        }
                        if ((i + 1) / (width - j - 1) < slope){
                            times++;
                        }
                    }
                    if (times < 1)grids[(int)i][(int)j] = ' ';
                    else grids[(int)i][(int)j] = pattern;
                }
            }
        }
        else if (d == Direction.RIGHT_UP){
            for (double i = 0.0; i < height; i++){
                for (double j = 0.0; j < width; j++){
                    int times = 0;
                    if (j != 0){
                        if (i / j < slope){
                            times++;
                        }
                        if ((i + 1) / j < slope){
                            times++;
                        }
                    }
                    if (i + 1 != 0){
                        if (i / (j + 1) < slope){
                            times++;
                        }
                        if ((i + 1) / (j + 1) < slope){
                            times++;
                        }
                    }
                    if (times < 1)grids[(int)i][(int)j] = ' ';
                    else grids[(int)i][(int)j] = pattern;
                }
            }
        }
    }

    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),this.area(),pattern);
    }

    @Override
    public void setGrids(char[][] grids) {
        grids = new char[height][width];
        this.grids = grids;
    }

    @Override
    public void enlarge() {
        width += 1;
        height += 1;
        char[][] gridsNew = new char[height][width];
        setGrids(gridsNew);
        fillGrids();
    }

    @Override
    public void shrink() {
        width -= 1;
        height -= 1;
        char[][] gridsNew = new char[height][width];
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
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                if (grids[j][i] == pattern){
                    area ++;
                }
            }
        }
        this.area = area;
        return this.area;
    }
}
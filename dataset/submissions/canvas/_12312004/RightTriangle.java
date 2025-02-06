import java.util.Arrays;
public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        this.fillGrids();
    }
    @Override
    public void fillGrids() {
        char[][] chars = new char[height][width];
        double tan=(double) width/height;
        switch (d) {
            case LEFT_DOWN:
                for (int i=0;i<height;i++){
                    for (int j=0;j<width;j++){
                        chars[i][j]=' ';
                    }
                }
                for (int i = 0; i < height; i++)
                    for (int k = 0; k < (i + 1) * tan; k++) {
                        chars[i][k] = pattern;
                    }
                break;
            case LEFT_UP:
                for (int i=0;i<height;i++){
                    for (int j=0;j<width;j++){
                        chars[i][j]=' ';
                    }
                }
                for (int i = 0; i < height; i++)
                    for (int k = 0; k < (i + 1) * tan; k++) {
                        chars[height-1-i][k] = pattern;
                    }
                break;
            case RIGHT_UP:
                for (int i=0;i<height;i++){
                    for (int j=0;j<width;j++){
                        chars[i][j]=' ';
                    }
                }
                for (int i = 0; i < height; i++)
                    for (int k = 0; k < (i + 1) * tan; k++) {
                        chars[height-1-i][width-1-k] = pattern;
                    }
                break;
            case RIGHT_DOWN:
                for (int i=0;i<height;i++){
                    for (int j=0;j<width;j++){
                        chars[i][j]=' ';
                    }
                }
                for (int i = 0; i < height; i++) {
                    for (int k = 0; k < (i + 1) * tan; k++) {
                        chars[i][width-1-k] =pattern;
                    }
                }
                break;
        }
        super.setGrids(chars);
    }

    @Override
    public void enlarge() {
        this.height = height + 1;
        this.width = width + 1;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.height = height - 1;
        this.width = width - 1;
        fillGrids();
    }

    @Override
    public int area() {
        int a = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (this.grids[i][j] == pattern)
                    a++;
            }
        }
        return a;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c", getLocation().getX(), getLocation().getY(),area(),pattern);
    }
}

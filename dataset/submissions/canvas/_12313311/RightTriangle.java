import java.util.Comparator;

public class RightTriangle extends Shape{
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }

    public void fillGrids() {
        grids=new char[height][width];
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                grids[i][j]=' ';
            }
        }
        //slope=height/width
        if(d==Direction.LEFT_DOWN) {
            for(int i=0;i<height;i++) {
                for(int j=0;j<width;j++) {
                    if((i+1)*width>height*j) {
                        grids[i][j]=pattern;
                    }
                }
            }
        }
        //slope=
        else if(d==Direction.LEFT_UP) {
            for(int i=0;i<height;i++) {
                for(int j=0;j<width;j++) {
                    if((height-i)*width>height*j) {
                        grids[i][j]=pattern;
                    }
                }
            }
        }
        else if(d==Direction.RIGHT_DOWN) {
            for(int i=0;i<height;i++) {
                for(int j=0;j<width;j++) {
                    if((i+1)*width>height*(width-1-j)) {
                        grids[i][j]=pattern;
                    }
                }
            }
        }
        else {
            for(int i=0;i<height;i++) {
                for(int j=0;j<width;j++) {
                    if((height-i)*width>height*(width-1-j)) {
                        grids[i][j]=pattern;
                    }
                }
            }
        }
    }

    public void enlarge() {
        this.height+=1;
        this.width+=1;
        fillGrids();
    }

    public void shrink() {
        this.height-=1;
        this.width-=1;
        fillGrids();
    }

    public int area() {
        int area=0;
        for(int i=0;i<height;i++) {
            for(int j=0;j<width;j++) {
                if(grids[i][j]==pattern)
                    area++;
            }
        }
        return area;
    }

    public String toString() {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }
}

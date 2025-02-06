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
        char[][] grids1= new char[height][width];
        switch(this.d) {
            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if((width*(i+1)-height*j)>0){
                            grids1[i][j]=pattern;
                        }
                        else {
                            grids1[i][j]=' ';
                        }
                    }
                }
                super.grids=grids1;
                break;
            case RIGHT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if((width*i-height*(j+1))<0){
                            grids1[i][j]=pattern;
                        }
                        else {
                            grids1[i][j]=' ';
                        }
                    }
                }
                super.grids=grids1;
                break;
            case LEFT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if((j*height+i*width)<width*height){
                            grids1[i][j]=pattern;
                        }
                        else {
                            grids1[i][j]=' ';
                        }
                    }
                }
                super.grids=grids1;
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if(((j+1)*height+(i+1)*width)>width*height){
                            grids1[i][j]=pattern;
                        }
                        else {
                            grids1[i][j]=' ';
                        }
                    }
                }
                super.grids=grids1;
                break;
        }
    }

    @Override
    public void enlarge() {
        height++;
        width++;
        fillGrids();
    }

    @Override
    public void shrink() {
        height--;
        width--;
        fillGrids();
    }

    @Override
    public int area() {
        int cout = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(super.grids[i][j]==pattern){
                    cout++;
                }
            }
        }
        return cout;
    }
    public String toString(){
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),area(),pattern);
    }
}

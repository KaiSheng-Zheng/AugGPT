public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        super.grids=new char[height][width];
        switch (d){
            case LEFT_UP -> {
                double k= (double) height / width;
                int intercept=-1*height;
                for (int i = 0; i <height; i++) {
                    for (int j = 0; j <width; j++) {
                        if(j*k+intercept<-1*i){
                            grids[i][j]=pattern;
                        }
                        else {grids[i][j]=' ';}
                    }
                }
                break;
            }
            case RIGHT_UP -> {
                double k= (double) -1*height / width;
                int intercept=0;
                for (int i = 0; i <height; i++) {
                    for (int j = 0; j <width; j++) {
                        if((j+1)*k+intercept<-1*i){
                            grids[i][j]=pattern;
                        }
                        else {grids[i][j]=' ';}
                    }
                }
                break;
            }
            case LEFT_DOWN -> {
                double k= (double) -1*height / width;
                int intercept=0;
                for (int i = 0; i <height; i++) {
                    for (int j = 0; j <width; j++) {
                        if(j*k+intercept>-1*i-1){
                            grids[i][j]=pattern;
                        }
                        else {grids[i][j]=' ';}
                    }
                }
                break;
            }
            case RIGHT_DOWN -> {
                double k= (double) height / width;
                int intercept=-1*height;
                for (int i = 0; i <height; i++) {
                    for (int j = 0; j <width; j++) {
                        if((j+1)*k+intercept>-1*i-1){
                            grids[i][j]=pattern;
                        }
                        else {grids[i][j]=' ';}
                    }
                }
                break;
            }
        }
    }

    @Override
    public void enlarge() {
        width=width+1;
        height=height+1;
        super.grids=new char[height][width];
        fillGrids();
    }
    public char getPattern() {
        return super.pattern;
    }
    @Override
    public void shrink() {
        width=width-1;
        height=height-1;
        super.grids=new char[height][width];
        fillGrids();
    }

    @Override
    public int area() {
        return count();
    }

    @Override
    public String toString() {
        return "RightTriangle: ("+ location.getX()+','+location.getY()+") area="+area()+" pattern="+pattern;
    }
}

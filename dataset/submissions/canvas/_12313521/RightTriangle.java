public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;
    private int sum=0;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids=new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j]=' ';
            }
        }
        if(d == Direction.LEFT_UP){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)i /(width-j)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
        if(d == Direction.RIGHT_UP){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)i /(j+1)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
        if(d == Direction.LEFT_DOWN){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double) (height-i-1) /(width-j)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
        if(d == Direction.RIGHT_DOWN){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)(height-i-1) /(j+1)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
    }

    @Override
    public void enlarge() {
        sum=0;
        height=height+1;
        width=width+1;
        grids=new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j]=' ';
            }
        }
        if(d == Direction.LEFT_UP){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)i /(width-j)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
        if(d == Direction.RIGHT_UP){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)i /(j+1)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
        if(d == Direction.LEFT_DOWN){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double) (height-i-1) /(width-j)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
        if(d == Direction.RIGHT_DOWN){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)(height-i-1) /(j+1)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
    }

    @Override
    public void shrink() {
        sum=0;
        height=height-1;
        width=width-1;
        grids=new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grids[i][j]=' ';
            }
        }
        if(d == Direction.LEFT_UP){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)i /(width-j)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
        if(d == Direction.RIGHT_UP){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)i /(j+1)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
        if(d == Direction.LEFT_DOWN){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double) (height-i-1) /(width-j)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
        if(d == Direction.RIGHT_DOWN){
            double k= (double) height /width;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if((double)(height-i-1) /(j+1)<k){
                        grids[i][j]=pattern;
                        sum++;
                    }
                }
            }
        }
    }

    @Override
    public int area() {
        return sum;
    }
    public String toString(){
        return "RightTriangle: "+"("+location.getX()+","+location.getY()+")"+" area="+sum+" pattern="+pattern;
    }
}

public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.height=height;
        this.width=width;
        this.d=d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        grids=new char[height][width];
        if(d==Direction.LEFT_DOWN){double k=1.0*height/width;
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j <width ; j++) {
                if(j==0){grids[i][j]=pattern;count++;}
                else{
                    if(1.0*i/j<=k&&1.0*(i+1)/j<=k&&1.0*(i+1)/(j+1)<=k&&1.0*i/(j+1)<=k&&1.0*(i+1)/(j+1)<=k){
                        grids[i][j]=' ';
                    }
                    else{grids[i][j]=pattern;count++;}
                }
            }
        }}
        if(d==Direction.RIGHT_UP){double k=1.0*height/width;
            for (int i = 0; i <height ; i++) {
                for (int j = 0; j <width ; j++) {
                    if(j==width-1){grids[i][j]=pattern;count++;}
                    else{
                        if(1.0*i/j>=k&&1.0*(i+1)/j>=k&&1.0*(i+1)/(j+1)>=k&&1.0*i/(j+1)>=k&&1.0*(i+1)/(j+1)>=k){
                            grids[i][j]=' ';
                        }
                        else{grids[i][j]=pattern;count++;}
                    }
                }
            }}
        if(d==Direction.RIGHT_DOWN){
            double k=1.0*height/width;
            for (int i = 0; i <height ; i++) {
                for (int j = 0; j <width ; j++) {
                    if(j==0){grids[i][j]=pattern;count++;}
                    else{
                        if(1.0*i/j<=k&&1.0*(i+1)/j<=k&&1.0*(i+1)/(j+1)<=k&&1.0*i/(j+1)<=k&&1.0*(i+1)/(j+1)<=k){
                            grids[i][j]=' ';
                        }
                        else{grids[i][j]=pattern;count++;}
                    }
                }
            }
            char[][]list=new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j <width ; j++) {
                    list[i][width-1-j]=grids[i][j];
                }
            }
            grids=list;
        }
        if(d==Direction.LEFT_UP){
            double k=1.0*height/width;
            for (int i = 0; i <height ; i++) {
                for (int j = 0; j <width ; j++) {
                    if(j==width-1){grids[i][j]=pattern;count++;}
                    else{
                        if(1.0*i/j>=k&&1.0*(i+1)/j>=k&&1.0*(i+1)/(j+1)>=k&&1.0*i/(j+1)>=k&&1.0*(i+1)/(j+1)>=k){
                            grids[i][j]=' ';
                        }
                        else{grids[i][j]=pattern;count++;}
                    }
                }
            }
            char[][]list=new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    list[i][width-1-j]=grids[i][j];
                }
            }
            grids=list;
        }

    }

    @Override
    public void enlarge() {
        width++;height++;
        count=0;
        fillGrids();
    }

    @Override
    public void shrink() {
        width--;height--;
        count=0;
        fillGrids();
    }

    @Override
    public int area() {
        int s=0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if(grids[i][j]!=' '){s++;}
            }
        }
        return s;
    }
    public String toString(){
        return "RightTriangle: "+"("+location.getX()+","+location.getY()+") "+"area="+area()+" pattern="+pattern;
    }
}

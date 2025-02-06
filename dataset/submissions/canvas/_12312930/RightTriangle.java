public class RightTriangle extends Shape implements Comparable<Shape>{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        repaint();
        fillGrids();
    }

    @Override
    public void fillGrids() {
        for(int i=0;i<height;i++){for(int j=0;j<width;j++){grids[i][j]=' ';}}
        if (this.d==Direction.RIGHT_UP){
            grids[0][0]=pattern;
            for(int i=0;i<height+1;i++){
                for(int j=1;j<width+1;j++){
                    double slope=(double) height/width;
                    double k=(double) i/j;
                    if(k<slope){
                        if(i-1>=0){grids[i-1][j-1]=pattern;}
                        if(i<height){grids[i][j-1]=pattern;}
                        if(i-1>=0&&j<width){grids[i-1][j]=pattern;}
                        if(i<height&&j<width){grids[i][j]=pattern;}
                    }
                }
            }
        }
        if (this.d==Direction.LEFT_UP){
            grids[0][width-1]=pattern;
            for(int i=0;i<height+1;i++){
                for(int j=0;j<width;j++){
                    double slope=(double) height/width;
                    double k=(double) i/(width-j);
                    if(k<slope){
                        if(i-1>=0&&j-1>=0){grids[(i-1)][j-1]=pattern;}
                        if(i<height&&j-1>=0){grids[i][j-1]=pattern;}
                        if(i-1>=0&&j<width){grids[i-1][j]=pattern;}
                        if(i<height&&j<width){grids[i][j]=pattern;}
                    }
                }
            }
        }
        if (this.d==Direction.LEFT_DOWN){
            for(int i=0;i<height;i++){
                grids[i][0]=pattern;
            }

            for(int i=0;i<height+1;i++){
                for(int j=1;j<width+1;j++){
                    double slope=(double) height/width;
                    double k=(double) i/j;
                    if(k>slope){
                        if(i-1>=0){grids[i-1][j-1]=pattern;}
                        if(i<height){grids[i][j-1]=pattern;}
                        if(i-1>=0&&j<width){grids[i-1][j]=pattern;}
                        if(i<height&&j<width){grids[i][j]=pattern;}
                    }
                }
            }
        }
        if (this.d==Direction.RIGHT_DOWN){
            for(int i=0;i<height;i++){
                grids[i][width-1]=pattern;
            }
            for(int i=0;i<height+1;i++){
                for(int j=0;j<width;j++){
                    double slope=(double) height/width;
                    double k=(double) i/(width-j);
                    if(k>slope){
                        if(i-1>=0&&j-1>=0){grids[(i-1)][j-1]=pattern;}
                        if(i<height&&j-1>=0){grids[i][j-1]=pattern;}
                        if(i-1>=0&&j<width){grids[i-1][j]=pattern;}
                        if(i<height&&j<width){grids[i][j]=pattern;}
                    }
                }
            }
        }



    }

    @Override
    public void enlarge() {
        height++;
        width++;
        repaint();
        fillGrids();
    }

    @Override
    public void shrink() {
        height--;
        width--;
        repaint();
        fillGrids();
    }

    @Override
    public int area() {
        int t=0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                {if(grids[i][j] == pattern)
                {t++;}
                }
            }
        }
        return t;
    }
    public String toString() {
        return "RightTriangle: "+location.toString()+" area="+ this.area()+" pattern="+pattern;
    }
    public void repaint(){
        grids=new char[height][width];
    }

    @Override
    public int compareTo(Shape o) {
        return 0;
    }
}

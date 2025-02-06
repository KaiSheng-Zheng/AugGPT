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
        grids=new char[height][width];
        for(int i=0;i<height;i++)
            for(int j=0;j<width;j++)
                grids[i][j]=' ';
        if(d==Direction.RIGHT_UP){
            for(int i=1;i<=height;i++)
                for(int j=1;j<=width;j++)
                    if(j == 1 || i * 1.0 / (j * 1.0 - 1.0) > 1.0 * height / (1.0 * width))
                        grids[height-i][width-j]=pattern;
        }
        if(d==Direction.RIGHT_DOWN){
            for(int i=1;i<=height;i++)
                for(int j=1;j<=width;j++)
                    if(j == 1 || i * 1.0 / (j * 1.0 - 1.0) > 1.0 * height / (1.0 * width))
                        grids[i-1][width-j]=pattern;
        }
        if(d==Direction.LEFT_DOWN){
            for(int i=1;i<=height;i++)
                for(int j=1;j<=width;j++)
                    if(j == 1 || i * 1.0 / (j * 1.0 - 1.0) > 1.0 * height / (1.0 * width))
                        grids[i-1][j-1]=pattern;
        }
        if(d==Direction.LEFT_UP){
            for(int i=1;i<=height;i++)
                for(int j=1;j<=width;j++)
                    if(j == 1 || i * 1.0 / (j * 1.0 - 1.0) > 1.0 * height / (1.0 * width))
                        grids[height-i][j-1]=pattern;
        }
    }

    @Override
    public void enlarge() {
        // incorrect implementation
        height++;
        width++;
        int h=height;
        int w=width;
        grids=new char[h][w];
        for(int i=0;i<h;i++)
            for(int j=0;j<w;j++)
                grids[i][j]=' ';
        if(d==Direction.RIGHT_UP){
            for(int i=-1;i<height-1;i++)
                for(int j=-1;j<width-1;j++)
                    if((j == -1&&i==-1) || i * 1.0 / (j * 1.0 + 1.0) < 1.0 * height / (1.0 * width))
                        grids[i+1][j+1]=pattern;
        }
        if(d==Direction.RIGHT_DOWN){
            for(int i=1;i<=height;i++)
                for(int j=1;j<=width;j++)
                    if(j == 1 || i * 1.0 / (j * 1.0 - 1.0) > 1.0 * height / (1.0 * width))
                        grids[i-1][width-j]=pattern;
        }
        if(d==Direction.LEFT_DOWN){
            for(int i=1;i<=height;i++)
                for(int j=1;j<=width;j++)
                    if(j == 1 || i * 1.0 / (j * 1.0 - 1.0) > 1.0 * height / (1.0 * width))
                        grids[i-1][j-1]=pattern;
        }
        if(d==Direction.LEFT_UP){
            for(int i=1;i<=height;i++)
                for(int j=1;j<=width;j++)
                    if(j == 1 || i * 1.0 / (j * 1.0 - 1.0) > 1.0 * height / (1.0 * width))
                        grids[height-i][j-1]=pattern;
        }
    }

    @Override
    public void shrink() {
        width--;
        height--;
        int h=height;
        int w=width;
        grids=new char[h][w];
        for(int i=0;i<h;i++)
            for(int j=0;j<w;j++)
                grids[i][j]=' ';
        if(d==Direction.RIGHT_UP){
            for(int i=-1;i<height-1;i++)
                for(int j=-1;j<width-1;j++)
                    if((j == -1&&i==-1) || i * 1.0 / (j * 1.0 + 1.0) < 1.0 * height / (1.0 * width))
                        grids[i+1][j+1]=pattern;
        }
        if(d==Direction.RIGHT_DOWN){
            for(int i=1;i<=height;i++)
                for(int j=1;j<=width;j++)
                    if(j == 1 || i * 1.0 / (j * 1.0 - 1.0) > 1.0 * height / (1.0 * width))
                        grids[i-1][width-j]=pattern;
        }
        if(d==Direction.LEFT_DOWN){
            for(int i=1;i<=height;i++)
                for(int j=1;j<=width;j++)
                    if(j == 1 || i * 1.0 / (j * 1.0 - 1.0) > 1.0 * height / (1.0 * width))
                        grids[i-1][j-1]=pattern;
        }
        if(d==Direction.LEFT_UP){
            for(int i=1;i<=height;i++)
                for(int j=1;j<=width;j++)
                    if(j == 1 || i * 1.0 / (j * 1.0 - 1.0) > 1.0 * height / (1.0 * width))
                        grids[height-i][j-1]=pattern;
        }
    }

    @Override
    public int area() {
        int sum=0;
        for (char[] grid : grids)
            for (char c : grid)
                if (c == pattern)
                    sum++;
        return sum;
    }

    @Override
    public String toString() {
        String s;
        s="RightTriangle: ("+location.getX()+","+location.getY()+") area="+area()+" pattern="+pattern;
        return s;
    }
}

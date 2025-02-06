public class RightTriangle extends Shape {
    private int width;
    private int height;
    private Direction d;
    private int count;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.location = location;
        this.pattern = pattern;
        this.width = width;
        this.height=height;
        this.d=d;
        count=0;
        this.grids=new char[height][width];
        if(d==Direction.LEFT_DOWN) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*(height-i-1)/height;
                    float b=1f*j/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d==Direction.LEFT_UP) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*i/height;
                    float b=1f*j/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d==Direction.RIGHT_DOWN) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*(height-i-1)/height;
                    float b=1f*(width-j-1)/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }else{
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*i/height;
                    float b=1f*(width-j-1)/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }
    }

    public void fillGrids() {
        count=0;
        this.grids=new char[height][width];
        if(d==Direction.LEFT_DOWN) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*(height-i-1)/height;
                    float b=1f*j/width;
                    System.out.println(a);
                    System.out.println(b);
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d==Direction.LEFT_UP) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*i/height;
                    float b=1f*j/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d==Direction.RIGHT_DOWN) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*(height-i-1)/height;
                    float b=1f*(width-j-1)/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }else{
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*i/height;
                    float b=1f*(width-j-1)/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }
    }

    public void enlarge() {
        width++;
        height++;
        this.grids=new char[height][width];
        count=0;
        if(d==Direction.LEFT_DOWN) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*(height-i-1)/height;
                    float b=1f*j/width;
                    System.out.println(a);
                    System.out.println(b);
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d==Direction.LEFT_UP) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*i/height;
                    float b=1f*j/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d==Direction.RIGHT_DOWN) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*(height-i-1)/height;
                    float b=1f*(width-j-1)/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }else{
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*i/height;
                    float b=1f*(width-j-1)/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }
    }

    public void shrink() {
        width--;
        height--;
        count=0;
        this.grids=new char[height][width];
        if(d==Direction.LEFT_DOWN) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*(height-i-1)/height;
                    float b=1f*j/width;
                    System.out.println(a);
                    System.out.println(b);
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d==Direction.LEFT_UP) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*i/height;
                    float b=1f*j/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        } else if (d==Direction.RIGHT_DOWN) {
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*(height-i-1)/height;
                    float b=1f*(width-j-1)/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }else{
            for(int i=0;i<height;i++)
            {
                for (int j=0;j<width;j++)
                {
                    float a=1f*i/height;
                    float b=1f*(width-j-1)/width;
                    if(a+b<1)
                    {
                        count++;
                        grids[i][j]=pattern;
                    }else{
                        grids[i][j]=' ';
                    }
                }
            }
        }
    }

    public int area() {
        return count;
    }
    public String toString()
    {
        return String.format("RightTriangle: (%d,%d) area=%d pattern=%c",location.getX(),location.getY(),count,pattern);
    }
}

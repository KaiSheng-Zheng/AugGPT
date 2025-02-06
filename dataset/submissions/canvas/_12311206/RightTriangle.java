public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public Direction getDirection() {
        return d;
    }

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
    super(location, pattern);
    this.width = width;
    this.height = height;
    this.d = d;
    fillGrids();
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth(){
        return width;
    }

    public void fillGrids()
    {
        Direction towards = getDirection();
        double m=getHeight();
        double n=getWidth();
        double k=n/m;
        char[][] grid = new char[getHeight()][getWidth()];
        if (towards==Direction.LEFT_DOWN)
        {
            double row=0;
            for (int i = 0; i < m; i++)
            {

                double compare=0;
                int compare2=0;
                row+=k;
                double num1 = Math.round(row * 1000) / 1000.0;
                while (num1>compare)
                {
                    compare++;
                    compare2++;
                }
                for (int j = 0; j < compare2; j++) {
                    grid[i][j] = pattern;
                }
            }
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    if (grid[i][j]!=pattern)
                    {
                        grid[i][j]=' ';
                    }
                }
            }
        }
        if (towards==Direction.LEFT_UP)
        {
            double row=0;
            row-=k;
            for (int i = 0; i < getHeight(); i++)
            {
                double compare=0;
                int compare2=0;
            row+=k;
                double num1 = Math.round(row * 1000) / 1000.0;
                while (num1>=compare)
                {
                    compare++;
                    compare2++;
                }
                for (int j = 0; j <getWidth()-compare2+1; j++) {
                grid[i][j] = pattern;
                }
            }
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    if (grid[i][j]!=pattern)
                    {
                        grid[i][j]=' ';
                    }
                }
            }
        }
        if (towards==Direction.RIGHT_UP)
        {
            double row=0;
            row-=k;
            for (int i = 0; i < m; i++)
            {
                double compare=0;
                int compare2=0;
                row+=k;
                double num1 = Math.round(row * 1000) / 1000.0;
                while (num1>=compare)
                {
                    compare++;
                    compare2++;
                }
                for (int j = compare2-1; j < getWidth(); j++)
                {
                    grid[i][j]=pattern;
                }
            }
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    if (grid[i][j]!=pattern)
                    {
                        grid[i][j]=' ';
                    }
                }
            }
        }
        if (towards==Direction.RIGHT_DOWN)
        {
            double row=0;
            for (int i = 0; i < getHeight(); i++) {
            row+=k;
                double compare=0;
                int compare2=0;
                double num1 = Math.round(row * 1000) / 1000.0;
                while (num1>compare)
            {
                compare++;
                compare2++;
            }
                for (int j = getWidth()-compare2; j < getWidth(); j++)
                {
                    grid[i][j]=pattern;
                }
        }
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 0; j < getWidth(); j++) {
                    if (grid[i][j]!=pattern)
                    {
                        grid[i][j]=' ';
                    }
                }
            }
    }
        setGrids(grid);
}
    public void enlarge()
    {
        setHeight(getHeight()+1);
        setWidth(getWidth()+1);
        fillGrids();
    }
    public void shrink()
    {
        setHeight(getHeight()-1);
        setWidth(getWidth()-1);
        fillGrids();
    }

    public int area() {
        double compare = 0;
        int compare2 = 0;
        double row = 0;
        double m = getHeight();
        double n = getWidth();
        double k = n/ m;
        char[][] grid = new char[getHeight()][getWidth()];
      int s= 0;
        for (int i = 0; i < getHeight(); i++) {
            row += k;

            while (row > compare) {
                compare++;
                compare2++;
            }
            s+=compare2;

        }
        return s;
    }
    public String toString()
    {

        String u="RightTriangle: "+"("+location.getX()+","+location.getY()+")"+" area="+area()+" pattern="+pattern;
        return u;
    }


    public char getPattern(){
        return  pattern;
    }

}

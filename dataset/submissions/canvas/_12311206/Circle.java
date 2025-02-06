public class Circle extends Shape {
    private int radius;

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Circle(Location location, char pattern, int radius){
        super(location, pattern);
        this.radius = radius;
        fillGrids();
    }


    public void fillGrids()
    {
        char[][] grid = new char[2*getRadius()][2*getRadius()];
        for (int i = 0; i < getRadius(); i++)
        {
            for (int j = 0; j < getRadius(); j++)
            {
                if ((getRadius()-i-1)*(getRadius()-i-1)+(getRadius()-j-1)*(getRadius()-j-1)<getRadius()*getRadius())
                {
                    grid[i][j]=pattern;
                }
                else {grid[i][j]=' ';}
            }
            for (int j = getRadius(); j <2*getRadius() ; j++)
            {
            if ((getRadius()-i-1)*(getRadius()-i-1)+(j-getRadius())*(j-getRadius())<getRadius()*getRadius())
            {
                grid[i][j]=pattern;
            }
            else {grid[i][j]=' ';}
            }
        }
        for (int i = getRadius(); i < 2*getRadius(); i++)
        {
            for (int j = 0; j < getRadius(); j++)
            {
            if ((i-getRadius())* (i-getRadius())+(getRadius()-j-1)*(getRadius()-j-1)<getRadius()*getRadius())
            {
                grid[i][j]=pattern;
            }
            else {grid[i][j]=' ';}
            }
            for (int j = getRadius(); j < 2*getRadius(); j++)
            {
            if ((i-getRadius())* (i-getRadius())+(j-getRadius())*(j-getRadius())<getRadius()*getRadius())
            {
                grid[i][j]=pattern;
            }
            else {grid[i][j]=' ';}
            }
        }
        setGrids(grid);
    }

    public void enlarge()
    {
        setRadius(getRadius()+1);
        fillGrids();
    }
    public void shrink()
    {
        setRadius(getRadius()-1);
        fillGrids();
    }
    public int area()
    {
        int area=0;
        for (int i = 0; i < getRadius(); i++)
        {
            for (int j = 0; j < getRadius(); j++)
            {
                if ((getRadius()-i-1)*(getRadius()-i-1)+(getRadius()-j-1)*(getRadius()-j-1)<getRadius()*getRadius())
                {
                    area++;
                }
            }
            for (int j = getRadius(); j <2*getRadius() ; j++)
            {
                if ((getRadius()-i-1)*(getRadius()-i-1)+(j-getRadius())*(j-getRadius())<getRadius()*getRadius())
                {
                    area++;
                }
            }
        }
        for (int i = getRadius(); i < 2*getRadius(); i++)
        {
            for (int j = 0; j < getRadius(); j++)
            {
                if ((i-getRadius())* (i-getRadius())+(getRadius()-j-1)*(getRadius()-j-1)<getRadius()*getRadius())
                {
                    area++;
                }
            }
            for (int j = getRadius(); j < 2*getRadius(); j++)
            {
                if ((i-getRadius())* (i-getRadius())+(j-getRadius())*(j-getRadius())<getRadius()*getRadius())
                {
                    area++;
                }
            }}
        return area;
    }
    public String toString()
    {
        String s="Circle: "+"("+location.getX()+","+location.getY()+")"+" area="+area()+" pattern="+pattern;
        return s;
    }
    public char getPattern(){
        return  pattern;
    }
    }
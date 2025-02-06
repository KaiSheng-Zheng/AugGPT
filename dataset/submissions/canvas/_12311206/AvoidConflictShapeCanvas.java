import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
public class AvoidConflictShapeCanvas implements  ShapeCanvas {
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    private  int count;

    public int getRow(){
        return canvas.length;
    }


    public  int getColume(){
        return canvas[0].length;
    }

    public void setShape(Shape shape,int i){
        shapes.remove(i);
        shapes.add(i,shape);
    }


    public AvoidConflictShapeCanvas(int rows, int cols)
    {
        canvas=new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
               canvas[i][j]=' ';
            }
        }
    }


    public List<Shape> getShapesByArea(){
        for (int i = 0; i < shapes.size() - 1; i++) {
            int minIndex = i;
            int m=shapes.get(i).area();

            for (int j = i + 1; j < shapes.size(); j++) {
                int n=shapes.get(j).area();
                char q=shapes.get(j).pattern;
                if (shapes.get(j).area() < shapes.get(minIndex).area()) {
                    minIndex = j;
                }
            }
            Shape mid=shapes.get(i);
            setShape(shapes.get(minIndex),i);
            setShape(mid,minIndex);
        }
        for (int i = 0; i <shapes.size() ; i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if (shapes.get(i).area()==shapes.get(j).area())
                {
                    if (shapes.get(i).pattern>shapes.get(j).pattern)
                    {
                        Shape midde=shapes.get(j);
                        setShape(shapes.get(i), j);
                        setShape(midde,i);
                    }
                }
            }
        }
        return shapes;
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params)
    {
        Location addLocation=new Location(x,y);

        if (params.length==3)
        {
            double m=params[1];
            double n=params[0];
            double k=n/m;
            int[][] grid=new int[params[1]][params[0]];
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    grid[i][j]=' ';
                }
            }
            if (params[2]==0)
            {
                RightTriangle add=new RightTriangle(addLocation,pattern,params[0],params[1],Direction.LEFT_UP);
                if (y+ add.getWidth()>getColume())
                {
                    return false;
                }
                if (x+add.getHeight()>getRow())
                {
                    return  false;
                }


               double  row=0;
                row-=k;
                for (int i = x; i < x+params[1]; i++)
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
                    for (int j = y; j <y+params[0]-compare2+1; j++) {
                        if (canvas[i][j]!=' '){return  false;}
                    }

                }
                row=-k;
                for (int i = x; i < x+params[1]; i++)
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
                    for (int j = y; j <y+params[0]-compare2+1; j++) {
                        canvas[i][j] = pattern;
                    }

                }
                count++;
                shapes.add(add);
               return true;
                }

            if (params[2]==1)
            {
                RightTriangle add=new RightTriangle(addLocation,pattern,params[0],params[1],Direction.LEFT_DOWN);
                if (y+ add.getWidth()>getColume())
                {
                    return false;
                }
                if (x+add.getHeight()>getRow())
                {
                    return  false;
                }


                double row=0;
                for (int i = x; i < x+m; i++)
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
                    for (int j = y; j < y+compare2; j++) {
                        if (canvas[i][j]!=' '){return  false;}
                    }
                }
                 row=0;
                for (int i = x; i <x+ m; i++)
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
                    for (int j = y; j < y+compare2; j++) {
                        canvas[i][j] = pattern;
                    }
                }
                count++;
                shapes.add(add);
                return true;
            }
            if (params[2]==2)
            {
                RightTriangle add=new RightTriangle(addLocation,pattern,params[0],params[1],Direction.RIGHT_UP);
                if (y+ add.getWidth()>getColume())
                {
                    return false;
                }
                if (x+add.getHeight()>getRow())
                {
                    return  false;
                }

               double row=0;
                row-=k;
                for (int i = x; i <x+ m; i++)
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
                    for (int j = y+compare2-1; j <y+ params[0]; j++)
                    {
                        if (canvas[i][j]!=' '){return  false;}
                    }
                }
                row=0;
                row-=k;
                for (int i = x; i <x+ m; i++)
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
                    for (int j = y+compare2-1; j <y+ params[0]; j++)
                    {
                      canvas[i][j]=pattern;
                    }
                }
                count++;
                shapes.add(add);
                return  true;
            }
            else
            {
                RightTriangle add=new RightTriangle(addLocation,pattern,params[0],params[1],Direction.RIGHT_DOWN);
                if (y+ add.getWidth()>getColume())
                {
                    return false;
                }
                m=add.getHeight();
                if (x+add.getHeight()>getRow())
                {
                    return  false;
                }

                double row=0;
                for (int i = x; i < x+params[1]; i++) {
                    row+=k;
                    double compare=0;
                    int compare2=0;
                    double num1 = Math.round(row * 1000) / 1000.0;
                    while (num1>compare)
                    {
                        compare++;
                        compare2++;
                    }
                    for (int j = y+params[0]-compare2; j < y+params[0]; j++)
                    {
                        if (canvas[i][j]!=' '){return  false;}
                    }
                }
                 row=0;
                for (int i = x; i < x+params[1]; i++) {
                    row+=k;
                    double compare=0;
                    int compare2=0;
                    double num1 = Math.round(row * 1000) / 1000.0;
                    while (num1>compare)
                    {
                        compare++;
                        compare2++;
                    }
                    for (int j = y+params[0]-compare2; j < y+params[0]; j++)
                    {
                        canvas[i][j]=pattern;
                    }
                }
                count++;
                shapes.add(add);
                return  true;
            }
        }
        else
        {
           Circle add=new Circle(addLocation,pattern,params[0]);
            int r=params[0];
            char[][] grid = new char[2*r][2*r];
            for (int i = 0; i < r; i++)
            {
                for (int j = 0; j < r; j++)
                {
                    if ((r-i-1)*(r-i-1)+(r-j-1)*(r-j-1)<r*r)
                    {
                        grid[i][j]=pattern;
                    }
                    else {grid[i][j]=' ';}
                }
                for (int j = r; j <2*r ; j++)
                {
                    if ((r-i-1)*(r-i-1)+(j-r)*(j-r)<r*r)
                    {
                        grid[i][j]=pattern;
                    }
                    else {grid[i][j]=' ';}
                }
            }
            for (int i = r; i < 2*r; i++)
            {
                for (int j = 0; j < r; j++)
                {
                    if ((i-r)* (i-r)+(r-j-1)*(r-j-1)<r*r)
                    {
                        grid[i][j]=pattern;
                    }
                    else {grid[i][j]=' ';}
                }
                for (int j = r; j < 2*r; j++)
                {
                    if ((i-r)* (i-r)+(j-r)*(j-r)<r*r)
                    {
                        grid[i][j]=pattern;
                    }
                    else {grid[i][j]=' ';}
                }}
            int label=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j]!=' '&&y+i>=0&&y+i<=getRow()-1&&x+i>=0&&x+i<=getColume()-1){
                        label++;
                    }
                }
            }
            if (label!=add.area()){return  false;}

            for (int i = x; i <x+r; i++)
            {
                for (int j = y; j < y+r; j++)
                {
                    if ((r-i+x-1)*(r-i+x-1)+(r-j+y-1)*(r-j+y-1)<r*r)
                    {
                        if (canvas[i][j]!=' '){return  false;}
                    }
                }
                for (int j = r+y; j <2*r+y ; j++)
                {
                    if ((r-i+x-1)*(r-i+x-1)+(j-r-y)*(j-y-r)<r*r)
                    {
                        if (canvas[i][j]!=' '){return  false;}
                    }
                }
            }
            for (int i = r+x; i < 2*r+x; i++)
            {
                for (int j = y; j < r+y; j++)
                {
                    if ((i-r-x)* (i-r-x)+(r-j+y-1)*(r-j+y-1)<r*r)
                    {
                        if (canvas[i][j]!=' '){return  false;}
                    }
                }
                for (int j = r+y; j < 2*r+y; j++)
                {
                    if ((i-r-x)* (i-r-x)+(j-r-y)*(j-r-y)<r*r)
                    {
                        if (canvas[i][j]!=' '){return  false;}
                    }
                }}
            r=params[0];
            for (int i = x; i <x+r; i++)
            {
                for (int j = y; j < y+r; j++)
                {
                    if ((r-i+x-1)*(r-i+x-1)+(r-j+y-1)*(r-j+y-1)<r*r)
                    {
                        canvas[i][j]=pattern;
                    }
                }
                for (int j = r+y; j <2*r+y ; j++)
                {
                    if ((r-i+x-1)*(r-i+x-1)+(j-r-y)*(j-r-y)<r*r)
                    {
                        canvas[i][j]=pattern;
                    }
                }
            }
            for (int i = r+x; i < 2*r+x; i++)
            {
                for (int j = y; j < r+y; j++)
                {
                    if ((i-r-x)* (i-r-x)+(r-j+y-1)*(r+y-j-1)<r*r)
                    {
                        canvas[i][j]=pattern;
                    }
                }
                for (int j = r+y; j < 2*r+y; j++)
                {
                    if ((i-r-x)* (i-r-x)+(j-r-y)*(j-r-y)<r*r)
                    {
                        canvas[i][j]=pattern;
                    }
                }}
            count++;
            shapes.add(add);
            return  true;
        }
    }


    public int getSpaceGridCount(){
        int count=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j]==' ')
                {
                    count++;
                }
            }
        }
        return  count;
    }


    public List<Shape> getShapesByLocation(){
        for (int i = 0; i < shapes.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(j).location.getX() < shapes.get(minIndex).location.getX()) {
                    minIndex = j;
                }
            }
            Shape mid=shapes.get(i);
            setShape(shapes.get(minIndex), i);
            setShape(mid, minIndex);
        }
        for (int i = 0; i <shapes.size() ; i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if (shapes.get(i).location.getX()==shapes.get(j).location.getX())
                {
                    if (shapes.get(j).location.getY()<shapes.get(i).location.getY())
                    {
                      Shape midd=shapes.get(i);
                      setShape(shapes.get(j),i);
                      setShape(midd,j);
                    }
                }
            }
        }
        for (int i = 0; i <shapes.size() ; i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if (shapes.get(i).location.getY()==shapes.get(j).location.getY()&&shapes.get(i).location.getX()==shapes.get(j).location.getX())
                {
                    if (shapes.get(i).pattern>shapes.get(j).pattern)
                    {
                        Shape midd=shapes.get(i);
                        setShape(shapes.get(j),i);
                        setShape(midd,j);
                    }
                }
            }
        }
        return  shapes;
    }
    public char[][] getCanvas(){
        return  canvas;
    }


    public int getShapeCount(){
        return  count;
    }
}
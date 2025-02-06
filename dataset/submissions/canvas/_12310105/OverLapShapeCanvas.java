import java.util.ArrayList;
import java.util.List;
public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    private int area = 0;
    private int column = 0;
    private int row = 0;
    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for(int a = 0 ; a <rows;a++)
        {
            for(int b =0 ; b <cols;b++)
            {
                canvas[a][b] =' ';
            }
        }
        column=cols;
        row=rows;
    }
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            Location location = new Location(x, y);
            Circle circle = new Circle(location, pattern, params[0]);
            circle.fillGrids();
                for(int Row= 0 ;Row< params[0]*2;Row++)
                {
                    for(int Column = 0 ; Column < params[0]*2;Column++)
                    {
                        if(circle.grids[Row][Column]==pattern&& x + Row < row && y + Column < column ) {
                            canvas[x + Row][y + Column] = circle.grids[Row][Column];
                        }
                    }
                }
            int whetherInCanvas = 0;
            for(int Row = 0 ;Row<row;Row++)
            {
                for(int Column = 0 ; Column < column;Column++)
                {
                    if(canvas[Row][Column]==pattern)
                    {
                        whetherInCanvas++;
                    }
                }
            }
            if(whetherInCanvas==0)
            {
                return false;
            }
                shapes.add(circle);
        }
        else{
            Location location = new Location(x,y);
            RightTriangle rightTriangle = new RightTriangle(location,pattern,params[0],params[1],Direction.values()[params[2]]);
                rightTriangle.fillGrids();
                for(int Row= 0 ;Row< params[1];Row++)
                {
                    for(int Column = 0 ; Column < params[0];Column++)
                    {
                        if(rightTriangle.grids[Row][Column]==pattern&&x+Row<row&&y+Column<column)
                        {
                            canvas[x+Row][y+Column]=rightTriangle.grids[Row][Column];
                        }
                    }
                }
                int whetherInCanvas = 0;
                for(int Row = 0 ;Row<row;Row++)
                {
                    for(int Column = 0 ; Column < column;Column++)
                    {
                        if(canvas[Row][Column]==pattern)
                        {
                            whetherInCanvas++;
                        }
                    }
                }
                if(whetherInCanvas==0)
                {
                    return false;
                }
                shapes.add(rightTriangle);
        }
        return true;
    }
    public int getSpaceGridCount(){
        for(int a = 0 ;a<row;a++)
        {
            for(int b = 0 ;b<column;b++)
            {
                if(canvas[a][b]!=' ')
                {
                    area++;
                }
            }
        }
        return column*row-area;
    }

    public int getShapeCount(){
        return shapes.toArray().length;
    }

    public List<Shape> getShapesByArea(){
        for(int a = 0 ; a < shapes.toArray().length-1;a++)
        {
            for(int b = 0 ; b <shapes.toArray().length-1;b++)
            {
                Shape transmitShape;
                if(b<shapes.toArray().length-1&&shapes.get(b).area()>shapes.get(b+1).area())
                {
                    transmitShape = shapes.get(b+1);
                    shapes.set(b+1,shapes.get(b));
                    shapes.set(b,transmitShape);
                }
                else if (b<shapes.toArray().length-1&&shapes.get(b).area()==shapes.get(b+1).area()&& shapes.get(b).getPattern()>shapes.get(b+1).getPattern())
                {
                    transmitShape = shapes.get(b+1);
                    shapes.set(b+1,shapes.get(b));
                    shapes.set(b,transmitShape);
                }
            }
        }
        return shapes;
    }

    public List<Shape> getShapesByLocation(){

        for(int a = 0 ;a<shapes.toArray().length-1;a++)
        {
            for(int b = 0; b < shapes.toArray().length;b++)
            {
                Shape transmitShape ;
                if(b<shapes.toArray().length-1&&shapes.get(b).getX()>shapes.get(b+1).getX())
                {   transmitShape = shapes.get(b+1);
                    shapes.set(b+1,shapes.get(b));
                    shapes.set(b,transmitShape);
                }else if (b<shapes.toArray().length-1&&shapes.get(b).getX()==shapes.get(b+1).getX()&&shapes.get(b).getY()>shapes.get(b+1).getY())
                {
                    transmitShape = shapes.get(b+1);
                    shapes.set(b+1,shapes.get(b));
                    shapes.set(b,transmitShape);
                }
                else if (b<shapes.toArray().length-1&&shapes.get(b).getX()==shapes.get(b+1).getX()&&shapes.get(b).getY()==shapes.get(b+1).getY()&&shapes.get(b).getPattern()>shapes.get(b+1).getPattern())
                {
                    transmitShape = shapes.get(b+1);
                    shapes.set(b+1,shapes.get(b));
                    shapes.set(b,transmitShape);
                }
            }
        }
        return shapes;
    }

    public char[][] getCanvas(){
        return  canvas;
    }
}

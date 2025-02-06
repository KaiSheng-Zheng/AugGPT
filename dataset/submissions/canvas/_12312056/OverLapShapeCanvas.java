import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        this.shapes=new ArrayList<>();
        canvas=new char[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                canvas[i][j]=' ';
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length==1){
            boolean ok=false;
            Location location=new Location(x,y);
            Shape circle=new Circle(location,pattern,params[0]);
            circle.fillGrids();
            char[][] grids=circle.getGrids();
            for(int i=0;i<params[0]*2;i++)
                for(int j=0;j<params[0]*2;j++)
                    if(grids[i][j]!=' '&&i+x<canvas.length&&j+y<canvas[0].length) {
                            canvas[i + x][j + y] = grids[i][j];
                            ok = true;
                    }
            if(!ok)
                return false;
            shapes.add(circle);
        }else{
            boolean ok=false;
            Location location=new Location(x,y);
            final Direction[] d=Direction.values();
            Shape righttriangle=new RightTriangle(location,pattern,params[0],params[1],d[params[2]]);
            righttriangle.fillGrids();
            char[][] grids=righttriangle.getGrids();
            for(int i=0;i<params[1];i++)
                for(int j=0;j<params[0];j++)
                    if(grids[i][j]!=' '&&i+x<canvas.length&&j+y<canvas[0].length) {
                            canvas[i + x][j + y] = grids[i][j];
                            ok = true;
                    }
            if(!ok)
                return false;
            shapes.add(righttriangle);
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int sum=0;
        for (char[] canva : canvas)
            for (char c : canva)
                if (c == ' ')
                    sum++;
        return sum;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.area()!=o2.area())
                    return Integer.compare(o1.area(), o2.area());
                else
                    return Integer.compare(o1.pattern, o2.pattern);
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.location.getX()!=o2.location.getX())
                    return Integer.compare(o1.location.getX(),o2.location.getX());
                else if(o1.location.getY()!=o2.location.getY())
                    return Integer.compare(o1.location.getY(),o2.location.getY());
                else
                    return Integer.compare(o1.pattern,o2.pattern);
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

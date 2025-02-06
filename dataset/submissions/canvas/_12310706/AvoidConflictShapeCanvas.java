

import java.util.*;

public class AvoidConflictShapeCanvas
implements ShapeCanvas
{
    private List<Shape> shapes;
    private int m;
    private int n;
    private char[][] canvas;
    private static final char EMPTY=' ';
    public AvoidConflictShapeCanvas(int rows, int cols){
        shapes=new ArrayList<>();
        m=rows;
        n=cols;
        canvas=new char[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                canvas[i][j]=EMPTY;
    }
    @Override public boolean addShape(int x, int y, char pattern, int... params){
        Shape shape;
        if(params.length==1)
            shape=new Circle(new Location(x,y),pattern,params[0]);
        else
            shape=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.values()[params[2]]);
        for(Location location:shape.occupiedLocations()){
            if(isOutOfBound(location))
                return false;
            if(canvas[location.getX()][location.getY()]!=EMPTY)
                return false;
        }
        shapes.add(shape);
        for(Location location:shape.occupiedLocations())
            canvas[location.getX()][location.getY()]=shape.pattern;
        return true;
    }
    @Override public int getSpaceGridCount(){
        int count=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(canvas[i][j]!=EMPTY)
                    count++;
        return count;
    }
    @Override public int getShapeCount(){
        return shapes.size();
    }
    @Override public List<Shape> getShapesByArea(){
        shapes.sort(new Shape.AreaComparator());
        return shapes;
    }
    @Override public List<Shape> getShapesByLocation(){
        shapes.sort(new Shape.LocationComparator());
        return shapes;
    }
    @Override public char[][] getCanvas(){
        return canvas;
    }
    public boolean isOutOfBound(Location location){
        return location.getX()<0||location.getX()>=m||location.getY()<0||location.getY()>=n;
    }
    @Override public String toString(){
        StringBuilder out=new StringBuilder();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                out.append(canvas[i][j]);
            out.append('\n');
        }
        return out.toString();
    }
}

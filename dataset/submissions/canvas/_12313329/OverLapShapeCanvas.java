import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        this.shapes = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';}
        }
    }

    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x, y);
        char[][] grid;
        Shape shape;
        Boolean isTrue=false;
        if (params.length == 1) {
            shape = new Circle(location, pattern, params[0]);

        } else {
            shape = new RightTriangle(location, pattern, params[0], params[1],
                    Direction.getByIndex(params[2]));

        }
        grid = shape.getGrids();

        if(x<0 || y<0){
            isTrue =  false;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]!=' '){
                    if(i+x<canvas.length && j+y<canvas[0].length){
                        if(shape.grids[i][j]!=' '){
                            canvas[i+x][j+y]=shape.grids[i][j];
                        }
                        isTrue = true;
                    }
                }
            }
        }
        if(isTrue==true){
            shapes.add(shape);
        }

        return isTrue;
    }

    @Override
    public int getSpaceGridCount() {
        int cout = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == ' ') {
                    cout++;
                }
            }
        }
        return cout;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                int AreaCompare = Integer.compare(o1.area(),o2.area());
                if(AreaCompare!=0){
                    return AreaCompare;
                }
                return String.valueOf(o1.getPattern()).compareTo
                        (String.valueOf(o2.getPattern()));

            }
        });
        return  (shapes);
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                int XCompare = Integer.compare(o1.location.getX(), o2.location.getX());
                if (XCompare != 0) {
                    return XCompare;
                }else {
                    int YCompare = Integer.compare(o1.location.getY(), o2.location.getY());
                    if (YCompare != 0) {
                        return YCompare;
                    }
                }
                return String.valueOf(o1.getPattern()).compareTo
                        (String.valueOf(o2.getPattern()));

            }
        });
        return (shapes);
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}

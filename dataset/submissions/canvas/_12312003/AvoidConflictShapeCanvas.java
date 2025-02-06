import java.awt.*;
import java.util.*;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes= new ArrayList<>();
    private char[][] canvas;
    int SpaceGridCount;
    int ShapeCount = 0;
    int rows;
    int cols;

    public AvoidConflictShapeCanvas(int rows, int cols){
        this.rows=rows;
        this.cols=cols;
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
        setCanvas(canvas);
        SpaceGridCount = rows * cols;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length == 1){
            int radius = params[0];
            return addCircle(x,y,pattern,radius);
        }
        else{
            int width = params[0];
            int height = params[1];
            int indexOfDirection = params[2];
            return addRectangle(x,y,pattern,width,height,indexOfDirection);
        }
    }

    @Override
    public int getSpaceGridCount() {
        return SpaceGridCount;
    }

    @Override
    public int getShapeCount() {
        return ShapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new CompareByArea());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new CompareByLocation());
        return shapes;
    }

    public void setCanvas(char[][] canvas) {
        this.canvas = canvas;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


    private boolean addCircle(int x, int y, char pattern, int radius) {
         Location location = new Location(x,y);
         Circle circle = new Circle(location,pattern,radius);
         boolean ifAdd = true;
         char[][] currentGrids =circle.fillGrids();
         label:
             for (int i = 0; i < currentGrids.length; i++) {
                 for (int j = 0; j < currentGrids[i].length; j++) {
                     if (currentGrids[i][j] != ' ') {
                         if (x + i >= canvas.length || y + j >= canvas[0].length) {
                             ifAdd = false;
                             break label;
                         }else if (canvas[x+i][y+j]!=' ') {
                             ifAdd = false;
                             break label;
                         }
                     }
                 }
             }

        if(ifAdd){
            for (int i = 0; i < currentGrids.length; i++) {
                for (int j = 0; j < currentGrids[i].length; j++) {
                    if(currentGrids[i][j]!=' ') {
                        canvas[x + i][y + j] = currentGrids[i][j];
                    }setCanvas(canvas);
                }
            }
            shapes.add(circle);
            ShapeCount++;
            SpaceGridCount = SpaceGridCount - circle.area();
        }
         return ifAdd;
        }

    private boolean addRectangle(int x, int y, char pattern, int width, int height, int indexOfDirection) {
        Location location = new Location(x,y);
        RightTriangle rightTriangle = new RightTriangle(location,pattern,width,height,Direction.values()[indexOfDirection]);
        boolean ifAdd = true;
        char [][]currentGrids = rightTriangle.fillGrids();
        label:
            for (int i = 0; i < currentGrids.length; i++) {
                for (int j = 0; j < currentGrids[i].length; j++) {
                    if (currentGrids[i][j] != ' ') {
                        if (x + i >= canvas.length || y + j >= canvas[0].length) {
                            ifAdd = false;
                            break label;
                        }else if (canvas[x+i][y+j]!=' ') {
                            ifAdd = false;
                            break label;
                        }
                    }
                }
            }
        if(ifAdd){
            for (int i = 0; i < currentGrids.length; i++) {
                for (int j = 0; j < currentGrids[i].length; j++) {
                    if(currentGrids[i][j]!=' ' && x + i < canvas.length && y + j < canvas[0].length) {
                        canvas[x + i][y + j] = currentGrids[i][j];
                    }
                    setCanvas(canvas);
                }
            }
            shapes.add(rightTriangle);
            ShapeCount++;
            SpaceGridCount = SpaceGridCount - rightTriangle.area();
        }
        return ifAdd;
    }
}

class CompareByArea implements Comparator<Shape> {
    @Override
     public int compare(Shape a,Shape b) {
         if(a.area()==b.area()) {
             return (a.pattern- b.pattern);
         }else {
             return (a.area() - b.area());
         }
     }
}

 class CompareByLocation implements Comparator<Shape> {
    @Override
    public int compare(Shape a,Shape b) {
        if(a.getLocation().getX()!=b.getLocation().getX()) {
            return a.getLocation().getX() - b.getLocation().getX();
        }else if(a.getLocation().getY() != b.getLocation().getY()){
            return a.getLocation().getY() - b.getLocation().getY();
        }else return a.pattern-b.pattern;
    }
}






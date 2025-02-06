import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    int SpaceGridCount=0;
    int ShapeCount = 0;
    int rows;
    int cols;

    public OverLapShapeCanvas(int rows, int cols){
        this.rows=rows;
        this.cols=cols;
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
        setCanvas(canvas);
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


    public void setCanvas(char[][] canvas){
        this.canvas = canvas;
    }

    @Override
    public int getSpaceGridCount() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                 if(canvas[i][j]==' '){
                     SpaceGridCount++;
                 }
            }
        }
        return SpaceGridCount;
    }

    @Override
    public int getShapeCount() {
        return ShapeCount;
    }

    @Override
    public List<Shape> getShapesByArea(){
        shapes.sort(new CompareByArea());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new CompareByLocation());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

private boolean addCircle(int x, int y, char pattern, int radius) {
    Location location = new Location(x,y);
    Circle circle = new Circle(location,pattern,radius);
    boolean ifAdd = false;
    char[][] currentGrids =circle.fillGrids();
    for (int i = 0; i < currentGrids.length; i++) {
        for (int j = 0; j < currentGrids[i].length; j++) {
            if(currentGrids[i][j]!=' '){
            if (x+i<canvas.length && y+j<canvas[0].length){
                canvas[x + i][y + j] = currentGrids[i][j];
                ifAdd = true;
            }
        }
    }
    }setCanvas(canvas);
    if(ifAdd) {
        shapes.add(circle);
        ShapeCount++;
    }

    return ifAdd;
    }

private boolean addRectangle(int x, int y, char pattern, int width, int height, int indexOfDirection) {
    Location location = new Location(x,y);
    RightTriangle rightTriangle = new RightTriangle(location,pattern,width,height,Direction.values()[indexOfDirection]);
    boolean ifAdd = false;
    char [][]currentGrids = rightTriangle.fillGrids();
    for (int i = 0; i < currentGrids.length; i++) {
        for (int j = 0; j < currentGrids[i].length; j++) {
            if(currentGrids[i][j]!=' '){
                if( (x+i<canvas.length && y+j<canvas[0].length)){
                canvas[x + i][y + j] = currentGrids[i][j];

                ifAdd = true;
            }
        }
        }
    }setCanvas(canvas);
    if(ifAdd) {
        shapes.add(rightTriangle);
        ShapeCount++;
    }

    return ifAdd;
}
}




import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    // Design a attribute shapes, which is to store the successfully added shapes.
    private ArrayList<Shape> shapes;
    //Using a char[][] array to represent the canvas.
    private char[][] canvas;
    private int height;
    private int width;
    public OverLapShapeCanvas(int rows,int cols){
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        height=rows;
        width=cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int r) {
        Circle c = new Circle(new Location(x,y),pattern,r);
        char[][] circle = c.getGrids();
        boolean isChanged=false;
        for (int i = 0; i < 2 * r; i++) {
            for (int j = 0; j < 2 * r; j++) {
                if (circle[i][j]!=' '){
                    if(x+i>=0&&x+i<height&&y+j>=0&&y+j<width){
                        canvas[x+i][y+j]=pattern;
                        isChanged=true;
                    }
                }
            }
        }
        if(isChanged){
            shapes.add(c);
            return true;
        }
        return false;
    }
    public boolean addShape(int x,int y,char pattern,int widthOfTriangle,int heightOfTriangle,int indexOfDirection){
        boolean isChanged = false;
        Direction d=Direction.values()[indexOfDirection];
        RightTriangle rightTriangle = new RightTriangle(new Location(x, y),pattern,widthOfTriangle,heightOfTriangle,d);
        char[][] triangle = rightTriangle.getGrids();
        for (int i = 0; i < heightOfTriangle; i++) {
            for (int j = 0; j < widthOfTriangle; j++) {
                if(triangle[i][j]!=' '){
                    if(x+i>=0&&x+i<height&&y+j>=0&&y+j<width){
                        canvas[x+i][y+j]=pattern;
                        isChanged =true;
                    }
                }
            }
        }
        if(isChanged){
            shapes.add(rightTriangle);
            return true;
        }
        return false;
    }
    @Override
    public int getSpaceGridCount() {
        int counter=0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(canvas[i][j]==' '){
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes,new ShapeComparatorForArea());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes,new ShapeComparatorForLocation());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

}

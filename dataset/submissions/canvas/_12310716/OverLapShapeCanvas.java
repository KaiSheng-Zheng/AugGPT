import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    public int spaceGridCount=0;
    public int shapeCount=0;

    public OverLapShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length!=1){
            if(x>canvas.length&&x+params[1]<0&&y>canvas[0].length&&y+params[0]<0){
                return false;
            }
            int c= Math.min(y + params[0], canvas[0].length);
            int r=Math.min(x + params[1], canvas.length);
        for (int i = y; i < c; i++) {
            for (int j = x; j < r; j++) {
                canvas[j][i] = pattern;
                spaceGridCount++;
            }
        }
        }
        else{
            if(x>canvas.length&&x+params[0]*2<0&&y>canvas[0].length&&y+params[0]*2<0){
                return false;
            }
            int c= Math.min(y + params[0]*2, canvas[0].length);
            int r=Math.min(x + params[0]*2, canvas.length);
            for (int i = y; i < c; i++) {
                for (int j = x; j < r; j++) {
                    canvas[j][i] = pattern;
                    spaceGridCount++;
                }
            }
        }
        shapeCount++;
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        return spaceGridCount;
    }

    @Override
    public int getShapeCount() {
        return shapeCount;
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(Comparator.comparingInt(Shape::area));
        shapes.sort(Comparator.comparing(Shape::getPattern));
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(Comparator.comparingInt(Location::getX));
        shapes.sort(Comparator.comparingInt(Location::getY));
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}


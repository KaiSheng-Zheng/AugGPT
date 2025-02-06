
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;
    public OverLapShapeCanvas(int rows, int cols){

    }
    public boolean addShape(int x, int y, char pattern, int... params){
        return true;
    }
    public int getSpaceGridCount() {
        int rec=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j]==' '){
                    rec++;
                }
            }
        }
        return rec;
    }

    @Override
    public int getShapeCount() {
        int rec=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j]!=' '){
                    rec++;
                }
            }
        }
        return rec;
    }

    @Override
    public List<Shape> getShapesByArea() {
        return null;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        return null;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

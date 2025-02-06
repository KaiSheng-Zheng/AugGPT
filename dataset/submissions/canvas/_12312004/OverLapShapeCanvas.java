import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int shapenumber;
    public OverLapShapeCanvas(int rows, int cols){
        shapes=new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        int a=0;
        if (params.length == 1) {
            Location location = new Location(x, y);
            Shape circle = new Circle(location, pattern, params[0]);
            circle.fillGrids();
            for (int i = 0; i < Math.min(circle.getGrids().length, canvas.length); i++) {
                for (int j = 0; j < Math.min(circle.getGrids()[i].length, canvas[i].length); j++) {
                    if (x + i < canvas.length && y + j < canvas[0].length && circle.getGrids()[i][j] == pattern) {
                        canvas[x + i][y + j] = circle.getGrids()[i][j];
                        a++;
                    }
                }
            }
            if (a>0) shapes.add(circle);
        }
        if (params.length > 1) {
            Location location = new Location(x, y);
            Direction[] d = new Direction[1];
            switch (params[2]) {
                case 0:
                    d[0] = Direction.LEFT_UP;
                    break;
                case 1:
                    d[0] = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d[0] = Direction.RIGHT_UP;
                    break;
                case 3:
                    d[0] = Direction.RIGHT_DOWN;
                    break;
            }
            Shape rightTriangle = new RightTriangle(location, pattern, params[0], params[1], d[0]);
            for (int i = 0; i < Math.min(rightTriangle.getGrids().length, canvas.length); i++) {
                for (int j = 0; j < Math.min(rightTriangle.getGrids()[i].length, canvas[i].length); j++) {
                    if (x + i < canvas.length && y + j < canvas[0].length&&rightTriangle.getGrids()[i][j] == pattern) {
                        canvas[x + i][y + j] = rightTriangle.getGrids()[i][j];
                        a++;
                    }
                }
            }
            if (a>0) shapes.add(rightTriangle);
        }
        if (a == 0) return false;
        shapenumber++;
        return true;
    }

    public int getSpaceGridCount() {
        int a=0;
        for (int i=0;i<canvas.length;i++){
            for (int j=0;j<canvas[0].length;j++){
                if (canvas[i][j]!=' '){
                    a++;
                }
            }
        }
        return canvas.length*canvas[0].length-a;
    }

    @Override
    public int getShapeCount() {
        return shapenumber;
    }

    @Override
    public List<Shape> getShapesByArea() {
        Comparator orderByArea = new OrderByArea();
        shapes.sort(orderByArea);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator orderByLocation = new OrderByLocation();
        shapes.sort(orderByLocation);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}
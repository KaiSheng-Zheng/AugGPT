import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j ++){
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int radius) {
        boolean add = false;
        Circle circle = new Circle(new Location(x,y), pattern, radius);
        for(int i = 0; i < circle.getGrids().length; i ++){
            for(int j = 0; j < circle.getGrids()[i].length; j ++){
                if(x+i < canvas.length && y+j < canvas[x+i].length && circle.getGrids()[i][j] != ' ') {
                    add = true | add;
                }
            }
        }
        if(add){
            shapes.add(circle);
            for(int i = 0; i < circle.getGrids().length; i ++){
                for(int j = 0; j < circle.getGrids()[i].length; j ++){
                    if(circle.getGrids()[i][j] != ' ' && x+i < canvas.length && y+j < canvas[x+i].length)
                        canvas[x+i][y+j] = circle.getGrids()[i][j];
                }
            }
        }
        return add;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int width, int height, int direction) {
        Direction d;
        boolean add = false;
        switch(direction) {
            case 0:
                d = Direction.LEFT_UP;
                break;
            case 1:
                d = Direction.LEFT_DOWN;
                break;
            case 2:
                d = Direction.RIGHT_UP;
                break;
            case 3:
                d = Direction.RIGHT_DOWN;
                break;
            default:
                return false;
        }
        RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, width, height, d);
        for(int i = 0; i < rightTriangle.getGrids().length; i ++){
            for(int j = 0; j < rightTriangle.getGrids()[i].length; j ++){
                if(x+i < canvas.length && y+j < canvas[x+i].length && rightTriangle.getGrids()[i][j] != ' ') {
                    add = true | add;
                }
            }
        }
        if(add){
            shapes.add(rightTriangle);
            for(int i = 0; i < rightTriangle.getGrids().length; i ++){
                for(int j = 0; j < rightTriangle.getGrids()[i].length; j ++){
                    if(rightTriangle.getGrids()[i][j] != ' ' && x+i < canvas.length && y+j < canvas[x+i].length)
                        canvas[x+i][y+j] = rightTriangle.getGrids()[i][j];
                }
            }
        }
        return add;
    }

    @Override
    public int getSpaceGridCount() {
        int nums = 0;
        for(int i = 0; i < canvas.length; i ++){
            for(int j = 0; j < canvas[i].length; j ++){
                if(canvas[i][j] == ' ') nums ++;
            }
        }
        return nums;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new AreaComparator());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new LocationComparator());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

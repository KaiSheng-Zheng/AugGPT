import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
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
        boolean add = true;
        Circle circle = new Circle(new Location(x,y), pattern, radius);
        for(int i = 0; i < circle.getGrids().length; i ++){
            for(int j = 0; j < circle.getGrids()[i].length; j ++){
                if(x+i < canvas.length && y+j < canvas[x+i].length)
                    if(circle.getGrids()[i][j] != ' ') {
                        if (canvas[x + i][y + j] == ' ') add = true & add;
                        else add = false;
                    }else;
                else add = false;
            }
        }
        if(add){
            shapes.add(circle);
            for(int i = 0; i < circle.getGrids().length; i ++){
                for(int j = 0; j < circle.getGrids()[i].length; j ++){
                    if(circle.getGrids()[i][j] != ' ')
                        canvas[x+i][y+j] = circle.getGrids()[i][j];
                }
            }
        }
        return add;
    }
    public boolean addShape(int x, int y, char pattern, int width, int height, int direction){
        Direction d;
        boolean add = true;
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
                if(x+i < canvas.length && y+j < canvas[x+i].length)
                    if(rightTriangle.getGrids()[i][j] != ' ') {
                        if (canvas[x + i][y + j] == ' ') add = true & add;
                        else add = false;
                    }else;
                else add = false;
            }
        }
        if(add){
            shapes.add(rightTriangle);
            for(int i = 0; i < rightTriangle.getGrids().length; i ++){
                for(int j = 0; j < rightTriangle.getGrids()[i].length; j ++){
                    if(rightTriangle.getGrids()[i][j] != ' ')
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
    public List<Shape> getShapesByLocation(){
        shapes.sort(new LocationComparator());
        return shapes;
    }
    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

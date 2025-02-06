import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private ArrayList<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    int row;
    int col;
    public OverLapShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int i1 = 0; i1 < cols; i1++) {
                canvas[i][i1]=' ';
            }
        }
        row=rows;
        col=cols;
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean finall=true;
        Location location = new Location(x, y);
        Direction d = Direction.LEFT_UP;
        if (params.length == 1) {
            Shape shape = new Circle(location, pattern, params[0]);
            int earn=0;
            for (int i = 0; i < shape.grids.length; i++) {
                for (int i1 = 0; i1 < shape.grids[0].length; i1++) {
                    if (i + x < canvas.length & i1 + y < canvas[0].length & shape.getGrids()[i][i1] != ' ') {
                        earn++;
                    }
                }
            }
            if (earn==0)return false;
            else {
                for (int i = 0; i < shape.grids.length; i++) {
                    for (int i1 = 0; i1 < shape.grids[0].length; i1++) {
                        if (i + x < canvas.length & i1 + y < canvas[0].length & shape.getGrids()[i][i1] != ' ') {
                            canvas[i+x][i1+y]=shape.getGrids()[i][i1];
                        }
                    }
                }
            }
            shapes.add(shape);
        } else {
            switch (params[2]) {
                case (0):
                    d = Direction.LEFT_UP;
                    break;
                case (1):
                    d = Direction.LEFT_DOWN;
                    break;
                case (2):
                    d = Direction.RIGHT_UP;
                    break;
                case (3):
                    d = Direction.RIGHT_DOWN;

            }
            Shape shape = new RightTriangle(location, pattern, params[0], params[1], d);
            int earn=0;
            for (int i = 0; i < shape.grids.length; i++) {
                for (int i1 = 0; i1 < shape.grids[0].length; i1++) {
                    if (i + x < canvas.length & i1 + y < canvas[0].length & shape.getGrids()[i][i1] != ' ') {
                        earn++;
                    }
                }
            }
            if (earn==0)return false;
            else {
                for (int i = 0; i < shape.grids.length; i++) {
                    for (int i1 = 0; i1 < shape.grids[0].length; i1++) {
                        if (i + x < canvas.length & i1 + y < canvas[0].length & shape.getGrids()[i][i1] != ' ') {
                            canvas[i+x][i1+y]=shape.getGrids()[i][i1];
                        }
                    }
                }
            }
            shapes.add(shape);
        }
        return finall;
    }

    @Override
    public int getSpaceGridCount() {
        int number=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int i1 = 0; i1 < canvas[0].length; i1++) {
                if (canvas[i][i1]==' ')number++;
            }
        }
        return number;
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
                if (o1.area()==o2.area()){
                    return (int) o1.pattern-(int) o2.pattern;
                }else return o1.area()-o2.area();

            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.location.getX()==o2.location.getX()&o1.location.getY()==o2.location.getY()){
                    return (int) o1.pattern-(int) o2.pattern;
                }else if (o1.location.getX()==o2.location.getX())return o1.location.getY()-o2.location.getY();
                else return o1.location.getX()-o2.location.getX();
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return  canvas;
    }
}

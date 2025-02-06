import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private ArrayList<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    int row;
    int col;
    public AvoidConflictShapeCanvas(int rows, int cols){
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
            if (shape.grids.length+x>canvas.length||shape.grids[0].length+y>canvas[0].length){
                finall=false;
            }else {
                for (int i = 0; i < shape.grids.length; i++) {
                    for (int i1 = 0; i1 < shape.grids[0].length; i1++) {
                        if (canvas[i+x][i1+y]!=' '&shape.getGrids()[i][i1]!=' ')return false;
                    }
                }
                for (int i = 0; i < shape.grids.length; i++) {
                    for (int i1 = 0; i1 < shape.grids[0].length; i1++) {
                        if (canvas[i+x][i1+y]==' '&shape.getGrids()[i][i1]!=' ')canvas[i+x][i1+y]=shape.getGrids()[i][i1];
                    }
                }
                shapes.add(shape);
            }

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
            if (shape.grids.length+x>canvas.length||shape.grids[0].length+y>canvas[0].length){
                finall=false;
            }else {
                for (int i = 0; i < shape.grids.length; i++) {
                    for (int i1 = 0; i1 < shape.grids[0].length; i1++) {
                        if (canvas[i+x][i1+y]!=' '&shape.getGrids()[i][i1]!=' ')return false;
                    }
                }
                for (int i = 0; i < shape.grids.length; i++) {
                    for (int i1 = 0; i1 < shape.grids[0].length; i1++) {
                        if (canvas[i+x][i1+y]==' '&shape.getGrids()[i][i1]!=' ')canvas[i+x][i1+y]=shape.getGrids()[i][i1];
                    }
                }
                shapes.add(shape);
            }
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

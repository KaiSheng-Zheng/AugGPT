import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape s1;
        if (params.length == 1) {
            s1 = new Circle(new Location(x, y), pattern, params[0]);
        } else {
            Direction d = null;
            if (params[2] == 0) {
                d = Direction.LEFT_UP;
            } else if (params[2] == 1) {
                d = Direction.LEFT_DOWN;
            } else if (params[2] == 2) {
                d = Direction.RIGHT_UP;
            } else if (params[2] == 3) {
                d = Direction.RIGHT_DOWN;
            }
            s1 = new RightTriangle(new Location(x, y), pattern, params[0], params[1], d);
        }
        boolean judgment=false;
        char[][] grids = s1.getGrids();
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (x+i<canvas.length && y+j<canvas[x+i].length & grids[i][j]!=' '){
                    canvas[x+i][y+j]=grids[i][j];
                    judgment=true;
                }
            }
        }
        if (judgment){
            shapes.add(s1);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int getSpaceGridCount() {
        int sum=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j]!='\u0000' & canvas[i][j]!=' ') {
                    sum++;
                }
            }
        }
        return sum;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape1> shapes1 = new ArrayList<>();;
        List<Shape> shapes2 = new ArrayList<>();;
        for(Shape shape:shapes){
            shapes1.add(new Shape1(shape));
        }
        Collections.sort(shapes1);
        for(Shape1 shape1:shapes1){
            shapes2.add(shape1.shape);
        }
        return shapes2;
    }

    @Override
    public char[][] getCanvas() {
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j]=='\u0000') {
                    canvas[i][j] = ' ';
                }
            }
        }
        return canvas;
    }
    private static class Shape1 implements Comparable<Shape1>{
        public Shape shape;
        public Shape1(Shape shape){
            this.shape=shape;
        }


        @Override
        public int compareTo(Shape1 o) {
            if (this.shape.location.getX() < o.shape.location.getX()) {
                return -1;
            }
            else if (this.shape.location.getX() == o.shape.location.getX()) {
                if (this.shape.location.getY() < o.shape.location.getY()) {
                    return -1;
                } else if (this.shape.location.getY() == o.shape.location.getY()) {
                    if (this.shape.pattern < o.shape.pattern) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                else {
                    return 1;
                }
            }
            else {
                return 1;
            }
        }
    }

}

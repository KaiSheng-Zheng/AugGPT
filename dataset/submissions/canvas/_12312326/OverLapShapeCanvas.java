import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;


    public OverLapShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 3) {
            Location location = new Location(x, y);
            Shape rt = new RightTriangle(location, pattern, params[0], params[1], Direction.values()[params[2]]);
            rt.fillGrids();
            boolean isEmpty = true;
            for (int i = 0; i < rt.getGrids().length; i++) {
                for (int j = 0; j < rt.getGrids()[0].length; j++) {
                    if (i + x >= canvas.length || j + y >= canvas[0].length || i + x < 0 || j + y < 0) {
                        continue;
                    }
                    if (rt.getGrids()[i][j] != ' ') {
                        canvas[i + x][j + y] = rt.getGrids()[i][j];
                        isEmpty = false;
                    }
                }
            }


            if (isEmpty) {
                return false;
            }
            shapes.add(rt);
            return true;
        }
        if (params.length == 1) {
            Location location = new Location(x, y);
            Shape c = new Circle(location, pattern, params[0]);
            c.fillGrids();
            boolean isEmpty = true;
            for (int i = 0; i < c.getGrids().length; i++) {
                for (int j = 0; j < c.getGrids()[0].length; j++) {
                    if (i + x >= canvas.length || j + y >= canvas[0].length || i + x < 0 || j + y < 0) {
                        continue;
                    }
                    if (c.getGrids()[i][j] != ' ') {
                        canvas[i + x][j + y] = c.getGrids()[i][j];
                        isEmpty = false;
                    }
                }
            }

                if (isEmpty) {
                    return false;
                }
                shapes.add(c);
                return true;


        }
         return false;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    public List<Shape> getShapesByArea() {
        shapes.sort(new Comparator(){
            public int compare(Object o1, Object o2){
                Shape s1 = (Shape) o1;
                Shape s2 = (Shape) o2;
                if(s1.area() == s2.area()){
                    return s1.pattern - s2.pattern;
                }
                return s1.area() - s2.area();
            }
        });
        return shapes;


    }
    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator(){
            public int compare(Object o1, Object o2){
                Shape s1 = (Shape) o1;
                Shape s2 = (Shape) o2;
                if(s1.location.getX() == s2.location.getX()){
                    if(s1.location.getY() == s2.location.getY()){
                        return s1.pattern - s2.pattern;
                    }
                    return s1.location.getY() - s2.location.getY();
                }
                return s1.location.getX() - s2.location.getX();
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

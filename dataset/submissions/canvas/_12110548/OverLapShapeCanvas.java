import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    int a;
    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
        a = rows * cols;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length == 1){
            Location l = new Location(x, y);
            int r = params[0];
            Shape s = new Circle(l, pattern, r);
            char[][] grids = s.getGrids();
            boolean isadd = false;
            int h = grids.length;
            int w = grids[0].length;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(grids[i][j] != ' ' && x + i < canvas.length && y + j < canvas[0].length){
                        isadd = true;
                    }
                }
            }
            if(isadd == false){
                return false;
            }


            for(int i = 0; i < h && i + x < canvas.length; i++){
                for(int j = 0; j < w && j + y < canvas[0].length; j++){
                    char c = grids[i][j];
                    if(c != ' '){
                        if(canvas[i + x][j + y] == ' '){
                            a--;
                        }
                        canvas[i + x][j + y] = c;
                    }
                }
            }
            shapes.add(s);
            return true;
        }
        else if(params.length == 3){
            Location l = new Location(x, y);
            int width = params[0];
            int height = params[1];
            Direction d = Direction.LEFT_UP;
            if(params[2] == 1){
                d = Direction.LEFT_DOWN;
            }
            else if(params[2] == 2){
                d = Direction.RIGHT_UP;
            }
            else if(params[2] == 3){
                d = Direction.RIGHT_DOWN;
            }
            Shape s = new RightTriangle(l, pattern, width, height, d);
            char[][] grids = s.getGrids();
            boolean isadd = false;
            int h = grids.length;
            int w = grids[0].length;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(grids[i][j] != ' ' && x + i < canvas.length && y + j < canvas[0].length){
                        isadd = true;
                    }
                }
            }
            if(isadd == false){
                return false;
            }

            for(int i = 0; i < h && i + x < canvas.length; i++){
                for(int j = 0; j < w && j + y < canvas[0].length; j++){
                    char c = grids[i][j];
                    if(c != ' '){
                        if(canvas[i + x][j + y] == ' '){
                            a--;
                        }
                        canvas[i + x][j + y] = c;
                    }
                }
            }
            shapes.add(s);
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        return a;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {

        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int areaComparison = Integer.compare(s1.area(), s2.area());
                if (areaComparison != 0) {
                    return areaComparison;
                }
                return Character.compare(s1.pattern, s2.pattern);
            }
        });

        return sortedShapes;

    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int xComparison = Integer.compare(s1.location.getX(), s2.location.getX());
                if (xComparison != 0) {
                    return xComparison;
                }
                if(xComparison == 0){
                    int yComparison = Integer.compare(s1.location.getY(), s2.location.getY());
                    if (yComparison != 0) {
                        return yComparison;
                    }
                }
                return Character.compare(s1.pattern, s2.pattern);
            }
        });

        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

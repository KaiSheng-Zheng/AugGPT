import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1){
            int radius = params[0];
            Location location = new Location(x, y);
            Circle circle = new Circle(location, pattern, radius);
            if (x+2*radius > canvas.length || y+2*radius > canvas[0].length){
                return false;
            }
            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[i].length; j++) {
                    if (circle.getGrids()[i][j] == pattern && canvas[i+x][j+y] != ' '){
                        return false;
                    }
                }
            }

            for (int i = 0; i < circle.getGrids().length; i++) {
                for (int j = 0; j < circle.getGrids()[i].length; j++) {
                    if(circle.getGrids()[i][j]!=' '){
                        canvas[i+x][j+y] = circle.getGrids()[i][j];
                    }

                }
            }
            shapes.add(circle);
        } else if (params.length == 3) {
            int width = params[0];
            int height = params[1];
            int directionIndex = params[2];
            Direction d = null;
            switch (directionIndex){
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
            }
            Location location = new Location(x, y);
            RightTriangle rightTriangle = new RightTriangle(location,pattern,width,height,d);
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[i].length; j++) {
                    if (rightTriangle.getGrids()[i][j] == pattern && (i+x >= canvas.length || j+y >= canvas[0].length) ){
                        return false;
                    }
                }
            }
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[i].length; j++) {
                    if(rightTriangle.getGrids()[i][j] == pattern && canvas[i+x][j+y] != ' '){
                        return false;
                    }
                }
            }
            for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                for (int j = 0; j < rightTriangle.getGrids()[i].length; j++) {
                    if (rightTriangle.getGrids()[i][j]!=' '){
                        canvas[i+x][j+y] = rightTriangle.getGrids()[i][j];
                    }
                }
            }
            shapes.add(rightTriangle);
        }else {
            return false;
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if(canvas[i][j]==' '){
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

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int result = Double.compare(s1.area(), s2.area());
                if (result == 0) {
                    result = Character.compare(s1.getPattern(), s2.getPattern());
                }
                return result;
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                int result = Double.compare(s1.X, s2.X);
                if (result == 0) {
                    result = Double.compare(s1.Y, s2.Y);
                }
                if (result == 0) {
                    result = Character.compare(s1.getPattern(), s2.getPattern());
                }
                return result;
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }


}

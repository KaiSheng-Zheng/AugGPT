import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length ; i++){
            for (int j = 0 ; j < canvas[i].length ; j++){
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }

    public List<Shape> getShapesByArea() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area() != s2.area()) {
                    return Double.compare(s1.area(), s2.area());
                }else {
                    return s1.getPattern() - s2.getPattern();
                }
            }
        });
        return shapes;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x,y);
        if (params.length == 1) {

            boolean inCanvas = false;
            int radius = params[0];
            Circle circle = new Circle(location,pattern,radius);

            for (int i = x; i < x + 2 * radius; i++) {
                for (int j = y; j < y + 2 * radius; j++) {
                    if (Math.pow(radius, 2) > Math.pow(Math.abs(radius - i +x - 0.5) - 0.5, 2) + Math.pow(Math.abs(radius - j +y - 0.5) - 0.5, 2) && i >=0 && j >=0 && i < canvas.length && j < canvas[0].length) {
                        inCanvas = true;
                        if (pattern != ' '){
                            canvas[i][j] = pattern;
                        }
                    }
                }
            }
            if (inCanvas){
                shapes.add(circle);
            }
            return inCanvas;
        }

        if (params.length == 3) {

            int width = params[0];
            int height = params[1];
            int index = params[2];
            boolean inCanvas = false;

            Direction direction = switch (index) {
                case 0 -> Direction.LEFT_UP;
                case 1 -> Direction.LEFT_DOWN;
                case 3 -> Direction.RIGHT_DOWN;
                default -> Direction.RIGHT_UP;
            };

            RightTriangle rightTriangle = new RightTriangle(location, pattern, width, height, direction);
            double slope = (double) (height) / (width);

            for (int i = x; i < x + height; i++) {
                for (int j = y; j < y + width; j++) {
                    if (index == 1) {
                        if ((j - y == 0 || (i - x + 1.0) / (j - y) > slope) && i >=0 && j >=0 && i < canvas.length && j < canvas[0].length) {
                            inCanvas = true;
                            if (pattern != ' '){
                                canvas[i][j] = pattern;
                            }
                        }
                    } else if (index == 2) {
                        if ((i - x) / (j - y + 1.0) < slope && i >=0 && j >=0 && i < canvas.length && j < canvas[0].length) {
                            inCanvas = true;
                            if (pattern != ' '){
                                canvas[i][j] = pattern;
                            }
                        }
                    } else if (index == 0) {
                        if ((double) (i - x) / (width - j + y) < slope && i >=0 && j >=0 && i < canvas.length && j < canvas[0].length) {
                            inCanvas = true;
                            if (pattern != ' '){
                                canvas[i][j] = pattern;
                            }
                        }
                    } else if (index == 3) {
                        if ((width - j + y - 1 == 0 || (i - x + 1) / (width - j + y - 1.0) > slope) && i >=0 && j >=0 && i < canvas.length && j < canvas[0].length) {
                            inCanvas = true;
                            if (pattern != ' '){
                                canvas[i][j] = pattern;
                            }
                        }
                    }
                }
            }
            if (inCanvas){
                shapes.add(rightTriangle);
            }
            return inCanvas;
        }
        return false;
    }

    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.location.getX() != s2.location.getX()) {
                    return s1.location.getX() - s2.location.getX();
                }else if (s1.location.getY() != s2.location.getY()){
                    return s1.location.getY() - s2.location.getY();
                }else {
                    return s1.getPattern() - s2.getPattern();
                }
            }
        });
        return shapes;
    }

    public int getShapeCount() {
        return shapes.size();
    }

    public int getSpaceGridCount(){
        int count = 0;
        for (int i = 0; i < canvas.length ; i++){
            for (int j = 0 ; j < canvas[i].length ; j++){
                if (canvas[i][j] == ' '){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class AvoidConflictShapeCanvas implements ShapeCanvas{

    private List<Shape> shapes;
    private char[][] canvas;

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

    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows ; i++){
            for (int j = 0 ; j < cols ; j++){
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }

    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x,y);
        if (params.length == 1) {

            int radius = params[0];
            Circle circle = new Circle(location,pattern,radius);

            if (x + 2 * radius > canvas[0].length || y + 2 * radius > canvas.length) {
                return false;
            }

            for (int i = x; i < x + 2 * radius; i++) {
                for (int j = y; j < y + 2 * radius; j++) {
                    if (Math.pow(radius, 2) > Math.pow(Math.abs(radius - i+x - 0.5) - 0.5, 2) + Math.pow(Math.abs(radius - j+y - 0.5) - 0.5, 2)) {
                        if (canvas[i][j] != ' ') {
                            return false;
                        }
                    }
                }
            }

            for (int i = x; i < x + 2 * radius; i++) {
                for (int j = y; j < y + 2 * radius; j++) {
                    if (Math.pow(radius, 2) > Math.pow(Math.abs(radius - i+x - 0.5) - 0.5, 2) + Math.pow(Math.abs(radius - j+y - 0.5) - 0.5, 2)) {
                        canvas[i][j] = pattern;
                    }
                }
            }
            shapes.add(circle);
            return true;
        }

        if (params.length == 3) {

            int width = params[0];
            int height = params[1];
            int index = params[2];

            Direction direction = switch (index) {
                case 0 -> Direction.LEFT_UP;
                case 1 -> Direction.LEFT_DOWN;
                case 3 -> Direction.RIGHT_DOWN;
                default -> Direction.RIGHT_UP;
            };

            RightTriangle rightTriangle = new RightTriangle(location,pattern,width,height,direction);

            if (x + height > canvas.length || y + width > canvas[0].length) {
                return false;
            }

            double slope = (double) (height) / (width);

            for (int i = x; i < x + height; i++) {
                for (int j = y; j < y + width; j++) {
                    if (index == 1) {
                        if (j - y == 0 || (i - x + 1.0) / (j - y) > slope) {
                            if (canvas[i][j] != ' ') {
                                return false;
                            }
                        }
                    } else if (index == 2) {
                        if ((i - x) / (j - y + 1.0) < slope) {
                            if (canvas[i][j] != ' ') {
                                return false;
                            }
                        }
                    } else if (index == 0) {
                        if ((double) (i - x) / (width - j + y) < slope) {
                            if (canvas[i][j] != ' ') {
                                return false;
                            }
                        }
                    } else if (index == 3) {
                        if ((width-j+y  == 0 || (i-x+1.0) / (width-j+y) > slope) && i >=0 && j >=0 && i < canvas.length && j < canvas[0].length) {
                            if (canvas[i][j] != ' ') {
                                return false;
                            }
                        }
                    }
                }
            }

            for (int i = x; i < x + height; i++) {
                for (int j = y; j < y + width; j++) {
                    if (index == 1) {
                        if (j - y == 0 || (i - x + 1.0) / (j - y) > slope) {
                            canvas[i][j] = pattern;
                        }
                    } else if (index == 2) {
                        if ((i - x) / (j - y + 1.0) < slope) {
                            canvas[i][j] = pattern;
                        }
                    } else if (index == 0) {
                        if ((double) (i - x) / (width - j + y) < slope) {
                            canvas[i][j] = pattern;
                        }
                    } else if (index == 3) {
                        if (width - j + y - 1 == 0 || (i - x + 1) / (width - j + y - 1.0) > slope) {
                            canvas[i][j] = pattern;
                        }
                    }
                }
            }
            shapes.add(rightTriangle);
        }
        return true;
    }


    public int getShapeCount() {
        return shapes.size();
    }

    public int getSpaceGridCount(){
        int count = 0;
        for (int i = 0; i < canvas.length ; i++){
            for (int j = 0 ; j < canvas[i].length ; i++){ // should be j++
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

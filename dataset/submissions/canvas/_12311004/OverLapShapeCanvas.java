import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private int spaceCounter = 0;
    private int shapeCounter = 0;

    private int judger = 0;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        this.shapes = new ArrayList<Shape>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    public boolean judgerForShape(int judger, Shape shape){

        if(judger == 1){
            shapes.add(shape);
            judger = 0;
            shapeCounter++;
            return true;

        } else if (judger == 0) {
            return false;
        }

        return true;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            judger = 0;
            double radius = params[0];
            Shape newCircle = new Circle(new Location(x, y), pattern, params[0]);
            for (int i = 0; i < 2 * radius; i++) {
                for (int j = 0; j < 2 * radius; j++) {
                    if (newCircle.grids[i][j] == pattern) {
                        if ( x + i >= 0 && x + i <= canvas.length - 1 && y + j >= 0 && y + j <= canvas[0].length - 1){
                            canvas[x + i][y + j] = pattern;
                            judger = 1;
                        }

                    }
                }
            }

            return judgerForShape(judger, newCircle);
        }

        if (params.length == 3) {
            double width = params[0];
            double height = params[1];
            switch (params[2]) {
                case 0 -> {
                    judger = 0;
                    Shape newRTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.LEFT_UP);
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            if(newRTriangle.grids[i][j] == pattern){
                                if ( x + i >= 0 && x + i <= canvas.length - 1 && y + j >= 0 && y + j <= canvas[0].length - 1){
                                    canvas[x + i][y + j] = pattern;
                                    judger = 1;
                                }
                            }
                        }
                    }
                    return judgerForShape(judger, newRTriangle);
                }

                case 1 -> {
                    judger = 0;
                    Shape newRTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.LEFT_DOWN);
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            if(newRTriangle.grids[i][j] == pattern){
                                if ( x + i >= 0 && x + i <= canvas.length - 1 && y + j >= 0 && y + j <= canvas[0].length - 1){
                                    canvas[x + i][y + j] = pattern;
                                    judger = 1;
                                }
                            }
                        }
                    }
                    return judgerForShape(judger, newRTriangle);
                }

                case 2 -> {
                    judger = 0;
                    Shape newRTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.RIGHT_UP);
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            if(newRTriangle.grids[i][j] == pattern){
                                if ( x + i >= 0 && x + i <= canvas.length - 1 && y + j >= 0 && y + j <= canvas[0].length - 1){
                                    canvas[x + i][y + j] = pattern;
                                    judger = 1;
                                }
                            }
                        }
                    }
                    return judgerForShape(judger, newRTriangle);
                }

                case 3 -> {
                    judger = 0;
                    Shape newRTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.RIGHT_DOWN);
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            if(newRTriangle.grids[i][j] == pattern){
                                if ( x + i >= 0 && x + i <= canvas.length - 1 && y + j >= 0 && y + j <= canvas[0].length - 1){
                                    canvas[x + i][y + j] = pattern;
                                    judger = 1;
                                }
                            }
                        }
                    }
                    return judgerForShape(judger, newRTriangle);
                }
            }
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {

        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') spaceCounter++;
            }
        }
        return spaceCounter;
    }

    @Override
    public int getShapeCount() {
        return shapeCounter;
    }

    @Override
    public List<Shape> getShapesByArea() {

        shapes.sort(comparatorByArea);
        return shapes;

    }

    Comparator<Shape> comparatorByArea = ((o1, o2) -> comparatorOfArea(o1, o2));
    public int comparatorOfArea(Shape o1, Shape o2){
        if(o1.area() < o2.area()){
            return -1;
        }
        if(o1.area() > o2.area()){
            return 1;
        }
        return Character.compare(o1.pattern, o2.pattern);
    }
    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, comparatorByLocation);
        return shapes;
    }
    Comparator<Shape> comparatorByLocation = new Comparator<Shape>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            if(o1.location.getX() < o2.location.getX()){
                return -1;
            }
            if(o1.location.getX() > o2.location.getX()){
                return 1;
            }
            if(o1.location.getY() < o2.location.getY()){
                return -1;
            }
            if(o1.location.getY() > o2.location.getY()){
                return 1;
            }

            return Character.compare(o1.pattern, o2.pattern);
        }
    };

    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        for(int i = 0; i < canvas.length; i++){
            for(int j = 0;j < canvas[i].length; j++){
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

        if (params.length == 1) {
            Circle circle = new Circle(new Location(x, y), pattern, params[0]);
            circle.fillGrids();
            if (x + params[0] > canvas.length || y + params[0] > canvas[0].length ) {
                return false;
            } else {
                if (shapes == null) {
                    shapes = new ArrayList<>();
                    shapes.add(circle);
                    for (int i = 0; i < circle.getGrids().length; i++) {
                        for (int j = 0; j < circle.getGrids()[i].length; j++) {
                            if (circle.getGrids()[i][j] != ' ')
                                canvas[i + x][j + y] = circle.getGrids()[i][j];
                        }
                    }
                    return true;
                }

                 else{

                    for (int i = 0; i < circle.getGrids().length; i++) {
                        for (int j = 0; j < circle.getGrids()[i].length; j++) {
                            if (circle.getGrids()[i][j] != ' ' && canvas[i + x][j + y] != ' ') {
                                return false;
                            }
                        }
                    }

                }
            }

                    shapes.add(circle);
                    for (int i = 0; i < circle.getGrids().length; i++) {
                        for (int j = 0; j < circle.getGrids()[i].length; j++) {
                            if (circle.getGrids()[i][j] != ' ')
                                canvas[i + x][j + y] = circle.getGrids()[i][j];

                        }
                    }

                    return true;


        }
        else if (params.length == 3) {
            Direction[] directions = Direction.values();
            RightTriangle triangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], directions[params[2]]);
            triangle.fillGrids();
            for (int i = 0; i < triangle.getGrids().length; i++) {
                for (int j = 0; j < triangle.getGrids()[i].length; j++) {
                    if (triangle.getGrids()[i][j] != ' ' && (i + x >= canvas.length || j + y >= canvas[0].length)) {
                        return false;
                    }
                }
            }
            if (shapes == null) {
                shapes = new ArrayList<>();
                shapes.add(triangle);
                for (int i = 0; i < triangle.getGrids().length; i++) {
                    for (int j = 0; j < triangle.getGrids()[i].length; j++) {
                        if (triangle.getGrids()[i][j] != ' ')
                            canvas[i + x][j + y] = triangle.getGrids()[i][j];

                    }

                }
                return true;
            }
        else{
                    for (int i = 0; i < triangle.getGrids().length; i++) {
                        for (int j = 0; j < triangle.getGrids()[i].length; j++) {
                            if (triangle.getGrids()[i][j] != ' ' && canvas[i + x][j + y] != ' ') {
                                return false;
                            }
                        }
                    }
                }
                shapes.add(triangle);
                for (int i = 0; i < triangle.getGrids().length; i++) {
                    for (int j = 0; j < triangle.getGrids()[i].length; j++) {
                        if(triangle.getGrids()[i][j] != ' ')
                            canvas[i + x][j + y] = triangle.getGrids()[i][j];
                    }
                }

                return true;
            }
            return false;

        }





    @Override
    public int getSpaceGridCount() {
        int sum = 0;
        for(int i = 0; i < canvas.length;i++){
            for (int j = 0;j < canvas[i].length;j++){
                if(canvas[i][j] != ' '){
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
        OrderByAreaComparator c = new OrderByAreaComparator();
        shapes.sort(c);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        OrderByLocationComparator c = new OrderByLocationComparator();
        shapes.sort(c);
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

class OrderByLocationComparator implements Comparator<Shape>{

    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.location.getX() < o2.location.getX()){
            return -1;
        }
        else if(o1.location.getX() > o2.location.getX()){
            return 1;
        }
        else{
            if(o1.location.getY() < o2.location.getY()){
                return -1;
            }
            else if (o1.location.getY() > o2.location.getY()) {
                return 1;
            }
            else{
                if (o1.getPattern() < o2.getPattern()) {
                    return -1;
                } else if (o1.getPattern() > o2.getPattern()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}

class OrderByAreaComparator implements Comparator<Shape>{

    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.area() < o2.area()){
            return -1;
        }
        else if(o1.area() > o2.area()){
            return 1;
        }
        else{
            if(o1.area() < o2.area()){
                return -1;
            }
            else if (o1.area() > o2.area()) {
                return 1;
            }
            else{
                if (o1.getPattern() < o2.getPattern()) {
                    return -1;
                } else if (o1.getPattern() > o2.getPattern()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
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
            if (x >= canvas.length - 1 && y >= canvas[0].length - 1) {
                return false;
            }
                int sum = 0;
                for (int i = 0; i < Math.min(circle.getGrids().length, canvas.length - x); i++) {
                    for (int j = 0; j < Math.min(circle.getGrids()[i].length, canvas[i].length - y); j++) {
                        if (circle.getGrids()[i][j] == ' ') {
                            sum += 1;
                        }
                    }
                }
                if (sum == Math.min(circle.getGrids().length, canvas.length - x) * Math.min(circle.getGrids()[0].length, canvas[0].length - y)) {
                    return false;
                } else {
                    if (shapes == null) {
                        shapes = new ArrayList<>();
                        shapes.add(circle);
                        for (int i = 0; i < Math.min(circle.getGrids().length, canvas.length - x); i++) {
                            for (int j = 0; j < Math.min(circle.getGrids()[i].length, canvas[i].length - y); j++) {
                                if (circle.getGrids()[i][j] != ' ')
                                    canvas[i + x][j + y] = circle.getGrids()[i][j];
                            }
                        }
                        return true;
                    } else {
                        shapes.add(circle);
                        for (int i = 0; i < Math.min(circle.getGrids().length, canvas.length - x); i++) {
                            for (int j = 0; j < Math.min(circle.getGrids()[i].length, canvas[i].length - y); j++) {
                                if (circle.getGrids()[i][j] != ' ')
                                    canvas[i + x][j + y] = circle.getGrids()[i][j];
                            }
                        }

                        return true;
                    }
                }

        } else if (params.length == 3) {
            Direction[] directions = Direction.values();
            RightTriangle triangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], directions[params[2]]);
            triangle.fillGrids();
            if (x >= canvas.length - 1 || y >= canvas[0].length - 1) {
                return false;
            }
            int sum = 0;
            for (int i = 0; i < Math.min(triangle.getGrids().length, canvas.length - x); i++) {
                for (int j = 0; j < Math.min(triangle.getGrids()[i].length, canvas[i].length - y); j++) {
                    if (triangle.getGrids()[i][j] == ' ' ) {
                        sum += 1;
                    }
                }
            }
            if(sum == Math.min(triangle.getGrids().length, canvas.length - x) * Math.min(triangle.getGrids()[0].length, canvas[0].length - y)){
                return false;
            }
            if (shapes == null) {
                shapes = new ArrayList<>();
                shapes.add(triangle);
                for (int i = 0; i < Math.min(triangle.getGrids().length, canvas.length - x); i++) {
                    for (int j = 0; j < Math.min(triangle.getGrids()[i].length, canvas[i].length - y); j++) {
                        if (triangle.getGrids()[i][j] != ' ')
                            canvas[i + x][j + y] = triangle.getGrids()[i][j];

                    }

                }
                return true;
            } else {
                shapes.add(triangle);
                for (int i = 0; i < Math.min(triangle.getGrids().length, canvas.length - x); i++) {
                    for (int j = 0; j < Math.min(triangle.getGrids()[i].length, canvas[i].length - y); j++) {
                        if (triangle.getGrids()[i][j] != ' ')
                            canvas[i + x][j + y] = triangle.getGrids()[i][j];
                    }
                }
                return true;
            }

        }
        return false;
    }



    @Override
    public int getSpaceGridCount() {
        int sum = 0;
        for(int i = 0; i < canvas.length;i++){
            for (int j = 0;j < canvas[i].length;j++){
                if(canvas[i][j] == ' '){
                    sum += 1;
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
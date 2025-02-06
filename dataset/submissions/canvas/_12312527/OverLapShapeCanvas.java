import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;




    public OverLapShapeCanvas(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        this.shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean InTheBound = false;


        if (params.length == 1) { // circle case
            int radius = params[0];
            int diameter =radius * 2;
            Circle circle = new Circle(new Location(x, y), pattern, radius);
            for (int i = 0; i < diameter; i++) {
                for (int j = 0; j < diameter; j++) {
                    if (circle.grids[i][j] == pattern) {
                        if ((x + i < rows) && (x + i >= 0) && (y + j < cols) && (y + j >= 0)) { // out of bound
                            InTheBound = true;
                            break;
                        }
                    }
                }
            }

            if (InTheBound){
                for (int i = 0; i < diameter; i++) {
                    for (int j = 0; j < diameter; j++) {
                        if (circle.grids[i][j] == pattern)
                            if ((x + i < rows) && (x + i >= 0) && (y + j < cols) && (y + j >= 0)) {
                                canvas[x+i][y+j] = pattern;
                            }
                    }
                }
            }
            else{
                return false;
            }


            shapes.add(circle);

        }

        else{ // right triangle case
            int width = params[0];
            int height = params[1];
            Direction dir = Direction.values()[params[2]];

            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, width, height, dir);
//            rightTriangle.fillGrids();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (rightTriangle.grids[i][j] == pattern) {
                        if ((x + i < rows) && (x + i >= 0) && (y + j < cols) && (y + j >= 0)) { // out of bound
                            InTheBound = true;

                            break;
                        }
                    }
                }
            }
            if (InTheBound){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (rightTriangle.grids[i][j] == pattern)
                        if ((x + i < rows) && (x + i >= 0) && (y + j < cols) && (y + j >= 0)) {
                            canvas[x+i][y+j] = pattern;
                        }
                    }
                }
            }
            else{
                return false;
            }
            shapes.add(rightTriangle);
        }
        return true;
    }


    @Override
    public List<Shape> getShapesByArea() {
        Comparator<Shape> com = new Comparator<Shape>() {
            @Override
            public int compare(Shape object0, Shape object1) {
                if (object0.area() > object1.area()) {
                    return 1;
                } else if (object0.area() < object1.area()) {
                    return -1;
                } else {
                    if (object0.pattern >object1.pattern) {
                        return 1;
                    } else if (object0.pattern <object1.pattern) {
                        return -1;
                    }
                }
                return 0;
            }
        };

        shapes.sort(com);
        return shapes;
    }
    @Override
    public int getShapeCount() {
        return shapes.size();
    }



    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> com = new Comparator<Shape>() {
            @Override
            public int compare(Shape object0, Shape object1) {
                if (object0.location.getX() > object1.location.getX()) {
                    return 1;
                } else if (object0.location.getX() < object1.location.getX()) {
                    return -1;
                } else {
                    if (object0.location.getY() > object1.location.getY()) {
                        return 1;
                    } else if (object0.location.getY() < object1.location.getY()) {
                        return -1;
                    }
                    else{
                        if (object0.pattern > object1.pattern){
                            return 1;
                        } else if (object0.pattern<object1.pattern) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        };
        shapes.sort(com);
        return shapes;
    }
    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
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

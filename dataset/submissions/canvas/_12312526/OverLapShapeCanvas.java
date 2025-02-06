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
        boolean atleastOneIsInside = false;


        if (params.length == 1) { // circle case
            int radius = params[0];

            Circle circle = new Circle(new Location(x, y), pattern, radius);
//            circle.fillGrids();
            for (int i = 0; i < radius * 2; i++) {
                for (int j = 0; j < radius * 2; j++) {
                    if (circle.grids[i][j] == pattern) {
                        if ((x + i < rows) && (x + i >= 0) && (y + j < cols) && (y + j >= 0)) { // out of bound
                            atleastOneIsInside = true;
                            break;
                        }
                    }
                }
            }

            if (atleastOneIsInside){
                for (int i = 0; i < radius * 2; i++) {
                    for (int j = 0; j < radius*2; j++) {
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
                            atleastOneIsInside = true;

                            break;
                        }
                    }
                }
            }
            if (atleastOneIsInside){
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
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Comparator<Shape> com = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.area() < o2.area()) {
                    return -1;
                } else if (o1.area() > o2.area()) {
                    return 1;
                } else {
                    if (o1.pattern < o2.pattern) {
                        return -1;
                    } else if (o1.pattern > o2.pattern) {
                        return 1;
                    }
                }
                return 0;
            }
        };

        shapes.sort(com);
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Comparator<Shape> com = new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if (o1.location.getX() < o2.location.getX()) {
                    return -1;
                } else if (o1.location.getX() > o2.location.getX()) {
                    return 1;
                } else {
                    if (o1.location.getY() < o2.location.getY()) {
                        return -1;
                    } else if (o1.location.getY() > o2.location.getY()) {
                        return 1;
                    }
                    else{
                        if (o1.pattern < o2.pattern){
                            return -1;
                        } else if (o1.pattern>o2.pattern) {
                            return 1;
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
    public char[][] getCanvas() {
        return canvas;
    }
}

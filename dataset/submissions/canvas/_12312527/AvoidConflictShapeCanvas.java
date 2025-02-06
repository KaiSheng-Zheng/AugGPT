import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private final int rows;
    private final int cols;


    public AvoidConflictShapeCanvas(int rows, int cols){
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
    public boolean addShape(int x, int y, char pattern, int... params){ // in canvas, x is row, y is col
//        storeTempCanvas = canvas; // initially is spaced grid
        boolean NoCollision= true;
        if (params.length == 1) { // circle case

            int radius = params[0];

            Circle circle = new Circle(new Location(x, y), pattern, radius);
            for (int i = 0; i < radius * 2; i++) {
                for (int j = 0; j < radius * 2; j++) {
                    if (circle.grids[i][j] == pattern) {
                        if (  (y + j >= cols) || (y + j < 0)||(x + i >= rows) || (x + i < 0) ) {
                            NoCollision= false;
                            break;
                        }else {
                            if (canvas[x + i][y +j] != ' '){
                                NoCollision = false;
                                break;
                            }
                        }
                    }
                }
            }

            if (NoCollision) {
                for (int i = 0; i < radius * 2; i++) {
                    for (int j = 0; j < radius * 2; j++) {
                        if (circle.grids[i][j] == pattern) {
                            canvas[x + i][y + j] = pattern;
                        }//end if
                    }//end for j
                }
                //enf for i
            } else {
                return false;
            }shapes.add(circle);
        }//end if

        else{
            int width = params[0];
            int height = params[1];

            Direction direction = Direction.values()[params[2]];

            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, width, height, direction);
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (rightTriangle.grids[i][j] == pattern){
                        if ((y + j >= cols) || (y + j < 0) || (x + i >= rows) || (x + i < 0)){
                            NoCollision = false;
                            break;
                        }else {
                            if (canvas[x + i][y +j] != ' '){
                                NoCollision = false;
                                break;
                            }//end
                        }
                    }
                }
            }

            if (NoCollision){
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if(rightTriangle.grids[i][j] == pattern){
                            canvas[x + i][y+j] = pattern;
                        }
                    }
                }
            }
            else {
                return false;
            }
            this.shapes.add(rightTriangle);
        }

        return true;
    }
    @Override
    public int getSpaceGridCount(){
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
    public int getShapeCount(){
        return shapes.size();
    }
        @Override
        public List<Shape> getShapesByLocation () {
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
            this.shapes.sort(com);
            return shapes;
        }
        @Override
        public char[][] getCanvas () {
            return canvas;
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

        this.shapes.sort(com);
        return shapes;
    }

}

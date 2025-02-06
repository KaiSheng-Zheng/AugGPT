import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j]=' ';
            }
        }
    }
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (x < 0 || x >= canvas.length || y < 0 || y >= canvas[0].length) {
            return false;
        }

        if (params.length == 1) {
            Shape shape;
            shape = new Circle(new Location(x, y), pattern, params[0]);
            int radius = params[0];
            for (int i = 0; i <shape.grids.length; i++) {
                for (int j =0; j <shape.grids[i].length; j++) {
                    if (x+i >= canvas.length||y+j >= canvas[0].length) {
                        return false;
                    }else if(canvas[x+i][y+j]!=' '&&shape.grids[i][j]!=' '){
                        return false;
                    }
                }
            }
            for (int i = 0; i <shape.grids.length; i++) {
                for (int j =0; j <shape.grids[i].length; j++) {
                    if ( canvas[x+i][y+j] ==' '&& shape.grids[i][j]!=' ') {
                        canvas[x+i][y+j] = shape.grids[i][j];
                    }
                }
            }
            shapes.add(shape);
            return true;
        }
        if (params.length == 3) {
            Shape shape;
            Direction d = null;
            int dx = 0,dy = 0;
            shape = new RightTriangle(new Location(x,y), pattern,params[0],params[1],d);
            int width = params[0];
            int height = params[1];
            int directionIndex = params[2];
            if(params[2]==0){
                d = Direction.LEFT_UP;

            }
            if(params[2]==1){
                d = Direction.LEFT_DOWN;

            }
            if(params[2]==2){
                d = Direction.RIGHT_UP;

            }
            if(params[2]==3){
                d = Direction.RIGHT_DOWN;

            }
            shape = new RightTriangle(new Location(x,y), pattern,params[0],params[1],d);
            for (int i = 0; i <shape.grids.length; i++) {
                for (int j =0; j <shape.grids[0].length; j++) {

                    if (x+i >= canvas.length||y+j >= canvas[0].length) {
                        return false;
                    }else if(canvas[x+i][y+j]!=' '&&shape.grids[i][j]!=' '){
                        return false;
                    }
                }
            }
            for (int i = 0; i <shape.grids.length; i++) {
                for (int j =0; j <shape.grids[i].length; j++) {
                    if ( canvas[x+i][y+j] ==' '&& shape.grids[i][j]!=' ') {
                        canvas[x+i][y+j] = shape.grids[i][j];
                    }
                }
            }
            shapes.add(shape);
            return true;


        }
        return false;
    }


        public int getSpaceGridCount () {
            int count = 0;
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if (canvas[i][j] != ' ') {
                        count++;
                    }
                }
            }
            return count;
        }

        public int getShapeCount () {
        return this. shapes.size();
        }

        public List<Shape> getShapesByArea () {
            List<Shape> sortedShapes = this.shapes;
            Collections.sort(sortedShapes, new Comparator<Shape>() {
                @Override
                public int compare(Shape shape1, Shape shape2) {
                    int areaComparison = shape1.area() - shape2.area();
                    if (areaComparison != 0) {
                        return areaComparison;
                    }

                    return shape1.pattern - shape2.pattern;
                }
            });
            return sortedShapes;
        }

        public List<Shape> getShapesByLocation () {
            List<Shape> sortedShapes = this.shapes;
            Collections.sort(sortedShapes, new Comparator<Shape>() {
                @Override
                public int compare(Shape shape1, Shape shape2) {

                    int xComparison = shape1.location.getX() - shape2.location.getX();
                    if (xComparison != 0) {
                        return xComparison;
                    }


                    int yComparison = shape1.location.getY() - shape2.location.getY();
                    if (yComparison != 0) {
                        return yComparison;
                    }


                    return shape1.pattern - shape2.pattern;
                }
            });
            return sortedShapes;
        }

        public char[][] getCanvas () {
            return canvas;
        }
    }
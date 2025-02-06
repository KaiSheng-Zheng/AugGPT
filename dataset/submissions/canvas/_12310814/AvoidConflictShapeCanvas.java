import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{

    private List<Shape> shapes;
    private char[][] canvas;
//    Using a char[][] array to represent the canvas.
//    The initial value of each grid in canvas is a space ' ' , which mean an empty grid.
    public AvoidConflictShapeCanvas(int rows, int cols){
        //Initialization of canvas
        canvas = new char[rows][cols];
        shapes = new ArrayList<>();
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean validity = true;
        Shape shape = null;
        if (params.length == 1){
            shape = new Circle(new Location(x,y), pattern,params[0]);
        } else if (params.length == 3) {
            shape = new RightTriangle(new Location(x,y), pattern, params[0], params[1], implyDirection(params[2]));
        }
        //Bound validity check
        if(x < 0 || x + shape.grids.length - 1 >= canvas.length
                || y < 0 || y + shape.grids[0].length - 1>= canvas[0].length){
            validity = false;
        }
        if(validity){
            for (int j = 0; j < shape.grids.length; j++) {
            for (int k = 0; k < shape.grids[0].length; k++) {
                //Overlap validity check
                if(shape.grids[j][k] != ' ' &&
                        canvas[shape.location.getX() + j][shape.location.getY() + k] != ' '){
                    validity = false;
                    break;
                }
//                else{canvas[shape.location.getY() + j][shape.location.getX() + k]
//                        = shape.grids[j][k];
//                }
            }
        }
        }

        //Add the grids in the canvas
        if(validity) {
            for (int j = 0; j < shape.grids.length; j++) {
                for (int k = 0; k < shape.grids[0].length; k++) {
                    if(shape.grids[j][k] != ' '){//if it is not blank, we fill in
                        canvas[shape.location.getX() + j][shape.location.getY() + k] = shape.grids[j][k];
                    }
                }
            }
    }
        if(validity){
            shapes.add(shape);
        }
        return validity;
    }

    @Override
    public int getSpaceGridCount() {
        int space = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if(canvas[i][j] == ' '){
                    space ++;
                }
            }
        }
        return space;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        int n = shapes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (shapes.get(j).area() < shapes.get(i).area()) {
                    // Swap the elements
                    Shape temp = shapes.get(i);
                    shapes.set(i, shapes.get(j));
                    shapes.set(j, temp);//Lists is different with arrays
                } else if (shapes.get(j).area() == shapes.get(i).area()) {
                    if(shapes.get(j).pattern < shapes.get(i).pattern){
                        // Swap the elements
                        Shape temp = shapes.get(i);
                        shapes.set(i, shapes.get(j));
                        shapes.set(j, temp);//Lists is different with arrays
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        int n = shapes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (shapes.get(j).location.getX() < shapes.get(i).location.getX()) {
                    // Swap the elements
                    Shape temp = shapes.get(i);
                    shapes.set(i, shapes.get(j));
                    shapes.set(j, temp);//Lists is different with arrays
                } else if (shapes.get(j).location.getX() == shapes.get(i).location.getX()) {
                    if(shapes.get(j).location.getY() < shapes.get(i).location.getY()){
                        // Swap the elements
                        Shape temp = shapes.get(i);
                        shapes.set(i, shapes.get(j));
                        shapes.set(j, temp);//Lists is different with arrays
                    } else if (shapes.get(j).location.getY() == shapes.get(i).location.getY()) {
                        if(shapes.get(j).pattern < shapes.get(i).pattern){
                            // Swap the elements
                            Shape temp = shapes.get(i);
                            shapes.set(i, shapes.get(j));
                            shapes.set(j, temp);//Lists is different with arrays
                        }
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
    public Direction implyDirection(int number){
        switch (number){
            case 0 : return Direction.LEFT_UP;
            case 1 : return Direction.LEFT_DOWN;
            case 2 : return Direction.RIGHT_UP;
            case 3 : return Direction.RIGHT_DOWN;
        }
        return null;
    }
}

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class OverLapShapeCanvas implements ShapeCanvas {
    private final List<Shape> shapes;
    private final char[][] canvas;
    private char[][] canvas2;
    private final List<Shape> newShapes;

    public OverLapShapeCanvas(int rows, int cols) {
        this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        this.canvas2 = new char[rows][cols];
        this.newShapes = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
                canvas2[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape;
        Location loc = new Location(x, y);
        if (params.length == 1) {
            newShape =  new Circle(loc, pattern, params[0]);
            if(OutOfBounds(newShape)){return false;}
            else{ newShapes.add(newShape);
                newShape.fillGrids();
                for(int i=0; i< canvas2.length; i++){
                    for(int j=0; j<canvas2[0].length; j++){
                        Location loc1 = new Location(i, j );
                        if(newShape.getLocations().contains(loc1)){
                            canvas2[i][j] =pattern;}}}
                getShapesBySequence(canvas2);
//                for(Shape s : newShapes) {
//                    removeShapesNotInCanvas(s);
//
//                }


                return true;}
        }
        if (params.length == 3) {
            Direction direction = getDirectionFromInt(params[2]);
            newShape = new RightTriangle(loc, pattern, params[0], params[1], direction);
            if (direction == null|| OutOfBounds(newShape)) {
                return false;
            }
            else {
                newShapes.add(newShape);
                newShape.fillGrids();
                for(int i=0; i< canvas2.length; i++){
                    for(int j=0; j<canvas2[0].length; j++){
                        Location loc1 = new Location(i, j );
                        if(newShape.getLocations().contains(loc1)){
                            canvas2[i][j] =pattern;}}}
                getShapesBySequence(canvas2);


                return true;}
            }


        return false;
    }



    public Direction getDirectionFromInt(int x) {
        return switch (x) {
            case 0 -> Direction.LEFT_UP;
            case 1 -> Direction.LEFT_DOWN;
            case 2 -> Direction.RIGHT_UP;
            case 3 -> Direction.RIGHT_DOWN;
            default -> null;
        };
    }

    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < getCanvas().length; i++) {

            for (int j = 0; j < getCanvas()[0].length; j++) {
                if (getCanvas()[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {

        return this.newShapes.size();
    }
    @Override
    public  List<Shape> getShapesByArea(){
        List<Shape> shapesByArea = new ArrayList<>(this.newShapes);
        shapesByArea.sort(Comparator.comparingInt(Shape::area).thenComparing(Shape::getPattern));
        return shapesByArea;
    }
    @Override
    public List<Shape> getShapesByLocation(){
        List<Shape> shapesByLocation = new ArrayList<>(this.newShapes);
        shapesByLocation.sort(Comparator.comparingInt(Shape::getX).thenComparing(Shape::getY).thenComparing(Shape::getPattern));
        return shapesByLocation;
    }
    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }
    private void getShapesBySequence(char[][] canvas2) {

        for (int i = 0; i < canvas2.length; i++) {
            for (int j = 0; j < canvas2[0].length; j++) {
                if (canvas2[i][j] != ' ') {
                    this.getCanvas()[i][j] = canvas2[i][j];
                }
            }
        }

    }
    private boolean OutOfBounds(Shape shape) {
        shape.fillGrids();
        for(Location loc: shape.locations){
            if (loc.getX()>=0&&loc.getY()>=0&&loc.getX()<canvas.length&&loc.getY()<canvas[0].length){
                return false;
            }
        }
        return true;
    }

    }

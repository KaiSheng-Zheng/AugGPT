import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private final List<Shape> shapes;
    private final char[][] canvas;
private char[][] canvas2;//a new array
    public AvoidConflictShapeCanvas(int rows, int cols) {
this.shapes = new ArrayList<>();
        this.canvas = new char[rows][cols];
        this.canvas2 = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Shape newShape;
        Location loc = new Location(x, y);
        if (params.length == 1) {
            newShape = new Circle(loc, pattern, params[0]);
            if(isOutOfBounds(newShape)||isOverlapping(newShape)){return false;}
           else{ newShape.fillGrids();canvas2= newShape.grids;shapes.add(newShape);
               for(int i=0; i< canvas.length; i++){
                   for(int j=0; j<canvas[0].length; j++){
                       Location loc1 = new Location(i, j );
                       if(newShape.getLocations().contains(loc1)){
                       this.canvas[i][j] =pattern;}
                   }
               }
            return true;}
        }
        if (params.length == 3) {
            Direction direction = getDirectionFromInt(params[2]);
            newShape = new RightTriangle(loc, pattern, params[0], params[1], direction);
            if (direction == null||isOutOfBounds(newShape)||isOverlapping(newShape)) {
                return false;
            }
           else {
               newShape.fillGrids();canvas2= newShape.grids;shapes.add(newShape);
                for(int i=0; i< canvas.length; i++){
                    for(int j=0; j<canvas[0].length; j++){
                        Location loc1 = new Location(i, j );
                        if(newShape.getLocations().contains(loc1)){
                            this.canvas[i][j] =pattern;}}}
                return true;
            }
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
        int count=0;
        for (int row = 0; row < canvas.length; row++) {

            for (int col = 0; col < canvas[row].length; col++) {
                if (canvas2[row][col] == ' ') { // bug: will cause ArrayIndexOutOfBoundException if calling after adding a small shape
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
    public List<Shape> getShapesByArea(){
        List<Shape> shapesByArea = new ArrayList<>(shapes);
    shapesByArea.sort(Comparator.comparingInt(Shape::area).thenComparing(Shape::getPattern));
return shapesByArea;
        }
        @Override
    public List<Shape> getShapesByLocation(){
        List<Shape> shapesByLocation = new ArrayList<>(shapes);
        shapesByLocation.sort(Comparator.comparingInt(Shape::getX).thenComparing(Shape::getY).thenComparing(Shape::getPattern));
        return shapesByLocation;
        }
        @Override
    public char[][] getCanvas() {
        return this.canvas;
        }

    private boolean isOutOfBounds(Shape shape) {
        shape.fillGrids();
        for(Location Loc:shape.locations)
        {if (Loc.getX()<0 || Loc.getX()>=canvas.length||Loc.getY()<0||Loc.getY()>=canvas[0].length){return true;}}
        return false;
    }

        private boolean isOverlapping(Shape shape) {
        shape.fillGrids();
        for(Location loc: shape.locations){
            if (canvas[loc.getX()][loc.getY()]!=' '){
                return true;
            }
        }
        return false;
        }
}



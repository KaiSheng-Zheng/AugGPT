import java.util.ArrayList;
import java.util.List;
public class OverLapShapeCanvas  implements  ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public int getSpaceGridCount(){
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' '){
                    count++;
                }
            }
        }
        return count;
    }
    public int getShapeCount(){
        return shapes.size();
    }
    public List<Shape> getShapesByArea(){
        List <Shape> shapesByArea = new ArrayList<>();
        for (Shape e:shapes){
            shapesByArea.add(e);
        }
        for (int i = 0; i < shapesByArea.size(); i++) {
            for (int j = 0; j < shapesByArea.size()-1-i; j++) {
                if (shapesByArea.get(j).area>shapesByArea.get(j+1).area){
                    Shape temp = shapesByArea.get(j);
                    shapesByArea.set(j,shapesByArea.get(j+1));
                    shapesByArea.set(j+1,temp);
                }

                if (shapesByArea.get(j).area == shapesByArea.get(j+1).area){
                    if (shapesByArea.get(j).pattern > shapesByArea.get(j+1).pattern){
                        Shape temp = shapesByArea.get(j);
                        shapesByArea.set(j,shapesByArea.get(j+1));
                        shapesByArea.set(j+1,temp);
                    }
                }

            }
        }
        return shapesByArea;
    }
    public List<Shape> getShapesByLocation(){
        List <Shape> shapesByLocation = new ArrayList<>();
        for (Shape e:shapes){
            shapesByLocation.add(e);
        }
        for (int i = 0; i < shapesByLocation.size(); i++) {
            for (int j = 0; j < shapesByLocation.size()-1-i; j++) {
                if (shapesByLocation.get(j).location.getX()  >  shapesByLocation.get(j+1).location.getX()){
                    Shape temp = shapesByLocation.get(j);
                    shapesByLocation.set(j,shapesByLocation.get(j+1));
                    shapesByLocation.set(j+1,temp);
                }

                if (shapesByLocation.get(j).location.getX()  ==  shapesByLocation.get(j+1).location.getX()){
                    if (shapesByLocation.get(j).location.getY() > shapesByLocation.get(j+1).location.getY()){
                        Shape temp = shapesByLocation.get(j);
                        shapesByLocation.set(j,shapesByLocation.get(j+1));
                        shapesByLocation.set(j+1,temp);
                    }
                }
                if (shapesByLocation.get(j).location.getY()  ==  shapesByLocation.get(j+1).location.getY()){
                    if (shapesByLocation.get(j).pattern > shapesByLocation.get(j+1).pattern){
                        Shape temp = shapesByLocation.get(j);
                        shapesByLocation.set(j,shapesByLocation.get(j+1));
                        shapesByLocation.set(j+1,temp);
                    }
                }

            }
        }
        return shapesByLocation;
    }
    public char[][] getCanvas(){
        return canvas;
    }
    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }

        }
        shapes = new ArrayList<>();
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        Shape shape;
        if (params.length == 1){
            shape = new Circle(new Location(x, y), pattern,params[0]);
        }
        else {
            Direction d = switch (params[2]) {
                case 1 -> Direction.LEFT_DOWN;
                case 2 -> Direction.RIGHT_UP;
                case 3 -> Direction.RIGHT_DOWN;
                default -> Direction.LEFT_UP;
            };
            shape = new RightTriangle(new Location(x, y),pattern,params[0],params[1],d);
        }
        char[][] grids = shape.getGrids();
        int count = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if (grids[i][j] != ' ') {
                    if (x + i <= canvas.length - 1 && y + j <= canvas[0].length - 1) {
                        canvas[x+i][y+j] = pattern;
                        count++;
                    }
                }
            }
        }
        if (count == 0){
            return false;
        }
        shapes.add(shape);
        return true;
    }
}

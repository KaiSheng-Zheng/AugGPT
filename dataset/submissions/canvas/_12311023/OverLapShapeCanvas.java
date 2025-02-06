import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;


    public OverLapShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int row = 0; row < canvas.length; row++) {
            for (int col = 0; col < canvas[row].length; col++) {
                canvas[row][col] = ' ';
            }

        }
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        if(params.length == 1){
            int[] parameter = params;
            int radius = parameter[0];
            Location location = new Location(x,y);
            Circle circle = new Circle(location, pattern, radius);
            if (isIn(circle)){
                shapes.add(circle);
                char[][] template = circle.getGrids();
                for (int row = 0; row < template.length; row++){
                    for (int col = 0; col < template[row].length; col++){
                        if (template[row][col] != ' ' && circle.getLocation().getX() + row >= 0 && circle.getLocation().getX() + row < canvas.length && circle.getLocation().getY() + col >= 0 && circle.getLocation().getY() + col < canvas[row].length){
                            canvas[circle.getLocation().getX() + row][circle.getLocation().getY() + col] = circle.getPattern();
                        }
                    }
                }
                return true;
            }else {
                return false;
            }
        }else {
            int[]parameter = params;
            int width = parameter[0];
            int height = parameter[1];
            int d = parameter[2];
            Location location = new Location(x,y);
            RightTriangle rightTriangle = new RightTriangle(location, pattern, width, height, Direction.values()[d]);
            if (isIn(rightTriangle)){
                shapes.add(rightTriangle);
                char[][] template = rightTriangle.getGrids();
                for (int row = 0; row < template.length; row++){
                    for (int col = 0; col < template[row].length; col++){
                        if (template[row][col] != ' ' && rightTriangle.getLocation().getX() + row >= 0 && rightTriangle.getLocation().getX() + row < canvas.length && rightTriangle.getLocation().getY() + col >= 0 && rightTriangle.getLocation().getY() + col < canvas[row].length){
                            canvas[rightTriangle.getLocation().getX() + row][rightTriangle.getLocation().getY() + col] = rightTriangle.getPattern();
                        }
                    }
                }
                return true;
            }else {
                return false;
            }

        }
    }

//finish
    @Override
    public int getSpaceGridCount() {
        int space = 0;
        for(int row = 0; row < this.canvas.length; row ++){
            for (int col = 0; col < this.canvas[row].length; col ++){
                if(this.canvas[row][col] == ' '){
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
    public List<Shape> getShapesByArea() {List<Shape> rearrange = new ArrayList<Shape>();

        List<Shape> buffer = new ArrayList<Shape>(shapes);

        while (!buffer.isEmpty()){
            int temp = 0;
            for (int j = 1; j < buffer.size(); j ++){
                if (buffer.get(temp).area() > buffer.get(j).area()  ){
                    temp = j;
                }else if (buffer.get(temp).area() == buffer.get(j).area() && buffer.get(temp).getPattern() > buffer.get(j).getPattern()){
                    temp = j;
                }
            }
            rearrange.add(buffer.get(temp));
            buffer.remove(temp);
        }

        return rearrange;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> rearrange = new ArrayList<Shape>();

        List<Shape> buffer = new ArrayList<Shape>(shapes);

        while (!buffer.isEmpty()){
            int temp = 0;
            for (int j = 1; j < buffer.size(); j ++){
                if (buffer.get(temp).location.getX() > buffer.get(j).location.getX()  ){
                    temp = j;
                }else if (buffer.get(temp).location.getX() == buffer.get(j).location.getX() && buffer.get(temp).location.getY() > buffer.get(j).location.getY()){
                    temp = j;
                } else if (buffer.get(temp).location.getX() == buffer.get(j).location.getX() && buffer.get(temp).location.getY() == buffer.get(j).location.getY() && buffer.get(temp).getPattern() > buffer.get(j).getPattern()) {
                    temp = j;
                }
            }
            rearrange.add(buffer.get(temp));
            buffer.remove(temp);
        }

        return rearrange;
    }

//finish
    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    private boolean isIn(Circle circle){
        boolean def = false;
        char[][] top = circle.getGrids();
        OuterLoop:
        for (int row = 0; row < top.length; row++){
            for (int col = 0; col < top[row].length; col++){
                if (top[row][col] != ' ' && circle.getLocation().getX() + row >= 0 && circle.getLocation().getX() + row < canvas.length && circle.getLocation().getY() + col >= 0 && circle.getLocation().getY() + col < canvas[0].length){
                    def = true;
                    break OuterLoop;
                }
            }
        }
        return def;
    }

    private boolean isIn(RightTriangle rightTriangle) {
        boolean def = false;
        char[][] top = rightTriangle.getGrids();
        OuterLoop:
        for (int row = 0; row < top.length; row++) {
            for (int col = 0; col < top[row].length; col++) {
                if (top[row][col] != ' ' && rightTriangle.getLocation().getX() + row >= 0 && rightTriangle.getLocation().getX() + row < canvas.length && rightTriangle.getLocation().getY() + col >= 0 && rightTriangle.getLocation().getY() + col < canvas[0].length) {
                    def = true;
                    break OuterLoop;
                }
            }
        }
        return def;
    }
}

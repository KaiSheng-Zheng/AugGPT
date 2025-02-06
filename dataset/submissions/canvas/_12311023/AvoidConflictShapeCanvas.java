import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;


    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int row = 0; row < canvas.length; row++){
            for (int col = 0; col < canvas[row].length; col++){
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
            if (y < 0 || x < 0  || canvas[x].length - y < 2*radius || canvas.length - x < 2*radius){
                return false;
            }else if (isOverlapTest(circle)){
                return false;
            }else {
                shapes.add(circle);
                char[][] template = circle.getGrids();
                for (int row = 0; row < template.length; row ++){
                    for (int col = 0; col < template[row].length; col++){
                        if (circle.getGrids()[row][col] != ' '){
                            canvas[x + row][y  + col] = template[row][col];
                        }

                    }
                }
                return true;
            }
        }else {
            int[]parameter = params;
            int width = parameter[0];
            int height = parameter[1];
            int d = parameter[2];
            Location location = new Location(x,y);
            RightTriangle rightTriangle = new RightTriangle(location, pattern, width, height, Direction.values()[d]);
            if (y < 0 || x < 0 ||canvas[x].length - y < width || canvas.length - x < height ){
                return false;
            } else if (isOverlapTest(rightTriangle)){
                return false;
            }else {
                shapes.add(rightTriangle);
                char[][] template = rightTriangle.getGrids();
                for (int row = 0; row < template.length; row ++){
                    for (int col = 0; col < template[row].length; col++){
                        if (rightTriangle.getGrids()[row][col] != ' '){
                            canvas[x + row][y  + col] = template[row][col];
                        }
                    }
                }
                return true;
            }

        }

    }

    @Override
    public int getSpaceGridCount() {
        int space = 0;
        for (int row = 0; row < canvas.length; row ++){
            for (int col = 0; col < canvas[row].length; col ++){
                if (canvas[row][col] == ' '){
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
        List<Shape> rearrange = new ArrayList<Shape>();

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
                }else if (buffer.get(temp).location.getX() == buffer.get(j).location.getX() && buffer.get(temp).getPattern() > buffer.get(j).getPattern()){
                    temp = j;
                }
            }
            rearrange.add(buffer.get(temp));
            buffer.remove(temp);
        }

        return rearrange;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    private boolean isOverlapTest(Circle circle){
        boolean def = false;
        char[][] top = circle.getGrids();
        char[][] bottom = new char[2*circle.getRadius()][2*circle.getRadius()];
        for (int row = 0; row < bottom.length; row ++){
            for (int col = 0; col < bottom[row].length; col++){
                bottom[row][col] = canvas[circle.getLocation().getX() + row][circle.getLocation().getY() + col];
            }
        }
        OuterLoop:
        for (int row = 0; row < bottom.length; row ++){
            for (int col = 0; col < bottom[row].length; col++){
                if (top[row][col] != ' ' && bottom[row][col] != ' '){
                    def = true;
                    break OuterLoop;
                }
            }
        }
        return def;
    }
    private boolean isOverlapTest(RightTriangle rightTriangle){
        boolean def = false;
        char[][] top = rightTriangle.getGrids();
        char[][] bottom = new  char[rightTriangle.getHeight()][rightTriangle.getWidth()];
        for (int row = 0; row < bottom.length; row ++){
            for (int col = 0; col < bottom[row].length; col++){
                bottom[row][col] = canvas[rightTriangle.getLocation().getX() + row][rightTriangle.getLocation().getY() + col];
            }
        }
        OuterLoop:
        for (int row = 0; row < bottom.length; row ++){
            for (int col = 0; col < bottom[row].length; col++){
                if (top[row][col] != ' ' && bottom[row][col] != ' '){
                    def = true;
                    break OuterLoop;
                }
            }
        }
        return def;
    }

}

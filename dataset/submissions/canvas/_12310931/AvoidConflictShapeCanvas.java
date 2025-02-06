import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private ArrayList<Shape> shapes;
    private ArrayList<Shape> shapeByArea;
    private ArrayList<Shape> shapeByLocation;
    private char[][] canvas;
    private boolean[][] canPaint;
    private int countShape = 0;
    private int countArea = 0;
    public AvoidConflictShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        this.canPaint = new boolean[rows][cols];
        this.shapes = new ArrayList<Shape>();
        this.shapeByArea = new ArrayList<Shape>();
        this.shapeByLocation = new ArrayList<Shape>();
        this.initialCanvas();
    }
    private void initialCanvas(){
        for(int i = 0; i < canvas.length; i++){
            for(int j = 0; j < canvas[i].length; j++){
                canvas[i][j] = ' ';
                canPaint[i][j] = true;
            }
        }
    }
    private boolean checkShape(Shape shape, char[][] grid){
        for(int i = 0 ; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(i + shape.location.getX() >= canvas.length || j + shape.location.getY() >= canvas[i].length)return false;
                else if(this.canPaint[i + shape.location.getX()][j + shape.location.getY()] == false && grid[i][j] == shape.pattern){
                    return false;
                }
            }
        }
        return true;
    }
    public void paint(char[][] grid, Location location, char pattern){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(this.canPaint[i + location.getX()][j + location.getY()] && grid[i][j] == pattern){
                    this.canvas[i + location.getX()][j + location.getY()] = grid[i][j];
                    this.canPaint[i + location.getX()][j + location.getY()] = false;
                }
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... param){
        if(param.length == 1){
            int radius = param[0];
            Location location = new Location(x, y);
            Circle circle = new Circle(location, pattern, radius);
            if(checkShape(circle, circle.getGrids())){
                paint(circle.getGrids(), location, pattern);
                shapes.add(circle);
                countShape++;
                countArea += circle.area();
                return true;
            }
            return false;
        }
        else if(param.length == 3){
            int width = param[0];
            int height = param[1];
            int direction_Num = param[2];
            Location location = new Location(x, y);
            Direction d;
            switch (direction_Num){
                case 0:
                    d = Direction.LEFT_UP;
                    break;
                case 1:
                    d = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d = Direction.RIGHT_UP;
                    break;
                case 3:
                    d = Direction.RIGHT_DOWN;
                    break;
                default:
                    d = null;
            }
//            System.out.println(d);
            RightTriangle triangle = new RightTriangle(location, pattern, width, height, d);
            if(checkShape(triangle, triangle.getGrids())){
                paint(triangle.getGrids(), location, pattern);
                shapes.add(triangle);
                countShape++;
                countArea += triangle.area();
                return true;
            }
            return false;
        }
        return false;
    }
    @Override
    public int getShapeCount(){
        return countShape;
    }
    @Override
    public char[][] getCanvas(){
        return this.canvas;
    }
    @Override
    public int getSpaceGridCount(){
        return countArea;
    }
    @Override
    public ArrayList<Shape> getShapesByArea(){
        int tot = this.shapes.size();
        boolean[] no = new boolean[tot+1];
        for(int i = 1; i <= tot; i++){
            int minArea = 9999;
            int position = 0;
            for(int j = 0; j < this.shapes.size(); j++){
                if(this.shapes.get(j).area() < minArea && no[j] == false){
                    position = j;
                    minArea = this.shapes.get(j).area();
                }
                else if(this.shapes.get(j).area() == minArea && no[j] == false){
                    if(this.shapes.get(j).pattern < this.shapes.get(position).pattern){
                        position = j;
                    }
                }
            }
            this.shapeByArea.add(this.shapes.get(position));
            no[position] = true;
        }
        return shapeByArea;
    }
    @Override
    public ArrayList<Shape> getShapesByLocation(){
        int tot = shapes.size();
        boolean[] no = new boolean[tot+1];
        for(int i = 1; i <= tot; i++){
            int minX = 999;
            int minY = 999;
            int position = 0;
            for(int j = 0; j < tot; j++){
                if(shapes.get(j).location.getX() < minX && no[j] == false){
                    minX = shapes.get(j).location.getX();
                    minY = shapes.get(j).location.getY();
                    position = j;
                }
                else if(shapes.get(j).location.getX() == minX && no[j] == false){
                    if(shapes.get(j).location.getY() < minY){
                        minY = shapes.get(j).location.getY();
                        position = j;
                    }
                }
            }
            shapeByLocation.add(this.shapes.get(position));
            no[position] = true;
        }
        return shapeByLocation;
    }
}

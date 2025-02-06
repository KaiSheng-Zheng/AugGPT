import java.util.*;

import java.util.stream.Collectors;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    public void setCanvas(char[][] canvas) {
        this.canvas = canvas;
    }

    public AvoidConflictShapeCanvas(int rows, int cols){
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for (char[] row : canvas) {
            Arrays.fill(row, ' ');
        }
    }
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1){
            Location location = new Location(x, y);
            Circle circle = new Circle(location,pattern,params[0]);
            char[][] shapeGrids = circle.getGrids();
            int left =  (y);
            int right =  (y + 2*params[0]);
            int bottom =  (x + 2*params[0]);
            int top = (x);
            if (bottom >  canvas.length || top <0) {
                return false;
            }
            if (right > canvas[1].length || left < 0){
                return false;
            }
            for (int i = 0; i<shapeGrids.length;i++){
                for (int j = 0; j < shapeGrids[i].length ;j++){
                    if (shapeGrids[i][j] == pattern && canvas[i+x][j+y] != ' '){
                        return false;
                    }
                }
            }
            for (int i = 0; i<shapeGrids.length;i++){
                for (int j = 0; j < shapeGrids[i].length ;j++) {
                    if (shapeGrids[i][j] == pattern) {
                        canvas[i+x][j+y] = pattern;
                    }
                }
            }
            shapes.add(circle);
        }else {
            Direction direction = Direction.values()[params[2]];
            Location location = new Location(x, y);
            RightTriangle Righttriangle =  new RightTriangle(location,pattern,params[0],params[1],direction);
            char[][] shapeGrids = Righttriangle.getGrids();
            int left =  (y);
            int right =  (y + params[0]);
            int bottom =  (x + params[1]);
            int top = (x);
            if (bottom >  canvas.length || top <0) {
                return false;
            }
            if (right > canvas[1].length || left < 0){
                return false;
            }
            for (int i = 0; i<shapeGrids.length;i++){
                for (int j = 0; j < shapeGrids[i].length ;j++){
                    if (shapeGrids[i][j] == pattern && canvas[i+x][j+y] != ' '){
                        return false;
                    }
                }
            }
            for (int i = 0; i<shapeGrids.length;i++){
                for (int j = 0; j < shapeGrids[i].length ;j++) {
                    if (shapeGrids[i][j] == pattern) {
                        canvas[i+x][j+y] = pattern;
                    }
                }
            }
            shapes.add(Righttriangle);
        }
        return true;
    }
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }
    public int getShapeCount() {
       return shapes.size();
    }
    public List<Shape> getShapesByArea() {
        List<Shape> getShapesByArea = shapes.stream().sorted(Comparator
                .comparing(Shape::area, Comparator.nullsFirst(Integer::compareTo))
                .thenComparing(Shape::getPattern, Comparator.nullsFirst(Character::compareTo))
        ).collect(Collectors.toList());
        return getShapesByArea;
    }
    public List<Shape> getShapesByLocation() {
        List<Shape> getShapesByLocation = shapes;
        shapes.sort((s1, s2) -> {
            int compareX = Integer.compare(s1.getLocation().getX(), s2.getLocation().getX());
            if (compareX != 0) {
                return compareX;
            }
            int compareY = Integer.compare(s1.getLocation().getY(), s2.getLocation().getY());
            if (compareY != 0) {
                return compareY;
            }
            return Character.compare(s1.getPattern(), s2.getPattern());
        });
        return getShapesByLocation;
    }
    public char[][] getCanvas() {
        return canvas;
    }

}

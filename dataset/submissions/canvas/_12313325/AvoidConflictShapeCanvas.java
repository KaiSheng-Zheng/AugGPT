import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j]=' ';
            }
        }
        shapes = new ArrayList<>();
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        int length = params.length;
        Location location = new Location(x, y);
        if (length == 1){
            int radius = params[0];
            if (x+2*radius > this.canvas.length || y+2*radius > this.canvas[0].length) return false;
            Circle circle = new Circle(location,pattern,radius);
            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids[0].length; j++) {
                    if (circle.grids[i][j]!=' ' && canvas[i+x][j+y]!=' ') return false;
                }
            }
            shapes.add(circle);
            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids[0].length; j++) {
                    if (circle.grids[i][j]!=' ' && canvas[i+x][j+y]!=' ') return false;
                    else if(circle.grids[i][j]!=' ') canvas[i+x][j+y] = circle.grids[i][j];
                }
            }
            return true;
        } 
        else if (length == 3) {
            Direction d=Direction.LEFT_UP;
            int width = params[0];
            int height = params[1];
            switch (params[2]){
                case 0 -> d = Direction.LEFT_UP;
                case 1 -> d = Direction.LEFT_DOWN;
                case 2 -> d = Direction.RIGHT_UP;
                case 3 -> d = Direction.RIGHT_DOWN;
            }
            if (x+height > this.canvas.length || y+width > this.canvas[0].length) return false;
            RightTriangle rightTriangle = new RightTriangle(location,pattern,width,height,d);
            for (int i = 0; i < rightTriangle.grids.length; i++) {
                for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                    if (rightTriangle.grids[i][j]!=' ' && canvas[i+x][j+y]!=' ') return false;
                }
            }
            shapes.add(rightTriangle);
            for (int i = 0; i < rightTriangle.grids.length; i++) {
                for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                    if (rightTriangle.grids[i][j]!=' ' && canvas[i+x][j+y]!=' ') return false;
                    else if(rightTriangle.grids[i][j]!=' ') canvas[i+x][j+y] = rightTriangle.grids[i][j];
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int space=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j] == ' ') space++;
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
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size()-1; j++) {
                if (shapes.get(j).area() > shapes.get(j+1).area()){
                    Collections.swap(shapes,j,j+1);
                } else if (shapes.get(j).area() == shapes.get(j+1).area() && shapes.get(j).getPattern()> shapes.get(j+1).getPattern()) {
                    Collections.swap(shapes,j,j+1);
                }
            }
            }
        return shapes;
    }
    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = 0; j < shapes.size()-1; j++) {
                if (shapes.get(j).getLocation().getX() > shapes.get(j+1).getLocation().getX()) {
                    Collections.swap(shapes,j,j+1);
                } else if (shapes.get(j).getLocation().getX() == shapes.get(j+1).getLocation().getX() && shapes.get(j).getLocation().getY() > shapes.get(j+1).getLocation().getY()) {
                    Collections.swap(shapes,j,j+1);
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

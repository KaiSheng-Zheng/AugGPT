import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j]=' ';
            }
        }
        shapes= new ArrayList<>();
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        int length = params.length;
        Location location = new Location(x, y);
        boolean bool=false;
        if (length == 1){
            int radius = params[0];
            Circle circle = new Circle(location,pattern,radius);
            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids[0].length; j++) {
                    if (circle.grids[i][j]!=' ' && i+x<this.canvas.length && j+y<this.canvas[0].length){
                        canvas[i+x][j+y]=circle.grids[i][j];
                        bool = true;
                    }
                }
            }
            if(bool) shapes.add(circle);
        }
        else if (length == 3) {
            Direction d = Direction.LEFT_UP;
            int width = params[0];
            int height = params[1];
            switch (params[2]) {
                case 0 -> d = Direction.LEFT_UP;
                case 1 -> d = Direction.LEFT_DOWN;
                case 2 -> d = Direction.RIGHT_UP;
                case 3 -> d = Direction.RIGHT_DOWN;
            }
            RightTriangle rightTriangle = new RightTriangle(location, pattern, width, height, d);
            for (int i = 0; i < rightTriangle.grids.length; i++) {
                for (int j = 0; j < rightTriangle.grids[0].length; j++) {
                    if (rightTriangle.grids[i][j] != ' ' && i + x < this.canvas.length && j + y < this.canvas[0].length) {
                        canvas[i+x][j+y] = rightTriangle.grids[i][j];
                        bool = true;
                    }
                }
            }
            if (bool) shapes.add(rightTriangle);
        }
        return bool;
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
                } else if (shapes.get(j).getLocation().getX() == shapes.get(j+1).getLocation().getX() && shapes.get(j).getLocation().getY() == shapes.get(j+1).getLocation().getY() && shapes.get(j).getPattern()> shapes.get(j+1).getPattern()) {
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
    public static void main(String[] args) {
        ShapeCanvas canvas1 = new OverLapShapeCanvas(15, 15);
        canvas1.addShape(0, 0, 'A', 6);
        canvas1.addShape(1, 1, 'B', 5);
        canvas1.addShape(2, 2, 'C', 4);
        canvas1.addShape(3, 3, 'D', 3);
        canvas1.addShape(10, 5, 'E', 4, 6, 2);
        canvas1.addShape(14, 14, 'F', 4, 6, 3);
        canvas1.addShape(10, 5, '0', 3, 2, 1);
        canvas1.addShape(10, 5, '1', 1, 1, 2);
        for (char[] line : canvas1.getCanvas()) {
            System.out.println(line);
        }
        System.out.println(canvas1.getShapeCount());
        System.out.println(canvas1.getSpaceGridCount());
        canvas1.getShapesByArea().forEach(System.out::println);
        canvas1.getShapesByLocation().forEach(System.out::println);
    }

}

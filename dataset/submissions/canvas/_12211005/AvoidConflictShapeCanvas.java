import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int ShapeCount;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i <= rows - 1; i++) {
            for (int j = 0; j <= cols - 1; j++) {
                canvas[i][j] = ' ';
            }
        }
        this.shapes = new ArrayList<>();
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length == 1) {
            int radius = params[0];
            Location l1 = new Location(x, y);
            Shape s1 = new Circle(l1, pattern, radius);
            if (x >= canvas.length || y >= canvas[0].length) {
                return false;
            }
            if (x + s1.grids.length - 1 >= canvas.length || y + s1.grids[0].length - 1 >= canvas[0].length) {
                return false;
            }
            for (int i = 0; i < s1.grids.length; i++) {
                for (int j = 0; j < s1.grids[0].length; j++) {
                    if (canvas[x + i][y + j] != ' ') {
                        return false;
                    }
                }
            }
        } else if (params.length == 3) {
            int width = params[0];
            int height = params[1];
            int indexOfDirection = params[2];
            Direction[] directions = Direction.values();
            Direction direction = directions[indexOfDirection];
            Location l2 = new Location(x, y);
            Shape s2 = new RightTriangle(l2, pattern, width, height, direction);
            if (x >= canvas.length || y >= canvas[0].length) {
                return false;
            }
            if (x + s2.grids.length - 1 >= canvas.length || y + s2.grids[0].length - 1 >= canvas[0].length) {
                return false;
            }
            for (int i = 0; i <= s2.grids.length - 1; i++) {
                for (int j = 0; j <= s2.grids[0].length - 1; j++) {
                    if (canvas[x + i][y + j] != ' ' && s2.grids[i][j] != ' ') {
                        return false;
                    }
                }
            }
        }
        if (params.length == 1) {
            int radius = params[0];
            Location l1 = new Location(x, y);
            Shape s1 = new Circle(l1, pattern, radius);
            shapes.add(s1);
            for (int i = 0; i <= radius * 2 - 1; i++) {
                for (int j = 0; j <= radius * 2 - 1; j++) {
                    canvas[x + i][y + j] = s1.grids[i][j];
                }
            }
            ShapeCount++;
        } else if (params.length == 3) {
            int width = params[0];
            int height = params[1];
            int indexOfDirection = params[2];
            Direction[] directions = Direction.values();
            Direction direction = directions[indexOfDirection];
            Location l2 = new Location(x, y);
            Shape s2 = new RightTriangle(l2, pattern, width, height, direction);
            shapes.add(s2);
            for (int i = 0; i <= height - 1; i++) {
                for (int j = 0; j <= width - 1; j++) {
                    if (canvas[x + i][y + j] == 'o') {
                        canvas[x + i][y + j] = s2.grids[i][j];
                    } else if (canvas[x + i][y + j] == ' ') {
                        canvas[x + i][y + j] = s2.grids[i][j];
                    }
                }
            }
            ShapeCount++;
        }
        return true;
    }

    public int getSpaceGridCount() {
        return 1;
    }

    public int getShapeCount() {
        return ShapeCount;
    }

    public List<Shape> getShapesByArea() {
        List<Shape> tempArea = new ArrayList<>();
        List<Shape> tempAreaCircle = new ArrayList<>();
        List<Shape> tempAreaRightTriangle = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                tempAreaCircle.add(shape);
            }
        }
        for (Shape shape : shapes) {
            if (shape instanceof RightTriangle) {
                tempAreaRightTriangle.add(shape);
            }
        }
        tempArea.addAll(tempAreaRightTriangle);
        tempArea.addAll(tempAreaCircle);
        for (int i = 0; i <= tempArea.size()-2;i++ ) {
            for(int j= i+1;j<=tempArea.size()-1;j++){
                Shape temp;
                if(tempArea.get(i).area()>=tempArea.get(j).area()){
                        temp = tempArea.get(i);
                        tempArea.set(i,tempArea.get(j));
                        tempArea.set(j,temp);
                }
            }
        }
        for (int i = 0; i <= tempArea.size() - 2; i++) {
            for (int j = i + 1; j <= tempArea.size() - 1; j++) {
                Shape temp1 = tempArea.get(i);
                Shape temp2 = tempArea.get(j);
                if (temp1.area() == temp2.area()) {
                    if (temp1.getPattern() > temp2.getPattern()) {
                        tempArea.set(i, temp2);
                        tempArea.set(j, temp1);
                    }
                }
            }
        }

        return tempArea;
    }

    public List<Shape> getShapesByLocation() {
        List<Shape> tempLocation = new ArrayList<>();
        List<Shape> tempLocationCircle = new ArrayList<>();
        List<Shape> tempLocationRightTriangle = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                tempLocationCircle.add(shape);
            }
        }
        for (Shape shape : shapes) {
            if (shape instanceof RightTriangle) {
                tempLocationRightTriangle.add(shape);
            }
        }
        tempLocation.addAll(tempLocationRightTriangle);
        tempLocation.addAll(tempLocationCircle);
        for (int i = 0; i <= tempLocation.size()-2;i++ ) {
            for(int j= i+1;j<=tempLocation.size()-1;j++){
                Shape temp;
                if(tempLocation.get(i).getLocation().getX()>=tempLocation.get(j).getLocation().getX()){
                    temp = tempLocation.get(i);
                    tempLocation.set(i,tempLocation.get(j));
                    tempLocation.set(j,temp);
                }
            }
        }
        for (int i = 0; i <= tempLocation.size()-2;i++ ) {
            for(int j= i+1;j<=tempLocation.size()-1;j++){
                Shape temp;
                if(tempLocation.get(i).getLocation().getX()==tempLocation.get(j).getLocation().getX()){
                    if(tempLocation.get(i).getLocation().getY()>tempLocation.get(j).getLocation().getY()){
                        temp = tempLocation.get(i);
                        tempLocation.set(i,tempLocation.get(j));
                        tempLocation.set(j,temp);
                    }
                }
            }
        }
        for (int i = 0; i <= tempLocation.size()-2;i++ ) {
            for(int j= i+1;j<=tempLocation.size()-1;j++){
                Shape temp;
                if(tempLocation.get(i).getLocation().getX()==tempLocation.get(j).getLocation().getX()&&tempLocation.get(i).getLocation().getY()==tempLocation.get(j).getLocation().getY()){
                    if(tempLocation.get(i).getPattern()>tempLocation.get(j).getPattern()){
                        temp = tempLocation.get(i);
                        tempLocation.set(i,tempLocation.get(j));
                        tempLocation.set(j,temp);
                    }
                }
            }
        }
        return tempLocation;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

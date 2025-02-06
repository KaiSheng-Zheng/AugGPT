import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            Arrays.fill(canvas[i], ' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int radius) {
        Circle circle=new Circle(new Location(x,y),pattern,radius);
        circle.fillGrids();
        if (circle.getGrids().length>canvas.length-x||circle.getGrids()[0].length>canvas[0].length-y) {
            return false;
        }
        for (int i = 0; i < circle.getGrids().length; i++) {
            for (int j = 0; j < circle.getGrids()[i].length; j++) {
                if (!Objects.equals(canvas[x+i][y+j],' ')&&!Objects.equals(circle.getGrids()[i][j],' ')) {
                    return false;
                }
            }
        }
        for (int i = 0; i < circle.getGrids().length; i++) {
            for (int j = 0; j < circle.getGrids()[i].length; j++) {
                if (!Objects.equals(circle.getGrids()[i][j],' ')) {
                    canvas[x + i][y + j] = circle.getGrids()[i][j];
                }
            }
        }
        shapes.add(circle);
        return true;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int width, int height, int d) {
        Direction direction;
            switch (d){
                case 0 -> direction=Direction.LEFT_UP;
                case 1 -> direction=Direction.LEFT_DOWN;
                case 2 -> direction=Direction.RIGHT_UP;
                case 3 -> direction=Direction.RIGHT_DOWN;
                default -> direction=null;
            }
        RightTriangle rightTriangle=new RightTriangle(new Location(x,y),pattern,width,height,direction);
        rightTriangle.fillGrids();
        if (rightTriangle.getGrids().length>canvas.length-x||rightTriangle.getGrids()[0].length>canvas[0].length-y) {
            return false;
        }
        for (int i = 0; i < rightTriangle.getGrids().length; i++) {
            for (int j = 0; j < rightTriangle.getGrids()[i].length; j++) {
                if (!Objects.equals(canvas[x+i][y+j],' ')&&!Objects.equals(rightTriangle.getGrids()[i][j],' ')) {
                    return false;
                }
            }
        }
        for (int i = 0; i < rightTriangle.getGrids().length; i++) {
            for (int j = 0; j < rightTriangle.getGrids()[i].length; j++) {
                if (!Objects.equals(rightTriangle.getGrids()[i][j],' ')) {
                    canvas[x + i][y + j] = rightTriangle.getGrids()[i][j];
                }
            }
        }
        shapes.add(rightTriangle);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (Objects.equals(canvas[i][j],' ')){
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
    public List<Shape> getShapesByArea() {
        shapes.sort((o1, o2) -> {
            if (o1.area()==o2.area()){
                return o1.pattern-o2.pattern;
            }
            return o1.area()- o2.area();
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort((o1, o2) -> {
            if ((o1.location.getX()==o2.location.getX())&&(o1.location.getY()==o2.location.getY())){
                return o1.pattern-o2.pattern;
            }
            if (o1.location.getX()==o2.location.getX()){
                return o1.location.getY()-o2.location.getY();
            }
            return o1.location.getX()-o2.location.getX();
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

import java.util.List;

public interface ShapeCanvas {
    public boolean addShape(int x, int y, char pattern, int... params);

    public int getSpaceGridCount();

    public int getShapeCount();

    public List<Shape> getShapesByArea();

    public List<Shape> getShapesByLocation();

    public char[][] getCanvas();
    default Direction findDirection(int index){
        Direction d =null;
        switch (index){
            case 0 ->{d= Direction.LEFT_UP;}
            case 1 ->{d= Direction.LEFT_DOWN;}
            case 2 ->{d= Direction.RIGHT_UP;}
            case 3 ->{d= Direction.RIGHT_DOWN;}
        }
        return d;
    }


}
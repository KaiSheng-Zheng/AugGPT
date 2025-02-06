import java.util.ArrayList;
import java.util.List;
    public interface ShapeCanvas {
        public boolean addShape(int x,int y,char pattern,int... param);
        public int getSpaceGridCount();
        public ArrayList<Shape> getShapesByArea();
        public ArrayList<Shape> getShapesByLocation();
        public char[][] getCanvas();
        public int getShapeCount();
    }

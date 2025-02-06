import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private int count = 0;
    private List<Shape> shapes  = new ArrayList<>();
    private char[][] canvas;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public char[][] getCanvas() {
        if(getCount() == 0){
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    canvas[i][j] = '\u0020';
                }
            }
        }
        setCount(1);
        return canvas;
    }

    public void setCanvas(char[][] canvas) {
        this.canvas = canvas;
    }

    public AvoidConflictShapeCanvas(int rows, int cols){
        setCanvas(new char[rows][cols]);
        getCanvas();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location = new Location(x,y);
        char[][] canvas2 = new char[canvas.length][canvas[0].length];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas2[i][j] = canvas[i][j];
            }
        }

        boolean isFill = true;
        if(params.length == 1){
            Circle circle = new Circle(location,pattern,params[0]);
            for (int i = 0; i < 2*circle.getRadius(); i++) {
                for (int j = 0; j < 2*circle.getRadius(); j++) {
                    if(!String.valueOf(circle.getGrids()[i][j]).equals(" ")){
                        if((x+i)<(canvas.length)
                                && (y+j)<(canvas[0].length)
                                && String.valueOf(canvas[x+i][y+j]).equals(" ")){
                            canvas[x+i][y+j] = circle.getGrids()[i][j];
                        }
                        else{
                            isFill = false;
                        }
                    }
                }
            }
            if(isFill){
                shapes.add(circle);
            }
            else {
                setCanvas(canvas2);
            }
            return isFill;
        }
        else{
            Direction d;
            switch (params[2]){
                case 0:
                    d = Direction.LEFT_UP;
                    break;
                case 1:
                    d = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d = Direction.RIGHT_UP;
                    break;
                default:
                    d = Direction.RIGHT_DOWN;
            }
            RightTriangle rightTriangle = new RightTriangle(location,pattern,params[0],params[1],d);
            for (int i = 0; i < rightTriangle.getHeight(); i++) {
                for (int j = 0; j < rightTriangle.getWidth(); j++) {
                    if(!String.valueOf(rightTriangle.getGrids()[i][j]).equals(" ")){
                        if((x+i)<(canvas.length)
                                && (y+j)<(canvas[0].length)
                                && String.valueOf(canvas[x+i][y+j]).equals(" ")){
                            canvas[x+i][y+j] = rightTriangle.getGrids()[i][j];
                        }
                        else {
                            isFill = false;
                        }
                    }
                }
            }
            if(isFill){
                getShapes().add(rightTriangle);
            }
            else {
                setCanvas(canvas2);
            }
            return isFill;
        }
    }


    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if(String.valueOf(canvas[i][j]).equals(" ")){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return getShapes().size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(getShapes(),new areaComparator());
        return getShapes();
    } 

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(getShapes(),new locationComparator());
        return getShapes();
    }

}

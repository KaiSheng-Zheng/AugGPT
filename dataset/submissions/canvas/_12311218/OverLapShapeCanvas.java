import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        shapes=new ArrayList<>();
        canvas=new char[rows][cols];
        for (char[] canva : canvas) {
            Arrays.fill(canva,' ');
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        int counter=0;
        if (params.length==1){
            Circle circle=new Circle(new Location(x,y),pattern,params[0]);
            for (int i = 0; i < circle.grids.length; i++) {
                for (int j = 0; j < circle.grids.length; j++) {
                    try {
                        if (circle.grids[i][j] != ' ') {
                            canvas[x + i][y + j] = circle.grids[i][j];
                            counter++;
                        }
                    }catch (ArrayIndexOutOfBoundsException e){}//do nothing
                }
            }
            if (counter>0){shapes.add(circle);}
            return (counter!=0);
        }

        RightTriangle rightTriangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],findDirection(params[2]));
        for (int i = 0; i <rightTriangle.getHeight() ; i++) {
            for (int j = 0; j <rightTriangle.getWidth() ; j++) {
                try {
                    if (rightTriangle.grids[i][j] != ' ') {
                        canvas[x + i][y + j] = rightTriangle.grids[i][j];
                        counter++;
                    }
                }catch (ArrayIndexOutOfBoundsException e){}//do nothing
            }
        }
        if (counter>0){shapes.add(rightTriangle);}
        return (counter!=0);
    }

    @Override
    public int getSpaceGridCount() {
        int counter=0;
        for (char[] canva :canvas){
            for (int i = 0; i < canva.length; i++) {
                if (canva[i]==' '){
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new AreaComparator());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new LocationComparator());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

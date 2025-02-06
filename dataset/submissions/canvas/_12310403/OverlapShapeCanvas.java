import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int row, int col){
        this.canvas = new char[row][col];
        this.shapes = new ArrayList<>();
        initCanvas();
    }
    public void initCanvas(){
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        int count = 0;
        switch(params.length){
            case 1:
                Location location = new Location(x,y);
                Circle circle = new Circle(location,pattern,params[0]);
                for (int i = 0; i < circle.getGrids().length; i++) {
                    for (int j = 0; j < circle.getGrids().length; j++) {
                        boolean equal = (circle.getGrids()[i][j]==pattern);
                        boolean inCanvas = (i+x>=0&&i+x< canvas.length&&j+y>=0&&j+y<canvas[i].length);
                        boolean flag = equal&inCanvas;
                        if (flag){
                            canvas[i+x][j+y]=pattern;
                            count++;
                        }
                    }
                    if (count==0) return false;
                    shapes.add(circle);
                }
                break;


            case 3:
                Location location1 = new Location(x,y);
                Direction direction =Direction.values()[params[2]];
                RightTriangle rightTriangle = new RightTriangle(location1,pattern,params[0],params[1],direction);
                for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                    for (int j = 0; j < rightTriangle.getGrids()[0].length; j++) {
                        boolean equal = (rightTriangle.getGrids()[i][j]==pattern);
                        boolean inCanvas = (i+x>=0&&i+x< canvas.length&&j+y>=0&&j+y<canvas[i].length);
                        boolean flag = equal&inCanvas;
                        if (flag){
                            canvas[i+x][j+y]=pattern;
                            count++;
                        }
                    }
                    if (count==0) return false;
                    shapes.add(rightTriangle);
                }
                break;
        }
        return true;
    }
    @Override
    public int getSpaceGridCount() {
        int count =0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if(canvas[i][j]==' '){
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
        List<Shape> sortedShapes = new ArrayList<>(shapes);
        sortedShapes.sort((s1, s2) -> {
            int areaComparison = Integer.compare(s1.area(), s2.area());
            if (areaComparison != 0) {
                return areaComparison;
            } else {
                return Character.compare(s1.pattern, s2.pattern);
            }
        });
        return sortedShapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes,new ShapeLocationComparator());
        return shapes;
    }

    class ShapeLocationComparator implements java.util.Comparator<Shape> {
        @Override
        public int compare(Shape a,Shape b) {
            if (a.location.getX() - b.location.getX()!=0){
                return a.location.getX() - b.location.getX();
            }
            if (a.location.getY()-b.location.getY()!=0){
                return a.location.getY()-b.location.getY();
            }
            return (int)a.pattern-(int)b.pattern;
        }
    }
    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

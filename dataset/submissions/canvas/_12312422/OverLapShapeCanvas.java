import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows,int cols){
        this.shapes=new ArrayList<>();
        this.canvas=new char[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean judge=true;
        if (params.length==1){
            Circle circle=new Circle(new Location(x,y),pattern,params[0]);
            for (int i=0;i<2*params[0];i++){
                for (int j=0;j<2*params[0];j++){
                    if (x+i>=0 && x+i<canvas.length && y+j>=0 && y+j<canvas[0].length && circle.getGrids()[i][j]!=' '){
                        canvas[x+i][y+j]=circle.getGrids()[i][j];
                        judge=false;
                    }
                }
            }
            if (judge) {
                return false;
            }
            shapes.add(circle);
            return true;
        }
        if (params.length==3) {
            Direction direction = switch (params[2]) {
                case 0 -> Direction.LEFT_UP;
                case 1 -> Direction.LEFT_DOWN;
                case 2 -> Direction.RIGHT_UP;
                default -> Direction.RIGHT_DOWN;
            };
            RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, params[0], params[1], direction);
            for (int i = 0; i < params[1]; i++) {
                for (int j = 0; j < params[0]; j++) {
                    if (x + i >= 0 && x + i < canvas.length && y + j >= 0 && y + j < canvas[0].length && rightTriangle.getGrids()[i][j]!= ' ') {
                        canvas[x + i][y + j] = rightTriangle.getGrids()[i][j];
                        judge = false;
                    }
                }
            }
            if (judge) {
                return false;
            }
            shapes.add(rightTriangle);
            return true;
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for (int i=0;i<canvas.length;i++){
            for (int j=0;j<canvas[i].length;j++){
                if (canvas[i][j]==' '){
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
        shapes.sort(Comparator.comparing(Shape::area).thenComparing(Shape::getPattern));
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(Comparator.comparingInt(Shape ::getLocationX)
                .thenComparingInt(Shape ::getLocationY)
                .thenComparing(Shape::getPattern));
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

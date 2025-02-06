import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;

    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
        this.rows=rows;
        this.cols=cols;
    }

    @Override
    public boolean addShape(int x,int y,char pattern,int... params) {
        if (params.length == 1){
            Circle circle = new Circle(new Location(x,y),pattern,params[0]);
            int radius = params[0];
            char[][] circleGrids = circle.getGrids();
            boolean ifOk = false ;
            for (int i=0;i<radius*2;i++){
                for (int j=0;j<radius*2;j++){
                    if (circleGrids[i][j] != ' ' && x+i>=0 && x+i<rows && y+j>=0 && y+j<cols){
                        ifOk = true ;
                    }
                }
            }
            if (ifOk){
                for (int i=0;i<radius*2;i++){
                    for (int j=0;j<radius*2;j++){
                        if (circleGrids[i][j] != ' ' && x+i>=0 && x+i<rows && y+j>=0 && y+j<cols){
                            canvas[x+i][y+j] = circleGrids[i][j];
                        }
                    }
                }
                shapes.add(circle);
            }
            return ifOk;
        } else {
            RightTriangle rightTriangle = null;
            switch (params[2]){
                case 0:
                    rightTriangle = new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.LEFT_UP);
                    break;
                case 1:
                    rightTriangle = new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.LEFT_DOWN);
                    break;
                case 2:
                    rightTriangle = new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.RIGHT_UP);
                    break;
                case 3:
                    rightTriangle = new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.RIGHT_DOWN);
                    break;
                default:
                    System.out.println("Wrong direction");
            }
            char[][] rightTriangleGrids = rightTriangle.getGrids();
            boolean ifOk = false ;
            for (int i=0;i<params[1];i++){
                for (int j=0;j<params[0];j++){
                    if (rightTriangleGrids[i][j] != ' ' && x+i>=0 && x+i<rows && y+j>=0 && y+j<cols){
                        ifOk = true ;
                    }
                }
            }
            if (ifOk){
                for (int i=0;i<params[1];i++){
                    for (int j=0;j<params[0];j++){
                        if (rightTriangleGrids[i][j] != ' ' && x+i>=0 && x+i<rows && y+j>=0 && y+j<cols){
                            canvas[x+i][y+j] = rightTriangleGrids[i][j];
                        }
                    }
                }
                shapes.add(rightTriangle);
            }
            return ifOk;
        }
    }

    @Override
    public int getSpaceGridCount(){
        int count = 0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++) {
                if (canvas[i][j] == ' '){
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int getShapeCount(){
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea(){
        shapes.sort((p1, p2) -> { int areaComparison = Integer.compare(p1.area(), p2.area());
            if (areaComparison != 0) {
                return areaComparison;
            } else {
                return Character.compare(p1.getPattern(), p2.getPattern());
            }});
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation(){
        shapes.sort((p1, p2) -> { int locationXComparison = Integer.compare(p1.getLocation().getX(), p2.getLocation().getX());
            if (locationXComparison != 0) {
                return locationXComparison;
            } else {
                int locationYComparison = Integer.compare(p1.getLocation().getY(), p2.getLocation().getY());
                if (locationYComparison != 0) {
                    return locationYComparison;
                } else {
                    return Character.compare(p1.getPattern(), p2.getPattern());
                }
            }
        });
        return shapes;
    }

    @Override
    public char[][] getCanvas(){
        return canvas;
    }
}

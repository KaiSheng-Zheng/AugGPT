import java.util.*;
public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<>();
    private char[][] canvas;
    public OverLapShapeCanvas(int rows,int cols){
        this.canvas = new char[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                canvas[i][j] = ' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        if (params.length==3){
            if (params[2]==0){
                Location p1 = new Location(x, y);
                Shape s1 = new RightTriangle(p1, pattern, params[0], params[1], Direction.LEFT_UP);
                char[][] grids = s1.getGrids();
                boolean m =false;
                for (int i =0;i<grids.length;i++){
                    for (int j=0;j<grids[0].length;j++){
                        if (x+i>=0&&x+i<canvas.length&&y+j>=0&&y+j<canvas[0].length){
                            if (grids[i][j]!=' '){
                                m = true;
                                canvas[x+i][y+j]=grids[i][j];
                            }
                        }
                    }
                }
                if (!m){
                    return false;
                }
                shapes.add(s1);
                return true;
            }
            if (params[2]==1){
                Location p1 = new Location(x, y);
                Shape s1 = new RightTriangle(p1, pattern, params[0], params[1], Direction.LEFT_DOWN);
                char[][] grids = s1.getGrids();
                boolean m =false;
                for (int i =0;i<grids.length;i++){
                    for (int j=0;j<grids[0].length;j++){
                        if (x+i>=0&&x+i<canvas.length&&y+j>=0&&y+j<canvas[0].length){
                            if (grids[i][j]!=' '){
                                m = true;
                                canvas[x+i][y+j]=grids[i][j];
                            }
                        }
                    }
                }
                if (!m){
                    return false;
                }
                shapes.add(s1);
                return true;
            }
            if (params[2]==2){
                Location p1 = new Location(x, y);
                Shape s1 = new RightTriangle(p1, pattern, params[0], params[1], Direction.RIGHT_UP);
                char[][] grids = s1.getGrids();
                boolean m =false;
                for (int i =0;i<grids.length;i++){
                    for (int j=0;j<grids[0].length;j++){
                        if (x+i>=0&&x+i<canvas.length&&y+j>=0&&y+j<canvas[0].length){
                            if (grids[i][j]!=' '){
                                m = true;
                                canvas[x+i][y+j]=grids[i][j];
                            }
                        }
                    }
                }
                if (!m){
                    return false;
                }
                shapes.add(s1);
                return true;
            }
            if (params[2]==3){
                Location p1 = new Location(x, y);
                Shape s1 = new RightTriangle(p1, pattern, params[0], params[1], Direction.RIGHT_DOWN);
                char[][] grids = s1.getGrids();
                boolean m =false;
                for (int i =0;i<grids.length;i++){
                    for (int j=0;j<grids[0].length;j++){
                        if (x+i>=0&&x+i<canvas.length&&y+j>=0&&y+j<canvas[0].length){
                            if (grids[i][j]!=' '){
                                m = true;
                                canvas[x+i][y+j]=grids[i][j];
                            }
                        }
                    }
                }
                if (!m){
                    return false;
                }
                shapes.add(s1);
                return true;
            }
        }
        if (params.length==1){
            Location p1 = new Location(x, y);
            Shape s1 = new Circle(p1,pattern,params[0]);
            char[][] grids = s1.getGrids();
            boolean m =false;
            for (int i =0;i<grids.length;i++){
                for (int j=0;j<grids[0].length;j++){
                    if (x+i>=0&&x+i<canvas.length&&y+j>=0&&y+j<canvas[0].length){
                        if (grids[i][j]!=' '){
                            m = true;
                            canvas[x+i][y+j]=grids[i][j];
                        }
                    }
                }
            }
            if (!m){
                return false;
            }
            shapes.add(s1);
            return true;
        }
        return false;
    }
    @Override
    public int getSpaceGridCount(){
        int a=0;
        for (int i=0;i<canvas.length;i++){
            for (int j=0;j<canvas[0].length;j++){
                if (canvas[i][j]==' '){
                    a++;
                }
            }
        }
        return a;
    }
    @Override
    public int getShapeCount(){
        return shapes.size();
    }
    @Override
    public List<Shape> getShapesByArea(){
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1,Shape o2) {
                if (o1.area()>o2.area()){
                    return 1;
                }else if (o1.area()<o2.area()){
                    return -1;
                }else {
                    if (o1.pattern>o2.pattern){
                        return 1;
                    }else {
                        return -1;
                    }
                }
            }
        });
        return shapes;
    }
    @Override
    public List<Shape> getShapesByLocation(){
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1,Shape o2) {
                if (o1.location.getX()>o2.location.getX()){
                    return 1;
                }else if (o1.location.getX()<o2.location.getX()){
                    return -1;
                }else {
                    if (o1.location.getY()>o2.location.getY()){
                        return 1;
                    }else if (o1.location.getY()<o2.location.getY()){
                        return -1;
                    }else {
                        if (o1.pattern>o2.pattern){
                            return 1;
                        }else {
                            return -1;
                        }
                    }
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

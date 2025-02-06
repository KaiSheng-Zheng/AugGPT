import java.util.ArrayList;
import java.util.List;
public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;
    private Shape shape;
    Direction d;

    public AvoidConflictShapeCanvas(int rows,int cols){
        this.rows = rows;
        this.cols = cols;
        shapes = new ArrayList<>();
        canvas = new char[rows][cols];
        for(int i = 0;i<rows;i++){
            for(int j =0 ;j<cols;j++){
                canvas[i][j] = " ".charAt(0);
            }
        }
    }
    @Override
    public boolean addShape(int x,int y,char pattern,int... params){
        boolean flag =false;
        Location location = new Location(x,y);
        if(params.length == 1){
            int radius = params[0];
            shape = new Circle(location,pattern,radius);
            flag = JudgeCircle(x,y,shape,radius);
        }
        if(params.length ==3){

            if(params[2] == 0){d = Direction.LEFT_UP;}
            if(params[2] == 1){d = Direction.LEFT_DOWN;}
            if(params[2] == 2){d = Direction.RIGHT_UP;}
            if(params[2] == 3){d = Direction.RIGHT_DOWN;}
            int width = params[0];
            int height = params[1];
            shape = new RightTriangle(location,pattern,width,height,d);
            flag = JudgeRightTriangle(x,y,shape,width,height);
        }
        if (flag){
            shapes.add(shape);
            return true;
        }
        return false;
    }
    public boolean JudgeCircle(int x,int y,Shape currentShape,int radius){
        if(x < 0 || x+2*radius> rows || y < 0 || y+2*radius>cols){return false;}
        else{
            for(int i =0 ;i<2*radius;i++){
                for(int j =0;j<2*radius;j++){
                    if(canvas[i+x][j+y]!=" ".charAt(0) && currentShape.grids[i][j]!=" ".charAt(0)){return false;}
                }
            }
        }
        for(int i =0 ;i<2*radius;i++){
            for(int j =0;j<2*radius;j++){
                if (currentShape.grids[i][j]!=" ".charAt(0)) {
                    canvas[i+x][j+y]=currentShape.grids[i][j];
                }
            }
        }
        return true;
    }
    public boolean JudgeRightTriangle(int x,int y,Shape currentShape,int width,int height) {
        if(x < 0 || x+height> rows || y < 0 || y+width>cols){return false;}
        else{
            for(int i =0 ;i<height;i++){
                for(int j =0;j<width;j++){
                    if(canvas[i+x][j+y]!=" ".charAt(0) && currentShape.grids[i][j]!=" ".charAt(0)){return false;}
                }
            }
        }
        for(int i =0 ;i<height;i++){
            for(int j =0;j<width;j++){
                if (currentShape.grids[i][j]!=" ".charAt(0)) {
                    canvas[i+x][j+y]=currentShape.grids[i][j];
                }
            }
        }
        return true;
    }
    @Override
    public int getSpaceGridCount() {
        int count = 0;
        for(int i = 0;i<rows;i++){
            for (int j =0 ;j<cols;j++){
                if (canvas[i][j] !=" ".charAt(0)){count++;}
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {return shapes.size();}

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> Shapes_ByArea= new ArrayList<>();
        for(int i =0 ;i<shapes.size();i++){Shapes_ByArea.add(shapes.get(i));}
        for (int i = 0;i<Shapes_ByArea.size()-1;i++){
            for(int j = Shapes_ByArea.size()-1;j>i;j--){
                if (Shapes_ByArea.get(j).area()<Shapes_ByArea.get(j-1).area()){
                    Shape temp_Shape = Shapes_ByArea.get(j-1);
                    Shapes_ByArea.set(j-1,Shapes_ByArea.get(j));
                    Shapes_ByArea.set(j,temp_Shape);
                }
            }
        }
        for (int i = 0;i<Shapes_ByArea.size()-1;i++){
            for(int j = Shapes_ByArea.size()-1;j>i;j--){
                if (Shapes_ByArea.get(j).pattern < Shapes_ByArea.get(j-1).pattern&&Shapes_ByArea.get(j).area()==Shapes_ByArea.get(j-1).area()){
                    Shape temp_Shape = Shapes_ByArea.get(j-1);
                    Shapes_ByArea.set(j-1,Shapes_ByArea.get(j));
                    Shapes_ByArea.set(j,temp_Shape);
                }
            }
        }
        return Shapes_ByArea;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> Shapes_ByLocation= new ArrayList<>();
        for(int i =0 ;i<shapes.size();i++){Shapes_ByLocation.add(shapes.get(i));}
        for (int i = 0;i<Shapes_ByLocation.size()-1;i++){
            for(int j = Shapes_ByLocation.size()-1;j>i;j--){
                if (Shapes_ByLocation.get(j).location.getX()<Shapes_ByLocation.get(j-1).location.getX()){
                    Shape temp_Shape = Shapes_ByLocation.get(j-1);
                    Shapes_ByLocation.set(j-1,Shapes_ByLocation.get(j));
                    Shapes_ByLocation.set(j,temp_Shape);
                }
            }
        }
        for (int i = 0;i<Shapes_ByLocation.size()-1;i++){
            for(int j = Shapes_ByLocation.size()-1;j>i;j--){
                if (Shapes_ByLocation.get(j).location.getY() < Shapes_ByLocation.get(j-1).location.getY() && Shapes_ByLocation.get(j).location.getX()==Shapes_ByLocation.get(j-1).location.getX()){
                    Shape temp_Shape = Shapes_ByLocation.get(j-1);
                    Shapes_ByLocation.set(j-1,Shapes_ByLocation.get(j));
                    Shapes_ByLocation.set(j,temp_Shape);
                }
            }
        }
        for (int i = 0;i<Shapes_ByLocation.size()-1;i++){
            for(int j = Shapes_ByLocation.size()-1;j>i;j--){
                if (Shapes_ByLocation.get(j).pattern < Shapes_ByLocation.get(j-1).pattern && Shapes_ByLocation.get(j).location.getY() == Shapes_ByLocation.get(j-1).location.getY() && Shapes_ByLocation.get(j).location.getX()==Shapes_ByLocation.get(j-1).location.getX()){
                    Shape temp_Shape = Shapes_ByLocation.get(j-1);
                    Shapes_ByLocation.set(j-1,Shapes_ByLocation.get(j));
                    Shapes_ByLocation.set(j,temp_Shape);
                }
            }
        }
        return Shapes_ByLocation;
    }

    @Override
    public char[][] getCanvas() {return canvas;}

}

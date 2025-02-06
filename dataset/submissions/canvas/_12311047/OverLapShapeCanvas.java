import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;
    private int spaceGridCount;
    private int shapeCount;
    public OverLapShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        this.rows=rows;
        this.cols=cols;
        this.spaceGridCount=0;
        this.shapeCount=0;
        this.shapes = new ArrayList<>();
        for(int i=0;i<this.rows;i++) {
            for (int j = 0; j < this.cols; j++) {
                this.canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        Location l = new Location(x,y);
        int a=0;
        int b=0;
        if(params.length==1){
            Circle c = new Circle(l,pattern,params[0]);
            for(int i=0;i<2*params[0];i++){
                for(int j=0;j<2*params[0];j++){
                    if(c.getGrids()[i][j]==c.getPattern() && x+i<this.rows && y+j<this.cols){
                        a++;
                    }

                }
            }
            if(a!=0){
                b=1;
                for(int i=0;i<2*params[0];i++) {
                    for (int j = 0; j < 2 * params[0]; j++) {
                        if(x+i<this.rows && y+j<this.cols && c.getGrids()[i][j]!=' '){
                            getCanvas()[x + i][y + j] = c.getPattern();
                        }
                    }
                }
                this.shapeCount++;
                this.shapes.add(c);
            }
        }
        if(params.length==3){
            Direction d=Direction.LEFT_UP;
            if(params[2]==0){
                d = Direction.LEFT_UP;
            }
            if(params[2]==1){
                d = Direction.LEFT_DOWN;
            }
            if(params[2]==2){
                d = Direction.RIGHT_UP;
            }
            if(params[2]==3){
                d = Direction.RIGHT_DOWN;
            }
            RightTriangle c = new RightTriangle(l,pattern,params[0],params[1],d);
            for(int i=0;i<params[1];i++){
                for(int j=0;j<params[0];j++){
                    if(c.getGrids()[i][j]==c.getPattern() && x+i<this.rows && y+j<this.cols){
                        a++;
                    }
                }
            }
            if(a!=0){
                b=1;
                for(int i=0;i<params[1];i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if(c.getX()+i<this.rows && c.getY()+j<this.cols && c.getGrids()[i][j]==c.getPattern()){
                            getCanvas()[c.getX()+ i][c.getY() + j] = c.getPattern();
                        }
                    }
                }
                this.shapeCount++;
                this.shapes.add(c);
            }
        }
        if(b==0){
            return false;
        }else{
            return true;
        }
    }
    public int getSpaceGridCount(){
        this.spaceGridCount=0;
        for(int i=0;i<this.rows;i++) {
            for (int j = 0; j < this.cols; j++) {
                if(this.canvas[i][j]==' '){
                    this.spaceGridCount++;
                }
            }
        }
        return this.spaceGridCount;
    }

    public int getShapeCount(){
        return this.shapeCount;
    }
    public List<Shape> getShapesByArea(){
        Comparator<Shape> comparator = Comparator.comparing(Shape::area).thenComparing(Shape::getPattern);
        this.shapes.sort(comparator);
        return this.shapes;
    }
    public List<Shape> getShapesByLocation(){
        Comparator<Shape> comparator = Comparator.comparing(Shape::getX).thenComparing(Shape::getY).thenComparing(Shape::getPattern);
        this.shapes.sort(comparator);
        return this.shapes;
    }
    public char[][] getCanvas(){
        return canvas;
    }
}

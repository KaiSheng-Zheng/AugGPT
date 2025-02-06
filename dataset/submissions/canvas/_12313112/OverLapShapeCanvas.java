import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public boolean addShape(int x, int y, char pattern, int... params){
        if (params.length==1){
            Circle circle=new Circle(new Location(x,y),pattern,params[0]);
            circle.fillGrids();
            boolean noConflict=false;
            for(int i=0;i<circle.grids.length;i++){
                for(int j=0;j<circle.grids.length;j++){
                    if (x+i>=0&&x+i<canvas.length&&y+j<canvas[0].length&&y+j>=0&&circle.grids[i][j]!=' '){
                        noConflict=true;
                        break;
                    }
                }
            }
            if(noConflict){
                for(int i=0;i<circle.grids.length;i++) {
                    for (int j = 0; j < circle.grids.length; j++) {
                        if(x+i>=0&&x+i<canvas.length&&y+j<canvas[0].length&&y+j>=0&&circle.grids[i][j]!=' ') {
                            canvas[x + i][y + j] = circle.grids[i][j];
                        }
                    }
                }
                shapes.add(circle);
            }
            return noConflict;
        }else{
            RightTriangle rightTriangle =new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.class.getEnumConstants()[params[2]]);
            rightTriangle.fillGrids();
            boolean noConflict=false;
            for(int i=0;i<rightTriangle.getHeight();i++){
                for(int j=0;j<rightTriangle.getWidth();j++){
                    if (x+i>=0&&x+i<canvas.length&&y+j<canvas[0].length&&y+j>=0&&rightTriangle.grids[i][j]!=' '){
                        noConflict=true;
                        break;
                    }
                }
            }
            if(noConflict){
                for(int i=0;i<rightTriangle.getHeight();i++) {
                    for (int j = 0; j < rightTriangle.getWidth(); j++) {
                        if(x+i>=0&&x+i<canvas.length&&y+j<canvas[0].length&&y+j>=0&&rightTriangle.grids[i][j]!=' ') {
                            canvas[x + i][y + j] = rightTriangle.grids[i][j];
                        }
                    }
                }
                shapes.add(rightTriangle);
            }
            return noConflict;
        }
    }
    public int getSpaceGridCount(){
        int count=0;
        for (char[] canva : this.canvas) {
            for (int j = 0; j < this.canvas[0].length; j++) {
                if (canva[j] == ' ') count++;
            }
        }
        return count;
    }

    public int getShapeCount(){return shapes.size();}
    public List<Shape> getShapesByArea(){
        class CompareByArea implements Comparator<Shape>{
            public int compare(Shape shape1,Shape shape2) {
                if(shape1.area() > shape2.area()){
                    return 1;
                }else if(shape1.area() < shape2.area()){
                    return -1;
                }else{
                    if(shape1.pattern > shape2.pattern){
                        return 1;
                    }else if(shape1.pattern < shape2.pattern){
                        return -1;
                    }
                }
                return 0;
            }
        }
        List<Shape> shapeList;
        shapeList=this.shapes;
        shapeList.sort(new CompareByArea());
        return shapeList;
    }

    public List<Shape> getShapesByLocation(){
        class CompareByLocation implements Comparator<Shape> {
            public int compare(Shape shape1,Shape shape2) {
                if(shape1.location.getX() > shape2.location.getX()){
                    return 1;
                }else if(shape1.location.getX() < shape2.location.getX()){
                    return -1;
                }else{
                    if(shape1.location.getY() > shape2.location.getY()){
                        return 1;
                    }else if(shape1.location.getY() < shape2.location.getY()){
                        return -1;
                    }else{
                        if(shape1.pattern > shape2.pattern){
                            return 1;
                        }else if(shape1.pattern < shape2.pattern){
                            return -1;
                        }
                    }
                }
                return 0;
            }
        }
        List<Shape> shapeList;
        shapeList=this.shapes;
        shapeList.sort(new CompareByLocation());
        return shapeList;
    }

    public char[][] getCanvas(){ return canvas;}
    public OverLapShapeCanvas(int rows, int cols){
        this.canvas=new char[rows][cols];
        this.canvas=new char[rows][cols];
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                this.canvas[i][j]=' ';

            }
        }
        this.shapes=new ArrayList<Shape>();
    }
}
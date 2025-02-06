import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public OverLapShapeCanvas(int rows,int cols){
        shapes=new ArrayList<Shape>();
        this.canvas=new char[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
    }
    public boolean addShape(int x,int y,char pattern,int params){
        Circle circle=new Circle(new Location(x,y),pattern,params);
        circle.fillGrids();
        int n=0;
        if (!(x>=canvas.length||y>=canvas[0].length||x+2*params<=0||y+2*params<=0)){
            for (int i=(x<0)?-x:0;i+x<((2*params+x>canvas.length)?canvas.length:2*params+x);i++){
                for (int j=(y<0)?-y:0;j+y<((2*params+y>canvas[0].length)?canvas[0].length:2*params+y);j++){
                    if (circle.getGrids()[i][j]!=' '){
                        n++;
                        break;
                    }
                }
            }
        }
        if (n==0){
            return false;
        }else {
            shapes.add(circle);
            for (int i=(x<0)?-x:0;i+x<((2*params+x>canvas.length)?canvas.length:2*params+x);i++){
                for (int j=(y<0)?-y:0;j+y<((2*params+y>canvas[0].length)?canvas[0].length:2*params+y);j++){
                    if (circle.grids[i][j]!=' ') {
                        canvas[i + x][y + j] = circle.grids[i][j];
                    }
                }
            }return true;
        }

    }
    public boolean addShape(int x,int y,char pattern,int width,int height,int direction){
        int n=0;
        Direction[] directions={Direction.LEFT_UP,Direction.LEFT_DOWN,Direction.RIGHT_UP,Direction.RIGHT_DOWN};
        RightTriangle rightTriangle=new RightTriangle(new Location(x, y),pattern,width,height,directions[direction]);
        rightTriangle.fillGrids();
        if (!(x>canvas.length||y>canvas[0].length||x+height<=0||y+height<=0)){
            for (int i=(x<0)?-x:0;i+x<((height+x>canvas.length)?canvas.length:height+x);i++){
                for (int j=(y<0)?-y:0;j+y<((width+y>canvas[0].length)?canvas[0].length:width+y);j++){
             if (rightTriangle.getGrids()[i][j]!=' '){
                 n++;
                 break;
             }
         }
        }
        }
        if (n==0){
            return false;
        }else {
            shapes.add(rightTriangle);
            for (int i=(x<0)?-x:0;i+x<((height+x>canvas.length)?canvas.length:height+x);i++){
                for (int j=(y<0)?-y:0;j+y<((width+y>canvas[0].length)?canvas[0].length:width+y);j++){
                    if (rightTriangle.grids[i][j]!=' ') {
                        canvas[i + x][y + j] = rightTriangle.grids[i][j];
                    }
                }
        }return true;
        }
//            for (int i=0;i<height;i++){
//                for (int j=0;j<width;j++){
//                    if (canvas[y+i][x+j]!=' '&&rightTriangle.getGrids()[i][j]!=' '){
//                        n++;
//                        break;
//                    }
//                }
//            }
//
//        if (n>0){
//            return false;
//        }else {
//            shapes.add(rightTriangle);
//            for (int i=0;i<height;i++){
//                for (int j=0;j<width;j++){
//                    canvas[y+i][x+j]=rightTriangle.getGrids()[i][j];
//                }
//            }return true;
//        }
    }


    public int getSpaceGridCount(){
        int n=0;
        for (char[] c:canvas){
            for (char a:c){
                if (a==' '){
                    n++;
                }
            }
        }
        return n;
    }
    public int getShapeCount(){
        int n=shapes.size();
        return n;
    }


    public List<Shape> getShapesByArea(){
        ArrayList<Shape> mid=new ArrayList<Shape>();
        for (Shape shape:shapes){
            mid.add(shape);
        }
        Collections.sort(mid);
        return mid;
    }
    public List<Shape> getShapesByLocation(){
        ArrayList<Shape> wtf=new ArrayList<Shape>();
        ArrayList<Shape> obj=new ArrayList<Shape>();
        for (Shape shape:shapes){
            wtf.add(shape);
        }
        while (obj.size()<shapes.size()){
            obj.add(maxOfShapes(wtf));
        }
        ArrayList<Shape> obj2=new ArrayList<Shape>();
        for (int n=obj.size()-1;n>=0;n--){
            obj2.add(obj.get(n));
        }
        return obj2;
//        for (Shape shape:shapes){
//            numbers.add(shape.getLocation().getX());
//        }
//        Collections.sort(numbers);
//        for (int i=0;i<numbers.size();i++){
//            if (i>0&&numbers.get(i)==numbers.get(i-1)){
//                continue;
//            }
//            for (int j=0;j<shapes.size();j++){
//                if (shapes.get(j).getLocation().getX()==numbers.get(i)){
//                    obj.add(shapes.get(j));
//                }
//            }
//        }
    }
    public char[][] getCanvas(){
        return canvas;
    }

    public Shape maxOfShapes(ArrayList<Shape> shapes1){
        Shape s1=shapes1.get(0);
        for (Shape shape:shapes1){
            if (shape.getLocation().getX()>s1.getLocation().getX()){
                s1=shape;
            }else if (shape.getLocation().getX()==s1.getLocation().getX()){
                if (shape.getLocation().getY()>s1.getLocation().getY()){
                    s1=shape;
                }else if (shape.getLocation().getY()==s1.getLocation().getY()){
                    if (shape.getPattern()>s1.getPattern()){
                        s1=shape;
                    }
                }
            }
        }
        shapes1.remove(s1);
        return s1;
    }
}

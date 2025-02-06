import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas  implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<Shape>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows,int cols){
        canvas=new char[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }

    }



    public boolean addShape(int x, int y, char pattern, int params){
        int n=0;
        Circle circle=new Circle(new Location(x,y),pattern,params);
        circle.fillGrids();
        if (x+2*params>canvas.length||y+2*params>canvas[0].length){
            n++;
        }else {
        for (int i=0;i<2*params;i++){
            for (int j=0;j<2*params;j++){
                if (canvas[i+x][j+y]!=' '&&circle.grids[i][j]!=' '){
                    n++;
                    break;
                }
            }
//        int n=0;
//        if (x+params>canvas[0].length||y+params>canvas.length||x<0||y<0){
//            n++;
//        }else {
//            for (int i=0;i<2*params;i++){
//                for (int j=0;j<2*params;j++){
//                    double distance=Math.pow(params-i,2)+Math.pow(params-j,2);
//                    if (distance<params*params){
//                        if (canvas[y+i][x+j]!=' '){
//                            n++;
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        if (n>0){
//            return false;
//        }else {
//            Circle c=new Circle(new Location(x,y),pattern,params);
//            shapes.add(c);
//            shapes.get(shapes.size()-1).fillGrids();
//            for (int i=0;i<2*params;i++){
//                for (int j=0;j<2*params;j++){
//                    canvas[y+i][x+j]=shapes.get(shapes.size()-1).getGrids()[i][j];
//                }
//            }
//            return true;
        }}
        if (n>0){
            return false;
        }else {
            shapes.add(circle);
            for (int i=0;i<2*params;i++){
                for (int j=0;j<2*params;j++){
                    if (canvas[i+x][y+j]==' ') {
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
       if (x+height>this.canvas.length||y+width>this.canvas[0].length){
           n++;
        }else {
           for (int i=0;i<height;i++){
               for (int j=0;j<width;j++){
                   if (canvas[x+i][y+j]!=' '&&rightTriangle.getGrids()[i][j]!=' '){
                       n++;
                       break;
                   }
               }
           }
       }
       if (n>0){
//           System.out.println("false");
           return false;

       }else {
           shapes.add(rightTriangle);
           for (int i=0;i<height;i++){
               for (int j=0;j<width;j++){
                   if (canvas[i+x][y+j]==' ') {
                       canvas[i + x][y + j] = rightTriangle.grids[i][j];
                   }
               }
           }return true;
       }
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
//        for (char[] c:canvas){
//            for (char a:c){
//                if (a!=' '){
//                    n++;
//                }
//            }
//        }return n;
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
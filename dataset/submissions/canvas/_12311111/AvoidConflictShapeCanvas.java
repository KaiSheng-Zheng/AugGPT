import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int SuccessAddNumber=0;

    public AvoidConflictShapeCanvas(int rows, int cols){
        shapes=new ArrayList<>();
        canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int... params){
        Location location=new Location(x, y);
        if (params.length==1){
            Circle circle=new Circle(location,pattern,params[0]);
            int radius=params[0];
            if (location.getX()+2*params[0]-1>canvas.length||location.getY()+2*params[0]-1>canvas[0].length){
                return false;
            }else {
                int count=0;
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (i<=radius-1+ location.getX()&&j<=radius-1+ location.getY()){
                            if ((Math.pow(radius-i-1+ location.getX(),2)+Math.pow(radius-j-1+ location.getY(),2)<Math.pow(radius,2))){
                                if (canvas[i][j]!=' ') count++;
                            }
                        }
                        if (i<=radius-1+ location.getX()&&j>=radius+ location.getY()){
                            if ((Math.pow(radius-i-1+ location.getX(),2)+Math.pow(radius-j+ location.getY(),2)<Math.pow(radius,2))){
                                if (canvas[i][j]!=' ') count++;
                            }
                        }
                        if (i>=radius+ location.getX()&&j<=radius-1+ location.getY()){
                            if ((Math.pow(radius-i+ location.getX(),2)+Math.pow(radius-j-1+ location.getY(),2)<Math.pow(radius,2))){
                                if (canvas[i][j]!=' ') count++;
                            }
                        }
                        if (i>=radius+ location.getX()&&j>=radius+ location.getY()){
                            if ((Math.pow(radius-i+ location.getX(),2)+Math.pow(radius-j+ location.getY(),2)<Math.pow(radius,2))){
                                if (canvas[i][j]!=' ') count++;
                            }
                        }
                    }
                }
                if (count==0){
                    for (int i = 0; i < canvas.length; i++) {
                        for (int j = 0; j < canvas[0].length; j++) {
                            if (i<=radius-1+ location.getX()&&j<=radius-1+ location.getY()){
                                if ((Math.pow(radius-i-1+ location.getX(),2)+Math.pow(radius-j-1+ location.getY(),2)<Math.pow(radius,2))){
                                    canvas[i][j]=pattern;
                                }
                            }
                            if (i<=radius-1+ location.getX()&&j>=radius+ location.getY()){
                                if ((Math.pow(radius-i-1+ location.getX(),2)+Math.pow(radius-j+ location.getY(),2)<Math.pow(radius,2))){
                                    canvas[i][j]=pattern;                                }
                            }
                            if (i>=radius+ location.getX()&&j<=radius-1+ location.getY()){
                                if ((Math.pow(radius-i+ location.getX(),2)+Math.pow(radius-j-1+ location.getY(),2)<Math.pow(radius,2))){
                                    canvas[i][j]=pattern;                                }
                            }
                            if (i>=radius+ location.getX()&&j>=radius+ location.getY()){
                                if ((Math.pow(radius-i+ location.getX(),2)+Math.pow(radius-j+ location.getY(),2)<Math.pow(radius,2))){
                                    canvas[i][j]=pattern;                                }
                            }
                        }
                    }
                    SuccessAddNumber++;
                    shapes.add(circle);
                    return true;
                }else {
                    return false;
                }
            }
        }else {
            int width=params[0];
            int height=params[1];
            Direction direction=Direction.LEFT_UP;
            switch (params[2]){
                case 0:direction=Direction.LEFT_UP;
                break;
                case 1:direction=Direction.LEFT_DOWN;
                break;
                case 2:direction=Direction.RIGHT_UP;
                break;
                case 3:direction=Direction.RIGHT_DOWN;
                break;
            }
            RightTriangle rightTriangle=new RightTriangle(location,pattern,width,height,direction);
            if (location.getX()+height>canvas.length||location.getY()+width>canvas[0].length){
                return false;
            }
            int count=0;
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if (i< location.getX()||j< location.getY()||i>= location.getX()+height||j>= location.getY()+width){
                        continue;
                    }
                    if (direction==Direction.LEFT_UP){
                        if ((i- location.getX())*width<height*(width-j+ location.getY())){
                            if (canvas[i][j]!=' ') count++;
                        }
                        if (canvas[location.getX()][location.getY()+width-1]!=' '|| canvas[location.getX()+height-1][location.getY()]!=' '){
                            count++;
                        }
                    }
                    if (direction==Direction.LEFT_DOWN){
                        if ((i+1- location.getX())*width>height*(j- location.getY())){
                            if (canvas[i][j]!=' ') count++;
                        }
                        if (canvas[location.getX()][location.getY()]!=' '&&canvas[height-1+ location.getX()][width-1+ location.getY()]!=' '){
                            count++;
                        }
                    }
                    if (direction==Direction.RIGHT_UP) {
                        if ((i- location.getX()) *width < height *(j+1- location.getY())) {
                            if (canvas[i][j]!=' ') count++;
                        }
                        if (canvas[location.getX()][location.getY()]!=' '&& canvas[height-1+ location.getX()][width-1+ location.getY()]!=' '){
                            count++;
                        }
                    }
                    if (direction==Direction.RIGHT_DOWN){
                        if ((i+1- location.getX())*width>height*(width-1-j+ location.getY())){
                            if (location.getX()==6&&location.getY()==3){
                                System.out.println(" i: "+i+" j: "+j);
                            }
                            if (canvas[i][j]!=' ') {
                                count++;
                            }
                        }
                        if (canvas[height-1+ location.getX()][location.getY()]!=' '&& canvas[location.getX()][width-1+ location.getY()]!=' '){
                            count++;
                        }
                    }
                }
            }
            if (count==0){
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (i< location.getX()||j< location.getY()||i>= location.getX()+height||j>= location.getY()+width){
                            continue;
                        }
                        if (direction==Direction.LEFT_UP){
                            if ((i- location.getX())*width<height*(width-j+ location.getY())){
                                canvas[i][j]=pattern;
                            }
                            canvas[location.getX()][location.getY()+width-1]=pattern;
                            canvas[location.getX()+height-1][location.getY()]=pattern;
                        }
                        if (direction==Direction.LEFT_DOWN){
                            if ((i+1- location.getX())*width>height*(j- location.getY())){
                                canvas[i][j]=pattern;
                            }
                            canvas[location.getX()][location.getY()]=pattern;
                            canvas[height-1+ location.getX()][width-1+ location.getY()]=pattern;
                        }
                        if (direction==Direction.RIGHT_UP) {
                            if ((i- location.getX()) *width < height *(j+1- location.getY())) {
                                canvas[i][j]=pattern;
                            }
                            canvas[location.getX()][location.getY()]=pattern;
                            canvas[height-1+ location.getX()][width-1+ location.getY()]=pattern;
                        }
                        if (direction==Direction.RIGHT_DOWN){
                            if ((i+1- location.getX())*width>height*(width-1-j+ location.getY())){
                                canvas[i][j]=pattern;
                            }
                            canvas[height-1+ location.getX()][location.getY()]=pattern;
                            canvas[location.getX()][width-1+ location.getY()]=pattern;
                        }
                    }
                }
                SuccessAddNumber++;
                shapes.add(rightTriangle);
                return true;
            }else {
                return false;
            }
        }
    }

    public int getSpaceGridCount(){
        int count=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                if (canvas[i][j]==' '){
                    count++;
                }
            }
        }
        return count;
    }

    public int getShapeCount(){
        return SuccessAddNumber;
    }
    public List<Shape> getShapesByArea(){
        Collections.sort(shapes);
        return shapes;
    }

    public List<Shape> getShapesByLocation(){
        for (int i = shapes.size()-1; i >=0 ; i--) {
            for (int j = i; j < shapes.size()-1; j++) {
                if (1==shapes.get(i).compare(shapes.get(i+1))){
                    Shape shape=shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,shape);
                }
            }
        }
        return shapes;
    }

    public char[][] getCanvas(){
        return canvas;
    }

    public String gridString(char[][] chars){
        StringBuilder string=new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                string.append(chars[i][j]);
            }
            string.append('\n');
        }
        return string.toString();
    }
}

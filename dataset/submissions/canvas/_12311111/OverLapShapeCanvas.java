import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OverLapShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int SuccessAddNumber=0;

    public OverLapShapeCanvas(int rows, int cols){
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
            if (location.getX()>canvas.length&&location.getY()>canvas[0].length){
                return false;
            }
            else {
                int count=0;
                int count1=0;
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (i<=radius-1+ location.getX()&&j<=radius-1+ location.getY()){
                            if ((Math.pow(radius-i-1+ location.getX(),2)+Math.pow(radius-j-1+ location.getY(),2)<Math.pow(radius,2))){
                                if (canvas[i][j]!=' ') count++;
                                count1++;
                            }
                        }
                        if (i<=radius-1+ location.getX()&&j>=radius+ location.getY()){
                            if ((Math.pow(radius-i-1+ location.getX(),2)+Math.pow(radius-j+ location.getY(),2)<Math.pow(radius,2))){
                                if (canvas[i][j]!=' ') count++;
                                count1++;
                            }
                        }
                        if (i>=radius+ location.getX()&&j<=radius-1+ location.getY()){
                            if ((Math.pow(radius-i+ location.getX(),2)+Math.pow(radius-j-1+ location.getY(),2)<Math.pow(radius,2))){
                                if (canvas[i][j]!=' ') count++;
                                count1++;
                            }
                        }
                        if (i>=radius+ location.getX()&&j>=radius+ location.getY()){
                            if ((Math.pow(radius-i+ location.getX(),2)+Math.pow(radius-j+ location.getY(),2)<Math.pow(radius,2))){
                                if (canvas[i][j]!=' ') count++;
                                count1++;
                            }
                        }
                    }
                }
                if (count1!=0){
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
            if (location.getX()+height>canvas.length&&location.getY()+width>canvas[0].length){
                if ((canvas.length-1- location.getX())*width< (location.getY()+width+1-canvas[0].length)*height){
                    return false;
                }
            }
            int count1=0;
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if (location.getX()+height>canvas.length&&location.getY()+width>canvas[0].length){
                        count1++;
                    }
                    if (i< location.getX()||j< location.getY()||i>= location.getX()+height||j>= location.getY()+width){
                        continue;
                    }
                    if (direction==Direction.LEFT_UP){
                        if ((i- location.getX())*width<height*(width-j+ location.getY())){
                            count1++;
                        }
                    }
                    if (direction==Direction.LEFT_DOWN){
                        if ((i+1- location.getX())*width>height*(j- location.getY())){
                            count1++;
                        }
                    }
                    if (direction==Direction.RIGHT_UP) {
                        if ((i- location.getX()) *width < height *(j+1- location.getY())) {
                            count1++;
                        }
                    }
                    if (direction==Direction.RIGHT_DOWN){
                        if ((i+1- location.getX())*width>height*(width-1-j+ location.getY())){
                            count1++;
                        }
                    }
                }
            }
            if (count1!=0){
                for (int i = 0; i < canvas.length; i++) {
                    for (int j = 0; j < canvas[0].length; j++) {
                        if (i< location.getX()||j< location.getY()||i>= location.getX()+height||j>= location.getY()+width){
                            continue;
                        }
                        if (direction==Direction.LEFT_UP){
                            if ((i- location.getX())*width<height*(width-j+ location.getY())){
                                canvas[i][j]=pattern;
                            }
                            if (location.getY()+width-1<=canvas[0].length){
                                canvas[location.getX()][location.getY()+width-1]=pattern;
                            }
                            if (location.getX()+height-1<=canvas.length){
                                canvas[location.getX()+height-1][location.getY()]=pattern;
                            }
                        }
                        if (direction==Direction.LEFT_DOWN){
                            if ((i+1- location.getX())*width>height*(j- location.getY())){
                                canvas[i][j]=pattern;
                            }
                            if (height-1+ location.getX()<=canvas.length&&width-1+ location.getY()<=canvas[0].length){
                                canvas[height-1+ location.getX()][width-1+ location.getY()]=pattern;
                            }
                            canvas[location.getX()][location.getY()]=pattern;
                        }
                        if (direction==Direction.RIGHT_UP) {
                            if ((i- location.getX()) *width < height *(j+1- location.getY())) {
                                canvas[i][j]=pattern;
                            }
                            if (height-1+ location.getX()<=canvas.length&&width-1+ location.getY()<=canvas[0].length){
                                // <= cannot prevent the case ==, which will cause ArrayIndexOutOfBoundsException.
                                canvas[height-1+ location.getX()][width-1+ location.getY()]=pattern;
                            }
                            canvas[location.getX()][location.getY()]=pattern;
                        }
                        if (direction==Direction.RIGHT_DOWN){
                            if ((i+1- location.getX())*width>height*(width-1-j+ location.getY())){
                                canvas[i][j]=pattern;
                            }
                            if (height-1+ location.getX()<=canvas.length){
                                canvas[height-1+ location.getX()][location.getY()]=pattern;
                            }
                            if (width-1+ location.getY()<=canvas[0].length){
                                canvas[location.getX()][width-1+ location.getY()]=pattern;
                            }
                        }
                    }
                }
                SuccessAddNumber++;
                shapes.add(rightTriangle);
                return true;
            }
            else {
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

    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size() - 1; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).compare(shapes.get(j + 1)) > 0) {
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
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

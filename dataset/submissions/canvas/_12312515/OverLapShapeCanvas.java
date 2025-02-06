import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<Shape>();
    private char[][] canvas;
    private int num=0;
    private static int rows,cols;
    public OverLapShapeCanvas(int rows, int cols){
        OverLapShapeCanvas.rows =rows;
        OverLapShapeCanvas.cols =cols;
        canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        if(params.length==1){
            int radius=params[0];
            boolean flag=false;
            for (int i = x; i < x+radius*2; i++) {
                for (int j = y; j < y+radius*2; j++) {
                    if(!checkpoint(i-x,j-y,radius)){
                        if(i>=0 && i<rows && j>=0 && j<cols){ flag=true;break;}
                    }
                }
            }
            if(flag){
                Location location=new Location(x,y);
                shapes.add(new Circle(location,pattern,radius));
                for (int i = x; i < x+radius*2; i++) {
                    for (int j = y; j < y+radius*2; j++) {
                        if(i>=0 && i<rows && j>=0 && j<cols && !checkpoint(i-x,j-y,radius)) canvas[i][j]=pattern;
                    }
                }
            }
            
            return flag;
        }



        else{
            boolean flag=false;
            int width=params[0];
            int height=params[1];
            Direction d=Direction.LEFT_UP;
            if(params[2]==3){
                d=Direction.RIGHT_DOWN;
                for (int i = x; i < x+height; i++) {
                    for (int j = y; j < y+width; j++) {
                        if((height-i-1+x)*(width)<(j+1-y)*(height)){
                            if(i>=0 && i<rows && j>=0 && j<cols){
                                flag=true;
                                break;
                            }
                        }
                    }
                }
            }
            if(params[2]==2){
                d=Direction.RIGHT_UP;
                for (int i = x; i < x+height; i++) {
                    for (int j = y; j < y+width; j++) {
                        if((i-x)*(width)<(j+1-y)*(height)){
                            if(i>=0 && i<rows && j>=0 && j<cols) {
                                flag=true;
                                break;
                            }
                        }
                    }
                }
            }
            if(params[2]==0){
                
                for (int i = x; i < x+height; i++) {
                    for (int j = y; j < y+width; j++) {
                        if((i-x)*(width)<(width-j+y)*(height)){
                            if(i>=0 && i<rows && j>=0 && j<cols) {
                                flag=true;
                                break;
                            }
                        }
                    }
                }
            }
            if(params[2]==1){
                d=Direction.LEFT_DOWN;
                for (int i = x; i < x+height; i++) {
                    for (int j = y; j < y+width; j++) {
                        if((height-i-1+x)*(width)<(width-j+y)*(height)){
                            if(i>=0 && i<rows && j>=0 && j<cols){
                                flag=true;
                                break;
                            }
                        }
                    }
                }
            }
            if(flag) {
                Location location = new Location(x, y);
                shapes.add(new RightTriangle(location, pattern, width, height, d));
                if (params[2] == 3) {
                    
                    for (int i = x; i < x + height; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((height - i - 1 + x) * (width) < (j + 1 - y) * (height)) {
                                if(i>=0 && i<rows && j>=0 && j<cols){
                                    canvas[i][j]=pattern;
                                }
                            }
                        }
                    }
                }
                if (params[2] == 2) {
                    
                    for (int i = x; i < x + height; i++) {
                        for (int j = y; j < y + width; j++) {
                            if((i-x)*(width)<(j+1-y)*(height)){
                                if(i>=0 && i<rows && j>=0 && j<cols){
                                    canvas[i][j]=pattern;
                                }
                            }
                        }
                    }
                }
                if (params[2] == 0) {
                    
                    for (int i = x; i < x + height; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((i - x) * (width) < (width - j + y) * (height)) {
                                if(i>=0 && i<rows && j>=0 && j<cols){
                                    canvas[i][j]=pattern;
                                }
                            }
                        }
                    }
                }
                if (params[2] == 1) {
                    
                    for (int i = x; i < x + height; i++) {
                        for (int j = y; j < y + width; j++) {
                            if ((height - i - 1 + x) * (width) < (width - j + y) * (height)) {
                                if(i>=0 && i<rows && j>=0 && j<cols){
                                    canvas[i][j]=pattern;
                                }
                            }
                        }
                    }
                }
            }
            return flag;
        }
    }
    public boolean checkpoint(int a,int b,int radius){
        if(a<radius && b<radius) return (radius-a-1)*(radius-a-1)+(radius-b-1)*(radius-b-1)>=radius*radius;
        if(a>=radius && b<radius) return (radius-a)*(radius-a)+(radius-b-1)*(radius-b-1)>=radius*radius;
        if(a<radius && b>=radius) return (radius-a-1)*(radius-a-1)+(radius-b)*(radius-b)>=radius*radius;
        if(a>=radius && b>=radius) return (radius-a)*(radius-a)+(radius-b)*(radius-b)>=radius*radius;
        return false;
    }
    @Override
    public int getSpaceGridCount(){
        int ans=0;
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if(canvas[i][j]==' ') ans++;
            }
        }
        return ans;
    }
    @Override
    public int getShapeCount(){
        return shapes.size();
    }
    @Override
    public List<Shape> getShapesByArea(){
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.area()> o2.area()) return 1;
                if(o1.area()< o2.area()) return -1;
                if(o1.area()== o2.area()) return o1.pattern< o2.pattern?-1:1;
                return 0;
            }
        });
        return shapes;
    }
    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.location.getX()> o2.location.getX()) return 1;
                if(o1.location.getX()< o2.location.getX()) return -1;
                if(o1.location.getX()== o2.location.getX()) {
                    if(o1.location.getY()>o2.location.getY()) return 1;
                    if(o1.location.getY()<o2.location.getY()) return -1;
                    return o1.pattern< o2.pattern?-1:1;
                }
                return 0;
            }
        });
        return shapes;
    }
    @Override
    public char[][] getCanvas(){
        return canvas;
    }
}

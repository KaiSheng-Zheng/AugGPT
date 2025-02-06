import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    private int SpaceGridCount=0;
    private int ShapeCount = 0;
    public int getSpaceGridCount(){
        return SpaceGridCount;
    }
    public int getShapeCount(){
        return ShapeCount;
    }
    public void setSpaceGridCount(int spaceGridCount) {
        SpaceGridCount = spaceGridCount;
    }
    public void setShapeCount(int shapeCount) {
        ShapeCount = shapeCount;
    }
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        setSpaceGridCount(0);
        if(params.length==1){
            if(x<0||x+2*params[0]>canvas.length||y<0||y+2*params[0]>canvas[0].length) return false;
            else{
                boolean flag=false;
                double[]center = {x+params[0]-0.5,y+params[0]-0.5};
                for (int i = x; i < x+params[0]; i++) {
                    for (int j = y; j < y+params[0]; j++) {
                        double[]rightDownCorner = {i+0.5,j+0.5};
                        double rrd = Math.sqrt(Math.pow(rightDownCorner[0]-center[0],2)+Math.pow(rightDownCorner[1]-center[1],2));
                        if(rrd<params[0]){
                            if(canvas[i][j]==' ')flag=true;
                            else return false;
                        }
                    }
                }
                for (int i = x; i < x+params[0]; i++) {
                    for (int j = y+params[0]; j < y+2*params[0]; j++) {
                        double[]leftDownCorner = {i+0.5,j-0.5};
                        double rld = Math.sqrt(Math.pow((leftDownCorner[0]-center[0]),2)+Math.pow((leftDownCorner[1]-center[1]),2));
                        if(rld<params[0]){
                            if(canvas[i][j]==' ')flag=true;
                            else return false;
                        }
                    }
                }
                for (int i = x+params[0]; i < x+2*params[0]; i++) {
                    for (int j = y; j < y+params[0]; j++) {
                        double[]rightUpCorner = {i-0.5,j+0.5};
                        double rru = Math.sqrt(Math.pow((rightUpCorner[0]-center[0]),2)+Math.pow((rightUpCorner[1]-center[1]),2));
                        if(rru<params[0]){
                            if(canvas[i][j]==' ')flag=true;
                            else return false;
                        }
                    }
                }
                for (int i = x+params[0]; i < x+2*params[0]; i++) {
                    for (int j = y+params[0]; j < y+2*params[0]; j++) {
                        double[]leftUpCorner = {i-0.5,j-0.5};
                        double rlu = Math.sqrt(Math.pow((leftUpCorner[0]-center[0]),2)+Math.pow((leftUpCorner[1]-center[1]),2));
                        if(rlu<params[0]){
                            if(canvas[i][j]==' ') flag=true;
                            else return false;
                        }
                    }
                }
                if(flag){
                    for (int i = x; i < x+params[0]; i++) {
                        for (int j = y; j < y+params[0]; j++) {
                            double[]rightDownCorner = {i+0.5,j+0.5};
                            double rrd = Math.sqrt(Math.pow(rightDownCorner[0]-center[0],2)+Math.pow(rightDownCorner[1]-center[1],2));
                            if(rrd<params[0]){
                                if(canvas[i][j]==' '){
                                    canvas[i][j]=pattern;
                                    setSpaceGridCount(getSpaceGridCount()+1);
                                }
                            }
                        }
                    }
                    for (int i = x; i < x+params[0]; i++) {
                        for (int j = y+params[0]; j < y+2*params[0]; j++) {
                            double[]leftDownCorner = {i+0.5,j-0.5};
                            double rld = Math.sqrt(Math.pow((leftDownCorner[0]-center[0]),2)+Math.pow((leftDownCorner[1]-center[1]),2));
                            if(rld<params[0]){
                                if(canvas[i][j]==' '){
                                    canvas[i][j]=pattern;
                                    setSpaceGridCount(getSpaceGridCount()+1);
                                }
                            }
                        }
                    }
                    for (int i = x+params[0]; i < x+2*params[0]; i++) {
                        for (int j = y; j < y+params[0]; j++) {
                            double[]rightUpCorner = {i-0.5,j+0.5};
                            double rru = Math.sqrt(Math.pow((rightUpCorner[0]-center[0]),2)+Math.pow((rightUpCorner[1]-center[1]),2));
                            if(rru<params[0]){
                                if(canvas[i][j]==' '){
                                    canvas[i][j]=pattern;
                                    setSpaceGridCount(getSpaceGridCount()+1);
                                }
                            }
                        }
                    }
                    for (int i = x+params[0]; i < x+2*params[0]; i++) {
                        for (int j = y+params[0]; j < y+2*params[0]; j++) {
                            double[]leftUpCorner = {i-0.5,j-0.5};
                            double rlu = Math.sqrt(Math.pow((leftUpCorner[0]-center[0]),2)+Math.pow((leftUpCorner[1]-center[1]),2));
                            if(rlu<params[0]){
                                if(canvas[i][j]==' '){
                                    canvas[i][j]=pattern;
                                    setSpaceGridCount(getSpaceGridCount()+1);
                                }
                            }
                        }
                    }
                }
                Location newlocation=new Location(x,y);
                Circle newCircle = new Circle(newlocation,pattern,params[0]);
                newCircle.setCount(getSpaceGridCount());
                shapes.add(newCircle);
                setShapeCount(getShapeCount()+1);
                return true;
            }
        } else if (params.length==3) {
            if(x<0||x+params[1]>canvas.length||y<0||y+params[0]>canvas[0].length) return false;
            else{
                boolean flag=false;
                switch (params[2]){
                    case 0:
                        Direction a =Direction.LEFT_UP;
                        for (int i = x; i < x+params[1]; i++) {
                            for (int j = y; j < y+params[0]; j++) {
                                double[]leftUpCorner = {i-0.5,j-0.5};
                                if(params[1]*(leftUpCorner[1]-(y-0.5))<-params[0]*(leftUpCorner[0]-(x+params[1]-0.5))){
                                    if(canvas[i][j]==' '){
                                        flag=true;
                                    }
                                    else return false;
                                }
                            }
                        }
                        if(flag){
                            for (int i = x; i < x+params[1]; i++) {
                                for (int j = y; j < y+params[0]; j++) {
                                    double[]leftUpCorner = {i-0.5,j-0.5};
                                    if(params[1]*(leftUpCorner[1]-(y-0.5))<-params[0]*(leftUpCorner[0]-(x+params[1]-0.5))){
                                        if(canvas[i][j]==' '){
                                            canvas[i][j]=pattern;
                                            setSpaceGridCount(getSpaceGridCount()+1);
                                        }
                                    }
                                }
                            }

                        }
                        Location newLocation0 = new Location(x,y);
                        RightTriangle newRightTriangle0 = new RightTriangle(newLocation0,pattern,params[0],params[1],a);
                        newRightTriangle0.setCount(getSpaceGridCount());
                        shapes.add(newRightTriangle0);
                        break;
                    case 1:
                        Direction b =Direction.LEFT_DOWN;
                        for (int i = x; i < x+params[1]; i++) {
                            for (int j = y; j < y+params[0]; j++) {
                                double[]leftDownCorner = {i+0.5,j-0.5};
                                if(params[1]*(leftDownCorner[1]-(y-0.5))<params[0]*(leftDownCorner[0]-(x-0.5))){
                                    if(canvas[i][j]==' '){
                                        flag=true;
                                    }
                                    else return false;
                                }
                            }
                        }
                        if(flag){
                            for (int i = x; i < x+params[1]; i++) {
                                for (int j = y; j < y+params[0]; j++) {
                                    double[]leftDownCorner = {i+0.5,j-0.5};
                                    if(params[1]*(leftDownCorner[1]-(y-0.5))<params[0]*(leftDownCorner[0]-(x-0.5))){
                                        if(canvas[i][j]==' '){
                                            canvas[i][j]=pattern;
                                            setSpaceGridCount(getSpaceGridCount()+1);
                                        }
                                    }
                                }
                            }
                        }
                        Location newLocation1 = new Location(x,y);
                        RightTriangle newRightTriangle1 = new RightTriangle(newLocation1,pattern,params[0],params[1],b);
                        newRightTriangle1.setCount(getSpaceGridCount());
                        shapes.add(newRightTriangle1);
                        break;
                    case 2:
                        Direction c = Direction.RIGHT_UP;
                        for (int i = x; i < x+params[1]; i++) {
                            for (int j = y; j < y+params[0]; j++) {
                                double[]rightUpCorner = {i-0.5,j+0.5};
                                if(params[1]*(rightUpCorner[1]-(y-0.5))>params[0]*(rightUpCorner[0]-(x-0.5))){
                                    if(canvas[i][j]==' '){
                                        flag=true;
                                    }
                                    else return false;
                                }
                            }
                        }
                        if(flag){
                            for (int i = x; i < x+params[1]; i++) {
                                for (int j = y; j < y+params[0]; j++) {
                                    double[]rightUpCorner = {i-0.5,j+0.5};
                                    if(params[1]*(rightUpCorner[1]-(y-0.5))>params[0]*(rightUpCorner[0]-(x-0.5))){
                                        if(canvas[i][j]==' '){
                                            canvas[i][j]=pattern;
                                            setSpaceGridCount(getSpaceGridCount()+1);
                                        }
                                    }
                                }
                            }
                        }
                        Location newLocation2 = new Location(x,y);
                        RightTriangle newRightTriangle2 = new RightTriangle(newLocation2,pattern,params[0],params[1],c);
                        newRightTriangle2.setCount(getSpaceGridCount());
                        shapes.add(newRightTriangle2);
                        break;
                    case 3:
                        Direction d = Direction.RIGHT_DOWN;
                        for (int i = x; i < x+params[1]; i++) {
                            for (int j = y; j < y+params[0]; j++) {
                                double[]rightDownCorner = {i+0.5,j+0.5};
                                if(params[1]*(rightDownCorner[1]-(y-0.5))>-params[0]*(rightDownCorner[0]-(x+params[1]-0.5))){
                                    if(canvas[i][j]==' '){
                                        flag=true;
                                    }
                                    else return false;
                                }
                            }
                        }
                        if(flag){
                            for (int i = x; i < x+params[1]; i++) {
                                for (int j = y; j < y+params[0]; j++) {
                                    double[]rightDownCorner = {i+0.5,j+0.5};
                                    if(params[1]*(rightDownCorner[1]-(y-0.5))>-params[0]*(rightDownCorner[0]-(x+params[1]-0.5))){
                                        if(canvas[i][j]==' '){
                                            canvas[i][j]=pattern;
                                            setSpaceGridCount(getSpaceGridCount()+1);
                                        }
                                    }
                                }
                            }
                        }
                        Location newLocation3 = new Location(x,y);
                        RightTriangle newRightTriangle3 = new RightTriangle(newLocation3,pattern,params[0],params[1],d);
                        newRightTriangle3.setCount(getSpaceGridCount());
                        shapes.add(newRightTriangle3);
                        break;
                }
                setShapeCount(getShapeCount()+1);
                return true;
            }
        }
        return false;
    }
    public char[][] getCanvas(){
        return canvas;
    }

    @Override
    public List<Shape> getShapesByArea() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if (s1.area() != s2.area()) return Integer.compare(s1.area(), s2.area());
                else return Character.compare(s1.getPattern(),s2.getPattern());
            }
        });
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        shapes.sort(new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                if(s1.getLocation().getX()!=s2.getLocation().getX()){
                    return Integer.compare(s1.getLocation().getX(),s2.getLocation().getX());
                } else if (s1.getLocation().getY()!=s2.getLocation().getY()) {
                    return Integer.compare(s1.getLocation().getY(),s2.getLocation().getY());
                }else return Character.compare(s1.getPattern(),s2.getPattern());
            }
        });
        return shapes;
    }
}


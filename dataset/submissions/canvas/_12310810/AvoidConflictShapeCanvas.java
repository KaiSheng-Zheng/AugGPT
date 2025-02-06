
import java.util.ArrayList;

import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    public int rowaaa;
    public int colaaa;
    public int count;
    public int spaceCount=0;
    public AvoidConflictShapeCanvas(int rows,int cols){
        canvas=new char[rows][cols];
        rowaaa=rows;
        colaaa=cols;
        for (int i = 0; i < rows; i++) {
            for (int i1 = 0; i1 < cols; i1++) {
                canvas[i][i1]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location l=new Location(x,y);
        char[][] clone=deepClone(canvas);
        if (params.length==1){
            Circle c=new Circle(l,pattern,params[0]);
            int radius=params[0];
            int bian=radius*2;
            for (int i = x; i < x+bian; i++) {
                for (int i1 = y; i1 <y+bian; i1++) {
                    double distance1=Math.pow(i-radius-x,2)+Math.pow(i1-radius-y,2);
                    double distance2=Math.pow(i+1-radius-x,2)+Math.pow(i1+1-radius-y,2);
                    double distance3=Math.pow(i+1-radius-x,2)+Math.pow(i1-radius-y,2);
                    double distance4=Math.pow(i-radius-x,2)+Math.pow(i1+1-radius-y,2);
                    double distance=Math.min(distance4,Math.min(distance3,Math.min(distance1,distance2)));
                    if(distance<radius*radius){
                        if(i>=rowaaa||i1>=colaaa){
                            canvas=clone;
                            return false;
                        }
                        if(canvas[i][i1] !=' '){
                            canvas=clone;
                            return false;
                        }
                        canvas[i][i1]=pattern;
                        spaceCount++;
                        c.area++;
                    }else{
                        if(i>rowaaa||i1>colaaa){
                            continue;
                        }
                    }
                }
            }
            shapes.add(c);
            count++;
            return true;
        }else if(params.length==3){
            // bug
            /*
            AvoidConflictShapeCanvas canvas = new AvoidConflictShapeCanvas(10, 10);
            assertTrue(canvas.addShape(2, 2, 'C', 3));
            assertFalse(canvas.addShape(1, 1, 'R', 4, 3, 0)); // failed here
             */
            Direction d=Direction.RIGHT_DOWN;
            if(params[2]==0){
                d=Direction.LEFT_UP;
            }else if(params[2]==1){
                d=Direction.LEFT_DOWN;
            }else if(params[2]==2){
                d=Direction.RIGHT_UP;
            }
            double width=params[0];
            double height=params[1];
            RightTriangle r=new RightTriangle(l,pattern,(int)width,(int)height,d);
            char[][] clone1=deepClone(canvas);
            double slope=height/width;
            if(params[2]==0){
                for (int i = x; i <x+height; i++) {
                    if(i>=rowaaa){
                        canvas=clone;
                        return false;
                    }
                    if(canvas[i][y]!=' '){
                        canvas=clone1;
                        return false;
                    }
                    canvas[i][y]=pattern;spaceCount++;r.area++;
                    for (int i1 = y+1; i1 < y+width; i1++) {
                        double slopex=(i-x)*1.0/(i1-y);
                        if(slopex<slope){
                            if(i>=rowaaa||i1>=colaaa){
                                canvas=clone;
                                return false;
                            }
                            if(canvas[i][(int) (2*y+width-i1)]!=' '){
                                canvas=clone1;
                                return false;
                            }
                            canvas[i][(int) (2*y+width-i1)]=pattern;
                            spaceCount++;r.area++;
                        }
                    }
                    count++;shapes.add(r);
                    return true;
                }
            }else if(params[2]==1){
                for (int i = x; i < x+height; i++) {
                    if(canvas[i][y]!=' '){
                        canvas=clone1;
                        return false;}
                    canvas[i][y]=pattern;spaceCount++;r.area++;
                    for (int i1 = 1+y; i1 < y+width; i1++) {
                        double slopex=(i+1-x)*1.0/(i1-y);
                        if(slopex>slope){
                            if(canvas[i][i1]!=' '){
                                canvas=clone1;
                                return false;}
                            canvas[i][i1]=pattern;
                            spaceCount++;r.area++;
                        }
                    }
                }
                count++;shapes.add(r);
                return true;
            }else if (params[2]==2){
                for (int i = x; i < x+height; i++) {
                    if(i>=rowaaa||(y+width-1)>=colaaa){
                        canvas=clone;
                        return false;
                    }
                    if(canvas[i][(int) (y+width-1)]!=' '){
                        canvas=clone1;
                        return false;}
                    canvas[i][(int) (y+width-1)]=pattern;spaceCount++;r.area++;
                    for (int i1 = y; i1 < y+width-1; i1++) {
                        double slopex=(i-x)*1.0/(i1-y+1);
                        if(slopex<slope){
                            if(canvas[i][i1]!=' '){
                                canvas=clone1;
                                return false;}
                            canvas[i][i1]=pattern;
                            spaceCount++;r.area++;
                        }
                    }
                }
                count++;shapes.add(r);
                return true;
            }else{
                for (int i = x; i < x+height; i++) {
                    if(i>=rowaaa||(y+width-1)>=colaaa){
                        canvas=clone;

                        return false;
                    }
                    if(canvas[i][(int) (y+width-1)]!=' '){
                        canvas=clone;
                        return false;}
                    canvas[i][(int) (y+width-1)]=pattern;spaceCount++;r.area++;
                    for (int i1 = y; i1 < y+width-1; i1++) {
                        double slopex=(i-x+1)*1.0/(y+width-i1-1);
                        if(slopex>slope){
                            if(i>=rowaaa||i1>=colaaa){
                                canvas=clone;
                                return false;
                            }
                            if(canvas[i][i1]!=' '){
                                canvas=clone;
                                return false;}
                            canvas[i][i1]=pattern;
                            spaceCount++;r.area++;
                        }
                    }
                }
                shapes.add(r);
                count++;
                return true;
            }
        }
        return false;
    }



    @Override
    public int getSpaceGridCount() {
        return spaceCount;
    }

    @Override
    public int getShapeCount() {
        return count;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int k=0;k<shapes.size();k++) {
            for (int i = 0; i < shapes.size()-1; i++) {
                if(shapes.get(i).area>shapes.get(i+1).area){
                    Shape temp=shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp);
                }else if(shapes.get(i).area==shapes.get(i+1).area){
                    if(shapes.get(i).pattern>shapes.get(i+1).pattern){
                        Shape temp=shapes.get(i);
                        shapes.set(i,shapes.get(i+1));
                        shapes.set(i+1,temp);
                    }
                }
            }}
        return shapes;}


    @Override
    public List<Shape> getShapesByLocation() {
        for (int k=0;k<shapes.size();k++) {
            for (int i = 0; i < shapes.size()-1; i++) {
                if(shapes.get(i).location.getX()>shapes.get(i+1).location.getX()){
                    Shape temp=shapes.get(i);
                    shapes.set(i,shapes.get(i+1));
                    shapes.set(i+1,temp);
                }else if(shapes.get(i).location.getX()==shapes.get(i+1).location.getX()){
                    if(shapes.get(i).location.getY()>shapes.get(i+1).location.getY()){
                        Shape temp=shapes.get(i);
                        shapes.set(i,shapes.get(i+1));
                        shapes.set(i+1,temp);}else if(shapes.get(i).location.getY()==shapes.get(i+1).location.getY()){
                        if(shapes.get(i).pattern>shapes.get(i+1).pattern){
                            Shape temp=shapes.get(i);
                            shapes.set(i,shapes.get(i+1));
                            shapes.set(i+1,temp);
                        }
                    }}
            }}
        return shapes;}



    @Override
    public char[][] getCanvas() {

        return canvas;
    }
    public static char[][] deepClone(char[][] original) {
        if (original == null) {
            return null;
        }

        int rows = original.length;
        char[][] cloned = new char[rows][];

        for (int i = 0; i < rows; i++) {
            if (original[i] != null) {
                int cols = original[i].length;
                cloned[i] = new char[cols];
                for (int j = 0; j < cols; j++) {
                    cloned[i][j] = original[i][j];
                }
            }
        }

        return cloned;
    }
}

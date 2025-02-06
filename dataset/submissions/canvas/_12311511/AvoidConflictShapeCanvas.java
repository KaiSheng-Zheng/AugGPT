
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static A6.Direction.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows;
    private int cols;

    public AvoidConflictShapeCanvas(int rows, int cols){
        // rows represents the height of canvas and cols represents the width of canvas.
        // Those are also the rows and columns of the private field canvas .
        canvas=new char[rows][cols];
        this.rows=rows;
        this.cols=cols;
        shapes=new ArrayList<>();
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        if (params.length==1){
            Location location=new Location(x,y);
            int radius=params[0];
            Circle c=new Circle(location,pattern,radius);
            c.fillGrids();
            char[][] getc=c.getGrids();
            for (int i = 0; i < radius*2; i++) {
                for (int j = 0; j < radius*2; j++) {
                    if (getc[i][j]==pattern){
                        if ((x+i>=this.rows)||(y+j>=this.cols)){
                            i=radius*2;
                            return false;
                        }
                        if(canvas[x+i][y+j]!='\u0000'){
                            i=radius*2;
                            return false;
                        }
                        if ((x+i<0)||(y+j<0)){
                            return false;
                        }
                    }
                }
            }
            for (int i = 0; i < radius*2; i++) {
                for (int j = 0; j < radius*2; j++) {
                    canvas[x+i][y+j]=pattern;
                }
            }
            shapes.add(c);
        }
        if (params.length==3){
            Location location=new Location(x,y);
            int width=params[0];
            int height=params[1];
            Direction d=LEFT_UP;
            if (params[2]==1){
                d=LEFT_DOWN;
            };
            if (params[2]==2){
                d=RIGHT_UP;
            }
            if (params[2]==3){
                d=RIGHT_DOWN;
            }
            RightTriangle t=new RightTriangle(location,pattern,width,height,d);
            t.fillGrids();
            char[][] getc=t.getGrids();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (getc[i][j]==pattern){
                        if ((x+i>=this.rows)||(y+j>=this.cols)){
                            i=height;
                            return false;
                        }
                        if(canvas[x+i][y+j]!='\u0000'){
                            i=height;
                            return false;
                        }
                        if ((x+i<0)||(y+j<0)){
                            return false;
                        }
                    }
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    canvas[x+i][y+j]=pattern;
                }
            }
            shapes.add(t);
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int rec=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j]==' '){
                    rec++;
                }
            }
        }
        return rec;
    }

    @Override
    public int getShapeCount() {
        int rec=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j]!=' '){
                    rec++;
                }
            }
        }
        return rec;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size(); i++) {
            Collections.sort(shapes);
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Orderlcomparator o=new Orderlcomparator();
        shapes.sort(o);
        return shapes;
        }

    @Override
    public char[][] getCanvas() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canvas[i][j]=='\u0000'){
                    canvas[i][j]=' ';
                }
            }
        }
        return canvas;
    }
}

class Orderlcomparator implements Comparator<Shape>{
    public int compare(Shape s1, Shape s2) {
        if (s1.getX()<s2.getX()){
            return -1;
        }
        if (s1.getX()>s2.getX()){

            return 1;
        }
        else {
            if (s1.getY()<s2.getY()){
                return -1;
            }
            if (s1.getY()>s2.getY()){
                return 1;
            }
            else{
                if (s1.getPattern()< s2.getPattern()){
                    return -1;
                }
                else
                    return 1;
            }
        }
    }
}
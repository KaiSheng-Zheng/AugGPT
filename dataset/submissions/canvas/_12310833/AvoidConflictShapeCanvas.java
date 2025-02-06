import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols){
        this.shapes=new ArrayList<>();
        this.canvas=new char[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
    }

    public boolean addShape(int x, int y, char pattern, int ... params){
        Location location=new Location(x,y);
        if(x<0 || y<0){
            return  false;
        }
        else{
            if(params.length==1){
                Shape circle=new Circle(location,pattern,params[0]);
                for(int row=0;row<params[0];row++){
                    for(int column=0;column<params[0];column++){
                        if((params[0]-1-row)*(params[0]-1-row)+(params[0]-1-column)*(params[0]-1-column)-params[0]*params[0]<0){
                            if(row+x>=canvas.length || column+y>=canvas[0].length || canvas[row+x][column+y]!=' '){
                                return false;
                            }
                        }
                    }
                }
                for(int row=0;row<params[0];row++){
                    for(int column=params[0];column<2*params[0];column++){
                        if((params[0]-1-row)*(params[0]-1-row)+(column-params[0])*(column-params[0])-params[0]*params[0]<0){
                            if(row+x>=canvas.length || column+y>=canvas[0].length || canvas[row+x][column+y]!=' '){
                                return false;
                            }
                        }
                    }
                }
                for(int row=params[0];row<2*params[0];row++){
                    for(int column=0;column<params[0];column++){
                        if((row-params[0])*(row-params[0])+(params[0]-1-column)*(params[0]-1-column)-params[0]*params[0]<0){
                            if(row+x>=canvas.length || column+y>=canvas[0].length || canvas[row+x][column+y]!=' '){
                                return false;
                            }
                        }
                    }
                }
                for(int row=params[0];row<2*params[0];row++){
                    for(int column=params[0];column<2*params[0];column++){
                        if((row-params[0])*(row-params[0])+(column-params[0])*(column-params[0])-params[0]*params[0]<0){
                            if(row+x>=canvas.length || column+y>=canvas[0].length || canvas[row+x][column+y]!=' '){
                                return false;
                            }
                        }
                    }
                }
                for(int row=0;row<params[0];row++){
                    for(int column=0;column<params[0];column++){
                        if((params[0]-1-row)*(params[0]-1-row)+(params[0]-1-column)*(params[0]-1-column)-params[0]*params[0]<0){
                            canvas[row+x][column+y]=pattern;
                        }
                    }
                }
                for(int row=0;row<params[0];row++){
                    for(int column=params[0];column<2*params[0];column++){
                        if((params[0]-1-row)*(params[0]-1-row)+(column-params[0])*(column-params[0])-params[0]*params[0]<0){
                            canvas[row+x][column+y]=pattern;
                        }
                    }
                }
                for(int row=params[0];row<2*params[0];row++){
                    for(int column=0;column<params[0];column++){
                        if((row-params[0])*(row-params[0])+(params[0]-1-column)*(params[0]-1-column)-params[0]*params[0]<0){
                            canvas[row+x][column+y]=pattern;
                        }
                    }
                }
                for(int row=params[0];row<2*params[0];row++){
                    for(int column=params[0];column<2*params[0];column++){
                        if((row-params[0])*(row-params[0])+(column-params[0])*(column-params[0])-params[0]*params[0]<0){
                            canvas[row+x][column+y]=pattern;
                        }
                    }
                }
                shapes.add(circle);
                return true;
            }
            else{
                Shape rightTriangle=new RightTriangle(location,pattern,params[0],params[1],params[2]);
                if(params[2]==0){
                    for(int column=0;column<params[0];column++){
                        int finalrow=params[1]-1-(column*(params[1]/params[0])+(column*(params[1]%params[0]))/params[0]);
                        for(int row=finalrow;row>=0;row--){
                            if(row+x>=canvas.length || column+y>=canvas[0].length || canvas[row+x][column+y]!=' '){
                                return false;
                            }
                        }
                    }
                    for(int column=0;column<params[0];column++){
                        int finalrow=params[1]-1-(column*(params[1]/params[0])+(column*(params[1]%params[0]))/params[0]);
                        for(int row=finalrow;row>=0;row--){
                            canvas[row+x][column+y]=pattern;
                        }
                    }
                    shapes.add(rightTriangle);
                    return true;
                }
                else if(params[2]==1){
                    for(int column=0;column<params[0];column++){
                        int initial=column*(params[1]/params[0])+(column*(params[1]%params[0]))/params[0];
                        for(int row=initial;row<params[1];row++){
                            if(row+x>=canvas.length || column+y>=canvas[0].length || canvas[row+x][column+y]!=' '){
                                return false;
                            }
                        }
                    }
                    for(int column=0;column<params[0];column++){
                        int initial=column*(params[1]/params[0])+(column*(params[1]%params[0]))/params[0];
                        for(int row=initial;row<params[1];row++){
                            canvas[row+x][column+y]=pattern;
                        }
                    }
                    shapes.add(rightTriangle);
                    return true;
                }
                else if(params[2]==2){
                    for(int column=params[0]-1;column>=0;column--){
                        int finalrow=params[1]-1-((params[0]-1-column)*(params[1]/params[0])+((params[0]-1-column)*(params[1]%params[0]))/params[0]);
                        for(int row=finalrow;row>=0;row--){
                            if(row+x>=canvas.length || column+y>=canvas[0].length || canvas[row+x][column+y]!=' '){
                                return false;
                            }
                        }
                    }
                    for(int column=params[0]-1;column>=0;column--){
                        int finalrow=params[1]-1-((params[0]-1-column)*(params[1]/params[0])+((params[0]-1-column)*(params[1]%params[0]))/params[0]);
                        for(int row=finalrow;row>=0;row--){
                            canvas[row+x][column+y]=pattern;
                        }
                    }
                    shapes.add(rightTriangle);
                    return true;
                }
                else {
                    for(int column=params[0]-1;column>=0;column--){
                        int initial=(params[0]-1-column)*(params[1]/params[0])+((params[0]-1-column)*(params[1]%params[0]))/params[0];
                        for(int row=initial;row<params[1];row++){
                            if(row+x>=canvas.length || column+y>=canvas[0].length || canvas[row+x][column+y]!=' '){
                                return false;
                            }
                        }
                    }
                    for(int column=params[0]-1;column>=0;column--){
                        int initial=(params[0]-1-column)*(params[1]/params[0])+((params[0]-1-column)*(params[1]%params[0]))/params[0];
                        for(int row=initial;row<params[1];row++){
                            canvas[row+x][column+y]=pattern;
                        }
                    }
                    shapes.add(rightTriangle);
                    return true;
                }
            }

        }
    }
    public int getSpaceGridCount(){
        int num=0;
        for(int row=0;row<canvas.length;row++){
            for(int col=0;col<canvas[0].length;col++){
                if(canvas[row][col]==' '){
                    num++;
                }
            }
        }
        return num;
    }
    public int getShapeCount(){
        return shapes.size();
    }

    public List<Shape> getShapesByArea(){
        for(int i=0;i<shapes.size()-1;i++){
            int min=i;
            for(int j=i+1;j<shapes.size();j++){
                if(shapes.get(j).area()<shapes.get(min).area()){
                    min=j;
                }
                else if(shapes.get(j).area()==shapes.get(min).area() && shapes.get(j).pattern<shapes.get(min).pattern){
                    min=j;
                }
            }
            if(i!=min){
                Shape shape1=shapes.get(i);
                Shape shape2=shapes.get(min);
                shapes.remove(i);
                shapes.add(i,shape2);
                shapes.remove(min);
                shapes.add(min,shape1);
            }
        }
        return shapes;
    }
    public List<Shape> getShapesByLocation(){
        Collections.sort(shapes);
        return shapes;
    }

    public char[][] getCanvas(){
        return canvas;
    }
}
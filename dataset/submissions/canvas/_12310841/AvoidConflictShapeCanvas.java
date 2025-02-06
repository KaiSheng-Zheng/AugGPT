

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private List<Integer> area;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for(char[] c:canvas){
            Arrays.fill(c, ' ');
        }
        shapes=new ArrayList<>();
        area=new ArrayList<>();
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length==1){
            if(x+2*params[0]<canvas[0].length && y+2*params[0]<canvas.length){
                Shape circle=new Circle(new Location(x,y),pattern,params[0]);
                circle.judgeFull(circle.location,canvas);
                if(!circle.isOverLapconflict()){
                    return false;
                }else {
                    circle.fillGrids(circle.location,canvas);
                    shapes.add(circle);
                    area.add(circle.getArea());
                    return true;
                }
            }else {
                return false;
            }
        }else{
            Direction d = null;
            switch (params[2]){
                case 0:
                    d=Direction.LEFT_UP;
                    break;
                case 2:
                    d=Direction.RIGHT_UP;
                    break;
                case 1:
                    d=Direction.LEFT_DOWN;
                    break;
                case 3:
                    d=Direction.RIGHT_DOWN;
                    break;
            }
            if(x+params[0]<=canvas.length && y+params[1]<=canvas[0].length){
                Shape rightTriangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],d);
                rightTriangle.judgeFull(rightTriangle.location,canvas);
                if(!rightTriangle.judgeFull(rightTriangle.location,canvas)){
                    return false;
                }else{
                    rightTriangle.fillGrids(rightTriangle.location,canvas);
                    shapes.add(rightTriangle);
                    area.add(rightTriangle.getArea());
                    return true;
                }
            }else{
                return false;
            }
        }
//        for(int i=x;x<canvas.length;i++){
//            for(int j=y;j<canvas[0].length;j++){
//                if(canvas[i][j]!=' '){
//                    return false;
//                }else{
//
//                }
//            }
//        }
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for (int i=0;i<canvas.length;i++){
            for (int j = 0; j <canvas[0].length; j++) {
                if(canvas[i][j]!=' '){
                    count+=1;
                }
            }
        }
        return count;
    }
    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if(area.get(i)> area.get(j)){
                    Shape temp1=shapes.get(i);
                    shapes.set(i, shapes.get(j));
                    shapes.set(j,temp1);
                    Integer temp2=area.get(i);
                    area.set(i, area.get(j));
                    area.set(j,temp2);
                }else if(area.get(i).equals(area.get(j))){
                    if(shapes.get(i).pattern> shapes.get(j).pattern){
                        Shape temp1=shapes.get(i);
                        shapes.set(i, shapes.get(j));
                        shapes.set(j,temp1);
                        Integer temp2=area.get(i);
                        area.set(i, area.get(j));
                        area.set(j,temp2);
                    }
                }

            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i+1; j <shapes.size() ; j++) {
                if(shapes.get(i).location.getX()>shapes.get(j).location.getX()){
                    Shape temp1=shapes.get(i);
                    shapes.set(i, shapes.get(j));
                    shapes.set(j,temp1);
                    Integer temp2=area.get(i);
                    area.set(i, area.get(j));
                    area.set(j,temp2);
                } else if (shapes.get(i).location.getX()==shapes.get(j).location.getX()) {
                    if(shapes.get(i).location.getY()>shapes.get(j).location.getY()){
                        Shape temp1=shapes.get(i);
                        shapes.set(i, shapes.get(j));
                        shapes.set(j,temp1);
                        Integer temp2=area.get(i);
                        area.set(i, area.get(j));
                        area.set(j,temp2);
                    } else if (shapes.get(i).location.getY()==shapes.get(j).location.getY()) {
                        if(shapes.get(i).pattern> shapes.get(j).pattern){
                            Shape temp1=shapes.get(i);
                            shapes.set(i, shapes.get(j));
                            shapes.set(j,temp1);
                            Integer temp2=area.get(i);
                            area.set(i, area.get(j));
                            area.set(j,temp2);
                        }
                    }
                }
            }

        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public void setCanvas(char[][] canvas) {
        this.canvas = canvas;
    }
}

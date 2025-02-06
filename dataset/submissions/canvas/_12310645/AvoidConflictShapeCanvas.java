import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.shapes=new ArrayList<Shape>();
        this.canvas=new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                canvas[i][j]=' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length==1){
            if(x+2*params[0]>=canvas.length)return false;
            else if(y+2*params[0]>=canvas[0].length)return false;
            //else if(x-params[0]<-1)return false;
            //else if(y-params[0]<-1)return false;
            else{
                Location loc=new Location(x,y);

                Circle circle=new Circle(loc,pattern,params[0]);
                for (int i = 0; i < circle.getGrids().length; i++) {
                    for (int j = 0; j < circle.getGrids()[0].length; j++) {
                        if(circle.getGrids()[i][j]!=' '&&this.canvas[i+x][j+y]!=' ')return false;
                    }
                }
                this.shapes.add(circle);
                for (int i = 0; i < circle.getGrids().length; i++) {
                    for (int j = 0; j < circle.getGrids()[0].length; j++) {
                        if(circle.getGrids()[i][j]!=' ')this.canvas[i+x][j+y]=pattern;
                    }
                }
                return true;
            }
        }
        else if (params.length==3){
            if(x+params[0]>canvas.length)return false;
            else if(y+params[1]>canvas[0].length)return false;
            //else if(x-params[0]<0)return false;
            //else if(y-params[1]<0)return false;
            else{
                Location loc=new Location(x,y);
                Direction dir=Direction.values()[params[2]];
                RightTriangle rt=new RightTriangle(loc,pattern,params[0],params[1],dir);
                for (int i = 0; i < rt.getGrids().length; i++) {
                    for (int j = 0; j < rt.getGrids()[0].length; j++) {
                        try{
                            if(rt.getGrids()[i][j]!=' '&&this.canvas[i+x][j+y]!=' ')return false;
                        } catch (Exception e) {
                            return false;
                        }

                    }
                }
                this.shapes.add(rt);
                for (int i = 0; i < rt.getGrids().length; i++) {
                    for (int j = 0; j < rt.getGrids()[0].length; j++) {
                        try {
                            if (rt.getGrids()[i][j] != ' ') this.canvas[i + x][j + y] = pattern;
                        }
                        catch (Exception e){
                            return false;
                        }
                    }
                }
                return true;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public int getSpaceGridCount() {
        int count=0;
        for (int i = 0; i < this.canvas.length; i++) {
            for (int j = 0; j < this.canvas[0].length; j++) {
                if(this.canvas[i][j]==' ')count+=1;
            }
        }
        return count;
    }

    @Override
    public int getShapeCount() {
        return this.shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = this.shapes.size()-1; i>0 ; i--) {
            for (int j = 0; j < i; j++) {
                Shape inter;
                if(shapes.get(j).area>shapes.get(j+1).area){
                    inter=shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,inter);
                }
                else if(shapes.get(j).area==shapes.get(j+1).area&&((int)shapes.get(j).getPattern()>(int)shapes.get(j+1).getPattern())){
                    inter=shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,inter);
                }
            }
        }
        return this.shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = this.shapes.size()-1; i>0 ; i--) {
            for (int j = 0; j < i; j++) {
                Shape inter;
                if(shapes.get(j).getLocation().getX()>shapes.get(j+1).getLocation().getX()){
                    inter=shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,inter);
                }
                else if(shapes.get(j).getLocation().getX()==shapes.get(j+1).getLocation().getX()&&shapes.get(j).getLocation().getY()>shapes.get(j+1).getLocation().getY()){
                    inter=shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,inter);
                }
                else if(shapes.get(j).getLocation().getX()==shapes.get(j+1).getLocation().getX()&&shapes.get(j).getLocation().getY()==shapes.get(j+1).getLocation().getY()&&((int)shapes.get(j).getPattern()>(int)shapes.get(j+1).getPattern())){
                    inter=shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,inter);
                }
            }
        }
        return this.shapes;
    }

    @Override
    public char[][] getCanvas() {
        return this.canvas;
    }
}

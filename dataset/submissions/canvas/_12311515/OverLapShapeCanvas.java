import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes = new ArrayList<Shape>();
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        boolean answer = false;
        if(params.length==1){
            for (int i = 0; i < params[0]*2; i++) {
                for (int j = 0; j < params[0]*2; j++) {
                    if((((params[0]-i)*(params[0]-i)+(params[0]-j)*(params[0]-j))<params[0]*params[0])||(((params[0]-1-i)*(params[0]-1-i)+(params[0]-j)*(params[0]-j))<params[0]*params[0])||(((params[0]-i)*(params[0]-i)+(params[0]-1-j)*(params[0]-1-j))<params[0]*params[0])||(((params[0]-1-j)*(params[0]-1-j)+(params[0]-1-i)*(params[0]-1-i))<params[0]*params[0])){
                        if((i+x)<canvas.length&&(j+y)<canvas[0].length){
                            answer = true;
                            canvas[i+x][j+y]=pattern;
                        }
                    }
                }
            }
            Location location = new Location(x,y);
            Circle circle = new Circle(location,pattern,params[0]);
            if (answer == true) this.shapes.add(circle);
        }
        if(params.length==3){
            if(params[2]==0){
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if((j*params[1]+i*params[0])<params[0]*params[1]){
                            if((i+x)<canvas.length&&(j+y)<canvas[0].length) {
                                answer = true;
                                canvas[i+x][j+y]=pattern;
                            }
                        }
                    }
                }
                Location location = new Location(x,y);
                RightTriangle righttriangle = new RightTriangle(location,pattern,params[0],params[1],Direction.LEFT_UP);
                if(answer==true) this.shapes.add(righttriangle);
            }
            if(params[2]==1){
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if((params[0]*(i+1)-params[1]*j)>0){
                            if((i+x)<canvas.length&&(j+y)<canvas[0].length) {
                                canvas[i+x][j+y]=pattern;
                                answer = true;
                            }
                        }
                    }
                }
                Location location = new Location(x,y);
                RightTriangle righttriangle = new RightTriangle(location,pattern,params[0],params[1],Direction.LEFT_DOWN);
                if(answer==true) this.shapes.add(righttriangle);
            }
            if(params[2]==2){
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if((params[0]*i-params[1]*(j+1))<0){
                            if((i+x)<canvas.length&&(j+y)<canvas[0].length) {
                                canvas[i+x][j+y]=pattern;
                                answer = true;
                            }
                        }
                    }
                }
                Location location = new Location(x,y);
                RightTriangle righttriangle = new RightTriangle(location,pattern,params[0],params[1],Direction.RIGHT_UP);
                if(answer==true) this.shapes.add(righttriangle);
            }
            if(params[2]==3){
                for (int i = 0; i < params[1]; i++) {
                    for (int j = 0; j < params[0]; j++) {
                        if(((j+1)*params[1]+(i+1)*params[0])>params[0]*params[1]){
                            if((i+x)<canvas.length&&(j+y)<canvas[0].length) {
                                canvas[i+x][j+y]=pattern;
                                answer = true;
                            }
                        }
                    }
                }
                Location location = new Location(x,y);
                RightTriangle righttriangle = new RightTriangle(location,pattern,params[0],params[1],Direction.RIGHT_DOWN);
                if(answer==true) this.shapes.add(righttriangle);
            }
        }
        return answer;
    }




    @Override
    public int getSpaceGridCount() {
        int numbers=0;
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if(canvas[i][j]==' ') numbers++;
            }
        }
        return numbers;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size()-1; i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if(shapes.get(i).area()>shapes.get(j).area()){
                    Shape exange = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,exange);
                } else if(shapes.get(i).area()==shapes.get(j).area()&&shapes.get(i).pattern>shapes.get(j).pattern) {
                    Shape exange = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,exange);
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size()-1; i++) {
            for (int j = i+1; j < shapes.size(); j++) {
                if(shapes.get(i).location.getX()>shapes.get(j).location.getX()){
                    Shape exange = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,exange);
                } else if(shapes.get(i).location.getX()==shapes.get(j).location.getX()&&shapes.get(i).location.getY()>shapes.get(j).location.getY()) {
                    Shape exange = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,exange);
                } else if (shapes.get(i).location.getX()==shapes.get(j).location.getX()&&shapes.get(i).location.getY()==shapes.get(j).location.getY()&&shapes.get(i).pattern>shapes.get(j).pattern) {
                    Shape exange = shapes.get(i);
                    shapes.set(i,shapes.get(j));
                    shapes.set(j,exange);
                }
            }
        }
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int count=0;
    public AvoidConflictShapeCanvas(int rows, int cols){
        canvas=new char[rows][cols];
        for (int i = 0; i <canvas.length ; i++) {
            for (int j = 0; j <canvas[0].length ; j++) {
                canvas[i][j]=' ';
            }
        }
        shapes=new ArrayList<>();
    }
    public boolean addShape(int x, int y, char pattern, int... params){
        Boolean ifadd=false;
        int count1=0;
        if(x>=0&&y>=0&&x< canvas.length&&y<canvas[0].length){
            ifadd = true;
        if(params.length==1){
            count1=0;
            Circle circle=new Circle(new Location(x,y),pattern,params[0]);
            for (int i = 0; i <circle.getGrids().length ; i++) {
                for (int j = 0; j <circle.getGrids()[0].length ; j++) {
                        try{
                            if(circle.getGrids()[i][j]==pattern&&canvas[i+x][j+y]==' '){
                                count1++;
                            }
                    }catch (ArrayIndexOutOfBoundsException e){
                            ifadd=false;
                            break;
                        }
                }
                if(ifadd==false){
                    break;
                }
            }
            if(count1!= circle.area()){
                ifadd=false;
            }
            if(ifadd==true){
                count++;
                shapes.add(circle);
                for (int i = 0; i <circle.getGrids().length ; i++) {
                    for (int j = 0; j <circle.getGrids()[0].length ; j++) {
                        if (circle.getGrids()[i][j] == pattern)
                        {
                            canvas[i+x][j+y]=circle.getGrids()[i][j];
                        }
                    }
                }
            }
        }else{
            count1=0;
            RightTriangle triangle=null;
            switch (params[2]){
                case 0:
                    triangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.LEFT_UP);
                    break;
                case 1:
                    triangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.LEFT_DOWN);
                    break;
                case 2:
                    triangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.RIGHT_UP);
                    break;
                case 3:
                    triangle=new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.RIGHT_DOWN);
                    break;
            }
            for(int i=0;i<triangle.getGrids().length;i++){
                for (int j = 0; j <triangle.getGrids()[0].length ; j++) {
                        try{if(triangle.getGrids()[i][j]==pattern&&canvas[i+x][j+y]==' '){
                            count1++;}
                        }catch (ArrayIndexOutOfBoundsException e){
                            ifadd=false;
                            break;
                        }

                }
                if(ifadd==false){
                    break;
                }
            }
            if(count1!= triangle.area()){
                ifadd=false;
            }
            if(ifadd==true){
                count++;
                shapes.add(triangle);
                for(int i=0;i<triangle.getGrids().length;i++){
                    for (int j = 0; j <triangle.getGrids()[0].length ; j++) {
                        if(triangle.getGrids()[i][j]==pattern)
                        canvas[i+x][j+y]=triangle.getGrids()[i][j];
                    }
            }
            }

        }
        }

        return ifadd;
    }

    @Override
    public int getSpaceGridCount() {
        int count1 =0;
        for (int i = 0; i <canvas.length ; i++) {
            for (int j = 0; j < canvas[0].length ; j++) {
                if(canvas[i][j]==' '){
                    count1++;
                }
            }
        }
        return count1;
    }

    @Override
    public int getShapeCount() {
        return count;
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i <shapes.size()-1 ; i++) {
            for (int j = 0; j <shapes.size()-1-i ; j++) {
                if(shapes.get(j).area()>shapes.get(j+1).area){
                    Shape temp = shapes.get(j + 1);
                    shapes.set(j+1, shapes.get(j));
                    shapes.set(j, temp);
                }else if(shapes.get(j).area()==shapes.get(j+1).area&&shapes.get(j).pattern>shapes.get(j+1).pattern){
                    Shape temp = shapes.get(j + 1);
                    shapes.set(j+1, shapes.get(j));
                    shapes.set(j, temp);
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i <shapes.size()-1 ; i++) {
            for (int j = 0; j < shapes.size() - 1 - i; j++) {
                if (shapes.get(j).location.getX() > shapes.get(j + 1).location.getX()) {
                    Shape temp = shapes.get(j + 1);
                    shapes.set(j+1, shapes.get(j));
                    shapes.set(j, temp);
                } else if (shapes.get(j).location.getX() == shapes.get(j + 1).location.getX() && shapes.get(j).location.getY() > shapes.get(j + 1).location.getY()) {
                    Shape temp = shapes.get(j + 1);
                    shapes.set(j+1, shapes.get(j));
                    shapes.set(j, temp);
                } else if (shapes.get(j).location.getX() == shapes.get(j + 1).location.getX() && shapes.get(j).location.getY() == shapes.get(j + 1).location.getY() && shapes.get(j).pattern > shapes.get(j + 1).pattern) {
                    Shape temp = shapes.get(j + 1);
                    shapes.set(j+1, shapes.get(j));
                    shapes.set(j, temp);
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

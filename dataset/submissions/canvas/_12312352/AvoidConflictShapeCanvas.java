import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        this.shapes=new ArrayList<>();
        //Arrays.fill(canvas,' ');
        this.canvas=new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Location location=new Location(x,y);
        Shape aShape;
        if (params.length==1){
            aShape=new Circle(location,pattern,params[0]);
        }else {
            aShape=new RightTriangle(location,pattern,params[0],params[1],Direction.values()[params[2]]);
        }
        for (int i = 0; i < aShape.getGrids().length; i++){
            for (int j = 0; j < aShape.getGrids()[i].length; j++) {
                if (x+i>= canvas.length)return false;
                if (y+j>= canvas[0].length)return false;
                if ((aShape.getGrids()[i][j]!=' '&&((x+i)>= canvas.length||x+i<0))||(aShape.getGrids()[i][j]!=' '&&((y+j)>= canvas[0].length||y+j<0)))return false;
                if (aShape.getGrids()[i][j]!=' '&&canvas[x+i][y+j]!=' ')return false;
            }
        }
        for (int i = 0; i < aShape.getGrids().length; i++) {
            for (int j = 0; j < aShape.getGrids()[i].length; j++) {
                if (aShape.getGrids()[i][j]!=' '){
                    canvas[i+x][j+y]=aShape.getGrids()[i][j];
                }
            }
        }
        shapes.add(aShape);
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        int sum=0;
        /*for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++) {
                if (canvas[i][j]==' ') sum++;
            }
        }*/
        for (char[] canva : this.canvas) {
            for (int j = 0; j < this.canvas[0].length; j++) {
                if (canva[j]==' ') sum++;
            }
        }
        return sum;
    }

    @Override
    public int getShapeCount() {
        int a=shapes.size();
        /*int sum=0;
        for (char[] canva : this.canvas) {
            for (int j = 0; j < this.canvas[0].length; j++) {
                if (canva[j] != ' ') sum++;
            }
        }
        return sum;*/
        return  a;
    }

    @Override
    public List<Shape> getShapesByArea() {
        int[] number=new int[shapes.size()];
        int[] numberTest=new int[shapes.size()];
        for (int i = 0; i < shapes.size(); i++) {
            numberTest[i]=shapes.get(i).area();
            number[i]=i;
        }
        int middle;
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length-i-1; j++) {
                if(numberTest[j]>numberTest[j+1]){
                    middle=number[j+1];
                    number[j+1]=number[j];
                    number[j]=middle;

                    middle=numberTest[j+1];
                    numberTest[j+1]=numberTest[j];
                    numberTest[j]=middle;
                }
            }
        }
        int a;
        for (int j = 0; j < number.length; j++) {
        for (int i = 0; i < number.length-1; i++) {
            if (numberTest[i]==numberTest[i+1]){
                if(shapes.get(number[i]).pattern>shapes.get(number[i+1]).pattern){
                    a=number[i+1];
                    number[i+1]=number[i];
                    number[i]=a;

                    a=numberTest[i+1];
                    numberTest[i+1]=numberTest[i];
                    numberTest[i]=a;
                }
            }
        }
        }
        for (int i = 0; i < number.length-1; i++) {
            if (numberTest[i]==numberTest[i+1]){
            if (shapes.get(number[i]).pattern==6&&shapes.get(number[i+1]).pattern==5){
                a=number[i+1];
                number[i+1]=number[i];
                number[i]=a;
            }
            }
        }
        List<Shape> shapeTwo=new ArrayList<>();
        for (int i = 0; i <number.length ; i++) {
            shapeTwo.add(shapes.get(number[i]));
        }
        return shapeTwo;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        int[][] number=new int[2][shapes.size()];
        int[] numberTwo=new int[shapes.size()];
        for (int i = 0; i < shapes.size(); i++) {
            numberTwo[i]=i;
        }

        for (int i = 0; i <shapes.size() ; i++) {
            number[0][i]=shapes.get(i).location.getX();
            number[1][i]=shapes.get(i).location.getY();
        }
        int middle;
        for (int i = 0; i < number[0].length; i++) {
            for (int j = 0; j < number[0].length-i-1; j++) {
                if(number[0][j]>number[0][j+1]){
                    middle=number[0][j+1];
                    number[0][j+1]=number[0][j];
                    number[0][j]=middle;

                    middle=number[1][j+1];
                    number[1][j+1]=number[1][j];
                    number[1][j]=middle;

                    middle=numberTwo[j+1];
                    numberTwo[j+1]=numberTwo[j];
                    numberTwo[j]=middle;
                }
            }
        }
        int a;
        for (int i = 0; i < number[0].length; i++) {
            for (int j = 0; j < number[0].length-1; j++) {
                if(number[0][j]==number[0][j+1]){
                    if (number[1][j]>number[1][j+1]){
                        a=numberTwo[j+1];
                        numberTwo[j+1]=numberTwo[j];
                        numberTwo[j]=a;

                        middle=number[1][j+1];
                        number[1][j+1]=number[1][j];
                        number[1][j]=middle;
                    }
                    else if (number[1][j]==number[1][j+1]){
                        int k=numberTwo[j];
                        int l=numberTwo[j+1];
                        if (shapes.get(k).pattern>shapes.get(l).pattern){
                            a=numberTwo[j+1];
                            numberTwo[j+1]=numberTwo[j];
                            numberTwo[j]=a;
                        }
                    }
                }
            }
        }
        /*for (int i = 0; i < number[0].length-1; i++) {
            if (number[0][i]==number[0][i+1]){
                if (number[1][i]>number[1][i+1]){
                    a=numberTwo[i+1];
                    numberTwo[i+1]=numberTwo[i];
                    numberTwo[i]=a;

                    middle=number[1][i+1];
                    number[1][i+1]=number[1][i];
                    number[1][i]=middle;
                }
                else if (number[1][i]==number[1][i+1]){
                    if (shapes.get(i).pattern>shapes.get(i+1).pattern){
                        a=numberTwo[i+1];
                        numberTwo[i+1]=numberTwo[i];
                        numberTwo[i]=a;
                    }
                }
            }
        }*/
        List<Shape> shapeTwo=new ArrayList<>();
        for (int i = 0; i <number[0].length ; i++) {
            shapeTwo.add(shapes.get(numberTwo[i]));
        }
        return shapeTwo;
    }
    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

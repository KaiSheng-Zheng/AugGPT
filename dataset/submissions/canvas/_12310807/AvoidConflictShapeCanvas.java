import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {

    private ArrayList<Shape> shapes;
    private char[][] canvas;
    int width;
    int height;
    int countOfShape =0;
    public AvoidConflictShapeCanvas(int height,int width){
        this.width=width;
        this.height=height;
        canvas = new char[height][width];
        shapes = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = ' ';
            }
        }
    }


    @Override
    public boolean addShape(int x, int y, char pattern, int params) {//for circle
        char[][] originalCanvas = new char[height][width];
        for (int i = 0; i < height; i++) {
            System.arraycopy(canvas[i], 0, originalCanvas[i], 0, width);
        }
        Circle circle = new Circle(new Location(x,y),pattern,params);
        int r = params;
        char[][] circlewithoutlocation = circle.getGrids();
        if(x>=0&&x+2*r<=width&&y>=0&&y+2*r<=height){
            for (int i = 0; i < 2*r; i++) {
                for (int j = 0; j < 2*r; j++) {
                    if(circlewithoutlocation[i][j]!=' '){
                        if(canvas[i+x][j+y]!=' '){//bugs may occur here
                            canvas = originalCanvas;
                            return false;
                        }
                        else canvas[i+x][j+y]=pattern;
                    }
                }
            }
            countOfShape++;
            shapes.add(circle);
            return true;
        }
        return false;
    }

    public boolean addShape(int x,int y,char pattern,int widthoftriangle,int heightoftriangle,int indexofdirection) {//for right triangle

        Direction d;
        if (indexofdirection == 0) {
            d = Direction.LEFT_UP;
        } else if (indexofdirection == 1) {
            d = Direction.LEFT_DOWN;
        } else if (indexofdirection == 2) {
            d = Direction.RIGHT_UP;
        } else {
            d = Direction.RIGHT_DOWN;
        }
        RightTriangle rightTriangle = new RightTriangle(new Location(x, y), pattern, widthoftriangle, heightoftriangle, d);
        char[][] originalCanvas = new char[height][width];
        for (int i = 0; i < height; i++) {
            System.arraycopy(canvas[i], 0, originalCanvas[i], 0, width);
        }
        char[][] rightTrianglewithoutlocaion = rightTriangle.getGrids();//generate a char[height][width]
        if(x>=0&&x+heightoftriangle<=this.height&&y>=0&&y+widthoftriangle<=this.width){
            for (int i = 0; i < heightoftriangle; i++) {
                for (int j = 0; j < widthoftriangle; j++) {
                    if(rightTrianglewithoutlocaion[i][j]!=' '){
                        if(canvas[x+i][y+j]!=' '){
                            canvas=originalCanvas;
                            return false;
                        }
                        canvas[x+i][y+j]=pattern;
                    }
                }
            }
            countOfShape++;
            shapes.add(rightTriangle);
            return true;
        }
        return false;
    }

    @Override
    public int getSpaceGridCount() {
        int counter=0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(canvas[i][j]==' '){
                    counter++;
                }
            }
        }
        return counter;
    }

    @Override
    public int getShapeCount() {
        return countOfShape;
    }

    @Override
    public List<Shape> getShapesByArea() {
        Collections.sort(shapes,new ShapeComparatorForArea());
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        Collections.sort(shapes,new ShapeComparatorForLocation());
        return shapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public void printCanvas(){
        for(char[] row: canvas){
            for (char c:row){
                System.out.printf(c+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

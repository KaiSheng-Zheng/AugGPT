import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.lang.Math;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    public OverLapShapeCanvas(int rows, int cols){
        canvas = new char [rows][cols];
        for (int i = 0; i <canvas.length ; i++) {
            for (int j = 0; j <canvas[0].length ; j++) {
                canvas [i][j]=' ';
            }
        }
    }

    
    public boolean addShape(int x, int y, char pattern, int... params) {
        if (params.length==1){
            Shape circle = new Circle(new Location(x,y),pattern,params[0]);

                int n = 0;
                for (int i = 0; i < Math.min(circle.getGrids().length,canvas.length); i++) {
                    for (int j = 0; j < Math.min(circle.getGrids()[0].length,canvas[0].length); j++) {
                        if ( circle.getGrids()[i][j]==pattern){
                            canvas[i][j]=circle.getGrids()[i][j];
                            n++;
                        }
                    }
                }
                for (int i = 0; i < Math.min(circle.getGrids().length,canvas.length); i++) {
                    for (int j = 0; j < Math.min(circle.getGrids()[0].length,canvas[0].length); j++) {
                        if (n==0){
                            return false;
                        }
                    }
                }
                shapes.add(circle);

        }
        if (params.length==3){
            Shape triangle = new RightTriangle(new Location(x,y),pattern,params[0],params[1],Direction.values()[params[2]]);

                int n = 0;
                for (int i = 0; i < Math.min(triangle.getGrids().length,canvas.length); i++) {
                    for (int j = 0; j < Math.min(triangle.getGrids()[0].length,canvas[0].length); j++) {
                        if (triangle.getGrids()[i][j]==pattern){
                            canvas[i][j]=triangle.getGrids()[i][j];
                            n++;
                        }
                    }
                }
                for (int i = 0; i < Math.min(triangle.getGrids().length,canvas.length); i++) {
                    for (int j = 0; j < Math.min(triangle.getGrids()[0].length,canvas[0].length); j++) {
                        if (n==0){
                            return false;
                        }
                    }
                }
                shapes.add(triangle);
            }

        return true;
    }

    
    public int getSpaceGridCount() {
        return canvas.length*canvas[0].length;
    }

    
    public int getShapeCount() {
        return shapes.size();
    }

    
    public List<Shape> getShapesByArea() {
        List<Shape> areagrid = new ArrayList<>();
        for (int i = 0; i < shapes.size(); i++) {
            areagrid.add(shapes.get(i)) ;
        }
        Collections.sort(areagrid,(a1, a2)-> {
            if (a1.area() == a2.area()){
                return Integer.compare(a1.pattern, a2.pattern);
            }
            return Integer.compare(a1.area(), a2.area());});
        return areagrid;
    }

    
    public List<Shape> getShapesByLocation() {
        List<Shape> shapegrid= new ArrayList<>();
        for (int i = 0; i < shapes.size(); i++) {
            shapegrid.add(shapes.get(i)) ;
        }
        Comparator<Shape> comparator = Comparator.comparingInt(Shape::getLocationX).thenComparing(Shape::getLocationY).thenComparing(Shape::getPattern);
        Collections.sort(shapegrid,comparator);
        return shapegrid;
    }

    
    public char[][] getCanvas() {
        return canvas;
    }

    public static void main(String[] args) {
        var c = new OverLapShapeCanvas(12, 16);
        c.addShape(2, 2, 'F', 3, 5, 0);
        for (int i = 0; i < c.getCanvas().length; i++) {
            for (int j = 0; j < c.getCanvas()[0].length; j++) {
                System.out.printf("%S",c.getCanvas()[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.println(c.getShapeCount());
        Shape triangle = new RightTriangle(new Location(2,2),'F',3,5,Direction.values()[0]);
        for (int i = 0; i < triangle.getGrids().length; i++) {
            for (int j = 0; j < triangle.getGrids()[0].length; j++) {
                System.out.printf("%S",triangle.getGrids()[i][j]);
            }
            System.out.printf("\n");
        }
    }
}

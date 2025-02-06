
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rowsCanvas;
    private int colsCanvas;
    public AvoidConflictShapeCanvas(int rows, int cols){
        rowsCanvas = rows;
        colsCanvas = cols;
        
        shapes = new ArrayList<>();
      
        canvas = new char[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        int shapeHeight=0;
        int shapeWidth=0;
        int i=0;
        int j=0;
        if(1==params.length){
            shapeHeight = params[0]*2;
            shapeWidth = params[0]*2;

            
            if((x<0)||(x>rowsCanvas)||(x+shapeHeight<0)||(x+shapeHeight>rowsCanvas)||(y<0)||(y>colsCanvas)||(y+shapeWidth<0)||(y+shapeWidth>colsCanvas)){
                return false;
            }

            
            Location p1 = new Location(x, y);
            Shape s1 = new Circle(p1, pattern, params[0]);
            char[][] grids = s1.getGrids();

            
            for(i=0;i<shapeHeight;i++) {
                for (j = 0; j < shapeWidth; j++) {
                    if((' '!=grids[i][j])&&(' '!=canvas[i+x][j+y])) {
                        s1=null;
                        return false;
                    }
                }
            }

            
            for(i=0;i<shapeHeight;i++) {
                for (j = 0; j < shapeWidth; j++) {
                    if(' '!=grids[i][j]) {
                        canvas[i + x][j + y] = grids[i][j];
                    }
                }
            }

           
            shapes.add(s1);
        }else if(3==params.length){
            shapeHeight = params[1];
            shapeWidth = params[0];

            
            if((x<0)||(x>rowsCanvas)||(x+shapeHeight<0)||(x+shapeHeight>rowsCanvas)||(y<0)||(y>colsCanvas)||(y+shapeWidth<0)||(y+shapeWidth>colsCanvas)){
                return false;
            }

            
            Location p1 = new Location(x, y);
            Shape s1 = new RightTriangle(p1, pattern, params[0], params[1], Direction.values()[params[2]]);
            char[][] grids = s1.getGrids();

            
            for(i=0;i<shapeHeight;i++) {
                for (j = 0; j < shapeWidth; j++) {
                    if((' '!=grids[i][j])&&(' '!=canvas[i+x][j+y])) {
                        s1=null;
                        return false;
                    }
                }
            }

            
            for(i=0;i<shapeHeight;i++) {
                for (j = 0; j < shapeWidth; j++) {
                    if(' '!=grids[i][j]) {
                        canvas[i + x][j + y] = grids[i][j];
                    }
                }
            }

            
            shapes.add(s1);
        }else{
            return false;
        }

        return true;
    }
    @Override
    public int getSpaceGridCount(){
        int spaceGridCount=0;
        for(int i=0;i<rowsCanvas;i++){
            for(int j=0;j<colsCanvas;j++){
                if(' '==canvas[i][j]) {
                    spaceGridCount++;
                }
            }
        }
        return spaceGridCount;
    }
    @Override
    public int getShapeCount(){
        return shapes.size();
    }
    @Override
    public List<Shape> getShapesByArea(){
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Integer.compare(s1.pattern, s2.pattern); 
            }
        });

        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Integer.compare(s1.area(), s2.area()); 
            }
        });
        return shapes;
    }
    @Override
    public List<Shape> getShapesByLocation(){
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Integer.compare(s1.pattern, s2.pattern);
            }
        });
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Integer.compare(s1.location.getY(), s2.location.getY()); 
            }
        });
        Collections.sort(shapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape s1, Shape s2) {
                return Integer.compare(s1.location.getX(), s2.location.getX()); 
            }
        });
        return shapes;
    }
    @Override
    public char[][] getCanvas(){
        return canvas;
    }
}



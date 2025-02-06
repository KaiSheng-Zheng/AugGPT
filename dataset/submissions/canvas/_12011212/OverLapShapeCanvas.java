import java.util.*;
public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<Shape>();
    private char[][] canvas;
    private int rows;
    private int cols;
    public OverLapShapeCanvas(int rows,int cols){
        this.rows=rows;
        this.cols=cols;
        canvas=new char[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                canvas[i][j]=' ';
    }

    public boolean addShape(int x, int y, char pattern, int... params){
        if(!CheckPartInBoundary(x,y,params))return false;
        Location InputLocation=new Location(x, y);
        if(params.length==1){
            shapes.add(new Circle(InputLocation,pattern,params[0]));
            return true;
        }
        else{
            int width=params[0];
            int height=params[1];
            Direction d=Direction.LEFT_UP;
            switch (params[2]) {
                case 0:
                    d=Direction.LEFT_UP;
                    break;
                case 1:
                    d=Direction.LEFT_DOWN;
                    break;
                case 2:
                    d=Direction.RIGHT_UP;
                    break;
                case 3:
                    d=Direction.RIGHT_DOWN;
                    break;
            }
            shapes.add(new RightTriangle(InputLocation,pattern,width,height,d));
            return true;
        }
    }

    private boolean CheckPointOutOfBoundary(int x,int y){
        return((x<0)||(y<0)||(x>=this.rows)||(y>=this.cols))?false:true;
    }

    private boolean CheckPartInBoundary(int x,int y,int... params){
        Shape CheckingShape;
        Location CheckingLocation=new Location(x, y);
        if(params.length==1){
            int radius=params[0];
            CheckingShape=new Circle(CheckingLocation,'*',radius);
            char[][] CheckingGrids=CheckingShape.getGrids();
            System.out.println("Mark");
            for(int i=0;i<2*radius;i++)
                for(int j=0;j<2*radius;j++)
                    if((CheckingGrids[i][j]=='*')&&(CheckPointOutOfBoundary(x+i,y+j)))return true;
            return false;
        }
        if(params.length==3){
            int width=params[0];
            int height=params[1];
            Direction d=Direction.LEFT_UP;
            switch (params[2]) {
                case 0:
                    d = Direction.LEFT_UP;
                    break;
                case 1:
                    d = Direction.LEFT_DOWN;
                    break;
                case 2:
                    d = Direction.RIGHT_UP;
                    break;
                case 3:
                    d = Direction.RIGHT_DOWN;
                    break;
            }
            CheckingShape=new RightTriangle(CheckingLocation,'*',width,height,d);
            char[][] CheckingGrids=CheckingShape.getGrids();
            for(int i=0;i<height;i++)
                for(int j=0;j<width;j++)
                    if((CheckingGrids[i][j]=='*')&&(CheckPointOutOfBoundary(x+i,y+j)))return true;
            return false;
        }
        return false;
    }

    public int getShapeCount(){
        return this.shapes.size();
    }

    public List<Shape> getShapesByArea(){
        List<Shape> OutputShapes=new ArrayList<Shape>();
        for(int i=0;i<shapes.size();i++)
            OutputShapes.add(shapes.get(i));
        Collections.sort(OutputShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if((o1.area()<o2.area())||((o1.area()==o2.area())&&(o1.getPattern()<o2.getPattern())))return -1;
                if((o1.area()>o2.area())||((o1.area()==o2.area())&&(o1.getPattern()>o2.getPattern())))return 1;
                return 0;
            }
        });
        return OutputShapes;
    }

    public List<Shape> getShapesByLocation(){
        List<Shape> OutputShapes=new ArrayList<Shape>();
        for(int i=0;i<shapes.size();i++)
            OutputShapes.add(shapes.get(i));
        Collections.sort(OutputShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                if(o1.getLocation().getX()<o2.getLocation().getX())return -1;
                if(o1.getLocation().getX()>o2.getLocation().getX())return 1;
                if(o1.getLocation().getY()<o2.getLocation().getY())return -1;
                if(o1.getLocation().getY()>o2.getLocation().getY())return 1;
                if(o1.getPattern()<o2.getPattern())return -1;
                if(o1.getPattern()>o2.getPattern())return 1;
                return 0;
            }
        });
        return OutputShapes;
    }

    public char[][] getCanvas(){

        for(int i=0;i<shapes.size();i++){
            Shape ithShape=shapes.get(i);
            Location ithLocation=ithShape.getLocation();
            char[][] ithGrids=ithShape.getGrids();
            for(int j=0;j<ithGrids.length;j++)
                for(int k=0;k<ithGrids[j].length;k++){
                    if(!CheckPointOutOfBoundary(ithLocation.getX()+j,ithLocation.getY()+k))continue;
                    if(ithGrids[j][k]==' ')continue;
                    canvas[ithLocation.getX()+j][ithLocation.getY()+k]=ithGrids[j][k];
                }
        }
        return canvas;
    }

    public int getSpaceGridCount(){
        char[][] CanvasForCalcalate=this.getCanvas();
        int Count=0;
        for(int i=0;i<this.rows;i++)
            for(int j=0;j<this.cols;j++)
                Count+=(CanvasForCalcalate[i][j]==' ')?1:0;
        return Count;
    }
}

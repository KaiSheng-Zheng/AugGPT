import java.util.*;
public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<Shape>();
    private char[][] canvas;
    private int rows;
    private int cols;
    public AvoidConflictShapeCanvas(int rows,int cols){
        this.rows=rows;
        this.cols=cols;
        canvas=new char[rows][cols];
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                canvas[i][j]=' ';
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {

        if(!CheckOutOfBoundary(x,y,params))return false;
        //System.out.println("Mark");
        if(!CheckOverlap(x,y,params))return false;
        Location InputLocation=new Location(x,y);
        if(params.length==1){
            int radius=params[0];
            shapes.add(new Circle(InputLocation,pattern,radius));
        }
        if(params.length==3){
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
        }
        return true;
    }

    private boolean CheckOutOfBoundary(int x,int y,int... params){
        if(params.length==1){
            int[] mx={0,2,0,2};
            int[] my={0,0,2,2};
            for(int i=0;i<4;i++){
                if(!CheckPointOutOfBoundary(x+mx[i]*params[0],y+my[i]*params[0]))return false;
            }
            return true;
        }
        if(params.length==3){
            int width=params[0];
            int height=params[1];
            return(CheckPointOutOfBoundary(x,y)&&CheckPointOutOfBoundary(x+height-1,y)&&CheckPointOutOfBoundary(x,y+width-1)&&CheckPointOutOfBoundary(x+height-1,y+width-1));
        }
        return true;
    }

    private boolean CheckPointOutOfBoundary(int x,int y){
        return((x<0)||(y<0)||(x>=this.rows)||(y>=this.cols))?false:true;
    }

    private  boolean CheckOverlap(int x,int y,int... params){
        if(shapes==null)return true;
        int [][] field=new int[this.rows][this.cols];
        for(int i=0;i<this.rows;i++)
            for(int j=0;j<this.cols;j++)
                field[i][j]=0;
        for(int i=0;i<shapes.size();i++){
            Shape ithShape=shapes.get(i);
            //System.out.println(ithShape);
            Location ithLocation=ithShape.getLocation();
            char[][] ithGrids=ithShape.getGrids();
            for(int j=0;j<ithGrids.length;j++)
                for(int k=0;k<ithGrids[j].length;k++){
                    field[ithLocation.getX()+j][ithLocation.getY()+k]+=(ithGrids[j][k]==' ')?0:1;
                    if(field[ithLocation.getX()+j][ithLocation.getY()+k]>1)return false;
                }
        }
        Shape ShapeInCheck;
        Location LocationInCheck=new Location(x, y);
        if(params.length==1)ShapeInCheck=new Circle(LocationInCheck,'*',params[0]);
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
            ShapeInCheck=new RightTriangle(LocationInCheck,'*',width,height,d);
        }
        Location ithLocation=ShapeInCheck.getLocation();
        char[][] ithGrids=ShapeInCheck.getGrids();
        for(int j=0;j<ithGrids.length;j++)
            for(int k=0;k<ithGrids[j].length;k++){
                field[ithLocation.getX()+j][ithLocation.getY()+k]+=(ithGrids[j][k]==' ')?0:1;
                if(field[ithLocation.getX()+j][ithLocation.getY()+k]>1)return false;
            }
        /*
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++)
                System.out.printf("%d",field[i][j]);
            System.out.printf("\n");
        }*/
        //System.out.println("-------------");
        return true;
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


import java.util.ArrayList;
import java.util.List;

public class AvoidConflictShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;
    private char[][] canvas;
    private int rows=0;
    private int cols=0;
    private int cgdtj=0;
    private Circle circle;
    private RightTriangle rightTriangle;
    private Location location;


    public AvoidConflictShapeCanvas(int rows, int cols){
        shapes = new ArrayList<Shape>();
      this.rows=rows;
      this.cols=cols;
      canvas=new char[rows][cols];
      for(int i=0;i<rows;i++){
          for(int j=0;j<cols;j++){
              canvas[i][j]= ' ';
          }
      }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        location=new Location(x,y);
        char[][] grids;
        char[][] crids;


        if(params.length==1){
            boolean trp=true;
           circle=new Circle(location,pattern,params[0]);
           circle.fillGrids();
           grids =circle.getGrids();
           for(int i=0;i<2*params[0];i++){
               for(int j=0;j<2*params[0];j++){
                  if(grids[i][j]==pattern){
                      if(x+i>rows-1||y+j>cols-1||x+i<0||y+j<0){
                          trp=false;
                      }
                  }
               }
           }
           if(trp){
           for(int i=0;i<2*params[0];i++){
               for(int j=0;j<2*params[0];j++){
                   if(grids[i][j]==pattern){
                   if(canvas[x+i][y+j]!=' '){
                       trp=false;
                   }
               }
           }}}
           if(trp){
               for(int i=0;i<2*params[0];i++){
                   for(int j=0;j<2*params[0];j++){
                       if(grids[i][j]==pattern){

                           canvas[x+i][y+j]=pattern;}

                   }
               }  cgdtj++;
               shapes.add(circle);
               return true;
           }else {return false;}

        }

        else if(params.length==3){
            boolean trp=true;
            Direction d = null;
            switch (params[2]){
                case 0: d=Direction.LEFT_UP;break;
                case 1: d=Direction.LEFT_DOWN;break;
                case 2: d=Direction.RIGHT_UP;break;
                case 3: d=Direction.RIGHT_DOWN;break;
            }
            rightTriangle=new RightTriangle(location,pattern,params[0],params[1],d);
            rightTriangle.fillGrids();
            crids =rightTriangle.getGrids();
            for(int i=0;i<params[1];i++){
                for(int j=0;j<params[0];j++){
                    if(crids[i][j]==pattern){
                        if((x+i>rows-1)||(y+j>cols-1)||(x+i<0)||(y+j<0)){
                            /*System.out.println(x);
                            System.out.println(y);
                            System.out.printf("%d %d\n",cols,rows);*/
                            trp=false;
                        }
                    }
                }
            }
            if(trp){
            for(int i=0;i<params[1];i++){
                for(int j=0;j<params[0];j++){
                    if(crids[i][j]==pattern){
                    if(canvas[x+i][y+j]!=' '){
                        trp=false;
                    }}
                }
            }}
            if(trp){
                for(int i=0;i<params[1];i++){
                    for(int j=0;j<params[0];j++){
                        if(crids[i][j]==pattern){
                            canvas[x+i][y+j]=pattern;}}}
                cgdtj++;
                shapes.add(rightTriangle);
                return true;}
            else {
                return false;}
        }
        return false;
    }

    public int getSpaceGridCount(){
        int gg=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(canvas[i][j]!=' '){
                    gg++;
                }
            }
        }

        return rows*cols-gg;
    };

    public int getShapeCount(){
        return cgdtj;
    };

    public List<Shape> getShapesByArea(){
        for(int i=0;i<shapes.toArray().length;i++){
            for(int j=0;j<shapes.toArray().length-1-i;j++){
                if(shapes.get(j).area() > shapes.get(j + 1).area()){
                    Shape temp=shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,temp);
                }else if(shapes.get(j).area() == shapes.get(j + 1).area()){
                    int U=shapes.get(j).pattern;
                    int V=shapes.get(j+1).pattern;
                    if(U>V){
                        Shape temp=shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }}
            }
        }
        return shapes;
    };

    public List<Shape> getShapesByLocation(){
        for(int i=0;i<shapes.toArray().length;i++){
            for(int j=0;j<shapes.toArray().length-1-i;j++){
                if(shapes.get(j).location.getX()> shapes.get(j + 1).location.getX()){
                    Shape temp=shapes.get(j);
                    shapes.set(j,shapes.get(j+1));
                    shapes.set(j+1,temp);
                }else if (shapes.get(j).location.getX()==shapes.get(j + 1).location.getX()){
                    if(shapes.get(j).location.getY()>shapes.get(j + 1).location.getY()){
                        Shape temp=shapes.get(j);
                        shapes.set(j,shapes.get(j+1));
                        shapes.set(j+1,temp);
                    }else if (shapes.get(j).location.getY()==shapes.get(j + 1).location.getY()){
                        int U=shapes.get(j).pattern;
                        int V=shapes.get(j+1).pattern;
                        if(U>V){
                            Shape temp=shapes.get(j);
                            shapes.set(j,shapes.get(j+1));
                            shapes.set(j+1,temp);
                        }
                    }
                }
            }
        }
        return shapes;
    };

    public char[][] getCanvas(){
        return canvas;
    };

}

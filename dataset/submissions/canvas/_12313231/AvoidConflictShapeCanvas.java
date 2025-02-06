import java.util.*;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private ArrayList<Shape>tempshaps;
    private char[][] canvas;

    public void setCanvas(char[][] canvas) {
        this.canvas = canvas;
    }

    public AvoidConflictShapeCanvas(int rows, int cols){
       tempshaps=new ArrayList<Shape>();
        canvas=new char[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                canvas[i][j]=' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        int error=0;
        if(params.length==1){
            if(x+2*params[0]>canvas.length||y+2*params[0]>canvas[0].length){
            return false;
            }else {
            Circle cir=new Circle(new Location(x,y),pattern,params[0]);
            for(int line=0;line<2*params[0];line++){
                for (int col=0;col<2*params[0];col++){
                    if(cir.getGrids()[line][col]==pattern){
                        if(canvas[line+x][col+y]!=' ') {
                        error++;
                        }
                    }
                }
            }
            if (error==0){
                for(int line=0;line<cir.getGrids().length;line++){
                    for (int col=0;col<cir.getGrids()[0].length;col++){
                        if(cir.getGrids()[line][col]==pattern){
                            if(canvas[line+x][col+y]==' '){
                                canvas[line+x][col+y]=pattern;
                            }
                        }
                    }
                }tempshaps.add(cir);
            return true;
            }else return false;
        }
        }else {Direction d = null;
            if(params[2]==0){d=Direction.LEFT_UP;}
            if(params[2]==1){d=Direction.LEFT_DOWN;}
            if(params[2]==2){d=Direction.RIGHT_UP;}
            if(params[2]==3){d=Direction.RIGHT_DOWN;}

            if(x+params[1]>canvas.length||y+params[0]>canvas[0].length){
                return false;
            }else {
            RightTriangle cir=new RightTriangle(new Location(x,y),pattern,params[0],params[1],d);
            for(int line=0;line<cir.getGrids().length;line++){
                for (int col=0;col<cir.getGrids()[0].length;col++){
                    if(cir.getGrids()[line][col]==pattern){
                        if(canvas[line+x][col+y]==' '){
                        }else error++;
                    }
                }
            }
            if (error==0){
                for(int line=0;line<cir.getGrids().length;line++){
                    for (int col=0;col<cir.getGrids()[0].length;col++){
                        if(cir.getGrids()[line][col]==pattern){
                            if(canvas[line+x][col+y]==' '){
                                canvas[line+x][col+y]=pattern;
                            }
                        }
                    }
                }tempshaps.add(cir);
                return true;
            }else return false;
        }}

        }


    @Override
    public int getSpaceGridCount() {
        int count=0;
        for(int line=0;line<canvas.length;line++){
            for (int col=0;col<canvas[0].length;col++){
                if(canvas[line][col]==' '){
                    count++;
                }
            }
        }return count;
    }

    @Override
    public int getShapeCount() {
        return tempshaps.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> areaList;
        ArrayList<Shape>tempareaLiat=new ArrayList<>(tempshaps.size());
        ArrayList<Integer>num=new ArrayList<>();
        for(int i=0;i<tempshaps.size();i++) {
            int numer=0;
            for (int j=0;j<tempshaps.size();j++){
                if(tempshaps.get(i).area()>tempshaps.get(j).area()||(tempshaps.get(i).area()==tempshaps.get(j).area()&&tempshaps.get(i).getPattern()>tempshaps.get(j).getPattern())){
                    numer++;
                }
            }num.add(numer);
        }for (int i=0;i<num.size();i++){
            for (int j =0;j<num.size();j++){
                if (num.get(j)==i){
                    tempareaLiat.add(tempshaps.get(j));
                }
            }
        }areaList= new ArrayList<>(tempareaLiat);
        return areaList;
    }

    @Override
    public List<Shape> getShapesByLocation() {
            List<Shape> temoshapsByLocation = new ArrayList<>(tempshaps);
            temoshapsByLocation.sort(Comparator.comparingInt(Shape::getX).thenComparing(Shape::getY).thenComparing(Shape::getPattern));
            return temoshapsByLocation;
        }


    @Override
    public char[][] getCanvas() {
        return canvas;
    }
}

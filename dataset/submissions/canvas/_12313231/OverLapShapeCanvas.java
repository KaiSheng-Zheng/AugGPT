import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private ArrayList<Shape> tempshaps;
    private char[][] canvas;

    public void setCanvas(char[][] canvas) {
        this.canvas = canvas;
    }
    public OverLapShapeCanvas(int rows, int cols){
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
                Circle cir=new Circle(new Location(x,y),pattern,params[0]);
                for(int line=0;line<2*params[0];line++){
                    for (int col=0;col<2*params[0];col++){
                        if(cir.getGrids()[line][col]==pattern){
                            if(line+x<canvas.length&&col+y<canvas[0].length&&line+x>0&&col+y>0){
                                error++;
                            }
                        }
                    }
                }
                if (error!=0){
                    for(int line=0;line<cir.getGrids().length;line++){
                        for (int col=0;col<cir.getGrids()[0].length;col++){
                            if(cir.getGrids()[line][col]==pattern){
                                if(line+x<canvas.length&&col+y<canvas[0].length&&line+x>0&&col+y>0){
                                    canvas[line+x][col+y]=pattern;}
                            }
                        }
                    }tempshaps.add(cir);
                    return true;
                }else return false;

        }else {Direction d = null;
            if(params[2]==0){d=Direction.LEFT_UP;}
            if(params[2]==1){d=Direction.LEFT_DOWN;}
            if(params[2]==2){d=Direction.RIGHT_UP;}
            if(params[2]==3){d=Direction.RIGHT_DOWN;}


                RightTriangle cir=new RightTriangle(new Location(x,y),pattern,params[0],params[1],d);
                for(int line=0;line<cir.getGrids().length;line++){
                    for (int col=0;col<cir.getGrids()[0].length;col++){
                        if(cir.getGrids()[line][col]==pattern){
                            if(line+x<canvas.length&&col+y<canvas[0].length&&line+x>0&&col+y>0){
                                error++;
                            }
                        }
                    }
                }
                if (error!=0){
                    for(int line=0;line<cir.getGrids().length;line++){
                        for (int col=0;col<cir.getGrids()[0].length;col++){
                            if(cir.getGrids()[line][col]==pattern){
                                if(line+x<canvas.length&&col+y<canvas[0].length){
                                    canvas[line+x][col+y]=pattern;}
                            }
                        }
                    }tempshaps.add(cir);
                    return true;
                }else return false;
            }

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

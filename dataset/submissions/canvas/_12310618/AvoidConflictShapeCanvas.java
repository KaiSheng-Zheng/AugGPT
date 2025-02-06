import java.util.ArrayList;
import java.util.List;
public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;

    public AvoidConflictShapeCanvas(int rows, int cols) {
        this.canvas=new char[rows][cols];
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j <cols; j++) {
                canvas[i][j]=' ';
            }

        }
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int...params) {
        if(params.length==1){
            Location location=new Location(x,y);
            Circle circle=new Circle(location,pattern,params[0]);
            circle.fillGrids();
            if(0>x||getRows()-1<x+2*params[0]||0>y||getCols()-1<y+2*params[0]){
                return false;
            }
            for (int i =x; i <x+2*params[0] ; i++) {

                for (int j =y; j <y+2*params[0] ; j++) {
                    if(canvas[i][j]!=' '&&circle.grids[i-x][j-y]!=' '){
                        return false;
                    }
                }
            }
            for (int i =x; i <x+2*params[0] ; i++) {

                for (int j =y; j <y+2*params[0] ; j++) {
                    if(circle.grids[i-x][j-y]!=' '){
                        canvas[i][j]=pattern;
                    }
                }
            }
            shapes.add(circle);
            return true;
        }
        else {
            Direction direction;
            if (params[2]==0){direction=Direction.LEFT_UP;}
            else if (params[2]==1){direction=Direction.LEFT_DOWN;}
            else if (params[2]==2){direction=Direction.RIGHT_UP;}
            else {direction=Direction.RIGHT_DOWN;}
            Location location=new Location(x,y);
            RightTriangle rightTriangle=new RightTriangle(location,pattern,params[0],params[1],direction);
            rightTriangle.fillGrids();
            if(!(x>=0&&y>=0&&x+params[1]<=getRows()&&y+params[0]<=getCols())){
                return false;
            }
            for (int i = 0; i <params[1]; i++) {
                for (int j = 0; j <params[0]; j++) {
                    if(rightTriangle.grids[i][j]!=' '&&canvas[x+i][y+j]!=' '){
  //                      System.out.println("qaz");
                        return false;
                    }
                }
            }
            for (int i = 0; i <params[1]; i++) {
                for (int j = 0; j <params[0]; j++) {
                    if(canvas[x+i][y+j]==' '){
                    canvas[x+i][y+j]=rightTriangle.grids[i][j];
                    }
                }
            }
            shapes.add(rightTriangle);
            return true;
        }
    }
    public int getRows(){
        return this.canvas.length;
    }
    public int getCols(){
        return this.canvas[0].length;
    }

    @Override
    public int getSpaceGridCount() {
        int num=0;
        for (int i = 0; i <getRows(); i++) {
            for (int j = 0; j <getCols(); j++) {
                if(canvas[i][j]==' '){
                    num++;
                }
            }
        }
        return num;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i <shapes.size(); i++) {
            for (int j = 0; j <shapes.size()-1; j++) {
                if(shapes.get(j).count()>shapes.get(j+1).count()){
                    shapes.add(j+2,shapes.get(j));
                    shapes.remove(j);
                }
                else if(shapes.get(j).count()==shapes.get(j+1).count()){
                    if (shapes.get(j).getPattern()>shapes.get(j+1).getPattern()){
                        shapes.add(j+2,shapes.get(j));
                        shapes.remove(j);
                    }
                }
            }
        }
        return shapes;
    }
    /**
     *            .,,       .,:;;iiiiiiiii;;:,,.     .,,
     *          rGB##HS,.;iirrrrriiiiiiiiiirrrrri;,s&##MAS,
     *         r5s;:r3AH5iiiii;;;;;;;;;;;;;;;;iiirXHGSsiih1,
     *            .;i;;s91;;;;;;::::::::::::;;;;iS5;;;ii:
     *          :rsriii;;r::::::::::::::::::::::;;,;;iiirsi,
     *       .,iri;;::::;;;;;;::,,,,,,,,,,,,,..,,;;;;;;;;iiri,,.
     *    ,9BM&,            .,:;;:,,,,,,,,,,,hXA8:            ..,,,.
     *   ,;&@@#r:;;;;;::::,,.   ,r,,,,,,,,,,iA@@@s,,:::;;;::,,.   .;.
     *    :ih1iii;;;;;::::;;;;;;;:,,,,,,,,,,;i55r;;;;;;;;;iiirrrr,..
     *   .ir;;iiiiiiiiii;;;;::::::,,,,,,,:::::,,:;;;iiiiiiiiiiiiri
     *   iriiiiiiiiiiiiiiii;;;::::::::::::::::;;;iiiiiiiiiiiiiiiir;
     *  ,riii;;;;;;;;;;;;;:::::::::::::::::::::::;;;;;;;;;;;;;;iiir.
     *  iri;;;::::,,,,,,,,,,:::::::::::::::::::::::::,::,,::::;;iir:
     * .rii;;::::,,,,,,,,,,,,:::::::::::::::::,,,,,,,,,,,,,::::;;iri
     * ,rii;;;::,,,,,,,,,,,,,:::::::::::,:::::,,,,,,,,,,,,,:::;;;iir.
     * ,rii;;i::,,,,,,,,,,,,,:::::::::::::::::,,,,,,,,,,,,,,::i;;iir.
     * ,rii;;r::,,,,,,,,,,,,,:,:::::,:,:::::::,,,,,,,,,,,,,::;r;;iir.
     * .rii;;rr,:,,,,,,,,,,,,,,:::::::::::::::,,,,,,,,,,,,,:,si;;iri
     *  ;rii;:1i,,,,,,,,,,,,,,,,,,:::::::::,,,,,,,,,,,,,,,:,ss:;iir:
     *  .rii;;;5r,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,sh:;;iri
     *   ;rii;:;51,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.:hh:;;iir,
     *    irii;::hSr,.,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,.,sSs:;;iir:
     *     irii;;:iSSs:.,,,,,,,,,,,,,,,,,,,,,,,,,,,..:135;:;;iir:
     *      ;rii;;:,r535r:...,,,,,,,,,,,,,,,,,,..,;sS35i,;;iirr:
     *       :rrii;;:,;1S3Shs;:,............,:is533Ss:,;;;iiri,
     *        .;rrii;;;:,;rhS393S55hh11hh5S3393Shr:,:;;;iirr:
     *          .;rriii;;;::,:;is1h555555h1si;:,::;;;iirri:.
     *            .:irrrii;;;;;:::,,,,,,,,:::;;;;iiirrr;,
     *               .:irrrriiiiii;;;;;;;;iiiiiirrrr;,.
     *                  .,:;iirrrrrrrrrrrrrrrrri;:.
     *                        ..,:::;;;;:::,,.
     */
    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i <shapes.size(); i++) {
            for (int j = 0; j <shapes.size()-1; j++) {
                if(shapes.get(j).getLocation().getX()>shapes.get(j+1).getLocation().getX()){
                    shapes.add(j+2,shapes.get(j));
                    shapes.remove(j);
                }
                else if (shapes.get(j).getLocation().getX()==shapes.get(j+1).getLocation().getX()){
                    if(shapes.get(j).getLocation().getY()>shapes.get(j+1).getLocation().getY()){
                        shapes.add(j+2,shapes.get(j));
                        shapes.remove(j);
                    }
                    else if(shapes.get(j).getLocation().getY()==shapes.get(j+1).getLocation().getY()){
                        if (shapes.get(j).getPattern()>shapes.get(j+1).getPattern()){
                            shapes.add(j+2,shapes.get(j));
                            shapes.remove(j);
                        }
                    }
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

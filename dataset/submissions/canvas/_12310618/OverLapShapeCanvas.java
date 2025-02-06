import java.util.ArrayList;
import java.util.List;
public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes=new ArrayList<>();
    private char[][] canvas;
    public OverLapShapeCanvas (int rows, int cols){
        this.canvas=new char[rows][cols];
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j <cols; j++) {
                canvas[i][j]=' ';
            }

        }
    }
    /**
     *_______________#########_______________________
     *______________############_____________________
     *______________#############____________________
     *_____________##__###########___________________
     *____________###__######_#####__________________
     *____________###_#######___####_________________
     *___________###__##########_####________________
     *__________####__###########_####_______________
     *________#####___###########__#####_____________
     *_______######___###_########___#####___________
     *_______#####___###___########___######_________
     *______######___###__###########___######_______
     *_____######___####_##############__######______
     *____#######__#####################_#######_____
     *____#######__##############################____
     *___#######__######_#################_#######___
     *___#######__######_######_#########___######___
     *___#######____##__######___######_____######___
     *___#######________######____#####_____#####____
     *____######________#####_____#####_____####_____
     *_____#####________####______#####_____###______
     *______#####______;###________###______#________
     *________##_______####________####______________
     */

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        if(params.length==1){
            Location location=new Location(x,y);
            Circle circle=new Circle(location,pattern,params[0]);
            circle.fillGrids();
            if(x+2*params[0]<=0||y+2*params[0]<=0||x>=getRows()||y>=getCols()){
//                System.out.println("false c1");
                return false;
            }
            int newcanvasX;
            int newcanvasY;
            int newgridsX;
            int newgridsY;
            if(x<0){
                newcanvasX=-x;
                newgridsX=0;
            }
            else {
                newgridsX=x;
                newcanvasX=0;
            }
            if (y<0){
                newcanvasY=-y;
                newgridsY=0;
            }
            else {
                newgridsY=y;
                newcanvasY=0;
            }
            boolean fill=false;
//            System.out.println("newcanvasX="+newcanvasX);
//            System.out.println("newcanvasY="+newcanvasY);
//            System.out.println("newgridsX="+newgridsX);
//            System.out.println("newgridsY="+newgridsY);
            for (int i =newcanvasX; i <Math.min(newgridsX+2*params[0],newcanvasX+getRows())-newgridsX; i++) {
                for (int j =newcanvasY; j <Math.min(newgridsY+2*params[0],newcanvasY+getCols())-newgridsY; j++) {
                    if(circle.grids[i][j]!=' '){
                        fill=true;
                    }
                }
            }
            if(!fill){
//                System.out.println("false c2");
                return false;
            }
            for (int i =newgridsX; i <Math.min(newgridsX+2*params[0],newcanvasX+getRows())-newcanvasX; i++) {
                for (int j =newgridsY; j <Math.min(newgridsY+2*params[0],newcanvasY+getCols())-newcanvasY; j++) {
                    if(circle.grids[newcanvasX+i-newgridsX][newcanvasY+j-newgridsY]!=' '){
                        canvas[i][j]=circle.grids[newcanvasX+i-newgridsX][newcanvasY+j-newgridsY];
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
            if(x+params[1]<=0||x>getRows()-1||y+params[0]<=0||y>getCols()-1){
    //            System.out.println("false r1");
                return false;
            }
            int newcanvasX;
            int newcanvasY;
            int newgridsX;
            int newgridsY;
            if(x<0){
                newcanvasX=-x;
                newgridsX=0;
            }
            else {
                newgridsX=x;
                newcanvasX=0;
            }
            if (y<0){
                newcanvasY=-y;
                newgridsY=0;
            }
            else {
                newgridsY=y;
                newcanvasY=0;
            }
            boolean fill=false;
            for (int i = 0; i <Math.min(newcanvasX+getRows(),newgridsX+params[1])-newcanvasX-newgridsX; i++) {
                for (int j = 0; j <Math.min(newcanvasY+getCols(),newgridsY+params[0])-newcanvasY-newgridsY; j++) {
                    if(rightTriangle.grids[i+newcanvasX][j+newcanvasY]!=' '){
                        fill=true;
                    }
                }
            }
            if(!fill){
//                System.out.println("false r2");
                return false;
            }
            for (int i = 0; i <Math.min(newcanvasX+getRows(),newgridsX+params[1])-newcanvasX-newgridsX; i++) {
                for (int j = 0; j <Math.min(newcanvasY+getCols(),newgridsY+params[0])-newcanvasY-newgridsY; j++) {
                    if(rightTriangle.grids[i+newcanvasX][j+newcanvasY]!=' '){
                        canvas[i+newgridsX][j+newgridsY]=rightTriangle.grids[i+newcanvasX][j+newcanvasY];
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

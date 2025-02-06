import static java.lang.Math.*;
public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids(location,pattern,width,height,d);
    }
    public void fillGrids(Location location, char pattern, int width, int height, Direction d){
        grids=new char[height+location.getX()][width+location.getY()];
        String a=" ";
        switch (d){
            case LEFT_DOWN:
                for (int i = 0; i <height; i++) {
                    for (int j = 0; j <width; j++) {
                        if (width*(i+1)>height*j){
                            grids[i+location.getX()][j+location.getY()]=pattern;
                        }
//                        else grids[i][j]=a.charAt(0);
                    }
                }
                break;
            case LEFT_UP:
                for (int i = 0; i <height; i++) {
                    for (int j = 0; j <width; j++) {
                        if (width*i<width*height-height*j){
                            grids[i+location.getX()][j+location.getY()]=pattern;
                        }
//                        else grids[i][j]=a.charAt(0);
                    }
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i <height; i++) {
                    for (int j = 0; j <width; j++) {
                        if (width*(i+1)>height*width-height*(j+1)){
                            grids[i+location.getX()][j+location.getY()]=pattern;
                        }
//                        else grids[i][j]=a.charAt(0);
                    }
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i <height; i++) {
                    for (int j = 0; j <width; j++) {
                        if (width*i<height*(j+1)){
                            grids[i+location.getX()][j+location.getY()]=pattern;
                        }
//                        else grids[i][j]=a.charAt(0);
                    }
                }
                break;
        }
    }

//public void fillGrids(Location location, char pattern, int width, int height, Direction d){
//    grids=new char[height][width];
//    String a = " ";
//    switch (d){
//        case LEFT_DOWN:
//            for (int i = 0; i <height; i++) {
//                for (int j = 0; j <width; j++) {
//                    if (width*(i+1)>height*j){
//                        grids[i][j]=pattern;
//                    }
//                    else grids[i][j]=a.charAt(0);
//                }
//            }
//            break;
//        case LEFT_UP:
//            for (int i = 0; i <height; i++) {
//                for (int j = 0; j <width; j++) {
//                    if (width*i<width*height-height*j){
//                        grids[i][j]=pattern;
//                    }
//                    else grids[i][j]=a.charAt(0);
//                }
//            }
//            break;
//        case RIGHT_DOWN:
//            for (int i = 0; i <height; i++) {
//                for (int j = 0; j <width; j++) {
//                    if (width*(i+1)>height*width-height*(j+1)){
//                        grids[i][j]=pattern;
//                    }
//                    else grids[i][j]=a.charAt(0);
//                }
//            }
//            break;
//        case RIGHT_UP:
//            for (int i = 0; i <height; i++) {
//                for (int j = 0; j <width; j++) {
//                    if (width*i<height*(j+1)){
//                        grids[i][j]=pattern;
//                    }
//                    else grids[i][j]=a.charAt(0);
//                }
//            }
//            break;
//    }
//}
    public void enlarge(){
        height++;
        width++;
        fillGrids(location,pattern,width,height,d);
    }
    public void shrink(){
        if (height>1&&width>1){
            height--;
            width--;
            fillGrids(location,pattern,width,height,d);
        }
    }
    public int area(){
        int num =0;
        for (int i = 0; i <grids.length; i++) {
            for (int j = 0; j <grids[0].length; j++) {
                if (grids[i][j]==pattern){
                    num++;
                }
            }
        }
        return num;
    }
    public String toString(){
        return String.format("RightTriangle: %s area=%d pattern=%s",location.toString(),area(),pattern);
    }
}

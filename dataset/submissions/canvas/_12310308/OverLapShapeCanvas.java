import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    
    public int getSpaceGridCount() {
        int a=0;
        for(int i=0;i< canvas.length;i++ ){
            for(int t=0;t<canvas[0].length;t++){
                if(canvas[i][t]==' '){
                    a++;
                }}}
        return a;
    }

    
    public int getShapeCount() {
        return shapess.size();
    }



    @Override
    public List<Shape> getShapesByArea(){
        Collections.sort(shapess, (s1, s2) -> {

            double area1 = parseArea(s1);
            double area2 = parseArea(s2);


            int compareByArea = Double.compare(area1, area2);
            if (compareByArea != 0) {
                return compareByArea;
            }


            String pattern1 = parsePattern(s1);
            String pattern2 = parsePattern(s2);
            return pattern1.compareTo(pattern2);
        });
        return null;
    }


    private static double parseArea(String shapeString) {

        String[] parts = shapeString.split(" ");
        for (String part : parts) {
            if (part.startsWith("area=")) {
                return Double.parseDouble(part.substring("area=".length()));
            }
        }
        throw new IllegalArgumentException(" ");
    }


    private static String parsePattern(String shapeString) {

        String[] parts = shapeString.split(" ");
        for (String part : parts) {
            if (part.startsWith("pattern=")) {
                return part.substring("pattern=".length());
            }
        } throw new IllegalArgumentException(" ");
    }




    
    public List<Shape> getShapesByLocation()  {
        Collections.sort(shapess, new Comparator<String>() {
            
            public int compare(String s1, String s2) {

                String[] parts1 = s1.split(" ");
                double x1 = Double.parseDouble(parts1[1].split("(")[1].split(",")[0]);
                double y1 = Double.parseDouble(parts1[1].split(",")[1].split(")")[0]);
                String pattern1 = parts1[parts1.length - 1].split("=")[1];


                String[] parts2 = s2.split(" ");
                double x2 = Double.parseDouble(parts2[1].split("(")[1].split(",")[0]);
                double y2 = Double.parseDouble(parts2[1].split(",")[1].split(")")[0]);
                String pattern2 = parts2[parts2.length - 1].split("=")[1];


                int compareByX = Double.compare(x1, x2);
                if (compareByX != 0) {
                    return compareByX;
                }


                int compareByY = Double.compare(y1, y2);
                if (compareByY != 0) {
                    return compareByY;
                }


                return pattern1.compareTo(pattern2);
            }
        });
        return null;
    }

    
    public char[][] getCanvas() {
        return canvas;
    }

    private List<Shape> shapes;
    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols){canvas = new char[rows][cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                canvas[i][j] = ' ';
            }
        }}
    public ArrayList<String> shapess;
    
    public boolean addShape(int x, int y, char pattern, int... params){int m=0;
        for(int i=0;i< canvas.length;i++){
            for (int t=0;t< canvas[0].length;t++){
                canvas[i][t]=' ';
            }
        }
        Location location = new Location(x, y);
        if(params.length==1){
            Circle circle = new Circle(location, pattern, params[0]);
                for(int i=0;i<x+2*params[0];i++){
                    for (int t=0;t<y+2*params[0];t++){
                        if(Shape.grids[i][t]!=' '&&i<canvas.length&&t<canvas[0].length){
                            canvas[i][t]=Shape.grids[i][t];m++;
                        }
                    }
                }if (m>0){shapess.add("Circle: ("+ location.getX()+","+ location.getY()+") area="+ circle.area()+" pattern="+pattern);return true;}
                else{return false;}
            }else{

                    if (params[2]==0){
                        RightTriangle rightTriangle=new RightTriangle(location,pattern,params[0],params[1],Direction.LEFT_UP);
                    }if (params[2]==1){
                        RightTriangle rightTriangle=new RightTriangle(location,pattern,params[0],params[1],Direction.LEFT_DOWN);
                    }if (params[2]==2){
                        RightTriangle rightTriangle=new RightTriangle(location,pattern,params[0],params[1],Direction.RIGHT_UP);
                    }if (params[2]==3){
                        RightTriangle rightTriangle=new RightTriangle(location,pattern,params[0],params[1],Direction.RIGHT_DOWN);
                    }
                    for(int i=0;i<x+params[1];i++){
                        for (int t=0;t<y+params[0];t++){
                            if(Shape.grids[i][t]!=' '&&i<canvas.length&&t<canvas[0].length){
                                canvas[i][t]=Shape.grids[i][t];m++;
                            }
                        }
                    }if(m>0){
                    int area=0;
                    for(int i=0;i<x+params[1];i++){
                        for (int t=0;t<y+params[0];t++){
                            if(Shape.grids[i][t]==pattern){area++;}
                        }
                    }
                    shapess.add("RightTriangle: ("+ location.getX()+","+ location.getY()+") area="+area+" pattern="+pattern);return true;}
else{return false;}

            }}
    }
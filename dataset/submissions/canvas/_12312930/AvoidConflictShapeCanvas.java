import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class AvoidConflictShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int shapeCount;



    public AvoidConflictShapeCanvas(int x, int y) {
        this.canvas = new char[x][y];
        this.shapes=new ArrayList<>();
        for(int i=0;i<x;i++){for(int j=0;j<y;j++){canvas[i][j]=' ';}}
    }
    public int getSpaceGridCount(){
        int n=0;
        for(int i=0;i< canvas.length;i++){for(int j=0;j<canvas[i].length-1;j++)
        {if(canvas[i][j]==' ')
        {n++;}}}
        return n;
    }
    public int getShapeCount(){
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        List<Shape> sortedShapes =shapes;
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                int a = Integer.compare(o1.area(), o2.area());
                return a;
            }
        });
        return sortedShapes;
    }


    @Override
    public List<Shape> getShapesByLocation() {
        List<Shape> sortedShapes =shapes;
        Collections.sort(sortedShapes, new Comparator<Shape>() {
            @Override
            public int compare(Shape o1, Shape o2) {
                int a =Integer.compare(o1.getLocation().getX(), o2.getLocation().getX());
                if(a!=0){
                    return a;
                }
                else{
                    int b =Integer.compare(o1.getLocation().getY(), o2.getLocation().getY());
                    return b;
                }
            }

        });
        return sortedShapes;
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        char[][] canvas1 = new char[canvas.length][];
        for (int i = 0; i < canvas.length; i++) {canvas1[i] = new char[canvas[i].length];for (int j = 0; j < canvas[i].length; j++) {canvas1[i][j] = ' ';}}
        if(params.length==1){
            int r=params[0];
            if(x<0||(x+2*r)>canvas.length||y<0||(y+2*r)> canvas[0].length){
                return false;
            }

            for(int i=0;i<2*r+1;i++){
                for(int j=0;j<2*r+1;j++){
                    if((i-r)*(i-r)+(j-r)*(j-r)<r*r){
                        if(i-1>=0&&j-1>=0){

                                canvas1[x + i - 1][y + j - 1] = pattern;
                            }
                        if(i-1>=0&&j<2*r){

                                canvas1[x + i - 1][y + j] = pattern;
                            }
                        if(i<2*r&&j-1>=0){

                                canvas1[x + i][y + j - 1] = pattern;
                            }
                        if(i<2*r&&j<2*r){
                                canvas1[x + i][y + j] = pattern;
                            }
                    }
                }
            }
            for(int i=0;i< canvas.length;i++) {
                for (int j = 0; j < canvas[i].length - 1; j++) {
                    if (canvas1[i][j] != ' ') {
                        if (canvas[i][j] != ' ') {
                            return false;
                        }
                    }
                }
            }
            for(int i=0;i< canvas.length;i++) {
                for (int j = 0; j < canvas[i].length - 1; j++) {
                    if (canvas1[i][j] != ' ') {
                        if (canvas[i][j] == ' ') {
                            canvas[i][j] =canvas1[i][j];
                        }
                    }
                }
            }
            shapes.add(new Circle(new Location(x,y),pattern,r));
            shapeCount++;
            return true;
            }


        else if(params.length==3){

            int width = params[0];
            int height = params[1];
            int direction = params[2];
            if (x < 0 || y < 0 || x+height >= canvas.length || y+width >= canvas[0].length) {
                return false;
            }
            Direction d=null;
            switch(direction){
                case 0:d=Direction.LEFT_UP;
                    break;
                case 1:d=Direction.LEFT_DOWN;
                    break;
                case 2:d=Direction.RIGHT_UP;
                    break;
                case 3:d=Direction.RIGHT_DOWN;}


            if (direction==0){
                canvas1[x][y+width-1]=pattern;
                for(int i=0;i<height+1;i++){
                    for(int j=0;j<width;j++){
                        double slope=(double) height/width;
                        double k=(double) i/(width-j);
                        if(k<slope){
                            if(i-1>=0&&j-1>=0){
                                    canvas1[(i - 1 + x)][j - 1 + y] = pattern;}
                            if(i<height&&j-1>=0){

                                    canvas1[i + x][j - 1 + y] = pattern;
                                }
                            if(i-1>=0&&j<width){

                                    canvas1[i - 1 + x][j + y] = pattern;
                                }

                            if(i<height&&j<width){

                                    canvas1[i + x][j + y] = pattern;
                                }

                        }
                    }
                }
            }
            if (direction==1){
                for(int i=0;i<height;i++){
                    canvas1[i+x][y]=pattern;
                }
                for(int i=0;i<height+1;i++){
                    for(int j=1;j<width+1;j++){
                        double slope=(double) height/width;
                        double k=(double) i/j;
                        if(k>slope){
                            if(i-1>=0){
                                canvas1[i - 1 + x][j - 1 + y] = pattern;
                            }

                            if(i<height){

                                    canvas1[i + x][j - 1 + y] = pattern;
                                }
                            if(i-1>=0&&j<width){

                                    canvas1[i - 1 + x][j + y] = pattern;
                                }

                            if(i<height&&j<width) {

                                canvas1[i + x][j + y] = pattern;
                            }
                        }
                    }
                }

            }
            if (direction==2){
                canvas1[x][y]=pattern;
                for(int i=0;i<height+1;i++){
                    for(int j=1;j<width+1;j++){
                        double slope=(double) height/width;
                        double k=(double) i/j;
                        if(k<slope){
                            if(i-1>=0){

                                    canvas1[x + i - 1][y + j - 1] = pattern;
                                }
                            if(i<height){

                                    canvas1[x + i][y + j - 1] = pattern;
                                }
                            if(i-1>=0&&j<width){

                                    canvas1[x + i - 1][y + j] = pattern;
                                }
                            if(i<height&&j<width){

                                    canvas1[x + i][y + j] = pattern;
                                }
                        }
                    }
                }
            }
            if (direction==3){
                for(int i=0;i<height;i++){
                    canvas1[x+i][y+width-1]=pattern;
                }
                for(int i=0;i<height+1;i++){
                    for(int j=0;j<width;j++){
                        double slope=(double) height/width;
                        double k=(double) i/(width-j);
                        if(k>slope){
                            if(i-1>=0&&j-1>=0){

                                    canvas1[(x+i - 1)][y+j - 1] = pattern;
                                }
                            if(i<height&&j-1>=0){

                                    canvas1[x+i][y+j - 1] = pattern;
                                }
                            if(i-1>=0&&j<width){

                                    canvas1[x+i - 1][y+j] = pattern;
                                }
                            if(i<height&&j<width){

                                    canvas1[x+i][y+j] = pattern;
                                }
                        }
                    }
                }
            }
            for(int i=0;i< canvas.length;i++) {
                for (int j = 0; j < canvas[i].length - 1; j++) {
                    if (canvas1[i][j] != ' ') {
                        if (canvas[i][j] != ' ') {
                            return false;
                        }
                    }
                }
            }
            for(int i=0;i< canvas.length;i++) {
                for (int j = 0; j < canvas[i].length - 1; j++) {
                    if (canvas1[i][j] != ' ') {
                        if (canvas[i][j] == ' ') {
                            canvas[i][j] =canvas1[i][j];
                        }
                    }
                }
            }



            shapes.add(new RightTriangle(new Location(x,y),pattern,width,height,d));
            shapeCount++;
            return true;

        }


        return false;
    }


}

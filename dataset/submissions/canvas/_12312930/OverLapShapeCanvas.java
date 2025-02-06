import java.util.*;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    private int shapeCount;
    public OverLapShapeCanvas(int rows, int cols){
        this.canvas = new char[rows][cols];
        this.shapes=new ArrayList<>();
        for(int i=0;i<rows;i++){for(int j=0;j<cols;j++){canvas[i][j]=' ';}}
        shapeCount=0;
    }
    @Override
    public boolean addShape(int x, int y, char pattern, int... params){
        char[][] canvasP = new char[canvas.length][];
        for (int i = 0; i < canvas.length; i++) {canvasP[i] = new char[canvas[i].length];for (int j = 0; j < canvas[i].length; j++) {canvasP[i][j] = ' ';}}
        if(params.length==1){
            int r=params[0];
            boolean a = x < canvas.length && y < canvas[0].length
                    && (x + 2*r > 0 && y + 2*r > 0);
            if(!a){
                return false;
            }

            for(int i=0;i<2*r+1;i++){
                for(int j=0;j<2*r+1;j++){
                    if((i-r)*(i-r)+(j-r)*(j-r)<r*r){
                        if(x+i-1>=0&&y+j-1>=0){
                            canvasP[x + i - 1][y + j - 1] = pattern;
                        }
                        if(x+i-1>=0&&y+j<canvas[0].length){

                            canvasP[x + i - 1][y + j] = pattern;
                        }
                        if(x+i<canvas.length&&y+j-1>=0){

                            canvasP[x + i][y + j - 1] = pattern;
                        }
                        if(x+i<canvas.length&&y+j<canvas.length){
                            canvasP[x + i][y + j] = pattern;
                        }
                    }
                }
            }
//            for(int i=0;i< canvas.length;i++) {
//                for (int j = 0; j < canvas[i].length - 1; j++) {
//                    if (canvas1[i][j] != ' ') {
//                        if (canvas[i][j] != ' ') {
//                            return false;
//                        }
//                    }
//                }
//            }
            for(int i=0;i< canvas.length;i++) {
                for (int j = 0; j < canvas[i].length - 1; j++) {
                    if (canvasP[i][j] != ' ') {
                            canvas[i][j] =canvasP[i][j];
                    }
                }
            }
            afterAdd();
            shapes.add(new Circle(new Location(x,y),pattern,r));
            shapeCount++;
            return true;
        }


        else if(params.length==3){

            int width = params[0];
            int height = params[1];
            int direction = params[2];
            boolean b=x < canvas.length && y < canvas[0].length
                    && (x + width > 0 && y + height > 0);
            if (!b) {
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
                canvasP[x][y+width-1]=pattern;
                for(int i=0;i<height+1;i++){
                    for(int j=0;j<width;j++){
                        double slope=(double) height/width;
                        double k=(double) i/(width-j);
                        if(k<slope){
                            if(x+i-1>=0&&y+j-1>=0&&x+i-1<canvas.length&&y+j-1<canvas[0].length){
                                canvasP[(i - 1 + x)][j - 1 + y] = pattern;}
                            if(x+i<canvas.length&&y+j-1>=0&&x+i>=0&&y+j-1<canvas[0].length){

                                canvasP[i + x][j - 1 + y] = pattern;
                            }
                            if(x+i-1>=0&&j+y<canvas[0].length&&x+i-1<canvas.length&&j+y>=0){

                                canvasP[i - 1 + x][j + y] = pattern;
                            }

                            if(x+i<canvas.length&&y+j<canvas[0].length&&x+i>=0&&y+j>=0){

                                canvasP[i + x][j + y] = pattern;
                            }

                        }
                    }
                }
            }
            if (direction==1){
                for(int i=0;i<height&&i+x<canvas.length&&y<canvas[0].length;i++){
                    canvasP[i+x][y]=pattern;
                }
                for(int i=0;i<height+1;i++){
                    for(int j=1;j<width+1;j++){
                        double slope=(double) height/width;
                        double k=(double) i/j;
                        if(k>slope){
                            if(x+i-1>=0&&x+i-1<canvas.length){
                                canvasP[i - 1 + x][j - 1 + y] = pattern;
                            }

                            if(x+i<canvas.length&&x+i>=0){

                                canvasP[i + x][j - 1 + y] = pattern;
                            }
                            if(x+i-1>=0&&y+j<canvas[0].length&&x+i-1<canvas.length&&y+j>=0){

                                canvasP[i - 1 + x][j + y] = pattern;
                            }

                            if(x+i<canvas.length&&y+j<canvas[0].length&&x+i>=0&&y+j>=0) {

                                canvasP[i + x][j + y] = pattern;
                            }
                        }
                    }
                }

            }
            if (direction==2){
                if(x>=0&&y>=0)
                {
                    canvasP[x][y] = pattern;
                }
                for(int i=0;i<height+1;i++){
                    for(int j=1;j<width+1;j++){
                        double slope=(double) height/width;
                        double k=(double) i/j;
                        if(k<slope){
                            if(x+i-1>=0&&x+i-1<canvas.length){

                                canvasP[x + i - 1][y + j - 1] = pattern;
                            }
                            if(x+i<canvas.length&&x+i>=0){

                                canvasP[x + i][y + j - 1] = pattern;
                            }
                            if(x+i-1>=0&&y+j<canvas[0].length&&x+i-1<canvas.length&&y+j>=0){

                                canvasP[x + i - 1][y + j] = pattern;
                            }
                            if(x+i<canvas.length&&y+j<canvas[0].length&&x+i>=0&&y+j>=0){

                                canvasP[x + i][y + j] = pattern;
                            }
                        }
                    }
                }
            }
            if (direction==3){
                for(int i=0;i<height&&x+i< canvas.length&&y+width-1<canvas[0].length;i++){
                    canvasP[x+i][y+width-1]=pattern;
                }
                for(int i=0;i<height+1;i++){
                    for(int j=0;j<width;j++){
                        double slope=(double) height/width;
                        double k=(double) i/(width-j);
                        if(k>slope){
                            if(x+i-1>=0&&y+j-1>=0&&x+i-1< canvas.length&&y+j-1<canvas[0].length){
                                canvasP[(x+i - 1)][y+j - 1] = pattern;
                            }
                            if(x+i<canvas.length&&y+j-1>=0&&x+i>=0&&y+j-1<canvas[0].length){

                                canvasP[x+i][y+j - 1] = pattern;
                            }
                            if(x+i-1>=0&&y+j<canvas[0].length&&x+i-1<canvas.length&&y+j>=0){

                                canvasP[x+i - 1][y+j] = pattern;
                            }
                            if(x+i<canvas.length&&y+j<canvas[0].length&&x+i>=0&&y+j>=0){

                                canvasP[x+i][y+j] = pattern;
                            }
                        }
                    }
                }
            }
//            for(int i=0;i< canvas.length;i++) {
//                for (int j = 0; j < canvas[i].length - 1; j++) {
//                    if (canvas1[i][j] != ' ') {
//                        if (canvas[i][j] != ' ') {
//                            return false;
//                        }
//                    }
//                }
//            }
            for(int i=0;i< canvas.length;i++) {
                for (int j = 0; j < canvas[i].length - 1; j++) {
                    if (canvasP[i][j] != ' ') {
                            canvas[i][j] =canvasP[i][j];

                    }
                }
            }
            shapes.add(new RightTriangle(new Location(x,y),pattern,width,height,d));
            afterAdd();
            shapeCount++;
            return true;

        }


        return false;


    }

    @Override
    public int getSpaceGridCount() {
        int n=0;
        for(int i=0;i< canvas.length;i++){for(int j=0;j<canvas[i].length-1;j++)
        {if(canvas[i][j]==' ')
        {n++;}}}
        return n;
    }

    @Override
    public int getShapeCount() {
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
    public void afterAdd(){
        List<Shape> toRemove = new ArrayList<>();
        if(shapes!=null){
            for (Shape shape1 : shapes) {

                if (isCompletelyCovered(shape1)) {
                    toRemove.add(shape1);
                }


            }
        }
        shapes.removeAll(toRemove);
    }
    public boolean isCompletelyCovered(Shape shape){
        for(int i=0;i< canvas.length;i++){for(int j=0;j<canvas[i].length-1;j++)
        {if(canvas[i][j]==shape.getPattern()){
        return false;}
        }}
        return true;
    }


}

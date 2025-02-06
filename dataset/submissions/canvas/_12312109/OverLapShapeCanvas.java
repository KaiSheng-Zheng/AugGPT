import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas{
    private List<Shape> shapes;
    private char[][] canvas;
    public Direction[]directions ={Direction.LEFT_UP,Direction.RIGHT_UP,Direction.RIGHT_DOWN,Direction.LEFT_DOWN};

    public OverLapShapeCanvas(int rows, int cols){
        for (int i = 0 ; i < rows ; i++){
            for (int j = 0 ; j < cols ; j++){
                canvas[i][j] = ' ';
            }
        }
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        getCanvas();
        if (params.length == 1){
            int radius = params[0];
            if (x >= canvas.length || y>= canvas[0].length || x+radius*2<0 ||y+radius*2<0){return false;}
            if ((x+2*radius)<canvas.length && (y+2*radius)<canvas[0].length && x > 0 && y > 0){return false;}
            for (int i = x; i < canvas.length;i++){
                for (int j = y; j < canvas[0].length;j++){
                    canvas[i][j] = pattern;
                }
            }
            Location location = new Location(x,y);
            Circle circle = new Circle(location,pattern,radius);
            shapes.add(circle);
        }
        if (params.length == 3){
            int width = params[0];
            int height = params[1];
            int d = params[2];
            double tan = (0.0 + height) / width;
            if (x>0 && y>0 && x+height<canvas.length && y+width<canvas[0].length){return false;}
            if (x>=canvas.length || y>canvas[0].length || x+height<=0 || y+height<=0){return false;}
        }
        return true;
    }

    @Override
    public int getSpaceGridCount() {
        getCanvas();
        int area = 0;
        for (int i = 0 ; i < canvas.length ; i++){
            for (int j = 0 ; j < canvas[0].length ; j++){
                if (!(canvas[i][j]==' ')){
                    area += 1;
                }
            }
        }
        return area;
    }

    @Override
    public int getShapeCount() {
        return shapes.size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        for (int i = 0; i < shapes.size();i++){
            for (int j = 0; j < shapes.size();j++){
                if (shapes.get(j).area()>shapes.get(j+1).area()){
                    Shape s = shapes.get(j+1);
                    shapes.set(j+1,shapes.get(j));
                    shapes.set(j,s);
                }
                if (shapes.get(j).area()==shapes.get(j+1).area()){
                    if (shapes.get(j).pattern<shapes.get(j+1).pattern){
                        Shape s = shapes.get(j+1);
                        shapes.set(j+1,shapes.get(j));
                        shapes.set(j,s);
                    }
                }
            }
        }
        return shapes;
    }

    @Override
    public List<Shape> getShapesByLocation() {
        for (int i = 0; i < shapes.size()-1;i++){
            for (int j = 0; j < shapes.size()-1;j++){
                if (shapes.get(j).location.getX()>shapes.get(j+1).location.getX()){
                    Shape s = shapes.get(j+1);
                    shapes.set(j+1,shapes.get(j));
                    shapes.set(j,s);
                }
                if (shapes.get(j).location.getX()==shapes.get(j+1).location.getX()){
                    if (shapes.get(j).location.getY()>shapes.get(j+1).location.getY()){
                        Shape s = shapes.get(j+1);
                        shapes.set(j+1,shapes.get(j));
                        shapes.set(j,s);
                    }
                }
                if (shapes.get(j).location.getX()==shapes.get(j+1).location.getX()){
                    if (shapes.get(j).location.getY()==shapes.get(j+1).location.getY()){
                        if (shapes.get(j).pattern<shapes.get(j+1).pattern){
                            Shape s = shapes.get(j+1);
                            shapes.set(j+1,shapes.get(j));
                            shapes.set(j,s);
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

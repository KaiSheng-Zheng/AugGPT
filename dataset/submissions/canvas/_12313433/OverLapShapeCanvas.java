

    import java.util.ArrayList;
    import java.util.List;

    public class OverLapShapeCanvas implements ShapeCanvas{
        private List<Shape> shapes;
        private char[][] canvas;
        public OverLapShapeCanvas(int rows, int cols){
            shapes=new ArrayList<>();
            canvas = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    canvas[i][j]=' ';
                }
            }
        }
        @Override
        public boolean addShape(int x, int y, char pattern, int... params){
            Shape shape;
            if (params.length == 1) { //circle
                shape = new Circle(new Location(x, y), pattern, params[0]);
            } else { //right triangle
                shape = new RightTriangle(new Location(x, y), pattern, params[0], params[1], Direction.values()[params[2]]);
            }
            boolean flag=false;
            for (int i = 0; i < shape.grids.length; i++) {
                for (int j = 0; j < shape.grids[0].length; j++) {
                    if ((x + i) < canvas.length && (y + j) < canvas[0].length && shape.grids[i][j]==pattern) {
                        canvas[x + i][y + j] = pattern;
                        flag= true;
                    }
                }
            }
            if(!flag){
                return false;
            }else{
            shapes.add(shape);
            }
            return true;
        }
        public int getSpaceGridCount(){
            int space = 0;
            for (int i = 0; i < canvas.length; i++) {
                for (int j = 0; j < canvas[0].length; j++) {
                    if(canvas[i][j]==' '){
                        space++;
                    }
                }
            }
            return space;
        }
        public int getShapeCount(){
            return shapes.size();
        }
        public List<Shape> getShapesByArea() {
            List<Shape> sortbyarea = shapes;
            for (int j = 0; j < sortbyarea.size()-1; j++) {
                for (int i = 0; i < sortbyarea.size()-1; i++) {
                    if (shapes.get(i).area() > shapes.get(i + 1).area() || (shapes.get(i).area() == shapes.get(i + 1).area() && shapes.get(i).pattern > shapes.get(i + 1).pattern)) {
                        Shape store = sortbyarea.get(i);
                        sortbyarea.set(i, sortbyarea.get(i+1));
                        sortbyarea.set(i+1,store);
                    }
                }
            }
            return sortbyarea;
        }

        @Override
        public List<Shape> getShapesByLocation() {
            List<Shape> sortbylocation= shapes;
            for (int j = 0; j < sortbylocation.size() - 1; j++) {
                for (int i = 0; i < sortbylocation.size() - 1; i++) {
                    if (shapes.get(i).location.getX() > shapes.get(i + 1).location.getX() || ((shapes.get(i).location.getX() == shapes.get(i + 1).location.getX() && shapes.get(i).location.getY() > shapes.get(i + 1).location.getY())) || (shapes.get(i).location.getX() == shapes.get(i + 1).location.getX() && shapes.get(i).location.getY() == shapes.get(i + 1).location.getY() && shapes.get(i).pattern > shapes.get(i+1).pattern)) {
                        Shape store = sortbylocation.get(i);
                        sortbylocation.set(i, sortbylocation.get(i+1));
                        sortbylocation.set(i+1,store);
                    }
                }
            }
            return sortbylocation;
        }
        public char[][] getCanvas(){
            return canvas;
        }
    }

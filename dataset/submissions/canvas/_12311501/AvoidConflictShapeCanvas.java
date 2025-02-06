import java.util.ArrayList;
import java.util.List;


public class AvoidConflictShapeCanvas implements ShapeCanvas {
        private List<Shape> shapes;

        private char[][] canvas;

        private int count = 0;
    public AvoidConflictShapeCanvas( int rows, int cols){
            shapes = new ArrayList<Shape>();
            canvas = new char[rows][cols];
            set();
        }

        public void set(){
            for(int i = 0; i < canvas.length; i++){
                for(int j = 0; j < canvas[i].length; j++){
                    canvas[i][j] = ' ';
                }
            }
        }

        @Override
        public boolean addShape ( int x, int y, char pattern, int...params){

            char[][] grids =null;
            Location loc = new Location(x, y);

            if(x < 0 || y < 0 || x >= canvas.length || y >= canvas[0].length) {
                return false;
            }
            else {
                if (params.length == 3) {
                    int width = params[0];
                    int height = params[1];
                    Direction d = Direction.values()[params[2]];
                    Shape graph = new RightTriangle(loc, pattern, params[0], params[1], d);

                    grids = graph.grids;
                    shapes.add(graph);
                }

                if (params.length == 1) {
                    Shape graph = new Circle(loc, pattern, params[0]);
                    if (y + 2*params[0] > canvas[0].length || x + 2*params[0] > canvas.length) {
                        return false;
                    }
                    grids = graph.grids;
                    shapes.add(graph);
                }

                //Find the grids.

                if(x+grids.length > canvas.length || y+grids[0].length > canvas[0].length) {
                    shapes.remove(count);
                    return false;
                } else{
                    for(int i=x; i<x+grids.length; i++){
                        for(int j=y; j<y+grids[0].length; j++){
                            if(grids[i-x][j-y] == pattern && canvas[i][j] != ' '){
                                shapes.remove(count);
                                return false;
                            }
                        }
                    }
                }
                for (int i = x; i < x + grids.length; i++) {
                    for (int j = y; j < y + grids[0].length; j++) {
                        if(grids[i-x][j-y] == pattern) {
                            canvas[i][j] = grids[i - x][j - y];
                        }
                    }
                }
                count++;
                return true;
            }

            //Fill the grids.
        }

        @Override
        public int getSpaceGridCount () {
            int cnt=0;

            for(int i = 0; i < canvas.length; i++) {
                for(int j = 0; j < canvas[0].length; j++) {
                    if(canvas[i][j] != ' ') {
                        cnt++;
                    }
                }
            }
            return cnt;
        }

        @Override
        public int getShapeCount () {
            return count;
        }

        @Override
        public List<Shape> getShapesByArea () {
            List<Shape> Rearrange = shapes;
            for (int i = 0; i < shapes.size(); i++) {
                for (int j = 0; j < shapes.size() - 1; j++) {
                    if (Rearrange.get(j).area() > Rearrange.get(j + 1).area() || (Rearrange.get(j).area() == Rearrange.get(j + 1).area() && Rearrange.get(j).pattern > Rearrange.get(j + 1).pattern)) {
                        Shape sto = Rearrange.get(j);
                        Rearrange.set(j, Rearrange.get(j + 1));
                        Rearrange.set(j + 1, sto);
                    }
                }
            }
            return Rearrange;
        }

        @Override
        public List<Shape> getShapesByLocation () {
            List<Shape> Rearrange = shapes;
            for (int i = 0; i < shapes.size(); i++) {
                for (int j = 0; j < shapes.size() - 1; j++) {
                    boolean judge1 = Rearrange.get(j).location.getX() > Rearrange.get(j + 1).location.getX();
                    boolean judge2 = (Rearrange.get(j).location.getX() == Rearrange.get(j + 1).location.getX() && Rearrange.get(j).location.getY() > Rearrange.get(j + 1).location.getY());
                    boolean judge3 = (Rearrange.get(j).location.getX() == Rearrange.get(j + 1).location.getX() && Rearrange.get(j).location.getY() == Rearrange.get(j + 1).location.getY() && Rearrange.get(j).pattern > Rearrange.get(j + 1).pattern);
                    if ((judge1) || (judge2) || (judge3)) {
                        Shape sto = Rearrange.get(j);
                        Rearrange.set(j, Rearrange.get(j + 1));
                        Rearrange.set(j + 1, sto);
                    }
                }
            }
            return Rearrange;
        }

        @Override
        public char[][] getCanvas () {
            return canvas;
        }
    }
import java.util.ArrayList;
import java.util.List;

public class OverLapShapeCanvas implements ShapeCanvas {
    private List<Shape> shapes;

    private char[][] canvas;

    public OverLapShapeCanvas(int rows, int cols) {
        this.canvas = new char[rows][cols];
        for (int i = 0; i < canvas.length; i++) {
            for (int j = 0; j < canvas[i].length; j++) {
                this.getCanvas()[i][j] = ' ';
            }
        }
        shapes = new ArrayList<>();
    }

    @Override
    public boolean addShape(int x, int y, char pattern, int... params) {
        Character[][] shapeC = swichToCharacter(getCanvas());
        switch (params.length) {
            case 1:
                Location location1 = new Location(x, y);
                Circle circle = new Circle(location1, pattern, params[0]);
                circle.fillGrids();
                if (ifConflict( location1.getX(), location1.getY(),circle.getGrids() )) {
                    for (int i = 0; i < circle.getGrids().length; i++) {
                        for (int j = 0; j < circle.getGrids()[i].length; j++) {
                            if (i+x<getCanvas().length&&j+y<getCanvas()[0].length){
                                if (circle.getGrids()[i][j]!=' ') {
                                    getCanvas()[x + i][y + j] = pattern;
                                }
                            }
                        }
                    }
                }else {
                    return false;
                }
                getShapes().add(circle);
                return true;
            case 3:
                Location location2 = new Location(x, y);
                Direction d = Direction.LEFT_UP;
                switch (params[2]) {
                    case 0:
                        d = Direction.LEFT_UP;
                        break;
                    case 1:
                        d = Direction.LEFT_DOWN;
                        break;
                    case 2:
                        d = Direction.RIGHT_UP;
                        break;
                    case 3:
                        d = Direction.RIGHT_DOWN;
                        break;
                }
                RightTriangle rightTriangle = new RightTriangle(location2, pattern, params[0], params[1], d);
                if (ifConflict( location2.getX(), location2.getY(),rightTriangle.getGrids() )) {
                    for (int i = 0; i < rightTriangle.getGrids().length; i++) {
                        for (int j = 0; j < rightTriangle.getGrids()[i].length; j++) {
                            if (rightTriangle.getGrids()[i][j]!=' ') {
                                if (i+x<getCanvas().length&&j+y<getCanvas()[0].length){
                                    if (rightTriangle.getGrids()[i][j]!=' ') {
                                        getCanvas()[x + i][y + j] = pattern;
                                    }
                                }
                            }

                        }
                    }
                }else {
                    return false;
                }
                getShapes().add(rightTriangle);
                return true;
            default:
                return false;
        }
    }

    @Override
    public int getSpaceGridCount() {
        int bankSpace = 0;
        for (int i = 0; i < canvas[0].length; i++) {
            for (int j = 0; j < canvas.length; j++) {
                if (canvas[i][j] == ' ') {
                    bankSpace++;
                }
            }
        }
        return bankSpace;
    }

    @Override
    public int getShapeCount() {
        return getShapes().size();
    }

    @Override
    public List<Shape> getShapesByArea() {
        int l = getShapes().size();
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (getShapes().get(j).area() > getShapes().get(j + 1).area()) {
                    Shape temp = getShapes().get(j);
                    getShapes().set(j, getShapes().get(j + 1));
                    getShapes().set(j + 1, temp);
                } else if (getShapes().get(j).area() == getShapes().get(j + 1).area()
                        &&getShapes().get(j).pattern > getShapes().get(j + 1).pattern) {
                    Shape temp = getShapes().get(j);
                    getShapes().set(j, getShapes().get(j + 1));
                    getShapes().set(j + 1, temp);
                }
            }
        }
        return getShapes();
    }

    @Override
    public List<Shape> getShapesByLocation() {
        int l = getShapes().size();
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (getShapes().get(j).location.getX() > getShapes().get(j + 1).location.getX()) {
                    Shape temp = getShapes().get(j);
                    getShapes().set(j, getShapes().get(j + 1));
                    getShapes().set(j + 1, temp);
                } else if (getShapes().get(j).location.getX() == getShapes().get(j + 1).location.getX()
                        &&getShapes().get(j).location.getY() > getShapes().get(j + 1).location.getY()) {
                    Shape temp = getShapes().get(j);
                    getShapes().set(j, getShapes().get(j + 1));
                    getShapes().set(j + 1, temp);
                } else if (getShapes().get(j).location.getX() == getShapes().get(j + 1).location.getX()
                        &&getShapes().get(j).location.getY() == getShapes().get(j + 1).location.getY()
                        &&getShapes().get(j).pattern > getShapes().get(j + 1).pattern) {
                    Shape temp = getShapes().get(j);
                    getShapes().set(j, getShapes().get(j + 1));
                    getShapes().set(j + 1, temp);
                }
            }
        }
        return getShapes();
    }

    @Override
    public char[][] getCanvas() {
        return canvas;
    }

    public List<Shape> getShapes() {
        return shapes;
    }


    public Character[][] swichToCharacter(char[][] shapes){
        Character[][] shapeC = new Character[getCanvas().length][getCanvas()[0].length];
        for (int i = 0; i < getCanvas().length; i++) {
            for (int j = 0; j < getCanvas()[i].length; j++) {
                shapeC[i][j]=getCanvas()[i][j];
            }
        }
        return shapeC;
    }
    public boolean ifConflict(int x,int y, char[][] grids){
        Character[][] shapeC = swichToCharacter(getCanvas());
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j]!=' ') {
                    if (i+x<getCanvas().length&&j+y<getCanvas()[0].length){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public String toString(){
        String str = "";
        for (int i = 0; i < getShapes().size(); i++) {
            str += getShapes().get(i);
            if (i+1<getShapes().size()){
                str+=", ";
            }
        }
        return str;
    }

}

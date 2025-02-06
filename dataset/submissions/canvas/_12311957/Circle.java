public class Circle extends Shape{
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = (radius>0)?radius:0;
    }

    public Circle(Location location, char pattern, int radius){
        super(location,pattern);
        setRadius(radius);
        fillGrids();
    }
    @Override
    public void fillGrids(){
        setGrids(new char[getRadius()*2][getRadius()*2]);
        for (int i = 0; i < getRadius()*2; i++) {
            for (int j = 0; j < getRadius()*2; j++) {
                grids[i][j] = '\u0020';
            }
        }

        for (int i = 1; i < getRadius()+1; i++) {
            for (int j = 1; j < getRadius()+1; j++) {
                if(((i-getRadius())*(i-getRadius()) + (j-getRadius())*(j-getRadius())) < ( (getRadius())*(getRadius()))){
                    grids[i-1][j-1] = getPattern();
                }
            }
        }

        for (int i = 0; i < getRadius(); i++) {
            for (int j = getRadius(); j < getRadius()*2; j++) {
                if(grids[i][getRadius()*2-j-1] == getPattern()){
                    grids[i][j] = getPattern();
                }
            }
        }

        for (int i = getRadius(); i < getRadius()*2; i++) {
            for (int j = 0; j < getRadius()*2; j++) {
                if(grids[getRadius()*2-i-1][j] == getPattern()){
                    grids[i][j] = getPattern();
                }
            }
        }

    }

    @Override
    public void enlarge() {
        setRadius(getRadius()+1);
        fillGrids();
    }

    @Override
    public void shrink() {
        setRadius((getRadius() == 0)?0:getRadius()-1);
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < getRadius(); i++) {
            for (int j = 0; j < getRadius(); j++) {
                if(grids[i][j] == getPattern()){
                    count++;
                }
            }
        }
        return 4*count;
    }

    @Override
    public String toString() {
        return String.format("Circle: %s area=%d pattern=%c",getLocation(),area(),getPattern());
    }
}

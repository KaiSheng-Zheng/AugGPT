public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = (width>0)?width:0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = (height>0)?height:0;
    }

    public Direction getD() {
        return d;
    }

    public RightTriangle(Location location, char pattern, int width, int height, Direction d){
        super(location,pattern);
        setWidth(width);
        setHeight(height);
        this.d = d;
        fillGrids();
    }
    @Override
    public void fillGrids(){
        setGrids(new char[getHeight()][getWidth()]);
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                grids[i][j] = '\u0020';
            }
        }
        double slope = (double)getHeight()/getWidth();

        if(getD().equals(Direction.LEFT_DOWN)){
            for (int i = 0; i < getHeight(); i++) {
                grids[i][0] = getPattern();
            }
            for (int i = 1; i < getHeight()+1; i++) {
                for (int j = 1; j < getWidth()+1; j++) {
                    if((((double)i/(double)j)>slope)){
                        grids[i-1][j] = getPattern();
                    }
                }
            }
        }
        else if(getD().equals(Direction.LEFT_UP)){
            for (int i = 0; i < getHeight(); i++) {
                grids[i][0] = getPattern();
            }
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 1; j < getWidth(); j++) {
                    if(((double)(getHeight()-i)/(double)j) > slope){
                        grids[i][j] = getPattern();
                    }
                }
            }
        }
        else if(getD().equals(Direction.RIGHT_DOWN)){
            for (int i = 1; i < getHeight()+1; i++) {
                for (int j = 1; j < getWidth()+1; j++) {
                    if(((double)(getHeight()-i)/(double)j) < slope){
                        grids[i-1][j-1] = getPattern();
                    }
                }
            }
        }
        else{
            for (int i = 0; i < getHeight(); i++) {
                grids[i][getWidth()-1] = getPattern();
            }
            for (int i = 0; i < getHeight(); i++) {
                for (int j = 1; j < getWidth(); j++) {
                    if(((double)(getHeight()-i)/(double)(getWidth()-j)) > slope){
                        grids[i][j-1] = getPattern();
                    }
                }
            }
        }
    }

    @Override
    public void enlarge(){
        setHeight(getHeight()+1);
        setWidth(getWidth()+1);
        fillGrids();
    }

    @Override
    public void shrink() {
        setHeight((getHeight() == 0)?0:getHeight()-1);
        setWidth((getWidth() == 0)?0:getWidth()-1);
        fillGrids();
    }

    @Override
    public int area() {
        int count = 0;
        for (int i = 0; i < getHeight(); i++) {
            for (int j = 0; j < getWidth(); j++) {
                if(grids[i][j] == getPattern()){
                    count++;
                }
            }
        }
        return count;
    }

    public String toString(){
        return String.format("RightTriangle: %s area=%d pattern=%c",getLocation(),area(),getPattern());
    }
}

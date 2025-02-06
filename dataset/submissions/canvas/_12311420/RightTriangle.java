
public class RightTriangle extends Shape {
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    public void fillGrids() {
        grids = new char[height][width];
        double k = (double) height / (double) width;
        switch (d) {
            case LEFT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 1; j < width; j++) {
                        if (j * k < i + 1)
                            grids[i][j] = pattern;
                        else
                            grids[i][j] = ' ';
                    }
                }
                for (int i = 0; i < height; i++) {
                    grids[i][0]=pattern;
                }
                break;
            case LEFT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 1; j < width; j++) {
                        if (height - j * k > i)
                            grids[i][j] = pattern;
                        else
                            grids[i][j] = ' ';
                    }
                }
                for (int i = 0; i < height; i++) {
                    grids[i][0]=pattern;
                }
                break;
            case RIGHT_DOWN:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width - 1; j++) {
                        if (height - (j + 1) * k < i + 1)
                            grids[i][j] = pattern;
                        else
                            grids[i][j] = ' ';
                    }
                }
                for (int i = 0; i < height; i++) {
                    grids[i][width-1]=pattern;
                }
                break;
            case RIGHT_UP:
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width - 1; j++) {
                        if ((j + 1) * k > i)
                            grids[i][j] = pattern;
                        else
                            grids[i][j] = ' ';
                    }
                }
                for (int i = 0; i < height; i++) {
                    grids[i][width-1]=pattern;
                }
                break;
        }
    }
    public void enlarge(){
        width+=1;
        height+=1;
        grids=new char[height][width];
        fillGrids();
    }
    public void shrink(){
        width-=1;
        height-=1;
        grids=new char[height][width];
        fillGrids();
    }
    public int area(){
        int counter=0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grids[i][j]==pattern)
                    counter++;
            }
        }
        return counter;
    }
    public String toString(){
        return "RightTriangle: "+this.location.toString()+" area="+this.area()+" pattern="+pattern;
    }

    @Override
    public int compare(Shape o1, Shape o2) {
        Location loc1 = o1.getLocation();
        Location loc2 = o2.getLocation();
        int compareX = Integer.compare(loc1.getX(), loc2.getX());
        int compareY=Integer.compare(loc1.getY(),loc2.getY());
        int comparePattern=Character.compare(o1.pattern,o2.pattern);
        if (compareX != 0) {
            return compareX;
        } else if (compareY!=0){
            return compareY;
        }
        else
            return comparePattern;
    }
}

public class RightTriangle extends Shape {
    private final Direction d;

    private int width;
    private int height;

    public RightTriangle(Location location, char pattern, int width,
                         int height, Direction d){
        super(location,pattern);
        this.width=width;
        this.height=height;
        this.d=d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[height][width];
        double k = (double) height / width;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((double) (i+1) / (j) > k) {
                    grids[i][j] = pattern;
                }
            }
        }
        if (d == Direction.RIGHT_DOWN) {
            char[][] temp = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(grids[i][j]==pattern){
                       temp[i][width-1-j]=pattern;
                    }
                }
            }
            grids=temp;
        }
        if (d == Direction.LEFT_UP) {
            char[][] temp = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(grids[i][j]==pattern){
                        temp[height-1-i][j]=pattern;
                    }
                }
            }
            grids=temp;
        }
        if (d == Direction.RIGHT_UP) {
            char[][] temp = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if(grids[i][j]==pattern){
                        temp[height-1-i][width-1-j]=pattern;
                    }
                }
            }
            grids=temp;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(grids[i][j]!=pattern){
                    grids[i][j]=' ';
                }
            }
        }
    }

    public void enlarge(){
        this.height++;
        this.width++;
        fillGrids();
        area();
    }
    public void shrink(){
        this.height--;
        this.width--;
        fillGrids();
        area();
    }
    public int area(){
        int out = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(this.grids[i][j]==this.pattern){
                    out++;
                }
            }
        }
        return out;
    }
    public String toString(){
        String S = "RightTriangle: "+"("+location.getX()+
                ","+location.getY()+") area="+area()+
                " pattern="+super.pattern;
        return S;
    }
    public char getPattern(){
        return pattern;
    }
}

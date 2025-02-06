public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle( Location location,char pattern, int width, int height, Direction d) {
        super(location,pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }


    @Override
    public void fillGrids() {
        char [][] chars=new char[height][width];
        if (d.equals(Direction.LEFT_DOWN)) {
            for (int y = 0; y < height; y++) {
                int a =width -(width * (height - y-1)) /height ;
                for (int i = 0; i < a; i++) {
                    chars[y][i] = pattern;
                }
                for (int n = a ; n < width; n++) {
                    chars[y][n] = ' ';
                }
            }
        }
        if (d.equals(Direction.LEFT_UP)){
            for (int y = 0; y < height; y++) {
                int a =width-(y*width)/height ;
                for (int i = 0; i < a; i++) {
                    chars[y][i] = pattern;
                }
                for (int n = a ; n < width; n++) {
                    chars[y][n] = ' ';
                }
            }
        }
        if (d.equals(Direction.RIGHT_UP)) {
            for (int y = 0; y < width; y++) {
                int a =height -(height * (width - y-1)) /width ;
                for (int i = 0; i < a; i++) {
                    chars[i][y] = pattern;
                }
                for (int n = a ; n < height; n++) {
                    chars[n][y] = ' ';
                }
            }
        }
        if (d.equals(Direction.RIGHT_DOWN)) {
            for (int y = 0; y < height; y++) {
                int a =width-(y*width)/height;
                for (int i = 0; i < a; i++) {
                    chars[height-y-1][width-i-1] = pattern;
                }
                for (int n = a ; n < width; n++) {
                    chars[height-y-1][width-n-1] = ' ';
                }
            }
        }
        setGrids(chars);
    }

    @Override
    public void enlarge() {
        width++;
        height++;
        fillGrids();
    }

    @Override
    public void shrink() {
        width--;
        height--;
        fillGrids();
    }

    @Override
    public int area() {
        int k=0;
        if (d.equals(Direction.LEFT_DOWN)) {
            for (int y = 0; y < height; y++) {
                int a =width -(width * (height - y-1)) /height ;
                for (int i = 0; i < a; i++) {
                   k++;
                }
            }
        }
        if (d.equals(Direction.RIGHT_UP)) {
            for (int y = 0; y < width; y++) {
                int a =height -(height * (width - y-1)) /width ;
                for (int i = 0; i < a; i++) {
                   k++;
                }
            }
        }
        if (d.equals(Direction.LEFT_UP)){
            for (int y = 0; y < height; y++) {
                int a =width-(y*width)/height ;
                for (int i = 0; i < a; i++) {
                    k++;
                }
            }
        }
        if (d.equals(Direction.RIGHT_DOWN)) {
            for (int y = 0; y < height; y++) {
                int a =width-(y*width)/height;
                for (int i = 0; i < a; i++) {
                   k++;
                }
            }
        }
        return k;
    }
    public  String toString(){
        return String.format("RightTriangle: "+location.toString()+" area=" +area()+" pattern="+pattern);
    }
}

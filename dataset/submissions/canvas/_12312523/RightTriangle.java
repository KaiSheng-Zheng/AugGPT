import java.math.BigDecimal;
import java.math.RoundingMode;

public class RightTriangle extends Shape{
    private int width;
    private int height;
    private final Direction d;

    public RightTriangle(Location location, char pattern, int width, int height, Direction d) {
        super(location, pattern);
        this.width = width;
        this.height = height;
        this.d = d;
        super.className = "RightTriangle";
        this.fillGrids();
        super.area = this.area();
    }

    public void fillGrids() {
        char[][] grids = new char[height][width];
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if(ifIn(i, j)) {
                    grids[i][j] = pattern;
                } else {
                    grids[i][j] = ' ';
                }
            }
        }
        super.grids = grids;
    }

    public boolean ifIn(int i, int j) {
        boolean tf;
        BigDecimal X = new BigDecimal(height);
        BigDecimal Y = new BigDecimal(width);
        BigDecimal K = Y.divide(X, 20, RoundingMode.HALF_EVEN);
        BigDecimal I = new BigDecimal(i);
        BigDecimal N = new BigDecimal(i + 1);
        BigDecimal Lower;
        BigDecimal Upper;
        double lower;
        double upper;
        double boundU;
        double boundL;
        if(d.equals(Direction.LEFT_DOWN) || d.equals(Direction.RIGHT_UP)) {
            Lower = I.multiply(K);
            lower = Lower.doubleValue();
            boundL = Math.floor(lower);
            Upper = N.multiply(K);
            upper = Upper.doubleValue();
            boundU = Math.ceil(upper);
            upper = Upper.doubleValue();
        } else {
            BigDecimal F = new BigDecimal(-1);
            Upper = I.multiply(K).multiply(F).add(Y);
            upper = Upper.doubleValue();
            boundU = Math.ceil(upper);
            Lower = N.multiply(K).multiply(F).add(Y);
            lower = Lower.doubleValue();
            boundL = Math.floor(lower);
        }
        if(d.equals(Direction.LEFT_DOWN) || d.equals(Direction.LEFT_UP)) {
            tf = j < boundU;
        } else {
            tf = j >= boundL;
        }
        return tf;
    }

    public int area() {
        int a = 0;
        for (int i = 0; i < grids.length; i++) {
            for (int j = 0; j < grids[0].length; j++) {
                if(ifIn(i, j)) {
                    a++;
                }
            }
        }
        return a;
    }

    public void enlarge() {
        this.width++;
        this.height++;
        RightTriangle target = new RightTriangle(this.location, this.pattern, this.width, this.height, this.d);
        this.grids = target.getGrids();
        this.area = target.area;
    }

    public void shrink() {
        this.width--;
        this.height--;
        RightTriangle target = new RightTriangle(this.location, this.pattern, this.width, this.height, this.d);
        this.grids = target.getGrids();
        this.area = target.area;
    }
}

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RightTriangle  extends Shape{

    private int width;

    private int height;

    private int area = 0;

    private final Direction d;
    public RightTriangle(Location location, char pattern, int width, int height,Direction d) {
        super(pattern, location);
        this.width = width;
        this.height = height;
        this.d = d;
        fillGrids();
    }

    @Override
    public void fillGrids() {
        this.grids = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                double value = 0;
                if(d == Direction.LEFT_UP){
                    value = new BigDecimal((height-i)*width).divide(new BigDecimal(height),2, RoundingMode.HALF_UP).doubleValue();
                }else if(d == Direction.RIGHT_DOWN){
                    value = new BigDecimal((height-i-1)*width).divide(new BigDecimal(height),2, RoundingMode.HALF_UP).doubleValue();
                }else if( d == Direction.RIGHT_UP) {
                    value = new BigDecimal(width*(height-i)).divide(new BigDecimal(height),2, RoundingMode.HALF_UP).doubleValue();
                }else if(d == Direction.LEFT_DOWN){
                    value = new BigDecimal(width*(i+1)).divide(new BigDecimal(height),2, RoundingMode.HALF_UP).doubleValue();
                }

                if((d == Direction.LEFT_DOWN && j<value)||
                        (d==Direction.RIGHT_UP && width-1-j<value)||
                        (d==Direction.RIGHT_DOWN&& j+1>value)||
                        (d==Direction.LEFT_UP && j<value)
                ){
                    grids[i][j] = pattern;
                    area++;
                }else{
                    grids[i][j] = ' ';
                }
            }
        }
    }

    @Override
    public void enlarge() {
        this.width = width+1;
        this.height = height+1;
        this.area = 0;
        fillGrids();
    }

    @Override
    public void shrink() {
        this.width = width-1;
        this.height = height-1;
        this.area = 0;
        fillGrids();
    }

    @Override
    public int area() {
        return this.area;
    }

    @Override
    public String toString() {
        return "RightTriangle: "+location.toString()+" area="+area+" pattern="+pattern;
    }
}

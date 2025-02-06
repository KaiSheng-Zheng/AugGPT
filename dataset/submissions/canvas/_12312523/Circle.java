import java.math.BigDecimal;

public class Circle extends Shape{
    private int radius;

    public Circle(Location location, char pattern, int radius) {
        super(location, pattern);
        this.radius = radius;
        super.className = "Circle";
        this.fillGrids();
        super.area = this.area();
    }
    public boolean ifIn(int i, int j) {
        Boolean tf = false;
        BigDecimal R = new BigDecimal(this.radius);
        BigDecimal Rs = R.multiply(R);
        BigDecimal I = new BigDecimal(i);
        BigDecimal J = new BigDecimal(j);
        BigDecimal Ox;
        BigDecimal Oy;
        if(i < radius && j < radius) {
            Ox = new BigDecimal(radius - 1);
            Oy = new BigDecimal(radius - 1);
        } else if (i >= radius && j < radius) {
            Ox = new BigDecimal(radius);
            Oy = new BigDecimal(radius - 1);
        } else if (i < radius && j >= radius) {
            Ox = new BigDecimal(radius - 1);
            Oy = new BigDecimal(radius);
        } else {
            Ox = new BigDecimal(radius);
            Oy = new BigDecimal(radius);
        }
        BigDecimal Dx = I.subtract(Ox);
        BigDecimal Dy = J.subtract(Oy);
        BigDecimal Ds = Dx.multiply(Dx).add(Dy.multiply(Dy));
        if(Ds.compareTo(Rs) < 0) {
            tf = true;
        }
        return tf;
    }

    public void fillGrids() {
        char[][] grids = new char[radius * 2][radius * 2];
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
        this.radius++;
        Circle target = new Circle(this.location, this.pattern, this.radius);
        this.grids = target.getGrids();
        this.area = target.area;
    }

    public void shrink() {
        this.radius--;
        Circle target = new Circle(this.location, this.pattern, this.radius);
        this.grids = target.getGrids();
        this.area = target.area;
    }

}

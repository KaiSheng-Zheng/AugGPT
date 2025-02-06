
public class ChessboardPoint {
    private int x;
    private int y;

    public ChessboardPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        String str = "(" + x + "," + y + ")";
        return str;
    }

    public ChessboardPoint offset(int dx, int dy) {
        ChessboardPoint newCbP = new ChessboardPoint(this.x + dx, this.y + dy);
        if ((0 <= newCbP.getX() && newCbP.getX() <= 7) && (0 <= newCbP.getY() && newCbP.getY() <= 7)) {
            return newCbP;
        } else {
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessboardPoint that = (ChessboardPoint) o;
        return x == that.x && y == that.y;
    }


}
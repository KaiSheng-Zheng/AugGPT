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
        return String.format("(%d,%d)",x ,y);
    }


    public ChessboardPoint offset(int dx, int dy) {
        boolean xValidity = x + dx <= 7 && x + dx >= 0;
        boolean yValidity = y + dy <= 7 && y + dy >= 0;
        if (xValidity && yValidity) {
            return new ChessboardPoint(x + dx, y + dy);
        } else {
            return null;
        }
    }
}

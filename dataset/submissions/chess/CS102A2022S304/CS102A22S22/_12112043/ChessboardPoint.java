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
        return "(" + this.getX() + "," + this.getY() + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int x1 = this.getX() + dx;
        int y1 = this.getY() + dy;
        ChessboardPoint destination = new ChessboardPoint(x1, y1);
        if (x1 > 0 && y1 > 0 && x1 < 8 && y1 < 8) {
            return destination;
        } else {
            return null;
        }
    }
}

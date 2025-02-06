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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        int x0 = x + dx;
        int y0 = y + dy;
        if (x0<=7 && x0>=0 && y0<=7 && y0>=0) {
            return new ChessboardPoint(x0,y0);
        }
        else {
            return null;
        }
    }
}
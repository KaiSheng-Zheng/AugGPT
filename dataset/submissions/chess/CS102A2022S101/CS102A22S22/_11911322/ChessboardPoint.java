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
        return String.format("(%d,%d)",this.x,this.y);
    }

    public ChessboardPoint offset(int dx, int dy) {
        int x = this.x + dx;
        int y = this.y + dy;
        boolean isOutOfBoard = false;
        if (x < 0 || x > 7) isOutOfBoard = true;
        if (y < 0 || y > 7) isOutOfBoard = true;
        if (isOutOfBoard) {
            return null;
        } else {
            return new ChessboardPoint(x,y);
        }
    }
}

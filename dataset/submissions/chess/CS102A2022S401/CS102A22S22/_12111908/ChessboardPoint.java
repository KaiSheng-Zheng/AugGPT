public class ChessboardPoint {
    private int x;
    private int y;

    /**
     * should design
     * @param x
     * @param y
     */
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
        return String.format("(%d,%d)",getX(),getY());
    }

    public ChessboardPoint offset(int dx, int dy) {
        if(dx + x >= 0 && dx + x <= 7 && dy + y >= 0 && dy + y <= 7) return new ChessboardPoint(x+dx,y+dy);
        else return null;
    }
}

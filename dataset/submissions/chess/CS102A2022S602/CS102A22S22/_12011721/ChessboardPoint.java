public class ChessboardPoint {
    private int x; // x: Horizontal location of this chess
    private int y; // y: Vertical location of this chess

    public ChessboardPoint(int x, int y)
    {
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
        return "(" + x + ',' + y + ')' ;
    }

    public ChessboardPoint offset(int dx, int dy)
    {
        int x = this.x;
        int y = this.y;
        x += dx;
        y += dy;
        if(0 <= x && x <= 7 && 0 <= y && y <= 7);
        else return null;
        return new ChessboardPoint(x, y);
    }
}

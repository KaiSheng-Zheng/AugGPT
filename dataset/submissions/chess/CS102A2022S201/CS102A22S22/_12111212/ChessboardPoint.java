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
        return String.format("(%d,%d)",x,y);
    }

    public boolean equals(Object o){
        if (o == null){
            return true;
        }
        ChessboardPoint obj = (ChessboardPoint) o;
        return getX() == ((ChessboardPoint) o).x && getY() == ((ChessboardPoint) o).y;
    }
    
    public ChessboardPoint offset(int dx, int dy) {
        int X = x + dx;
        int Y = y + dy;
        if (X >= 0 && X <= 7 && Y >= 0 && Y <= 7){
            return new ChessboardPoint(X, Y);
        }
        else
            return null;
    }
}
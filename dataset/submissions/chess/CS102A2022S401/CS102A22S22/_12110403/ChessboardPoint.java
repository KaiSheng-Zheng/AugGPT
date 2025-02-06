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

    public String toString() {
        if (x < 0 && x > 7 && y < 0 && y > 7) {
            return null;
        } else {
            return "(" + x + "," + y + ")";
        }
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (x + dx < 0 || x + dx > 7 || y + dy < 0 || y + dy > 7) {
            return null;
        }else{
            return new ChessboardPoint(x +dx,y +dy);
        }
    }
    @Override
    public boolean equals(Object o){
        ChessboardPoint cp = (ChessboardPoint) o;
        return cp.getX() == x && cp.getY() == y;
    }
}
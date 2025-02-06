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
        return "(" + x + "," + y + ")";
    }

    public ChessboardPoint offset(int dx, int dy) {
        if (getX()+dx>=0&&getX()+dx<8&&getY()+dy>=0&&getY()+dy<8) {
            return new ChessboardPoint(getX()+dx,getY()+dy);
        }else{
            return null;
        }
    }

    public boolean canMoveTo(int i, int i1) {
        return true;
    }
}
